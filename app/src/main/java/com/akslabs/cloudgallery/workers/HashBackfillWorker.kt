package com.akslabs.cloudgallery.workers

import android.content.Context
import android.util.Log
import androidx.core.net.toUri
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.akslabs.cloudgallery.data.localdb.DbHolder
import com.akslabs.cloudgallery.utils.ContentHasher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Background worker that computes SHA-256 content hashes for existing photos
 * that don't have one yet. Runs with low priority in batches of 50.
 */
class HashBackfillWorker(
    private val context: Context,
    params: WorkerParameters
) : CoroutineWorker(context, params) {

    override suspend fun doWork(): Result = withContext(Dispatchers.IO) {
        try {
            val photoDao = DbHolder.database.photoDao()
            val remotePhotoDao = DbHolder.database.remotePhotoDao()
            val photosNeedingHash = photoDao.getAllNeedingHash()

            if (photosNeedingHash.isEmpty()) {
                Log.d(TAG, "No photos need hashing")
                return@withContext Result.success()
            }

            Log.i(TAG, "Hashing ${photosNeedingHash.size} photos")

            // Process in batches of 50
            photosNeedingHash.chunked(BATCH_SIZE).forEachIndexed { batchIndex, batch ->
                batch.forEach { photo ->
                    try {
                        val hash = ContentHasher.computeHash(context, photo.pathUri.toUri())
                        if (hash != null) {
                            photoDao.updateContentHash(photo.localId, hash)

                            // Also update the linked RemotePhoto if it exists
                            if (photo.remoteId != null) {
                                val remotePhoto = remotePhotoDao.getById(photo.remoteId)
                                if (remotePhoto != null && remotePhoto.contentHash == null) {
                                    remotePhotoDao.insertAll(remotePhoto.copy(contentHash = hash))
                                }
                            }
                        }
                    } catch (e: Exception) {
                        Log.w(TAG, "Failed to hash photo ${photo.localId}: ${e.message}")
                        // Continue with next photo — don't fail the whole batch
                    }
                }
                Log.d(TAG, "Batch ${batchIndex + 1} complete (${(batchIndex + 1) * BATCH_SIZE}/${photosNeedingHash.size})")
            }

            Log.i(TAG, "Hash backfill complete")
            Result.success()
        } catch (e: Exception) {
            Log.e(TAG, "Hash backfill failed", e)
            Result.retry()
        }
    }

    companion object {
        private const val TAG = "HashBackfillWorker"
        private const val BATCH_SIZE = 50
    }
}
