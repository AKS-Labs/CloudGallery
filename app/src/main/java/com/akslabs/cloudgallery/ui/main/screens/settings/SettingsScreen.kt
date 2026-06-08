package com.akslabs.cloudgallery.ui.main.screens.settings

import android.content.Context
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
import com.akslabs.cloudgallery.data.mediastore.AlbumInfo
import com.akslabs.cloudgallery.ui.components.DonateBottomSheet
import com.akslabs.cloudgallery.ui.components.MoreAppsBottomSheet
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

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
        val iconContainerColor = if (enabled) MaterialTheme.colorScheme.primaryContainer else MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
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
    iconColor: Color? = null,
    modifier: Modifier = Modifier
) {
    val alpha = if (enabled) 1f else 0.4f
    val finalIconColor = iconColor ?: MaterialTheme.colorScheme.primary.copy(alpha = alpha)

    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable(enabled = enabled) { onClick() }
            .padding(horizontal = 20.dp, vertical = 14.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        val iconContainerColor = if (enabled) MaterialTheme.colorScheme.primaryContainer else MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
        val tintColor = finalIconColor

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
                        tint = tintColor
                    )
                }
                iconPainter != null -> {
                    Image(
                        painter = iconPainter,
                        contentDescription = null,
                        modifier = Modifier.size(24.dp),
                        colorFilter = androidx.compose.ui.graphics.ColorFilter.tint(tintColor)
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

    fun openLinkFromHref(href: String) {
        context.startActivity(
            Intent(Intent.ACTION_VIEW, Uri.parse(href))
        )
    }

    // Bottom Sheet States
    var showMoreAppsSheet by remember { mutableStateOf(false) }
    var showDonateSheet by remember { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)

    if (showMoreAppsSheet) {
        MoreAppsBottomSheet(
            onDismiss = { showMoreAppsSheet = false },
            onAppSelected = { href ->
                showMoreAppsSheet = false
                openLinkFromHref(href)
            }
        )
    }

    if (showDonateSheet) {
        DonateBottomSheet(
            onDismiss = { showDonateSheet = false },
            onDonateOptionSelected = { href ->
                showDonateSheet = false
                openLinkFromHref(href)
            }
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
        ActivityResultContracts.OpenDocumentTree()
    ) {
        it?.let { uri ->
            context.contentResolver.takePersistableUriPermission(
                uri,
                Intent.FLAG_GRANT_READ_URI_PERMISSION or Intent.FLAG_GRANT_WRITE_URI_PERMISSION
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
    var currentAutoExportInterval by remember {
        mutableStateOf(
            run {
                val intervals = listOf("Daily" to "1", "Weekly" to "7", "Biweekly" to "14", "Monthly" to "30")
                val current = Preferences.getString(Preferences.autoExportDatabaseIntervalKey, "7")
                intervals.find { it.second == current }?.first ?: "Weekly"
            }
        )
    }
    var isAutoCloudBackupEnabled by remember {
        mutableStateOf(Preferences.getBoolean(Preferences.isAutoCloudBackupEnabledKey, true))
    }
    var isMetadataUploadEnabled by remember {
        mutableStateOf(MetadataConfig.shouldIncludeMetadata())
    }
    var isSyncImagePreviewEnabled by remember {
        mutableStateOf(Preferences.getBoolean(Preferences.syncImagePreviewKey, false))
    }
    var currentPreviewSize by remember {
        mutableStateOf(Preferences.getInt(Preferences.syncImagePreviewSizeKey, 25))
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
                    var showSyncModeChoiceDialog by remember { mutableStateOf(false) }
                    var currentSyncMode by remember {
                        mutableStateOf(
                            run {
                                val current = Preferences.getSyncMode()
                                if (current == Preferences.SYNC_MODE_NEW_ONLY) "Only new photos" else "All photos"
                            }
                        )
                    }
                    SettingsSwitchItem(
                        icon = Icons.Rounded.CloudSync,
                        title = stringResource(R.string.auto_periodic_backup),
                        subtitle = "Automatically backup photos to Telegram",
                        isChecked = isAutoPhotoBackupEnabled,
                        onCheckedChange = { enabled ->
                            if (enabled) {
                                showSyncModeChoiceDialog = true
                            } else {
                                isAutoPhotoBackupEnabled = false
                                Preferences.edit {
                                    putBoolean(Preferences.isAutoBackupEnabledKey, false)
                                }
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

                    if (showSyncModeChoiceDialog) {
                        AlertDialog(
                            onDismissRequest = {
                                showSyncModeChoiceDialog = false
                            },
                            title = {
                                Column {
                                    Row(verticalAlignment = Alignment.CenterVertically) {
                                        Icon(
                                            imageVector = Icons.Rounded.Sync,
                                            contentDescription = null,
                                            tint = MaterialTheme.colorScheme.primary,
                                            modifier = Modifier.size(24.dp)
                                        )
                                        Spacer(modifier = Modifier.width(10.dp))
                                        Text(
                                            text = "Sync Scope",
                                            style = MaterialTheme.typography.titleLarge,
                                            fontWeight = FontWeight.Bold
                                        )
                                    }
                                    Spacer(modifier = Modifier.height(4.dp))
                                    Text(
                                        text = "Choose what to sync before enabling periodic backup.",
                                        style = MaterialTheme.typography.bodySmall,
                                        color = MaterialTheme.colorScheme.onSurfaceVariant
                                    )
                                }
                            },
                            text = {
                                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                                    Surface(
                                        onClick = {
                                            Preferences.setSyncMode(Preferences.SYNC_MODE_ALL)
                                            Preferences.setSyncNewOnlyTimestamp(0L)
                                            currentSyncMode = "All photos"
                                            isAutoPhotoBackupEnabled = true
                                            Preferences.edit { putBoolean(Preferences.isAutoBackupEnabledKey, true) }
                                            WorkModule.PeriodicBackup.enqueue()
                                            showSyncModeChoiceDialog = false
                                            scope.launch { context.toastFromMainThread("Periodic backup enabled") }
                                        },
                                        shape = RoundedCornerShape(16.dp),
                                        color = MaterialTheme.colorScheme.primaryContainer,
                                        modifier = Modifier.fillMaxWidth()
                                    ) {
                                        Row(
                                            modifier = Modifier.padding(16.dp),
                                            verticalAlignment = Alignment.CenterVertically
                                        ) {
                                            Icon(
                                                imageVector = Icons.Rounded.CloudSync,
                                                contentDescription = null,
                                                tint = MaterialTheme.colorScheme.onPrimaryContainer,
                                                modifier = Modifier.size(28.dp)
                                            )
                                            Spacer(modifier = Modifier.width(14.dp))
                                            Column(modifier = Modifier.weight(1f)) {
                                                Text(
                                                    text = "Sync All Photos",
                                                    style = MaterialTheme.typography.titleMedium,
                                                    fontWeight = FontWeight.Bold,
                                                    color = MaterialTheme.colorScheme.onPrimaryContainer
                                                )
                                                Text(
                                                    text = "Upload existing photos and new ones going forward",
                                                    style = MaterialTheme.typography.bodySmall,
                                                    color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.7f)
                                                )
                                            }
                                        }
                                    }
                                    Surface(
                                        onClick = {
                                            Preferences.setSyncMode(Preferences.SYNC_MODE_NEW_ONLY)
                                            Preferences.setSyncNewOnlyTimestamp(System.currentTimeMillis())
                                            currentSyncMode = "Only new photos"
                                            isAutoPhotoBackupEnabled = true
                                            Preferences.edit { putBoolean(Preferences.isAutoBackupEnabledKey, true) }
                                            WorkModule.PeriodicBackup.enqueue()
                                            showSyncModeChoiceDialog = false
                                            scope.launch { context.toastFromMainThread("Periodic backup enabled — new photos only") }
                                        },
                                        shape = RoundedCornerShape(16.dp),
                                        color = MaterialTheme.colorScheme.secondaryContainer,
                                        modifier = Modifier.fillMaxWidth()
                                    ) {
                                        Row(
                                            modifier = Modifier.padding(16.dp),
                                            verticalAlignment = Alignment.CenterVertically
                                        ) {
                                            Icon(
                                                imageVector = Icons.Rounded.History,
                                                contentDescription = null,
                                                tint = MaterialTheme.colorScheme.onSecondaryContainer,
                                                modifier = Modifier.size(28.dp)
                                            )
                                            Spacer(modifier = Modifier.width(14.dp))
                                            Column(modifier = Modifier.weight(1f)) {
                                                Text(
                                                    text = "Sync Only New Photos",
                                                    style = MaterialTheme.typography.titleMedium,
                                                    fontWeight = FontWeight.Bold,
                                                    color = MaterialTheme.colorScheme.onSecondaryContainer
                                                )
                                                Text(
                                                    text = "Skip existing photos, only upload photos added from now on",
                                                    style = MaterialTheme.typography.bodySmall,
                                                    color = MaterialTheme.colorScheme.onSecondaryContainer.copy(alpha = 0.7f)
                                                )
                                            }
                                        }
                                    }
                                }
                            },
                            confirmButton = {},
                            dismissButton = {
                                TextButton(onClick = { showSyncModeChoiceDialog = false }) {
                                    Text("Cancel")
                                }
                            }
                        )
                    }

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

                    SettingsDialogItem(
                        icon = Icons.Rounded.Sync,
                        title = "Sync Scope",
                        subtitle = if (currentSyncMode == "Only new photos") "Only sync photos added from now on"
                                   else "Sync all existing and new photos",
                        currentValue = currentSyncMode,
                        options = listOf(
                            "All photos" to Preferences.SYNC_MODE_ALL,
                            "Only new photos" to Preferences.SYNC_MODE_NEW_ONLY
                        ),
                        enabled = isAutoPhotoBackupEnabled,
                        onValueChange = { value ->
                            if (value == Preferences.SYNC_MODE_NEW_ONLY) {
                                val now = System.currentTimeMillis()
                                Preferences.setSyncNewOnlyTimestamp(now)
                                Preferences.setSyncMode(Preferences.SYNC_MODE_NEW_ONLY)
                                currentSyncMode = "Only new photos"
                                scope.launch {
                                    context.toastFromMainThread("Will only sync photos added from now on")
                                }
                            } else {
                                Preferences.setSyncMode(Preferences.SYNC_MODE_ALL)
                                Preferences.setSyncNewOnlyTimestamp(0L)
                                currentSyncMode = "All photos"
                                scope.launch {
                                    context.toastFromMainThread("Will sync all existing and new photos")
                                }
                            }
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

                    SettingsSwitchItem(
                        icon = Icons.Rounded.Image,
                        title = "Sync Image Preview",
                        subtitle = "Sync low-quality previews with original image (${currentPreviewSize} KB)",
                        isChecked = isSyncImagePreviewEnabled,
                        onCheckedChange = { enabled ->
                            isSyncImagePreviewEnabled = enabled
                            Preferences.edit { putBoolean(Preferences.syncImagePreviewKey, enabled) }
                            scope.launch {
                                context.toastFromMainThread(if (enabled) "Image preview sync enabled" else "Image preview sync disabled")
                            }
                        }
                    )

                    if (isSyncImagePreviewEnabled) {
                        var showCustom by remember { mutableStateOf(currentPreviewSize !in listOf(25, 50, 100, 200, 400)) }
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 20.dp, end = 20.dp, bottom = 10.dp)
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(6.dp)
                            ) {
                                listOf(25, 50, 100, 200, 400).forEach { size ->
                                    val selected = currentPreviewSize == size && !showCustom
                                    Surface(
                                        onClick = {
                                            showCustom = false
                                            currentPreviewSize = size
                                            Preferences.edit { putInt(Preferences.syncImagePreviewSizeKey, size) }
                                        },
                                        shape = RoundedCornerShape(10.dp),
                                        color = if (selected) MaterialTheme.colorScheme.primaryContainer
                                                else MaterialTheme.colorScheme.surfaceContainerHigh,
                                        border = if (selected) androidx.compose.foundation.BorderStroke(1.5.dp, MaterialTheme.colorScheme.primary) else null
                                    ) {
                                        Text(
                                            text = "${size}KB",
                                            style = MaterialTheme.typography.labelSmall,
                                            fontWeight = if (selected) FontWeight.Bold else FontWeight.Medium,
                                            color = if (selected) MaterialTheme.colorScheme.onPrimaryContainer
                                                    else MaterialTheme.colorScheme.onSurfaceVariant,
                                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp)
                                        )
                                    }
                                }
                                Surface(
                                    onClick = { showCustom = !showCustom },
                                    shape = RoundedCornerShape(10.dp),
                                    color = if (showCustom) MaterialTheme.colorScheme.primaryContainer
                                            else MaterialTheme.colorScheme.surfaceContainerHigh,
                                    border = if (showCustom) androidx.compose.foundation.BorderStroke(1.5.dp, MaterialTheme.colorScheme.primary) else null
                                ) {
                                    Text(
                                        text = "Custom",
                                        style = MaterialTheme.typography.labelSmall,
                                        fontWeight = if (showCustom) FontWeight.Bold else FontWeight.Medium,
                                        color = if (showCustom) MaterialTheme.colorScheme.onPrimaryContainer
                                                else MaterialTheme.colorScheme.onSurfaceVariant,
                                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp)
                                    )
                                }
                            }

                            if (showCustom) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.Center,
                                    modifier = Modifier.fillMaxWidth().padding(top = 6.dp)
                                ) {
                                    var manualInput by remember(showCustom) {
                                        mutableStateOf(
                                            if (currentPreviewSize !in listOf(25, 50, 100, 200, 400)) currentPreviewSize.toString() else ""
                                        )
                                    }
                                    Text(
                                        text = "Enter size",
                                        style = MaterialTheme.typography.labelSmall,
                                        color = MaterialTheme.colorScheme.onSurfaceVariant
                                    )
                                    Spacer(modifier = Modifier.width(8.dp))
                                    TextField(
                                        value = manualInput,
                                        onValueChange = { value ->
                                            val filtered = value.filter { it.isDigit() }
                                            if (filtered.length <= 3) {
                                                manualInput = filtered
                                                val size = filtered.toIntOrNull()
                                                if (size != null && size in 10..500) {
                                                    currentPreviewSize = size
                                                    Preferences.edit { putInt(Preferences.syncImagePreviewSizeKey, size) }
                                                }
                                            }
                                        },
                                        modifier = Modifier.width(72.dp),
                                        textStyle = MaterialTheme.typography.bodySmall.copy(textAlign = androidx.compose.ui.text.style.TextAlign.Center),
                                        singleLine = true,
                                        keyboardOptions = androidx.compose.foundation.text.KeyboardOptions(keyboardType = androidx.compose.ui.text.input.KeyboardType.Number),
                                        colors = TextFieldDefaults.colors(
                                            unfocusedContainerColor = androidx.compose.ui.graphics.Color.Transparent,
                                            focusedContainerColor = androidx.compose.ui.graphics.Color.Transparent,
                                            unfocusedIndicatorColor = MaterialTheme.colorScheme.outlineVariant,
                                            focusedIndicatorColor = MaterialTheme.colorScheme.primary
                                        )
                                    )
                                    Spacer(modifier = Modifier.width(4.dp))
                                    Text(
                                        text = "KB",
                                        style = MaterialTheme.typography.labelSmall,
                                        color = MaterialTheme.colorScheme.onSurfaceVariant
                                    )
                                }
                            }
                        }
                    }
                }
            }

            // EXCLUDE FOLDERS SECTION
            Spacer(modifier = Modifier.height(16.dp))
            SettingsSection(title = "Exclude Folders")
            Surface(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(24.dp),
                color = MaterialTheme.colorScheme.surfaceContainerLow
            ) {
                var showExcludedDialog by remember { mutableStateOf(false) }
                val excludedCount = remember { Preferences.getExcludedBucketNames().size }
                SettingsItem(
                    icon = Icons.Rounded.FolderOff,
                    title = "Exclude Folders",
                    subtitle = if (excludedCount > 0) "$excludedCount folder${if (excludedCount != 1) "s" else ""} excluded · Tap to manage"
                              else "Choose folders to exclude from auto-sync",
                    onClick = { showExcludedDialog = true }
                )
                if (showExcludedDialog) {
                    ManageExcludedFoldersDialog(
                        onDismiss = { showExcludedDialog = false }
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
                    SettingsSwitchItem(
                        icon = Icons.Rounded.CloudUpload,
                        title = "Auto Cloud Backup",
                        subtitle = "Daily database backup to Telegram for safekeeping",
                        isChecked = isAutoCloudBackupEnabled,
                        onCheckedChange = { enabled ->
                            isAutoCloudBackupEnabled = enabled
                            Preferences.edit {
                                putBoolean(Preferences.isAutoCloudBackupEnabledKey, enabled)
                            }
                            if (enabled) {
                                WorkModule.DailyDatabaseBackup.enqueuePeriodic()
                                scope.launch {
                                    context.toastFromMainThread("Auto cloud backup enabled")
                                }
                            } else {
                                WorkModule.DailyDatabaseBackup.cancel()
                                scope.launch {
                                    context.toastFromMainThread("Auto cloud backup disabled")
                                }
                            }
                        }
                    )

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
                        subtitle = "Sync images which are uploaded via Telegram",
                        onClick = {
                            scope.launch {
                                context.toastFromMainThread("Syncing...")
                                CloudPhotoSyncService.forceSync(context).collect { progress ->
                                    if (progress.isComplete) {
                                        context.toastFromMainThread(
                                            if (progress.errorMessage != null) "Sync failed: ${progress.errorMessage}"
                                            else "Sync complete!"
                                        )
                                    }
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
                        subtitle = "Automatically export to file locally",
                        isChecked = isAutoExportDatabaseEnabled,
                        onCheckedChange = { enabled ->
                            isAutoExportDatabaseEnabled = enabled
                            Preferences.edit { putBoolean(Preferences.isAutoExportDatabaseEnabledKey, enabled) }
                            if (enabled) {
                                autoExportBackupFileLauncher.launch(null)
                            } else {
                                WorkModule.PeriodicDbExport.cancel()
                                scope.launch { context.toastFromMainThread("Auto export cancelled") }
                            }
                        }
                    )

                    SettingsDialogItem(
                        icon = Icons.Rounded.AccessTime,
                        title = "Export Interval",
                        subtitle = "How often to export database locally",
                        currentValue = currentAutoExportInterval,
                        options = listOf("Daily" to "1", "Weekly" to "7", "Biweekly" to "14", "Monthly" to "30"),
                        enabled = isAutoExportDatabaseEnabled,
                        onValueChange = { value ->
                            Preferences.edit {
                                putBoolean(Preferences.isAutoExportDatabaseEnabledKey, true)
                                putString(Preferences.autoExportDatabaseIntervalKey, value)
                            }
                            val selectedLabel = listOf("Daily" to "1", "Weekly" to "7", "Biweekly" to "14", "Monthly" to "30")
                                .find { it.second == value }?.first ?: "Weekly"
                            currentAutoExportInterval = selectedLabel
                            WorkModule.PeriodicDbExport.enqueue(forceUpdate = true)
                            scope.launch {
                                context.toastFromMainThread("Export interval updated to $selectedLabel")
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
                        onClick = {
                            val dateFormat = SimpleDateFormat("yyyy-MM-dd_hh-mm-a", Locale.getDefault())
                            val timestamp = dateFormat.format(Date())
                            val defaultFileName = "CloudGallery_Backup_$timestamp.json"
                            exportBackupFileLauncher.launch(defaultFileName)
                        }
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
                        subtitle = "More Apps by AKS-Labs",
                        onClick = { showMoreAppsSheet = true }
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
                        subtitle = "GPL-3.0 license",
                        onClick = { openLinkFromHref(Constants.LICENSE) }
                    )

                    SettingsItem(
                        iconPainter = painterResource(id = R.drawable.donation),
                        title = "Donate",
                        subtitle = "Support the development",
                        iconColor = MaterialTheme.colorScheme.primary,
                        onClick = { showDonateSheet = true }
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

/**
 * Dialog to manage which folders are excluded from auto-sync.
 * Loads all albums (folders) from MediaStore and lets the user toggle them on/off.
 */
@Composable
private fun ManageExcludedFoldersDialog(
    onDismiss: () -> Unit
) {
    val context = LocalContext.current
    var albums by remember { mutableStateOf<List<AlbumInfo>>(emptyList()) }
    var excludedNames by remember { mutableStateOf(Preferences.getExcludedBucketNames()) }
    var isLoading by remember { mutableStateOf(true) }
    var loadError by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        withContext(Dispatchers.IO) {
            try {
                albums = loadAlbumsFromMediaStore(context)
                isLoading = false
            } catch (e: Exception) {
                loadError = true
                isLoading = false
            }
        }
    }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Column {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Rounded.FolderOff,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = "Exclude Folders",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold
                    )
                }
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Toggle folders to exclude them from auto periodic sync. Photos in excluded folders will not be uploaded automatically.",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        },
        text = {
            when {
                isLoading -> {
                    Box(
                        modifier = Modifier.fillMaxWidth().height(150.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator()
                    }
                }
                loadError -> {
                    Text("Could not load albums. Make sure storage permission is granted.")
                }
                albums.isEmpty() -> {
                    Text("No albums found on this device.")
                }
                else -> {
                    val sortedAlbums = remember(albums, excludedNames) {
                        albums.sortedByDescending { it.label in excludedNames }
                    }
                    Column(
                        modifier = Modifier.heightIn(max = 400.dp).verticalScroll(rememberScrollState())
                    ) {
                        sortedAlbums.forEach { album ->
                            val isExcluded = album.label in excludedNames
                            Surface(
                                onClick = {
                                    excludedNames = if (isExcluded) excludedNames - album.label
                                                    else excludedNames + album.label
                                },
                                shape = RoundedCornerShape(12.dp),
                                color = if (isExcluded) MaterialTheme.colorScheme.errorContainer.copy(alpha = 0.4f)
                                        else MaterialTheme.colorScheme.surface,
                                modifier = Modifier.fillMaxWidth().padding(vertical = 2.dp)
                            ) {
                                Row(
                                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Checkbox(
                                        checked = isExcluded,
                                        onCheckedChange = { checked ->
                                            excludedNames = if (checked) excludedNames + album.label
                                                            else excludedNames - album.label
                                        },
                                        colors = CheckboxDefaults.colors(
                                            checkedColor = MaterialTheme.colorScheme.error,
                                            uncheckedColor = MaterialTheme.colorScheme.onSurfaceVariant
                                        )
                                    )
                                    Spacer(modifier = Modifier.width(8.dp))
                                    Icon(
                                        imageVector = Icons.Rounded.Folder,
                                        contentDescription = null,
                                        tint = if (isExcluded) MaterialTheme.colorScheme.error
                                               else MaterialTheme.colorScheme.onSurfaceVariant,
                                        modifier = Modifier.size(20.dp)
                                    )
                                    Spacer(modifier = Modifier.width(8.dp))
                                    Text(
                                        text = album.label,
                                        style = MaterialTheme.typography.bodyLarge,
                                        color = if (isExcluded) MaterialTheme.colorScheme.error
                                                else MaterialTheme.colorScheme.onSurface
                                    )
                                }
                            }
                        }
                    }
                }
            }
        },
        confirmButton = {
            TextButton(
                onClick = {
                    Preferences.setExcludedBucketNames(excludedNames)
                    onDismiss()
                }
            ) {
                Text("Save")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Cancel")
            }
        }
    )
}

/**
 * Queries MediaStore for all distinct album buckets on the device.
 */
private fun loadAlbumsFromMediaStore(context: Context): List<AlbumInfo> {
    val contentResolver = context.contentResolver
    val uri = android.provider.MediaStore.Images.Media.getContentUri(android.provider.MediaStore.VOLUME_EXTERNAL)
    val projection = arrayOf(
        android.provider.MediaStore.Images.ImageColumns.BUCKET_ID,
        android.provider.MediaStore.Images.ImageColumns.BUCKET_DISPLAY_NAME
    )
    val sortOrder = "${android.provider.MediaStore.Images.ImageColumns.BUCKET_DISPLAY_NAME} ASC"
    val albums = mutableListOf<AlbumInfo>()
    contentResolver.query(uri, projection, null, null, sortOrder)?.use { cursor ->
        val bucketIdIdx = cursor.getColumnIndexOrThrow(android.provider.MediaStore.Images.ImageColumns.BUCKET_ID)
        val bucketNameIdx = cursor.getColumnIndexOrThrow(android.provider.MediaStore.Images.ImageColumns.BUCKET_DISPLAY_NAME)
        val seenIds = mutableSetOf<Long>()
        while (cursor.moveToNext()) {
            val id = cursor.getLong(bucketIdIdx)
            if (id !in seenIds) {
                seenIds.add(id)
                val name = cursor.getString(bucketNameIdx) ?: "Unknown"
                albums.add(AlbumInfo(id = id, label = name, count = 0, coverUri = ""))
            }
        }
    }
    return albums
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
