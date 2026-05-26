package com.akslabs.cloudgallery.api

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize

/**
 * Result of scanning a Telegram channel for media files
 */
sealed class ChannelScanResult {
    data class Success(
        val mediaFiles: List<DiscoveredMediaFile>,
        val hasMore: Boolean,
        val nextOffset: Long?
    ) : ChannelScanResult()
    
    data class Error(val message: String) : ChannelScanResult()
}

/**
 * Represents a media file discovered in a Telegram channel
 */
@Keep
@Parcelize
data class DiscoveredMediaFile(
    val fileId: String,
    val fileName: String?,
    val fileSize: Long?,
    val mimeType: String?,
    val uploadDate: Long,
    val messageId: Int,
    val mediaType: MediaType
) : Parcelable {
    
    /**
     * Get file extension from filename or mime type
     */
    fun getFileExtension(): String? {
        return fileName?.substringAfterLast('.', "")?.takeIf { it.isNotEmpty() }
            ?: when (mimeType) {
                "image/jpeg" -> "jpg"
                "image/png" -> "png"
                "image/gif" -> "gif"
                "image/webp" -> "webp"
                "image/bmp" -> "bmp"
                "video/mp4" -> "mp4"
                "video/avi" -> "avi"
                "video/mov" -> "mov"
                "video/mkv" -> "mkv"
                else -> null
            }
    }
    
    /**
     * Check if this is an image file
     */
    fun isImage(): Boolean {
        return mediaType == MediaType.PHOTO || 
               mimeType?.startsWith("image/") == true ||
               getFileExtension()?.lowercase() in listOf("jpg", "jpeg", "png", "gif", "webp", "bmp")
    }
    
    /**
     * Check if this is a video file
     */
    fun isVideo(): Boolean {
        return mimeType?.startsWith("video/") == true ||
               getFileExtension()?.lowercase() in listOf("mp4", "avi", "mov", "mkv", "webm", "3gp")
    }
}

/**
 * Type of media discovered in the channel
 */
@Keep
enum class MediaType {
    DOCUMENT,  // Files sent as documents
    PHOTO      // Files sent as photos (compressed by Telegram)
}

/**
 * Progress information for channel scanning operation
 */
data class ScanProgress(
    val currentBatch: Int,
    val totalFilesFound: Int,
    val isComplete: Boolean,
    val errorMessage: String? = null
)

/**
 * Configuration for channel scanning
 */
data class ScanConfig(
    val channelId: Long,
    val batchSize: Int = 100,
    val maxFiles: Int = 10000, // Prevent infinite scanning
    val includePhotos: Boolean = true,
    val includeDocuments: Boolean = true,
    val includeVideos: Boolean = true
)
