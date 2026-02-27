package com.akslabs.cloudgallery.ui.main.screens.uploads

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.work.WorkInfo
import androidx.work.WorkManager
import com.akslabs.cloudgallery.data.localdb.DbHolder
import com.akslabs.cloudgallery.data.localdb.entities.Photo
import com.akslabs.cloudgallery.workers.InstantPhotoUploadWorker
import com.akslabs.cloudgallery.workers.PeriodicPhotoBackupWorker
import com.akslabs.cloudgallery.workers.WorkModule
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import java.util.UUID

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
    val localPhotoId: String? = null, // For click-to-open navigation
    val timestamp: Long = System.currentTimeMillis() // When the work was observed
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

    private val workManager = WorkManager.getInstance(application)

    // Observe manual backups (tagged "manual_backup")
    private val manualBackupFlow = workManager.getWorkInfosByTagFlow("manual_backup")

    // Observe instant uploads (tagged "instant_upload")
    private val instantUploadFlow = workManager.getWorkInfosByTagFlow("instant_upload")

    // Observe periodic/auto backups (by unique work name)
    private val periodicBackupFlow = workManager.getWorkInfosForUniqueWorkFlow(WorkModule.PERIODIC_PHOTO_BACKUP_WORK)

    // All uploads from DB (RemotePhoto table)
    private val remotePhotosFlow = DbHolder.database.remotePhotoDao().getAllFlow()
 
    // Map of remoteId to local path for smart thumbnails
    private val remoteToLocalPathMapFlow: StateFlow<Map<String, String>> = DbHolder.database.photoDao().getAllFlow()
        .map { photos -> 
            photos.filter { it.remoteId != null }.associate { it.remoteId!! to it.pathUri }
        }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyMap())

    // Combined active work
    private val allWorkFlow = combine(
        manualBackupFlow,
        instantUploadFlow,
        periodicBackupFlow,
        remoteToLocalPathMapFlow
    ) { manual, instant, periodic, localMap ->
        // Use a map to deduplicate by ID, keeping the most specific type mapping if possible.
        // We prioritize the lists in order: Manual -> Instant -> Periodic
        val workMap = mutableMapOf<UUID, Pair<WorkInfo, UploadType>>()
        
        manual.forEach { workMap[it.id] = it to UploadType.Selective }
        instant.forEach { if (!workMap.containsKey(it.id)) workMap[it.id] = it to UploadType.Instant }
        periodic.forEach { if (!workMap.containsKey(it.id)) workMap[it.id] = it to UploadType.Background }

        workMap.values.mapNotNull { (info, type) -> 
            mapWorkInfoToUiItem(info, type, localMap) 
        }
    }

    // Queued Photos (from DB — not yet uploaded)
    val queuedPhotos: StateFlow<List<Photo>> = DbHolder.database.photoDao().getAllNotUploadedFlow()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    // All uploads sorted by status and merging DB history
    val allUploads: StateFlow<List<UploadUiItem>> = combine(
        allWorkFlow, 
        remotePhotosFlow,
        remoteToLocalPathMapFlow
    ) { workItems, dbItems, localMap ->
        val dbUploads = dbItems.map { mapRemotePhotoToUiItem(it, localMap) }
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
        remoteToLocalPathMapFlow
    ) { workItems, dbItems, localMap ->
        val manualWork = workItems.filter { it.type == UploadType.Selective || it.type == UploadType.Instant }
        val manualDb = dbItems
            .filter { it.uploadType == "manual_backup" || it.uploadType == "instant" }
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
 
    // Synced/Completed uploads history (All DB records)
    val syncedUploads: StateFlow<List<UploadUiItem>> = combine(
        remotePhotosFlow,
        remoteToLocalPathMapFlow
    ) { items, localMap ->
        items.map { mapRemotePhotoToUiItem(it, localMap) }
            .sortedByDescending { it.timestamp }
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())
 
    private fun mapRemotePhotoToUiItem(
        remote: com.akslabs.cloudgallery.data.localdb.entities.RemotePhoto,
        localMap: Map<String, String>
    ): UploadUiItem {
        val localPath = localMap[remote.remoteId]
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
            thumbnailUri = localPath ?: remote, // Smart Thumbnail: Use local path if available, else RemotePhoto object
            totalItems = 1,
            fileName = remote.fileName ?: "Uploaded Photo",
            isCancellable = false,
            localPhotoId = localPath, // Allow clicking to open local if available
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
        val inputData = workInfo.inputData
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
                val extractedUri = progressData.getString(InstantPhotoUploadWorker.KEY_PHOTO_URI)?.ifEmpty { null }
                    ?: progressData.getString(PeriodicPhotoBackupWorker.KEY_CURRENT_FILE_URI)?.ifEmpty { null }
                    ?: inputData.getString(InstantPhotoUploadWorker.KEY_PHOTO_URI)?.ifEmpty { null }
                    ?: inputData.getString(PeriodicPhotoBackupWorker.KEY_CURRENT_FILE_URI)?.ifEmpty { null }
                    ?: outputData.getString(InstantPhotoUploadWorker.KEY_PHOTO_URI)?.ifEmpty { null }
                    ?: outputData.getString(PeriodicPhotoBackupWorker.KEY_CURRENT_FILE_URI)?.ifEmpty { null }
                
                thumbnailUri = extractedUri
                localPhotoId = extractedUri
                
                progressText = when (status) {
                    UploadStatus.InProgress -> if (type == UploadType.Instant) "Syncing..." else "Uploading..."
                    UploadStatus.Completed -> "Synced"
                    UploadStatus.Failed -> "Failed — will retry"
                    else -> "Queued..."
                }
                
                fileName = progressData.getString(InstantPhotoUploadWorker.KEY_FILE_NAME)?.ifEmpty { null }
                    ?: inputData.getString(InstantPhotoUploadWorker.KEY_FILE_NAME)?.ifEmpty { null }
                    ?: outputData.getString(InstantPhotoUploadWorker.KEY_FILE_NAME)?.ifEmpty { null }
                    ?: "Photo Upload"

                // Try to resolve thumbnail from localMap by filename if URI is missing
                if (thumbnailUri == null && fileName != null) {
                    thumbnailUri = localMap.values.find { it.substringAfterLast("/") == fileName || it.endsWith(fileName!!) }
                }
            }
            UploadType.Background -> {
                val extractedUri = progressData.getString(PeriodicPhotoBackupWorker.KEY_CURRENT_FILE_URI)?.ifEmpty { null }
                    ?: inputData.getString(PeriodicPhotoBackupWorker.KEY_CURRENT_FILE_URI)?.ifEmpty { null }
                    ?: outputData.getString(PeriodicPhotoBackupWorker.KEY_CURRENT_FILE_URI)?.ifEmpty { null }
                
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
                
                fileName = progressData.getString("fileName")?.ifEmpty { null }
                    ?: inputData.getString("fileName")?.ifEmpty { null }
                    ?: (if (type == UploadType.Selective) "User Choice" else "Auto Backup")
                
                // Try to resolve thumbnail from localMap by filename if currentUri is missing
                if (thumbnailUri == null && fileName != null) {
                    thumbnailUri = localMap.values.find { it.substringAfterLast("/") == fileName || it.endsWith(fileName!!) }
                }
            }
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
            localPhotoId = localPhotoId
        )
    }

    fun cancelUpload(id: String) {
        try {
            workManager.cancelWorkById(UUID.fromString(id))
        } catch (e: Exception) {
            Log.e("ManageUploadsVM", "Error canceling work", e)
        }
    }

    fun retryAllFailed() {
        val failed = allUploads.value.filter { it.status == UploadStatus.Failed }
        // Retry logic:
        // 1. Enqueue periodic backup if any manual/auto backup failed
        if (failed.any { it.type == UploadType.Selective || it.type == UploadType.Background }) {
            WorkModule.PeriodicBackup.enqueue()
        }
        // 2. Retry instant uploads (WorkManager retry logic handles this, but if cancelled we might need to re-enqueue. 
        // Simple retry for now is relying on WorkManager's auto-retry or re-enqueuing if we had the URI, 
        // but re-enqueuing requires keeping track of URIs which we don't fully do here yet apart from observing.
        // For now, retryAll primarily triggers the main backup worker which picks up queued items.)
    }
}
