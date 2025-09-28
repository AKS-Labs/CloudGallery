package com.akslabs.cloudgallery.ui.main.screens.settings

import android.content.Intent
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.Image


import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.rounded.BugReport
import androidx.compose.material.icons.rounded.CloudDownload
import androidx.compose.material.icons.rounded.CloudSync
import androidx.compose.material.icons.rounded.CloudUpload
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material.icons.rounded.Language
import androidx.compose.material.icons.rounded.MoveToInbox
import androidx.compose.material.icons.rounded.Outbox
import androidx.compose.material.icons.rounded.Palette
import androidx.compose.material.icons.rounded.Security
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material.icons.rounded.Storage
import androidx.compose.material.icons.rounded.AccessTime
import androidx.compose.material.icons.rounded.AccountTree
import androidx.compose.material.icons.rounded.ArrowOutward
import androidx.compose.material.icons.rounded.AutoMode
import androidx.compose.material.icons.rounded.SignalCellularAlt
import androidx.compose.material.icons.rounded.Stars
import androidx.compose.material.icons.rounded.Description
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import androidx.work.NetworkType
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.akslabs.cloudgallery.R
import com.akslabs.cloudgallery.BuildConfig
import com.akslabs.cloudgallery.data.localdb.DbHolder
import com.akslabs.cloudgallery.data.localdb.Preferences
import com.akslabs.cloudgallery.data.localdb.backup.BackupHelper
import com.akslabs.cloudgallery.services.CloudPhotoSyncService
import com.akslabs.cloudgallery.utils.Constants
import com.akslabs.cloudgallery.utils.MetadataConfig
import com.akslabs.cloudgallery.utils.toastFromMainThread
import android.net.Uri
import androidx.compose.material.icons.rounded.Android
import androidx.compose.material.icons.rounded.Balance
import androidx.compose.material.icons.rounded.Code
import androidx.compose.material.icons.rounded.ThumbUp
import androidx.compose.ui.res.painterResource
import com.akslabs.cloudgallery.workers.WorkModule
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Section header component for grouping settings
 */
@Composable
private fun SettingsSection(
    title: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = title,
        style = MaterialTheme.typography.titleMedium,
        fontWeight = FontWeight.SemiBold,
        color = MaterialTheme.colorScheme.primary,
        modifier = modifier.padding(horizontal = 16.dp, vertical = 12.dp)
    )
}

/**
 * Settings item with switch toggle
 */
@Composable
private fun SettingsSwitchItem(
    icon: ImageVector,
    title: String,
    subtitle: String,
    isChecked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    enabled: Boolean = true,
    modifier: Modifier = Modifier
) {
    val alpha = if (enabled) 1f else 0.4f

    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable(enabled = enabled) { onCheckedChange(!isChecked) }
            .padding(horizontal = 16.dp, vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier.size(24.dp),
            tint = MaterialTheme.colorScheme.onSurface.copy(alpha = alpha)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Medium,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = alpha)
            )
            Text(
                text = subtitle,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = alpha)
            )
        }
        Switch(
            checked = isChecked,
            onCheckedChange = onCheckedChange,
            enabled = enabled
        )
    }
}

/**
 * Settings item with dialog selection
 */
@Composable
private fun SettingsDialogItem(
    icon: ImageVector,
    title: String,
    subtitle: String,
    currentValue: String,
    options: List<Pair<String, String>>, // Display name to value
    onValueChange: (String) -> Unit,
    enabled: Boolean = true,
    modifier: Modifier = Modifier
) {
    var showDialog by remember { mutableStateOf(false) }

    SettingsItem(
        icon = icon,
        title = title,
        subtitle = "$subtitle: $currentValue",
        onClick = { if (enabled) showDialog = true },
        enabled = enabled,
        modifier = modifier
    )

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            title = { Text(title) },
            text = {
                Column {
                    options.forEach { (displayName, value) ->
                        TextButton(
                            onClick = {
                                onValueChange(value)
                                showDialog = false
                            },
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = displayName,
                                modifier = Modifier.fillMaxWidth(),
                                style = MaterialTheme.typography.bodyLarge
                            )
                        }
                    }
                }
            },
            confirmButton = {
                TextButton(onClick = { showDialog = false }) {
                    Text("Cancel")
                }
            }
        )
    }
}

/**
 * Simple settings item component matching the target design
 */
@Composable
private fun SettingsItem(
    icon: ImageVector? = null,       // Built-in icon
    iconPainter: Painter? = null,          // Custom drawable / SVG
    title: String,
    subtitle: String,
    onClick: () -> Unit,
    enabled: Boolean = true,
    modifier: Modifier = Modifier
) {
    val alpha = if (enabled) 1f else 0.4f

    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable(enabled = enabled) { onClick() }
            .padding(horizontal = 16.dp, vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        when {
            icon != null -> {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    modifier = Modifier.size(24.dp),
                    tint = MaterialTheme.colorScheme.onSurface.copy(alpha = alpha)
                )
            }
            iconPainter != null -> {
                Image(
                    painter = iconPainter,
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)
                )
            }
        }

        Spacer(modifier = Modifier.width(16.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = title,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Medium,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = alpha)
            )
            Text(
                text = subtitle,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = alpha)
            )
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(modifier: Modifier = Modifier) {
    val scope = rememberCoroutineScope()
    val context = LocalContext.current


    fun openLinkFromHref(href: String) {
        context.startActivity(
            Intent(Intent.ACTION_VIEW, Uri.parse(href))
        )
    }

    // File launchers for import/export
    val exportBackupFileLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.CreateDocument(BackupHelper.JSON_MIME)
    ) {
        scope.launch(Dispatchers.IO) {
            BackupHelper.exportDatabase(it ?: return@launch, context)
        }
    }

    val importPhotosBackupFile = rememberLauncherForActivityResult(
        ActivityResultContracts.OpenDocument()
    ) {
        scope.launch(Dispatchers.IO) {
            BackupHelper.importDatabase(it ?: return@launch, context)
        }
    }

    val autoExportBackupFileLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.CreateDocument(BackupHelper.JSON_MIME)
    ) {
        it?.let { uri ->
            context.contentResolver.takePersistableUriPermission(
                uri,
                Intent.FLAG_GRANT_WRITE_URI_PERMISSION
            )
            Preferences.edit {
                putString(Preferences.autoExportDatabseLocation, uri.toString())
            }
            WorkModule.PeriodicDbExport.enqueue()
            scope.launch {
                context.toastFromMainThread("Periodic database export enabled")
            }
        }
    }

    // Settings state
    var isAutoPhotoBackupEnabled by remember {
        mutableStateOf(Preferences.getBoolean(Preferences.isAutoBackupEnabledKey, false))
    }
    var isAutoExportDatabaseEnabled by remember {
        mutableStateOf(Preferences.getBoolean(Preferences.isAutoExportDatabaseEnabledKey, false))
    }
    var isMetadataUploadEnabled by remember {
        mutableStateOf(MetadataConfig.shouldIncludeMetadata())
    }
    var backupStats by remember { mutableStateOf<BackupHelper.BackupStats?>(null) }
    val totalCloudPhotosCount by DbHolder.database.remotePhotoDao()
        .getTotalCountFlow().collectAsStateWithLifecycle(initialValue = 0)

    // Load backup stats
    LaunchedEffect(Unit) {
        backupStats = BackupHelper.getBackupStats()
    }

    val scrollState = rememberScrollState()
    Column(
        modifier = modifier
            .fillMaxWidth()
            .verticalScroll(scrollState)
    ) {
        TopAppBar(
            title = { Text(text = "Settings") },
            navigationIcon = {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back",
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .size(24.dp)
                        .clickable { (context as? androidx.activity.ComponentActivity)?.onBackPressedDispatcher?.onBackPressed() }
                )
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.surface.copy(alpha = 0.95f)
            )
        )
        Spacer(modifier = Modifier.height(8.dp))

        // BACKUP & SYNC SECTION
        SettingsSection(title = "Backup & Sync")

        SettingsSwitchItem(
            icon = Icons.Rounded.CloudSync,
            title = stringResource(R.string.auto_periodic_backup),
            subtitle = "Automatically backup photos to Telegram",
            isChecked = isAutoPhotoBackupEnabled,
            onCheckedChange = { enabled ->
                isAutoPhotoBackupEnabled = enabled
                Preferences.edit {
                    putBoolean(Preferences.isAutoBackupEnabledKey, enabled)
                }
                if (enabled) {
                    WorkModule.PeriodicBackup.enqueue()
                    scope.launch {
                        context.toastFromMainThread("Periodic backup enabled")
                    }
                } else {
                    WorkModule.PeriodicBackup.cancel()
                    scope.launch {
                        context.toastFromMainThread("Periodic backup cancelled")
                    }
                }
            }
        )

        SettingsDialogItem(
            icon = Icons.Rounded.AccessTime,
            title = stringResource(R.string.backup_interval),
            subtitle = "How often to backup photos",
            currentValue = remember {
                val intervals = listOf("Daily" to "1", "Weekly" to "7", "Biweekly" to "14", "Monthly" to "30")
                val current = Preferences.getString(Preferences.autoBackupIntervalKey, "7")
                intervals.find { it.second == current }?.first ?: "Weekly"
            },
            options = listOf("Daily" to "1", "Weekly" to "7", "Biweekly" to "14", "Monthly" to "30"),
            enabled = isAutoPhotoBackupEnabled,
            onValueChange = { value ->
                Preferences.edit {
                    putString(Preferences.autoBackupIntervalKey, value)
                }
                WorkModule.PeriodicBackup.enqueue(forceUpdate = true)
            }
        )

        SettingsDialogItem(
            icon = Icons.Rounded.SignalCellularAlt,
            title = stringResource(R.string.backup_network_type),
            subtitle = "Network type for backups",
            currentValue = remember {
                val networkTypes = listOf(
                    "All networks" to NetworkType.CONNECTED.name,
                    "Unmetered" to NetworkType.UNMETERED.name,
                    "Metered" to NetworkType.METERED.name,
                    "Not Roaming" to NetworkType.NOT_ROAMING.name
                )
                val current = Preferences.getString(Preferences.autoBackupNetworkTypeKey, NetworkType.CONNECTED.name)
                networkTypes.find { it.second == current }?.first ?: "All networks"
            },
            options = listOf(
                "All networks" to NetworkType.CONNECTED.name,
                "Unmetered" to NetworkType.UNMETERED.name,
                "Metered" to NetworkType.METERED.name,
                "Not Roaming" to NetworkType.NOT_ROAMING.name
            ),
            enabled = isAutoPhotoBackupEnabled,
            onValueChange = { value ->
                Preferences.edit {
                    putString(Preferences.autoBackupNetworkTypeKey, value)
                }
                WorkModule.PeriodicBackup.enqueue(forceUpdate = true)
            }
        )

        SettingsSwitchItem(
            icon = Icons.Rounded.Description,
            title = "Include Image Metadata",
            subtitle = "Upload EXIF data, camera info, and location with images",
            isChecked = isMetadataUploadEnabled,
            onCheckedChange = { enabled ->
                isMetadataUploadEnabled = enabled
                MetadataConfig.setIncludeMetadata(enabled)
                scope.launch {
                    val message = if (enabled) {
                        "Image metadata will be included with uploads"
                    } else {
                        "Image metadata will not be included with uploads"
                    }
                    context.toastFromMainThread(message)
                }
            }
        )

        SettingsItem(
            icon = Icons.Rounded.CloudUpload,
            title = "Backup Database to Telegram",
            subtitle = if (backupStats?.isUpToDate == true) {
                "✅ Backup is up to date (${backupStats?.lastBackupFilename})"
            } else {
                "Upload complete database to Telegram for safekeeping"
            },
            onClick = {
                scope.launch {
                    try {
                        context.toastFromMainThread("Uploading database to Telegram...")
                        val result = BackupHelper.uploadDatabaseToTelegram(context)
                        result.fold(
                            onSuccess = { message ->
                                context.toastFromMainThread("✅ $message")
                                backupStats = BackupHelper.getBackupStats()
                            },
                            onFailure = { error ->
                                context.toastFromMainThread("❌ Backup failed: ${error.message}")
                            }
                        )
                    } catch (e: Exception) {
                        context.toastFromMainThread("❌ Error: ${e.message}")
                    }
                }
            }
        )

        SettingsItem(
            icon = Icons.Rounded.CloudSync,
            title = "Sync Cloud Photos",
            subtitle = "Discover and sync photos from Telegram channel",
            onClick = {
                scope.launch {
                    try {
                        context.toastFromMainThread("Starting cloud photo sync...")
                        CloudPhotoSyncService.forceSync(context).collect { progress ->
                            if (progress.isComplete) {
                                val message = if (progress.errorMessage != null) {
                                    "Sync failed: ${progress.errorMessage}"
                                } else {
                                    "Sync complete! Found ${progress.totalFilesFound} new photos"
                                }
                                context.toastFromMainThread(message)
                            }
                        }
                    } catch (e: Exception) {
                        context.toastFromMainThread("Sync error: ${e.message}")
                    }
                }
            }
        )

        SettingsItem(
            icon = Icons.Rounded.CloudDownload,
            title = "Restore Missing Photos",
            subtitle = stringResource(R.string.photos_not_found_on_this_device, totalCloudPhotosCount),
            onClick = {
                WorkModule.RestoreMissingFromDevice.enqueue()
                scope.launch {
                    context.toastFromMainThread("Restoring task enqueued in the background")
                }
            }
        )

        // DATABASE MANAGEMENT SECTION
        SettingsSection(title = "Database Management")

        SettingsSwitchItem(
            icon = Icons.Rounded.AutoMode,
            title = stringResource(R.string.auto_export_database),
            subtitle = "Automatically export database to file",
            isChecked = isAutoExportDatabaseEnabled,
            onCheckedChange = { enabled ->
                isAutoExportDatabaseEnabled = enabled
                Preferences.edit {
                    putBoolean(Preferences.isAutoExportDatabaseEnabledKey, enabled)
                }
                if (enabled) {
                    autoExportBackupFileLauncher.launch(
                        context.getString(R.string.CloudGallery_auto_photos_backup_json)
                    )
                } else {
                    WorkModule.PeriodicDbExport.cancel()
                    scope.launch {
                        context.toastFromMainThread("Periodic database export cancelled")
                    }
                }
            }
        )

        SettingsDialogItem(
            icon = Icons.Rounded.AccessTime,
            title = "Auto Export Interval",
            subtitle = "How often to export database",
            currentValue = remember {
                val intervals = listOf("Weekly" to "7", "Biweekly" to "14", "Monthly" to "30")
                val current = Preferences.getString(Preferences.autoExportDatabaseIntervalKey, "7")
                intervals.find { it.second == current }?.first ?: "Weekly"
            },
            options = listOf("Weekly" to "7", "Biweekly" to "14", "Monthly" to "30"),
            enabled = isAutoExportDatabaseEnabled,
            onValueChange = { value ->
                Preferences.edit {
                    putString(Preferences.autoExportDatabaseIntervalKey, value)
                }
                WorkModule.PeriodicDbExport.enqueue(forceUpdate = true)
            }
        )

        SettingsItem(
            icon = Icons.Rounded.MoveToInbox,
            title = stringResource(R.string.import_database),
            subtitle = "Import database backup from file",
            onClick = {
                importPhotosBackupFile.launch(arrayOf(BackupHelper.JSON_MIME))
            }
        )

        SettingsItem(
            icon = Icons.Rounded.Outbox,
            title = stringResource(R.string.export_database),
            subtitle = "Export database to file for backup",
            onClick = {
                exportBackupFileLauncher.launch(
                    context.getString(R.string.CloudGallery_photos_backup_json)
                )
            }
        )

        SettingsItem(
            icon = Icons.Rounded.Info,
            title = "View Database Status",
            subtitle = "View current database and backup information",
            onClick = {
                scope.launch {
                    val stats = BackupHelper.getBackupStats()
                    val message = buildString {
                        appendLine("📊 Database Status:")
                        appendLine("• Photos: ${stats.currentPhotos}")
                        appendLine("• Remote Photos: ${stats.currentRemotePhotos}")
                        appendLine()
                        if (stats.lastBackupTime > 0) {
                            appendLine("☁️ Last Backup:")
                            appendLine("• File: ${stats.lastBackupFilename}")
                            appendLine("• Time: ${java.text.SimpleDateFormat("yyyy-MM-dd HH:mm", java.util.Locale.getDefault()).format(java.util.Date(stats.lastBackupTime))}")
                            appendLine("• Status: ${if (stats.isUpToDate) "✅ Up to date" else "⚠️ Needs backup"}")
                        } else {
                            appendLine("☁️ No backup found")
                        }
                    }
                    android.util.Log.i("DatabaseStatus", message)
                    context.toastFromMainThread("Database status logged - check logcat")
                }
            }
        )

        // PRIVACY & SECURITY SECTION
        SettingsSection(title = "Privacy & Security")

        SettingsItem(
            icon = Icons.Rounded.Security,
            title = "Data Protection",
            subtitle = "App is completely private with no telemetry",
            onClick = {
                scope.launch {
                    context.toastFromMainThread("✅ App is 100% private - no data collection or tracking")
                }
            }
        )

        // ABOUT SECTION
        SettingsSection(title = "About")

        SettingsItem(
            icon = Icons.Rounded.Android,
            title = "More Apps",
            subtitle = "More Apps By AKS-Labs",
            onClick = {
                openLinkFromHref(Constants.moreApps)
            }
        )

        SettingsItem(
            iconPainter = painterResource(id = R.drawable.telegram),
            title = "Join Telegram",
            subtitle = "Join Telegram Community 0f AKS-Labs",
            onClick = { openLinkFromHref(Constants.joinTelegra) }
        )

        SettingsItem(
            icon = Icons.Rounded.Info,
            title = "Version",
            subtitle = "${BuildConfig.VERSION_NAME} (${BuildConfig.VERSION_CODE})",
            onClick = {
                scope.launch {
                    context.toastFromMainThread("Version ${BuildConfig.VERSION_NAME}")
                }
            }
        )

        SettingsItem(
            icon = Icons.Rounded.Code,
            title = "Source Code",
            subtitle = "View the project on GitHub",
            onClick = {
                openLinkFromHref(Constants.REPO_GITHUB)
            }
        )

        SettingsItem(
            icon = Icons.Rounded.Balance,
            title = "License",
            subtitle = "View the project license",
            onClick = {
                openLinkFromHref(Constants.LICENSE)
            }
        )

        SettingsItem(
            icon = Icons.Rounded.ThumbUp,
            title = "Donate",
            subtitle = "Help me keep the app alive",
            onClick = {
                openLinkFromHref(Constants.Donate)
            }
        )

        SettingsItem(
            icon = Icons.Rounded.ArrowOutward,
            title = "Contributors",
            subtitle = "See contributors on GitHub",
            onClick = {
                openLinkFromHref(Constants.CONTRIBUTORS_GITHUB)
            }
        )

        Spacer(modifier = Modifier.height(16.dp))
    }
}