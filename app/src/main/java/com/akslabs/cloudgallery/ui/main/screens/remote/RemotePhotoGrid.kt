package com.akslabs.cloudgallery.ui.main.screens.remote

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.rounded.Cloud
import androidx.compose.material.icons.rounded.CloudOff
import androidx.compose.material.icons.rounded.CloudDownload
import androidx.compose.animation.*
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.snap
import androidx.compose.animation.core.tween
import androidx.compose.material3.*
import androidx.navigation.NavController
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import coil.compose.AsyncImage
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest
import coil.size.Size

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import androidx.compose.runtime.snapshotFlow
import com.akslabs.cloudgallery.ui.components.DragSelectableLazyVerticalGrid
import com.akslabs.cloudgallery.ui.components.ExpressiveScrollbar
import com.akslabs.cloudgallery.R
import com.akslabs.cloudgallery.data.localdb.entities.RemotePhoto
import com.akslabs.cloudgallery.ui.components.LoadAnimation
import com.akslabs.cloudgallery.ui.components.PhotoPageView
import com.akslabs.cloudgallery.ui.main.rememberGridState
import com.akslabs.cloudgallery.utils.coil.ImageLoaderModule
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.akslabs.cloudgallery.data.localdb.Preferences
import androidx.compose.material3.FloatingToolbarDefaults.floatingToolbarVerticalNestedScroll
import androidx.compose.ui.graphics.graphicsLayer
import com.akslabs.cloudgallery.ui.components.ExpressiveEmptyState
import com.akslabs.cloudgallery.ui.main.nav.Screens

private const val TAG = "RemotePhotoGrid"

// Sealed class for remote grid items to support date grouping
sealed class RemoteGridItem {
    data class PhotoItem(val photo: RemotePhoto, val originalIndex: Int) : RemoteGridItem()
    data class HeaderItem(val dateLabel: String, val id: String) : RemoteGridItem()
}

// Data class for remote date groups
data class RemoteDateGroup(
    val dateLabel: String,
    val photos: List<Pair<RemotePhoto, Int>>, // RemotePhoto with original index
    val sortKey: Long // For efficient sorting
)

// Optimized remote layout cache
data class RemoteLayoutCache(
    val normalGridItems: List<RemoteGridItem>,
    val dateGroupedItems: List<RemoteGridItem>,
    val idToNormalIndex: Map<String, Int>,
    val idToDateGroupedIndex: Map<String, Int>,
    val totalPhotos: Int,
    val lastUpdateTime: Long
)

// Function to format remote photo date with fallback
private fun formatRemotePhotoDate(timestamp: Long): String {
    return try {
        java.text.SimpleDateFormat("EEE d - LLLL yyyy", java.util.Locale.getDefault()).format(java.util.Date(timestamp))
    } catch (e: Exception) {
        "Unknown Date"
    }
}

// Optimized function to group remote photos by date ensuring ALL photos are included
private fun groupRemotePhotosByDateOptimized(
    cloudPhotos: LazyPagingItems<RemotePhoto>
): List<RemoteDateGroup> {
    val photosByDate = mutableMapOf<String, MutableList<Pair<RemotePhoto, Int>>>()
    var processedCount = 0
    var skippedCount = 0

    Log.d(TAG, "🔍 Starting remote date grouping for ${cloudPhotos.itemCount} photos")

    // Process ALL photos - no filtering
    for (i in 0 until cloudPhotos.itemCount) {
        val photo = cloudPhotos.peek(i)
        if (photo != null) {
            val dateLabel = formatRemotePhotoDate(photo.uploadedAt)
            photosByDate.getOrPut(dateLabel) { mutableListOf() }.add(photo to i)
            processedCount++
        } else {
            skippedCount++
        }
    }

    Log.d(TAG, "✅ Remote date grouping complete: $processedCount processed, $skippedCount skipped")

    // Convert to sorted list of RemoteDateGroups (most recent first)
    return photosByDate.map { (dateLabel, photos) ->
        val sortKey = photos.maxOfOrNull { it.first.uploadedAt } ?: 0L
        RemoteDateGroup(
            dateLabel = dateLabel,
            photos = photos.sortedByDescending { it.first.uploadedAt },
            sortKey = sortKey
        )
    }.sortedByDescending { it.sortKey }
}

// Optimized function to create remote layout cache
private fun createRemoteLayoutCache(
    cloudPhotos: LazyPagingItems<RemotePhoto>
): RemoteLayoutCache {
    val startTime = System.currentTimeMillis()

    // Create normal grid items (simple list)
    val normalGridItems = (0 until cloudPhotos.itemCount).mapNotNull { index ->
        cloudPhotos.peek(index)?.let { photo ->
            RemoteGridItem.PhotoItem(photo, index)
        }
    }

    // Create date grouped items
    val dateGroups = groupRemotePhotosByDateOptimized(cloudPhotos)
    val dateGroupedItems = mutableListOf<RemoteGridItem>()

    dateGroups.forEachIndexed { groupIndex, dateGroup ->
        // Add date header
        dateGroupedItems.add(RemoteGridItem.HeaderItem(
            dateLabel = dateGroup.dateLabel,
            id = "header_${groupIndex}_${dateGroup.dateLabel}"
        ))

        // Add all photos for this date
        dateGroup.photos.forEach { (photo, originalIndex) ->
            dateGroupedItems.add(RemoteGridItem.PhotoItem(photo, originalIndex))
        }
    }

    val idToNormalIndex = mutableMapOf<String, Int>()
    normalGridItems.forEachIndexed { index, item ->
        idToNormalIndex[item.photo.remoteId] = index
    }

    val idToDateGroupedIndex = mutableMapOf<String, Int>()
    dateGroupedItems.forEachIndexed { index, item ->
        if (item is RemoteGridItem.PhotoItem) idToDateGroupedIndex[item.photo.remoteId] = index
    }

    return RemoteLayoutCache(
        normalGridItems = normalGridItems,
        dateGroupedItems = dateGroupedItems,
        idToNormalIndex = idToNormalIndex,
        idToDateGroupedIndex = idToDateGroupedIndex,
        totalPhotos = cloudPhotos.itemCount,
        lastUpdateTime = System.currentTimeMillis()
    )
}

@OptIn(ExperimentalAnimationApi::class, ExperimentalSharedTransitionApi::class, ExperimentalMaterial3ExpressiveApi::class, kotlinx.coroutines.FlowPreview::class)
@Composable
fun RemotePhotosGrid(
    cloudPhotos: LazyPagingItems<RemotePhoto>,
    onPhotoClick: (Int, RemotePhoto?) -> Unit,
    expanded: Boolean,
    onExpandedChange: (Boolean) -> Unit,
    selectionMode: Boolean,
    selectedPhotos: Set<String>,
    onSelectionModeChange: (Boolean) -> Unit,
    onSelectedPhotosChange: (Set<String>) -> Unit,
    navController: NavController,
    sharedTransitionScope: SharedTransitionScope,
    animatedVisibilityScope: AnimatedVisibilityScope,
    lastViewedPhotoId: String? = null,
    clickedPhotoId: String? = null,
    savedIndex: Int = 0,
    savedOffset: Int = 0,
    onSaveScrollState: (String, Int, Int) -> Unit = { _, _, _ -> },
    onLastViewedPhotoConsumed: () -> Unit = {}
) {
    Log.e(TAG, "🎯 === REMOTE PHOTO GRID COMPOSING ===")
    val context = LocalContext.current

    val glideSelectionBehavior by Preferences.getStringFlow(Preferences.glideSelectionBehaviorKey, "Fixed").collectAsStateWithLifecycle()
    val thumbnailResolution = Preferences.getInt(Preferences.thumbnailResolutionKey, Preferences.defaultThumbnailResolution)
    var isScrollbarDragging by remember { mutableStateOf(false) }

    if (selectionMode) {
        BackHandler(enabled = true) {
            onSelectionModeChange(false)
            onSelectedPhotosChange(emptySet())
        }
    }

    fun toggleSelection(photoId: String) {
        val newSelectedPhotos = if (selectedPhotos.contains(photoId)) {
            selectedPhotos - photoId
        } else {
            selectedPhotos + photoId
        }
        onSelectedPhotosChange(newSelectedPhotos)
        if (newSelectedPhotos.isEmpty()) {
            onSelectionModeChange(false)
        }
    }

    // Responsive grid configuration (3-6 columns, default 4)
    val gridState = rememberGridState()
    val columns = gridState.columnCount.coerceIn(3, 6)
    val horizontalSpacing = 12.dp
    val verticalSpacing = 12.dp

    // Layout mode configuration
    val isDateGroupedLayout = gridState.isDateGroupedLayout

    // Create layout cache off-thread to prevent UI jank
    var layoutCache by remember { 
        mutableStateOf(RemoteLayoutCache(emptyList(), emptyList(), emptyMap(), emptyMap(), 0, 0L)) 
    }

    LaunchedEffect(cloudPhotos.itemSnapshotList, isDateGroupedLayout) {
        withContext(Dispatchers.Default) {
            val newCache = createRemoteLayoutCache(cloudPhotos)
            withContext(Dispatchers.Main) {
                layoutCache = newCache
            }
        }
    }

    val currentLayoutItems = if (isDateGroupedLayout) layoutCache.dateGroupedItems else layoutCache.normalGridItems

    // Initialize scroll state with EXACT position if returning to the same photo
    val (initialIndex, initialOffset) = remember(lastViewedPhotoId, layoutCache, clickedPhotoId, savedIndex, savedOffset) {
        if (!lastViewedPhotoId.isNullOrEmpty() && layoutCache.totalPhotos > 0) {
            if (lastViewedPhotoId == clickedPhotoId) {
                // Return to EXACTLY where we left off
                savedIndex to savedOffset
            } else {
                // User swiped, find new index
                val indexMap = if (isDateGroupedLayout) layoutCache.idToDateGroupedIndex else layoutCache.idToNormalIndex
                val index = indexMap[lastViewedPhotoId] ?: -1
                val newIndex = if (index != -1) index else 0
                newIndex to 0
            }
        } else {
            0 to 0
        }
    }

    val lazyGridState = rememberLazyGridState(
        initialFirstVisibleItemIndex = initialIndex, 
        initialFirstVisibleItemScrollOffset = initialOffset
    )

    // Create header-to-index map for lightning fast scrollbar label lookup
    var headerIndices by remember { mutableStateOf<List<Pair<Int, String>>>(emptyList()) }
    var effectiveTotalRows by remember { mutableStateOf(0) }

    LaunchedEffect(currentLayoutItems, columns, isDateGroupedLayout) {
        withContext(Dispatchers.Default) {
            val indices = currentLayoutItems.mapIndexedNotNull { index, item ->
                if (item is RemoteGridItem.HeaderItem) index to item.dateLabel else null
            }

            val totalRows = if (isDateGroupedLayout) {
                var rowsCount = 0
                layoutCache.dateGroupedItems.forEach { item ->
                    if (item is RemoteGridItem.HeaderItem) {
                        rowsCount++
                    }
                }
                val photosCount = layoutCache.dateGroupedItems.count { it is RemoteGridItem.PhotoItem }
                rowsCount + kotlin.math.ceil(photosCount.toFloat() / columns).toInt()
            } else {
                kotlin.math.ceil(layoutCache.normalGridItems.size.toFloat() / columns).toInt()
            }

            withContext(Dispatchers.Main) {
                headerIndices = indices
                effectiveTotalRows = totalRows
            }
        }
    }

    // Sync scroll to last viewed photo (backup)
    LaunchedEffect(lastViewedPhotoId, layoutCache) {
        if (!lastViewedPhotoId.isNullOrEmpty() && layoutCache.totalPhotos > 0) {
            // Wait for layout to settle
            kotlinx.coroutines.delay(100)
            
            val index = if (isDateGroupedLayout) {
                layoutCache.idToDateGroupedIndex[lastViewedPhotoId] ?: -1
            } else {
                layoutCache.idToNormalIndex[lastViewedPhotoId] ?: -1
            }
            if (index != -1) {
                // Check visibility just for logging/debugging if needed, but we force scroll
                val visibleItems = lazyGridState.layoutInfo.visibleItemsInfo
                val isVisible = visibleItems.any { it.index == index }
                
                if (!isVisible) {
                    lazyGridState.scrollToItem(index)
                }
                // onLastViewedPhotoConsumed()
            }
        }
    }
    // Optimized prefetching for remote photos: Debounced to prevent main thread saturation
    LaunchedEffect(currentLayoutItems, isScrollbarDragging) {
        if (isScrollbarDragging || layoutCache.totalPhotos == 0) return@LaunchedEffect
        
        snapshotFlow { lazyGridState.layoutInfo.visibleItemsInfo.lastOrNull()?.index }
            .distinctUntilChanged()
            .debounce(250) // More conservative debounce for remote items
            .collectLatest { lastIndex ->
                if (lastIndex == null) return@collectLatest
                
                withContext(Dispatchers.IO) {
                    try {
                        val prefetchRange = (lastIndex + 1)..(lastIndex + 20)
                        prefetchRange.forEach { index ->
                            if (index in currentLayoutItems.indices) {
                                when (val item = currentLayoutItems[index]) {
                                    is RemoteGridItem.PhotoItem -> {
                                        val request = ImageRequest.Builder(context)
                                            .data(item.photo)
                                            .size(64, 64) // Prefetch small thumbnails first
                                            .memoryCachePolicy(coil.request.CachePolicy.ENABLED)
                                            .build()
                                        ImageLoaderModule.thumbnailImageLoader.enqueue(request)
                                    }
                                    else -> {}
                                }
                            }
                        }
                    } catch (e: Exception) {
                        Log.e(TAG, "Remote prefetch error: ${e.message}")
                    }
                }
            }
    }

    val maxLineSpan = columns

    Box(modifier = Modifier.fillMaxSize()) {
        if (cloudPhotos.loadState.refresh == LoadState.Loading && cloudPhotos.itemCount == 0) {
            LoadAnimation(modifier = Modifier.align(Alignment.Center))
        } else if (cloudPhotos.itemCount == 0 && cloudPhotos.loadState.refresh is LoadState.NotLoading) {
             ExpressiveEmptyState(
                icon = Icons.Rounded.Cloud,
                title = "No cloud photos",
                description = "Sync images to view your collection here anytime, anywhere.",
                actionText = "Start Backup",
                onActionClick = {
                    // Navigate to settings or trigger backup
                    navController.navigate(Screens.Settings.route)
                }
            )
        } else {
            ExpressiveScrollbar(
                lazyGridState = lazyGridState,
                totalRows = effectiveTotalRows,
                modifier = Modifier.align(Alignment.CenterEnd),
                onDraggingChange = { isDragging -> isScrollbarDragging = isDragging },
                labelProvider = { index ->
                    val safeIndex = index.coerceIn(0, currentLayoutItems.size - 1)
                    
                    // Binary search for the nearest header at or above safeIndex
                    var low = 0
                    var high = headerIndices.size - 1
                    var result = "..."
                    
                    while (low <= high) {
                        val mid = (low + high) / 2
                        if (headerIndices[mid].first <= safeIndex) {
                            result = headerIndices[mid].second
                            low = mid + 1
                        } else {
                            high = mid - 1
                        }
                    }
                    result
                }
            )
            DragSelectableLazyVerticalGrid(
                lazyGridState = lazyGridState,
                selectionEnabled = selectionMode,
                glideSelectionBehavior = glideSelectionBehavior,
                onItemSelectionChange = { key, isSelected ->
                    if (key is String && !key.startsWith("header_")) {
                        val photoId = key
                        val currentlySelected = selectedPhotos.contains(photoId)
                        if (isSelected != currentlySelected) {
                            toggleSelection(photoId)
                        }
                        if (!selectionMode && isSelected) {
                            onSelectionModeChange(true)
                        }
                    }
                },
                isItemSelected = { key ->
                    if (key is String && !key.startsWith("header_")) {
                        selectedPhotos.contains(key)
                    } else false
                },
                onDragSelectionEnd = {
                    if (selectedPhotos.isEmpty()) {
                        onSelectionModeChange(false)
                    }
                },
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(20.dp))
                    .background(MaterialTheme.colorScheme.background)
                    .floatingToolbarVerticalNestedScroll(
                        expanded = expanded,
                        onExpand = { onExpandedChange(true) },
                        onCollapse = { onExpandedChange(false) },
                    ),
                columns = GridCells.Fixed(columns),
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                verticalArrangement = Arrangement.spacedBy(verticalSpacing),
                horizontalArrangement = Arrangement.spacedBy(horizontalSpacing)
            ) {
                // Unified remote layout rendering with smooth transitions
                items(
                    count = currentLayoutItems.size,
                    key = { index ->
                        when (val item = currentLayoutItems[index]) {
                            is RemoteGridItem.HeaderItem -> item.id
                            is RemoteGridItem.PhotoItem -> item.photo.remoteId
                        }
                    },
                    span = { index ->
                        when (currentLayoutItems[index]) {
                            is RemoteGridItem.HeaderItem -> GridItemSpan(maxLineSpan)
                            is RemoteGridItem.PhotoItem -> GridItemSpan(1)
                        }
                    }
                ) { index ->
                    when (val item = currentLayoutItems[index]) {
                        is RemoteGridItem.HeaderItem -> {
                            // Date header
                            Text(
                                text = item.dateLabel,
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.SemiBold,
                                color = MaterialTheme.colorScheme.onSurface,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 8.dp, bottom = 4.dp)
                            )
                        }
                        is RemoteGridItem.PhotoItem -> {
                            val isSelected = selectedPhotos.contains(item.photo.remoteId)
                            CloudPhotoItem(
                                remotePhoto = item.photo,
                                index = item.originalIndex,
                                isSelected = isSelected,
                                isScrollbarDragging = isScrollbarDragging,
                                thumbnailResolution = thumbnailResolution,
                                sharedTransitionScope = sharedTransitionScope,
                                animatedVisibilityScope = animatedVisibilityScope,
                                modifier = Modifier.clickable(
                                    onClick = {
                                        if (selectionMode) {
                                            toggleSelection(item.photo.remoteId)
                                        } else {
                                            onSaveScrollState(
                                                item.photo.remoteId,
                                                lazyGridState.firstVisibleItemIndex,
                                                lazyGridState.firstVisibleItemScrollOffset
                                            )
                                            onPhotoClick(item.originalIndex, item.photo)
                                        }
                                    }
                                )
                            )
                        }
                    }
                }
            }
        }

    }
}

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun CloudPhotoItem(
    remotePhoto: RemotePhoto?,
    index: Int,
    isSelected: Boolean,
    isScrollbarDragging: Boolean = false,
    thumbnailResolution: Int = 150,
    sharedTransitionScope: SharedTransitionScope,
    animatedVisibilityScope: AnimatedVisibilityScope,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current

    // Performance: Disable entrance animations during active scrollbar dragging
    val skipEntrance = isScrollbarDragging
    var isVisible by remember { mutableStateOf(skipEntrance) }
    
    if (!skipEntrance && !isVisible) {
        LaunchedEffect(Unit) {
            delay((index % 6) * 30L) // Stagger
            isVisible = true
        }
    }

    val animatedValues by animateFloatAsState(
        targetValue = if (isVisible) 1f else 0f,
        animationSpec = if (!skipEntrance) tween(250) else snap(),
        label = "item_entrance"
    )

    with(sharedTransitionScope) {
        Box(
            modifier = modifier
                .sharedElement(
                    rememberSharedContentState(key = "photo_${remotePhoto?.remoteId}"),
                    animatedVisibilityScope = animatedVisibilityScope,
                    boundsTransform = { _, _ -> com.akslabs.cloudgallery.ui.theme.AnimationConstants.PremiumBoundsSpring }
                )
                .aspectRatio(1f)
                .graphicsLayer {
                    val entrance = if (skipEntrance) 1f else animatedValues
                    // Removed alpha = entrance to keep placeholder icon visible
                    scaleX = 0.92f + 0.08f * entrance
                    scaleY = 0.92f + 0.08f * entrance
                    translationY = (1f - entrance) * 15f
                }
                .clip(RoundedCornerShape(16.dp))
                .background(MaterialTheme.colorScheme.surfaceContainerLow)
                .then(
                    if (isSelected) Modifier.border(
                        6.dp, 
                        MaterialTheme.colorScheme.primary, 
                        RoundedCornerShape(16.dp)
                    ) else Modifier
                ),
            contentAlignment = Alignment.Center
        ) {
            // Visual Placeholder (Icon) shown behind the AsyncImage
            Icon(
                imageVector = Icons.Rounded.CloudDownload,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.2f),
                modifier = Modifier.size(32.dp)
            )

            if (remotePhoto != null) {
                // Fix: Stabilize ImageRequest model
                val imageRequest = remember(remotePhoto.remoteId) {
                    ImageRequest.Builder(context)
                        .data(remotePhoto)
                        .size(180, 180)
                        .memoryCacheKey("grid_thumb_${remotePhoto.remoteId}")
                        .diskCacheKey("grid_thumb_${remotePhoto.remoteId}")
                        .allowHardware(true)
                        .allowRgb565(true)
                        .crossfade(200)
                        .build()
                }
                
                AsyncImage(
                    imageLoader = ImageLoaderModule.thumbnailImageLoader,
                    model = imageRequest,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxSize()
                        .graphicsLayer {
                            // Apply entrance alpha ONLY to the image
                            alpha = if (skipEntrance) 1f else animatedValues
                        },
                    contentDescription = stringResource(id = R.string.photo),
                    placeholder = null
                )

                // Selection Tonal Overlay
                if (isSelected) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(6.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.15f))
                    )
                }
            } else {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.surfaceContainerLow)
                )
            }
            
            if (isSelected) {
                Box(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(10.dp)
                        .background(MaterialTheme.colorScheme.primary, CircleShape)
                        .size(28.dp)
                        .border(2.dp, MaterialTheme.colorScheme.onPrimary, CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Check,
                        contentDescription = "Selected",
                        tint = MaterialTheme.colorScheme.onPrimary,
                        modifier = Modifier.size(18.dp)
                    )
                }
            }
        }
    }
}

// Helper function to find the current activity from the context
private fun Context.findActivity(): Activity? {
    var context = this
    while (context is ContextWrapper) {
        if (context is Activity) return context
        context = context.baseContext
    }
    return null
}
