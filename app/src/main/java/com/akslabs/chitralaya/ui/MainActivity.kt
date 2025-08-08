package com.akslabs.cloudgallery.ui

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.dialog
import androidx.navigation.compose.rememberNavController
import com.akslabs.cloudgallery.data.localdb.Preferences
import com.akslabs.cloudgallery.debug.DatabaseDebugHelper
import com.akslabs.cloudgallery.ui.main.MainPage
import com.akslabs.cloudgallery.ui.main.MainViewModel
import com.akslabs.cloudgallery.ui.main.nav.screenScopedViewModel
import com.akslabs.cloudgallery.ui.onboarding.OnboardingPage
import com.akslabs.cloudgallery.ui.permission.PermissionDialogScreen
import com.akslabs.cloudgallery.ui.permission.PermissionViewModel
import com.akslabs.cloudgallery.ui.theme.AppTheme
import com.akslabs.cloudgallery.utils.NotificationHelper
import com.akslabs.cloudgallery.workers.WorkModule
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    private val isSdkAbove33 = Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU
    private var hasPhotosPerm by mutableStateOf(false)
    private var startDestination by mutableStateOf(ScreenFlow.Onboarding.route)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize notification channels
        NotificationHelper.createNotificationChannels(this)

        // Debug database state on app startup
        lifecycleScope.launch {
            DatabaseDebugHelper.debugDatabaseState(this@MainActivity)
        }

        // Initialize cloud photo sync on app startup
        initializeCloudPhotoSync()

        // Start daily database backup
        WorkModule.DailyDatabaseBackup.enqueuePeriodic()

        setContent {
            AppTheme {
                val topNavController = rememberNavController()
                NavHost(navController = topNavController, startDestination = startDestination) {
                    composable(ScreenFlow.Onboarding.route) {
                        OnboardingPage(onProceed = {
                            val navigateToRoute = if (hasPhotosPerm) {
                                ScreenFlow.Main.route
                            } else {
                                ScreenFlow.Permission.route
                            }
                            topNavController.navigate(navigateToRoute) {
                                popUpTo(ScreenFlow.Onboarding.route) { inclusive = true }
                            }
                        })
                    }
                    composable(ScreenFlow.Main.route) {
                        val viewModel: MainViewModel = screenScopedViewModel()
                        MainPage(viewModel)
                    }
                    dialog(ScreenFlow.Permission.route) {
                        val viewModel: PermissionViewModel = screenScopedViewModel()
                        val dialogQueue = viewModel.visiblePermissionDialogQueue

                        val permissionsToRequest = remember {
                            if (isSdkAbove33) {
                                arrayOf(
                                    Manifest.permission.READ_MEDIA_IMAGES,
                                    Manifest.permission.POST_NOTIFICATIONS
                                )
                            } else {
                                arrayOf(
                                    Manifest.permission.READ_EXTERNAL_STORAGE
                                )
                            }
                        }

                        PermissionDialogScreen(
                            permissionsToRequest = permissionsToRequest,
                            onPermissionLauncherResult = { perms: Map<String, Boolean> ->
                                permissionsToRequest.forEach { permission ->
                                    viewModel.onPermissionResult(
                                        permission,
                                        isGranted = perms[permission] == true
                                    )
                                }
                                if (isSdkAbove33) {
                                    perms[Manifest.permission.READ_MEDIA_IMAGES]?.let { isGranted ->
                                        hasPhotosPerm = isGranted
                                    }
                                } else {
                                    perms[Manifest.permission.READ_EXTERNAL_STORAGE]?.let { isGranted ->
                                        hasPhotosPerm = isGranted
                                    }
                                }
                            },
                            dialogQueue = dialogQueue,
                            isPermanentyDeclined = { permission ->
                                !shouldShowRequestPermissionRationale(
                                    permission
                                )
                            },
                            onGoToAppSettingsClick = { openAppSettings() },
                            onDismissDialog = { viewModel.dismissDialog() },
                            onOkClick = { viewModel.dismissDialog() }
                        )
                    }
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        hasPhotosPerm = if (isSdkAbove33) {
            ContextCompat.checkSelfPermission(
                this@MainActivity,
                Manifest.permission.READ_MEDIA_IMAGES
            ) == PackageManager.PERMISSION_GRANTED
        } else {
            ContextCompat.checkSelfPermission(
                this@MainActivity,
                Manifest.permission.READ_EXTERNAL_STORAGE
            ) == PackageManager.PERMISSION_GRANTED
        }
        startDestination = when {
            Preferences.getEncryptedLong(Preferences.channelId, 0) == 0L -> ScreenFlow.Onboarding.route
            !hasPhotosPerm -> ScreenFlow.Permission.route
            else -> ScreenFlow.Main.route
        }
    }

    /**
     * Initialize cloud photo sync workers for automatic background sync
     */
    private fun initializeCloudPhotoSync() {
        lifecycleScope.launch {
            try {
                // Start periodic cloud photo sync (daily)
                WorkModule.CloudPhotoSync.enqueue()

                // Start quick sync (every 6 hours)
                WorkModule.QuickCloudSync.enqueue()

                // Trigger an immediate one-time sync if this is a fresh install
                // or if it's been a while since last sync
                val lastSyncTime = try {
                    Preferences.getLong("last_cloud_photo_sync_timestamp", 0L)
                } catch (e: ClassCastException) {
                    Log.w("MainActivity", "Invalid sync timestamp format, resetting to 0", e)
                    // Clear the invalid value and set default
                    Preferences.edit { remove("last_cloud_photo_sync_timestamp") }
                    0L
                }
                val daysSinceLastSync = (System.currentTimeMillis() - lastSyncTime) / (1000 * 60 * 60 * 24)

                if (lastSyncTime == 0L || daysSinceLastSync > 1) {
                    // Trigger immediate sync for new installs or if it's been more than a day
                    WorkModule.CloudPhotoSync.enqueueOneTime()
                }

            } catch (e: Exception) {
                // Log error but don't crash the app
                android.util.Log.e("MainActivity", "Error initializing cloud photo sync", e)
            }
        }
    }
}

sealed class ScreenFlow(val route: String) {
    data object Onboarding : ScreenFlow("onboard")
    data object Main : ScreenFlow("main")
    data object Permission : ScreenFlow("permission")
}

fun Activity.openAppSettings() {
    Intent(
        Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
        Uri.fromParts("package", packageName, null)
    ).also(::startActivity)
}