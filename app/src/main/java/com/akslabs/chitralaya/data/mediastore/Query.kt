package com.akslabs.cloudgallery.data.mediastore

import android.content.ContentResolver
import android.os.Bundle
import android.provider.MediaStore

sealed class Query(
    var projection: Array<String>,
    var bundle: Bundle? = null,
) {
    class MediaQuery : Query(
        projection = arrayOf(
            MediaStore.MediaColumns._ID,
            MediaStore.MediaColumns.DATA,
            MediaStore.MediaColumns.RELATIVE_PATH,
            MediaStore.MediaColumns.DISPLAY_NAME,
            MediaStore.MediaColumns.BUCKET_ID,
            MediaStore.MediaColumns.DATE_MODIFIED,
            MediaStore.MediaColumns.DATE_TAKEN,
            MediaStore.MediaColumns.BUCKET_DISPLAY_NAME,
            MediaStore.MediaColumns.DURATION,
            MediaStore.MediaColumns.MIME_TYPE,
            MediaStore.MediaColumns.IS_FAVORITE,
            MediaStore.MediaColumns.IS_TRASHED
        )
    )

    class PhotoQuery : Query(
        projection = arrayOf(
            MediaStore.Images.ImageColumns._ID,
            MediaStore.Images.ImageColumns.DATE_MODIFIED,
            MediaStore.Images.ImageColumns.MIME_TYPE,
            MediaStore.Images.ImageColumns.SIZE,
            MediaStore.Images.ImageColumns.DATE_TAKEN,
            MediaStore.Images.ImageColumns.DATE_ADDED
        ),
        bundle = Bundle()
            .apply {
                putString(
                    ContentResolver.QUERY_ARG_SORT_COLUMNS,
                    MediaStore.Images.ImageColumns.DATE_MODIFIED
                )
                putInt(
                    ContentResolver.QUERY_ARG_SORT_DIRECTION,
                    ContentResolver.QUERY_SORT_DIRECTION_DESCENDING
                )
            }
    )

    class VideoQuery : Query(
        projection = arrayOf(
            MediaStore.Video.VideoColumns._ID,
            MediaStore.Video.VideoColumns.DATE_MODIFIED,
            MediaStore.Video.VideoColumns.MIME_TYPE
        ),
        bundle = Bundle().apply {
            putString(
                ContentResolver.QUERY_ARG_SORT_COLUMNS,
                MediaStore.Video.VideoColumns.DATE_MODIFIED
            )
            putInt(
                ContentResolver.QUERY_ARG_SORT_DIRECTION,
                ContentResolver.QUERY_SORT_DIRECTION_DESCENDING
            )
        }
    )

    fun copy(projection: Array<String> = this.projection, bundle: Bundle? = this.bundle): Query {
        this.projection = projection
        this.bundle = bundle
        return this
    }

    companion object {
        val defaultBundle = Bundle().apply {
            putStringArray(
                ContentResolver.QUERY_ARG_SORT_COLUMNS,
                arrayOf(MediaStore.MediaColumns.DATE_MODIFIED)
            )
            putInt(
                ContentResolver.QUERY_ARG_SQL_SORT_ORDER,
                ContentResolver.QUERY_SORT_DIRECTION_DESCENDING
            )
        }
    }
}