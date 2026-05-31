package com.akslabs.cloudgallery.data.localdb.dao

import androidx.annotation.Keep
import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.akslabs.cloudgallery.data.localdb.entities.Photo
import com.akslabs.cloudgallery.data.localdb.entities.RemotePhoto
import kotlinx.coroutines.flow.Flow

@Keep
@Dao
interface RemotePhotoDao {
    // Default queries now filter by ACTIVE status
    @Query("SELECT * FROM remote_photos WHERE status = 'ACTIVE' ORDER BY uploadedAt DESC")
    fun getAllPagingSource(): PagingSource<Int, RemotePhoto>

    @Query("SELECT * FROM remote_photos WHERE status = 'ACTIVE' ORDER BY uploadedAt DESC")
    fun getAllFlow(): Flow<List<RemotePhoto>>

    @Query("SELECT * FROM remote_photos WHERE status = 'ACTIVE'")
    suspend fun getAll(): List<RemotePhoto>

    // Unfiltered queries (for backup/migration purposes)
    @Query("SELECT * FROM remote_photos")
    suspend fun getAllIncludingDeleted(): List<RemotePhoto>

    @Query("SELECT COUNT(*) FROM remote_photos WHERE status = 'ACTIVE'")
    fun getTotalCountFlow(): Flow<Int>

    @Query("SELECT COUNT(*) FROM remote_photos WHERE status = 'ACTIVE'")
    suspend fun getCount(): Int

    @Query("SELECT SUM(fileSize) FROM remote_photos WHERE status = 'ACTIVE'")
    fun getTotalSizeFlow(): Flow<Long?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg remotePhotos: RemotePhoto)

    @Query("DELETE FROM remote_photos")
    suspend fun clearAll()

    @Query("DELETE FROM remote_photos WHERE remoteId IN (:remoteIds)")
    suspend fun deleteByRemoteIds(remoteIds: List<String>)

    @Query("DELETE FROM remote_photos WHERE remoteId = :remoteId")
    suspend fun delete(remoteId: String)

    @Query("DELETE FROM remote_photos WHERE uploadedAt < :timestamp")
    suspend fun deleteOlderThan(timestamp: Long)

    @Query("SELECT * FROM remote_photos WHERE remoteId = :remoteId")
    suspend fun getById(remoteId: String): RemotePhoto?

    @Query("UPDATE remote_photos SET thumbnailCached = :cached WHERE remoteId = :remoteId")
    suspend fun updateThumbnailCached(remoteId: String, cached: Boolean)

    // For "delete backed up photos" feature
    @Query(
        "SELECT p.* FROM photos p INNER JOIN remote_photos rp ON p.remoteId = rp.remoteId WHERE p.remoteId IS NOT NULL AND rp.status = 'ACTIVE'"
    )
    suspend fun getBackedUpPhotosOnDevice(): List<Photo>

    @Query("SELECT remoteId FROM remote_photos WHERE status = 'ACTIVE'")
    suspend fun getAllRemoteIds(): List<String>

    // ── New queries for multi-device & dedup ──

    @Query("SELECT * FROM remote_photos WHERE contentHash = :hash AND status = 'ACTIVE' LIMIT 1")
    suspend fun getByContentHash(hash: String): RemotePhoto?

    @Query("SELECT * FROM remote_photos WHERE status = 'ACTIVE' ORDER BY uploadedAt DESC")
    fun getActivePagingSource(): PagingSource<Int, RemotePhoto>

    @Query("SELECT * FROM remote_photos WHERE status = 'DELETED' ORDER BY deletedAt DESC")
    fun getDeletedPagingSource(): PagingSource<Int, RemotePhoto>

    @Query("SELECT * FROM remote_photos WHERE status = 'DELETED' ORDER BY deletedAt DESC")
    fun getDeletedFlow(): Flow<List<RemotePhoto>>

    @Query("SELECT COUNT(*) FROM remote_photos WHERE status = 'DELETED'")
    fun getDeletedCountFlow(): Flow<Int>

    @Query("SELECT COALESCE(SUM(fileSize), 0) FROM remote_photos WHERE status = 'DELETED'")
    fun getDeletedTotalSizeFlow(): Flow<Long>

    @Query("UPDATE remote_photos SET status = 'DELETED', deletedAt = :deletedAt, deletedByDevice = :deletedByDevice WHERE remoteId = :remoteId")
    suspend fun softDelete(remoteId: String, deletedAt: Long = System.currentTimeMillis(), deletedByDevice: String? = null)

    @Query("UPDATE remote_photos SET status = 'ACTIVE', deletedAt = NULL, deletedByDevice = NULL WHERE remoteId = :remoteId")
    suspend fun restore(remoteId: String)

    @Query("SELECT * FROM remote_photos WHERE uploadedByDevice = :deviceId AND status = 'ACTIVE'")
    suspend fun getByDeviceId(deviceId: String): List<RemotePhoto>
}
