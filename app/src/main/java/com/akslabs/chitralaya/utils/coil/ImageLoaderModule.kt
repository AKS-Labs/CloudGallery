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

        // Full resolution remote image loader
        Log.d(TAG, "Creating remoteImageLoader...")
        remoteImageLoader = ImageLoader.Builder(appContext)
            .crossfade(true)
            .respectCacheHeaders(false)
            .memoryCachePolicy(CachePolicy.ENABLED)
            .diskCachePolicy(CachePolicy.ENABLED)
            .memoryCache {
                MemoryCache.Builder(appContext)
                    .maxSizePercent(0.15) // Reduced for thumbnails
                    .strongReferencesEnabled(true)
                    .build()
            }
            .diskCache {
                DiskCache.Builder()
                    .directory(appContext.cacheDir.resolve("image_cache"))
                    .maxSizePercent(0.1) // 10% of available disk space
                    .build()
            }
            .okHttpClient(okHttpClient)
            .components { add(NetworkFetcher.Factory()) }
            .logger(DebugLogger())
            .build()
        Log.i(TAG, "remoteImageLoader created successfully")

        // Optimized thumbnail loader for grid views
        Log.d(TAG, "Creating thumbnailImageLoader...")
        thumbnailImageLoader = ImageLoader.Builder(appContext)
            .crossfade(false) // Disable crossfade for faster loading
            .respectCacheHeaders(false)
            .memoryCachePolicy(CachePolicy.ENABLED)
            .diskCachePolicy(CachePolicy.ENABLED)
            .allowHardware(true) // Enable hardware acceleration
            .allowRgb565(true) // Use less memory per image
            .memoryCache {
                MemoryCache.Builder(appContext)
                    .maxSizePercent(0.30) // More memory for thumbnails
                    .strongReferencesEnabled(true)
                    .build()
            }
            .diskCache {
                DiskCache.Builder()
                    .directory(appContext.cacheDir.resolve("thumbnail_cache"))
                    .maxSizePercent(0.08) // Slightly more disk space for thumbnails
                    .build()
            }
            .okHttpClient(okHttpClient)
            .components { add(NetworkFetcher.Factory()) }
            .build()
        Log.i(TAG, "thumbnailImageLoader created successfully")

        Log.i(TAG, "=== IMAGE LOADERS INITIALIZATION COMPLETE ===")
        Log.i(TAG, "Available loaders:")
        Log.i(TAG, "- defaultImageLoader: ${if (::defaultImageLoader.isInitialized) "✓" else "✗"}")
        Log.i(TAG, "- remoteImageLoader: ${if (::remoteImageLoader.isInitialized) "✓" else "✗"}")
        Log.i(TAG, "- thumbnailImageLoader: ${if (::thumbnailImageLoader.isInitialized) "✓" else "✗"}")
    }
}