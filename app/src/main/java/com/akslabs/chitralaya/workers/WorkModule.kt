package com.akslabs.cloudgallery.workers

import android.content.Context
import android.net.Uri
import android.provider.MediaStore
import androidx.work.BackoffPolicy
import androidx.work.Constraints
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.ExistingWorkPolicy
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.OutOfQuotaPolicy
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.workDataOf
import com.akslabs.cloudgallery.data.localdb.Preferences
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import java.time.Duration

object WorkModule {
    private lateinit var manager: WorkManager
    fun create(applicationContext: Context) {
        manager = WorkManager.getInstance(applicationContext)
    }

    object PeriodicBackup {

        private fun getConstraints(): Constraints {
            return Constraints.Builder()
                .setRequiredNetworkType(
                    NetworkType.valueOf(
                        Preferences.getString(
                            Preferences.autoBackupNetworkTypeKey,
                            NetworkType.CONNECTED.name
                        )
                    )
                )
                .build()
        }

        private fun getRepeatIntervalDays(): Long {
            return Preferences.getString(
                Preferences.autoBackupIntervalKey,
                Preferences.defaultAutoBackupInterval.toString()
            ).toLong()
        }

        fun enqueue(forceUpdate: Boolean = false, onlySchedule: Boolean = false) {
            val constraints = getConstraints()
            val repeatIntervalDays = getRepeatIntervalDays()

            // 1️⃣ Immediate one-time backup
            if (!onlySchedule) {
                val instantBackupRequest =
                    OneTimeWorkRequestBuilder<PeriodicPhotoBackupWorker>()
                        .setInputData(
                            workDataOf(PeriodicPhotoBackupWorker.KEY_COMPRESSION_THRESHOLD to 1024 * 50L)
                        )
                        .setConstraints(constraints)
                        .setExpedited(OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST)
                        .build()

                manager.enqueueUniqueWork(
                    "InstantPhotoBackupWork",
                    ExistingWorkPolicy.REPLACE,
                    instantBackupRequest
                )
            }

            // 2️⃣ Periodic backup with current preferences
            val periodicUploadWorkRequest =
                PeriodicWorkRequestBuilder<PeriodicPhotoBackupWorker>(Duration.ofDays(repeatIntervalDays))
                    .setInputData(
                        workDataOf(PeriodicPhotoBackupWorker.KEY_COMPRESSION_THRESHOLD to 1024 * 50L)
                    )
                    .setConstraints(constraints)
                    .setInitialDelay(Duration.ofDays(1))
                    .setBackoffCriteria(
                        backoffPolicy = BackoffPolicy.LINEAR,
                        duration = Duration.ofMinutes(40)
                    )
                    .build()

            manager.enqueueUniquePeriodicWork(
                PERIODIC_PHOTO_BACKUP_WORK,
                if (forceUpdate) ExistingPeriodicWorkPolicy.UPDATE else ExistingPeriodicWorkPolicy.KEEP,
                periodicUploadWorkRequest
            )
        }

        fun cancel() {
            manager.cancelUniqueWork(PERIODIC_PHOTO_BACKUP_WORK)
        }
    }

    object SyncMediaStore {

        private val periodicSyncMediaStoreRequest =
            PeriodicWorkRequestBuilder<SyncDbMediaStoreWorker>(Duration.ofDays(1))
                .setInitialDelay(Duration.ofDays(1))
                .setBackoffCriteria(
                    backoffPolicy = BackoffPolicy.LINEAR,
                    duration = Duration.ofMinutes(40)
                )
                .build()

        private val instantSyncMediaStoreRequest =
            OneTimeWorkRequestBuilder<SyncDbMediaStoreWorker>()
                .setExpedited(OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST)
                .build()

        fun enqueuePeriodic() {
            manager.enqueueUniquePeriodicWork(
                SYNC_MEDIA_STORE_WORK,
                ExistingPeriodicWorkPolicy.KEEP,
                periodicSyncMediaStoreRequest
            )
        }

        fun enqueueInstant() {
            manager.enqueueUniqueWork(
                SYNC_MEDIA_STORE_WORK,
                ExistingWorkPolicy.REPLACE,
                instantSyncMediaStoreRequest
            )
        }

        fun cancel() {
            manager.cancelUniqueWork(SYNC_MEDIA_STORE_WORK)
        }
    }

    class InstantUpload(private val uri: Uri) {

        private val constraints: Constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()

        private val instantUploadRequest =
            OneTimeWorkRequestBuilder<InstantPhotoUploadWorker>()
                .setExpedited(OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST)
                .setInputData(
                    workDataOf(InstantPhotoUploadWorker.KEY_PHOTO_URI to uri.toString())
                )
                .setConstraints(constraints)
                .addTag("instant_upload")
                .build()

        fun enqueue() {
            manager.enqueueUniqueWork(
                "$UPLOADING_ID:${uri.lastPathSegment}",
                ExistingWorkPolicy.KEEP,
                instantUploadRequest
            )
        }

        fun cancel() {
            manager.cancelUniqueWork("$UPLOADING_ID:${uri.lastPathSegment}")
        }
    }

    class InstantDownload(private val remoteId: String, private val forceDownload: Boolean = false) {

        private val constraints: Constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()

        private val instantDownloadRequest =
            OneTimeWorkRequestBuilder<InstantPhotoDownloadWorker>()
                .setExpedited(OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST)
                .setInputData(
                    workDataOf(
                        InstantPhotoDownloadWorker.KEY_REMOTE_ID to remoteId,
                        InstantPhotoDownloadWorker.KEY_FORCE_DOWNLOAD to forceDownload
                    )
                )
                .setConstraints(constraints)
                .build()

        fun enqueue() {
            manager.enqueueUniqueWork(
                "$DOWNLOADING_ID:$remoteId",
                if (forceDownload) ExistingWorkPolicy.REPLACE else ExistingWorkPolicy.KEEP,
                instantDownloadRequest
            )
        }

        fun cancel() {
            manager.cancelUniqueWork("$DOWNLOADING_ID:$remoteId")
        }
    }

    object RestoreMissingFromDevice {

        private val constraints: Constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()

        private val instantUploadRequest =
            OneTimeWorkRequestBuilder<DownloadMissingPhotosWorker>()
                .setExpedited(OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST)
                .setConstraints(constraints)
                .build()

        fun enqueue() {
            manager.enqueueUniqueWork(
                RESTORE_ALL_PHOTOS_WORK,
                ExistingWorkPolicy.KEEP,
                instantUploadRequest
            )
        }

        fun cancel() {
            manager.cancelUniqueWork(RESTORE_ALL_PHOTOS_WORK)
        }
    }

    object PeriodicDbExport {

        private val repeatIntervalDays = Preferences.getString(
            Preferences.autoExportDatabaseIntervalKey,
            Preferences.defaultAutoBackupInterval.toString()
        ).toLong()

        private val uri = Preferences.getString(
            Preferences.autoExportDatabseLocation,
            MediaStore.Downloads.EXTERNAL_CONTENT_URI.toString()
        )

        private val periodicDbExportRequest =
            PeriodicWorkRequestBuilder<PeriodicDbExportWorker>(Duration.ofDays(repeatIntervalDays))
                .setInputData(
                    workDataOf(PeriodicDbExportWorker.KEY_URI to uri)
                )
                .setBackoffCriteria(
                    backoffPolicy = BackoffPolicy.EXPONENTIAL,
                    duration = Duration.ofMinutes(10)
                )
                .build()

        fun enqueue(forceUpdate: Boolean = false) {
            manager.enqueueUniquePeriodicWork(
                PERIODIC_DB_EXPORT_WORK,
                if (forceUpdate) ExistingPeriodicWorkPolicy.UPDATE else ExistingPeriodicWorkPolicy.KEEP,
                periodicDbExportRequest
            )
        }

        fun cancel() {
            manager.cancelUniqueWork(PERIODIC_DB_EXPORT_WORK)
        }
    }

    object CloudPhotoSync {
        private val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .setRequiresBatteryNotLow(true)
            .build()

        private val periodicCloudSyncRequest =
            PeriodicWorkRequestBuilder<CloudPhotoSyncWorker>(Duration.ofDays(1))
                .setConstraints(constraints)
                .setInitialDelay(Duration.ofMinutes(30)) // Wait 30 minutes after app install
                .setBackoffCriteria(BackoffPolicy.EXPONENTIAL, Duration.ofMinutes(15))
                .build()

        fun enqueue() {
            manager.enqueueUniquePeriodicWork(
                CLOUD_PHOTO_SYNC_WORK,
                ExistingPeriodicWorkPolicy.KEEP,
                periodicCloudSyncRequest
            )
        }

        fun cancel() {
            manager.cancelUniqueWork(CLOUD_PHOTO_SYNC_WORK)
        }

        fun enqueueOneTime() {
            val oneTimeRequest = OneTimeWorkRequestBuilder<CloudPhotoSyncWorker>()
                .setConstraints(constraints)
                .setBackoffCriteria(BackoffPolicy.EXPONENTIAL, Duration.ofMinutes(5))
                .build()

            manager.enqueueUniqueWork(
                CLOUD_PHOTO_SYNC_ONE_TIME_WORK,
                ExistingWorkPolicy.REPLACE,
                oneTimeRequest
            )
        }
    }

    object QuickCloudSync {
        private val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()

        private val periodicQuickSyncRequest =
            PeriodicWorkRequestBuilder<QuickCloudSyncWorker>(Duration.ofHours(6))
                .setConstraints(constraints)
                .setInitialDelay(Duration.ofHours(1))
                .build()

        fun enqueue() {
            manager.enqueueUniquePeriodicWork(
                QUICK_CLOUD_SYNC_WORK,
                ExistingPeriodicWorkPolicy.KEEP,
                periodicQuickSyncRequest
            )
        }

        fun cancel() {
            manager.cancelUniqueWork(QUICK_CLOUD_SYNC_WORK)
        }
    }

    object DailyDatabaseBackup {
        private val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()

        private val dailyBackupRequest = PeriodicWorkRequestBuilder<DailyDatabaseBackupWorker>(
            Duration.ofDays(1)
        )
            .setConstraints(constraints)
            .setInitialDelay(Duration.ofHours(1)) // Start 1 hour after app install
            .build()

        fun enqueuePeriodic() {
            manager.enqueueUniquePeriodicWork(
                DAILY_DATABASE_BACKUP_WORK,
                ExistingPeriodicWorkPolicy.KEEP,
                dailyBackupRequest
            )
        }

        fun cancel() {
            manager.cancelUniqueWork(DAILY_DATABASE_BACKUP_WORK)
        }
    }

    fun observeWorkerByName(name: String) = manager.getWorkInfosForUniqueWorkFlow(name)
        .flowOn(Dispatchers.IO)

    fun observeWorkerByTag(tag: String) = manager.getWorkInfosByTagFlow(tag)
        .flowOn(Dispatchers.IO)

    const val PERIODIC_PHOTO_BACKUP_WORK = "PeriodicPhotoBackupWork"
    const val SYNC_MEDIA_STORE_WORK = "SyncMediaStoreWork"
    const val RESTORE_ALL_PHOTOS_WORK = "RestoreAllPhotosWork"
    const val PERIODIC_DB_EXPORT_WORK = "PeriodicDbExportWork"
    const val CLOUD_PHOTO_SYNC_WORK = "CloudPhotoSyncWork"
    const val CLOUD_PHOTO_SYNC_ONE_TIME_WORK = "CloudPhotoSyncOneTimeWork"
    const val QUICK_CLOUD_SYNC_WORK = "QuickCloudSyncWork"
    const val DAILY_DATABASE_BACKUP_WORK = "DailyDatabaseBackupWork"
    const val UPLOADING_ID = "UploadingId"
    const val DOWNLOADING_ID = "DownloadingId"
    
    val VERBOSE_NOTIFICATION_CHANNEL_NAME: CharSequence = "Verbose WorkManager Notifications"
    const val VERBOSE_NOTIFICATION_CHANNEL_DESCRIPTION = "Shows notifications whenever work starts"
    val NOTIFICATION_TITLE: CharSequence = "Chitralaya"
    const val CHANNEL_ID = "VERBOSE_WHITE_HOLE_APP_NOTIFICATION"

    // Unique Notification IDs
    const val NOTIFICATION_ID_BACKUP = 101
    const val NOTIFICATION_ID_SYNC = 102
    const val NOTIFICATION_ID_DOWNLOAD = 103
    const val NOTIFICATION_ID_UPLOAD = 104
    const val NOTIFICATION_ID_EXPORT = 105
    const val NOTIFICATION_ID_GENERIC = 100
    
    @Deprecated("Use unique IDs instead")
    const val NOTIFICATION_ID = 1
}