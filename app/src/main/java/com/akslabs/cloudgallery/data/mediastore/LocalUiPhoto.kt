package com.akslabs.cloudgallery.data.mediastore

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class LocalUiPhoto(
    val localId: String,
    val pathUri: String,
    val mimeType: String,
    val displayDateMillis: Long,
    val size: Long = 0,
    val remoteId: String? = null,
    val bucketId: Long = -1L,
    val bucketName: String = ""
) : Parcelable


