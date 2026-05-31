package com.akslabs.cloudgallery.workers

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.akslabs.cloudgallery.api.BotApi
import com.akslabs.cloudgallery.data.localdb.DbHolder
import com.akslabs.cloudgallery.data.localdb.Preferences
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SyncRemoteSizesWorker(
    context: Context,
    params: WorkerParameters
) : CoroutineWorker(context, params) {

    override suspend fun doWork(): Result {
        try {
            setForeground(getForegroundInfo())
        } catch (e: Exception) {
            Log.e(TAG, "Failed to set foreground", e)
        }

        return withContext(Dispatchers.IO) {
            try {
                val channelId = Preferences.getEncryptedLong(Preferences.channelId, 0L)
                if (channelId == 0L) return@withContext Result.failure()

                val dao = DbHolder.database.remotePhotoDao()
                val photosWithoutSize = dao.getAll().filter { it.fileSize == null }

                if (photosWithoutSize.isEmpty()) {
                    Log.d(TAG, "No photos missing size info.")
                    return@withContext Result.success()
                }

                Log.i(TAG, "Found ${photosWithoutSize.size} photos without size info. Fetching individually...")

                var updatedCount = 0
                photosWithoutSize.forEach { photo ->
                    try {
                        val fileSize = BotApi.getFileSize(photo.remoteId)
                        if (fileSize != null) {
                            dao.insertAll(photo.copy(fileSize = fileSize))
                            updatedCount++
                        }
                    } catch (e: Exception) {
                        Log.w(TAG, "Failed to get size for ${photo.remoteId}: ${e.message}")
                        // Continue with next photo
                    }
                }
                Log.i(TAG, "Updated size for $updatedCount photos.")

                Result.success()
            } catch (e: Exception) {
                Log.e(TAG, "Error syncing remote sizes", e)
                Result.retry()
            }
        }
    }

    override suspend fun getForegroundInfo(): androidx.work.ForegroundInfo {
        return createForegroundInfo(
            applicationContext,
            WorkModule.NOTIFICATION_ID_SYNC,
            "Syncing remote file info..."
        )
    }

    companion object {
        private const val TAG = "SyncRemoteSizesWorker"
    }
}
