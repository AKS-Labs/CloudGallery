package com.akslabs.cloudgallery.workers

import android.content.Context
import android.content.pm.ServiceInfo
import android.util.Log
import androidx.core.net.toUri
import androidx.work.CoroutineWorker
import androidx.work.ForegroundInfo
import androidx.work.WorkerParameters
import androidx.work.workDataOf
import com.akslabs.cloudgallery.R
import com.akslabs.cloudgallery.api.BotApi
import com.akslabs.cloudgallery.data.localdb.Preferences
import com.akslabs.cloudgallery.utils.sendFileViaUri
import com.akslabs.cloudgallery.workers.WorkModule.NOTIFICATION_ID
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class InstantPhotoUploadWorker(
    private val appContext: Context,
    private val params: WorkerParameters,
) : CoroutineWorker(appContext, params) {

    private val channelId = Preferences.getEncryptedLong(Preferences.channelId, 0L)
    private val botApi = BotApi
    
    override suspend fun doWork(): Result {
        try {
            setForeground(getForegroundInfo())
        } catch (e: IllegalStateException) {
            Log.d("PhotoUpload", "FAILED: ${e.localizedMessage}")
            return Result.failure()
        }

        return withContext(Dispatchers.IO) {
            try {
                val photoUriString = params.inputData.getString(KEY_PHOTO_URI)!!
                val photoUri = photoUriString.toUri()
                val fileName = com.akslabs.cloudgallery.utils.getFileName(appContext.contentResolver, photoUri)
                val uploadType = params.inputData.getString(KEY_UPLOAD_TYPE) ?: "instant"

                setProgress(
                    workDataOf(
                        "progress" to "started",
                        KEY_PHOTO_URI to photoUriString,
                        KEY_FILE_NAME to fileName,
                        KEY_UPLOAD_TYPE to uploadType
                    )
                )

                sendFileViaUri(photoUri, appContext.contentResolver, channelId, botApi, appContext, uploadType, fileName)

                Result.success(workDataOf(
                    KEY_PHOTO_URI to photoUriString,
                    KEY_FILE_NAME to fileName,
                    KEY_UPLOAD_TYPE to uploadType
                ))
            } catch (e: Throwable) {
                Log.d("PhotoUpload", "FAILED, will retry: ${e.localizedMessage}")
                Result.retry()
            }
        }
    }

    override suspend fun getForegroundInfo(): ForegroundInfo {
        return createForegroundInfo(
            appContext,
            WorkModule.NOTIFICATION_ID_UPLOAD,
            appContext.getString(R.string.uploading_photo)
        )
    }

    companion object {
        const val KEY_PHOTO_URI = "photoUri"
        const val KEY_FILE_NAME = "fileName"
        const val KEY_UPLOAD_TYPE = "upload_type"
    }
}
