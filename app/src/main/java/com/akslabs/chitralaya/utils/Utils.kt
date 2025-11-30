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
import com.akslabs.cloudgallery.data.localdb.entities.Photo
import com.akslabs.cloudgallery.data.localdb.entities.RemotePhoto
import com.github.kotlintelegrambot.entities.files.Document
import com.github.kotlintelegrambot.network.fold
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
    context: android.content.Context
) {
    val mimeType: String? = getMimeTypeFromUri(contentResolver, uri)
    val fileExtension = getExtFromMimeType(mimeType!!)
    val inputStream = contentResolver.openInputStream(uri)
    inputStream?.use { ipStream ->
        val tempFile = File.createTempFile(Random.nextLong().toString(), ".$fileExtension")
        val outputStream = FileOutputStream(tempFile)
        ipStream.copyTo(outputStream)
        sendFileApi(
            botApi,
            channelId,
            uri,
            tempFile,
            fileExtension!!,
            context
        )
        outputStream.close()
        Log.d(TAG, tempFile.name)
        tempFile.deleteOnExit()
    }
}

suspend fun sendFileApi(
    botApi: BotApi,
    channelId: Long,
    pathUri: Uri,
    file: File,
    extension: String,
    context: android.content.Context
) {
    var message: com.github.kotlintelegrambot.entities.Message? = null
    
    // Extract metadata and create caption if enabled
    val caption = if (MetadataConfig.shouldIncludeMetadata()) {
        val metadata = ImageMetadataExtractor.extractMetadata(context, pathUri)
        metadata?.toTelegramCaption()
    } else {
        null
    }
    
    botApi.sendFile(file, channelId, caption).fold(
        { apiResponse ->
            message = apiResponse?.result
        }
    )

    val doc = message?.document
    val photoSize = message?.photo?.maxByOrNull { it.fileSize ?: 0 }
    val fileId = doc?.fileId ?: photoSize?.fileId

    if (fileId != null) {
        // Resolve extension from Telegram metadata if available
        val resolvedExt = when {
            doc?.mimeType != null -> getExtFromMimeType(doc.mimeType!!) ?: extension
            photoSize != null -> "jpg"
            else -> extension
        }

        // Atomically update the remoteId for the photo using its pathUri
        DbHolder.database.photoDao().updateRemoteIdForPath(pathUri.toString(), fileId)

        // Insert/replace RemotePhoto so Cloud screen picks it up immediately
        DbHolder.database.remotePhotoDao().insertAll(
            RemotePhoto(
                remoteId = fileId,
                photoType = resolvedExt,
                fileName = file.name,
                fileSize = file.length(),
                uploadedAt = System.currentTimeMillis(),
                thumbnailCached = false,
                messageId = message?.messageId
            )
        )
        Log.d(TAG, "sendFile: Success! Metadata included in caption.")
    } else {
        Log.d(TAG, "sendFile: Failed!")
    }
}

suspend fun Context.toastFromMainThread(msg: String?, length: Int = Toast.LENGTH_LONG) =
    withContext(Dispatchers.Main) {
        Toast.makeText(this@toastFromMainThread, msg ?: getString(R.string.error), length).show()
    }
