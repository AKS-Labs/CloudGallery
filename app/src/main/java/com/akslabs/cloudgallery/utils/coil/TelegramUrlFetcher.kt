package com.akslabs.cloudgallery.utils.coil

import android.util.Log
import coil.ImageLoader
import coil.decode.DataSource
import coil.decode.ImageSource
import coil.fetch.FetchResult
import coil.fetch.Fetcher
import coil.fetch.SourceResult
import coil.request.Options
import com.akslabs.cloudgallery.api.ThumbnailCache
import com.akslabs.cloudgallery.data.localdb.entities.RemotePhoto
import com.akslabs.cloudgallery.utils.getMimeTypeFromExt
import okhttp3.OkHttpClient
import okhttp3.Request
import java.util.concurrent.TimeUnit

/**
 * Coil Fetcher that loads cloud photos via Telegram download URLs.
 *
 * Strategy:
 * 1. If photo has thumbFileId → resolve that (small ~20KB thumbnail from Telegram)
 * 2. Otherwise → resolve remoteId (full file, Coil downscales via .size())
 *
 * URLs are cached via ThumbnailCache (valid ~1 hour).
 * This replaces downloading full file bytes through Bot.downloadFileBytes().
 */
class TelegramUrlFetcher(
    private val remotePhoto: RemotePhoto,
    private val options: Options,
) : Fetcher {

    companion object {
        private const val TAG = "TelegramUrlFetcher"
        private val httpClient = OkHttpClient.Builder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .build()
    }

    override suspend fun fetch(): FetchResult? {
        // Prefer thumbFileId (small pre-generated thumbnail) over full document
        val fileId = remotePhoto.thumbFileId ?: remotePhoto.remoteId
        val isThumb = remotePhoto.thumbFileId != null

        Log.d(TAG, "Fetching ${if (isThumb) "thumb" else "full"} for ${remotePhoto.remoteId}")

        val url = try {
            ThumbnailCache.getUrl(fileId)
        } catch (e: Exception) {
            Log.e(TAG, "URL resolution failed for $fileId", e)
            null
        }

        if (url == null) {
            Log.w(TAG, "URL resolution failed, falling back to direct download for $fileId")
            // Fallback: download bytes directly like the old NetworkFetcher
            return try {
                val bytes = com.akslabs.cloudgallery.api.BotApi.getFile(fileId)
                buildResult(bytes)
            } catch (e: Exception) {
                Log.e(TAG, "Fallback download also failed for $fileId", e)
                null
            }
        }

        return try {
            val request = Request.Builder().url(url).build()
            val response = httpClient.newCall(request).execute()

            if (!response.isSuccessful) {
                response.close()
                // URL may have expired, invalidate and retry once
                ThumbnailCache.invalidate(fileId)
                val retryUrl = ThumbnailCache.getUrl(fileId) ?: return null
                val retryResponse = httpClient.newCall(Request.Builder().url(retryUrl).build()).execute()
                if (!retryResponse.isSuccessful) {
                    retryResponse.close()
                    return null
                }
                buildResult(retryResponse.body?.bytes())
            } else {
                buildResult(response.body?.bytes())
            }
        } catch (e: Exception) {
            Log.e(TAG, "Download failed for $fileId: ${e.message}")
            null
        }
    }

    private fun buildResult(bytes: ByteArray?): FetchResult? {
        if (bytes == null || bytes.size < 100) return null
        val mimeType = getMimeTypeFromExt(remotePhoto.photoType)
        val buffer = okio.Buffer().write(bytes)
        return SourceResult(
            source = ImageSource(buffer, options.context),
            mimeType = mimeType,
            dataSource = DataSource.NETWORK
        )
    }

    class Factory : Fetcher.Factory<RemotePhoto> {
        override fun create(
            data: RemotePhoto,
            options: Options,
            imageLoader: ImageLoader,
        ): Fetcher {
            return TelegramUrlFetcher(data, options)
        }
    }
}
