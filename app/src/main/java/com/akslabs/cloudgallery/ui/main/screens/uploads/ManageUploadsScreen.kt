package com.akslabs.cloudgallery.ui.main.screens.uploads

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.togetherWith
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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Backup
import androidx.compose.material.icons.rounded.Cancel
import androidx.compose.material.icons.rounded.CheckCircle
import androidx.compose.material.icons.rounded.CloudDone
import androidx.compose.material.icons.rounded.CloudOff
import androidx.compose.material.icons.rounded.CloudQueue
import androidx.compose.material.icons.rounded.CloudUpload
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
import androidx.compose.material3.IconButton
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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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

// ─── Tab definitions ─────────────────────────────────────────────
private enum class UploadTab(val label: String, val icon: ImageVector) {
    All("All", Icons.Rounded.CloudUpload),
    Manual("Manual", Icons.Rounded.Upload),
    AutoBackup("Auto Backup", Icons.Rounded.Backup),
    Queued("Queued", Icons.Rounded.Schedule)
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
    val queuedPhotos by viewModel.queuedPhotos.collectAsState()
    val haptic = LocalHapticFeedback.current

    var selectedTab by remember { mutableIntStateOf(0) }
    val tabs = UploadTab.entries

    // Stats
    val activeCount = allUploads.count { it.status == UploadStatus.InProgress }
    val completedCount = allUploads.count { it.status == UploadStatus.Completed }
    val failedCount = allUploads.count { it.status == UploadStatus.Failed }

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        contentWindowInsets = WindowInsets.navigationBars,
        topBar = {
            LargeTopAppBar(
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
                                    text = "${queuedPhotos.size} queued",
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
                        modifier = Modifier.padding(start = 12.dp).size(40.dp)
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
                            modifier = Modifier.padding(end = 8.dp).size(40.dp)
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
            // ─── Scrollable Tab Row with pills ───────────────────
            ScrollableTabRow(
                selectedTabIndex = selectedTab,
                edgePadding = 16.dp,
                containerColor = Color.Transparent,
                contentColor = MaterialTheme.colorScheme.primary,
                divider = {},
                indicator = {} // We handle selection via Surface color on each tab
            ) {
                tabs.forEachIndexed { index, tab ->
                    val isSelected = selectedTab == index
                    Tab(
                        selected = isSelected,
                        onClick = {
                            haptic.performHapticFeedback(HapticFeedbackType.TextHandleMove)
                            selectedTab = index
                        },
                        modifier = Modifier.padding(horizontal = 4.dp, vertical = 8.dp)
                    ) {
                        Surface(
                            shape = RoundedCornerShape(50),
                            color = if (isSelected) MaterialTheme.colorScheme.primaryContainer
                            else MaterialTheme.colorScheme.surfaceContainerHigh,
                            contentColor = if (isSelected) MaterialTheme.colorScheme.onPrimaryContainer
                            else MaterialTheme.colorScheme.onSurfaceVariant
                        ) {
                            Row(
                                modifier = Modifier.padding(horizontal = 16.dp, vertical = 10.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(6.dp)
                            ) {
                                Icon(tab.icon, contentDescription = null, modifier = Modifier.size(18.dp))
                                Text(
                                    text = tab.label,
                                    style = MaterialTheme.typography.labelLarge,
                                    fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium
                                )
                            }
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // ─── Content per tab ─────────────────────────────────
            AnimatedContent(
                targetState = selectedTab,
                transitionSpec = {
                    (fadeIn(tween(200)) + slideInVertically { it / 8 }) togetherWith
                            (fadeOut(tween(150)) + slideOutVertically { -it / 8 })
                },
                label = "tab_content"
            ) { tab ->
                when (tab) {
                    0 -> UploadListContent(
                        uploads = allUploads,
                        queuedPhotos = queuedPhotos,
                        showQueued = true,
                        onCancel = { viewModel.cancelUpload(it) },
                        onPhotoClick = { photoId -> navigateToViewer(navController, photoId) },
                        navController = navController
                    )
                    1 -> UploadListContent(
                        uploads = manualUploads,
                        queuedPhotos = emptyList(),
                        showQueued = false,
                        onCancel = { viewModel.cancelUpload(it) },
                        onPhotoClick = { photoId -> navigateToViewer(navController, photoId) },
                        navController = navController,
                        emptyMessage = "No manual uploads",
                        emptyIcon = Icons.Rounded.UploadFile
                    )
                    2 -> UploadListContent(
                        uploads = autoBackupUploads,
                        queuedPhotos = emptyList(),
                        showQueued = false,
                        onCancel = { viewModel.cancelUpload(it) },
                        onPhotoClick = { photoId -> navigateToViewer(navController, photoId) },
                        navController = navController,
                        emptyMessage = "No automatic backups",
                        emptyIcon = Icons.Rounded.Backup
                    )
                    3 -> UploadListContent(
                        uploads = emptyList(),
                        queuedPhotos = queuedPhotos,
                        showQueued = true,
                        onCancel = {},
                        onPhotoClick = { photoId -> navigateToViewer(navController, photoId) },
                        navController = navController,
                        emptyMessage = "All photos are uploaded!",
                        emptyIcon = Icons.Rounded.CloudDone
                    )
                }
            }
        }
    }
}

private fun navigateToViewer(navController: NavController, photoId: String) {
    try {
        navController.navigate("photo_viewer/$photoId/false")
    } catch (e: Exception) {
        // Silently handle navigation errors
    }
}

// ─── Stat pill ───────────────────────────────────────────────────
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
    onPhotoClick: (String) -> Unit,
    navController: NavController,
    emptyMessage: String = "Nothing here yet",
    emptyIcon: ImageVector = Icons.Rounded.CloudQueue
) {
    val isEmpty = uploads.isEmpty() && (!showQueued || queuedPhotos.isEmpty())

    if (isEmpty) {
        // ─── Empty state ─────────────────────────────────────
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
                            tint = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.6f)
                        )
                    }
                }
                Text(
                    text = emptyMessage,
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.6f),
                    fontWeight = FontWeight.Medium
                )
            }
        }
    } else {
        LazyColumn(
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            // Active / worker uploads
            if (uploads.isNotEmpty()) {
                item {
                    SectionHeader(
                        title = "Active & Recent",
                        icon = Icons.Rounded.CloudUpload
                    )
                }
                items(uploads, key = { it.id }) { item ->
                    UploadItemCard(
                        item = item,
                        onCancel = { onCancel(item.id) },
                        onTap = {
                            if (item.thumbnailUri != null) {
                                onPhotoClick(item.id)
                            }
                        },
                        modifier = Modifier.animateItem()
                    )
                }
            }

            // Queued from DB
            if (showQueued && queuedPhotos.isNotEmpty()) {
                item {
                    Spacer(modifier = Modifier.height(8.dp))
                    SectionHeader(
                        title = "Pending Upload (${queuedPhotos.size})",
                        icon = Icons.Rounded.HourglassTop
                    )
                }
                items(queuedPhotos, key = { "queued_${it.localId}" }) { photo ->
                    QueuedPhotoCard(
                        photo = photo,
                        onTap = { onPhotoClick(photo.localId) },
                        modifier = Modifier.animateItem()
                    )
                }
            }
        }
    }
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

// ─── Upload Item Card (worker-based) ─────────────────────────────
@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun UploadItemCard(
    item: UploadUiItem,
    onCancel: () -> Unit,
    onTap: () -> Unit,
    modifier: Modifier = Modifier
) {
    val haptic = LocalHapticFeedback.current
    var showContextMenu by remember { mutableStateOf(false) }

    Surface(
        shape = RoundedCornerShape(20.dp),
        color = MaterialTheme.colorScheme.surfaceContainerLow,
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
                modifier = Modifier.padding(16.dp),
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
                            model = ImageRequest.Builder(LocalContext.current)
                                .data(item.thumbnailUri)
                                .crossfade(true)
                                .size(256)
                                .build(),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize()
                        )
                        // Gradient scrim for status badge visibility
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(
                                    Brush.verticalGradient(
                                        0f to Color.Transparent,
                                        1f to Color.Black.copy(alpha = 0.15f)
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
                            tint = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.5f),
                            modifier = Modifier.size(28.dp)
                        )
                    }
                    // Small status badge
                    StatusBadge(
                        status = item.status,
                        modifier = Modifier.align(Alignment.BottomEnd).padding(4.dp)
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
                    Text(
                        text = item.progressText.ifEmpty { item.status.name },
                        style = MaterialTheme.typography.bodySmall,
                        color = statusColor(item.status),
                        fontWeight = FontWeight.Medium
                    )
                    // Upload type label
                    Surface(
                        shape = RoundedCornerShape(6.dp),
                        color = typeColor(item.type).copy(alpha = 0.12f),
                        modifier = Modifier.padding(top = 4.dp)
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
                }

                // ─── Cancel button ───────────────────────────
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

            // ─── Progress bar ───────────────────────────────
            AnimatedVisibility(visible = item.status == UploadStatus.InProgress) {
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
                            .padding(horizontal = 16.dp),
                        strokeCap = StrokeCap.Round,
                        trackColor = MaterialTheme.colorScheme.surfaceContainerHighest,
                    )
                } else {
                    LinearProgressIndicator(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(4.dp)
                            .padding(horizontal = 16.dp),
                        strokeCap = StrokeCap.Round,
                        trackColor = MaterialTheme.colorScheme.surfaceContainerHighest,
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
            }
        }

        // ─── Long-press context menu ─────────────────────
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
                    text = { Text("Retry") },
                    leadingIcon = { Icon(Icons.Rounded.Refresh, contentDescription = null, modifier = Modifier.size(20.dp)) },
                    onClick = { showContextMenu = false }
                )
            }
        }
    }
}

// ─── Queued Photo Card (from database) ───────────────────────────
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
                    color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.6f)
                )
            }

            Surface(
                shape = RoundedCornerShape(8.dp),
                color = MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.5f)
            ) {
                Text(
                    text = "Queued",
                    style = MaterialTheme.typography.labelSmall,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSecondaryContainer,
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                )
            }
        }
    }
}

// ─── Status Badge ────────────────────────────────────────────────
@Composable
private fun StatusBadge(status: UploadStatus, modifier: Modifier = Modifier) {
    val (color, icon) = when (status) {
        UploadStatus.Queued -> MaterialTheme.colorScheme.secondary to Icons.Rounded.Schedule
        UploadStatus.InProgress -> MaterialTheme.colorScheme.primary to null // Use spinner
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

// ─── Helpers ─────────────────────────────────────────────────────
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
