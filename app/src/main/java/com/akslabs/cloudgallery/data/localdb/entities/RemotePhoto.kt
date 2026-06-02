package com.akslabs.cloudgallery.data.localdb.entities

import android.os.Parcelable
import androidx.annotation.Keep
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
@Entity(
    tableName = "remote_photos",
    indices = [
        Index(value = ["uploadedAt"]),
        Index(value = ["contentHash"]),
        Index(value = ["localId"]),
        Index(value = ["status"])
    ]
)
data class RemotePhoto(
    @PrimaryKey val remoteId: String,
    @ColumnInfo val photoType: String,
    @ColumnInfo val fileName: String? = null,
    @ColumnInfo val fileSize: Long? = null,
    @ColumnInfo val uploadedAt: Long = System.currentTimeMillis(),
    @ColumnInfo val thumbnailCached: Boolean = false,
    @ColumnInfo val messageId: Long? = null,
    @ColumnInfo val uploadType: String? = null,
    @ColumnInfo val localId: String? = null,
    @ColumnInfo val contentHash: String? = null,
    @ColumnInfo val status: String = "ACTIVE",
    @ColumnInfo val deletedAt: Long? = null,
    @ColumnInfo val uploadedByDevice: String? = null,
    @ColumnInfo val deletedByDevice: String? = null,
    @ColumnInfo val previewRemoteId: String? = null,
    @ColumnInfo val topicId: Long? = null,
    @ColumnInfo val topicName: String? = null
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
            @JsonProperty("localId") localId: String? = null,
            @JsonProperty("contentHash") contentHash: String? = null,
            @JsonProperty("status") status: String = "ACTIVE",
            @JsonProperty("deletedAt") deletedAt: Long? = null,
            @JsonProperty("uploadedByDevice") uploadedByDevice: String? = null,
            @JsonProperty("deletedByDevice") deletedByDevice: String? = null,
            @JsonProperty("previewRemoteId") previewRemoteId: String? = null,
            @JsonProperty("topicId") topicId: Long? = null,
            @JsonProperty("topicName") topicName: String? = null
        ): RemotePhoto = RemotePhoto(
            remoteId, photoType, fileName, fileSize, uploadedAt, thumbnailCached,
            messageId, uploadType, localId, contentHash, status, deletedAt,
            uploadedByDevice, deletedByDevice, previewRemoteId, topicId, topicName
        )
    }
}
