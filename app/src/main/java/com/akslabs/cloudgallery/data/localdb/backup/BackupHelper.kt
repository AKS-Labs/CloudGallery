package com.akslabs.cloudgallery.data.localdb.backup

import android.content.Context
import android.net.Uri
import android.util.Log
import com.akslabs.cloudgallery.R
import com.akslabs.cloudgallery.api.BotApi
import com.akslabs.cloudgallery.data.localdb.DbHolder
import com.akslabs.cloudgallery.data.localdb.Preferences
import com.akslabs.cloudgallery.utils.toastFromMainThread
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File
import java.text.SimpleDateFormat
import java.util.*
import androidx.documentfile.provider.DocumentFile

object BackupHelper {
    const val JSON_MIME = "application/json"
    private const val TAG = "BackupHelper"
    private const val DATABASE_BACKUP_PREFIX = "CloudGallery_Backup"

    private val mapper by lazy {
        ObjectMapper().apply {
            // Configure to ignore unknown fields during deserialization
            // This makes import robust against schema changes
            configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
        }
    }

    suspend fun exportDatabase(uri: Uri, context: Context) {
        try {
            val deviceId = Preferences.getOrCreateDeviceId()
            val deviceName = Preferences.getDeviceName()
            val photos = DbHolder.database.photoDao().getAll()
            val remotePhotos = DbHolder.database.remotePhotoDao().getAllIncludingDeleted()
            val backupFile = BackupFile(
                version = 2,
                deviceId = deviceId,
                deviceName = deviceName,
                createdAt = System.currentTimeMillis(),
                photos = photos,
                remotePhotos = remotePhotos
            )
            
            // Handle both specific file URIs and directory (tree) URIs
            val targetUri = if (uri.toString().contains("tree")) {
                val directory = DocumentFile.fromTreeUri(context, uri)
                val dateFormat = SimpleDateFormat("yyyy-MM-dd_hh-mm-a", Locale.getDefault())
                val timestamp = dateFormat.format(Date())
                val fileName = "CloudGallery_Backup_${deviceId}_$timestamp.json"
                directory?.createFile(JSON_MIME, fileName)?.uri
            } else {
                uri
            }

            if (targetUri == null) {
                Log.e(TAG, "Failed to resolve target URI for export")
                return
            }

            context.contentResolver.openOutputStream(targetUri, "wt")?.use {
                val favoritesJson = mapper.writeValueAsBytes(backupFile)
                it.write(favoritesJson)
            }
            context.toastFromMainThread(context.getString(R.string.export_successful))
        } catch (e: Exception) {
            context.toastFromMainThread(e.localizedMessage)
            Log.d("Export All Photos", "doWork: ${e.localizedMessage}")
        }
    }

    /**
     * Import database backup with device-aware merge:
     * - Same device: full import (photos + remotePhotos)
     * - Different device: only merge remotePhotos (skip photos to avoid localId collisions)
     */
    suspend fun importDatabase(uri: Uri, context: Context) {
        try {
            context.contentResolver.openInputStream(uri)?.use {
                val backupFile = mapper.readValue(it.readBytes(), BackupFile::class.java)
                val currentDeviceId = Preferences.getOrCreateDeviceId()
                val isSameDevice = backupFile.deviceId.isEmpty() || backupFile.deviceId == currentDeviceId

                if (isSameDevice) {
                    // Same device — full import
                    Log.i(TAG, "Importing from same device (${backupFile.deviceId}): full import")
                    DbHolder.database.photoDao().insertPhotos(*backupFile.photos.toTypedArray())
                    DbHolder.database.remotePhotoDao().insertAllIfNotExists(
                        *backupFile.remotePhotos.toTypedArray()
                    )
                } else {
                    // Different device — only merge remotePhotos to avoid localId collisions
                    Log.i(TAG, "Importing from different device (${backupFile.deviceId} → $currentDeviceId): remotePhotos only")
                    DbHolder.database.remotePhotoDao().insertAllIfNotExists(
                        *backupFile.remotePhotos.toTypedArray()
                    )
                }
            }
            context.toastFromMainThread(context.getString(R.string.import_successful))
        } catch (e: Exception) {
            Log.d("Import All Photos", "doWork: ${e.localizedMessage}")
            context.toastFromMainThread(e.localizedMessage)
        }
    }

    /**
     * Upload database backup to Telegram with device metadata
     */
    suspend fun uploadDatabaseToTelegram(context: Context): Result<String> {
        return withContext(Dispatchers.IO) {
            try {
                Log.i(TAG, "=== UPLOADING DATABASE TO TELEGRAM ===")

                val channelId = Preferences.getEncryptedLong(Preferences.channelId, 0L)
                if (channelId == 0L) {
                    return@withContext Result.failure(Exception("No Telegram channel configured"))
                }

                val deviceId = Preferences.getOrCreateDeviceId()
                val deviceName = Preferences.getDeviceName()

                val photos = DbHolder.database.photoDao().getAll()
                val remotePhotos = DbHolder.database.remotePhotoDao().getAllIncludingDeleted()
                val backupFile = BackupFile(
                    version = 2,
                    deviceId = deviceId,
                    deviceName = deviceName,
                    createdAt = System.currentTimeMillis(),
                    photos = photos,
                    remotePhotos = remotePhotos
                )

                Log.i(TAG, "Database backup created: ${photos.size} photos, ${remotePhotos.size} remote photos (device: $deviceId)")

                val backupJson = mapper.writeValueAsBytes(backupFile)

                val dateFormat = SimpleDateFormat("yyyy-MM-dd_hh-mm-a", Locale.getDefault())
                val timestamp = dateFormat.format(Date())
                val fileName = "${DATABASE_BACKUP_PREFIX}_${deviceId}_$timestamp.json"

                val tempFile = File(context.cacheDir, fileName)
                tempFile.writeBytes(backupJson)

                Log.i(TAG, "Created backup file: $fileName (${tempFile.length()} bytes)")

                // Upload with device tag in caption
                val caption = "#db_backup #device:$deviceId $deviceName"
                Log.i(TAG, "Uploading to Telegram channel: $channelId")
                val uploadResult = BotApi.sendFile(tempFile, channelId, caption)

                val (response, error) = uploadResult
                if (error != null) {
                    Log.e(TAG, "❌ Failed to upload database backup", error)
                    tempFile.delete()
                    Result.failure(error)
                } else {
                    val document = response?.body()?.result?.document
                    if (document != null) {
                        Log.i(TAG, "✅ Database backup uploaded successfully: ${document.fileId}")

                        Preferences.edit {
                            putString("last_database_backup_file_id", document.fileId)
                            putString("last_database_backup_filename", fileName)
                            putLong("last_database_backup_timestamp", System.currentTimeMillis())
                            putLong("last_database_backup_photos", photos.size.toLong())
                            putLong("last_database_backup_remote_photos", remotePhotos.size.toLong())
                        }

                        tempFile.delete()
                        Result.success("Database uploaded to Telegram: $fileName")
                    } else {
                        tempFile.delete()
                        Result.failure(Exception("Upload failed: No document in response"))
                    }
                }

            } catch (e: Exception) {
                Log.e(TAG, "Exception uploading database to Telegram", e)
                Result.failure(e)
            }
        }
    }

    /**
     * Download and import database backup from Telegram with device-aware merge
     */
    suspend fun downloadDatabaseFromTelegram(fileId: String, context: Context): Result<String> {
        return withContext(Dispatchers.IO) {
            try {
                Log.i(TAG, "=== DOWNLOADING DATABASE FROM TELEGRAM ===")
                Log.i(TAG, "Downloading backup file: $fileId")

                val fileBytes = BotApi.getFile(fileId)
                if (fileBytes == null) {
                    return@withContext Result.failure(Exception("Failed to download backup file"))
                }

                val backupFile = mapper.readValue(fileBytes, BackupFile::class.java)
                val currentDeviceId = Preferences.getOrCreateDeviceId()
                val isSameDevice = backupFile.deviceId.isEmpty() || backupFile.deviceId == currentDeviceId

                Log.i(TAG, "Database backup downloaded: ${backupFile.photos.size} photos, ${backupFile.remotePhotos.size} remote photos (from device: ${backupFile.deviceId})")

                if (isSameDevice) {
                    Log.i(TAG, "Importing from same device (${backupFile.deviceId}): full import")
                    DbHolder.database.photoDao().insertPhotos(*backupFile.photos.toTypedArray())
                    DbHolder.database.remotePhotoDao().insertAllIfNotExists(*backupFile.remotePhotos.toTypedArray())
                } else {
                    Log.i(TAG, "Importing from different device (${backupFile.deviceId} → $currentDeviceId): remotePhotos only")
                    DbHolder.database.remotePhotoDao().insertAllIfNotExists(*backupFile.remotePhotos.toTypedArray())
                }

                Log.i(TAG, "✅ Database imported successfully")

                Preferences.edit {
                    putLong("last_database_import_timestamp", System.currentTimeMillis())
                    putLong("last_database_import_photos", backupFile.photos.size.toLong())
                    putLong("last_database_import_remote_photos", backupFile.remotePhotos.size.toLong())
                }

                val importType = if (isSameDevice) "full" else "remotePhotos only"
                Result.success("Database imported ($importType): ${backupFile.photos.size} photos, ${backupFile.remotePhotos.size} remote photos")

            } catch (e: Exception) {
                Log.e(TAG, "Exception downloading database from Telegram", e)
                Result.failure(e)
            }
        }
    }

    /**
     * Check if database backup is up to date
     */
    suspend fun isDatabaseBackupUpToDate(
        currentPhotos: Int? = null,
        currentRemotePhotos: Int? = null
    ): Boolean {
        return withContext(Dispatchers.IO) {
            try {
                val lastBackupTimestamp = Preferences.getLong("last_database_backup_timestamp", 0L)
                val lastBackupPhotos = Preferences.getLong("last_database_backup_photos", 0L).toInt()
                val lastBackupRemotePhotos = Preferences.getLong("last_database_backup_remote_photos", 0L).toInt()

                val photosCount = currentPhotos ?: DbHolder.database.photoDao().getCount()
                val remotePhotosCount = currentRemotePhotos ?: DbHolder.database.remotePhotoDao().getCount()

                val hasBackup = lastBackupTimestamp > 0
                val dataUnchanged = (photosCount == lastBackupPhotos && remotePhotosCount == lastBackupRemotePhotos)

                Log.d(TAG, "Backup status - Has backup: $hasBackup, Data unchanged: $dataUnchanged")
                Log.d(TAG, "Current: $photosCount photos, $remotePhotosCount remote | Last backup: $lastBackupPhotos photos, $lastBackupRemotePhotos remote")

                hasBackup && dataUnchanged

            } catch (e: Exception) {
                Log.e(TAG, "Error checking backup status", e)
                false
            }
        }
    }

    fun shouldCreateDailyBackup(): Boolean {
        val lastBackup = Preferences.getLong("last_database_backup_timestamp", 0L)
        val oneDayAgo = System.currentTimeMillis() - (24 * 60 * 60 * 1000)
        return lastBackup < oneDayAgo
    }

    suspend fun getBackupStats(): BackupStats {
        return withContext(Dispatchers.IO) {
            val lastBackupTime = Preferences.getLong("last_database_backup_timestamp", 0L)
            val lastBackupFilename = Preferences.getString("last_database_backup_filename", "")
            val lastImportTime = Preferences.getLong("last_database_import_timestamp", 0L)
            
            val currentPhotos = DbHolder.database.photoDao().getCount()
            val currentRemotePhotos = DbHolder.database.remotePhotoDao().getCount()
            
            val isUpToDate = isDatabaseBackupUpToDate(currentPhotos, currentRemotePhotos)

            BackupStats(
                lastBackupTime = lastBackupTime,
                lastBackupFilename = lastBackupFilename,
                lastImportTime = lastImportTime,
                currentPhotos = currentPhotos,
                currentRemotePhotos = currentRemotePhotos,
                isUpToDate = isUpToDate,
                needsDailyBackup = shouldCreateDailyBackup()
            )
        }
    }

    data class BackupStats(
        val lastBackupTime: Long,
        val lastBackupFilename: String,
        val lastImportTime: Long,
        val currentPhotos: Int,
        val currentRemotePhotos: Int,
        val isUpToDate: Boolean,
        val needsDailyBackup: Boolean
    )
}
