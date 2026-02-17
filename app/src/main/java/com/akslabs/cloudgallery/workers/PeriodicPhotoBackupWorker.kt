package com.akslabs.cloudgallery.workers

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Log
import androidx.compose.ui.util.fastForEach
import androidx.compose.ui.util.fastForEachIndexed
import androidx.core.net.toUri
import androidx.work.CoroutineWorker
import androidx.work.ForegroundInfo
import androidx.work.WorkerParameters
import androidx.work.workDataOf
import com.akslabs.cloudgallery.R
import com.akslabs.cloudgallery.api.BotApi
import com.akslabs.cloudgallery.data.localdb.DbHolder
import com.akslabs.cloudgallery.data.localdb.Preferences
import com.akslabs.cloudgallery.utils.getExtFromMimeType
import com.akslabs.cloudgallery.utils.getMimeTypeFromUri
import com.akslabs.cloudgallery.utils.sendFileApi
import com.akslabs.cloudgallery.workers.WorkModule.NOTIFICATION_ID
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.IOException
import kotlin.math.roundToInt
import kotlin.random.Random

class PeriodicPhotoBackupWorker(
    private val appContext: Context,
    private val params: WorkerParameters,
) : CoroutineWorker(appContext, params) {

    private val channelId: Long = Preferences.getEncryptedLong(Preferences.channelId, 0L)
    private val botApi: BotApi = BotApi
    override suspend fun doWork(): Result {
        val compressionThresholdInBytes = params.inputData.getLong(
            KEY_COMPRESSION_THRESHOLD,
            0L
        )
        val imageList = DbHolder.database.photoDao().getAllNotUploaded()
        return withContext(Dispatchers.IO) {
            try {
                Log.d("PeriodicBackup", "Found ${imageList.size} photos not uploaded")
                lateinit var tempFile: File
                
                // Initial progress
                setProgress(
                    workDataOf(
                        KEY_PROGRESS_CURRENT to 0,
                        KEY_PROGRESS_MAX to imageList.size,
                        KEY_CURRENT_FILE_URI to ""
                    )
                )

                imageList.fastForEachIndexed { index, photo ->
                    Log.d("PeriodicBackup", "Processing ${index + 1}/${imageList.size}: ${photo.pathUri}")
                    
                    // Update progress
                    setProgress(
                        workDataOf(
                            KEY_PROGRESS_CURRENT to index + 1,
                            KEY_PROGRESS_MAX to imageList.size,
                            KEY_CURRENT_FILE_URI to photo.pathUri
                        )
                    )

                    val uri = photo.pathUri.toUri()
                    try {
                        val mimeType = getMimeTypeFromUri(appContext.contentResolver, uri)
                        val ext = getExtFromMimeType(mimeType!!)
                        val FIFTY_MB = 50L * 1024 * 1024 // 50 MB in bytes

                        val bytes = appContext.contentResolver.openInputStream(uri)?.use {
                            it.readBytes()
                        }!!

                        var outputBytes = bytes // default — no compression
                        var quality = 100

                        // Compress only if image > 50 MB
                        if (bytes.size > FIFTY_MB) {
                            val bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.size)
                            val compressFormat = when (mimeType) {
                                MIME_TYPE_JPEG -> Bitmap.CompressFormat.JPEG
                                MIME_TYPE_PNG -> Bitmap.CompressFormat.PNG
                                MIME_TYPE_WEBP -> Bitmap.CompressFormat.WEBP
                                else -> Bitmap.CompressFormat.JPEG
                            }

                            do {
                                val outputStream = ByteArrayOutputStream()
                                outputStream.use {
                                    bitmap.compress(compressFormat, quality, it)
                                    outputBytes = it.toByteArray()
                                }
                                quality -= 5 // reduce quality by 5 each iteration
                            } while (outputBytes.size > FIFTY_MB && quality > 0)
                        }

                        tempFile = File.createTempFile(
                            Random.nextLong().toString(),
                            ".$ext"
                        )
                        tempFile.writeBytes(outputBytes)
                        sendFileApi(botApi, channelId, uri, tempFile, ext!!, appContext)
                    } catch (e: IOException) {
                        return@withContext Result.failure(
                            workDataOf(KEY_RESULT_ERROR to "${e.message}")
                        )
                    } finally {
                        tempFile.deleteOnExit()
                    }
                }
                Result.success()
            } catch (e: Exception) {
                Result.failure(
                    workDataOf(KEY_RESULT_ERROR to "${e.message}")
                )
            }
        }
    }

    override suspend fun getForegroundInfo(): ForegroundInfo {
        return createForegroundInfo(
            appContext,
            WorkModule.NOTIFICATION_ID_BACKUP,
            appContext.getString(R.string.backing_up_photos)
        )
    }

    companion object {
        const val MIME_TYPE_JPEG = "image/jpeg"
        const val MIME_TYPE_PNG = "image/png"
        const val MIME_TYPE_WEBP = "image/webp"
        const val KEY_COMPRESSION_THRESHOLD = "KEY_COMPRESSION_THRESHOLD"
        const val KEY_RESULT_ERROR = "KEY_RESULT_ERROR"
        const val KEY_PROGRESS_CURRENT = "progress_current"
        const val KEY_PROGRESS_MAX = "progress_max"
        const val KEY_CURRENT_FILE_URI = "current_file_uri"
    }
}
