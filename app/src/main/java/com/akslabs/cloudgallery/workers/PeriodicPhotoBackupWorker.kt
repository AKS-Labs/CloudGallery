package com.akslabs.cloudgallery.workers

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
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
import com.akslabs.cloudgallery.data.localdb.entities.Photo
import com.akslabs.cloudgallery.data.localdb.entities.UploadQueue
import com.akslabs.cloudgallery.utils.ContentHasher
import com.akslabs.cloudgallery.utils.generatePreview
import com.akslabs.cloudgallery.utils.getExtFromMimeType
import com.akslabs.cloudgallery.utils.getFileName
import com.akslabs.cloudgallery.utils.getBucketNamesForIds
import com.akslabs.cloudgallery.utils.getMimeTypeFromUri
import com.akslabs.cloudgallery.utils.isSyncImagePreviewEnabled
import com.akslabs.cloudgallery.utils.sendFileApi
import com.akslabs.cloudgallery.utils.uploadPreviewFile
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.IOException
import kotlin.math.min
import kotlin.math.roundToInt

class PeriodicPhotoBackupWorker(
    private val appContext: Context,
    private val params: WorkerParameters,
) : CoroutineWorker(appContext, params) {

    private val channelId: Long = Preferences.getEncryptedLong(Preferences.channelId, 0L)
    private val botApi: BotApi = BotApi

    override suspend fun doWork(): Result {
        val uploadType = params.inputData.getString(KEY_UPLOAD_TYPE)
        val deviceId = Preferences.getOrCreateDeviceId()
        val photoDao = DbHolder.database.photoDao()
        val remotePhotoDao = DbHolder.database.remotePhotoDao()
        val uploadQueueDao = DbHolder.database.uploadQueueDao()

        val allPending = photoDao.getAllPendingUpload()
        val excludedBucketNames = Preferences.getExcludedBucketNames()
        val pendingPhotos = if (excludedBucketNames.isEmpty()) {
            allPending
        } else {
            val ids = allPending.mapNotNull { it.pathUri.substringAfterLast("/").toLongOrNull() }
            val bucketNameMap = getBucketNamesForIds(appContext.contentResolver, ids)
            allPending.filter { photo ->
                val photoId = photo.pathUri.substringAfterLast("/")
                val bucketName = bucketNameMap[photoId]
                bucketName !in excludedBucketNames
            }
        }
        val imageList = pendingPhotos.take(MAX_BATCH_SIZE)

        return withContext(Dispatchers.IO) {
            try {
                Log.d("PeriodicBackup", "Found ${allPending.size} photos pending, processing batch of ${imageList.size} (deviceId=$deviceId)")

                setProgress(
                    workDataOf(
                        KEY_PROGRESS_CURRENT to 0,
                        KEY_PROGRESS_MAX to imageList.size,
                        KEY_CURRENT_FILE_URI to ""
                    )
                )

                var successCount = 0
                var failedCount = 0

                val parallelism = if (isSyncImagePreviewEnabled()) 1 else PARALLELISM
                val chunks = imageList.chunked(parallelism)
                for ((chunkIndex, chunk) in chunks.withIndex()) {
                    val results = coroutineScope {
                        chunk.mapIndexed { indexInChunk, photo ->
                            async(Dispatchers.IO) {
                                val globalIndex = chunkIndex * parallelism + indexInChunk
                                uploadSinglePhoto(
                                    photo = photo,
                                    index = globalIndex,
                                    total = imageList.size,
                                    deviceId = deviceId,
                                    photoDao = photoDao,
                                    remotePhotoDao = remotePhotoDao,
                                    uploadQueueDao = uploadQueueDao,
                                    uploadType = uploadType
                                )
                            }
                        }.awaitAll()
                    }

                    results.forEach { success ->
                        if (success) successCount++ else failedCount++
                    }

                    val processed = minOf((chunkIndex + 1) * parallelism, imageList.size)
                    setProgress(
                        workDataOf(
                            KEY_PROGRESS_CURRENT to processed,
                            KEY_PROGRESS_MAX to imageList.size,
                            KEY_CURRENT_FILE_URI to (chunk.lastOrNull()?.pathUri ?: "")
                        )
                    )

                    if (chunkIndex < chunks.size - 1) {
                        delay(DELAY_BETWEEN_CHUNKS_MS)
                    }
                }

                Log.d("PeriodicBackup", "Batch complete: $successCount succeeded, $failedCount failed")
                if (failedCount > imageList.size / 2) {
                    Result.retry()
                } else {
                    Result.success(workDataOf())
                }
            } catch (e: Exception) {
                Log.e("PeriodicBackup", "Backup failed, will retry: ${e.message}")
                Result.retry()
            }
        }
    }

    private suspend fun uploadSinglePhoto(
        photo: Photo,
        index: Int,
        total: Int,
        deviceId: String,
        photoDao: com.akslabs.cloudgallery.data.localdb.dao.PhotoDao,
        remotePhotoDao: com.akslabs.cloudgallery.data.localdb.dao.RemotePhotoDao,
        uploadQueueDao: com.akslabs.cloudgallery.data.localdb.dao.UploadQueueDao,
        uploadType: String?
    ): Boolean {
        return try {
            Log.d("PeriodicBackup", "Processing ${index + 1}/$total: ${photo.pathUri}")

            // 1. Re-check status (another worker may have uploaded it)
            val current = photoDao.getPhotoByLocalId(photo.localId) ?: return false
            if (current.uploadStatus == "DONE" || current.remoteId != null) {
                Log.d("PeriodicBackup", "Skipping ${photo.localId}: already uploaded")
                return true
            }

            // 2. Check upload queue for active entry from another worker
            val activeQueueEntry = uploadQueueDao.getActiveForPhoto(photo.localId)
            if (activeQueueEntry != null) {
                Log.d("PeriodicBackup", "Skipping ${photo.localId}: active queue entry exists")
                return true
            }

            // 3. Compute content hash if missing
            val hash = current.contentHash ?: ContentHasher.computeHash(appContext, current.pathUri.toUri())
            if (hash != null && current.contentHash == null) {
                photoDao.updateContentHash(current.localId, hash)
            }

            // 4. Content-based dedup: check if already uploaded (by any device)
            if (hash != null) {
                val existing = remotePhotoDao.getByContentHash(hash)
                if (existing != null) {
                    Log.d("PeriodicBackup", "Dedup: ${photo.localId} already in cloud (hash match)")
                    photoDao.updateRemoteIdForLocalId(current.localId, existing.remoteId)
                    photoDao.updateUploadStatus(current.localId, "DONE", System.currentTimeMillis())
                    return true
                }
            }

            // 5. Create queue entry
            val queueId = uploadQueueDao.insert(
                UploadQueue(
                    localId = current.localId,
                    pathUri = current.pathUri,
                    contentHash = hash,
                    workerType = "periodic",
                    deviceId = deviceId
                )
            )

            // 6. Mark uploading
            photoDao.updateUploadStatus(current.localId, "UPLOADING", System.currentTimeMillis())
            uploadQueueDao.markInProgress(queueId)

            val uri = photo.pathUri.toUri()
            var tempFile: File? = null

            var messageThreadId: Long? = null
            var topicName: String? = null
            try {
                val mimeType = getMimeTypeFromUri(appContext.contentResolver, uri)
                val ext = getExtFromMimeType(mimeType!!)
                val FIFTY_MB = 50L * 1024 * 1024

                // Stream to temp file instead of readBytes() — avoids OOM on large files
                tempFile = File.createTempFile("upload_${index}_", ".$ext")
                appContext.contentResolver.openInputStream(uri)?.use { input ->
                    tempFile!!.outputStream().use { output ->
                        input.copyTo(output, bufferSize = 8192)
                    }
                } ?: throw IOException("Cannot open input stream for $uri")

                val fileSize = tempFile!!.length()

                // Compress only if file > 50 MB
                if (fileSize > FIFTY_MB) {
                    val bytes = tempFile!!.readBytes()
                    val bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.size)
                    if (bitmap != null) {
                        val compressFormat = when (mimeType) {
                            MIME_TYPE_JPEG -> Bitmap.CompressFormat.JPEG
                            MIME_TYPE_PNG -> Bitmap.CompressFormat.PNG
                            MIME_TYPE_WEBP -> Bitmap.CompressFormat.WEBP
                            else -> Bitmap.CompressFormat.JPEG
                        }
                        var quality = 100
                        var outputBytes: ByteArray
                        do {
                            val outputStream = ByteArrayOutputStream()
                            outputStream.use {
                                bitmap.compress(compressFormat, quality, it)
                                outputBytes = it.toByteArray()
                            }
                            quality -= 5
                        } while (outputBytes.size > FIFTY_MB && quality > 0)
                        tempFile!!.writeBytes(outputBytes)
                    }
                }

                val fileName = getFileName(appContext.contentResolver, uri)

                // 7a. Determine folder/topic for forum organization
                try {
                    val bucketName = com.akslabs.cloudgallery.utils.getBucketName(appContext.contentResolver, uri)
                    if (bucketName != null && bucketName.isNotBlank()) {
                        topicName = bucketName
                        messageThreadId = botApi.topicCache[bucketName]
                        if (messageThreadId == null) {
                            messageThreadId = remotePhotoDao.getTopicIdByName(bucketName)
                            if (messageThreadId != null) {
                                botApi.topicCache[bucketName] = messageThreadId
                                Log.d("PeriodicBackup", "Loaded topic '$bucketName' from DB: id=$messageThreadId")
                            } else {
                                messageThreadId = botApi.createForumTopic(channelId, bucketName)
                                if (messageThreadId != null) {
                                    botApi.topicCache[bucketName] = messageThreadId
                                    Log.d("PeriodicBackup", "Created topic '$bucketName' with id=$messageThreadId")
                                }
                            }
                        }
                    }
                } catch (e: Exception) {
                    Log.w("PeriodicBackup", "Failed to create/get topic for ${photo.localId}, uploading to General", e)
                }

                // 7. Upload preview before original if enabled
                var previewId: String? = null
                var previewMessageId: Long? = null
                if (isSyncImagePreviewEnabled()) {
                    try {
                        val previewFile = generatePreview(appContext, uri)
                        if (previewFile != null) {
                            val result = uploadPreviewFile(botApi, channelId, previewFile, hash, messageThreadId, topicName)
                            previewId = result.first
                            previewMessageId = result.second
                            if (previewId != null) {
                                photoDao.updatePreviewRemoteId(current.localId, previewId)
                                Log.d("PeriodicBackup", "Preview uploaded: $previewId for ${photo.localId}")
                            }
                            previewFile.delete()
                        }
                    } catch (e: Throwable) {
                        Log.e("PeriodicBackup", "Preview upload failed for ${photo.localId}, continuing with original", e)
                    }
                }

                // 8. Upload original with hash, device metadata, and previewRemoteId
                val topicLabel = if (topicName != null) " topic='$topicName'($messageThreadId)" else " (General)"
                Log.d("PeriodicBackup", "Uploading ${photo.localId}$topicLabel (${tempFile!!.length()} bytes)")

                sendFileApi(botApi, channelId, uri, tempFile!!, ext!!, appContext, uploadType, fileName, hash, previewId, previewMessageId, messageThreadId, topicName)

                photoDao.updateUploadStatus(current.localId, "DONE", System.currentTimeMillis())
                uploadQueueDao.markDone(queueId)
                Log.d("PeriodicBackup", "Upload success: ${photo.localId}")
                true
            } catch (e: Exception) {
                Log.e("PeriodicBackup", "Upload failed for ${photo.localId}: ${e.message}" +
                    if (topicName != null) " (topic='$topicName')" else "")
                photoDao.updateUploadStatus(current.localId, "FAILED", System.currentTimeMillis())
                uploadQueueDao.markFailed(queueId, e.message)
                // Check retry count — if exceeded, permanently cancel to avoid infinite loop
                val updatedQueue = uploadQueueDao.getById(queueId)
                if (updatedQueue?.retryCount != null && updatedQueue.retryCount >= MAX_RETRIES) {
                    Log.e("PeriodicBackup", "Permanently cancelling ${photo.localId}: retries exhausted ($MAX_RETRIES)")
                    uploadQueueDao.markCancelled(queueId)
                }
                false
            } finally {
                tempFile?.delete()
            }
        } catch (e: Exception) {
            Log.e("PeriodicBackup", "Error in uploadSinglePhoto for ${photo.localId}: ${e.message}")
            false
        }
    }

    override suspend fun getForegroundInfo(): ForegroundInfo {
        return createForegroundInfo(
            appContext,
            WorkModule.NOTIFICATION_ID_BACKUP,
            appContext.getString(R.string.backing_up_photos)
        )
    }

    companion object {
        const val MIME_TYPE_JPEG = "image/jpeg"
        const val MIME_TYPE_PNG = "image/png"
        const val MIME_TYPE_WEBP = "image/webp"
        const val KEY_COMPRESSION_THRESHOLD = "KEY_COMPRESSION_THRESHOLD"
        const val KEY_RESULT_ERROR = "KEY_RESULT_ERROR"
        const val KEY_PROGRESS_CURRENT = "progress_current"
        const val KEY_PROGRESS_MAX = "progress_max"
        const val KEY_CURRENT_FILE_URI = "current_file_uri"
        const val KEY_UPLOAD_TYPE = "upload_type"
        const val KEY_TOTAL_DONE = "total_done"
        const val KEY_TOTAL_PHOTOS = "total_photos"
        const val MAX_BATCH_SIZE = 50
        const val PARALLELISM = 3
        const val DELAY_BETWEEN_CHUNKS_MS = 1500L
        const val MAX_RETRIES = 3
    }
}
