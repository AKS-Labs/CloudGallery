package com.akslabs.cloudgallery.utils.coil

import android.content.Context
import android.util.Log
import coil.ImageLoader
import coil.disk.DiskCache
import coil.imageLoader
import coil.memory.MemoryCache
import coil.request.CachePolicy
import coil.util.DebugLogger
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit
import coil.intercept.Interceptor
import coil.request.ImageResult
import coil.request.SuccessResult
import coil.size.Precision
import android.content.ComponentCallbacks2
import android.content.res.Configuration

@OptIn(coil.annotation.ExperimentalCoilApi::class)
object ImageLoaderModule {
    private const val TAG = "ImageLoaderModule"

    lateinit var remoteImageLoader: ImageLoader
    lateinit var thumbnailImageLoader: ImageLoader
    lateinit var defaultImageLoader: ImageLoader

    fun create(appContext: Context) {
        Log.i(TAG, "=== INITIALIZING IMAGE LOADERS ===")
        defaultImageLoader = appContext.imageLoader

        // Optimized OkHttpClient for cloud images
        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .build()

        Log.d(TAG, "Created OkHttpClient with 30s connect, 60s read/write timeouts")

        // Shared disk cache — single cache so grid thumbnails and full viewer share cached files
        Log.d(TAG, "Creating sharedDiskCache...")
        val sharedDiskCache = DiskCache.Builder()
            .directory(appContext.cacheDir.resolve("telegram_image_cache"))
            .maxSizeBytes(750 * 1024 * 1024L) // 750MB combined
            .build()
        Log.d(TAG, "sharedDiskCache created")

        // Full resolution remote image loader
        Log.d(TAG, "Creating remoteImageLoader...")
        remoteImageLoader = ImageLoader.Builder(appContext)
            .crossfade(true)
            .respectCacheHeaders(false)
            .memoryCachePolicy(CachePolicy.ENABLED)
            .diskCachePolicy(CachePolicy.ENABLED)
            .memoryCache {
                MemoryCache.Builder(appContext)
                    .maxSizePercent(0.15)
                    .strongReferencesEnabled(true)
                    .build()
            }
            .diskCache { sharedDiskCache }
            .okHttpClient(okHttpClient)
            .components {
                add(NetworkFetcher.Factory())
                add(NetworkFetcher.FileIdFactory())
            }
            .build()
        Log.i(TAG, "remoteImageLoader created successfully")

        // Optimized thumbnail loader for grid views
        Log.d(TAG, "Creating thumbnailImageLoader...")
        thumbnailImageLoader = ImageLoader.Builder(appContext)
            .crossfade(false)
            .respectCacheHeaders(false)
            .memoryCachePolicy(CachePolicy.ENABLED)
            .diskCachePolicy(CachePolicy.ENABLED)
            .allowHardware(true)
            .allowRgb565(true)
            .memoryCache {
                MemoryCache.Builder(appContext)
                    .maxSizePercent(0.20)
                    .strongReferencesEnabled(true)
                    .build()
            }
            .diskCache { sharedDiskCache }
            .okHttpClient(okHttpClient)
            .components {
                add(NetworkFetcher.Factory())
                add(NetworkFetcher.FileIdFactory())
            }
            .build()
        Log.i(TAG, "thumbnailImageLoader created successfully")

        // Register memory trimmer — clears caches based on severity level
        appContext.registerComponentCallbacks(object : ComponentCallbacks2 {
            override fun onTrimMemory(level: Int) {
                Log.d(TAG, "Trimming memory: level=$level")
                when {
                    level >= ComponentCallbacks2.TRIM_MEMORY_COMPLETE -> {
                        Log.w(TAG, "Process about to be killed — clearing all caches including disk")
                        clearAllCaches(clearDisk = true)
                    }
                    level >= ComponentCallbacks2.TRIM_MEMORY_MODERATE -> {
                        Log.w(TAG, "Moderate memory pressure — clearing memory caches")
                        clearMemoryCaches()
                    }
                    level == ComponentCallbacks2.TRIM_MEMORY_UI_HIDDEN -> {
                        Log.i(TAG, "App in background — clearing memory caches")
                        clearMemoryCaches()
                    }
                    else -> {
                        remoteImageLoader.memoryCache?.trimMemory(level)
                        thumbnailImageLoader.memoryCache?.trimMemory(level)
                    }
                }
            }
            override fun onConfigurationChanged(newConfig: Configuration) {}
            override fun onLowMemory() {
                Log.w(TAG, "CRITICAL: Low memory, clearing all caches")
                clearAllCaches(clearDisk = false)
            }
        })

        Log.i(TAG, "=== IMAGE LOADERS INITIALIZATION COMPLETE ===")
        Log.i(TAG, "Available loaders:")
        Log.i(TAG, "- defaultImageLoader: ${if (::defaultImageLoader.isInitialized) "✓" else "✗"}")
        Log.i(TAG, "- remoteImageLoader: ${if (::remoteImageLoader.isInitialized) "✓" else "✗"}")
        Log.i(TAG, "- thumbnailImageLoader: ${if (::thumbnailImageLoader.isInitialized) "✓" else "✗"}")
    }

    fun clearMemoryCaches() {
        remoteImageLoader.memoryCache?.clear()
        thumbnailImageLoader.memoryCache?.clear()
    }

    @coil.annotation.ExperimentalCoilApi
    fun clearAllCaches(clearDisk: Boolean = true) {
        clearMemoryCaches()
        if (clearDisk) {
            try {
                remoteImageLoader.diskCache?.clear()
            } catch (e: Exception) {
                Log.e(TAG, "Failed to clear disk cache", e)
            }
        }
    }
}
