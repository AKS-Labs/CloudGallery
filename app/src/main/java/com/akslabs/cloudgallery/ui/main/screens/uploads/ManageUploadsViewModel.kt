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
    val thumbnailUri: String? = null,
    val fileName: String? = null,
    val totalItems: Int = 1,
    val isCancellable: Boolean = true,
    val localPhotoId: String? = null, // For click-to-open navigation
    val timestamp: Long = System.currentTimeMillis() // When the work was observed
)

enum class UploadType {
    ManualBackup,
    AutoBackup,
    Instant
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

    // Combined active work
    private val allWorkFlow = combine(
        manualBackupFlow,
        instantUploadFlow,
        periodicBackupFlow
    ) { manual, instant, periodic ->
        val manualIds = manual.map { it.id }.toSet()
        val manualItems = manual.mapNotNull { mapWorkInfoToUiItem(it, UploadType.ManualBackup) }
        val instantItems = instant.mapNotNull { mapWorkInfoToUiItem(it, UploadType.Instant) }
        // Filter periodic to exclude items already in manual (they share the same worker class)
        val periodicItems = periodic
            .filter { it.id !in manualIds }
            .mapNotNull { mapWorkInfoToUiItem(it, UploadType.AutoBackup) }
        manualItems + instantItems + periodicItems
    }

    // Queued Photos (from DB — not yet uploaded)
    val queuedPhotos: StateFlow<List<Photo>> = DbHolder.database.photoDao().getAllNotUploadedFlow()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    // All uploads sorted by status
    val allUploads: StateFlow<List<UploadUiItem>> = allWorkFlow.map { items ->
        items.sortedWith(compareByDescending<UploadUiItem> { it.status == UploadStatus.InProgress }
            .thenByDescending { it.status == UploadStatus.Queued }
            .thenByDescending { it.status == UploadStatus.Failed })
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    // Manual uploads only (manual backup + instant uploads by user)
    val manualUploads: StateFlow<List<UploadUiItem>> = allWorkFlow.map { items ->
        items.filter { it.type == UploadType.ManualBackup || it.type == UploadType.Instant }
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    // Auto backup uploads only
    val autoBackupUploads: StateFlow<List<UploadUiItem>> = allWorkFlow.map { items ->
        items.filter { it.type == UploadType.AutoBackup }
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    // Failed uploads only
    val failedUploads: StateFlow<List<UploadUiItem>> = allWorkFlow.map { items ->
        items.filter { it.status == UploadStatus.Failed }
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    // Synced/Completed uploads only
    val syncedUploads: StateFlow<List<UploadUiItem>> = allWorkFlow.map { items ->
        items.filter { it.status == UploadStatus.Completed }
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    private fun mapWorkInfoToUiItem(workInfo: WorkInfo, type: UploadType): UploadUiItem? {
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

        when (type) {
            UploadType.ManualBackup, UploadType.AutoBackup -> {
                val current = progressData.getInt(PeriodicPhotoBackupWorker.KEY_PROGRESS_CURRENT, 0)
                val max = progressData.getInt(PeriodicPhotoBackupWorker.KEY_PROGRESS_MAX, 0)
                // Use progress URI if running, otherwise try output data (from success result)
                val currentUri = progressData.getString(PeriodicPhotoBackupWorker.KEY_CURRENT_FILE_URI)
                    ?: outputData.getString(PeriodicPhotoBackupWorker.KEY_CURRENT_FILE_URI)

                totalItems = if (max > 0) max else 1
                progress = if (max > 0) current.toFloat() / max.toFloat() else 0f
                progressText = when {
                    status == UploadStatus.InProgress && max > 0 -> "Uploading $current of $max photos"
                    status == UploadStatus.InProgress -> "Preparing..."
                    status == UploadStatus.Completed -> "All photos uploaded"
                    status == UploadStatus.Failed -> "Upload failed — tap to retry"
                    status == UploadStatus.Cancelled -> "Cancelled"
                    else -> "Waiting to start..."
                }
                thumbnailUri = currentUri?.ifEmpty { null }
                fileName = if (type == UploadType.ManualBackup) "Manual Backup" else "Auto Backup"
            }
            UploadType.Instant -> {
                // Get the photo URI from input data via progress or output
                val inputUri = workInfo.progress.getString(InstantPhotoUploadWorker.KEY_PHOTO_URI)
                thumbnailUri = inputUri
                    ?: workInfo.outputData.getString(InstantPhotoUploadWorker.KEY_PHOTO_URI)
                localPhotoId = thumbnailUri // The URI can be used to look up the photo

                progress = if (status == UploadStatus.Completed) 1f else 0f
                progressText = when (status) {
                    UploadStatus.InProgress -> "Uploading photo..."
                    UploadStatus.Completed -> "Uploaded successfully"
                    UploadStatus.Failed -> "Upload failed — will auto retry"
                    UploadStatus.Cancelled -> "Cancelled"
                    else -> "Waiting to start..."
                }
                fileName = "Single Photo Upload"
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
        if (failed.any { it.type == UploadType.ManualBackup || it.type == UploadType.AutoBackup }) {
            WorkModule.PeriodicBackup.enqueue()
        }
        // 2. Retry instant uploads (WorkManager retry logic handles this, but if cancelled we might need to re-enqueue. 
        // Simple retry for now is relying on WorkManager's auto-retry or re-enqueuing if we had the URI, 
        // but re-enqueuing requires keeping track of URIs which we don't fully do here yet apart from observing.
        // For now, retryAll primarily triggers the main backup worker which picks up queued items.)
    }
}
