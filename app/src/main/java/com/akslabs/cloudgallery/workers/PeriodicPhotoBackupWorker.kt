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
import com.akslabs.cloudgallery.utils.getExtFromMimeType
import com.akslabs.cloudgallery.utils.getMimeTypeFromUri
import com.akslabs.cloudgallery.utils.sendFileApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.IOException
import kotlin.math.roundToInt

class PeriodicPhotoBackupWorker(
    private val appContext: Context,
    private val params: WorkerParameters,
) : CoroutineWorker(appContext, params) {

    private val channelId: Long = Preferences.getEncryptedLong(Preferences.channelId, 0L)
    private val botApi: BotApi = BotApi

    override suspend fun doWork(): Result {
        val compressionThresholdInBytes = params.inputData.getLong(
            KEY_COMPRESSION_THRESHOLD,
            0L
        )
        val uploadType = params.inputData.getString(KEY_UPLOAD_TYPE)
        // Batch size limit: only process up to MAX_BATCH_SIZE photos per worker run
        val allNotUploaded = DbHolder.database.photoDao().getAllNotUploaded()
        val imageList = allNotUploaded.take(MAX_BATCH_SIZE)

        return withContext(Dispatchers.IO) {
            try {
                Log.d("PeriodicBackup", "Found ${allNotUploaded.size} photos not uploaded, processing batch of ${imageList.size}")

                // Initial progress
                setProgress(
                    workDataOf(
                        KEY_PROGRESS_CURRENT to 0,
                        KEY_PROGRESS_MAX to imageList.size,
                        KEY_CURRENT_FILE_URI to ""
                    )
                )

                var successCount = 0
                var failedCount = 0

                // Process in parallel chunks of PARALLELISM
                val chunks = imageList.chunked(PARALLELISM)
                for ((chunkIndex, chunk) in chunks.withIndex()) {
                    val results = coroutineScope {
                        chunk.mapIndexed { indexInChunk, photo ->
                            async(Dispatchers.IO) {
                                val globalIndex = chunkIndex * PARALLELISM + indexInChunk
                                uploadSinglePhoto(photo, globalIndex, imageList.size, uploadType)
                            }
                        }.awaitAll()
                    }

                    results.forEach { success ->
                        if (success) successCount++ else failedCount++
                    }

                    // Update progress after each parallel chunk
                    val processed = (chunkIndex + 1) * PARALLELISM
                    setProgress(
                        workDataOf(
                            KEY_PROGRESS_CURRENT to minOf(processed, imageList.size),
                            KEY_PROGRESS_MAX to imageList.size,
                            KEY_CURRENT_FILE_URI to (chunk.lastOrNull()?.pathUri ?: "")
                        )
                    )

                    // Rate limit: delay between parallel chunks to respect Telegram limits
                    if (chunkIndex < chunks.size - 1) {
                        delay(DELAY_BETWEEN_CHUNKS_MS)
                    }
                }

                Log.d("PeriodicBackup", "Batch complete: $successCount succeeded, $failedCount failed")

                // If more than half failed, retry; otherwise success
                // If there are more photos remaining beyond this batch, WorkManager will re-run
                if (failedCount > imageList.size / 2) {
                    Result.retry()
                } else {
                    val lastUri = if (imageList.isNotEmpty()) imageList.last().pathUri else null
                    // Re-enqueue if there are still pending photos
                    val remainingPhotos = DbHolder.database.photoDao().getAll().count { it.remoteId == null }
                    if (remainingPhotos > 0) {
                        Log.i("PeriodicBackup", "Batch done but $remainingPhotos still pending — re-enqueuing")
                        WorkModule.PeriodicBackup.enqueue(type = "auto")
                    }
                    Result.success(
                        if (lastUri != null) workDataOf(KEY_CURRENT_FILE_URI to lastUri) else workDataOf()
                    )
                }
            } catch (e: Exception) {
                Log.e("PeriodicBackup", "Backup failed, will retry: ${e.message}")
                Result.retry()
            }
        }
    }

    /**
     * Upload a single photo with error handling. Returns true on success, false on failure.
     */
    private suspend fun uploadSinglePhoto(
        photo: com.akslabs.cloudgallery.data.localdb.entities.Photo,
        index: Int,
        total: Int,
        uploadType: String?
    ): Boolean {
        var tempFile: File? = null
        try {
            Log.d("PeriodicBackup", "Processing ${index + 1}/$total: ${photo.pathUri}")

            val uri = photo.pathUri.toUri()
            val fileName = com.akslabs.cloudgallery.utils.getFileName(appContext.contentResolver, uri)
            val mimeType = getMimeTypeFromUri(appContext.contentResolver, uri)
            val ext = getExtFromMimeType(mimeType!!)
            val FIFTY_MB = 50L * 1024 * 1024

            // Stream file to temp instead of reading entire file into memory
            tempFile = File.createTempFile("upload_${index}_", ".$ext")
            val fileSize: Long

            appContext.contentResolver.openInputStream(uri)?.use { input ->
                tempFile!!.outputStream().use { output ->
                    input.copyTo(output, bufferSize = 8192)
                }
            } ?: throw IOException("Cannot open input stream for $uri")

            fileSize = tempFile!!.length()

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

            sendFileApi(botApi, channelId, uri, tempFile!!, ext!!, appContext, uploadType, fileName)
            return true
        } catch (e: Exception) {
            Log.e("PeriodicBackup", "Failed to upload photo ${index + 1} (${photo.pathUri}), skipping: ${e.message}")
            return false
        } finally {
            // Delete temp file immediately, not on exit
            tempFile?.delete()
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

        /** Max photos to process in a single worker run to avoid WorkManager timeout */
        const val MAX_BATCH_SIZE = 50
        /** Number of concurrent uploads */
        const val PARALLELISM = 3
        /** Delay between parallel chunks to respect Telegram rate limits (~1s per photo effective) */
        const val DELAY_BETWEEN_CHUNKS_MS = 1500L
    }
}
