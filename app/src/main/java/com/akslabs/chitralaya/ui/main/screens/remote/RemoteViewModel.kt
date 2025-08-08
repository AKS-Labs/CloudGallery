package com.akslabs.cloudgallery.ui.main.screens.remote

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.akslabs.cloudgallery.data.localdb.DbHolder
import com.akslabs.cloudgallery.data.localdb.entities.Photo
import com.akslabs.cloudgallery.data.localdb.entities.RemotePhoto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
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
                val pagingSource = DbHolder.database.remotePhotoDao().getAllPaging()
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

    init {
        Log.e(TAG, "🚀 === REMOTE VIEW MODEL INITIALIZED ===")
        debugDatabaseState()

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

    private fun debugDatabaseState() {
        viewModelScope.launch {
            try {
                Log.i(TAG, "=== COMPREHENSIVE DATABASE DEBUG ===")

                // Check RemotePhoto table
                val allRemotePhotos = DbHolder.database.remotePhotoDao().getAll()
                Log.i(TAG, "Total RemotePhoto records in database: ${allRemotePhotos.size}")

                if (allRemotePhotos.isEmpty()) {
                    Log.w(TAG, "❌ NO RemotePhoto records found in database!")
                    Log.i(TAG, "Checking if any photos have been uploaded...")

                    val allPhotos = DbHolder.database.photoDao().getAll()
                    val uploadedPhotos = allPhotos.filter { it.remoteId != null }
                    Log.i(TAG, "Total Photo records: ${allPhotos.size}")
                    Log.i(TAG, "Photos with remoteId (uploaded): ${uploadedPhotos.size}")

                    if (uploadedPhotos.isNotEmpty()) {
                        Log.w(TAG, "⚠️ Found uploaded photos but no RemotePhoto records - migration issue?")
                        uploadedPhotos.take(3).forEach { photo ->
                            Log.d(TAG, "Uploaded photo: remoteId=${photo.remoteId}, type=${photo.photoType}")
                        }
                    } else {
                        Log.w(TAG, "❌ No uploaded photos found either - database is empty")
                    }
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
                    val pagingSource = DbHolder.database.remotePhotoDao().getAllPaging()
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