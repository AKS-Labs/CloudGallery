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
    tableName = "photos",
    indices = [
        Index(value = ["remoteId"]),
        Index(value = ["pathUri"], unique = true),
        Index(value = ["contentHash"]),
        Index(value = ["uploadStatus"])
    ]
)
data class Photo(
    @PrimaryKey val localId: String,
    @ColumnInfo val remoteId: String? = null,
    @ColumnInfo val photoType: String,
    @ColumnInfo val pathUri: String,
    @ColumnInfo val contentHash: String? = null,
    @ColumnInfo val uploadStatus: String = "NONE",
    @ColumnInfo val deviceId: String? = null,
    @ColumnInfo val lastUploadAttempt: Long? = null,
    @ColumnInfo val uploadRetryCount: Int = 0
) : Parcelable {

    companion object {
        @JvmStatic
        @JsonCreator
        fun create(
            @JsonProperty("localId") localId: String,
            @JsonProperty("remoteId") remoteId: String? = null,
            @JsonProperty("photoType") photoType: String,
            @JsonProperty("pathUri") pathUri: String,
            @JsonProperty("contentHash") contentHash: String? = null,
            @JsonProperty("uploadStatus") uploadStatus: String = "NONE",
            @JsonProperty("deviceId") deviceId: String? = null,
            @JsonProperty("lastUploadAttempt") lastUploadAttempt: Long? = null,
            @JsonProperty("uploadRetryCount") uploadRetryCount: Int = 0
        ): Photo = Photo(localId, remoteId, photoType, pathUri, contentHash, uploadStatus, deviceId, lastUploadAttempt, uploadRetryCount)
    }

    fun toRemotePhoto(): RemotePhoto {
        return RemotePhoto(
            remoteId = remoteId.toString(),
            photoType = photoType,
            fileName = pathUri.substringAfterLast('/'),
            fileSize = null,
            uploadedAt = System.currentTimeMillis(),
            thumbnailCached = false,
            localId = localId,
            contentHash = contentHash,
            uploadedByDevice = deviceId
        )
    }
}
