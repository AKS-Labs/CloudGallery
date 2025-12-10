package com.akslabs.chitralaya.ui.components

import android.net.http.SslCertificate.restoreState
import android.net.http.SslCertificate.saveState
import android.widget.Toast
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowUpward
import androidx.compose.material.icons.filled.Cloud
import androidx.compose.material.icons.filled.PhoneAndroid
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.FloatingToolbarDefaults
import androidx.compose.material3.HorizontalFloatingToolbar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.akslabs.cloudgallery.ui.main.nav.Screens
import com.akslabs.cloudgallery.workers.PeriodicPhotoBackupWorker
import androidx.compose.material3.LocalContentColor
import com.akslabs.cloudgallery.ui.main.MainViewModel
import com.akslabs.cloudgallery.utils.NotificationHelper
import com.akslabs.cloudgallery.workers.WorkModule
import com.akslabs.cloudgallery.data.localdb.Preferences

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun BottomToolbarFAB(
    expanded: Boolean,
    onExpandedChange: (Boolean) -> Unit,
    navController: NavHostController,
    viewModel: MainViewModel,
    modifier: Modifier = Modifier,
) {
    val haptic = LocalHapticFeedback.current
    val isUploading by viewModel.isUploading.collectAsStateWithLifecycle()
    val context = LocalContext.current
    val workManager = WorkManager.getInstance(context)
    val backupWorkRequest = OneTimeWorkRequestBuilder<PeriodicPhotoBackupWorker>()
        .addTag("manual_backup")
        .build()

    val transition = rememberInfiniteTransition(label = "")
    val offsetY by transition.animateFloat(
        initialValue = 0f,
        targetValue = -60f,
        animationSpec = infiniteRepeatable(
            animation = tween(1500, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = ""
    )
    val alpha by transition.animateFloat(
        initialValue = 1f,
        targetValue = 0f,
        animationSpec = infiniteRepeatable(
            animation = tween(1500, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = ""
    )

    HorizontalFloatingToolbar(
        modifier = modifier
            .offset(y = -FloatingToolbarDefaults.ScreenOffset)
            .shadow(6.dp, FloatingToolbarDefaults.ContainerShape)
            .clip(FloatingToolbarDefaults.ContainerShape)
            .zIndex(1f),
        expanded = expanded,
        leadingContent = { LeadingContent(navController) },
        trailingContent = { TrailingContent(navController) },
        content = {
            FilledIconButton(
                modifier = Modifier.width(66.dp),
                onClick = {
                    haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                    if (isUploading) {
                        // Stop all uploads (manual, instant, and current periodic if running)
                        try {
                            workManager.cancelAllWorkByTag("manual_backup")
                            workManager.cancelAllWorkByTag("instant_upload")
                            // Also cancel the instant periodic backup worker if it's running
                            workManager.cancelUniqueWork("InstantPhotoBackupWork")
                            // Cancel periodic worker if it's currently running
                            workManager.cancelUniqueWork(WorkModule.PERIODIC_PHOTO_BACKUP_WORK)
                            
                            // If auto-backup is enabled, we must re-schedule the periodic worker
                            // so it runs again at the next interval (without triggering immediate work now)
                            val isAutoBackupEnabled = Preferences.getBoolean(Preferences.isAutoBackupEnabledKey, false)
                            if (isAutoBackupEnabled) {
                                WorkModule.PeriodicBackup.enqueue(onlySchedule = true)
                            }

                            Toast.makeText(context, "Upload stopped", Toast.LENGTH_SHORT).show()
                            NotificationHelper.showBackupStoppedNotification(context)
                        } catch (e: Exception) {
                            Toast.makeText(context, "Error stopping upload", Toast.LENGTH_SHORT).show()
                        }
                    } else {
                        // Start manual backup
                        try {
                            workManager.enqueue(backupWorkRequest)
                            Toast.makeText(context, "Backup started", Toast.LENGTH_SHORT).show()
                            NotificationHelper.showBackupStartedNotification(context)
                        } catch (e: Exception) {
                            Toast.makeText(context, "Error starting backup", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            ) {
                if (isUploading) {
                    Icon(
                        imageVector = Icons.Filled.ArrowUpward,
                        contentDescription = "Uploading",
                        modifier = Modifier
                            .offset(y = offsetY.dp)
                            .zIndex(1f),
                        tint = LocalContentColor.current.copy(alpha = alpha)
                    )
                } else {
                    Icon(
                        imageVector = Icons.Filled.ArrowUpward,
                        contentDescription = "Upload"
                    )
                }
            }
        },
    )
}

@Composable
private fun LeadingContent(navController: NavHostController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val isDarkTheme = isSystemInDarkTheme()
    val isSelected = currentRoute == Screens.LocalPhotos.route

    IconButton(
        onClick = {
            navController.navigate(Screens.LocalPhotos.route) {
                popUpTo(navController.graph.startDestinationId) { saveState = true }
                launchSingleTop = true
                restoreState = true
            }
        }
    ) {
        Icon(
            imageVector = Icons.Filled.PhoneAndroid,
            contentDescription = "Device Photos",
            tint = when {
                isSelected -> MaterialTheme.colorScheme.primary
                isDarkTheme -> Color.White
                else -> Color.Black
            }
        )
    }

    Spacer(modifier = Modifier.size(18.dp))
}

@Composable
private fun TrailingContent(navController: NavHostController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val isCloudSelected = currentRoute == Screens.RemotePhotos.route
    val isDarkTheme = isSystemInDarkTheme()

    Spacer(modifier = Modifier.size(18.dp))

    IconButton(
        onClick = {
            navController.navigate(Screens.RemotePhotos.route) {
                popUpTo(navController.graph.startDestinationId) { saveState = true }
                launchSingleTop = true
                restoreState = true
            }
        }
    ) {
        Icon(
            imageVector = Icons.Filled.Cloud,
            contentDescription = "Cloud Photos",
            tint = when {
                isCloudSelected -> MaterialTheme.colorScheme.primary
                isDarkTheme -> Color.White
                else -> Color.Black
            }
        )
    }
}
