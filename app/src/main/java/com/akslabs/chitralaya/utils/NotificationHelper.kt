package com.akslabs.cloudgallery.utils

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import com.akslabs.cloudgallery.R
import com.akslabs.cloudgallery.ui.MainActivity

/**
 * Helper class for creating and managing notifications
 */
object NotificationHelper {

    private const val CLOUD_SYNC_CHANNEL_ID = "cloud_sync_channel"
    private const val CLOUD_SYNC_CHANNEL_NAME = "Cloud Photo Sync"
    private const val CLOUD_SYNC_CHANNEL_DESCRIPTION = "Notifications for cloud photo synchronization"
    private const val CLOUD_SYNC_COMPLETE_NOTIFICATION_ID = 2002
    private const val CLOUD_SYNC_ERROR_NOTIFICATION_ID = 2003
    private const val BACKUP_CHANNEL_ID = "backup_channel"
    private const val BACKUP_CHANNEL_NAME = "Backup"
    private const val BACKUP_CHANNEL_DESCRIPTION = "Notifications for backup"
    private const val BACKUP_NOTIFICATION_ID = 2004

    /**
     * Create notification channel for cloud sync notifications
     */
    fun createNotificationChannels(context: Context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

            // Cloud sync channel
            val cloudSyncChannel = NotificationChannel(
                CLOUD_SYNC_CHANNEL_ID,
                CLOUD_SYNC_CHANNEL_NAME,
                NotificationManager.IMPORTANCE_LOW
            ).apply {
                description = CLOUD_SYNC_CHANNEL_DESCRIPTION
                setShowBadge(false)
            }
            notificationManager.createNotificationChannel(cloudSyncChannel)

            // Backup channel
            val backupChannel = NotificationChannel(
                BACKUP_CHANNEL_ID,
                BACKUP_CHANNEL_NAME,
                NotificationManager.IMPORTANCE_DEFAULT
            ).apply {
                description = BACKUP_CHANNEL_DESCRIPTION
                setShowBadge(false)
            }
            notificationManager.createNotificationChannel(backupChannel)
        }
    }

    /**
     * Create notification for ongoing cloud sync operation
     */
    fun createCloudSyncNotification(
        context: Context,
        title: String,
        content: String
    ): Notification {
        val intent = Intent(context, MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(
            context,
            0,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        return NotificationCompat.Builder(context, CLOUD_SYNC_CHANNEL_ID)
            .setContentTitle(title)
            .setContentText(content)
            .setSmallIcon(R.drawable.ic_launcher_foreground) // Use your app icon
            .setContentIntent(pendingIntent)
            .setOngoing(true)
            .setProgress(0, 0, true) // Indeterminate progress
            .setPriority(NotificationCompat.PRIORITY_LOW)
            .setCategory(NotificationCompat.CATEGORY_PROGRESS)
            .build()
    }

    /**
     * Show notification when cloud sync completes with new photos found
     */
    fun showCloudSyncCompleteNotification(
        context: Context,
        newPhotosCount: Int
    ) {
        val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        val intent = Intent(context, MainActivity::class.java).apply {
            // Navigate to cloud photos screen
            putExtra("navigate_to", "cloud_photos")
        }

        val pendingIntent = PendingIntent.getActivity(
            context,
            1,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        val notification = NotificationCompat.Builder(context, CLOUD_SYNC_CHANNEL_ID)
            .setContentTitle("Cloud Photos Synced")
            .setContentText("Found $newPhotosCount new photos from your Telegram backup")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setCategory(NotificationCompat.CATEGORY_STATUS)
            .build()

        notificationManager.notify(CLOUD_SYNC_COMPLETE_NOTIFICATION_ID, notification)
    }

    /**
     * Show notification for sync errors
     */
    fun showCloudSyncErrorNotification(
        context: Context,
        errorMessage: String
    ) {
        val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        val intent = Intent(context, MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(
            context,
            2,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        val notification = NotificationCompat.Builder(context, CLOUD_SYNC_CHANNEL_ID)
            .setContentTitle("Cloud Sync Failed")
            .setContentText("Error syncing photos: $errorMessage")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setCategory(NotificationCompat.CATEGORY_ERROR)
            .build()

        notificationManager.notify(CLOUD_SYNC_ERROR_NOTIFICATION_ID, notification)
    }

    fun showBackupStartedNotification(context: Context) {
        val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val notification = NotificationCompat.Builder(context, BACKUP_CHANNEL_ID)
            .setContentTitle("Backup Started")
            .setContentText("Uploading pending photos.")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setOngoing(true)
            .build()
        notificationManager.notify(BACKUP_NOTIFICATION_ID, notification)
    }

    fun showBackupStoppedNotification(context: Context) {
        val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val notification = NotificationCompat.Builder(context, BACKUP_CHANNEL_ID)
            .setContentTitle("Backup Stopped")
            .setContentText("Backup was stopped by the user.")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .build()
        notificationManager.notify(BACKUP_NOTIFICATION_ID, notification)
    }

    fun cancelBackupNotification(context: Context) {
        val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.cancel(BACKUP_NOTIFICATION_ID)
    }
}
