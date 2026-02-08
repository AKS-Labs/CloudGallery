package com.akslabs.cloudgallery.ui.main.screens.remote

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.akslabs.cloudgallery.data.localdb.DbHolder
import com.akslabs.cloudgallery.data.localdb.entities.RemotePhoto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class RemoteViewModel : ViewModel() {

    // Single unified flow for all cloud photos
    val allCloudPhotosFlow: Flow<PagingData<RemotePhoto>> by lazy {
        Pager(
            config = PagingConfig(
                pageSize = PAGE_SIZE,
                prefetchDistance = PREFETCH_DISTANCE,
                jumpThreshold = JUMP_THRESHOLD
            ),
            pagingSourceFactory = {
                Log.d(TAG, "=== CREATING NEW PAGING SOURCE ===")
                Log.d(TAG, "PageSize: $PAGE_SIZE, PrefetchDistance: $PREFETCH_DISTANCE, JumpThreshold: $JUMP_THRESHOLD")
                val pagingSource = DbHolder.database.remotePhotoDao().getAllPagingSource()
                Log.d(TAG, "PagingSource created: ${pagingSource::class.simpleName}")
                pagingSource
            }
        ).flow.cachedIn(viewModelScope)
    }

    // Total count of cloud photos
    val totalCloudPhotosCount: StateFlow<Int> by lazy {
        DbHolder.database.remotePhotoDao().getTotalCountFlow()
            .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), 0)
    }

    // Total size of cloud photos
    val totalSize: StateFlow<Long> by lazy {
        DbHolder.database.remotePhotoDao().getTotalSizeFlow()
            .map { it ?: 0L }
            .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), 0L)
    }

    init {
        // Monitor paging data changes
        viewModelScope.launch {
            try {
                allCloudPhotosFlow.collect { pagingData ->
                    Log.e(TAG, "📄 New PagingData received in ViewModel")
                }
            } catch (e: Exception) {
                Log.e(TAG, "❌ Error collecting from allCloudPhotosFlow", e)
            }
        }

        // Monitor total count changes
        viewModelScope.launch {
            try {
                totalCloudPhotosCount.collect { count ->
                    Log.e(TAG, "📊 Total count updated: $count")
                }
            } catch (e: Exception) {
                Log.e(TAG, "❌ Error collecting from totalCloudPhotosCount", e)
            }
        }
    }

    fun moveToTrash(selectedIds: Set<String>) {
        viewModelScope.launch {
            val dao = DbHolder.database.remotePhotoDao()
            val deletedDao = DbHolder.database.deletedPhotoDao()
            val channelId = com.akslabs.cloudgallery.data.localdb.Preferences.getEncryptedLong(com.akslabs.cloudgallery.data.localdb.Preferences.channelId, 0L)

            selectedIds.forEach { id ->
                val photo = dao.getById(id)
                if (photo != null) {
                    // Move to DeletedPhoto
                    val deletedPhoto = com.akslabs.cloudgallery.data.localdb.entities.DeletedPhoto(
                        remoteId = photo.remoteId,
                        photoType = photo.photoType,
                        fileName = photo.fileName,
                        fileSize = photo.fileSize,
                        uploadedAt = photo.uploadedAt,
                        deletedAt = System.currentTimeMillis(),
                        messageId = photo.messageId
                    )
                    deletedDao.insert(deletedPhoto)

                    // Delete from RemotePhoto
                    dao.delete(id)

                    // Delete from Telegram if possible
                    if (channelId != 0L && photo.messageId != null) {
                         com.akslabs.cloudgallery.api.BotApi.deleteMessage(channelId, photo.messageId)
                    }
                }
            }
        }
    }

    private fun debugDatabaseState() {
        viewModelScope.launch {
            try {
                Log.i(TAG, "=== COMPREHENSIVE DATABASE DEBUG ===")

                // Check RemotePhoto table
                val allRemotePhotos = DbHolder.database.remotePhotoDao().getAll()
                Log.i(TAG, "Total RemotePhoto records in database: ${allRemotePhotos.size}")

                if (allRemotePhotos.isEmpty()) {
                    Log.w(TAG, "❌ NO RemotePhoto records found in database!")
                } else {
                    Log.i(TAG, "✅ RemotePhoto records found:")
                    allRemotePhotos.take(10).forEachIndexed { index, remotePhoto ->
                        Log.d(TAG, "RemotePhoto[$index]: id=${remotePhoto.remoteId}, type=${remotePhoto.photoType}, " +
                                "fileName=${remotePhoto.fileName}, size=${remotePhoto.fileSize}, " +
                                "uploadedAt=${remotePhoto.uploadedAt}, thumbnailCached=${remotePhoto.thumbnailCached}")
                    }
                    if (allRemotePhotos.size > 10) {
                        Log.d(TAG, "... and ${allRemotePhotos.size - 10} more records")
                    }

                    // Test paging source directly
                    Log.i(TAG, "Testing PagingSource directly...")
                    val pagingSource = DbHolder.database.remotePhotoDao().getAllPagingSource()
                    Log.d(TAG, "PagingSource created: ${pagingSource::class.simpleName}")
                }

                // Check total count flow
                val totalCount = DbHolder.database.remotePhotoDao().getTotalCountFlow()
                Log.i(TAG, "Total count flow created: ${totalCount::class.simpleName}")

                Log.i(TAG, "=== END COMPREHENSIVE DATABASE DEBUG ===")
            } catch (e: Exception) {
                Log.e(TAG, "❌ Error debugging database state", e)
            }
        }
    }

    companion object {
        private const val TAG = "RemoteViewModel"
        const val PAGE_SIZE = 24  // Reduced for better thumbnail loading performance
        const val PREFETCH_DISTANCE = 3 * 24  // Reduced prefetch distance
        const val JUMP_THRESHOLD = 5 * 24
    }
}
