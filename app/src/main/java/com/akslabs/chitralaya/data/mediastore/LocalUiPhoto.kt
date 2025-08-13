package com.akslabs.cloudgallery.data.mediastore

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class LocalUiPhoto(
    val localId: String,
    val pathUri: String,
    val mimeType: String,
    val displayDateMillis: Long,
) : Parcelable


