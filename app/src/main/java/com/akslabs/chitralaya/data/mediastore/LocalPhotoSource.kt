package com.akslabs.cloudgallery.data.mediastore

import android.content.ContentResolver
import android.content.Context
import android.provider.MediaStore
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.akslabs.cloudgallery.data.localdb.entities.Photo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object LocalPhotoSource : PagingSource<Int, Photo>() {

    private lateinit var contentResolver: ContentResolver
    private val imageCollection = MediaStore.Images.Media.getContentUri(MediaStore.VOLUME_EXTERNAL)

    override val jumpingSupported: Boolean = true

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Photo> {
        val page = params.key ?: 1
        val pageSize = params.loadSize
        val limit = pageSize
        val offset = (page - 1) * pageSize
        val pagePhotoList = mutableListOf<Photo>()
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
                            pagePhotoList.add(cursor.getPhotoFromCursor())
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

    override fun getRefreshKey(state: PagingState<Int, Photo>): Int? {
        return state.anchorPosition
    }

    fun create(applicationContext: Context) {
        contentResolver = applicationContext.contentResolver
    }
}