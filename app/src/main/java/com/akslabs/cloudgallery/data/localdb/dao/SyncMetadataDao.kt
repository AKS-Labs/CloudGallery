package com.akslabs.cloudgallery.data.localdb.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.akslabs.cloudgallery.data.localdb.entities.SyncMetadata

@Dao
interface SyncMetadataDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun put(item: SyncMetadata)

    @Query("SELECT value FROM sync_metadata WHERE `key` = :key")
    suspend fun get(key: String): String?

    @Query("DELETE FROM sync_metadata WHERE `key` = :key")
    suspend fun delete(key: String)
}
