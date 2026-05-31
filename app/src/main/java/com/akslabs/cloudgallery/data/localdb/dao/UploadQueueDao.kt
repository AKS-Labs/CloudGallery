package com.akslabs.cloudgallery.data.localdb.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.akslabs.cloudgallery.data.localdb.entities.UploadQueue
import kotlinx.coroutines.flow.Flow

@Dao
interface UploadQueueDao {
    @Insert
    suspend fun insert(item: UploadQueue): Long

    @Query("SELECT * FROM upload_queue WHERE status = 'PENDING' ORDER BY createdAt ASC")
    suspend fun getPending(): List<UploadQueue>

    @Query("SELECT * FROM upload_queue WHERE localId = :localId AND status IN ('PENDING','IN_PROGRESS')")
    suspend fun getActiveForPhoto(localId: String): UploadQueue?

    @Query("SELECT * FROM upload_queue WHERE contentHash = :hash AND status IN ('PENDING','IN_PROGRESS','DONE')")
    suspend fun getByContentHash(hash: String): UploadQueue?

    @Query("UPDATE upload_queue SET status = 'IN_PROGRESS', startedAt = :startedAt WHERE id = :id")
    suspend fun markInProgress(id: Long, startedAt: Long = System.currentTimeMillis())

    @Query("UPDATE upload_queue SET status = 'DONE', completedAt = :completedAt WHERE id = :id")
    suspend fun markDone(id: Long, completedAt: Long = System.currentTimeMillis())

    @Query("UPDATE upload_queue SET status = 'FAILED', errorMessage = :error, retryCount = retryCount + 1 WHERE id = :id")
    suspend fun markFailed(id: Long, error: String?)

    @Query("DELETE FROM upload_queue WHERE status = 'DONE' AND completedAt < :before")
    suspend fun cleanupOld(before: Long)

    @Query("SELECT * FROM upload_queue ORDER BY createdAt DESC")
    fun getAllFlow(): Flow<List<UploadQueue>>
}
