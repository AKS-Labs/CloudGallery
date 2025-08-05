package com.akslabs.cloudgallery.workers

import android.content.Context
import android.content.pm.ServiceInfo
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.ForegroundInfo
import androidx.work.WorkerParameters
import com.akslabs.cloudgallery.R
import com.akslabs.cloudgallery.services.CloudPhotoSyncService
import com.akslabs.cloudgallery.utils.NotificationHelper

/**
 * Background worker for syncing cloud photos from Telegram channel
 * Runs periodically to discover new historical images and sync them to local database
 */
class CloudPhotoSyncWorker(
    context: Context,
    workerParams: WorkerParameters
) : CoroutineWorker(context, workerParams) {

    override suspend fun doWork(): Result {
        Log.i(TAG, "=== CLOUD PHOTO SYNC WORKER STARTED ===")
        
        return try {
            // Set foreground info for long-running operation
            setForeground(createForegroundInfo())
            
            // Perform sync
            var finalSyncResult: com.akslabs.cloudgallery.services.SyncResult? = null
            CloudPhotoSyncService.performFullSync(applicationContext).collect { progress ->
                // Update progress in foreground notification
                if (progress.isComplete) {
                    finalSyncResult = if (progress.errorMessage != null) {
                        com.akslabs.cloudgallery.services.SyncResult.Error(progress.errorMessage)
                    } else {
                        com.akslabs.cloudgallery.services.SyncResult.Success(progress.totalFilesFound)
                    }
                } else {
                    // Update notification with progress
                    setProgress(
                        androidx.work.workDataOf(
                            "batch" to progress.currentBatch,
                            "found" to progress.totalFilesFound
                        )
                    )
                }
            }

            when (val result = finalSyncResult) {
                is com.akslabs.cloudgallery.services.SyncResult.Success -> {
                    val newFiles = result.newFilesFound
                    Log.i(TAG, "Cloud photo sync completed successfully: $newFiles new files")
                    if (newFiles > 0) {
                        // Show notification about new photos found
                        NotificationHelper.showCloudSyncCompleteNotification(
                            applicationContext,
                            newFiles
                        )
                    }
                    Result.success()
                }

                is com.akslabs.cloudgallery.services.SyncResult.Error -> {
                    Log.e(TAG, "Cloud photo sync failed: ${result.message}")
                    Result.failure()
                }

                is com.akslabs.cloudgallery.services.SyncResult.NoChannelConfigured -> {
                    Log.w(TAG, "No Telegram channel configured, skipping sync")
                    Result.success() // Not a failure, just nothing to do
                }

                null -> {
                    Log.e(TAG, "Sync result was null")
                    Result.failure()
                }
            }
            
        } catch (e: Exception) {
            Log.e(TAG, "Exception in CloudPhotoSyncWorker", e)
            Result.failure()
        } finally {
            Log.i(TAG, "=== CLOUD PHOTO SYNC WORKER FINISHED ===")
        }
    }

    override suspend fun getForegroundInfo(): ForegroundInfo {
        return createForegroundInfo()
    }

    private fun createForegroundInfo(): ForegroundInfo {
        val notification = NotificationHelper.createCloudSyncNotification(
            applicationContext,
            "Syncing cloud photos...",
            "Discovering historical photos from Telegram"
        )
        
        return ForegroundInfo(
            NOTIFICATION_ID,
            notification,
            ServiceInfo.FOREGROUND_SERVICE_TYPE_DATA_SYNC
        )
    }

    companion object {
        private const val TAG = "CloudPhotoSyncWorker"
        private const val NOTIFICATION_ID = 2001
    }
}

/**
 * Worker for quick sync operations (lighter than full sync)
 * Used for more frequent checks without heavy processing
 */
class QuickCloudSyncWorker(
    context: Context,
    workerParams: WorkerParameters
) : CoroutineWorker(context, workerParams) {

    override suspend fun doWork(): Result {
        Log.d(TAG, "Quick cloud sync worker started")
        
        return try {
            val syncResult = CloudPhotoSyncService.performQuickSync(applicationContext)
            
            when (syncResult) {
                is com.akslabs.cloudgallery.services.SyncResult.Success -> {
                    Log.d(TAG, "Quick sync completed: ${syncResult.newFilesFound} new files")
                    Result.success()
                }
                
                is com.akslabs.cloudgallery.services.SyncResult.Error -> {
                    Log.e(TAG, "Quick sync failed: ${syncResult.message}")
                    Result.retry()
                }
                
                is com.akslabs.cloudgallery.services.SyncResult.NoChannelConfigured -> {
                    Log.d(TAG, "No channel configured for quick sync")
                    Result.success()
                }
            }
            
        } catch (e: Exception) {
            Log.e(TAG, "Exception in QuickCloudSyncWorker", e)
            Result.retry()
        }
    }

    companion object {
        private const val TAG = "QuickCloudSyncWorker"
    }
}
