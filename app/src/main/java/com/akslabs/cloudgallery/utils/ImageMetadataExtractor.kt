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
    @JsonProperty("filePath") val filePath: String = "",
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
    fun toTelegramCaption(): String {
        val sb = StringBuilder()
        val d = "\u2501".repeat(18)

        sb.appendLine("\uD83D\uDCC1 <b>File:</b>")
        sb.appendLine("<blockquote><code>${escapeHtml(fileName)}</code></blockquote>")
        if (filePath.isNotEmpty()) {
//            sb.appendLine()
            sb.appendLine("\uD83D\uDCCD <b>Path:</b>")
            sb.appendLine("<blockquote><code>${escapeHtml(filePath)}</code></blockquote>")
        }
        sb.appendLine()
        sb.append("\uD83D\uDCBE <b>Size: ${formatFileSize(fileSize)}</b>")
        if (width != null && height != null) {
            sb.append("  \u00B7  \uD83D\uDDBC\uFE0F <b>Res: ${width}\u00d7${height}</b>")
        }
//        sb.appendLine()

        sb.appendLine()
        sb.appendLine(d)
        if (dateTaken != null) {
//            sb.appendLine()
            sb.appendLine("<b>Date taken:</b>")
            sb.appendLine("<blockquote><code>${formatDate(dateTaken)}</code></blockquote>")
        }
//        sb.appendLine()
        sb.appendLine("<b>Date added:</b>")
        sb.appendLine("<blockquote><code>${formatDate(dateAdded)}</code></blockquote>")

        camera?.let { cam ->
            val has = cam.make.isNotEmpty() || cam.model.isNotEmpty() || cam.lens.isNotEmpty()
            if (has) {
//                sb.appendLine()
                sb.appendLine(d)
                if (cam.make.isNotEmpty()) sb.appendLine("\uD83C\uDFED <b>Make:</b> <i>${escapeHtml(cam.make)}</i>")
                if (cam.model.isNotEmpty()) sb.appendLine("\uD83D\uDCF1 <b>Model:</b> <u>${escapeHtml(cam.model)}</u>")
                if (cam.lens.isNotEmpty()) sb.appendLine("\uD83D\uDD0D <b>Lens:</b> <tg-spoiler>${escapeHtml(cam.lens)}</tg-spoiler>")
            }
        }

        technical?.let { tech ->
            val has = tech.aperture.isNotEmpty() || tech.shutterSpeed.isNotEmpty() ||
                tech.iso.isNotEmpty() || tech.focalLength.isNotEmpty() || tech.flash.isNotEmpty()
            if (has) {
//                sb.appendLine()
                sb.appendLine(d)
                if (tech.aperture.isNotEmpty()) sb.appendLine("\uD83D\uDD73\uFE0F <b>Aperture:</b> f/${tech.aperture}")
                if (tech.shutterSpeed.isNotEmpty()) sb.appendLine("\u26A1 <b>Shutter:</b> <s>${tech.shutterSpeed}</s>")
                if (tech.iso.isNotEmpty()) sb.appendLine("\uD83C\uDF9B\uFE0F <b>ISO:</b> ${tech.iso}")
                if (tech.focalLength.isNotEmpty()) sb.appendLine("\uD83D\uDD2D <b>Focal:</b> ${tech.focalLength}mm")
                if (tech.flash.isNotEmpty()) sb.appendLine("\uD83D\uDCA1 <b>Flash:</b> ${tech.flash}")
            }
        }

        location?.let { loc ->
//            sb.appendLine()
            sb.appendLine(d)
            sb.appendLine("\uD83D\uDCCD <b>Coords:</b> <code>${loc.latitude}, ${loc.longitude}</code>")
            if (loc.altitude != null) {
                sb.appendLine("\u26F0\uFE0F <b>Altitude:</b> ${loc.altitude}m")
            }
            if (loc.address.isNotEmpty()) {
                sb.appendLine("\uD83C\uDFE0 <b>Address:</b> <i>${escapeHtml(loc.address)}</i>")
            }
            sb.appendLine("<blockquote expandable>\uD83D\uDCCD Location embedded in EXIF</blockquote>")
        }

        if (tags.isNotEmpty()) {
//            sb.appendLine()
            sb.appendLine(d)
            sb.appendLine(tags.joinToString(" ") { "#$it" })
        }

        return collapseBlankLines(sb.toString()).take(1024)
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
        val sdf = SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.getDefault())
        return sdf.format(Date(timestamp))
    }
}

private fun collapseBlankLines(text: String): String = text.replace(Regex("\\n{3,}"), "\n\n")

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

fun escapeHtml(text: String): String {
    return text
        .replace("&", "&amp;")
        .replace("<", "&lt;")
        .replace(">", "&gt;")
}

object ImageMetadataExtractor {

    private const val TAG = "ImageMetadataExtractor"

    suspend fun extractMetadata(
        context: Context,
        uri: Uri
    ): ImageMetadata? = withContext(Dispatchers.IO) {
        try {
            val contentResolver = context.contentResolver
            val basicInfo = getBasicFileInfo(contentResolver, uri) ?: return@withContext null
            val exifInfo = getExifInfo(contentResolver, uri)

            ImageMetadata(
                fileName = basicInfo.fileName,
                fileSize = basicInfo.fileSize,
                mimeType = basicInfo.mimeType,
                filePath = basicInfo.filePath,
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
            MediaStore.Images.ImageColumns.HEIGHT,
            MediaStore.Images.ImageColumns.DATA
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
                    height = cursor.getIntOrNull(MediaStore.Images.ImageColumns.HEIGHT),
                    filePath = cursor.getStringOrEmpty(MediaStore.Images.ImageColumns.DATA)
                )
            } else null
        }
    }

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

    private fun generateTags(basicInfo: BasicFileInfo, exifInfo: ExifInfo): List<String> {
        val tags = mutableListOf<String>()

        if (exifInfo.camera.make.isNotEmpty()) {
            tags.add(exifInfo.camera.make.lowercase().replace(" ", "_"))
        }
        if (exifInfo.camera.model.isNotEmpty()) {
            tags.add(exifInfo.camera.model.lowercase().replace(" ", "_"))
        }
        if (basicInfo.mimeType.isNotEmpty()) {
            val fileType = basicInfo.mimeType.substringAfter("/")
            tags.add(fileType)
        }
        if (basicInfo.filePath.isNotEmpty()) {
            val folder = basicInfo.filePath.substringBeforeLast("/")
                .substringAfterLast("/")
                .lowercase()
                .replace(" ", "_")
            if (folder.isNotEmpty()) {
                tags.add(folder)
            }
        }

        val cal = Calendar.getInstance()
        if (basicInfo.dateTaken != null) {
            cal.timeInMillis = basicInfo.dateTaken
        } else {
            cal.timeInMillis = basicInfo.dateAdded
        }
        tags.add("${cal.get(Calendar.YEAR)}")
        tags.add("${cal.get(Calendar.YEAR)}_${cal.get(Calendar.MONTH) + 1}")

        exifInfo.location?.let {
            tags.add("gps_enabled")
            tags.add("location_tagged")
        }
        if (exifInfo.technical.flash.isNotEmpty()) {
            tags.add("flash_used")
        }

        return tags.distinct()
    }

    private fun Cursor.getStringOrEmpty(columnName: String): String {
        return try {
            val index = getColumnIndexOrThrow(columnName)
            if (!isNull(index)) getString(index) else ""
        } catch (e: Exception) { "" }
    }

    private fun Cursor.getLongOrNull(columnName: String): Long? {
        return try {
            val index = getColumnIndexOrThrow(columnName)
            if (!isNull(index)) getLong(index) else null
        } catch (e: Exception) { null }
    }

    private fun Cursor.getLongOrDefault(columnName: String, defaultValue: Long): Long {
        return try {
            val index = getColumnIndexOrThrow(columnName)
            if (!isNull(index)) getLong(index) else defaultValue
        } catch (e: Exception) { defaultValue }
    }

    private fun Cursor.getIntOrNull(columnName: String): Int? {
        return try {
            val index = getColumnIndexOrThrow(columnName)
            if (!isNull(index)) getInt(index) else null
        } catch (e: Exception) { null }
    }
}

private data class BasicFileInfo(
    val fileName: String,
    val fileSize: Long,
    val mimeType: String,
    val filePath: String = "",
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
