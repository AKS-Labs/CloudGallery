package com.akslabs.cloudgallery.data.localdb.backup

import androidx.annotation.Keep
import com.akslabs.cloudgallery.data.localdb.entities.Photo
import com.akslabs.cloudgallery.data.localdb.entities.RemotePhoto

@Keep
data class BackupFile(
    val photos: List<Photo> = emptyList(),
    val remotePhotos: List<RemotePhoto> = emptyList(),
)
