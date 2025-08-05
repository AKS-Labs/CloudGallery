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

    init {
        Log.d(TAG, "RemoteViewModel initialized")
        debugDatabaseState()
    }

    // Single unified flow for all cloud photos
    val allCloudPhotosFlow: Flow<PagingData<RemotePhoto>> =
        Pager(
            config = PagingConfig(
                pageSize = PAGE_SIZE,
                prefetchDistance = PREFETCH_DISTANCE,
                jumpThreshold = JUMP_THRESHOLD
            ),
            pagingSourceFactory = {
                Log.d(TAG, "Creating new PagingSource for cloud photos")
                DbHolder.database.remotePhotoDao().getAllPaging()
            }
        ).flow.cachedIn(viewModelScope)

    // Total count of cloud photos
    val totalCloudPhotosCount: StateFlow<Int> =
        DbHolder.database.remotePhotoDao().getTotalCountFlow()
            .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), 0)

    private fun debugDatabaseState() {
        viewModelScope.launch {
            try {
                val allRemotePhotos = DbHolder.database.remotePhotoDao().getAll()
                Log.i(TAG, "=== REMOTE PHOTOS DEBUG ===")
                Log.i(TAG, "Total RemotePhoto records in database: ${allRemotePhotos.size}")

                if (allRemotePhotos.isEmpty()) {
                    Log.w(TAG, "No RemotePhoto records found in database!")
                    Log.i(TAG, "Checking if any photos have been uploaded...")

                    val allPhotos = DbHolder.database.photoDao().getAll()
                    val uploadedPhotos = allPhotos.filter { it.remoteId != null }
                    Log.i(TAG, "Total Photo records: ${allPhotos.size}")
                    Log.i(TAG, "Photos with remoteId (uploaded): ${uploadedPhotos.size}")

                    if (uploadedPhotos.isNotEmpty()) {
                        Log.w(TAG, "Found uploaded photos but no RemotePhoto records - migration issue?")
                        uploadedPhotos.take(3).forEach { photo ->
                            Log.d(TAG, "Uploaded photo: remoteId=${photo.remoteId}, type=${photo.photoType}")
                        }
                    }
                } else {
                    Log.i(TAG, "RemotePhoto records found:")
                    allRemotePhotos.take(5).forEach { remotePhoto ->
                        Log.d(TAG, "RemotePhoto: id=${remotePhoto.remoteId}, type=${remotePhoto.photoType}, " +
                                "fileName=${remotePhoto.fileName}, size=${remotePhoto.fileSize}, " +
                                "uploadedAt=${remotePhoto.uploadedAt}, thumbnailCached=${remotePhoto.thumbnailCached}")
                    }
                    if (allRemotePhotos.size > 5) {
                        Log.d(TAG, "... and ${allRemotePhotos.size - 5} more")
                    }
                }
                Log.i(TAG, "=== END REMOTE PHOTOS DEBUG ===")
            } catch (e: Exception) {
                Log.e(TAG, "Error debugging database state", e)
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