package com.akslabs.cloudgallery.ui.main.screens.trash

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
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class TrashViewModel : ViewModel() {

    // Use soft-deleted remote photos instead of legacy deleted_photos table
    val deletedPhotosFlow: Flow<PagingData<RemotePhoto>> by lazy {
        Pager(
            config = PagingConfig(pageSize = 24),
            pagingSourceFactory = { DbHolder.database.remotePhotoDao().getDeletedPagingSource() }
        ).flow.cachedIn(viewModelScope)
    }

    val totalSize: StateFlow<Long> by lazy {
        DbHolder.database.remotePhotoDao().getDeletedTotalSizeFlow()
            .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), 0L)
    }

    val deletedPhotosCount: StateFlow<Int> by lazy {
        DbHolder.database.remotePhotoDao().getDeletedCountFlow()
            .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), 0)
    }

    val allDeletedPhotos: StateFlow<List<com.akslabs.cloudgallery.data.localdb.entities.Photo>> by lazy {
        DbHolder.database.remotePhotoDao().getDeletedFlow()
            .map { list ->
                list.map { photo ->
                    com.akslabs.cloudgallery.data.localdb.entities.Photo(
                        localId = "",
                        remoteId = photo.remoteId,
                        photoType = photo.photoType,
                        pathUri = ""
                    )
                }
            }
            .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), emptyList())
    }

    fun restore(photo: RemotePhoto) {
        viewModelScope.launch(kotlinx.coroutines.Dispatchers.IO) {
            val dao = DbHolder.database.remotePhotoDao()
            // Simply change status back to ACTIVE
            dao.restore(photo.remoteId)
        }
    }

    fun permanentlyDelete(photo: RemotePhoto) {
        viewModelScope.launch(kotlinx.coroutines.Dispatchers.IO) {
            // Hard-delete from database
            DbHolder.database.remotePhotoDao().delete(photo.remoteId)
        }
    }
}
