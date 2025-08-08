package com.akslabs.cloudgallery.utils.coil

import android.util.Log
import coil.ImageLoader
import coil.decode.DataSource
import coil.decode.ImageSource
import coil.fetch.FetchResult
import coil.fetch.Fetcher
import coil.fetch.SourceResult
import coil.request.Options
import com.akslabs.cloudgallery.api.BotApi
import com.akslabs.cloudgallery.data.localdb.entities.RemotePhoto
import com.akslabs.cloudgallery.utils.getMimeTypeFromExt

class NetworkFetcher(
    private val botApi: BotApi = BotApi,
    private val remotePhoto: RemotePhoto,
    private val options: Options,
) : Fetcher {
    override suspend fun fetch(): FetchResult? {
        Log.d(TAG, "🌐 === NETWORK FETCHER START ===")
        Log.d(TAG, "🌐 Fetching image for remoteId: ${remotePhoto.remoteId}")
        Log.d(TAG, "🌐 Photo type: ${remotePhoto.photoType}")
        Log.d(TAG, "🌐 Photo fileName: ${remotePhoto.fileName}")
        Log.d(TAG, "🌐 Photo fileSize: ${remotePhoto.fileSize}")
        Log.d(TAG, "🌐 Request size: ${options.size}")

        return try {
            Log.i(TAG, "🌐 Calling BotApi.getFile for remoteId: ${remotePhoto.remoteId}")
            val startTime = System.currentTimeMillis()
            val byteArray = botApi.getFile(remotePhoto.remoteId)
            val endTime = System.currentTimeMillis()

            if (byteArray != null) {
                Log.i(TAG, "🌐 ✅ SUCCESS: Downloaded ${byteArray.size} bytes in ${endTime - startTime}ms for remoteId: ${remotePhoto.remoteId}")
                val mimeType = getMimeTypeFromExt(remotePhoto.photoType)
                Log.d(TAG, "🌐 Detected MIME type: $mimeType")

                val buffer = okio.Buffer().write(byteArray)
                val result = SourceResult(
                    source = ImageSource(buffer, options.context),
                    mimeType = mimeType,
                    dataSource = DataSource.NETWORK
                )
                Log.i(TAG, "🌐 Created SourceResult for remoteId: ${remotePhoto.remoteId}")
                Log.d(TAG, "🌐 === NETWORK FETCHER SUCCESS ===")
                result
            } else {
                Log.e(TAG, "🌐 ❌ FAILED: BotApi.getFile returned null for remoteId: ${remotePhoto.remoteId}")
                Log.d(TAG, "🌐 === NETWORK FETCHER FAILED ===")
                null
            }
        } catch (e: Exception) {
            Log.e(TAG, "🌐 ❌ EXCEPTION in NetworkFetcher for remoteId: ${remotePhoto.remoteId}", e)
            Log.d(TAG, "🌐 === NETWORK FETCHER EXCEPTION ===")
            null
        }
    }

    class Factory(
        private val botApi: BotApi = BotApi,
    ) : Fetcher.Factory<RemotePhoto> {
        override fun create(
            data: RemotePhoto,
            options: Options,
            imageLoader: ImageLoader,
        ): Fetcher? {
            Log.d(TAG, "🏭 NetworkFetcher.Factory creating fetcher for remoteId: ${data.remoteId}, size: ${options.size}")
            return NetworkFetcher(botApi, data, options)
        }
    }

    companion object {
        private const val TAG = "NetworkFetcher"
    }
}