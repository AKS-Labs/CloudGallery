package com.akslabs.cloudgallery.ui.main.screens.local

import android.net.Uri
import android.util.Log
import androidx.compose.ui.util.fastForEach
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.akslabs.cloudgallery.data.localdb.DbHolder
import com.akslabs.cloudgallery.data.mediastore.LocalPhotoSource
import com.akslabs.cloudgallery.data.mediastore.LocalUiPhoto
import com.akslabs.cloudgallery.workers.WorkModule
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class LocalViewModel : ViewModel() {

    val localPhotosFlow: Flow<PagingData<LocalUiPhoto>> by lazy {
        Pager(
            config = PagingConfig(
                pageSize = PAGE_SIZE,
                prefetchDistance = PREFETCH_DISTANCE,
                jumpThreshold = JUMP_THRESHOLD,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                Log.d(TAG, "=== CREATING NEW LOCAL PAGING SOURCE ===")
                Log.d(TAG, "PageSize: $PAGE_SIZE, PrefetchDistance: $PREFETCH_DISTANCE, JumpThreshold: $JUMP_THRESHOLD")
                LocalPhotoSource
            }
        ).flow.cachedIn(viewModelScope)
    }

    val localPhotosCount: StateFlow<Int> by lazy {
        DbHolder.database.photoDao().getAllCountFlow()
            .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), 0)
    }

    init {
        Log.e(TAG, "🚀 === LOCAL VIEW MODEL INITIALIZED ===")
        debugDatabaseState()

        // Monitor paging data changes
        viewModelScope.launch {
            try {
                localPhotosFlow.collect { pagingData ->
                    Log.e(TAG, "📄 New PagingData received in LocalViewModel")
                }
            } catch (e: Exception) {
                Log.e(TAG, "❌ Error collecting from localPhotosFlow", e)
            }
        }

        // Monitor total count changes
        viewModelScope.launch {
            try {
                localPhotosCount.collect { count ->
                    Log.e(TAG, "📊 Local photos count updated: $count")
                }
            } catch (e: Exception) {
                Log.e(TAG, "❌ Error collecting from localPhotosCount", e)
            }
        }
    }

    fun uploadMultiplePhotos(uris: List<Uri>) {
        viewModelScope.launch(Dispatchers.IO) {
            uris.fastForEach { uri ->
                WorkModule.InstantUpload(uri).enqueue()
            }
        }
    }

    private fun debugDatabaseState() {
        viewModelScope.launch {
            try {
                Log.i(TAG, "=== LOCAL PHOTOS DATABASE DEBUG ===")

                // Check Photo table
                val allPhotos = DbHolder.database.photoDao().getAll()
                Log.i(TAG, "Total Photo records in database: ${allPhotos.size}")

                if (allPhotos.isEmpty()) {
                    Log.w(TAG, "❌ NO Photo records found in database!")
                } else {
                    Log.i(TAG, "✅ Photo records found:")
                    allPhotos.take(10).forEachIndexed { index, photo ->
                        Log.d(TAG, "Photo[$index]: localId=${photo.localId}, pathUri=${photo.pathUri}, " +
                                "remoteId=${photo.remoteId}, photoType=${photo.photoType}")
                    }
                    if (allPhotos.size > 10) {
                        Log.d(TAG, "... and ${allPhotos.size - 10} more records")
                    }

                    // Test paging source directly
                    Log.i(TAG, "Testing Local PagingSource directly...")
                    val pagingSource = DbHolder.database.photoDao().getAllPaging()
                    Log.d(TAG, "Local PagingSource created: ${pagingSource::class.simpleName}")
                }

                // Check total count flow
                val totalCount = DbHolder.database.photoDao().getAllCountFlow()
                Log.i(TAG, "Local total count flow created: ${totalCount::class.simpleName}")

                Log.i(TAG, "=== END LOCAL PHOTOS DATABASE DEBUG ===")
            } catch (e: Exception) {
                Log.e(TAG, "❌ Error debugging local database state", e)
            }
        }
    }

    companion object {
        private const val TAG = "LocalViewModel"
        const val PAGE_SIZE = 32
        const val PREFETCH_DISTANCE = 2 * 32
        const val JUMP_THRESHOLD = 5 * 32
    }
}