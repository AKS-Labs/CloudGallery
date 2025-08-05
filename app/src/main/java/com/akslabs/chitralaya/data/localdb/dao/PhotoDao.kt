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

    @Query("SELECT * FROM photos")
    suspend fun getAll(): List<Photo>

    @Query("SELECT * FROM photos")
    fun getAllPaging(): PagingSource<Int, Photo>

    @Query("SELECT * FROM photos WHERE remoteId IS NOT NULL")
    fun getAllUploadedPaging(): PagingSource<Int, Photo>

    @Query("SELECT COUNT(*) FROM photos")
    fun getAllCountFlow(): Flow<Int>

    @Query("SELECT EXISTS(SELECT 1 FROM photos WHERE localId = :localId AND remoteId IS NOT NULL)")
    suspend fun isUploaded(localId: String): Int

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

    // NOT USED RIGHT NOW
    @Upsert
    suspend fun upsertPhotos(vararg photos: Photo)

    // NOT USED RIGHT NOW
    @Query("SELECT * FROM photos WHERE remoteId IS NOT NULL")
    suspend fun getAllUploaded(): List<Photo>

    // NOT USED RIGHT NOW
    @Query("SELECT COUNT(*) FROM photos WHERE remoteId IS NOT NULL")
    fun getAllUploadedCountFlow(): Flow<Int>

    // NOT USED RIGHT NOW
    @Query("SELECT * FROM photos WHERE remoteId IS NULL")
    fun getAllNotUploadedPaging(): PagingSource<Int, Photo>
}
