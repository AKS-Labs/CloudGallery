package com.akslabs.cloudgallery.data.mediastore

import android.content.ContentResolver
import android.content.Context
import android.provider.MediaStore
import androidx.paging.PagingSource
import androidx.paging.PagingState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LocalPhotoSource(context: Context) : PagingSource<Int, LocalUiPhoto>() {

    private val contentResolver: ContentResolver = context.contentResolver
    private val imageCollection = MediaStore.Images.Media.getContentUri(MediaStore.VOLUME_EXTERNAL)

    override val jumpingSupported: Boolean = true

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, LocalUiPhoto> {
        val page = params.key ?: 1
        val pageSize = params.loadSize
        val limit = pageSize
        val offset = (page - 1) * pageSize
        val pagePhotoList = mutableListOf<LocalUiPhoto>()
        val query =
            Query.PhotoQuery().copy(
                bundle = Query.PhotoQuery().bundle?.apply {
                    putString(
                        ContentResolver.QUERY_ARG_SQL_SORT_ORDER,
                        "${MediaStore.Images.ImageColumns.DATE_MODIFIED} DESC"
                    )
                    putInt(
                        ContentResolver.QUERY_ARG_OFFSET,
                        offset
                    )
                    putInt(
                        ContentResolver.QUERY_ARG_LIMIT,
                        limit
                    )
                }
            )
        return try {
            withContext(Dispatchers.IO) {
                val cursor = contentResolver.query(
                    imageCollection,
                    query.projection,
                    query.bundle,
                    null
                )
                cursor?.use { _ ->
                    while (cursor.moveToNext()) {
                        try {
                            val id: Long = cursor.getLong(cursor.getColumnIndexOrThrow(MediaStore.Images.ImageColumns._ID))
                            val mime: String = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Images.ImageColumns.MIME_TYPE))
                            val dateTaken = runCatching { cursor.getLong(cursor.getColumnIndexOrThrow(MediaStore.Images.ImageColumns.DATE_TAKEN)) }.getOrDefault(0L)
                            val dateAdded = runCatching { cursor.getLong(cursor.getColumnIndexOrThrow(MediaStore.Images.ImageColumns.DATE_ADDED)) }.getOrDefault(0L) * 1000L
                            val dateModified = runCatching { cursor.getLong(cursor.getColumnIndexOrThrow(MediaStore.Images.ImageColumns.DATE_MODIFIED)) }.getOrDefault(0L) * 1000L
                            val ts = when {
                                dateTaken > 0L -> dateTaken
                                dateModified > 0L -> dateModified
                                dateAdded > 0L -> dateAdded
                                else -> 0L
                            }
                            val contentUri = MediaStore.Images.Media.getContentUri(MediaStore.VOLUME_EXTERNAL)
                            val uri = android.content.ContentUris.withAppendedId(contentUri, id)
                            pagePhotoList.add(LocalUiPhoto(id.toString(), uri.toString(), mime, ts))
                        } catch (e: Exception) {
                            e.printStackTrace()
                        }
                    }
                }
            }
            val nextKey = if (pagePhotoList.size < pageSize) null else page + 1
            LoadResult.Page(pagePhotoList, null, nextKey)
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, LocalUiPhoto>): Int? {
        val anchor = state.anchorPosition ?: return null
        val closest = state.closestPageToPosition(anchor)
        return closest?.prevKey?.plus(1) ?: closest?.nextKey?.minus(1)
    }
}