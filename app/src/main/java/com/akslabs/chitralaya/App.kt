package com.akslabs.cloudgallery

import android.app.Application

import com.akslabs.cloudgallery.api.BotApi
import com.akslabs.cloudgallery.data.localdb.DbHolder
import com.akslabs.cloudgallery.data.localdb.Preferences
import com.akslabs.cloudgallery.utils.coil.ImageLoaderModule
import com.akslabs.cloudgallery.utils.connectivity.ConnectivityObserver
import com.akslabs.cloudgallery.workers.WorkModule


class App : Application() {

    override fun onCreate() {
        super.onCreate()

        Preferences.init(applicationContext)
        DbHolder.create(applicationContext)
        WorkModule.create(applicationContext)
        ImageLoaderModule.create(applicationContext)
        ConnectivityObserver.init(applicationContext)
        BotApi.create()


    }
}