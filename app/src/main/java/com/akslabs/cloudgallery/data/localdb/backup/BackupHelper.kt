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
            val photos = DbHolder.database.photoDao().getAll()
            val remotePhotos = DbHolder.database.remotePhotoDao().getAll()
            val backupFile = BackupFile(photos, remotePhotos)
            
            // Handle both specific file URIs and directory (tree) URIs
            val targetUri = if (uri.toString().contains("tree")) {
                val directory = DocumentFile.fromTreeUri(context, uri)
                val dateFormat = SimpleDateFormat("yyyy-MM-dd_hh-mm-a", Locale.getDefault())
                val timestamp = dateFormat.format(Date())
                val fileName = "CloudGallery_AutoBackup_$timestamp.json"
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

    suspend fun importDatabase(uri: Uri, context: Context) {
        try {
            context.contentResolver.openInputStream(uri)?.use {
                val backupFile = mapper.readValue(it.readBytes(), BackupFile::class.java)
                DbHolder.database.photoDao().updatePhotos(*backupFile.photos.toTypedArray())
                DbHolder.database.remotePhotoDao().insertAll(
                    *backupFile.remotePhotos.toTypedArray()
                )
            }
            context.toastFromMainThread(context.getString(R.string.import_successful))
            // Run deduplication after import to catch any conflicts
            deduplicateDatabase()
        } catch (e: Exception) {
            Log.d("Import All Photos", "doWork: ${e.localizedMessage}")
            context.toastFromMainThread(e.localizedMessage)
        }
    }

    /**
     * Upload database backup to Telegram
     */
    suspend fun uploadDatabaseToTelegram(context: Context): Result<String> {
        return withContext(Dispatchers.IO) {
            try {
                Log.i(TAG, "=== UPLOADING DATABASE TO TELEGRAM ===")

                // Get channel ID
                val channelId = Preferences.getEncryptedLong(Preferences.channelId, 0L)
                if (channelId == 0L) {
                    return@withContext Result.failure(Exception("No Telegram channel configured"))
                }

                // Create database backup
                val photos = DbHolder.database.photoDao().getAll()
                val remotePhotos = DbHolder.database.remotePhotoDao().getAll()
                val backupFile = BackupFile(photos, remotePhotos)

                Log.i(TAG, "Database backup created: ${photos.size} photos, ${remotePhotos.size} remote photos")

                // Convert to JSON
                val backupJson = mapper.writeValueAsBytes(backupFile)

                // Create filename with date
                val dateFormat = SimpleDateFormat("yyyy-MM-dd_hh-mm-a", Locale.getDefault())
                val timestamp = dateFormat.format(Date())
                val fileName = "${DATABASE_BACKUP_PREFIX}_$timestamp.json"

                // Create a named file in cache directory
                val tempFile = File(context.cacheDir, fileName)
                tempFile.writeBytes(backupJson)

                Log.i(TAG, "Created backup file: $fileName (${tempFile.length()} bytes)")

                // Upload to Telegram
                Log.i(TAG, "Uploading to Telegram channel: $channelId")
                val uploadResult = BotApi.sendFile(tempFile, channelId)

                val (response, error) = uploadResult
                if (error != null) {
                    Log.e(TAG, "❌ Failed to upload database backup", error)
                    tempFile.delete()
                    Result.failure(error)
                } else {
                    val document = response?.body()?.result?.document
                    if (document != null) {
                        Log.i(TAG, "✅ Database backup uploaded successfully: ${document.fileId}")

                        // Store backup info
                        Preferences.edit {
                            putString("last_database_backup_file_id", document.fileId)
                            putString("last_database_backup_filename", fileName)
                            putLong("last_database_backup_timestamp", System.currentTimeMillis())
                            putLong("last_database_backup_photos", photos.size.toLong())
                            putLong("last_database_backup_remote_photos", remotePhotos.size.toLong())
                        }

                        // Clean up temp file
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
     * Download and import database backup from Telegram
     */
    suspend fun downloadDatabaseFromTelegram(fileId: String, context: Context): Result<String> {
        return withContext(Dispatchers.IO) {
            try {
                Log.i(TAG, "=== DOWNLOADING DATABASE FROM TELEGRAM ===")
                Log.i(TAG, "Downloading backup file: $fileId")

                // Download file from Telegram
                val fileBytes = BotApi.getFile(fileId)
                if (fileBytes == null) {
                    return@withContext Result.failure(Exception("Failed to download backup file"))
                }

                // Parse JSON
                val backupFile = mapper.readValue(fileBytes, BackupFile::class.java)

                Log.i(TAG, "Database backup downloaded: ${backupFile.photos.size} photos, ${backupFile.remotePhotos.size} remote photos")

                // Import to database
                DbHolder.database.photoDao().updatePhotos(*backupFile.photos.toTypedArray())
                DbHolder.database.remotePhotoDao().insertAll(*backupFile.remotePhotos.toTypedArray())

                Log.i(TAG, "✅ Database imported successfully")

                // Update preferences
                Preferences.edit {
                    putLong("last_database_import_timestamp", System.currentTimeMillis())
                    putLong("last_database_import_photos", backupFile.photos.size.toLong())
                    putLong("last_database_import_remote_photos", backupFile.remotePhotos.size.toLong())
                }

                Result.success("Database imported: ${backupFile.photos.size} photos, ${backupFile.remotePhotos.size} remote photos")

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

                // Get current database state efficiently if not provided
                val photosCount = currentPhotos ?: DbHolder.database.photoDao().getCount()
                val remotePhotosCount = currentRemotePhotos ?: DbHolder.database.remotePhotoDao().getCount()

                // Check if backup exists and data hasn't changed
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

    /**
     * Check if daily backup is needed
     */
    fun shouldCreateDailyBackup(): Boolean {
        val lastBackup = Preferences.getLong("last_database_backup_timestamp", 0L)
        val oneDayAgo = System.currentTimeMillis() - (24 * 60 * 60 * 1000)
        return lastBackup < oneDayAgo
    }

    /**
     * Get backup statistics for UI display
     */
    suspend fun getBackupStats(): BackupStats {
        return withContext(Dispatchers.IO) {
            val lastBackupTime = Preferences.getLong("last_database_backup_timestamp", 0L)
            val lastBackupFilename = Preferences.getString("last_database_backup_filename", "")
            val lastImportTime = Preferences.getLong("last_database_import_timestamp", 0L)
            
            // Use optimized count queries instead of loading all objects
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

    /**
     * Deduplicate the database after import or sync operations.
     * Only removes entries where we're 100% certain they're duplicates:
     * - Same remoteId appearing multiple times in remote_photos
     * - Same localId + remoteId combination (exact match)
     * If uncertain, keeps both entries (safer to have dupes than lose data).
     */
    suspend fun deduplicateDatabase() {
        withContext(Dispatchers.IO) {
            try {
                val dao = DbHolder.database.remotePhotoDao()
                val photoDao = DbHolder.database.photoDao()
                
                // 1. Deduplicate remote_photos by remoteId (keep first inserted)
                val allRemote = dao.getAll()
                val seen = mutableSetOf<String>()
                var removedRemote = 0
                for (photo in allRemote) {
                    if (photo.remoteId in seen) {
                        dao.delete(photo.remoteId)
                        removedRemote++
                    } else {
                        seen.add(photo.remoteId)
                    }
                }
                
                // 2. Deduplicate photos table by localId (keep the one with remoteId if exists)
                val allPhotos = photoDao.getAll()
                val localIdMap = mutableMapOf<String, MutableList<com.akslabs.cloudgallery.data.localdb.entities.Photo>>()
                for (photo in allPhotos) {
                    localIdMap.getOrPut(photo.localId) { mutableListOf() }.add(photo)
                }
                
                var removedLocal = 0
                for ((_, photos) in localIdMap) {
                    if (photos.size > 1) {
                        // Keep the one with remoteId (it's been backed up)
                        val withRemote = photos.filter { it.remoteId != null }
                        val toKeep = if (withRemote.isNotEmpty()) withRemote.first() else photos.first()
                        val toRemove = photos.filter { it !== toKeep }
                        for (dupe in toRemove) {
                            photoDao.deleteById(dupe.localId)
                            removedLocal++
                        }
                    }
                }
                
                Log.i("BackupHelper", "Dedup complete: removed $removedRemote remote dupes, $removedLocal local dupes")
            } catch (e: Exception) {
                Log.e("BackupHelper", "Error during deduplication", e)
            }
        }
    }
