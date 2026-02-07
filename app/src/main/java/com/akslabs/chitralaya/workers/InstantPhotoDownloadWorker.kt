package com.akslabs.cloudgallery.workers

import android.content.ContentValues
import android.content.Context
import android.content.pm.ServiceInfo
import android.provider.MediaStore
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.ForegroundInfo
import androidx.work.WorkerParameters
import androidx.work.workDataOf
import com.akslabs.cloudgallery.R
import com.akslabs.cloudgallery.api.BotApi
import com.akslabs.cloudgallery.data.localdb.DbHolder
import com.akslabs.cloudgallery.data.localdb.entities.Photo
import com.akslabs.cloudgallery.utils.getMimeTypeFromExt
import com.akslabs.cloudgallery.utils.toastFromMainThread
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.ByteArrayInputStream

class InstantPhotoDownloadWorker(
    private val context: Context,
    params: WorkerParameters,
) : CoroutineWorker(context, params) {

    override suspend fun doWork(): Result {
        Log.d(TAG, "InstantPhotoDownloadWorker started!")
        val remoteId = inputData.getString(KEY_REMOTE_ID)
            ?: return Result.failure(workDataOf(KEY_RESULT_ERROR to "Remote ID not provided"))
        
        val forceDownload = inputData.getBoolean(KEY_FORCE_DOWNLOAD, false)
        Log.d(TAG, "Processing download for remoteId: $remoteId, forceDownload: $forceDownload")

        try {
            setForeground(getForegroundInfo())
        } catch (e: IllegalStateException) {
            Log.d(TAG, "doWork: ${e.localizedMessage}")
        }

        return withContext(Dispatchers.IO) {
            try {
                Log.d(TAG, "Getting remote photo from database for remoteId: $remoteId")
                // Get remote photo details from database
                val remotePhoto = DbHolder.database.remotePhotoDao().getById(remoteId)
                    ?: return@withContext Result.failure(workDataOf(KEY_RESULT_ERROR to "Remote photo not found"))
                
                Log.d(TAG, "Found remote photo: ${remotePhoto.remoteId}")
                
                // Check if photo already exists on device
                val existingPhoto = DbHolder.database.photoDao().getByRemoteId(remoteId)
                if (existingPhoto != null && !forceDownload) {
                    Log.d(TAG, "Photo already exists on device and forceDownload is false, skipping download")
                    return@withContext Result.success()
                }
                
                Log.d(TAG, "Starting download from Telegram for remoteId: $remoteId")
                // Download file from Telegram
                val byteArray = BotApi.getFile(remoteId)
                    ?: return@withContext Result.failure(workDataOf(KEY_RESULT_ERROR to "Failed to download file"))
                
                Log.d(TAG, "Downloaded ${byteArray.size} bytes")

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
                        getMimeTypeFromExt(remotePhoto.photoType) ?: "image/jpeg"
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
                ) ?: return@withContext Result.failure(workDataOf(KEY_RESULT_ERROR to "Failed to create file"))

                // Copy data to file
                resolver.openOutputStream(uri).use { outStream ->
                    inStream.copyTo(outStream!!)
                }

                // Insert photo into local database
                val photo = Photo(
                    localId = uri.lastPathSegment!!,
                    remoteId = remotePhoto.remoteId,
                    photoType = remotePhoto.photoType,
                    pathUri = uri.toString()
                )
                DbHolder.database.photoDao().insertPhotos(photo)
                
                Log.d(TAG, "Download completed successfully for remoteId: $remoteId")
                context.toastFromMainThread("Photo downloaded successfully!")
                Result.success()
            } catch (e: Exception) {
                Log.e(TAG, "Download failed: ${e.localizedMessage}", e)
                context.toastFromMainThread("Download failed: ${e.localizedMessage}")
                Result.failure(workDataOf(KEY_RESULT_ERROR to e.localizedMessage))
            }
        }
    }

    override suspend fun getForegroundInfo(): ForegroundInfo {
        return createForegroundInfo(
            context,
            WorkModule.NOTIFICATION_ID_DOWNLOAD,
            context.getString(R.string.downloading_photo)
        )
    }

    companion object {
        private const val TAG = "InstantPhotoDownloadWorker"
        const val KEY_REMOTE_ID = "KEY_REMOTE_ID"
        const val KEY_FORCE_DOWNLOAD = "KEY_FORCE_DOWNLOAD"
        const val KEY_RESULT_ERROR = "KEY_RESULT_ERROR"
    }
}