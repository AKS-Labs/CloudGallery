package com.akslabs.cloudgallery.utils

import android.content.ContentResolver
import android.content.Context
import android.database.Cursor
import android.net.Uri
import android.provider.MediaStore
import androidx.exifinterface.media.ExifInterface
import com.fasterxml.jackson.annotation.JsonProperty
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*

/**
 * Data class to hold comprehensive image metadata
 */
data class ImageMetadata(
    @JsonProperty("fileName") val fileName: String,
    @JsonProperty("fileSize") val fileSize: Long,
    @JsonProperty("mimeType") val mimeType: String,
    @JsonProperty("width") val width: Int? = null,
    @JsonProperty("height") val height: Int? = null,
    @JsonProperty("dateAdded") val dateAdded: Long,
    @JsonProperty("dateModified") val dateModified: Long,
    @JsonProperty("dateTaken") val dateTaken: Long? = null,
    @JsonProperty("camera") val camera: CameraInfo? = null,
    @JsonProperty("location") val location: LocationInfo? = null,
    @JsonProperty("technical") val technical: TechnicalInfo? = null,
    @JsonProperty("tags") val tags: List<String> = emptyList()
) {
    /**
     * Generate a formatted metadata caption for Telegram
     */
    fun toTelegramCaption(): String {
        val sb = StringBuilder()
        
        // Basic file info
        sb.appendLine("📷 **Photo Metadata**")
        sb.appendLine("📁 File: $fileName")
        sb.appendLine("📏 Size: ${formatFileSize(fileSize)}")
        
        // Dimensions
        if (width != null && height != null) {
            sb.appendLine("📐 Dimensions: ${width}x${height}")
        }
        
        // Date information
        if (dateTaken != null) {
            sb.appendLine("📅 Taken: ${formatDate(dateTaken)}")
        }
        sb.appendLine("📅 Added: ${formatDate(dateAdded)}")
        
        // Camera information
        camera?.let { cam ->
            sb.appendLine("\n📸 **Camera Info**")
            if (cam.make.isNotEmpty()) sb.appendLine("🏭 Make: ${cam.make}")
            if (cam.model.isNotEmpty()) sb.appendLine("📱 Model: ${cam.model}")
            if (cam.lens.isNotEmpty()) sb.appendLine("🔍 Lens: ${cam.lens}")
        }
        
        // Technical details
        technical?.let { tech ->
            sb.appendLine("\n⚙️ **Technical**")
            if (tech.aperture.isNotEmpty()) sb.appendLine("🕳️ Aperture: f/${tech.aperture}")
            if (tech.shutterSpeed.isNotEmpty()) sb.appendLine("⚡ Shutter: ${tech.shutterSpeed}")
            if (tech.iso.isNotEmpty()) sb.appendLine("🎛️ ISO: ${tech.iso}")
            if (tech.focalLength.isNotEmpty()) sb.appendLine("🔭 Focal: ${tech.focalLength}mm")
            if (tech.flash.isNotEmpty()) sb.appendLine("💡 Flash: ${tech.flash}")
        }
        
        // Location information
        location?.let { loc ->
            sb.appendLine("\n🌍 **Location**")
            sb.appendLine("📍 Coordinates: ${loc.latitude}, ${loc.longitude}")
            if (loc.altitude != null) {
                sb.appendLine("⛰️ Altitude: ${loc.altitude}m")
            }
            if (loc.address.isNotEmpty()) {
                sb.appendLine("🏠 Address: ${loc.address}")
            }
        }
        
        // Tags
        if (tags.isNotEmpty()) {
            sb.appendLine("\n🏷️ **Tags**")
            sb.appendLine(tags.joinToString(" ") { "#$it" })
        }
        
        return sb.toString().take(1024) // Telegram caption limit
    }
    
    private fun formatFileSize(bytes: Long): String {
        val units = arrayOf("B", "KB", "MB", "GB")
        var size = bytes.toDouble()
        var unitIndex = 0
        
        while (size >= 1024 && unitIndex < units.size - 1) {
            size /= 1024
            unitIndex++
        }
        
        return "%.1f %s".format(size, units[unitIndex])
    }
    
    private fun formatDate(timestamp: Long): String {
        val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
        return sdf.format(Date(timestamp))
    }
}

data class CameraInfo(
    @JsonProperty("make") val make: String = "",
    @JsonProperty("model") val model: String = "",
    @JsonProperty("lens") val lens: String = ""
)

data class LocationInfo(
    @JsonProperty("latitude") val latitude: Double,
    @JsonProperty("longitude") val longitude: Double,
    @JsonProperty("altitude") val altitude: Double? = null,
    @JsonProperty("address") val address: String = ""
)

data class TechnicalInfo(
    @JsonProperty("aperture") val aperture: String = "",
    @JsonProperty("shutterSpeed") val shutterSpeed: String = "",
    @JsonProperty("iso") val iso: String = "",
    @JsonProperty("focalLength") val focalLength: String = "",
    @JsonProperty("flash") val flash: String = "",
    @JsonProperty("whiteBalance") val whiteBalance: String = "",
    @JsonProperty("colorSpace") val colorSpace: String = ""
)

/**
 * Utility object for extracting comprehensive image metadata
 */
object ImageMetadataExtractor {
    
    private const val TAG = "ImageMetadataExtractor"
    
    /**
     * Extract comprehensive metadata from an image URI
     */
    suspend fun extractMetadata(
        context: Context,
        uri: Uri
    ): ImageMetadata? = withContext(Dispatchers.IO) {
        try {
            val contentResolver = context.contentResolver
            
            // Get basic file information from MediaStore
            val basicInfo = getBasicFileInfo(contentResolver, uri)
                ?: return@withContext null
            
            // Get EXIF data
            val exifInfo = getExifInfo(contentResolver, uri)
            
            ImageMetadata(
                fileName = basicInfo.fileName,
                fileSize = basicInfo.fileSize,
                mimeType = basicInfo.mimeType,
                width = exifInfo.width,
                height = exifInfo.height,
                dateAdded = basicInfo.dateAdded,
                dateModified = basicInfo.dateModified,
                dateTaken = basicInfo.dateTaken ?: exifInfo.dateTaken,
                camera = exifInfo.camera,
                location = exifInfo.location,
                technical = exifInfo.technical,
                tags = generateTags(basicInfo, exifInfo)
            )
        } catch (e: Exception) {
            android.util.Log.e(TAG, "Error extracting metadata for $uri", e)
            null
        }
    }
    
    /**
     * Get basic file information from MediaStore
     */
    private fun getBasicFileInfo(
        contentResolver: ContentResolver,
        uri: Uri
    ): BasicFileInfo? {
        val projection = arrayOf(
            MediaStore.Images.ImageColumns.DISPLAY_NAME,
            MediaStore.Images.ImageColumns.SIZE,
            MediaStore.Images.ImageColumns.MIME_TYPE,
            MediaStore.Images.ImageColumns.DATE_ADDED,
            MediaStore.Images.ImageColumns.DATE_MODIFIED,
            MediaStore.Images.ImageColumns.DATE_TAKEN,
            MediaStore.Images.ImageColumns.WIDTH,
            MediaStore.Images.ImageColumns.HEIGHT
        )
        
        return contentResolver.query(uri, projection, null, null, null)?.use { cursor ->
            if (cursor.moveToFirst()) {
                BasicFileInfo(
                    fileName = cursor.getStringOrEmpty(MediaStore.Images.ImageColumns.DISPLAY_NAME),
                    fileSize = cursor.getLongOrDefault(MediaStore.Images.ImageColumns.SIZE, 0L),
                    mimeType = cursor.getStringOrEmpty(MediaStore.Images.ImageColumns.MIME_TYPE),
                    dateAdded = cursor.getLongOrDefault(MediaStore.Images.ImageColumns.DATE_ADDED, 0L) * 1000,
                    dateModified = cursor.getLongOrDefault(MediaStore.Images.ImageColumns.DATE_MODIFIED, 0L) * 1000,
                    dateTaken = cursor.getLongOrNull(MediaStore.Images.ImageColumns.DATE_TAKEN),
                    width = cursor.getIntOrNull(MediaStore.Images.ImageColumns.WIDTH),
                    height = cursor.getIntOrNull(MediaStore.Images.ImageColumns.HEIGHT)
                )
            } else null
        }
    }
    
    /**
     * Extract EXIF information from image
     */
    private fun getExifInfo(
        contentResolver: ContentResolver,
        uri: Uri
    ): ExifInfo {
        return try {
            contentResolver.openInputStream(uri)?.use { inputStream ->
                val exif = ExifInterface(inputStream)
                
                val camera = CameraInfo(
                    make = exif.getAttribute(ExifInterface.TAG_MAKE) ?: "",
                    model = exif.getAttribute(ExifInterface.TAG_MODEL) ?: "",
                    lens = exif.getAttribute(ExifInterface.TAG_LENS_MODEL) ?: ""
                )
                
                val location = getLocationFromExif(exif)
                
                val technical = TechnicalInfo(
                    aperture = exif.getAttribute(ExifInterface.TAG_APERTURE_VALUE) ?: "",
                    shutterSpeed = exif.getAttribute(ExifInterface.TAG_EXPOSURE_TIME) ?: "",
                    iso = exif.getAttribute(ExifInterface.TAG_ISO_SPEED_RATINGS) ?: "",
                    focalLength = exif.getAttribute(ExifInterface.TAG_FOCAL_LENGTH) ?: "",
                    flash = exif.getAttribute(ExifInterface.TAG_FLASH) ?: "",
                    whiteBalance = exif.getAttribute(ExifInterface.TAG_WHITE_BALANCE) ?: "",
                    colorSpace = exif.getAttribute(ExifInterface.TAG_COLOR_SPACE) ?: ""
                )
                
                val dateTaken = exif.getAttribute(ExifInterface.TAG_DATETIME)?.let { dateStr ->
                    try {
                        val sdf = SimpleDateFormat("yyyy:MM:dd HH:mm:ss", Locale.getDefault())
                        sdf.parse(dateStr)?.time
                    } catch (e: Exception) {
                        null
                    }
                }
                
                ExifInfo(
                    width = exif.getAttributeInt(ExifInterface.TAG_IMAGE_WIDTH, 0).takeIf { it > 0 },
                    height = exif.getAttributeInt(ExifInterface.TAG_IMAGE_LENGTH, 0).takeIf { it > 0 },
                    dateTaken = dateTaken,
                    camera = camera,
                    location = location,
                    technical = technical
                )
            } ?: ExifInfo()
        } catch (e: IOException) {
            android.util.Log.w(TAG, "Failed to read EXIF data", e)
            ExifInfo()
        }
    }
    
    /**
     * Extract GPS location from EXIF data
     */
    private fun getLocationFromExif(exif: ExifInterface): LocationInfo? {
        val latLong = FloatArray(2)
        return if (exif.getLatLong(latLong)) {
            val altitude = exif.getAltitude(0.0).takeIf { it != 0.0 }
            LocationInfo(
                latitude = latLong[0].toDouble(),
                longitude = latLong[1].toDouble(),
                altitude = altitude
            )
        } else null
    }
    
    /**
     * Generate searchable tags based on metadata
     */
    private fun generateTags(basicInfo: BasicFileInfo, exifInfo: ExifInfo): List<String> {
        val tags = mutableListOf<String>()
        
        // Add camera brand tags
        if (exifInfo.camera.make.isNotEmpty()) {
            tags.add(exifInfo.camera.make.lowercase().replace(" ", "_"))
        }
        
        // Add camera model tags
        if (exifInfo.camera.model.isNotEmpty()) {
            tags.add(exifInfo.camera.model.lowercase().replace(" ", "_"))
        }
        
        // Add file type tag
        if (basicInfo.mimeType.isNotEmpty()) {
            val fileType = basicInfo.mimeType.substringAfter("/")
            tags.add(fileType)
        }
        
        // Add date-based tags
        val cal = Calendar.getInstance()
        if (basicInfo.dateTaken != null) {
            cal.timeInMillis = basicInfo.dateTaken
        } else {
            cal.timeInMillis = basicInfo.dateAdded
        }
        
        tags.add("${cal.get(Calendar.YEAR)}")
        tags.add("${cal.get(Calendar.YEAR)}_${cal.get(Calendar.MONTH) + 1}")
        
        // Add location tags if available
        exifInfo.location?.let {
            tags.add("gps_enabled")
            tags.add("location_tagged")
        }
        
        // Add technical tags
        if (exifInfo.technical.flash.isNotEmpty()) {
            tags.add("flash_used")
        }
        
        return tags.distinct()
    }
    
    // Helper extension functions
    private fun Cursor.getStringOrEmpty(columnName: String): String {
        return try {
            val index = getColumnIndexOrThrow(columnName)
            if (!isNull(index)) getString(index) else ""
        } catch (e: Exception) {
            ""
        }
    }
    
    private fun Cursor.getLongOrNull(columnName: String): Long? {
        return try {
            val index = getColumnIndexOrThrow(columnName)
            if (!isNull(index)) getLong(index) else null
        } catch (e: Exception) {
            null
        }
    }
    
    private fun Cursor.getLongOrDefault(columnName: String, defaultValue: Long): Long {
        return try {
            val index = getColumnIndexOrThrow(columnName)
            if (!isNull(index)) getLong(index) else defaultValue
        } catch (e: Exception) {
            defaultValue
        }
    }
    
    private fun Cursor.getIntOrNull(columnName: String): Int? {
        return try {
            val index = getColumnIndexOrThrow(columnName)
            if (!isNull(index)) getInt(index) else null
        } catch (e: Exception) {
            null
        }
    }
}

/**
 * Internal data classes for organization
 */
private data class BasicFileInfo(
    val fileName: String,
    val fileSize: Long,
    val mimeType: String,
    val dateAdded: Long,
    val dateModified: Long,
    val dateTaken: Long?,
    val width: Int?,
    val height: Int?
)

private data class ExifInfo(
    val width: Int? = null,
    val height: Int? = null,
    val dateTaken: Long? = null,
    val camera: CameraInfo = CameraInfo(),
    val location: LocationInfo? = null,
    val technical: TechnicalInfo = TechnicalInfo()
)