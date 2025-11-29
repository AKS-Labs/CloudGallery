package com.akslabs.cloudgallery.ui.main.screens.trash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.akslabs.cloudgallery.data.localdb.DbHolder
import com.akslabs.cloudgallery.data.localdb.entities.DeletedPhoto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class TrashViewModel : ViewModel() {

    val deletedPhotosFlow: Flow<PagingData<DeletedPhoto>> by lazy {
        Pager(
            config = PagingConfig(pageSize = 24),
            pagingSourceFactory = { DbHolder.database.deletedPhotoDao().getAllPaging() }
        ).flow.cachedIn(viewModelScope)
    }

    val totalSize: StateFlow<Long> by lazy {
        DbHolder.database.deletedPhotoDao().getTotalSizeFlow()
            .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), 0L)
    }

    fun restore(photo: DeletedPhoto) {
        viewModelScope.launch(kotlinx.coroutines.Dispatchers.IO) {
            val remoteDao = DbHolder.database.remotePhotoDao()
            val deletedDao = DbHolder.database.deletedPhotoDao()
            
            // Move back to remote table
            remoteDao.insertAll(
                com.akslabs.cloudgallery.data.localdb.entities.RemotePhoto(
                    remoteId = photo.remoteId,
                    photoType = photo.photoType,
                    fileName = photo.fileName,
                    fileSize = photo.fileSize,
                    uploadedAt = photo.uploadedAt
                )
            )
            // Remove from deleted table
            deletedDao.delete(photo)
        }
    }

    fun permanentlyDelete(photo: DeletedPhoto) {
        viewModelScope.launch(kotlinx.coroutines.Dispatchers.IO) {
            DbHolder.database.deletedPhotoDao().delete(photo)
            // Also try to delete from Telegram if we had messageId
        }
    }
}
