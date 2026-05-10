package com.akslabs.cloudgallery.data.localdb.dao

import androidx.room.*
import com.akslabs.cloudgallery.data.localdb.entities.Place
import kotlinx.coroutines.flow.Flow

@Dao
interface PlaceDao {
    @Query("SELECT * FROM places ORDER BY photoCount DESC")
    fun getAll(): Flow<List<Place>>

    @Query("SELECT COUNT(*) FROM places")
    fun count(): Flow<Int>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(places: List<Place>)

    @Query("DELETE FROM places")
    suspend fun deleteAll()
}
