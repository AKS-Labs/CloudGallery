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
                    putStringArray(
                        ContentResolver.QUERY_ARG_SORT_COLUMNS,
                        arrayOf(MediaStore.Images.ImageColumns.DATE_MODIFIED)
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
                    val idIdx = cursor.getColumnIndexOrThrow(MediaStore.Images.ImageColumns._ID)
                    val mimeIdx = cursor.getColumnIndexOrThrow(MediaStore.Images.ImageColumns.MIME_TYPE)
                    val sizeIdx = cursor.getColumnIndexOrThrow(MediaStore.Images.ImageColumns.SIZE)
                    val takenIdx = cursor.getColumnIndexOrThrow(MediaStore.Images.ImageColumns.DATE_TAKEN)
                    val addedIdx = cursor.getColumnIndexOrThrow(MediaStore.Images.ImageColumns.DATE_ADDED)
                    val modIdx = cursor.getColumnIndexOrThrow(MediaStore.Images.ImageColumns.DATE_MODIFIED)

                    val tempPhotos = mutableListOf<LocalUiPhoto>()
                    val localIds = mutableListOf<String>()

                    while (cursor.moveToNext()) {
                        try {
                            val id = cursor.getLong(idIdx).toString()
                            val mime = cursor.getString(mimeIdx) ?: "image/jpeg"
                            val size = runCatching { cursor.getLong(sizeIdx) }.getOrDefault(0L)
                            val dateTaken = runCatching { cursor.getLong(takenIdx) }.getOrDefault(0L)
                            val dateAdded = runCatching { cursor.getLong(addedIdx) }.getOrDefault(0L) * 1000L
                            val dateModified = runCatching { cursor.getLong(modIdx) }.getOrDefault(0L) * 1000L
                            val ts = when {
                                dateTaken > 0L -> dateTaken
                                dateModified > 0L -> dateModified
                                dateAdded > 0L -> dateAdded
                                else -> 0L
                            }
                            val contentUri = MediaStore.Images.Media.getContentUri(MediaStore.VOLUME_EXTERNAL)
                            val uri = android.content.ContentUris.withAppendedId(contentUri, id.toLong())
                            
                            tempPhotos.add(LocalUiPhoto(id, uri.toString(), mime, ts, size, null))
                            localIds.add(id)
                        } catch (e: Exception) {
                            e.printStackTrace()
                        }
                    }

                    // Batch query remote status
                    if (localIds.isNotEmpty()) {
                        val remotePhotos = com.akslabs.cloudgallery.data.localdb.DbHolder.database.photoDao().getRemoteIdsForLocals(localIds)
                        val remoteIdMap = remotePhotos.associate { it.localId to it.remoteId }
                        
                        tempPhotos.forEach { photo ->
                            val remoteId = remoteIdMap[photo.localId]
                            pagePhotoList.add(photo.copy(remoteId = remoteId))
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
