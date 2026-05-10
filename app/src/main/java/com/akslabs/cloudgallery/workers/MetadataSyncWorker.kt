package com.akslabs.cloudgallery.workers

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.ExistingWorkPolicy
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkerParameters
import com.akslabs.cloudgallery.services.MetadataSyncService

/**
 * WorkManager worker that syncs the metadata.db from Telegram on app launch.
 */
class MetadataSyncWorker(
    context: Context,
    workerParams: WorkerParameters
) : CoroutineWorker(context, workerParams) {

    companion object {
        private const val TAG = "MetadataSyncWorker"
        const val WORK_NAME = "MetadataSync"
        private const val PREF_LAST_SYNC = "metadata_last_sync_time"

        fun enqueue(context: Context) {
            WorkManager.getInstance(context).enqueueUniqueWork(
                WORK_NAME,
                ExistingWorkPolicy.KEEP,
                OneTimeWorkRequestBuilder<MetadataSyncWorker>().build()
            )
        }
    }

    override suspend fun doWork(): Result {
        Log.i(TAG, "Starting metadata sync")

        val fileId = MetadataSyncService.findMetadataFileId()
        if (fileId == null) {
            Log.i(TAG, "No metadata.db pinned message found")
            return Result.success()
        }

        val metadataFile = MetadataSyncService.downloadFile(applicationContext, fileId)
        if (metadataFile == null) {
            Log.w(TAG, "Failed to download metadata.db")
            return Result.retry()
        }

        try {
            MetadataSyncService.importMetadata(metadataFile)
            // Store sync timestamp
            applicationContext.getSharedPreferences("metadata_sync", Context.MODE_PRIVATE)
                .edit()
                .putLong(PREF_LAST_SYNC, System.currentTimeMillis())
                .apply()
            Log.i(TAG, "Metadata sync complete")
            return Result.success()
        } catch (e: Exception) {
            Log.e(TAG, "Import failed", e)
            return Result.retry()
        }
    }
}
