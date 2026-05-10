package com.akslabs.cloudgallery.api

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONObject
import java.util.concurrent.TimeUnit
import java.util.concurrent.ConcurrentHashMap

/**
 * API client for the CloudGallery thumbnail server.
 * Provides thumbnail URLs and file_id → server_id mapping.
 */
object ServerApi {
    private const val TAG = "ServerApi"

    private val client = OkHttpClient.Builder()
        .connectTimeout(5, TimeUnit.SECONDS)
        .readTimeout(10, TimeUnit.SECONDS)
        .build()

    // Cache: telegram_file_id → server photo id
    private val fileIdToServerId = ConcurrentHashMap<String, Int>()
    private var cacheFullyLoaded = false
    private val cacheMutex = Mutex()
    private var lastCacheLoadTime = 0L
    private const val CACHE_TTL_MS = 10 * 60 * 1000L // 10 minutes

    /**
     * Build thumbnail URL for a given server photo ID.
     */
    fun getThumbnailUrl(serverId: Int, size: Int = 150): String {
        return "${ServerConfig.getServerUrl()}/api/photos/$serverId/thumb?size=$size"
    }

    /**
     * Look up the server ID for a given telegram_file_id.
     * Returns null if not found or server unreachable.
     */
    suspend fun getServerIdForFileId(telegramFileId: String): Int? {
        // Check cache first
        fileIdToServerId[telegramFileId]?.let { return it }

        // If cache is fully loaded and not stale, the ID doesn't exist on server
        if (cacheFullyLoaded && System.currentTimeMillis() - lastCacheLoadTime < CACHE_TTL_MS) {
            return null
        }

        // Load cache
        ensureCacheLoaded()
        return fileIdToServerId[telegramFileId]
    }

    /**
     * Get thumbnail URL for a telegram_file_id, or null if not on server.
     */
    suspend fun getThumbnailUrlForFileId(telegramFileId: String, size: Int = 150): String? {
        val serverId = getServerIdForFileId(telegramFileId) ?: return null
        return getThumbnailUrl(serverId, size)
    }

    /**
     * Check if the server is reachable.
     */
    suspend fun checkConnection(): Boolean = withContext(Dispatchers.IO) {
        try {
            val request = Request.Builder()
                .url(ServerConfig.getServerUrl())
                .build()
            val response = client.newCall(request).execute()
            val ok = response.isSuccessful
            response.close()
            ok
        } catch (e: Exception) {
            Log.d(TAG, "Server unreachable: ${e.message}")
            false
        }
    }

    /**
     * Get server stats.
     */
    suspend fun getStats(): ServerStats? = withContext(Dispatchers.IO) {
        try {
            val request = Request.Builder()
                .url("${ServerConfig.getServerUrl()}/api/photos?page=1&per_page=1")
                .build()
            val response = client.newCall(request).execute()
            if (!response.isSuccessful) { response.close(); return@withContext null }
            val body = response.body?.string() ?: return@withContext null
            val json = JSONObject(body)
            ServerStats(totalPhotos = json.optInt("total", 0))
        } catch (e: Exception) {
            Log.e(TAG, "Failed to get stats: ${e.message}")
            null
        }
    }

    /**
     * Load the full file_id → server_id mapping from the server.
     * Uses pagination to fetch all photos.
     */
    private suspend fun ensureCacheLoaded() { cacheMutex.withLock {
        // Double-check after acquiring lock
        if (cacheFullyLoaded && System.currentTimeMillis() - lastCacheLoadTime < CACHE_TTL_MS) return@withLock

        withContext(Dispatchers.IO) {
            try {
                Log.d(TAG, "Loading file_id → server_id cache from server...")
                val perPage = 500
                var page = 1
                var totalLoaded = 0

                while (true) {
                    val request = Request.Builder()
                        .url("${ServerConfig.getServerUrl()}/api/photos?page=$page&per_page=$perPage")
                        .build()
                    val response = client.newCall(request).execute()
                    if (!response.isSuccessful) {
                        response.close()
                        Log.e(TAG, "Failed to load page $page: ${response.code}")
                        break
                    }

                    val body = response.body?.string() ?: break
                    val json = JSONObject(body)
                    val photos = json.getJSONArray("photos")

                    if (photos.length() == 0) break

                    for (i in 0 until photos.length()) {
                        val photo = photos.getJSONObject(i)
                        val fileId = photo.optString("telegram_file_id", "")
                        val serverId = photo.optInt("id", -1)
                        if (fileId.isNotEmpty() && serverId > 0) {
                            fileIdToServerId[fileId] = serverId
                            totalLoaded++
                        }
                    }

                    val total = json.optInt("total", 0)
                    if (page * perPage >= total) break
                    page++
                }

                cacheFullyLoaded = true
                lastCacheLoadTime = System.currentTimeMillis()
                Log.i(TAG, "✅ Cache loaded: $totalLoaded file_id → server_id mappings")
            } catch (e: Exception) {
                Log.e(TAG, "Failed to load cache: ${e.message}")
            }
        }
    }
    }

    /**
     * Invalidate the cache (e.g., after new photos are synced).
     */
    fun invalidateCache() {
        cacheFullyLoaded = false
        lastCacheLoadTime = 0
    }

    data class ServerStats(val totalPhotos: Int)

    // --- Phase G: Power Features API ---

    data class ServerStatus(val status: String, val version: String, val totalPhotos: Int)
    data class StatsResponse(val totalPhotos: Int, val favorites: Int, val processed: Int)
    data class Person(val id: Int, val name: String?, val photoCount: Int)
    data class Place(val id: Int, val name: String, val photoCount: Int)
    data class SearchResult(val id: Int, val filename: String, val thumbnailUrl: String?)
    data class Album(val id: Int, val name: String, val photoCount: Int)

    /** GET / — check server and return status info */
    suspend fun getServerStatus(): ServerStatus? = withContext(Dispatchers.IO) {
        try {
            val request = Request.Builder().url(ServerConfig.getServerUrl()).build()
            val response = client.newCall(request).execute()
            if (!response.isSuccessful) { response.close(); return@withContext null }
            val body = response.body?.string() ?: return@withContext null
            val json = JSONObject(body)
            ServerStatus(
                status = json.optString("status", "ok"),
                version = json.optString("version", "unknown"),
                totalPhotos = json.optInt("total_photos", 0)
            )
        } catch (e: Exception) {
            Log.d(TAG, "getServerStatus failed: ${e.message}")
            null
        }
    }

    /** GET /api/photos/stats */
    suspend fun getPhotoStats(): StatsResponse? = withContext(Dispatchers.IO) {
        try {
            val request = Request.Builder().url("${ServerConfig.getServerUrl()}/api/photos/stats").build()
            val response = client.newCall(request).execute()
            if (!response.isSuccessful) { response.close(); return@withContext null }
            val body = response.body?.string() ?: return@withContext null
            val json = JSONObject(body)
            StatsResponse(
                totalPhotos = json.optInt("total_photos", json.optInt("total", 0)),
                favorites = json.optInt("favorites", 0),
                processed = json.optInt("processed", 0)
            )
        } catch (e: Exception) {
            Log.e(TAG, "getPhotoStats failed: ${e.message}")
            null
        }
    }

    /** GET /api/people */
    suspend fun getPeople(): List<Person> = withContext(Dispatchers.IO) {
        try {
            val request = Request.Builder().url("${ServerConfig.getServerUrl()}/api/people").build()
            val response = client.newCall(request).execute()
            if (!response.isSuccessful) { response.close(); return@withContext emptyList() }
            val body = response.body?.string() ?: return@withContext emptyList()
            val json = JSONObject(body)
            val arr = json.optJSONArray("people") ?: return@withContext emptyList()
            (0 until arr.length()).map { i ->
                val p = arr.getJSONObject(i)
                Person(p.optInt("id"), p.optString("name", null), p.optInt("photo_count", 0))
            }
        } catch (e: Exception) {
            Log.e(TAG, "getPeople failed: ${e.message}")
            emptyList()
        }
    }

    /** GET /api/places */
    suspend fun getPlaces(): List<Place> = withContext(Dispatchers.IO) {
        try {
            val request = Request.Builder().url("${ServerConfig.getServerUrl()}/api/places").build()
            val response = client.newCall(request).execute()
            if (!response.isSuccessful) { response.close(); return@withContext emptyList() }
            val body = response.body?.string() ?: return@withContext emptyList()
            val json = JSONObject(body)
            val arr = json.optJSONArray("places") ?: return@withContext emptyList()
            (0 until arr.length()).map { i ->
                val p = arr.getJSONObject(i)
                Place(p.optInt("id"), p.optString("name", ""), p.optInt("photo_count", 0))
            }
        } catch (e: Exception) {
            Log.e(TAG, "getPlaces failed: ${e.message}")
            emptyList()
        }
    }

    /** GET /api/search?q= */
    suspend fun search(query: String): List<SearchResult> = withContext(Dispatchers.IO) {
        try {
            val url = "${ServerConfig.getServerUrl()}/api/search?q=${java.net.URLEncoder.encode(query, "UTF-8")}"
            val request = Request.Builder().url(url).build()
            val response = client.newCall(request).execute()
            if (!response.isSuccessful) { response.close(); return@withContext emptyList() }
            val body = response.body?.string() ?: return@withContext emptyList()
            val json = JSONObject(body)
            val arr = json.optJSONArray("results") ?: json.optJSONArray("photos") ?: return@withContext emptyList()
            (0 until arr.length()).map { i ->
                val p = arr.getJSONObject(i)
                SearchResult(p.optInt("id"), p.optString("filename", ""), null)
            }
        } catch (e: Exception) {
            Log.e(TAG, "search failed: ${e.message}")
            emptyList()
        }
    }

    /** GET /api/albums */
    suspend fun getAlbums(): List<Album> = withContext(Dispatchers.IO) {
        try {
            val request = Request.Builder().url("${ServerConfig.getServerUrl()}/api/albums").build()
            val response = client.newCall(request).execute()
            if (!response.isSuccessful) { response.close(); return@withContext emptyList() }
            val body = response.body?.string() ?: return@withContext emptyList()
            val json = JSONObject(body)
            val arr = json.optJSONArray("albums") ?: return@withContext emptyList()
            (0 until arr.length()).map { i ->
                val a = arr.getJSONObject(i)
                Album(a.optInt("id"), a.optString("name", ""), a.optInt("photo_count", 0))
            }
        } catch (e: Exception) {
            Log.e(TAG, "getAlbums failed: ${e.message}")
            emptyList()
        }
    }

    /** Scan local network for server on port 8100 */
    suspend fun autoDetectServer(): String? = withContext(Dispatchers.IO) {
        try {
            val prefixes = listOf("192.168.1", "192.168.0", "10.0.0")
            val scanClient = OkHttpClient.Builder()
                .connectTimeout(1, TimeUnit.SECONDS)
                .readTimeout(1, TimeUnit.SECONDS)
                .build()

            for (prefix in prefixes) {
                // Scan in batches of 50 for speed
                for (batch in (1..254).chunked(50)) {
                    val results = coroutineScope {
                        batch.map { i ->
                            async {
                                try {
                                    val url = "http://$prefix.$i:8100/"
                                    val req = Request.Builder().url(url).build()
                                    val resp = scanClient.newCall(req).execute()
                                    if (resp.isSuccessful) {
                                        val body = resp.body?.string() ?: ""
                                        resp.close()
                                        if (body.contains("CloudGallery") || body.contains("status") || body.contains("version")) {
                                            "http://$prefix.$i:8100"
                                        } else null
                                    } else {
                                        resp.close()
                                        null
                                    }
                                } catch (_: Exception) { null }
                            }
                        }.awaitAll()
                    }
                    val found = results.filterNotNull().firstOrNull()
                    if (found != null) return@withContext found
                }
            }
            null
        } catch (e: Exception) {
            Log.e(TAG, "autoDetect failed: ${e.message}")
            null
        }
    }
}
