package com.akslabs.cloudgallery.services

import android.content.Context
import android.util.Log
import com.akslabs.cloudgallery.api.ScanConfig
import com.akslabs.cloudgallery.data.localdb.DbHolder
import com.akslabs.cloudgallery.data.localdb.Preferences
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import java.util.concurrent.TimeUnit

/**
 * Service responsible for synchronizing cloud photos between Telegram channel and local database
 * Handles both initial sync for new installations and periodic sync for updates
 */
object CloudPhotoSyncService {
    private const val TAG = "CloudPhotoSyncService"
    private const val LAST_SYNC_TIMESTAMP_KEY = "last_cloud_photo_sync_timestamp"
    private const val SYNC_INTERVAL_HOURS = 24 // Sync once per day
    
    /**
     * Perform a full synchronization of cloud photos
     * This includes discovering historical images and updating existing records
     */
    fun performFullSync(context: Context): Flow<com.akslabs.cloudgallery.api.ScanProgress> = flow {
        Log.i(TAG, "=== STARTING FULL CLOUD PHOTO SYNC ===")
        
        try {
            // Get the configured channel ID
            val channelId = getConfiguredChannelId()
            if (channelId == null) {
                Log.w(TAG, "No channel ID configured, skipping sync")
                Log.i(TAG, "To enable historical sync: Configure group/channel ID in app settings")
                emit(com.akslabs.cloudgallery.api.ScanProgress(
                    currentBatch = 0,
                    totalFilesFound = 0,
                    isComplete = true,
                    errorMessage = "No Telegram group/channel configured for backup."
                ))
                return@flow
            }
            
            Log.i(TAG, "Syncing with channel ID: $channelId")

            // IMPORTANT: Telegram Bot API Limitation Warning
            Log.w(TAG, "⚠️  TELEGRAM BOT API LIMITATION:")
            Log.w(TAG, "Bot API can only access messages from the last 24 hours")
            Log.w(TAG, "Historical images older than 24 hours cannot be retrieved via Bot API")
            Log.w(TAG, "This is a Telegram platform limitation, not an app bug")

            // Check if we need to perform sync
            if (!shouldPerformSync()) {
                Log.i(TAG, "Sync not needed (recent sync found)")
                emit(com.akslabs.cloudgallery.api.ScanProgress(
                    currentBatch = 0,
                    totalFilesFound = 0,
                    isComplete = true
                ))
                return@flow
            }
            
            // Get current database state
            val existingRemotePhotos = withContext(Dispatchers.IO) {
                DbHolder.database.remotePhotoDao().getAll()
            }
            Log.i(TAG, "Current database has ${existingRemotePhotos.size} RemotePhoto records")
            
            // Configure scan based on database state
            val scanConfig = if (existingRemotePhotos.isEmpty()) {
                // First time sync - scan everything
                Log.i(TAG, "Performing initial sync (empty database)")
                ScanConfig(
                    channelId = channelId,
                    batchSize = 50, // Smaller batches for initial sync
                    maxFiles = 5000, // Reasonable limit for initial sync
                    includePhotos = true,
                    includeDocuments = true,
                    includeVideos = true
                )
            } else {
                // Regular sync - look for recent additions
                Log.i(TAG, "Performing incremental sync")
                ScanConfig(
                    channelId = channelId,
                    batchSize = 100,
                    maxFiles = 1000, // Smaller limit for incremental sync
                    includePhotos = true,
                    includeDocuments = true,
                    includeVideos = true
                )
            }
            
            // Perform the discovery and sync
            HistoricalImageDiscoveryService.discoverAndSyncHistoricalImages(
                channelId = channelId,
                config = scanConfig
            ).collect { progress ->
                emit(progress)
            }
            
            // Update last sync timestamp
            updateLastSyncTimestamp()
            
            Log.i(TAG, "=== FULL CLOUD PHOTO SYNC COMPLETE ===")
            
        } catch (e: Exception) {
            Log.e(TAG, "Exception during full sync", e)
            emit(com.akslabs.cloudgallery.api.ScanProgress(
                currentBatch = 0,
                totalFilesFound = 0,
                isComplete = true,
                errorMessage = "Sync failed: ${e.message}"
            ))
        }
    }
    
    /**
     * Perform a quick sync to check for recent additions
     * This is lighter than full sync and can be run more frequently
     */
    suspend fun performQuickSync(context: Context): SyncResult {
        return withContext(Dispatchers.IO) {
            try {
                Log.d(TAG, "Performing quick sync")
                
                val channelId = getConfiguredChannelId()
                if (channelId == null) {
                    Log.w(TAG, "No channel ID configured for quick sync")
                    return@withContext SyncResult.NoChannelConfigured
                }
                
                // Quick scan of recent messages
                val scanConfig = ScanConfig(
                    channelId = channelId,
                    batchSize = 50,
                    maxFiles = 100,
                    includePhotos = true,
                    includeDocuments = true,
                    includeVideos = true
                )
                
                var totalNewFiles = 0
                HistoricalImageDiscoveryService.discoverAndSyncHistoricalImages(
                    channelId = channelId,
                    config = scanConfig
                ).collect { progress ->
                    if (progress.isComplete) {
                        totalNewFiles = progress.totalFilesFound
                    }
                }
                
                Log.d(TAG, "Quick sync complete: $totalNewFiles new files")
                SyncResult.Success(totalNewFiles)
                
            } catch (e: Exception) {
                Log.e(TAG, "Exception during quick sync", e)
                SyncResult.Error(e.message ?: "Unknown error")
            }
        }
    }
    
    /**
     * Check if a sync should be performed based on last sync timestamp
     */
    private fun shouldPerformSync(): Boolean {
        val lastSyncTimestamp = Preferences.getString(LAST_SYNC_TIMESTAMP_KEY, "0").toLongOrNull() ?: 0L
        val currentTime = System.currentTimeMillis()
        val timeSinceLastSync = currentTime - lastSyncTimestamp
        val syncIntervalMs = TimeUnit.HOURS.toMillis(SYNC_INTERVAL_HOURS.toLong())

        val shouldSync = timeSinceLastSync > syncIntervalMs
        Log.d(TAG, "Last sync: $lastSyncTimestamp, Current: $currentTime, Should sync: $shouldSync")
        return shouldSync
    }
    
    /**
     * Update the last sync timestamp
     */
    private fun updateLastSyncTimestamp() {
        val currentTime = System.currentTimeMillis()
        Preferences.edit {
            putString(LAST_SYNC_TIMESTAMP_KEY, currentTime.toString())
        }
        Log.d(TAG, "Updated last sync timestamp to: $currentTime")
    }
    
    /**
     * Get the configured Telegram channel ID from preferences
     */
    private suspend fun getConfiguredChannelId(): Long? {
        return withContext(Dispatchers.IO) {
            try {
                // First try to get the configured group/channel ID from encrypted preferences
                // This is where the user's images are actually stored
                val groupChannelId = Preferences.getEncryptedLong(Preferences.channelId, 0L)

                if (groupChannelId != 0L) {
                    Log.d(TAG, "Found configured group/channel ID: $groupChannelId")
                    return@withContext groupChannelId
                }

                Log.w(TAG, "No group/channel ID configured in preferences")

                // Fallback: try to get from BotApi (direct bot chat)
                var botChatId = com.akslabs.cloudgallery.api.BotApi.chatId

                if (botChatId == null) {
                    Log.d(TAG, "BotApi.chatId is null, trying to get from preferences")

                    // Try to get from stored preferences (if we stored it previously)
                    val storedChatId = Preferences.getString("telegram_chat_id", "")
                    if (storedChatId.isNotEmpty()) {
                        botChatId = storedChatId.toLongOrNull()
                        Log.d(TAG, "Found stored bot chat ID: $botChatId")
                    }
                }

                if (botChatId == null) {
                    Log.w(TAG, "No chat ID available. User may need to configure group/channel ID or send /start to bot first")
                }

                botChatId
            } catch (e: Exception) {
                Log.e(TAG, "Error getting configured channel ID", e)
                null
            }
        }
    }
    
    /**
     * Force a sync regardless of timestamp (for manual sync)
     */
    fun forceSync(context: Context): Flow<com.akslabs.cloudgallery.api.ScanProgress> = flow {
        Log.i(TAG, "Force sync requested")
        // Reset last sync timestamp to force sync
        Preferences.edit {
            putString(LAST_SYNC_TIMESTAMP_KEY, "0")
        }

        // Perform full sync
        performFullSync(context).collect { progress ->
            emit(progress)
        }
    }

    /**
     * Test if historical sync is properly configured
     */
    suspend fun testSyncConfiguration(): String {
        return withContext(Dispatchers.IO) {
            try {
                val groupChannelId = Preferences.getEncryptedLong(Preferences.channelId, 0L)
                val botChatId = com.akslabs.cloudgallery.api.BotApi.chatId

                return@withContext when {
                    groupChannelId != 0L -> {
                        "✅ Group/Channel ID configured: $groupChannelId. Ready for historical sync."
                    }
                    botChatId != null -> {
                        "⚠️ Using bot chat ID: $botChatId. Consider configuring group/channel for better organization."
                    }
                    else -> {
                        "❌ No Telegram group/channel configured. Please set up your backup destination."
                    }
                }
            } catch (e: Exception) {
                "❌ Error checking configuration: ${e.message}"
            }
        }
    }
    
    /**
     * Get sync statistics
     */
    suspend fun getSyncStatistics(): SyncStatistics {
        return withContext(Dispatchers.IO) {
            try {
                val totalRemotePhotos = DbHolder.database.remotePhotoDao().getAll().size
                val lastSyncTimestamp = Preferences.getString(LAST_SYNC_TIMESTAMP_KEY, "0").toLongOrNull() ?: 0L
                val timeSinceLastSync = System.currentTimeMillis() - lastSyncTimestamp
                
                SyncStatistics(
                    totalCloudPhotos = totalRemotePhotos,
                    lastSyncTimestamp = lastSyncTimestamp,
                    timeSinceLastSyncMs = timeSinceLastSync,
                    isSyncOverdue = timeSinceLastSync > TimeUnit.HOURS.toMillis(SYNC_INTERVAL_HOURS.toLong())
                )
            } catch (e: Exception) {
                Log.e(TAG, "Error getting sync statistics", e)
                SyncStatistics(0, 0L, 0L, true)
            }
        }
    }
}

/**
 * Result of a sync operation
 */
sealed class SyncResult {
    data class Success(val newFilesFound: Int) : SyncResult()
    data class Error(val message: String) : SyncResult()
    object NoChannelConfigured : SyncResult()
}

/**
 * Statistics about the sync state
 */
data class SyncStatistics(
    val totalCloudPhotos: Int,
    val lastSyncTimestamp: Long,
    val timeSinceLastSyncMs: Long,
    val isSyncOverdue: Boolean
)
