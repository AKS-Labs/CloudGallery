package com.akslabs.cloudgallery.workers

import android.content.Context
import android.content.pm.ServiceInfo
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.work.CoroutineWorker
import androidx.work.ExistingWorkPolicy
import androidx.work.ForegroundInfo
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkerParameters
import androidx.work.workDataOf
import com.akslabs.cloudgallery.R
import com.akslabs.cloudgallery.api.BotApi
import com.akslabs.cloudgallery.data.localdb.DbHolder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import java.io.ByteArrayOutputStream

/**
 * Background worker that pre-downloads all cloud photo thumbnails into the local Room DB.
 * After sync, the grid reads thumbnails from local BLOB storage — zero network during scroll.
 */
class ThumbnailSyncWorker(
    context: Context,
    workerParams: WorkerParameters
) : CoroutineWorker(context, workerParams) {

    companion object {
        private const val TAG = "ThumbnailSyncWorker"
        private const val NOTIFICATION_ID = 2010
        private const val CHANNEL_ID = "cloud_sync_channel"
        private const val BATCH_SIZE = 50
        private const val CONCURRENCY = 10
        private const val BATCH_DELAY_MS = 50L
        const val WORK_NAME = "ThumbnailSync"

        fun enqueue(context: Context) {
            WorkManager.getInstance(context).enqueueUniqueWork(
                WORK_NAME,
                ExistingWorkPolicy.KEEP,
                OneTimeWorkRequestBuilder<ThumbnailSyncWorker>().build()
            )
        }
    }

    override suspend fun doWork(): Result {
        Log.i(TAG, "=== THUMBNAIL SYNC WORKER STARTED ===")

        val dao = DbHolder.database.remotePhotoDao()
        val totalUnsynced = dao.getUnsyncedCount()
        val totalSynced = dao.getSyncedCount()
        val totalPhotos = totalSynced + totalUnsynced

        if (totalUnsynced == 0) {
            Log.i(TAG, "All $totalPhotos thumbnails already synced. Done.")
            return Result.success()
        }

        Log.i(TAG, "Need to sync $totalUnsynced / $totalPhotos thumbnails")

        try {
            setForeground(createForegroundInfo(totalSynced, totalPhotos))
        } catch (e: Exception) {
            Log.w(TAG, "Could not set foreground: ${e.message}")
        }

        var synced = totalSynced
        var errors = 0

        while (true) {
            val batch = dao.getUnsyncedPhotos(BATCH_SIZE)
            if (batch.isEmpty()) break

            // Process in parallel — 10 concurrent downloads
            batch.chunked(CONCURRENCY).forEach { chunk ->
                val results = coroutineScope {
                    chunk.map { photo ->
                        async(Dispatchers.IO) {
                            try {
                                val fileId = photo.thumbFileId ?: photo.remoteId
                                val useThumb = photo.thumbFileId != null

                                val rawBytes = BotApi.getFile(fileId)
                                if (rawBytes == null || rawBytes.size < 100) {
                                    return@async false
                                }

                                val thumbBytes = if (useThumb) rawBytes else scaleThumbnail(rawBytes)
                                if (thumbBytes != null) {
                                    dao.updateThumbnail(photo.remoteId, thumbBytes)
                                    true
                                } else {
                                    // Can't decode (e.g. HEIC) — mark synced to stop retrying
                                    Log.w(TAG, "Can't decode ${photo.remoteId} (${photo.photoType}), marking synced")
                                    dao.markThumbSynced(photo.remoteId)
                                    true
                                }
                            } catch (e: Exception) {
                                Log.e(TAG, "Error syncing ${photo.remoteId}: ${e.message}")
                                false
                            }
                        }
                    }.awaitAll()
                }
                synced += results.count { it }
                errors += results.count { !it }
            }

            // Update progress
            try {
                setProgress(workDataOf("synced" to synced, "total" to totalPhotos))
                setForeground(createForegroundInfo(synced, totalPhotos))
            } catch (_: Exception) {}

            // Rate limiting delay between batches
            delay(BATCH_DELAY_MS)
        }

        Log.i(TAG, "=== THUMBNAIL SYNC COMPLETE: $synced synced, $errors errors ===")

        // Check if there are still unsynced (due to errors) and re-enqueue
        val remaining = dao.getUnsyncedCount()
        if (remaining > 0 && errors > 0) {
            Log.i(TAG, "$remaining photos still unsynced, will retry later")
            // Don't re-enqueue immediately to avoid hammering on persistent errors
        }

        return Result.success(workDataOf("synced" to synced, "errors" to errors))
    }

    private fun scaleThumbnail(rawBytes: ByteArray): ByteArray? {
        return try {
            val options = BitmapFactory.Options().apply { inJustDecodeBounds = true }
            BitmapFactory.decodeByteArray(rawBytes, 0, rawBytes.size, options)

            // Calculate sample size for ~200px target
            val targetSize = 200
            var sampleSize = 1
            while (options.outWidth / sampleSize > targetSize * 2 || options.outHeight / sampleSize > targetSize * 2) {
                sampleSize *= 2
            }

            val decodeOptions = BitmapFactory.Options().apply { inSampleSize = sampleSize }
            val bitmap = BitmapFactory.decodeByteArray(rawBytes, 0, rawBytes.size, decodeOptions) ?: return null

            val scaled = Bitmap.createScaledBitmap(bitmap, targetSize, targetSize, true)
            val out = ByteArrayOutputStream()
            scaled.compress(Bitmap.CompressFormat.JPEG, 60, out)

            if (scaled !== bitmap) scaled.recycle()
            bitmap.recycle()

            out.toByteArray()
        } catch (e: Exception) {
            Log.e(TAG, "Failed to scale thumbnail: ${e.message}")
            null
        }
    }

    private fun createForegroundInfo(synced: Int, total: Int): ForegroundInfo {
        val notification = NotificationCompat.Builder(applicationContext, CHANNEL_ID)
            .setContentTitle("Syncing cloud thumbnails")
            .setContentText("$synced / $total")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setProgress(total, synced, false)
            .setOngoing(true)
            .setSilent(true)
            .build()

        return ForegroundInfo(
            NOTIFICATION_ID,
            notification,
            ServiceInfo.FOREGROUND_SERVICE_TYPE_DATA_SYNC
        )
    }
}
