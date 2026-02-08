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
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map
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
                    WorkModule.observeWorkerByTag("instant_upload"),
                    WorkModule.observeWorkerByName("InstantPhotoBackupWork"),
                    WorkModule.observeWorkerByName(WorkModule.PERIODIC_PHOTO_BACKUP_WORK)
                ) { manualWorkList, instantWorkList, instantPeriodicList, periodicWorkList ->
                    val manualActive = manualWorkList.any { it.state == WorkInfo.State.ENQUEUED || it.state == WorkInfo.State.RUNNING }
                    val instantActive = instantWorkList.any { it.state == WorkInfo.State.ENQUEUED || it.state == WorkInfo.State.RUNNING }
                    val instantPeriodicActive = instantPeriodicList.any { it.state == WorkInfo.State.ENQUEUED || it.state == WorkInfo.State.RUNNING }
                    
                    // periodicWork is always ENQUEUED, so we only check for RUNNING state
                    val periodicActive = periodicWorkList.any { it.state == WorkInfo.State.RUNNING }
                    
                    manualActive || instantActive || instantPeriodicActive || periodicActive
                }.collect { isActive ->
                    _isUploading.value = isActive
                    Log.d("MainViewModel", "Upload state: $isActive")
                }
            } catch (e: Exception) {
                Log.e("MainViewModel", "Error observing upload work", e)
            }
        }
        loadMediaStorePhotos()
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

    val allLocalPhotos: StateFlow<List<com.akslabs.cloudgallery.data.localdb.entities.Photo>> by lazy {
        DbHolder.database.photoDao().getAllFlow()
            .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), emptyList())
    }

    val allRemotePhotos: StateFlow<List<com.akslabs.cloudgallery.data.localdb.entities.Photo>> by lazy {
        DbHolder.database.remotePhotoDao().getAllFlow()
            .map { list -> list.map { it.toPhoto() } }
            .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), emptyList())
    }
    // Track the last viewed photo ID to sync grid position on return
    private val _lastViewedPhotoId = MutableStateFlow<String?>(null)
    val lastViewedPhotoId: StateFlow<String?> = _lastViewedPhotoId.asStateFlow()

    fun updateLastViewedPhotoId(id: String) {
        _lastViewedPhotoId.value = id
    }

    // Cache MediaStore photos for immediate grid access
    private val _mediaStorePhotos = MutableStateFlow<List<LocalUiPhoto>>(emptyList())
    val mediaStorePhotos: StateFlow<List<LocalUiPhoto>> = _mediaStorePhotos.asStateFlow()

    private fun loadMediaStorePhotos() {
        viewModelScope.launch(Dispatchers.IO) {
            val context = getApplication<Application>()
            val resolver = context.contentResolver
            val collection = android.provider.MediaStore.Images.Media.getContentUri(android.provider.MediaStore.VOLUME_EXTERNAL)
            val projection = arrayOf(
                android.provider.MediaStore.Images.ImageColumns._ID,
                android.provider.MediaStore.Images.ImageColumns.DATE_TAKEN,
                android.provider.MediaStore.Images.ImageColumns.DATE_ADDED,
                android.provider.MediaStore.Images.ImageColumns.DATE_MODIFIED,
                android.provider.MediaStore.Images.ImageColumns.MIME_TYPE,
                android.provider.MediaStore.Images.ImageColumns.SIZE
            )
            val photos = ArrayList<LocalUiPhoto>(4096)
            try {
                resolver.query(collection, projection, null, null, "${android.provider.MediaStore.Images.ImageColumns.DATE_TAKEN} DESC")?.use { cursor ->
                    val idIdx = cursor.getColumnIndexOrThrow(android.provider.MediaStore.Images.ImageColumns._ID)
                    val takenIdx = cursor.getColumnIndexOrThrow(android.provider.MediaStore.Images.ImageColumns.DATE_TAKEN)
                    val addedIdx = cursor.getColumnIndexOrThrow(android.provider.MediaStore.Images.ImageColumns.DATE_ADDED)
                    val modIdx = cursor.getColumnIndexOrThrow(android.provider.MediaStore.Images.ImageColumns.DATE_MODIFIED)
                    val mimeIdx = cursor.getColumnIndexOrThrow(android.provider.MediaStore.Images.ImageColumns.MIME_TYPE)
                    val sizeIdx = cursor.getColumnIndexOrThrow(android.provider.MediaStore.Images.ImageColumns.SIZE)

                    while (cursor.moveToNext()) {
                        val id = cursor.getLong(idIdx).toString()
                        val taken = runCatching { cursor.getLong(takenIdx) }.getOrDefault(0L)
                        val added = runCatching { cursor.getLong(addedIdx) }.getOrDefault(0L)
                        val modified = runCatching { cursor.getLong(modIdx) }.getOrDefault(0L)
                        val mimeType = cursor.getString(mimeIdx) ?: "image/jpeg"
                        val size = cursor.getLong(sizeIdx)

                        val tsMillis = when {
                            taken > 0L -> taken
                            added > 0L -> added * 1000L
                            modified > 0L -> modified * 1000L
                            else -> 0L
                        }
                        
                        val uri = android.content.ContentUris.withAppendedId(collection, id.toLong()).toString()

                        photos.add(LocalUiPhoto(
                            localId = id,
                            pathUri = uri,
                            mimeType = mimeType,
                            displayDateMillis = tsMillis,
                            size = size,
                            remoteId = null
                        ))
                    }
                }
                
                // Fetch synced status from DB
                val syncedMap = DbHolder.database.photoDao().getSyncedPhotoMap().associate { it.localId to it.remoteId }
                
                // Update remoteId for photos that are synced
                photos.forEachIndexed { index, photo ->
                    val remoteId = syncedMap[photo.localId]
                    if (remoteId != null) {
                        photos[index] = photo.copy(remoteId = remoteId)
                    }
                }

                // Ensure photos are sorted by the actual display date
                photos.sortByDescending { it.displayDateMillis }
                
                _mediaStorePhotos.value = photos
            } catch (e: Exception) {
                Log.e("MainViewModel", "Error loading MediaStore photos", e)
            }
        }
    }
}
