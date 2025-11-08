package com.akslabs.cloudgallery

import android.app.Application

import com.akslabs.cloudgallery.api.BotApi
import com.akslabs.cloudgallery.data.localdb.DbHolder
import com.akslabs.cloudgallery.data.localdb.Preferences
import com.akslabs.cloudgallery.data.mediastore.LocalPhotoSource
import com.akslabs.cloudgallery.utils.coil.ImageLoaderModule
import com.akslabs.cloudgallery.utils.connectivity.ConnectivityObserver
import com.akslabs.cloudgallery.workers.WorkModule
import coil.ImageLoader
import coil.disk.DiskCache
import coil.memory.MemoryCache
import android.graphics.Bitmap
import coil.Coil
import java.io.File


class App : Application() {

    override fun onCreate() {
        super.onCreate()

        Preferences.init(applicationContext)
        DbHolder.create(applicationContext)
        LocalPhotoSource.create(applicationContext)
        WorkModule.create(applicationContext)
        ImageLoaderModule.create(applicationContext)
        ConnectivityObserver.init(applicationContext)
        BotApi.create()

        val imageLoader = ImageLoader.Builder(this)
            .crossfade(false)                     // disable global crossfade
            .allowHardware(false)                 // prefer software decoding for consistent scroll
            .bitmapConfig(Bitmap.Config.ARGB_8888) // default high quality
            .diskCache {
                DiskCache.Builder()
                    .directory(File(cacheDir, "image_cache"))
                    .maxSizePercent(0.05) // up to 5% of disk
                    .build()
            }
            .memoryCache {
                MemoryCache.Builder(this)
                    .maxSizePercent(0.25) // up to 25% of app memory
                    .build()
            }
            .build()
        Coil.setImageLoader(imageLoader)
    }

    }
