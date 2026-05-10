package com.akslabs.cloudgallery.utils.coil

import android.util.Log
import coil.ImageLoader
import coil.decode.DataSource
import coil.decode.ImageSource
import coil.fetch.FetchResult
import coil.fetch.Fetcher
import coil.fetch.SourceResult
import coil.request.Options
import com.akslabs.cloudgallery.api.ServerApi
import com.akslabs.cloudgallery.api.ServerConfig
import com.akslabs.cloudgallery.data.localdb.entities.RemotePhoto
import okhttp3.OkHttpClient
import okhttp3.Request
import java.util.concurrent.TimeUnit

/**
 * Coil Fetcher that loads thumbnails from the CloudGallery server
 * instead of downloading full images from Telegram.
 *
 * Falls back to NetworkFetcher (Telegram) if:
 * - Server is not enabled/configured
 * - Photo not found on server
 * - Server request fails
 */
class ServerThumbnailFetcher(
    private val remotePhoto: RemotePhoto,
    private val options: Options,
    private val fallbackFactory: NetworkFetcher.Factory,
) : Fetcher {

    companion object {
        private const val TAG = "ServerThumbFetcher"
        private val httpClient = OkHttpClient.Builder()
            .connectTimeout(5, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .build()

        // Track server health to avoid hammering a dead server
        @Volatile
        private var serverHealthy = true
        @Volatile
        private var lastHealthCheck = 0L
        private const val HEALTH_RETRY_MS = 30_000L // retry after 30s
    }

    override suspend fun fetch(): FetchResult? {
        // Skip server path if not enabled
        if (!ServerConfig.isServerEnabled() || !ServerConfig.isServerConfigured()) {
            return fallback()
        }

        // Skip if server was recently unreachable
        if (!serverHealthy && System.currentTimeMillis() - lastHealthCheck < HEALTH_RETRY_MS) {
            return fallback()
        }

        return try {
            val thumbnailUrl = ServerApi.getThumbnailUrlForFileId(remotePhoto.remoteId)
            if (thumbnailUrl == null) {
                Log.d(TAG, "Photo ${remotePhoto.remoteId} not on server, falling back")
                return fallback()
            }

            val request = Request.Builder().url(thumbnailUrl).build()
            val response = httpClient.newCall(request).execute()

            if (!response.isSuccessful) {
                response.close()
                Log.w(TAG, "Server returned ${response.code} for ${remotePhoto.remoteId}")
                return fallback()
            }

            val bytes = response.body?.bytes()
            if (bytes == null || bytes.size < 100) {
                // Too small = likely placeholder (1x1 px)
                Log.d(TAG, "Thumbnail too small (${bytes?.size} bytes) for ${remotePhoto.remoteId}, falling back")
                return fallback()
            }

            serverHealthy = true
            val buffer = okio.Buffer().write(bytes)
            SourceResult(
                source = ImageSource(buffer, options.context),
                mimeType = "image/jpeg",
                dataSource = DataSource.NETWORK
            )
        } catch (e: Exception) {
            Log.w(TAG, "Server fetch failed for ${remotePhoto.remoteId}: ${e.message}")
            serverHealthy = false
            lastHealthCheck = System.currentTimeMillis()
            fallback()
        }
    }

    private suspend fun fallback(): FetchResult? {
        val fetcher = fallbackFactory.create(remotePhoto, options, ImageLoaderModule.thumbnailImageLoader)
        return fetcher?.fetch()
    }

    class Factory : Fetcher.Factory<RemotePhoto> {
        private val fallbackFactory = NetworkFetcher.Factory()

        override fun create(
            data: RemotePhoto,
            options: Options,
            imageLoader: ImageLoader,
        ): Fetcher {
            return ServerThumbnailFetcher(data, options, fallbackFactory)
        }
    }
}
