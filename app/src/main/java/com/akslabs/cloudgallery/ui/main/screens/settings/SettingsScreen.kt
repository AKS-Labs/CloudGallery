package com.akslabs.cloudgallery.ui.main.screens.settings

import android.content.Intent
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.rounded.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.work.NetworkType
import androidx.work.WorkManager
import com.akslabs.cloudgallery.BuildConfig
import com.akslabs.cloudgallery.R
import com.akslabs.cloudgallery.data.localdb.DbHolder
import com.akslabs.cloudgallery.data.localdb.Preferences
import com.akslabs.cloudgallery.data.localdb.backup.BackupHelper
import com.akslabs.cloudgallery.services.CloudPhotoSyncService
import com.akslabs.cloudgallery.utils.Constants
import com.akslabs.cloudgallery.utils.MetadataConfig
import com.akslabs.cloudgallery.utils.toastFromMainThread
import com.akslabs.cloudgallery.workers.WorkModule
import com.akslabs.cloudgallery.ui.components.SupportSheet
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
/**
 * Section header component for grouping settings
 */


@Composable
fun SettingsSection(
    title: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = title.uppercase(),
        style = MaterialTheme.typography.labelLarge,
        fontWeight = FontWeight.Bold,
        color = MaterialTheme.colorScheme.primary,
        modifier = modifier
            .padding(horizontal = 28.dp, vertical = 8.dp)
            .padding(top = 16.dp)
    )
}

/**
 * Settings item with switch toggle
 */
@Composable
fun SettingsSwitchItem(
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
            .padding(horizontal = 20.dp, vertical = 14.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        val iconContainerColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.3f * alpha)
        val iconColor = MaterialTheme.colorScheme.primary.copy(alpha = alpha)

        Box(
            modifier = Modifier
                .size(42.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(iconContainerColor),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                modifier = Modifier.size(24.dp),
                tint = iconColor
            )
        }
        Spacer(modifier = Modifier.width(16.dp))
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold,
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
            enabled = enabled,
            colors = SwitchDefaults.colors(
                checkedThumbColor = MaterialTheme.colorScheme.primary,
                checkedTrackColor = MaterialTheme.colorScheme.primaryContainer
            )
        )
    }
}

/**
 * Settings item with expressive selection layout
 */
@Composable
 fun SettingsDialogItem(
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
        subtitle = if (enabled) "$subtitle: $currentValue" else subtitle,
        onClick = { if (enabled) showDialog = true },
        enabled = enabled,
        modifier = modifier
    )

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            title = { 
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                ) 
            },
            text = {
                Column(
                    verticalArrangement = Arrangement.spacedBy(10.dp),
                    modifier = Modifier.padding(top = 8.dp)
                ) {
                    options.forEach { (displayName, value) ->
                        val isSelected = currentValue == displayName
                        Surface(
                            onClick = {
                                onValueChange(value)
                                showDialog = false
                            },
                            shape = RoundedCornerShape(16.dp),
                            color = if (isSelected) MaterialTheme.colorScheme.primaryContainer else MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f),
                            border = if (isSelected) androidx.compose.foundation.BorderStroke(2.dp, MaterialTheme.colorScheme.primary) else null,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Row(
                                modifier = Modifier.padding(16.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = displayName,
                                    style = MaterialTheme.typography.bodyLarge,
                                    fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                                    color = if (isSelected) MaterialTheme.colorScheme.onPrimaryContainer else MaterialTheme.colorScheme.onSurface
                                )
                                if (isSelected) {
                                    Spacer(modifier = Modifier.weight(1f))
                                    Icon(
                                        imageVector = Icons.Rounded.Check,
                                        contentDescription = null,
                                        tint = MaterialTheme.colorScheme.primary
                                    )
                                }
                            }
                        }
                    }
                }
            },
            confirmButton = {
                TextButton(onClick = { showDialog = false }) {
                    Text("Close")
                }
            }
        )
    }
}

/**
 * Simple settings item component matching the target design
 */
@Composable
fun SettingsItem(
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
            .padding(horizontal = 20.dp, vertical = 14.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        val iconContainerColor = MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.3f * alpha)
        val iconColor = MaterialTheme.colorScheme.secondary.copy(alpha = alpha)

        Box(
            modifier = Modifier
                .size(42.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(iconContainerColor),
            contentAlignment = Alignment.Center
        ) {
            when {
                icon != null -> {
                    Icon(
                        imageVector = icon,
                        contentDescription = null,
                        modifier = Modifier.size(24.dp),
                        tint = iconColor
                    )
                }
                iconPainter != null -> {
                    Image(
                        painter = iconPainter,
                        contentDescription = null,
                        modifier = Modifier.size(24.dp),
                        colorFilter = androidx.compose.ui.graphics.ColorFilter.tint(iconColor)
                    )
                }
            }
        }

        Spacer(modifier = Modifier.width(16.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold,
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
fun SettingsScreen(modifier: Modifier = Modifier.clip(RoundedCornerShape(32.dp)).background(MaterialTheme.colorScheme.background)) {
    val scope = rememberCoroutineScope()
    val context = LocalContext.current

    var showDialog by remember { mutableStateOf(false) }
    var dialogMessage by remember { mutableStateOf("") }

    // SupportSheet State
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    var showSupportSheet by remember { mutableStateOf(false) }

    if (showSupportSheet) {
        SupportSheet(
            sheetState = sheetState,
            onDismissRequest = { showSupportSheet = false }
        )
    }

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
    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior(rememberTopAppBarState())

    Scaffold(
        modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
                LargeTopAppBar(
                    title = {
                        Text(
                            text = "Settings",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold,
                        )
                    },
                navigationIcon = {
                    IconButton(onClick = { (context as? androidx.activity.ComponentActivity)?.onBackPressedDispatcher?.onBackPressed() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                },
                scrollBehavior = scrollBehavior,
                colors = TopAppBarDefaults.largeTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background,
                    scrolledContainerColor = MaterialTheme.colorScheme.background
                )
            )
        },
        containerColor = MaterialTheme.colorScheme.background
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 12.dp)
        ) {
            // BACKUP & SYNC SECTION
            SettingsSection(title = "Backup & Sync")
            Surface(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(24.dp),
                color = MaterialTheme.colorScheme.surfaceContainerLow
            ) {
                Column {
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
                                try {
                                    val workManager = WorkManager.getInstance(context)
                                    workManager.cancelAllWorkByTag("manual_backup")
                                    workManager.cancelAllWorkByTag("instant_upload")
                                } catch (e: Exception) {
                                    android.util.Log.e("SettingsScreen", "Error cancelling uploads", e)
                                }
                                WorkModule.PeriodicBackup.cancel()
                                scope.launch {
                                    context.toastFromMainThread("Periodic backup cancelled")
                                }
                            }
                        }
                    )

                    var currentInterval by remember {
                        mutableStateOf(
                            run {
                                val intervals = listOf("Daily" to "1", "Weekly" to "7", "Biweekly" to "14", "Monthly" to "30")
                                val current = Preferences.getString(Preferences.autoBackupIntervalKey, "7")
                                intervals.find { it.second == current }?.first ?: "Weekly"
                            }
                        )
                    }

                    SettingsDialogItem(
                        icon = Icons.Rounded.AccessTime,
                        title = stringResource(R.string.backup_interval),
                        subtitle = "How often to backup photos",
                        currentValue = currentInterval,
                        options = listOf("Daily" to "1", "Weekly" to "7", "Biweekly" to "14", "Monthly" to "30"),
                        enabled = isAutoPhotoBackupEnabled,
                        onValueChange = { value ->
                            Preferences.edit {
                                putBoolean(Preferences.isAutoBackupEnabledKey, true)
                                putString(Preferences.autoBackupIntervalKey, value)
                            }
                            val selectedLabel = listOf("Daily" to "1", "Weekly" to "7", "Biweekly" to "14", "Monthly" to "30")
                                .find { it.second == value }?.first ?: "Weekly"
                            currentInterval = selectedLabel
                            WorkModule.PeriodicBackup.enqueue(forceUpdate = true)
                        }
                    )

                    var currentNetwork by remember {
                        mutableStateOf(
                            run {
                                val networkTypes = listOf(
                                    "All networks" to NetworkType.CONNECTED.name,
                                    "Wi-Fi" to NetworkType.UNMETERED.name,
                                    "Mobile Data" to NetworkType.METERED.name,
                                    "Not Roaming" to NetworkType.NOT_ROAMING.name
                                )
                                val current = Preferences.getString(Preferences.autoBackupNetworkTypeKey, NetworkType.CONNECTED.name)
                                networkTypes.find { it.second == current }?.first ?: "All networks"
                            }
                        )
                    }

                    SettingsDialogItem(
                        icon = Icons.Rounded.SignalCellularAlt,
                        title = stringResource(R.string.backup_network_type),
                        subtitle = "Network type for backups",
                        currentValue = currentNetwork,
                        options = listOf(
                            "All networks" to NetworkType.CONNECTED.name,
                            "Wi-Fi" to NetworkType.UNMETERED.name,
                            "Mobile Data" to NetworkType.METERED.name,
                            "Not Roaming" to NetworkType.NOT_ROAMING.name
                        ),
                        enabled = isAutoPhotoBackupEnabled,
                        onValueChange = { value ->
                            Preferences.edit {
                                putString(Preferences.autoBackupNetworkTypeKey, value)
                            }
                            val selectedLabel = listOf(
                                "All networks" to NetworkType.CONNECTED.name,
                                "Wi-Fi" to NetworkType.UNMETERED.name,
                                "Mobile Data" to NetworkType.METERED.name,
                                "Not Roaming" to NetworkType.NOT_ROAMING.name
                            ).find { it.second == value }?.first ?: "All networks"
                            currentNetwork = selectedLabel
                            WorkModule.PeriodicBackup.enqueue(forceUpdate = true)
                        }
                    )

                    SettingsSwitchItem(
                        icon = Icons.Rounded.Description,
                        title = "Include Image Metadata",
                        subtitle = "Upload EXIF data and location",
                        isChecked = isMetadataUploadEnabled,
                        onCheckedChange = { enabled ->
                            isMetadataUploadEnabled = enabled
                            MetadataConfig.setIncludeMetadata(enabled)
                            scope.launch {
                                context.toastFromMainThread(if (enabled) "Metadata enabled" else "Metadata disabled")
                            }
                        }
                    )
                }
            }

            // CLOUD ACTIONS SECTION
            Spacer(modifier = Modifier.height(16.dp))
            SettingsSection(title = "Cloud Actions")
            Surface(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(24.dp),
                color = MaterialTheme.colorScheme.surfaceContainerLow
            ) {
                Column {
                    SettingsItem(
                        icon = Icons.Rounded.CloudUpload,
                        title = "Backup Database",
                        subtitle = if (backupStats?.isUpToDate == true) "✅ Up to date" else "Upload database to Telegram",
                        onClick = {
                            scope.launch {
                                context.toastFromMainThread("Uploading database...")
                                BackupHelper.uploadDatabaseToTelegram(context).fold(
                                    onSuccess = { context.toastFromMainThread("✅ Success") },
                                    onFailure = { context.toastFromMainThread("❌ Failed: ${it.message}") }
                                )
                                backupStats = BackupHelper.getBackupStats()
                            }
                        }
                    )

                    SettingsItem(
                        icon = Icons.Rounded.CloudSync,
                        title = "Sync Cloud Photos",
                        subtitle = "Manually refresh from Telegram",
                        onClick = {
                            scope.launch {
                                context.toastFromMainThread("Syncing...")
                                CloudPhotoSyncService.forceSync(context).collect { progress ->
                                    if (progress.isComplete) {
                                        context.toastFromMainThread(if (progress.errorMessage != null) "Sync failed" else "Sync complete!")
                                    }
                                }
                            }
                        }
                    )

                    SettingsItem(
                        icon = Icons.Rounded.CloudDownload,
                        title = "Restore Missing",
                        subtitle = stringResource(R.string.photos_not_found_on_this_device, totalCloudPhotosCount),
                        onClick = {
                            WorkModule.RestoreMissingFromDevice.enqueue()
                            scope.launch { context.toastFromMainThread("Restore enqueued") }
                        }
                    )
                }
            }

            // LOCAL MANAGEMENT SECTION
            Spacer(modifier = Modifier.height(16.dp))
            SettingsSection(title = "Local Management")
            Surface(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(24.dp),
                color = MaterialTheme.colorScheme.surfaceContainerLow
            ) {
                Column {
                    SettingsSwitchItem(
                        icon = Icons.Rounded.AutoMode,
                        title = "Auto Export Database",
                        subtitle = "Automatically export to file",
                        isChecked = isAutoExportDatabaseEnabled,
                        onCheckedChange = { enabled ->
                            isAutoExportDatabaseEnabled = enabled
                            Preferences.edit { putBoolean(Preferences.isAutoExportDatabaseEnabledKey, enabled) }
                            if (enabled) {
                                autoExportBackupFileLauncher.launch(context.getString(R.string.CloudGallery_auto_photos_backup_json))
                            } else {
                                WorkModule.PeriodicDbExport.cancel()
                                scope.launch { context.toastFromMainThread("Auto export cancelled") }
                            }
                        }
                    )

                    SettingsItem(
                        icon = Icons.Rounded.MoveToInbox,
                        title = "Import Database",
                        subtitle = "Restore from local file",
                        onClick = { importPhotosBackupFile.launch(arrayOf(BackupHelper.JSON_MIME)) }
                    )

                    SettingsItem(
                        icon = Icons.Rounded.Outbox,
                        title = "Export Database",
                        subtitle = "Manual export to local file",
                        onClick = { exportBackupFileLauncher.launch(context.getString(R.string.CloudGallery_photos_backup_json)) }
                    )

                    SettingsItem(
                        icon = Icons.Rounded.Info,
                        title = "Database Status",
                        subtitle = "View detailed statistics",
                        onClick = {
                            scope.launch {
                                val stats = BackupHelper.getBackupStats()
                                withContext(Dispatchers.Main) {
                                    backupStats = stats
                                    showDialog = true
                                }
                            }
                        }
                    )
                }
            }

            // ABOUT SECTION
            Spacer(modifier = Modifier.height(16.dp))
            SettingsSection(title = "About")
            Surface(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(24.dp),
                color = MaterialTheme.colorScheme.surfaceContainerLow
            ) {
                Column {
                    SettingsItem(
                        icon = Icons.Rounded.Android,
                        title = "More Apps",
                        subtitle = "Explore more tools from us",
                        onClick = { openLinkFromHref(Constants.moreApps) }
                    )

                    SettingsItem(
                        iconPainter = painterResource(id = R.drawable.telegram),
                        title = "Join Telegram",
                        subtitle = "Support and community",
                        onClick = { openLinkFromHref(Constants.joinTelegra) }
                    )

                    SettingsItem(
                        icon = Icons.Rounded.Info,
                        title = "Version",
                        subtitle = "${BuildConfig.VERSION_NAME} (${BuildConfig.VERSION_CODE})",
                        onClick = {
                            scope.launch { context.toastFromMainThread("Version ${BuildConfig.VERSION_NAME}") }
                        }
                    )

                    SettingsItem(
                        icon = Icons.Rounded.Code,
                        title = "Source Code",
                        subtitle = "View on GitHub",
                        onClick = { openLinkFromHref(Constants.REPO_GITHUB) }
                    )

                    SettingsItem(
                        icon = Icons.Rounded.Balance,
                        title = "License",
                        subtitle = "MIT License",
                        onClick = { openLinkFromHref(Constants.LICENSE) }
                    )

                    SettingsItem(
                        iconPainter = painterResource(id = R.drawable.donation),
                        title = "Donate",
                        subtitle = "Support the development",
                        onClick = { showSupportSheet = true }
                    )
                }
            }

            Spacer(modifier = Modifier.height(32.dp))
        }

        if (showDialog) {
            Dialog(onDismissRequest = { showDialog = false }) {
                Surface(
                    shape = RoundedCornerShape(28.dp),
                    color = MaterialTheme.colorScheme.surfaceContainerHigh,
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier
                            .padding(24.dp)
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Box(
                                modifier = Modifier
                                    .size(40.dp)
                                    .clip(RoundedCornerShape(10.dp))
                                    .background(MaterialTheme.colorScheme.primaryContainer),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    imageVector = Icons.Rounded.Storage,
                                    contentDescription = null,
                                    tint = MaterialTheme.colorScheme.primary,
                                    modifier = Modifier.size(24.dp)
                                )
                            }
                            Spacer(modifier = Modifier.width(16.dp))
                            Text(
                                text = "Database Status",
                                style = MaterialTheme.typography.titleLarge,
                                fontWeight = FontWeight.Bold
                            )
                        }
                        
                        Spacer(modifier = Modifier.height(24.dp))
                        
                        val stats = backupStats
                        if (stats != null) {
                            StatusRow(
                                icon = Icons.Rounded.Android,
                                label = "Device Photos",
                                value = stats.currentPhotos.toString(),
                                color = MaterialTheme.colorScheme.secondary
                            )
                            Spacer(modifier = Modifier.height(12.dp))
                            StatusRow(
                                icon = Icons.Rounded.Cloud,
                                label = "Cloud Photos",
                                value = stats.currentRemotePhotos.toString(),
                                color = MaterialTheme.colorScheme.primary
                            )
                            
                            if (stats.lastBackupTime > 0) {
                                Spacer(modifier = Modifier.height(20.dp))
                                HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)
                                Spacer(modifier = Modifier.height(20.dp))
                                
                                StatusRow(
                                    icon = Icons.Rounded.History,
                                    label = "Last Backup",
                                    value = java.text.SimpleDateFormat("MMM dd, HH:mm", java.util.Locale.getDefault()).format(java.util.Date(stats.lastBackupTime)),
                                    color = MaterialTheme.colorScheme.tertiary
                                )
                                Spacer(modifier = Modifier.height(12.dp))
                                StatusRow(
                                    icon = if (stats.isUpToDate) Icons.Rounded.CheckCircle else Icons.Rounded.Error,
                                    label = "Sync Status",
                                    value = if (stats.isUpToDate) "Up to date" else "Sync pending",
                                    color = if (stats.isUpToDate) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.error
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(32.dp))
                        
                        Button(
                            onClick = { showDialog = false },
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(16.dp)
                        ) {
                            Text("Dismiss")
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun StatusRow(
    icon: ImageVector,
    label: String,
    value: String,
    color: Color
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = color,
            modifier = Modifier.size(20.dp)
        )
        Spacer(modifier = Modifier.width(12.dp))
        Text(
            text = label,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.weight(1f)
        )
        Text(
            text = value,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}
