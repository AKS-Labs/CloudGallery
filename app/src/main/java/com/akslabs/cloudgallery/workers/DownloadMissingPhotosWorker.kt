package com.akslabs.cloudgallery.workers

import android.content.ContentValues
import android.content.Context
import android.content.pm.ServiceInfo
import android.provider.MediaStore
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.ForegroundInfo
import androidx.work.WorkerParameters
import com.akslabs.cloudgallery.R
import com.akslabs.cloudgallery.api.BotApi
import com.akslabs.cloudgallery.data.localdb.DbHolder
import com.akslabs.cloudgallery.data.localdb.entities.Photo
import com.akslabs.cloudgallery.data.localdb.entities.RemotePhoto
import com.akslabs.cloudgallery.utils.getMimeTypeFromExt
import com.akslabs.cloudgallery.utils.toastFromMainThread
import java.io.ByteArrayInputStream
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DownloadMissingPhotosWorker(
    private val context: Context,
    params: WorkerParameters,
) : CoroutineWorker(context, params) {
    override suspend fun doWork(): Result {
        try {
            setForeground(getForegroundInfo())
        } catch (e: IllegalStateException) {
            Log.d("DownloadMissingPhotosWorker", "doWork: ${e.localizedMessage}")
        }
        return withContext(Dispatchers.IO) {
            try {
                // Get all remote photos and filter for those not on device
                val allRemotePhotos = DbHolder.database.remotePhotoDao().getAll()
                val allLocalPhotos = DbHolder.database.photoDao().getAll()
                val localRemoteIds = allLocalPhotos.mapNotNull { it.remoteId }.toSet()

                val remotePhotosNotOnDevice = allRemotePhotos.filter { remotePhoto ->
                    remotePhoto.remoteId !in localRemoteIds
                }

                val photosToInsert = mutableListOf<Photo>()

                remotePhotosNotOnDevice.forEach { remotePhoto ->
                        val byteArray = BotApi.getFile(remotePhoto.remoteId)!!
                        val inStream = ByteArrayInputStream(byteArray)
                        val contentValues = ContentValues().apply {
                            put(
                                MediaStore.MediaColumns.DISPLAY_NAME,
                                context.getString(
                                    R.string.CloudGallery,
                                    remotePhoto.remoteId,
                                    remotePhoto.photoType
                                )
                            )
                            put(
                                MediaStore.MediaColumns.MIME_TYPE,
                                getMimeTypeFromExt(remotePhoto.photoType)!!
                            )
                            put(
                                MediaStore.MediaColumns.RELATIVE_PATH,
                                context.getString(R.string.download_CloudGallery)
                            )
                        }

                        val resolver = context.contentResolver

                        val uri = resolver.insert(
                            MediaStore.Downloads.EXTERNAL_CONTENT_URI,
                            contentValues
                        )
                        if (uri != null) {
                            inStream.use {
                                resolver.openOutputStream(uri).use { outStream ->
                                    inStream.copyTo(outStream!!)
                                }
                            }
                            photosToInsert.add(
                                Photo(
                                    localId = uri.lastPathSegment!!,
                                    remoteId = remotePhoto.remoteId,
                                    photoType = remotePhoto.photoType,
                                    pathUri = uri.toString()
                                )
                            )
                        }
                    }
                DbHolder.database.photoDao().insertPhotos(*photosToInsert.toTypedArray())
                Result.success()
            } catch (e: Exception) {
                Log.d("DownloadMissingPhotosWorker", "doWork: ${e.localizedMessage}")
                context.toastFromMainThread(e.localizedMessage)
                Result.failure()
            }
        }
    }

    override suspend fun getForegroundInfo(): ForegroundInfo {
        return createForegroundInfo(
            context,
            WorkModule.NOTIFICATION_ID_DOWNLOAD,
            context.getString(R.string.downloading_photos)
        )
    }
}
