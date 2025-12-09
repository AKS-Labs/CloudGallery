package com.akslabs.cloudgallery.ui.main

import android.app.Application
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.work.WorkManager
import androidx.work.WorkInfo
import com.akslabs.cloudgallery.data.localdb.DbHolder
import com.akslabs.cloudgallery.data.localdb.entities.RemotePhoto
import com.akslabs.cloudgallery.data.mediastore.LocalPhotoSource
import com.akslabs.cloudgallery.data.mediastore.LocalUiPhoto
import com.akslabs.cloudgallery.ui.main.nav.Screens
import com.akslabs.cloudgallery.workers.WorkModule
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {
    var currentDestination by mutableStateOf<Screens>(Screens.LocalPhotos)
        private set

    fun updateDestination(destination: Screens) {
        currentDestination = destination
    }

    private val _syncState = MutableStateFlow(SyncState.IDLE)
    val syncState: StateFlow<SyncState> = _syncState.asStateFlow()

    fun updateSyncState(newState: SyncState) {
        _syncState.value = newState
    }

    // Upload/Backup state tracking
    private val _isUploading = MutableStateFlow(false)
    val isUploading: StateFlow<Boolean> = _isUploading.asStateFlow()

    init {
        // Combine observations of manual_backup and instant_upload tags
        viewModelScope.launch {
            try {
                combine(
                    WorkModule.observeWorkerByTag("manual_backup"),
                    WorkModule.observeWorkerByTag("instant_upload")
                ) { manualWorkList, instantWorkList ->
                    val manualActive = manualWorkList.any { it.state == WorkInfo.State.ENQUEUED || it.state == WorkInfo.State.RUNNING }
                    val instantActive = instantWorkList.any { it.state == WorkInfo.State.ENQUEUED || it.state == WorkInfo.State.RUNNING }
                    manualActive || instantActive
                }.collect { isActive ->
                    _isUploading.value = isActive
                    Log.d("MainViewModel", "Upload state: $isActive")
                }
            } catch (e: Exception) {
                Log.e("MainViewModel", "Error observing upload work", e)
            }
        }
    }

    val localPhotosFlow: Flow<PagingData<LocalUiPhoto>> by lazy {
        Pager(
            config = PagingConfig(
                pageSize = 60,
                prefetchDistance = 192,
                jumpThreshold = 160,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                Log.d("MainViewModel", "=== CREATING NEW LOCAL PAGING SOURCE ===")
                LocalPhotoSource(getApplication())
            }
        ).flow.cachedIn(viewModelScope)
    }

    val allCloudPhotosFlow: Flow<PagingData<RemotePhoto>> by lazy {
        Pager(
            config = PagingConfig(
                pageSize = 24,
                prefetchDistance = 72,
                jumpThreshold = 120
            ),
            pagingSourceFactory = {
                Log.d("MainViewModel", "=== CREATING NEW REMOTE PAGING SOURCE ===")
                DbHolder.database.remotePhotoDao().getAllPagingSource()
            }
        ).flow.cachedIn(viewModelScope)
    }

    val localPhotosCount: StateFlow<Int> by lazy {
        DbHolder.database.photoDao().getAllCountFlow()
            .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), 0)
    }

    val totalCloudPhotosCount: StateFlow<Int> by lazy {
        DbHolder.database.remotePhotoDao().getTotalCountFlow()
            .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), 0)
    }
}