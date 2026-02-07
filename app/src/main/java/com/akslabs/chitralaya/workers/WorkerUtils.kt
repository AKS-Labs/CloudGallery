package com.akslabs.cloudgallery.workers

import android.Manifest
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import com.akslabs.cloudgallery.R
import com.akslabs.cloudgallery.workers.WorkModule.CHANNEL_ID
import com.akslabs.cloudgallery.workers.WorkModule.NOTIFICATION_TITLE
import com.akslabs.cloudgallery.workers.WorkModule.VERBOSE_NOTIFICATION_CHANNEL_DESCRIPTION
import com.akslabs.cloudgallery.workers.WorkModule.VERBOSE_NOTIFICATION_CHANNEL_NAME
import androidx.work.ForegroundInfo

private const val TAG = "WorkerUtils"

/**
 * Create a ForegroundInfo object for long-running worker tasks.
 */
fun createForegroundInfo(context: Context, id: Int, message: String): androidx.work.ForegroundInfo {
    val notification = makeStatusNotification(message, context)
    
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.UPSIDE_DOWN_CAKE) {
        androidx.work.ForegroundInfo(
            id,
            notification,
            android.content.pm.ServiceInfo.FOREGROUND_SERVICE_TYPE_DATA_SYNC
        )
    } else {
        androidx.work.ForegroundInfo(id, notification)
    }
}

/**
 * Create a Notification that is shown as a heads-up notification if possible.
 */
fun makeStatusNotification(message: String, context: Context): Notification {
    val name = VERBOSE_NOTIFICATION_CHANNEL_NAME
    val description = VERBOSE_NOTIFICATION_CHANNEL_DESCRIPTION
    val importance = NotificationManager.IMPORTANCE_LOW
    val channel = NotificationChannel(CHANNEL_ID, name, importance)
    channel.description = description

    val notificationManager =
        context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager?

    notificationManager?.createNotificationChannel(channel)

    val builder = NotificationCompat.Builder(context, CHANNEL_ID)
        .setSmallIcon(R.drawable.ic_launcher_foreground)
        .setContentTitle(NOTIFICATION_TITLE)
        .setContentText(message)
        .setPriority(NotificationCompat.PRIORITY_LOW)
        .setOngoing(true)

    return builder.build()
}