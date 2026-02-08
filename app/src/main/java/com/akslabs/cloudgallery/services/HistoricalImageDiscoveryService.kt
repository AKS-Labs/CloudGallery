package com.akslabs.cloudgallery.services

import android.util.Log
import com.akslabs.cloudgallery.api.BotApi
import com.akslabs.cloudgallery.api.ChannelScanResult
import com.akslabs.cloudgallery.api.DiscoveredMediaFile
import com.akslabs.cloudgallery.api.ScanConfig
import com.akslabs.cloudgallery.api.ScanProgress
import com.akslabs.cloudgallery.data.localdb.DbHolder
import com.akslabs.cloudgallery.data.localdb.entities.RemotePhoto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext

/**
 * Service responsible for discovering historical images from Telegram channel
 * and synchronizing them with the local RemotePhoto database
 */
object HistoricalImageDiscoveryService {
    private const val TAG = "HistoricalImageDiscovery"
    
    /**
     * Discover all historical images from the Telegram channel and sync to database
     * Returns a Flow that emits progress updates during the scanning process
     */
    fun discoverAndSyncHistoricalImages(
        channelId: Long,
        config: ScanConfig = ScanConfig(channelId)
    ): Flow<ScanProgress> = flow {
        Log.i(TAG, "=== STARTING HISTORICAL IMAGE DISCOVERY ===")
        Log.i(TAG, "Channel ID: $channelId")
        Log.i(TAG, "Config: $config")
        
        try {
            // Get existing RemotePhoto records to avoid duplicates
            val existingRemoteIds = withContext(Dispatchers.IO) {
                DbHolder.database.remotePhotoDao().getAll().map { it.remoteId }.toSet()
            }
            Log.i(TAG, "Found ${existingRemoteIds.size} existing RemotePhoto records")
            
            var currentBatch = 0
            var totalFilesFound = 0
            var nextOffset: Long? = null
            val newRemotePhotos = mutableListOf<RemotePhoto>()
            
            do {
                currentBatch++
                Log.d(TAG, "Processing batch $currentBatch (offset: $nextOffset)")
                
                // Emit progress update
                emit(ScanProgress(
                    currentBatch = currentBatch,
                    totalFilesFound = totalFilesFound,
                    isComplete = false
                ))
                
                // Scan the channel for media files
                val scanResult = BotApi.scanChannelForMedia(
                    channelId = channelId,
                    limit = config.batchSize,
                    offsetMessageId = nextOffset
                )
                
                when (scanResult) {
                    is ChannelScanResult.Success -> {
                        Log.d(TAG, "Batch $currentBatch: Found ${scanResult.mediaFiles.size} media files")
                        
                        // Filter and process discovered media files
                        val filteredFiles = scanResult.mediaFiles.filter { mediaFile ->
                            // Skip if already exists in database
                            if (mediaFile.fileId in existingRemoteIds) {
                                Log.v(TAG, "Skipping existing file: ${mediaFile.fileId}")
                                return@filter false
                            }
                            
                            // Apply config filters
                            when {
                                mediaFile.isImage() && !config.includePhotos -> false
                                mediaFile.isVideo() && !config.includeVideos -> false
                                !mediaFile.isImage() && !mediaFile.isVideo() && !config.includeDocuments -> false
                                else -> true
                            }
                        }
                        
                        Log.i(TAG, "Batch $currentBatch: Processing ${filteredFiles.size} new files")
                        
                        // Convert to RemotePhoto entities
                        val batchRemotePhotos = filteredFiles.map { mediaFile ->
                            mediaFile.toRemotePhoto()
                        }
                        
                        newRemotePhotos.addAll(batchRemotePhotos)
                        totalFilesFound += filteredFiles.size
                        
                        // Update progress
                        emit(ScanProgress(
                            currentBatch = currentBatch,
                            totalFilesFound = totalFilesFound,
                            isComplete = false
                        ))
                        
                        // Prepare for next batch
                        nextOffset = scanResult.nextOffset
                        
                        // Check limits
                        if (totalFilesFound >= config.maxFiles) {
                            Log.w(TAG, "Reached max files limit (${config.maxFiles}), stopping scan")
                            break
                        }
                        
                        if (!scanResult.hasMore) {
                            Log.i(TAG, "No more messages to scan")
                            break
                        }
                    }
                    
                    is ChannelScanResult.Error -> {
                        Log.e(TAG, "Error scanning channel: ${scanResult.message}")
                        emit(ScanProgress(
                            currentBatch = currentBatch,
                            totalFilesFound = totalFilesFound,
                            isComplete = true,
                            errorMessage = scanResult.message
                        ))
                        return@flow
                    }
                }
                
            } while (nextOffset != null && totalFilesFound < config.maxFiles)
            
            // Save all discovered RemotePhotos to database
            if (newRemotePhotos.isNotEmpty()) {
                Log.i(TAG, "Saving ${newRemotePhotos.size} new RemotePhoto records to database")
                withContext(Dispatchers.IO) {
                    DbHolder.database.remotePhotoDao().insertAll(*newRemotePhotos.toTypedArray())
                }
                Log.i(TAG, "Successfully saved ${newRemotePhotos.size} RemotePhoto records")
            } else {
                Log.i(TAG, "No new images found to sync")
            }
            
            // Emit final progress
            emit(ScanProgress(
                currentBatch = currentBatch,
                totalFilesFound = totalFilesFound,
                isComplete = true
            ))
            
            Log.i(TAG, "=== HISTORICAL IMAGE DISCOVERY COMPLETE ===")
            Log.i(TAG, "Total batches processed: $currentBatch")
            Log.i(TAG, "Total new files discovered: $totalFilesFound")
            
        } catch (e: Exception) {
            Log.e(TAG, "Exception during historical image discovery", e)
            emit(ScanProgress(
                currentBatch = 0,
                totalFilesFound = 0,
                isComplete = true,
                errorMessage = "Exception: ${e.message}"
            ))
        }
    }
    
    /**
     * Quick check to see if there are any historical images to discover
     * Returns the estimated number of media files in the channel
     */
    suspend fun estimateHistoricalImageCount(channelId: Long): Int {
        return withContext(Dispatchers.IO) {
            try {
                Log.d(TAG, "Estimating historical image count for channel: $channelId")
                val scanResult = BotApi.scanChannelForMedia(
                    channelId = channelId,
                    limit = 100,
                    offsetMessageId = null
                )
                
                when (scanResult) {
                    is ChannelScanResult.Success -> {
                        val mediaCount = scanResult.mediaFiles.count { it.isImage() || it.isVideo() }
                        Log.d(TAG, "Estimated media files in first 100 messages: $mediaCount")
                        // Rough estimate: if we found media in first 100 messages, 
                        // there might be more throughout the channel
                        if (mediaCount > 0 && scanResult.hasMore) {
                            mediaCount * 10 // Rough multiplier
                        } else {
                            mediaCount
                        }
                    }
                    is ChannelScanResult.Error -> {
                        Log.e(TAG, "Error estimating count: ${scanResult.message}")
                        0
                    }
                }
            } catch (e: Exception) {
                Log.e(TAG, "Exception estimating historical image count", e)
                0
            }
        }
    }
}

/**
 * Extension function to convert DiscoveredMediaFile to RemotePhoto
 */
private fun DiscoveredMediaFile.toRemotePhoto(): RemotePhoto {
    return RemotePhoto(
        remoteId = fileId,
        photoType = getFileExtension() ?: "unknown",
        fileName = fileName,
        fileSize = fileSize,
        uploadedAt = uploadDate,
        thumbnailCached = false,
        messageId = messageId.toLong()
    )
}
