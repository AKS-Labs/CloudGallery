package com.akslabs.cloudgallery.ui.main.screens.uploads

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.work.WorkInfo
import androidx.work.WorkManager
import com.akslabs.cloudgallery.data.localdb.DbHolder
import com.akslabs.cloudgallery.data.localdb.Preferences
import com.akslabs.cloudgallery.data.localdb.entities.Photo
import com.akslabs.cloudgallery.workers.InstantPhotoUploadWorker
import com.akslabs.cloudgallery.workers.PeriodicPhotoBackupWorker
import com.akslabs.cloudgallery.workers.WorkModule
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import kotlinx.coroutines.delay
import java.util.UUID
import kotlin.math.roundToInt
import kotlinx.coroutines.Job

data class UploadUiItem(
    val id: String,
    val type: UploadType,
    val status: UploadStatus,
    val progress: Float = 0f,
    val progressText: String = "",
    val thumbnailUri: Any? = null,
    val fileName: String? = null,
    val totalItems: Int = 1,
    val isCancellable: Boolean = true,
    val localPhotoId: String? = null,
    val speed: String? = null,
    val eta: String? = null,
    val timestamp: Long = System.currentTimeMillis()
)

enum class UploadType {
    Selective,   // User manually chose these
    Background,  // Auto backup running in background
    Instant      // Expedited single photo sync
}

enum class UploadStatus {
    Queued,
    InProgress,
    Completed,
    Failed,
    Cancelled
}

class ManageUploadsViewModel(application: Application) : AndroidViewModel(application) {

    // UI-dismissed synced item IDs — persisted in SharedPreferences across app relaunches
    private val _dismissedIds = MutableStateFlow<Set<String>>(
        Preferences.getStringSet("dismissedSyncedIds", emptySet())
    )

    // Dismissed work IDs (failed/cancelled items dismissed by user) — runtime only
    private val _dismissedWorkIds = MutableStateFlow<Set<String>>(emptySet())

    init {
        // Auto-clear history older than 24 hours on startup
        viewModelScope.launch {
            val oneDayAgo = System.currentTimeMillis() - 24 * 60 * 60 * 1000
            DbHolder.database.remotePhotoDao().deleteOlderThan(oneDayAgo)
        }
    }

    private val workManager = WorkManager.getInstance(application)

    // Observe manual backups (tagged "manual_backup")
    private val manualBackupFlow = workManager.getWorkInfosByTagFlow("manual_backup")

    // Observe instant uploads (tagged "instant_upload")
    private val instantUploadFlow = workManager.getWorkInfosByTagFlow("instant_upload")

    // Observe periodic/auto backups (by unique work name)
    private val periodicBackupFlow = workManager.getWorkInfosForUniqueWorkFlow(WorkModule.PERIODIC_PHOTO_BACKUP_WORK)

    // All uploads from DB (RemotePhoto table)
    private val remotePhotosFlow = DbHolder.database.remotePhotoDao().getAllFlow()
 
    // Track start times for running workers to calculate speed/ETA
    private val workStartTimes = mutableMapOf<UUID, Long>()

    // Selection state for multi-select
    private val _selectedIds = kotlinx.coroutines.flow.MutableStateFlow<Set<String>>(emptySet())
    val selectedIds: StateFlow<Set<String>> = _selectedIds.asStateFlow()

    fun toggleSelection(id: String) {
        _selectedIds.value = if (_selectedIds.value.contains(id)) {
            _selectedIds.value - id
        } else {
            _selectedIds.value + id
        }
    }

    fun clearSelection() {
        _selectedIds.value = emptySet()
    }

    // Inside ManageUploadsViewModel.kt
    fun refresh() {
        viewModelScope.launch {
            _isRefreshing.value = true
            // Call your data loading logic here
            // loadUploads()
            _isRefreshing.value = false
        }
    }
    fun batchCancel() {
        _selectedIds.value.forEach { cancelUpload(it) }
        clearSelection()
    }

    fun batchRetry() {
        // We'd need to re-enqueue specifically these, but retryAllFailed is more general.
        // For now, let's just trigger the general retry if any failed items are selected.
        retryAllFailed()
        clearSelection()
    }

    fun batchClearHistory() {
        val idsToClear = _selectedIds.value.toList()
        viewModelScope.launch {
            DbHolder.database.remotePhotoDao().deleteByRemoteIds(idsToClear)
        }
        // Also try to cancel/prune any work items selected
        _selectedIds.value.forEach { id ->
            val uuid = try { UUID.fromString(id) } catch (e: Exception) { null }
            if (uuid != null) {
                workManager.cancelWorkById(uuid)
            }
        }
        clearSelection()
    }

    // Refresh state
    private val _isRefreshing = MutableStateFlow(false)
    val isRefreshing: StateFlow<Boolean> = _isRefreshing.asStateFlow()

    // Undo state
    private var recentlyDeletedItem: com.akslabs.cloudgallery.data.localdb.entities.RemotePhoto? = null
    private var undoJob: Job? = null

    private val remoteToLocalPathMapFlow: StateFlow<Map<String, String>> = DbHolder.database.photoDao().getAllFlow()
        .map { photos -> 
            photos.filter { it.remoteId != null }.associate { it.remoteId!! to it.pathUri }
        }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyMap())

    // Queued Photos (from DB — not yet uploaded)
    val queuedPhotos: StateFlow<List<Photo>> = DbHolder.database.photoDao().getAllNotUploadedFlow()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    // Raw active work (before thumbnail enrichment)
    private val rawWorkFlow = combine(
        manualBackupFlow,
        instantUploadFlow,
        periodicBackupFlow,
        remoteToLocalPathMapFlow,
        _dismissedWorkIds
    ) { manual, instant, periodic, localMap, dismissedIds ->
        val workMap = mutableMapOf<UUID, Pair<WorkInfo, UploadType>>()
        manual.forEach { workMap[it.id] = it to UploadType.Selective }
        instant.forEach { if (!workMap.containsKey(it.id)) workMap[it.id] = it to UploadType.Instant }
        periodic.forEach { if (!workMap.containsKey(it.id)) workMap[it.id] = it to UploadType.Background }
        workMap.values.mapNotNull { (info, type) -> 
            val item = mapWorkInfoToUiItem(info, type, localMap)
            if (item != null && item.id !in dismissedIds) item else null
        }
    }

    // Combined active work with local thumbnails resolved
    private val allWorkFlow: Flow<List<UploadUiItem>> = rawWorkFlow.combine(queuedPhotos) { workItems, nonUploadedPhotos ->
        workItems.map { item ->
            if (item.thumbnailUri == null && item.localPhotoId == null && item.fileName != null) {
                val matchingPath = nonUploadedPhotos.firstOrNull { p ->
                    p.pathUri.contains(item.fileName, ignoreCase = true)
                }?.pathUri
                if (matchingPath != null) item.copy(thumbnailUri = matchingPath, localPhotoId = matchingPath) else item
            } else item
        }
    }

    // All uploads sorted by status and merging DB history
    val allUploads: StateFlow<List<UploadUiItem>> = combine(
        allWorkFlow, 
        remotePhotosFlow,
        remoteToLocalPathMapFlow,
        _dismissedIds
    ) { workItems, dbItems, localMap, dismissed ->
        val dbUploads = dbItems
            .filter { it.remoteId !in dismissed }
            .map { mapRemotePhotoToUiItem(it, localMap) }
        val dbFileNames = dbItems.mapNotNull { it.fileName }.toSet()

        // Deduplicate: Keep work items only if they are not yet in the DB
        // or if they are still running/queued.
        val filteredWork = workItems.filter { item ->
            if (item.status == UploadStatus.Completed) {
                // If recently completed, only keep if it hasn't reached the DB yet
                return@filter item.fileName !in dbFileNames
            }
            // Keep all active/failed/queued items
            true
        }
        
        (filteredWork + dbUploads).sortedWith(
            compareByDescending<UploadUiItem> { it.status == UploadStatus.InProgress }
                .thenByDescending { it.status == UploadStatus.Queued }
                .thenByDescending { it.status == UploadStatus.Failed }
                .thenByDescending { it.timestamp }
        )
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())
 
    // Manual uploads only (manual backup + instant uploads + DB history of these types)
    val manualUploads: StateFlow<List<UploadUiItem>> = combine(
        allWorkFlow, 
        remotePhotosFlow,
        remoteToLocalPathMapFlow,
        _dismissedIds
    ) { workItems, dbItems, localMap, dismissed ->
        val manualWork = workItems.filter { it.type == UploadType.Selective || it.type == UploadType.Instant }
        val manualDb = dbItems
            .filter { it.uploadType == "manual_backup" || it.uploadType == "instant" }
            .filter { it.remoteId !in dismissed }
            .map { mapRemotePhotoToUiItem(it, localMap) }
        
        val dbFileNames = manualDb.mapNotNull { it.fileName }.toSet()
        val filteredWork = manualWork.filter { 
            if (it.status == UploadStatus.Completed) it.fileName !in dbFileNames else true
        }
        
        val result: List<UploadUiItem> = (filteredWork + manualDb).sortedWith(
            compareByDescending<UploadUiItem> { it.status == UploadStatus.InProgress }
                .thenByDescending { it.timestamp }
        )
        result
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())
 
    // Auto backup uploads only (Active work)
    val autoBackupUploads: StateFlow<List<UploadUiItem>> = allWorkFlow.map { items ->
        items.filter { it.type == UploadType.Background }
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())
 
    // Failed uploads only
    val failedUploads: StateFlow<List<UploadUiItem>> = allWorkFlow.map { items ->
        items.filter { it.status == UploadStatus.Failed }
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())
 
    // Synced/Completed uploads history (All DB records + recently synced)
    val syncedUploads: StateFlow<List<UploadUiItem>> = combine(
        allWorkFlow,
        remotePhotosFlow,
        remoteToLocalPathMapFlow,
        _dismissedIds
    ) { workItems, dbItems, localMap, dismissed ->
        val dbUploads = dbItems
            .filter { it.remoteId !in dismissed }
            .map { mapRemotePhotoToUiItem(it, localMap) }
        val dbFileNames = dbItems.mapNotNull { it.fileName }.toSet()
        
        // Include work items that are completed but not yet in DB
        val recentlyCompletedWork = workItems.filter { 
            it.status == UploadStatus.Completed && it.fileName !in dbFileNames && it.id !in dismissed
        }
        
        (recentlyCompletedWork + dbUploads).sortedByDescending { it.timestamp }
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())
 
    private fun mapRemotePhotoToUiItem(
        remote: com.akslabs.cloudgallery.data.localdb.entities.RemotePhoto,
        localMap: Map<String, String>
    ): UploadUiItem {
        val localPath = localMap[remote.remoteId]
        val remoteThumb = if (localPath == null) {
            com.akslabs.cloudgallery.utils.coil.FileIdData(remote.previewRemoteId ?: remote.remoteId)
        } else null
        return UploadUiItem(
            id = remote.remoteId,
            type = when (remote.uploadType) {
                "manual_backup" -> UploadType.Selective
                "instant" -> UploadType.Instant
                else -> UploadType.Background
            },
            status = UploadStatus.Completed,
            progress = 1f,
            progressText = "Synced to Cloud",
            thumbnailUri = localPath ?: remoteThumb,
            totalItems = 1,
            fileName = remote.fileName ?: "Uploaded Photo",
            isCancellable = false,
            localPhotoId = localPath,
            timestamp = remote.uploadedAt
        )
    }

    private fun mapWorkInfoToUiItem(
        workInfo: WorkInfo, 
        type: UploadType,
        localMap: Map<String, String> = emptyMap()
    ): UploadUiItem? {
        val status = when (workInfo.state) {
            WorkInfo.State.ENQUEUED -> UploadStatus.Queued
            WorkInfo.State.RUNNING -> UploadStatus.InProgress
            WorkInfo.State.SUCCEEDED -> UploadStatus.Completed
            WorkInfo.State.FAILED -> UploadStatus.Failed
            WorkInfo.State.CANCELLED -> UploadStatus.Cancelled
            WorkInfo.State.BLOCKED -> UploadStatus.Queued
        }

        val progressData = workInfo.progress
        val outputData = workInfo.outputData
        var progress = 0f
        var progressText = ""
        var thumbnailUri: String? = null
        var totalItems = 1
        var fileName: String? = null
        var localPhotoId: String? = null

        // Support for dynamic filename and URI across all types
        when (type) {
            UploadType.Selective, UploadType.Instant -> {
                // Check both possible keys for URIs (Instant uses KEY_PHOTO_URI, Periodic uses KEY_CURRENT_FILE_URI)
                // Also fall back to WorkPhotoRegistry for queued workers that haven't run yet
                val extractedUri = progressData.getString(InstantPhotoUploadWorker.KEY_PHOTO_URI)?.takeIf<String> { it.isNotEmpty() }
                    ?: progressData.getString(PeriodicPhotoBackupWorker.KEY_CURRENT_FILE_URI)?.takeIf<String> { it.isNotEmpty() }
                    ?: outputData.getString(InstantPhotoUploadWorker.KEY_PHOTO_URI)?.takeIf<String> { it.isNotEmpty() }
                    ?: outputData.getString(PeriodicPhotoBackupWorker.KEY_CURRENT_FILE_URI)?.takeIf<String> { it.isNotEmpty() }
                    ?: WorkModule.WorkPhotoRegistry.resolve(workInfo.id.toString())?.takeIf<String> { it.isNotEmpty() }
                
                thumbnailUri = extractedUri
                localPhotoId = extractedUri
                
                val registryFileName = extractedUri?.substringAfterLast("/")?.takeIf { it.isNotEmpty() }
                progressText = when (status) {
                    UploadStatus.InProgress -> if (type == UploadType.Instant) "Syncing..." else "Uploading..."
                    UploadStatus.Completed -> "Synced"
                    UploadStatus.Failed -> "Failed — will retry"
                    else -> "Queued..."
                }
                
                fileName = progressData.getString(InstantPhotoUploadWorker.KEY_FILE_NAME)?.takeIf<String> { it.isNotEmpty() }
                    ?: outputData.getString(InstantPhotoUploadWorker.KEY_FILE_NAME)?.takeIf<String> { it.isNotEmpty() }
                    ?: registryFileName
                    ?: "Photo Upload"

                // Try to resolve thumbnail from localMap by filename if URI is missing
                if (thumbnailUri == null && fileName != null) {
                    thumbnailUri = localMap.values.find { it.substringAfterLast("/") == fileName || it.endsWith(fileName!!) }
                }
            }
            UploadType.Background -> {
                val extractedUri = progressData.getString(PeriodicPhotoBackupWorker.KEY_CURRENT_FILE_URI)?.takeIf<String> { it.isNotEmpty() }
                    ?: outputData.getString(PeriodicPhotoBackupWorker.KEY_CURRENT_FILE_URI)?.takeIf<String> { it.isNotEmpty() }
                
                thumbnailUri = extractedUri
                localPhotoId = extractedUri
                
                progressText = when (status) {
                    UploadStatus.InProgress -> {
                        val current = progressData.getInt(PeriodicPhotoBackupWorker.KEY_PROGRESS_CURRENT, 0)
                        val total = progressData.getInt(PeriodicPhotoBackupWorker.KEY_PROGRESS_MAX, 0)
                        if (total > 0) "Backing up $current of $total..." else "Calculating..."
                    }
                    UploadStatus.Completed -> "Backup complete"
                    UploadStatus.Failed -> "Backup failed"
                    else -> "Queued for backup..."
                }
                
                fileName = progressData.getString("fileName")?.takeIf<String> { it.isNotEmpty() }
                    ?: (if (type == UploadType.Selective) "User Choice" else "Auto Backup")
                
                // Try to resolve thumbnail from localMap by filename if currentUri is missing
                if (thumbnailUri == null) {
                    thumbnailUri = localMap.values.find { it.substringAfterLast("/") == fileName || it.endsWith(fileName!!) }
                }
            }
        }

        // Calculate Speed & ETA if in progress
        var speedText: String? = null
        var etaText: String? = null
        
        if (status == UploadStatus.InProgress && totalItems > 1 && progress > 0) {
            val startTime = workStartTimes.getOrPut(workInfo.id) { System.currentTimeMillis() }
            val elapsed = (System.currentTimeMillis() - startTime).coerceAtLeast(1000L).toFloat() / 1000f
            val itemsDone = (progress * totalItems).coerceAtLeast(0.1f)
            val itemsPerSecond = itemsDone / elapsed
            
            if (itemsPerSecond > 0) {
                speedText = String.format("%.1f items/s", itemsPerSecond)
                val remainingItems = (totalItems - itemsDone).coerceAtLeast(0f)
                val remainingSeconds = (remainingItems / itemsPerSecond).roundToInt()
                
                etaText = if (remainingSeconds < 60) {
                    "$remainingSeconds s left"
                } else if (remainingSeconds < 3600) {
                    "${remainingSeconds / 60} m left"
                } else {
                    "${remainingSeconds / 3600} h left"
                }
            }
        } else if (status != UploadStatus.InProgress) {
            workStartTimes.remove(workInfo.id)
        }

        return UploadUiItem(
            id = workInfo.id.toString(),
            type = type,
            status = status,
            progress = progress,
            progressText = progressText,
            thumbnailUri = thumbnailUri,
            totalItems = totalItems,
            fileName = fileName,
            isCancellable = status == UploadStatus.InProgress || status == UploadStatus.Queued,
            localPhotoId = localPhotoId,
            speed = speedText,
            eta = etaText
        )
    }

    fun cancelUpload(id: String) {
        try {
            workManager.cancelWorkById(UUID.fromString(id))
        } catch (e: Exception) {
            Log.e("ManageUploadsVM", "Error canceling work", e)
        }
    }

    fun deleteHistoryItem(id: String, onUndoAvailable: (String) -> Unit) {
        viewModelScope.launch {
            Log.d("ManageUploadsVM", "Deleting history item: $id")
            // Temporarily store it for undo
            recentlyDeletedItem = DbHolder.database.remotePhotoDao().getById(id)
            DbHolder.database.remotePhotoDao().delete(id)
            onUndoAvailable("Item removed from history")
            
            // Auto-clear undo state after 5 seconds
            undoJob?.cancel()
            undoJob = launch {
                delay(5000)
                recentlyDeletedItem = null
            }
        }
    }

    fun undoDelete() {
        viewModelScope.launch {
            recentlyDeletedItem?.let { item ->
                Log.d("ManageUploadsVM", "Restoring history item: ${item.remoteId}")
                DbHolder.database.remotePhotoDao().insertAll(item)
                recentlyDeletedItem = null
            }
        }
    }

    fun clearAllHistory() {
        val currentSynced = syncedUploads.value.map { it.id }.toSet()
        val newDismissed = _dismissedIds.value + currentSynced
        _dismissedIds.value = newDismissed
        Preferences.edit { putStringSet("dismissedSyncedIds", newDismissed) }
    }

    fun retryAllFailed() {
        val failed = allUploads.value.filter { it.status == UploadStatus.Failed }
        // Dismiss all failed items so they disappear from the list
        _dismissedWorkIds.value = _dismissedWorkIds.value + failed.map { it.id }.toSet()
        // Retry logic:
        // 1. Enqueue periodic backup if any manual/auto backup failed
        if (failed.any { it.type == UploadType.Selective || it.type == UploadType.Background }) {
            WorkModule.PeriodicBackup.enqueue()
        }
        // 2. Retry instant uploads (WorkManager retry logic handles this, but if cancelled we might need to re-enqueue. 
        // Simple retry for now is relying on WorkManager's auto-retry or re-enqueuing if we had the URI, 
        // but re-enqueuing requires keeping track of URIs which we don't fully do here yet apart from observing.
        // For now, retryAll primarily triggers the main backup worker which picks up queued items.
    }

    fun retryUpload(id: String) {
        viewModelScope.launch {
            // Dismiss the old work ID so it disappears from lists immediately
            _dismissedWorkIds.value = _dismissedWorkIds.value + id

            val item = allUploads.value.find { it.id == id }
            if (item != null) {
                // Try to enqueue using localPhotoId or thumbnailUri if available
                var uriStr = item.localPhotoId ?: (item.thumbnailUri as? String)

                // If URI not in work data, look up from DB by filename
                if (uriStr.isNullOrEmpty() && item.fileName != null) {
                    val photo = DbHolder.database.photoDao().getAllNotUploaded()
                        .find { it.pathUri.contains(item.fileName, ignoreCase = true) }
                    uriStr = photo?.pathUri
                }

                if (!uriStr.isNullOrEmpty()) {
                    try {
                        val uri = android.net.Uri.parse(uriStr)
                        WorkModule.InstantUpload(uri, type = "manual_backup").enqueue()
                    } catch (e: Exception) {
                        // couldn't retry — just dismissed
                    }
                }
            }
        }
    }

    fun dismissFailedItem(id: String) {
        _dismissedWorkIds.value = _dismissedWorkIds.value + id
    }

    fun refreshWorkInfo() {
        viewModelScope.launch {
            _isRefreshing.value = true
            // Simulate refresh delay to show the indicator for a short moment, 
            // as WorkInfo streams are continuous.
            delay(800)
            _isRefreshing.value = false
        }
    }
}
