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
    @Query("SELECT * FROM remote_photos ORDER BY uploadedAt DESC")
    fun getAllPagingSource(): PagingSource<Int, RemotePhoto>

    @Query("SELECT * FROM remote_photos")
    suspend fun getAll(): List<RemotePhoto>

    @Query("SELECT COUNT(*) FROM remote_photos")
    fun getTotalCountFlow(): Flow<Int>

    @Query("SELECT SUM(fileSize) FROM remote_photos")
    fun getTotalSizeFlow(): Flow<Long?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg remotePhotos: RemotePhoto)

    @Query("DELETE FROM remote_photos WHERE remoteId = :remoteId")
    suspend fun delete(remoteId: String)

    @Query("DELETE FROM remote_photos")
    suspend fun clearAll()

    @Query("SELECT * FROM remote_photos WHERE remoteId = :remoteId")
    suspend fun getById(remoteId: String): RemotePhoto?

    @Query("UPDATE remote_photos SET thumbnailCached = :cached WHERE remoteId = :remoteId")
    suspend fun updateThumbnailCached(remoteId: String, cached: Boolean)

    // For "delete backed up photos" feature - get photos that exist in cloud but can be deleted from device
    @Query(
        "SELECT p.* FROM photos p INNER JOIN remote_photos rp ON p.remoteId = rp.remoteId WHERE p.remoteId IS NOT NULL"
    )
    suspend fun getBackedUpPhotosOnDevice(): List<Photo>
}