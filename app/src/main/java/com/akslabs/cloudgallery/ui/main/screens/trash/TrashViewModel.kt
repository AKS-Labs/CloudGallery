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
import kotlinx.coroutines.flow.map
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

    val allDeletedPhotos: StateFlow<List<com.akslabs.cloudgallery.data.localdb.entities.Photo>> by lazy {
        DbHolder.database.deletedPhotoDao().getAllFlow()
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
                    uploadedAt = photo.uploadedAt,
                    messageId = photo.messageId
                )
            )
            // Remove from deleted table
            deletedDao.delete(photo)
        }
    }

    fun permanentlyDelete(photo: DeletedPhoto) {
        viewModelScope.launch(kotlinx.coroutines.Dispatchers.IO) {
            DbHolder.database.deletedPhotoDao().delete(photo)
            // Note: We already deleted from Telegram when moving to trash, 
            // or if we didn't, we can try again here if we want, but usually "Trash" implies it's already "gone" from the main view.
            // If the user wants to ensure it's gone from Telegram, we did that in moveToTrash.
            // If we want to support "Delete from Telegram ONLY when permanently deleting", we should change moveToTrash.
            // But the user said "ensure selected images gets deleted from chat ... and show those photos in trash bin".
            // So we delete from chat FIRST.
        }
    }
}
