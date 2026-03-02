package com.akslabs.cloudgallery.data.localdb.entities

import android.os.Parcelable
import androidx.annotation.Keep
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
@Entity(tableName = "remote_photos")
data class RemotePhoto(
    @PrimaryKey val remoteId: String,
    @ColumnInfo val photoType: String,
    @ColumnInfo val fileName: String? = null,
    @ColumnInfo val fileSize: Long? = null,
    @ColumnInfo val uploadedAt: Long = System.currentTimeMillis(),
    @ColumnInfo val thumbnailCached: Boolean = false,
    @ColumnInfo val messageId: Long? = null,
    @ColumnInfo val uploadType: String? = null,
) : Parcelable {

    fun toPhoto(): Photo = Photo("", remoteId, photoType, "")

    companion object {
        @JvmStatic
        @JsonCreator
        fun create(
            @JsonProperty("remoteId") remoteId: String,
            @JsonProperty("photoType") photoType: String,
            @JsonProperty("fileName") fileName: String? = null,
            @JsonProperty("fileSize") fileSize: Long? = null,
            @JsonProperty("uploadedAt") uploadedAt: Long = System.currentTimeMillis(),
            @JsonProperty("thumbnailCached") thumbnailCached: Boolean = false,
            @JsonProperty("messageId") messageId: Long? = null,
            @JsonProperty("uploadType") uploadType: String? = null,
        ): RemotePhoto = RemotePhoto(remoteId, photoType, fileName, fileSize, uploadedAt, thumbnailCached, messageId, uploadType)
    }
}
