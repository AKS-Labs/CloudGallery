package com.akslabs.cloudgallery.data.localdb.entities

import android.os.Parcelable
import androidx.annotation.Keep
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
@Entity(tableName = "deleted_photos")
data class DeletedPhoto(
    @PrimaryKey val remoteId: String,
    @ColumnInfo val photoType: String,
    @ColumnInfo val fileName: String? = null,
    @ColumnInfo val fileSize: Long? = null,
    @ColumnInfo val uploadedAt: Long,
    @ColumnInfo val deletedAt: Long = System.currentTimeMillis(),
    @ColumnInfo val messageId: Long? = null
) : Parcelable
