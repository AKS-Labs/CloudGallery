package com.akslabs.cloudgallery.workers

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.akslabs.cloudgallery.data.localdb.backup.BackupHelper

/**
 * Worker that runs daily to backup database to Telegram
 * Ensures users don't lose their data and can restore after app reinstall
 */
class DailyDatabaseBackupWorker(
    private val context: Context,
    params: WorkerParameters
) : CoroutineWorker(context, params) {
    
    companion object {
        const val TAG = "DailyDatabaseBackup"
        const val WORK_NAME = "daily_database_backup"
    }
    
    override suspend fun doWork(): Result {
        Log.d(TAG, "Daily database backup worker started")
        
        return try {
            // Check if backup is needed
            if (!BackupHelper.shouldCreateDailyBackup()) {
                Log.d(TAG, "Daily backup not needed yet")
                return Result.success()
            }
            
            // Check if database has changes
            if (BackupHelper.isDatabaseBackupUpToDate()) {
                Log.d(TAG, "Database backup is up to date, no changes to backup")
                return Result.success()
            }
            
            // Create and upload backup
            val result = BackupHelper.uploadDatabaseToTelegram(context)
            
            result.fold(
                onSuccess = { message ->
                    Log.i(TAG, "Daily database backup completed: $message")
                    Result.success()
                },
                onFailure = { error ->
                    Log.e(TAG, "Daily database backup failed: ${error.message}", error)
                    Result.retry()
                }
            )
            
        } catch (e: Exception) {
            Log.e(TAG, "Exception in DailyDatabaseBackupWorker", e)
            Result.retry()
        }
    }
}
