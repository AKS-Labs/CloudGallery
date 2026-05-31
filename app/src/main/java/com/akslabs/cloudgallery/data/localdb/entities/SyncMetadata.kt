package com.akslabs.cloudgallery.data.localdb.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sync_metadata")
data class SyncMetadata(
    @PrimaryKey val key: String,
    @ColumnInfo val value: String,
    @ColumnInfo val updatedAt: Long = System.currentTimeMillis()
)
