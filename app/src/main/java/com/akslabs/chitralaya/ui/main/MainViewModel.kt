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
import com.akslabs.cloudgallery.data.localdb.DbHolder
import com.akslabs.cloudgallery.data.localdb.entities.RemotePhoto
import com.akslabs.cloudgallery.data.mediastore.LocalPhotoSource
import com.akslabs.cloudgallery.data.mediastore.LocalUiPhoto
import com.akslabs.cloudgallery.ui.main.nav.Screens
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn

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