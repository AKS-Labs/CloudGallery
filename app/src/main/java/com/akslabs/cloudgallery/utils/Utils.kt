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
    contentHash: String? = null
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
            contentHash
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
    contentHash: String? = null
): Boolean {
    val deviceId = Preferences.getOrCreateDeviceId()
    var message: com.github.kotlintelegrambot.entities.Message? = null
    var uploadError: Exception? = null
    
    // Build caption: metadata + device/hash tags
    val metadataCaption = if (MetadataConfig.shouldIncludeMetadata()) {
        val metadata = ImageMetadataExtractor.extractMetadata(context, pathUri)
        metadata?.toTelegramCaption()
    } else {
        null
    }
    
    // Append device and hash tags
    val deviceName = Preferences.getDeviceName()
    val deviceTag = if (deviceName.isNotEmpty()) "#device:$deviceId ($deviceName)" else "#device:$deviceId"
    val hashTag = if (contentHash != null) " #hash:$contentHash" else ""
    val caption = buildString {
        if (metadataCaption != null) {
            append(metadataCaption)
            append("\n")
        }
        append(deviceTag)
        append(hashTag)
    }
    
    Log.d(TAG, "⬆️ sendFileApi: Uploading file=${file.name} (${file.length()} bytes) to channel=$channelId")
    Log.d(TAG, "⬆️ sendFileApi: caption=$caption")
    
    val result = botApi.sendFile(file, channelId, caption)
    val (response, error) = result
    
    if (error != null) {
        Log.e(TAG, "❌ sendFileApi: Network/API error during upload", error)
        uploadError = error
    } else if (response != null) {
        val body = response.body()
        if (response.isSuccessful && body?.result != null) {
            message = body.result
            Log.d(TAG, "✅ sendFileApi: Telegram API returned success, messageId=${message?.messageId}")
        } else {
            val errorBody = response.errorBody()?.string()
            Log.e(TAG, "❌ sendFileApi: Telegram API error - code=${response.code()}, body=$errorBody")
            uploadError = java.io.IOException("Telegram API error ${response.code()}: $errorBody")
        }
    } else {
        Log.e(TAG, "❌ sendFileApi: Both response and error are null")
        uploadError = java.io.IOException("Upload returned null response")
    }

    val doc = message?.document
    val sticker = message?.sticker
    val photoSize = message?.photo?.maxByOrNull { it.fileSize ?: 0 }
    val fileId = doc?.fileId ?: photoSize?.fileId ?: sticker?.fileId

    if (fileId != null) {
        // Resolve extension from Telegram metadata if available
        val resolvedExt = when {
            doc?.mimeType != null -> getExtFromMimeType(doc.mimeType!!) ?: extension
            photoSize != null -> "jpg"
            else -> extension
        }

        // Atomically update the remoteId for the photo using its pathUri
        DbHolder.database.photoDao().updateRemoteIdForPath(pathUri.toString(), fileId)

        // Insert/replace RemotePhoto with device metadata
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
                uploadedByDevice = deviceId
            )
        )
        Log.d(TAG, "✅ sendFile: Success! fileId=$fileId, Device: $deviceId, Hash: ${contentHash?.take(8) ?: "none"}")
        return true
    } else {
        Log.e(TAG, "❌ sendFile: Upload FAILED - no fileId in response. Error: ${uploadError?.message}")
        // Throw so callers know the upload failed
        throw uploadError ?: java.io.IOException("Upload failed: no fileId in Telegram response")
    }
}

suspend fun Context.toastFromMainThread(msg: String?, length: Int = Toast.LENGTH_LONG) =
    withContext(Dispatchers.Main) {
        Toast.makeText(this@toastFromMainThread, msg ?: getString(R.string.error), length).show()
    }
