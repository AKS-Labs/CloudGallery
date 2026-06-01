package com.akslabs.cloudgallery.data.localdb.dao

import androidx.annotation.Keep
import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import androidx.room.Upsert
import com.akslabs.cloudgallery.data.localdb.entities.Photo
import kotlinx.coroutines.flow.Flow

@Keep
@Dao
interface PhotoDao {

    @Query("SELECT * FROM photos ORDER BY pathUri DESC")
    fun getAllPagingSource(): PagingSource<Int, Photo>

    @Query("SELECT * FROM photos ORDER BY pathUri DESC")
    fun getAllFlow(): Flow<List<Photo>>

    @Query("SELECT * FROM photos")
    suspend fun getAll(): List<Photo>

    @Query("SELECT COUNT(*) FROM photos")
    fun getAllCountFlow(): Flow<Int>

    @Query("SELECT COUNT(*) FROM photos")
    suspend fun getCount(): Int

    @Query("SELECT * FROM photos WHERE localId IN (:localIds) AND remoteId IS NOT NULL")
    suspend fun getRemoteIdsForLocals(localIds: List<String>): List<Photo>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertPhotos(vararg photos: Photo): List<Long>

    @Update
    suspend fun updatePhotos(vararg photos: Photo)

    @Query("DELETE FROM photos WHERE localId = :id")
    suspend fun deleteById(id: String)

    @Query("DELETE FROM photos")
    suspend fun deleteAll()

    @Query("SELECT * FROM photos WHERE remoteId IS NULL")
    suspend fun getAllNotUploaded(): List<Photo>

    @Query("SELECT * FROM photos WHERE remoteId IS NULL")
    fun getAllNotUploadedFlow(): Flow<List<Photo>>

    @Query("SELECT * FROM photos WHERE remoteId = :remoteId")
    suspend fun getByRemoteId(remoteId: String): Photo?

    // NOT USED RIGHT NOW
    @Upsert
    suspend fun upsertPhotos(vararg photos: Photo)

    // NOT USED RIGHT NOW
    @Query("SELECT * FROM photos WHERE remoteId IS NOT NULL")
    suspend fun getAllUploaded(): List<Photo>

    // NOT USED RIGHT NOW
    @Query("SELECT COUNT(*) FROM photos WHERE remoteId IS NOT NULL")
    fun getAllUploadedCountFlow(): Flow<Int>

    @Query("SELECT * FROM photos WHERE localId = :localId")
    suspend fun getPhotoByLocalId(localId: String): Photo?

    @Query("UPDATE photos SET remoteId = :remoteId WHERE pathUri = :pathUri")
    suspend fun updateRemoteIdForPath(pathUri: String, remoteId: String)

    @Query("UPDATE photos SET remoteId = :remoteId WHERE localId = :localId")
    suspend fun updateRemoteIdForLocalId(localId: String, remoteId: String)

    @Query("SELECT localId FROM photos")
    suspend fun getAllLocalIds(): List<String>

    @Query("SELECT localId, remoteId FROM photos WHERE remoteId IS NOT NULL")
    suspend fun getSyncedPhotoMap(): List<SyncedPhotoTuple>

    // ── New queries for multi-device & dedup ──

    @Query("SELECT * FROM photos WHERE contentHash = :hash LIMIT 1")
    suspend fun getByContentHash(hash: String): Photo?

    @Query("UPDATE photos SET uploadStatus = :status, lastUploadAttempt = :lastAttempt WHERE localId = :localId")
    suspend fun updateUploadStatus(localId: String, status: String, lastAttempt: Long? = null)

    @Query("UPDATE photos SET contentHash = :hash WHERE localId = :localId")
    suspend fun updateContentHash(localId: String, hash: String)

    @Query("SELECT * FROM photos WHERE contentHash IS NULL")
    suspend fun getAllNeedingHash(): List<Photo>

    @Query("SELECT * FROM photos WHERE uploadStatus IN ('NONE', 'FAILED') AND remoteId IS NULL")
    suspend fun getAllPendingUpload(): List<Photo>

    @Query("UPDATE photos SET deviceId = :deviceId WHERE localId = :localId")
    suspend fun setDeviceId(localId: String, deviceId: String)

    @Query("UPDATE photos SET previewRemoteId = :previewRemoteId WHERE localId = :localId")
    suspend fun updatePreviewRemoteId(localId: String, previewRemoteId: String)
}

data class SyncedPhotoTuple(
    val localId: String,
    val remoteId: String
)
