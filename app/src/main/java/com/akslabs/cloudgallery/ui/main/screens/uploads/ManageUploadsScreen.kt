package com.akslabs.cloudgallery.ui.main.screens.uploads

import android.text.format.DateUtils
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Backup
import androidx.compose.material.icons.rounded.Cancel
import androidx.compose.material.icons.rounded.CheckCircle
import androidx.compose.material.icons.rounded.CloudDone
import androidx.compose.material.icons.rounded.CloudQueue
import androidx.compose.material.icons.rounded.CloudUpload
import androidx.compose.material.icons.rounded.ErrorOutline
import androidx.compose.material.icons.rounded.HourglassTop
import androidx.compose.material.icons.rounded.Image
import androidx.compose.material.icons.rounded.Refresh
import androidx.compose.material.icons.rounded.Schedule
import androidx.compose.material.icons.rounded.Upload
import androidx.compose.material.icons.rounded.UploadFile
import androidx.compose.material.icons.rounded.Warning
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.Icon
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.akslabs.cloudgallery.data.localdb.entities.Photo
import kotlinx.coroutines.launch

// ─── Tab definitions ────────────────────────────────────────────────
private enum class UploadTab(val label: String, val icon: ImageVector) {
    All("All", Icons.Rounded.CloudUpload),
    Manual("Manual", Icons.Rounded.Upload),
    AutoBackup("Queue & Backup", Icons.Rounded.Backup),
    Synced("Synced", Icons.Rounded.CheckCircle),
    Failed("Failed", Icons.Rounded.ErrorOutline)
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class, ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun ManageUploadsScreen(
    navController: NavController,
    viewModel: ManageUploadsViewModel = viewModel()
) {
    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior(rememberTopAppBarState())
    val allUploads by viewModel.allUploads.collectAsState()
    val manualUploads by viewModel.manualUploads.collectAsState()
    val autoBackupUploads by viewModel.autoBackupUploads.collectAsState()
    val failedUploads by viewModel.failedUploads.collectAsState()
    val syncedUploads by viewModel.syncedUploads.collectAsState()
    val queuedPhotos by viewModel.queuedPhotos.collectAsState()
    val haptic = LocalHapticFeedback.current
    val scope = rememberCoroutineScope()

    val tabs = UploadTab.entries
    val pagerState = rememberPagerState(pageCount = { tabs.size })

    // Stats
    val activeCount = allUploads.count { it.status == UploadStatus.InProgress }
    val completedCount = allUploads.count { it.status == UploadStatus.Completed }
    val failedCount = failedUploads.size

    val statusBarHeight = WindowInsets.statusBars.asPaddingValues().calculateTopPadding()

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        contentWindowInsets = WindowInsets.navigationBars,
        topBar = {
            LargeTopAppBar(
                modifier = Modifier.padding(top = statusBarHeight),
                title = {
                    Column {
                        Text(
                            "Uploads",
                            style = MaterialTheme.typography.headlineMedium,
                            fontWeight = FontWeight.ExtraBold,
                            letterSpacing = (-0.5).sp
                        )
                        // Stats row with pill badges
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                            modifier = Modifier.padding(top = 4.dp)
                        ) {
                            if (activeCount > 0) {
                                StatPill(
                                    text = "$activeCount active",
                                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                                    contentColor = MaterialTheme.colorScheme.onPrimaryContainer
                                )
                            }
                            if (queuedPhotos.isNotEmpty()) {
                                StatPill(
                                    text = "${queuedPhotos.size} pending",
                                    containerColor = MaterialTheme.colorScheme.secondaryContainer,
                                    contentColor = MaterialTheme.colorScheme.onSecondaryContainer
                                )
                            }
                            if (failedCount > 0) {
                                StatPill(
                                    text = "$failedCount failed",
                                    containerColor = MaterialTheme.colorScheme.errorContainer,
                                    contentColor = MaterialTheme.colorScheme.onErrorContainer
                                )
                            }
                            if (completedCount > 0) {
                                StatPill(
                                    text = "$completedCount done",
                                    containerColor = MaterialTheme.colorScheme.tertiaryContainer,
                                    contentColor = MaterialTheme.colorScheme.onTertiaryContainer
                                )
                            }
                        }
                    }
                },
                navigationIcon = {
                    Surface(
                        onClick = { navController.navigateUp() },
                        color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f),
                        shape = CircleShape,
                        modifier = Modifier
                            .padding(start = 12.dp)
                            .size(40.dp)
                    ) {
                        Box(contentAlignment = Alignment.Center) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Rounded.ArrowBack,
                                contentDescription = "Back",
                                modifier = Modifier.size(20.dp)
                            )
                        }
                    }
                },
                actions = {
                    if (failedCount > 0) {
                        Surface(
                            onClick = {
                                haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                                viewModel.retryAllFailed()
                            },
                            color = MaterialTheme.colorScheme.errorContainer.copy(alpha = 0.7f),
                            shape = CircleShape,
                            modifier = Modifier
                                .padding(end = 8.dp)
                                .size(40.dp)
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                                Icon(
                                    imageVector = Icons.Rounded.Refresh,
                                    contentDescription = "Retry All Failed",
                                    modifier = Modifier.size(20.dp),
                                    tint = MaterialTheme.colorScheme.onErrorContainer
                                )
                            }
                        }
                    }
                },
                scrollBehavior = scrollBehavior,
                colors = TopAppBarDefaults.largeTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface,
                    scrolledContainerColor = MaterialTheme.colorScheme.surface,
                ),
                expandedHeight = 140.dp,
                windowInsets = WindowInsets(0, 0, 0, 0)
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            // ─── Scrollable Tab Row ──────────────────────────────
            ScrollableTabRow(
                selectedTabIndex = pagerState.currentPage,
                edgePadding = 16.dp,
                containerColor = Color.Transparent,
                contentColor = MaterialTheme.colorScheme.primary,
                divider = {},
                indicator = {}
            ) {
                tabs.forEachIndexed { index, tab ->
                    val isSelected = pagerState.currentPage == index
                    // Count for badge
                    val count = when (tab) {
                        UploadTab.All -> allUploads.size + queuedPhotos.size
                        UploadTab.Manual -> manualUploads.size
                        UploadTab.AutoBackup -> autoBackupUploads.size + queuedPhotos.size
                        UploadTab.Synced -> syncedUploads.size
                        UploadTab.Failed -> failedCount
                    }
                    Tab(
                        selected = isSelected,
                        onClick = {
                            haptic.performHapticFeedback(HapticFeedbackType.TextHandleMove)
                            scope.launch { pagerState.animateScrollToPage(index) }
                        },
                        modifier = Modifier.padding(horizontal = 4.dp, vertical = 8.dp)
                    ) {
                        Surface(
                            shape = RoundedCornerShape(50),
                            color = if (isSelected) {
                                if (tab == UploadTab.Failed && failedCount > 0)
                                    MaterialTheme.colorScheme.errorContainer
                                else
                                    MaterialTheme.colorScheme.primaryContainer
                            } else MaterialTheme.colorScheme.surfaceContainerHigh,
                            contentColor = if (isSelected) {
                                if (tab == UploadTab.Failed && failedCount > 0)
                                    MaterialTheme.colorScheme.onErrorContainer
                                else
                                    MaterialTheme.colorScheme.onPrimaryContainer
                            } else MaterialTheme.colorScheme.onSurfaceVariant
                        ) {
                            Row(
                                modifier = Modifier.padding(horizontal = 14.dp, vertical = 10.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(6.dp)
                            ) {
                                Icon(tab.icon, contentDescription = null, modifier = Modifier.size(18.dp))
                                Text(
                                    text = if (count > 0) "${tab.label} ($count)" else tab.label,
                                    style = MaterialTheme.typography.labelLarge,
                                    fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium
                                )
                            }
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(4.dp))

            // ─── Pager Content ───────────────────────────────────
            HorizontalPager(
                state = pagerState,
                modifier = Modifier.fillMaxSize()
            ) { page ->
                when (tabs[page]) {
                    UploadTab.All -> UploadListContent(
                        uploads = allUploads,
                        queuedPhotos = queuedPhotos,
                        showQueued = true,
                        onCancel = { viewModel.cancelUpload(it) },
                        onRetry = { viewModel.retryAllFailed() },
                        navController = navController,
                        activeTitle = "Active & Recent"
                    )
                    UploadTab.Manual -> UploadListContent(
                        uploads = manualUploads,
                        queuedPhotos = emptyList(),
                        showQueued = false,
                        onCancel = { viewModel.cancelUpload(it) },
                        onRetry = { viewModel.retryAllFailed() },
                        navController = navController,
                        emptyMessage = "No manual uploads yet",
                        emptySubMessage = "Select photos and upload to cloud to see them here",
                        emptyIcon = Icons.Rounded.UploadFile
                    )
                    UploadTab.AutoBackup -> UploadListContent(
                        uploads = autoBackupUploads,
                        queuedPhotos = queuedPhotos,
                        showQueued = true,
                        onCancel = { viewModel.cancelUpload(it) },
                        onRetry = { viewModel.retryAllFailed() },
                        navController = navController,
                        emptyMessage = "No backup tasks",
                        emptySubMessage = "Enable auto backup in Settings to start",
                        emptyIcon = Icons.Rounded.Backup
                    )
                    UploadTab.Synced -> UploadListContent(
                        uploads = syncedUploads,
                        queuedPhotos = emptyList(),
                        showQueued = false,
                        onCancel = {}, // Synced items usually aren't cancellable
                        onRetry = {},
                        navController = navController,
                        emptyMessage = "No synced photos",
                        emptySubMessage = "Uploaded photos will appear here",
                        emptyIcon = Icons.Rounded.CheckCircle,
                        activeTitle = "Synced Photos"
                    )
                    UploadTab.Failed -> UploadListContent(
                        uploads = failedUploads,
                        queuedPhotos = emptyList(),
                        showQueued = false,
                        onCancel = { viewModel.cancelUpload(it) },
                        onRetry = { viewModel.retryAllFailed() },
                        navController = navController,
                        emptyMessage = "No failed uploads",
                        emptySubMessage = "Everything is running smoothly!",
                        emptyIcon = Icons.Rounded.CloudDone
                    )
                }
            }
        }
    }
}

// ─── Stat Pill ───────────────────────────────────────────────────
@Composable
private fun StatPill(
    text: String,
    containerColor: Color,
    contentColor: Color
) {
    Surface(
        color = containerColor.copy(alpha = 0.7f),
        contentColor = contentColor,
        shape = CircleShape
    ) {
        Text(
            text = text,
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 3.dp),
            style = MaterialTheme.typography.labelMedium,
            fontWeight = FontWeight.Bold,
            letterSpacing = 0.2.sp
        )
    }
}

// ─── Upload List Content ─────────────────────────────────────────
@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun UploadListContent(
    uploads: List<UploadUiItem>,
    queuedPhotos: List<Photo>,
    showQueued: Boolean,
    onCancel: (String) -> Unit,
    onRetry: () -> Unit,
    navController: NavController,
    emptyMessage: String = "Nothing here yet",
    emptySubMessage: String = "",
    emptyIcon: ImageVector = Icons.Rounded.CloudQueue,
    activeTitle: String = "Active"
) {
    val isEmpty = uploads.isEmpty() && (!showQueued || queuedPhotos.isEmpty())

    if (isEmpty) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Surface(
                    shape = CircleShape,
                    color = MaterialTheme.colorScheme.surfaceContainerHigh,
                    modifier = Modifier.size(80.dp)
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Icon(
                            imageVector = emptyIcon,
                            contentDescription = null,
                            modifier = Modifier.size(36.dp),
                            tint = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.5f)
                        )
                    }
                }
                Text(
                    text = emptyMessage,
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.7f),
                    fontWeight = FontWeight.SemiBold
                )
                if (emptySubMessage.isNotEmpty()) {
                    Text(
                        text = emptySubMessage,
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.45f)
                    )
                }
            }
        }
    } else {
        LazyColumn(
            contentPadding = PaddingValues(
                start = 16.dp, 
                end = 16.dp, 
                top = 0.dp, // Reduced top padding to fix blank space
                bottom = 16.dp
            ),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            // ─── Active worker uploads ───────────────────────
            val activeItems = uploads.filter { it.status != UploadStatus.Completed }
            if (activeItems.isNotEmpty()) {
                item(key = "header_active") {
                    SectionHeader(
                        title = activeTitle,
                        icon = Icons.Rounded.CloudUpload
                    )
                }
                items(activeItems, key = { it.id }) { item ->
                    UploadItemCard(
                        item = item,
                        onCancel = { onCancel(item.id) },
                        onRetry = onRetry,
                        onTap = {
                            navigateToPhotoFromUri(navController, item.thumbnailUri)
                        },
                        modifier = Modifier.animateItem()
                    )
                }
            }
 
            // ─── Synced/History from DB ──────────────────────
            val syncedItems = uploads.filter { it.status == UploadStatus.Completed }
            if (syncedItems.isNotEmpty()) {
                item(key = "header_synced") {
                    if (activeItems.isNotEmpty()) Spacer(modifier = Modifier.height(8.dp))
                    SectionHeader(
                        title = "Recently Synced",
                        icon = Icons.Rounded.CloudDone
                    )
                }
                items(syncedItems, key = { it.id }) { item ->
                    UploadItemCard(
                        item = item,
                        onCancel = {},
                        onRetry = {},
                        onTap = {
                            navigateToPhotoFromUri(navController, item.thumbnailUri)
                        },
                        modifier = Modifier.animateItem()
                    )
                }
            }

            // Queued from DB
            if (showQueued && queuedPhotos.isNotEmpty()) {
                item(key = "header_queued") {
                    Spacer(modifier = Modifier.height(4.dp))
                    SectionHeader(
                        title = "Pending Queue (${queuedPhotos.size})",
                        icon = Icons.Rounded.HourglassTop
                    )
                }
                items(queuedPhotos, key = { "queued_${it.localId}" }) { photo ->
                    QueuedPhotoCard(
                        photo = photo,
                        onTap = {
                            try {
                                navController.navigate("photo_viewer/${photo.localId}/false")
                            } catch (_: Exception) {}
                        },
                        modifier = Modifier.animateItem()
                    )
                }
            }
        }
    }
}

private fun navigateToPhotoFromUri(navController: NavController, uri: Any?) {
    if (uri == null) return
    try {
        val idToNavigate = when (uri) {
            is com.akslabs.cloudgallery.data.localdb.entities.RemotePhoto -> uri.remoteId
            is String -> uri
            else -> uri.toString()
        }
        val isRemote = uri is com.akslabs.cloudgallery.data.localdb.entities.RemotePhoto
        navController.navigate("photo_viewer/${java.net.URLEncoder.encode(idToNavigate, "UTF-8")}/$isRemote")
    } catch (_: Exception) {}
}

// ─── Section Header ──────────────────────────────────────────────
@Composable
private fun SectionHeader(title: String, icon: ImageVector) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(vertical = 8.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier.size(18.dp),
            tint = MaterialTheme.colorScheme.primary
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = title,
            style = MaterialTheme.typography.titleSmall,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary,
            letterSpacing = 0.3.sp
        )
    }
}

// ─── Upload Item Card ────────────────────────────────────────────
@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun UploadItemCard(
    item: UploadUiItem,
    onCancel: () -> Unit,
    onRetry: () -> Unit,
    onTap: () -> Unit,
    modifier: Modifier = Modifier
) {
    val haptic = LocalHapticFeedback.current
    var showContextMenu by remember { mutableStateOf(false) }

    Surface(
        shape = RoundedCornerShape(20.dp),
        color = if (item.status == UploadStatus.Failed)
            MaterialTheme.colorScheme.errorContainer.copy(alpha = 0.15f)
        else MaterialTheme.colorScheme.surfaceContainerLow,
        tonalElevation = 1.dp,
        modifier = modifier
            .fillMaxWidth()
            .animateContentSize(spring(stiffness = Spring.StiffnessMediumLow))
            .clip(RoundedCornerShape(20.dp))
            .combinedClickable(
                onClick = onTap,
                onLongClick = {
                    haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                    showContextMenu = true
                }
            )
    ) {
        Column {
            Row(
                modifier = Modifier.padding(14.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // ─── Thumbnail ───────────────────────────────
                Box(
                    modifier = Modifier
                        .size(64.dp)
                        .clip(RoundedCornerShape(14.dp))
                        .background(MaterialTheme.colorScheme.surfaceContainerHigh),
                    contentAlignment = Alignment.Center
                ) {
                    if (item.thumbnailUri != null) {
                        AsyncImage(
                            imageLoader = com.akslabs.cloudgallery.utils.coil.ImageLoaderModule.thumbnailImageLoader,
                            model = ImageRequest.Builder(LocalContext.current)
                                .data(item.thumbnailUri)
                                .crossfade(true)
                                .size(256)
                                .build(),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize()
                        )
                        // Gradient scrim
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(
                                    Brush.verticalGradient(
                                        0f to Color.Transparent,
                                        1f to Color.Black.copy(alpha = 0.1f)
                                    )
                                )
                        )
                    } else {
                        val icon = when (item.type) {
                            UploadType.ManualBackup -> Icons.Rounded.Upload
                            UploadType.AutoBackup -> Icons.Rounded.Backup
                            UploadType.Instant -> Icons.Rounded.Image
                        }
                        Icon(
                            imageVector = icon,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.4f),
                            modifier = Modifier.size(28.dp)
                        )
                    }
                    // Status badge overlay
                    StatusBadge(
                        status = item.status,
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .padding(3.dp)
                    )
                }

                Spacer(modifier = Modifier.width(14.dp))

                // ─── Text content ────────────────────────────
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = item.fileName ?: "Upload",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.SemiBold,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Spacer(modifier = Modifier.height(2.dp))

                    // Status text
                    Text(
                        text = item.progressText.ifEmpty { item.status.name },
                        style = MaterialTheme.typography.bodySmall,
                        color = statusColor(item.status),
                        fontWeight = FontWeight.Medium
                    )

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        modifier = Modifier.padding(top = 4.dp)
                    ) {
                        // Upload type chip
                        Surface(
                            shape = RoundedCornerShape(6.dp),
                            color = typeColor(item.type).copy(alpha = 0.12f),
                        ) {
                            Text(
                                text = when (item.type) {
                                    UploadType.ManualBackup -> "Manual"
                                    UploadType.AutoBackup -> "Auto"
                                    UploadType.Instant -> "Instant"
                                },
                                style = MaterialTheme.typography.labelSmall,
                                color = typeColor(item.type),
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp)
                            )
                        }

                        // Item count chip (for batch uploads)
                        if (item.totalItems > 1) {
                            Surface(
                                shape = RoundedCornerShape(6.dp),
                                color = MaterialTheme.colorScheme.surfaceContainerHighest,
                            ) {
                                Text(
                                    text = "${item.totalItems} photos",
                                    style = MaterialTheme.typography.labelSmall,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                                    fontWeight = FontWeight.Medium,
                                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp)
                                )
                            }
                        }

                        // Timestamp
                        Text(
                            text = DateUtils.getRelativeTimeSpanString(
                                item.timestamp,
                                System.currentTimeMillis(),
                                DateUtils.MINUTE_IN_MILLIS,
                                DateUtils.FORMAT_ABBREV_RELATIVE
                            ).toString(),
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.5f)
                        )
                    }
                }

                // ─── Action button ───────────────────────────
                if (item.status == UploadStatus.Failed) {
                    // Retry button for failed
                    Surface(
                        onClick = {
                            haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                            onRetry()
                        },
                        shape = CircleShape,
                        color = MaterialTheme.colorScheme.errorContainer,
                        modifier = Modifier.size(36.dp)
                    ) {
                        Box(contentAlignment = Alignment.Center) {
                            Icon(
                                imageVector = Icons.Rounded.Refresh,
                                contentDescription = "Retry",
                                modifier = Modifier.size(18.dp),
                                tint = MaterialTheme.colorScheme.onErrorContainer
                            )
                        }
                    }
                } else {
                    AnimatedVisibility(
                        visible = item.isCancellable,
                        enter = fadeIn() + scaleIn(),
                        exit = fadeOut()
                    ) {
                        Surface(
                            onClick = {
                                haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                                onCancel()
                            },
                            shape = CircleShape,
                            color = MaterialTheme.colorScheme.errorContainer.copy(alpha = 0.5f),
                            modifier = Modifier.size(36.dp)
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                                Icon(
                                    imageVector = Icons.Rounded.Cancel,
                                    contentDescription = "Cancel",
                                    modifier = Modifier.size(18.dp),
                                    tint = MaterialTheme.colorScheme.onErrorContainer
                                )
                            }
                        }
                    }
                }
            }

            // ─── Progress bar ────────────────────────────────
            AnimatedVisibility(visible = item.status == UploadStatus.InProgress) {
                Column {
                    val animatedProgress by animateFloatAsState(
                        targetValue = item.progress,
                        animationSpec = spring(stiffness = Spring.StiffnessLow),
                        label = "progress"
                    )
                    if (item.progress > 0f) {
                        LinearProgressIndicator(
                            progress = { animatedProgress },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(4.dp)
                                .padding(horizontal = 14.dp),
                            strokeCap = StrokeCap.Round,
                            trackColor = MaterialTheme.colorScheme.surfaceContainerHighest,
                        )
                    } else {
                        LinearProgressIndicator(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(4.dp)
                                .padding(horizontal = 14.dp),
                            strokeCap = StrokeCap.Round,
                            trackColor = MaterialTheme.colorScheme.surfaceContainerHighest,
                        )
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }

        // ─── Long-press context menu ─────────────────────────
        DropdownMenu(
            expanded = showContextMenu,
            onDismissRequest = { showContextMenu = false },
            shape = RoundedCornerShape(16.dp)
        ) {
            if (item.isCancellable) {
                DropdownMenuItem(
                    text = { Text("Cancel Upload") },
                    leadingIcon = { Icon(Icons.Rounded.Cancel, contentDescription = null, modifier = Modifier.size(20.dp)) },
                    onClick = {
                        onCancel()
                        showContextMenu = false
                    }
                )
            }
            if (item.status == UploadStatus.Failed) {
                DropdownMenuItem(
                    text = { Text("Retry Upload") },
                    leadingIcon = { Icon(Icons.Rounded.Refresh, contentDescription = null, modifier = Modifier.size(20.dp)) },
                    onClick = {
                        onRetry()
                        showContextMenu = false
                    }
                )
            }
            if (item.thumbnailUri != null) {
                DropdownMenuItem(
                    text = { Text("View Photo") },
                    leadingIcon = { Icon(Icons.Rounded.Image, contentDescription = null, modifier = Modifier.size(20.dp)) },
                    onClick = {
                        showContextMenu = false
                        onTap()
                    }
                )
            }
        }
    }
}

// ─── Queued Photo Card ───────────────────────────────────────────
@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun QueuedPhotoCard(
    photo: Photo,
    onTap: () -> Unit,
    modifier: Modifier = Modifier
) {
    val haptic = LocalHapticFeedback.current

    Surface(
        shape = RoundedCornerShape(20.dp),
        color = MaterialTheme.colorScheme.surfaceContainerLow,
        tonalElevation = 0.dp,
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .combinedClickable(
                onClick = onTap,
                onLongClick = {
                    haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                }
            )
    ) {
        Row(
            modifier = Modifier.padding(14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Thumbnail
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(photo.pathUri)
                    .crossfade(true)
                    .size(256)
                    .build(),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(56.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(MaterialTheme.colorScheme.surfaceContainerHigh)
            )

            Spacer(modifier = Modifier.width(14.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = photo.pathUri.substringAfterLast("/"),
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Medium,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = "Waiting for upload",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.5f)
                )
            }

            Surface(
                shape = RoundedCornerShape(8.dp),
                color = MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.5f)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Icon(
                        imageVector = Icons.Rounded.Schedule,
                        contentDescription = null,
                        modifier = Modifier.size(12.dp),
                        tint = MaterialTheme.colorScheme.onSecondaryContainer
                    )
                    Text(
                        text = "Queued",
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSecondaryContainer
                    )
                }
            }
        }
    }
}

// ─── Status Badge ────────────────────────────────────────────────
@Composable
private fun StatusBadge(status: UploadStatus, modifier: Modifier = Modifier) {
    val (color, icon) = when (status) {
        UploadStatus.Queued -> MaterialTheme.colorScheme.secondary to Icons.Rounded.Schedule
        UploadStatus.InProgress -> MaterialTheme.colorScheme.primary to null
        UploadStatus.Completed -> MaterialTheme.colorScheme.primary to Icons.Rounded.CheckCircle
        UploadStatus.Failed -> MaterialTheme.colorScheme.error to Icons.Rounded.Warning
        UploadStatus.Cancelled -> MaterialTheme.colorScheme.outline to Icons.Rounded.Cancel
    }

    Surface(
        shape = CircleShape,
        color = color.copy(alpha = 0.9f),
        modifier = modifier.size(20.dp)
    ) {
        Box(contentAlignment = Alignment.Center) {
            if (status == UploadStatus.InProgress) {
                CircularProgressIndicator(
                    modifier = Modifier.size(12.dp),
                    strokeWidth = 1.5.dp,
                    color = Color.White
                )
            } else if (icon != null) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(12.dp)
                )
            }
        }
    }
}

// ─── Color helpers ───────────────────────────────────────────────
@Composable
private fun statusColor(status: UploadStatus): Color = when (status) {
    UploadStatus.Queued -> MaterialTheme.colorScheme.onSurfaceVariant
    UploadStatus.InProgress -> MaterialTheme.colorScheme.primary
    UploadStatus.Completed -> MaterialTheme.colorScheme.primary
    UploadStatus.Failed -> MaterialTheme.colorScheme.error
    UploadStatus.Cancelled -> MaterialTheme.colorScheme.onSurfaceVariant
}

@Composable
private fun typeColor(type: UploadType): Color = when (type) {
    UploadType.ManualBackup -> MaterialTheme.colorScheme.primary
    UploadType.AutoBackup -> MaterialTheme.colorScheme.tertiary
    UploadType.Instant -> MaterialTheme.colorScheme.secondary
}
