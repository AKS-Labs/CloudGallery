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
@Entity(tableName = "photos")
data class Photo(
    @PrimaryKey val localId: String,
    @ColumnInfo val remoteId: String? = null,
    @ColumnInfo val photoType: String,
    @ColumnInfo val pathUri: String,
) : Parcelable {

    companion object {
        @JvmStatic
        @JsonCreator
        fun create(
            @JsonProperty("localId") localId: String,
            @JsonProperty("remoteId") remoteId: String? = null,
            @JsonProperty("photoType") photoType: String,
            @JsonProperty("pathUri") pathUri: String,
        ): Photo = Photo(localId, remoteId, photoType, pathUri)
    }

    fun toRemotePhoto(): RemotePhoto {
        return RemotePhoto(
            remoteId = remoteId.toString(),
            photoType = photoType,
            fileName = pathUri.substringAfterLast('/'),
            fileSize = null, // File size not available from Photo entity
            uploadedAt = System.currentTimeMillis(),
            thumbnailCached = false
        )
    }
}
