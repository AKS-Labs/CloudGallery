package com.akslabs.cloudgallery.utils

import android.content.ContentResolver
import android.content.ContentValues.TAG
import android.content.Context
import android.net.Uri
import android.provider.OpenableColumns
import android.util.Log
import android.webkit.MimeTypeMap
import android.widget.Toast
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import com.akslabs.cloudgallery.R
import com.akslabs.cloudgallery.api.BotApi
import com.akslabs.cloudgallery.data.localdb.DbHolder
import com.akslabs.cloudgallery.data.localdb.Preferences
import com.akslabs.cloudgallery.data.localdb.entities.Photo
import com.akslabs.cloudgallery.data.localdb.entities.RemotePhoto
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import java.io.File
import java.io.FileOutputStream
import kotlin.random.Random
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

fun getFileName(contentResolver: ContentResolver, uri: Uri): String? {
    var fileName: String? = null
    contentResolver.query(uri, null, null, null, null)?.use { cursor ->
        if (cursor.moveToFirst()) {
            val nameIndex = cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME)
            if (nameIndex != -1 && cursor.moveToFirst()) {
                fileName = cursor.getString(nameIndex)
            }
        }
    }
    return fileName
}

fun getMimeTypeFromUri(contentResolver: ContentResolver, uri: Uri): String? {
    val mimeType = if (uri.scheme == ContentResolver.SCHEME_CONTENT) {
        contentResolver.getType(uri)
    } else {
        val fileExtension = MimeTypeMap.getFileExtensionFromUrl(uri.toString())
        MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtension?.lowercase())
    }
    return mimeType
}

fun getExtFromMimeType(mimeType: String): String? {
    return MimeTypeMap.getSingleton().getExtensionFromMimeType(mimeType)
}

fun scaleIntoContainer(
    direction: ScaleTransitionDirection = ScaleTransitionDirection.INWARDS,
    initialScale: Float = if (direction == ScaleTransitionDirection.OUTWARDS) 0.9f else 1.1f,
): EnterTransition {
    return scaleIn(
        animationSpec = tween(220, delayMillis = 90),
        initialScale = initialScale
    ) + fadeIn(animationSpec = tween(220, delayMillis = 90))
}

fun scaleOutOfContainer(
    direction: ScaleTransitionDirection = ScaleTransitionDirection.OUTWARDS,
    targetScale: Float = if (direction == ScaleTransitionDirection.INWARDS) 0.9f else 1.1f,
): ExitTransition {
    return scaleOut(
        animationSpec = tween(
            durationMillis = 220,
            delayMillis = 90
        ),
        targetScale = targetScale
    ) + fadeOut(tween(delayMillis = 90))
}

enum class ScaleTransitionDirection {
    INWARDS,
    OUTWARDS,
}

fun getMimeTypeFromExt(extension: String): String? {
    val mimeTypeMap = MimeTypeMap.getSingleton()
    return mimeTypeMap.getMimeTypeFromExtension(extension)
}

suspend fun sendFileViaUri(
    uri: Uri,
    contentResolver: ContentResolver,
    channelId: Long,
    botApi: BotApi,
    context: android.content.Context,
    uploadType: String? = null,
    fileName: String? = null,
    contentHash: String? = null,
    previewRemoteId: String? = null,
    replyToMessageId: Long? = null,
    messageThreadId: Long? = null,
    topicName: String? = null
): Boolean {
    val mimeType: String? = getMimeTypeFromUri(contentResolver, uri)
    val fileExtension = getExtFromMimeType(mimeType!!)
    val originalFileName = fileName ?: getFileName(contentResolver, uri)
    val inputStream = contentResolver.openInputStream(uri)
    var success = false
    inputStream?.use { ipStream ->
        val tempFile = File.createTempFile(Random.nextLong().toString(), ".$fileExtension")
        val outputStream = FileOutputStream(tempFile)
        ipStream.copyTo(outputStream)
        success = sendFileApi(
            botApi,
            channelId,
            uri,
            tempFile,
            fileExtension!!,
            context,
            uploadType,
            originalFileName,
            contentHash,
            previewRemoteId,
            replyToMessageId,
            messageThreadId,
            topicName
        )
        outputStream.close()
        Log.d(TAG, tempFile.name)
        tempFile.deleteOnExit()
    }
    return success
}

/**
 * Sends a file to Telegram and records it in the database.
 * Returns true if the upload was successful, false otherwise.
 * Throws IOException if the upload fails so callers can handle it.
 */
suspend fun sendFileApi(
    botApi: BotApi,
    channelId: Long,
    pathUri: Uri,
    file: File,
    extension: String,
    context: android.content.Context,
    uploadType: String? = null,
    fileName: String? = null,
    contentHash: String? = null,
    previewRemoteId: String? = null,
    replyToMessageId: Long? = null,
    messageThreadId: Long? = null,
    topicName: String? = null
): Boolean {
    val deviceId = Preferences.getOrCreateDeviceId()
    var message: com.github.kotlintelegrambot.entities.Message? = null
    var uploadError: Exception? = null
    var uploadedToTopic: Boolean = false

    // Build caption: metadata + device/hash tags
    val metadataCaption = if (MetadataConfig.shouldIncludeMetadata()) {
        val metadata = ImageMetadataExtractor.extractMetadata(context, pathUri)
        metadata?.toTelegramCaption()
    } else {
        null
    }

    // Append device and hash tags in formatted footer
    val deviceName = Preferences.getDeviceName()
    val caption = buildString {
        if (metadataCaption != null) {
            append(metadataCaption)
            append("\n")
        }
        appendLine("\u2501".repeat(18))
        appendLine("<b>#device:</b> ${deviceId} (<b>${escapeHtml(deviceName)}</b>)")
        if (contentHash != null) {
            appendLine("<b>#hash:</b> ${contentHash}")
        }
    }

    val topicLabel = if (topicName != null) " topic='$topicName'($messageThreadId)" else " (General)"
    Log.d(TAG, "⬆️ sendFileApi: Uploading file=${file.name} (${file.length()} bytes) to channel=$channelId$topicLabel")
    Log.d(TAG, "⬆️ sendFileApi: caption=$caption")

    // Attempt upload — if topic upload fails, fall back to General topic
    attemptUpload(botApi, channelId, file, caption, replyToMessageId, messageThreadId).also { (msg, err) ->
        message = msg; uploadError = err
        if (err == null) uploadedToTopic = true
    }

    // Fallback: if topic upload failed, retry without topic
    if (uploadError != null && messageThreadId != null) {
        Log.w(TAG, "⚠️ sendFileApi: Topic upload failed (${uploadError.message}), retrying to General topic")
        botApi.removeTopicFromCache(topicName)
        attemptUpload(botApi, channelId, file, caption, replyToMessageId, null).also { (msg, err) ->
            message = msg; uploadError = err
        }
    }

    val doc = message?.document
    val sticker = message?.sticker
    val photoSize = message?.photo?.maxByOrNull { it.fileSize ?: 0 }
    val fileId = doc?.fileId ?: photoSize?.fileId ?: sticker?.fileId

    if (fileId != null) {
        val resolvedExt = when {
            doc?.mimeType != null -> getExtFromMimeType(doc.mimeType!!) ?: extension
            photoSize != null -> "jpg"
            else -> extension
        }

        DbHolder.database.photoDao().updateRemoteIdForPath(pathUri.toString(), fileId)
        DbHolder.database.remotePhotoDao().insertAll(
            RemotePhoto(
                remoteId = fileId,
                photoType = resolvedExt,
                fileName = fileName,
                fileSize = file.length(),
                uploadedAt = System.currentTimeMillis(),
                thumbnailCached = false,
                messageId = message?.messageId,
                uploadType = uploadType,
                contentHash = contentHash,
                uploadedByDevice = deviceId,
                previewRemoteId = previewRemoteId,
                topicId = if (uploadedToTopic) messageThreadId else null,
                topicName = if (uploadedToTopic) topicName else null
            )
        )
        Log.d(TAG, "✅ sendFile: Success! fileId=$fileId, Device: $deviceId, Hash: ${contentHash?.take(8) ?: "none"}")
        return true
    } else {
        Log.e(TAG, "❌ sendFile: Upload FAILED - no fileId in response. Error: ${uploadError?.message}")
        throw uploadError ?: java.io.IOException("Upload failed: no fileId in Telegram response")
    }
}

/** Calls botApi.sendFile and returns (message, error). */
private suspend fun attemptUpload(
    botApi: BotApi,
    channelId: Long,
    file: File,
    caption: String?,
    replyToMessageId: Long?,
    messageThreadId: Long?
): Pair<com.github.kotlintelegrambot.entities.Message?, Exception?> {
    val result = botApi.sendFile(file, channelId, caption, replyToMessageId, messageThreadId)
    val (response, error) = result
    if (error != null) {
        Log.e(TAG, "❌ attemptUpload: Error for topic=$messageThreadId", error)
        return Pair(null, error)
    }
    if (response != null) {
        val body = response.body()
        val message = body?.result
        if (response.isSuccessful && message != null) {
            Log.d(TAG, "✅ attemptUpload: success, messageId=${message.messageId}")
            return Pair(message, null)
        }
        val errorBody = response.errorBody()?.string()
        Log.e(TAG, "❌ attemptUpload: API error code=${response.code()}, body=$errorBody")
        return Pair(null, java.io.IOException("Telegram API error ${response.code()}: $errorBody"))
    }
    Log.e(TAG, "❌ attemptUpload: Both response and error are null")
    return Pair(null, java.io.IOException("Upload returned null response"))
}

/**
 * Generates a JPEG preview of an image at the given URI.
 * Targets at least [minBytes] file size by adjusting quality and dimensions.
 * If the original image is smaller than [minBytes], returns a copy as-is.
 * Returns a temp file with the preview, or null on failure.
 */
suspend fun generatePreview(
    context: Context,
    uri: Uri,
    maxDimension: Int = 320,
    minBytes: Long = 25600
): File? = withContext(Dispatchers.IO) {
    try {
        // Check original file size — if already below threshold, copy as-is
        val originalSize = try {
            context.contentResolver.openFileDescriptor(uri, "r")?.use { it.statSize }
        } catch (_: Exception) { null }
        if (originalSize != null && originalSize in 1 until minBytes) {
            val copy = File.createTempFile("preview_", ".jpg")
            context.contentResolver.openInputStream(uri)?.use { input ->
                FileOutputStream(copy).use { output -> input.copyTo(output) }
            }
            return@withContext copy
        }

        val opts = BitmapFactory.Options().apply { inJustDecodeBounds = true }
        context.contentResolver.openInputStream(uri)?.use { input ->
            BitmapFactory.decodeStream(input, null, opts)
        }
        if (opts.outWidth <= 0 || opts.outHeight <= 0) return@withContext null

        var currentMaxDim = maxDimension
        var quality = 30
        var bestFile: File? = null

        while (quality <= 95 && currentMaxDim <= 1280) {
            val sampleSize = calculateSampleSize(opts.outWidth, opts.outHeight, currentMaxDim)
            val decodeOpts = BitmapFactory.Options().apply { inSampleSize = sampleSize }
            val bitmap = context.contentResolver.openInputStream(uri)?.use { input ->
                BitmapFactory.decodeStream(input, null, decodeOpts)
            } ?: return@withContext null

            val scale = minOf(
                currentMaxDim.toFloat() / bitmap.width,
                currentMaxDim.toFloat() / bitmap.height
            )
            val newWidth = (bitmap.width * scale).toInt().coerceAtLeast(1)
            val newHeight = (bitmap.height * scale).toInt().coerceAtLeast(1)

            val scaled = Bitmap.createScaledBitmap(bitmap, newWidth, newHeight, true)
            if (scaled != bitmap) bitmap.recycle()

            val tempFile = File.createTempFile("preview_", ".jpg")
            FileOutputStream(tempFile).use { out -> scaled.compress(Bitmap.CompressFormat.JPEG, quality, out) }
            scaled.recycle()

            if (tempFile.length() >= minBytes) {
                bestFile?.delete()
                bestFile = tempFile
                break
            }

            bestFile?.delete()
            bestFile = tempFile

            if (quality < 95) {
                quality = (quality + 15).coerceAtMost(95)
            } else {
                currentMaxDim += 200
                quality = 30
            }
        }

        bestFile
    } catch (e: Exception) {
        Log.e("Preview", "Failed to generate preview", e)
        null
    }
}

private fun calculateSampleSize(width: Int, height: Int, maxDimension: Int): Int {
    var sampleSize = 1
    while (width / sampleSize > maxDimension * 2 && height / sampleSize > maxDimension * 2) {
        sampleSize *= 2
    }
    return sampleSize
}

/**
 * Uploads a preview file to Telegram without creating database records.
 * Returns the Telegram file ID, or null on failure.
 */
suspend fun uploadPreviewFile(
    botApi: BotApi,
    channelId: Long,
    file: File,
    contentHash: String?
): Pair<String?, Long?> {
    val caption = buildString {
        append("<b>[Preview ${formatFileSize(file.length())}]</b>")
        if (contentHash != null) {
            append(" <b>#hash:</b> ${escapeHtml(contentHash)}")
        }
    }
    val (response, error) = botApi.sendPhoto(file, channelId, caption)
    if (error != null || response == null || !response.isSuccessful) {
        Log.e("Preview", "Preview upload failed: ${error?.message}")
        return Pair(null, null)
    }
    val message = response.body()?.result ?: return Pair(null, null)
    return Pair(message.photo?.lastOrNull()?.fileId, message.messageId)
}

/**
 * Whether sync image preview is enabled in settings.
 */
fun isSyncImagePreviewEnabled(): Boolean =
    Preferences.getBoolean(Preferences.syncImagePreviewKey, false)

suspend fun Context.toastFromMainThread(msg: String?, length: Int = Toast.LENGTH_LONG) =
    withContext(Dispatchers.Main) {
        Toast.makeText(this@toastFromMainThread, msg ?: getString(R.string.error), length).show()
    }

fun formatFileSize(bytes: Long): String {
    val units = arrayOf("B", "KB", "MB", "GB")
    var size = bytes.toDouble()
    var unitIndex = 0
    while (size >= 1024 && unitIndex < units.lastIndex) {
        size /= 1024
        unitIndex++
    }
    return if (unitIndex == 0) "${bytes} ${units[unitIndex]}"
    else "%.1f %s".format(size, units[unitIndex])
}

/**
 * Queries MediaStore for the BUCKET_DISPLAY_NAME (folder name) of a content URI.
 * Returns null if the URI is not a MediaStore content URI or the query fails.
 */
fun getBucketName(contentResolver: android.content.ContentResolver, uri: android.net.Uri): String? {
    return try {
        val cursor = contentResolver.query(
            uri,
            arrayOf(android.provider.MediaStore.Images.ImageColumns.BUCKET_DISPLAY_NAME),
            null, null, null
        )
        cursor?.use {
            if (it.moveToFirst()) {
                it.getString(it.getColumnIndexOrThrow(android.provider.MediaStore.Images.ImageColumns.BUCKET_DISPLAY_NAME))
            } else null
        }
    } catch (e: Exception) {
        Log.e(TAG, "Failed to get bucket name for $uri", e)
        null
    }
}
