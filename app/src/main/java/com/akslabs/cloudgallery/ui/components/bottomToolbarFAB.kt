package com.akslabs.cloudgallery.ui.components

import android.net.http.SslCertificate.restoreState
import android.net.http.SslCertificate.saveState
import android.widget.Toast
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowUpward
import androidx.compose.material.icons.rounded.Cloud
import androidx.compose.material.icons.rounded.PhoneAndroid
import androidx.compose.material.icons.rounded.Stop
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.FloatingToolbarDefaults
import androidx.compose.material3.HorizontalFloatingToolbar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.TooltipBox
import androidx.compose.material3.TooltipDefaults
import androidx.compose.material3.PlainTooltip
import androidx.compose.material3.rememberTooltipState
import androidx.compose.material3.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.launch
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
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
import com.akslabs.cloudgallery.ui.theme.AnimationConstants

@OptIn(ExperimentalMaterial3ExpressiveApi::class, ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
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
        targetValue = -40f,
        animationSpec = infiniteRepeatable(
            animation = tween(1200, easing = AnimationConstants.EmphasizedEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "upload_offset"
    )
    val alpha by transition.animateFloat(
        initialValue = 1f,
        targetValue = 0.2f,
        animationSpec = infiniteRepeatable(
            animation = tween(1200, easing = AnimationConstants.EmphasizedEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "upload_alpha"
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
            val containerColor = if (isUploading) MaterialTheme.colorScheme.tertiaryContainer else MaterialTheme.colorScheme.primaryContainer
            val contentColor = if (isUploading) MaterialTheme.colorScheme.onTertiaryContainer else MaterialTheme.colorScheme.onPrimaryContainer

            val tooltipState = rememberTooltipState()
            val scope = rememberCoroutineScope()
            
            LaunchedEffect(isUploading) {
                if (isUploading) {
                    tooltipState.show()
                }
            }

            TooltipBox(
                positionProvider = TooltipDefaults.rememberPlainTooltipPositionProvider(
                    spacingBetweenTooltipAndAnchor = 56.dp
                ),
                tooltip = {
                    PlainTooltip(
                        containerColor = MaterialTheme.colorScheme.inverseSurface,
                        contentColor = MaterialTheme.colorScheme.inverseOnSurface,
                        shape = androidx.compose.foundation.shape.RoundedCornerShape(16.dp)
                    ) {
                        Text(
                            text = "Long press to manage uploads",
                            style = MaterialTheme.typography.titleSmall,
                            modifier = Modifier.padding(6.dp)
                        )
                    }
                },
                state = tooltipState
            ) {
                Surface(
                    modifier = Modifier
                        .width(66.dp)
                        .height(40.dp) // Standard IconButton height
                        .clip(FloatingToolbarDefaults.ContainerShape)
                        .combinedClickable(
                            onClick = {
                                scope.launch { tooltipState.show() }
                                haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                                if (isUploading) {
                                    try {
                                        workManager.cancelAllWorkByTag("manual_backup")
                                        workManager.cancelAllWorkByTag("instant_upload")
                                        workManager.cancelUniqueWork("InstantPhotoBackupWork")
                                        workManager.cancelUniqueWork(WorkModule.PERIODIC_PHOTO_BACKUP_WORK)
                                        
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
                                    try {
                                        workManager.enqueue(backupWorkRequest)
                                        Toast.makeText(context, "Backup started", Toast.LENGTH_SHORT).show()
                                        NotificationHelper.showBackupStartedNotification(context)
                                    } catch (e: Exception) {
                                        Toast.makeText(context, "Error starting backup", Toast.LENGTH_SHORT).show()
                                    }
                                }
                            },
                            onLongClick = {
                                haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                                navController.navigate(Screens.ManageUploads.route)
                            }
                        ),
                    shape = FloatingToolbarDefaults.ContainerShape,
                    color = containerColor,
                    contentColor = contentColor
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        if (isUploading) {
                            Box(contentAlignment = Alignment.Center) {
                                Icon(
                                    imageVector = Icons.Rounded.ArrowUpward,
                                    contentDescription = "Uploading",
                                    modifier = Modifier
                                        .offset(y = offsetY.dp)
                                        .graphicsLayer { this.alpha = alpha },
                                    tint = contentColor
                                )
                            }
                        } else {
                            Icon(
                                imageVector = Icons.Rounded.ArrowUpward,
                                contentDescription = "Upload"
                            )
                        }
                    }
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
            imageVector = Icons.Rounded.PhoneAndroid,
            contentDescription = "Device Photos",
            tint = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurfaceVariant
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
            imageVector = Icons.Rounded.Cloud,
            contentDescription = "Cloud Photos",
            tint = if (isCloudSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}
