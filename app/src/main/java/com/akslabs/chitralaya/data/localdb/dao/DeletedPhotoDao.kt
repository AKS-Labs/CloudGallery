package com.akslabs.cloudgallery.data.localdb.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.akslabs.cloudgallery.data.localdb.entities.DeletedPhoto
import kotlinx.coroutines.flow.Flow

@Dao
interface DeletedPhotoDao {
    @Query("SELECT * FROM deleted_photos ORDER BY deletedAt DESC")
    fun getAllPaging(): PagingSource<Int, DeletedPhoto>

    @Query("SELECT * FROM deleted_photos ORDER BY deletedAt DESC")
    fun getAll(): List<DeletedPhoto>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(photo: DeletedPhoto)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg photos: DeletedPhoto)

    @Delete
    suspend fun delete(photo: DeletedPhoto)

    @Query("DELETE FROM deleted_photos WHERE remoteId = :remoteId")
    suspend fun deleteById(remoteId: String)

    @Query("SELECT * FROM deleted_photos WHERE remoteId = :remoteId")
    suspend fun getById(remoteId: String): DeletedPhoto?

    @Query("SELECT COALESCE(SUM(fileSize), 0) FROM deleted_photos")
    fun getTotalSizeFlow(): Flow<Long>

    @Query("SELECT COUNT(*) FROM deleted_photos")
    fun getCountFlow(): Flow<Int>
}
