package com.akslabs.cloudgallery.workers

import android.content.Context
import android.content.pm.ServiceInfo
import android.util.Log
import androidx.core.net.toUri
import androidx.work.CoroutineWorker
import androidx.work.ForegroundInfo
import androidx.work.WorkerParameters
import androidx.work.workDataOf
import com.akslabs.cloudgallery.R
import com.akslabs.cloudgallery.api.BotApi
import com.akslabs.cloudgallery.data.localdb.DbHolder
import com.akslabs.cloudgallery.data.localdb.Preferences
import com.akslabs.cloudgallery.data.localdb.entities.UploadQueue
import com.akslabs.cloudgallery.utils.ContentHasher
import com.akslabs.cloudgallery.utils.generatePreview
import com.akslabs.cloudgallery.utils.isSyncImagePreviewEnabled
import com.akslabs.cloudgallery.utils.sendFileViaUri
import com.akslabs.cloudgallery.utils.uploadPreviewFile
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class InstantPhotoUploadWorker(
    private val appContext: Context,
    private val params: WorkerParameters,
) : CoroutineWorker(appContext, params) {

    private val channelId = Preferences.getEncryptedLong(Preferences.channelId, 0L)
    private val botApi = BotApi
    
    override suspend fun doWork(): Result {
        try {
            setForeground(getForegroundInfo())
        } catch (e: IllegalStateException) {
            Log.d("PhotoUpload", "FAILED: ${e.localizedMessage}")
            return Result.failure()
        }

        return withContext(Dispatchers.IO) {
            try {
                val deviceId = Preferences.getOrCreateDeviceId()
                val photoDao = DbHolder.database.photoDao()
                val remotePhotoDao = DbHolder.database.remotePhotoDao()
                val uploadQueueDao = DbHolder.database.uploadQueueDao()

                val photoUriString = params.inputData.getString(KEY_PHOTO_URI)!!
                val photoUri = photoUriString.toUri()
                val fileName = com.akslabs.cloudgallery.utils.getFileName(appContext.contentResolver, photoUri)
                val uploadType = params.inputData.getString(KEY_UPLOAD_TYPE) ?: "instant"

                // Find the photo in database by path URI
                val photo = photoDao.getAll().find { it.pathUri == photoUriString }

                if (photo != null) {
                    // 1. Check if already uploaded
                    if (photo.uploadStatus == "DONE" || photo.remoteId != null) {
                        Log.d("PhotoUpload", "Skipping: already uploaded (${photo.localId})")
                        return@withContext Result.success()
                    }

                    // 2. Check for active queue entry
                    val activeEntry = uploadQueueDao.getActiveForPhoto(photo.localId)
                    if (activeEntry != null) {
                        Log.d("PhotoUpload", "Skipping: active queue entry (${photo.localId})")
                        return@withContext Result.success()
                    }

                    // 3. Compute content hash
                    val hash = photo.contentHash ?: ContentHasher.computeHash(appContext, photoUri)
                    if (hash != null && photo.contentHash == null) {
                        photoDao.updateContentHash(photo.localId, hash)
                    }

                    // 4. Content-based dedup
                    if (hash != null) {
                        val existing = remotePhotoDao.getByContentHash(hash)
                        if (existing != null) {
                            Log.d("PhotoUpload", "Dedup: content already in cloud (hash match)")
                            photoDao.updateRemoteIdForLocalId(photo.localId, existing.remoteId)
                            photoDao.updateUploadStatus(photo.localId, "DONE", System.currentTimeMillis())
                            return@withContext Result.success()
                        }
                    }

                    // 5. Create queue entry and mark uploading
                    val queueId = uploadQueueDao.insert(UploadQueue(
                        localId = photo.localId,
                        pathUri = photo.pathUri,
                        contentHash = hash,
                        workerType = "instant",
                        deviceId = deviceId
                    ))
                    photoDao.updateUploadStatus(photo.localId, "UPLOADING", System.currentTimeMillis())
                    uploadQueueDao.markInProgress(queueId)

                    setProgress(
                        workDataOf(
                            "progress" to "started",
                            KEY_PHOTO_URI to photoUriString,
                            KEY_FILE_NAME to fileName,
                            KEY_UPLOAD_TYPE to uploadType
                        )
                    )

                    // 6. Upload preview before original if enabled
                    var previewId: String? = null
                    var previewMessageId: Long? = null
                    if (isSyncImagePreviewEnabled()) {
                        try {
                            val previewFile = generatePreview(appContext, photoUri)
                            if (previewFile != null) {
                                val result = uploadPreviewFile(botApi, channelId, previewFile, hash)
                                previewId = result.first
                                previewMessageId = result.second
                                if (previewId != null) {
                                    photoDao.updatePreviewRemoteId(photo.localId, previewId)
                                    Log.d("PhotoUpload", "Preview uploaded: $previewId for ${photo.localId}")
                                }
                                previewFile.delete()
                            }
                        } catch (e: Throwable) {
                            Log.e("PhotoUpload", "Preview upload failed for ${photo.localId}, continuing with original", e)
                        }
                    }

                    // 7. Upload original with hash
                    try {
                        sendFileViaUri(photoUri, appContext.contentResolver, channelId, botApi, appContext, uploadType, fileName, hash, previewId, previewMessageId)
                        photoDao.updateUploadStatus(photo.localId, "DONE", System.currentTimeMillis())
                        uploadQueueDao.markDone(queueId)
                    } catch (e: Exception) {
                        photoDao.updateUploadStatus(photo.localId, "FAILED", System.currentTimeMillis())
                        uploadQueueDao.markFailed(queueId, e.message)
                        throw e
                    }
                } else {
                    // Photo not in our database (e.g. direct share) — upload without dedup
                    setProgress(
                        workDataOf(
                            "progress" to "started",
                            KEY_PHOTO_URI to photoUriString,
                            KEY_FILE_NAME to fileName,
                            KEY_UPLOAD_TYPE to uploadType
                        )
                    )

                    val hash = ContentHasher.computeHash(appContext, photoUri)
                    sendFileViaUri(photoUri, appContext.contentResolver, channelId, botApi, appContext, uploadType, fileName, hash)
                }

                Result.success(workDataOf(
                    KEY_PHOTO_URI to photoUriString,
                    KEY_FILE_NAME to fileName,
                    KEY_UPLOAD_TYPE to uploadType
                ))
            } catch (e: Throwable) {
                Log.d("PhotoUpload", "FAILED, will retry: ${e.localizedMessage}")
                Result.retry()
            }
        }
    }

    override suspend fun getForegroundInfo(): ForegroundInfo {
        return createForegroundInfo(
            appContext,
            WorkModule.NOTIFICATION_ID_UPLOAD,
            appContext.getString(R.string.uploading_photo)
        )
    }

    companion object {
        const val KEY_PHOTO_URI = "photoUri"
        const val KEY_FILE_NAME = "fileName"
        const val KEY_UPLOAD_TYPE = "upload_type"
    }
}
