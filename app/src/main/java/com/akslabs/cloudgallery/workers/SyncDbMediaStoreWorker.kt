package com.akslabs.cloudgallery.workers

import android.content.ContentValues.TAG
import android.content.Context
import android.content.pm.ServiceInfo
import android.provider.MediaStore
import android.util.Log
import androidx.compose.ui.util.fastForEach
import androidx.work.CoroutineWorker
import androidx.work.ForegroundInfo
import androidx.work.WorkerParameters
import com.akslabs.cloudgallery.R
import com.akslabs.cloudgallery.data.localdb.DbHolder
import com.akslabs.cloudgallery.data.localdb.Preferences
import com.akslabs.cloudgallery.data.localdb.entities.Photo
import com.akslabs.cloudgallery.data.mediastore.getPhotoFromCursor
import com.akslabs.cloudgallery.utils.toastFromMainThread
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SyncDbMediaStoreWorker(
    private val context: Context,
    params: WorkerParameters,
) : CoroutineWorker(context, params) {

    override suspend fun doWork(): Result {
        return withContext(Dispatchers.Default) {
            try {
                val deviceId = Preferences.getOrCreateDeviceId()
                val resolver = context.contentResolver
                val collection = MediaStore.Images.Media.getContentUri(MediaStore.VOLUME_EXTERNAL)
                val projection = arrayOf(
                    MediaStore.Images.ImageColumns._ID,
                    MediaStore.Images.ImageColumns.MIME_TYPE
                )
                val cursor = resolver.query(
                    collection,
                    projection,
                    null,
                    null,
                    null
                )
                val photosOnDevice = mutableListOf<Photo>()
                cursor?.use {
                    while (cursor.moveToNext()) {
                        try {
                            val photo = cursor.getPhotoFromCursor()
                            // Set deviceId on new photos
                            photosOnDevice.add(photo.copy(deviceId = deviceId))
                        } catch (e: Exception) {
                            Log.d(TAG, "doWork: ${e.localizedMessage}")
                        }
                    }
                }
                DbHolder.database.photoDao().insertPhotos(*photosOnDevice.toTypedArray())
                val photosInDb = DbHolder.database.photoDao().getAll()
                // Only delete photos that are truly gone from device AND have no cloud backup
                // Photos with remoteId are cloud-linked — preserve them even if local URI changed
                val deletedPhotos = photosInDb.filter { photo ->
                    photosOnDevice.none { it.localId == photo.localId } && photo.remoteId == null
                }
                Log.d(TAG, "doWork: $deletedPhotos")
                deletedPhotos.fastForEach {
                    DbHolder.database.photoDao().deleteById(it.localId)
                }
                Log.d("Sync MediaStore", "doWork: Success (deviceId=$deviceId)")
                Result.success()
            } catch (e: Exception) {
                Log.d("Sync MediaStore", "doWork: ${e.localizedMessage}")
                context.toastFromMainThread(e.localizedMessage)
                Result.failure()
            }
        }
    }

    override suspend fun getForegroundInfo(): ForegroundInfo {
        return createForegroundInfo(
            context,
            WorkModule.NOTIFICATION_ID_SYNC,
            context.getString(R.string.syncing_all_photos)
        )
    }
}
