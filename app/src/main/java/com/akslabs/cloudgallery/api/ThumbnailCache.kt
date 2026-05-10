package com.akslabs.cloudgallery.api

import android.util.Log
import kotlinx.coroutines.*
import java.util.concurrent.ConcurrentHashMap

/**
 * Caches resolved Telegram file download URLs.
 * Telegram URLs from getFile are valid for ~1 hour.
 * Works for both thumbFileId (small thumbnail) and remoteId (full document).
 */
object ThumbnailCache {
    private const val TAG = "ThumbnailCache"
    private const val URL_TTL_MS = 50 * 60 * 1000L // 50 minutes (conservative vs 1hr)

    // fileId -> (url, expiryTimestamp)
    private val urlCache = ConcurrentHashMap<String, Pair<String, Long>>()

    /**
     * Resolve a Telegram file_id to a direct download URL.
     * Returns cached URL if still valid, otherwise resolves via Bot API.
     */
    suspend fun getUrl(fileId: String): String? {
        val cached = urlCache[fileId]
        if (cached != null && System.currentTimeMillis() < cached.second) {
            return cached.first
        }

        val url = BotApi.getFileUrl(fileId) ?: return null
        urlCache[fileId] = url to (System.currentTimeMillis() + URL_TTL_MS)
        return url
    }

    /**
     * Batch-prefetch URLs for a list of file IDs.
     * Rate-limited to avoid hitting Telegram's API limits.
     */
    suspend fun prefetchUrls(fileIds: List<String>) = coroutineScope {
        val now = System.currentTimeMillis()
        val needed = fileIds.filter { id ->
            val cached = urlCache[id]
            cached == null || now >= cached.second
        }

        if (needed.isEmpty()) return@coroutineScope

        Log.d(TAG, "Prefetching ${needed.size} thumbnail URLs")

        // Process in chunks of 20 with rate limiting
        needed.chunked(20).forEach { chunk ->
            chunk.map { fileId ->
                async(Dispatchers.IO) {
                    try {
                        getUrl(fileId)
                    } catch (e: Exception) {
                        Log.w(TAG, "Prefetch failed for $fileId: ${e.message}")
                        null
                    }
                }
            }.awaitAll()
            delay(100) // Rate limit between chunks
        }
    }

    fun invalidate(fileId: String) {
        urlCache.remove(fileId)
    }

    fun clear() {
        urlCache.clear()
    }
}
