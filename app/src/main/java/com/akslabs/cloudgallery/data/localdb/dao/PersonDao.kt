package com.akslabs.cloudgallery.data.localdb.dao

import androidx.room.*
import com.akslabs.cloudgallery.data.localdb.entities.Person
import kotlinx.coroutines.flow.Flow

@Dao
interface PersonDao {
    @Query("SELECT * FROM people ORDER BY photoCount DESC")
    fun getAll(): Flow<List<Person>>

    @Query("SELECT COUNT(*) FROM people")
    fun count(): Flow<Int>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(people: List<Person>)

    @Query("DELETE FROM people")
    suspend fun deleteAll()
}
