package com.akslabs.cloudgallery.ui.main.screens.local

import android.app.Activity
import android.content.ContentUris
import android.content.Context
import android.content.ContextWrapper
import android.provider.MediaStore
import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.rounded.Block
import androidx.compose.material.icons.rounded.BrokenImage
import androidx.compose.material.icons.rounded.Cloud
import androidx.compose.material.icons.rounded.CloudDone
import androidx.compose.animation.*
import androidx.compose.animation.core.snap
import androidx.compose.material.icons.rounded.PhoneAndroid
import androidx.compose.material3.*
import androidx.navigation.NavController
import com.akslabs.cloudgallery.ui.main.nav.Screens
import androidx.compose.material3.FloatingToolbarDefaults.floatingToolbarVerticalNestedScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.runtime.derivedStateOf
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.distinctUntilChanged
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.size.Size
import com.akslabs.cloudgallery.ui.components.DragSelectableLazyVerticalGrid
import com.akslabs.cloudgallery.ui.components.ExpressiveScrollbar
import com.akslabs.cloudgallery.BuildConfig
import com.akslabs.cloudgallery.R
import com.akslabs.cloudgallery.data.localdb.DbHolder
import com.akslabs.cloudgallery.data.localdb.Preferences
import com.akslabs.cloudgallery.data.localdb.dao.SyncedPhotoTuple
import com.akslabs.cloudgallery.data.mediastore.LocalUiPhoto
import com.akslabs.cloudgallery.ui.components.ExpressiveEmptyState
import com.akslabs.cloudgallery.ui.components.LoadAnimation
import com.akslabs.cloudgallery.ui.components.PhotoPageView
import com.akslabs.cloudgallery.ui.main.rememberGridState
import com.akslabs.cloudgallery.utils.coil.ImageLoaderModule
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

private const val TAG = "LocalPhotoGrid"

private fun Context.findActivity(): Activity? {
    var context = this
    while (context is ContextWrapper) {
        if (context is Activity) return context
        context = context.baseContext
    }
    return null
}

// Sealed class for grid items to support date grouping
sealed class LocalGridItem {
    data class PhotoItem(val photo: LocalUiPhoto, val originalIndex: Int) : LocalGridItem()
    data class HeaderItem(val dateLabel: String, val id: String) : LocalGridItem()
}

// Data class for date groups
data class DateGroup(
    val dateLabel: String,
    val photos: List<Pair<LocalUiPhoto, Int>>, // Photo with original index
    val sortKey: Long // For efficient sorting
)

// Optimized layout cache
data class LayoutCache(
    val normalGridItems: List<LocalGridItem>,
    val dateGroupedItems: List<LocalGridItem>,
    val totalPhotos: Int,
    val lastUpdateTime: Long
)

// Avoid heavy per-item resolver calls in UI thread
private fun safeTimestampFromLocalId(localId: String): Long = localId.toLongOrNull()?.times(1000L) ?: 0L



// Function to format date with fallback
private fun formatPhotoDate(timestamp: Long): String {
    return try {
        java.text.SimpleDateFormat("EEE d - LLLL yyyy", java.util.Locale.getDefault()).format(java.util.Date(timestamp))
    } catch (e: Exception) {
        "Unknown Date"
    }
}

// Optimized function to group photos by date ensuring ALL photos are included
private fun groupPhotosByDateOptimized(
    allPhotos: List<LocalUiPhoto>,
    deletedPhotoIds: List<String>
): List<DateGroup> {
    val photosByDate = mutableMapOf<String, MutableList<Pair<LocalUiPhoto, Int>>>()
    
    allPhotos.forEachIndexed { index, photo ->
        if (!deletedPhotoIds.contains(photo.localId)) {
            val dateLabel = formatPhotoDate(photo.displayDateMillis)
            photosByDate.getOrPut(dateLabel) { mutableListOf() }.add(photo to index)
        }
    }

    return photosByDate.map { (dateLabel, photos) ->
        val sortKey = photos.maxOfOrNull { it.first.displayDateMillis } ?: 0L
        DateGroup(
            dateLabel = dateLabel,
            photos = photos.sortedByDescending { it.first.displayDateMillis },
            sortKey = sortKey
        )
    }.sortedByDescending { it.sortKey }
}

// Optimized function to create layout cache
private fun createLayoutCache(
    allPhotos: List<LocalUiPhoto>,
    deletedPhotoIds: List<String>
): LayoutCache {
    val start = System.currentTimeMillis()

    // Create normal grid items
    val normalGridItems = allPhotos.mapIndexedNotNull { index, photo ->
        if (deletedPhotoIds.contains(photo.localId)) null else LocalGridItem.PhotoItem(photo, index)
    }

    // Create date grouped items
    val dateGroups = groupPhotosByDateOptimized(allPhotos, deletedPhotoIds)
    val dateGroupedItems = mutableListOf<LocalGridItem>()

    dateGroups.forEachIndexed { groupIndex, dateGroup ->
        // Add date header
        dateGroupedItems.add(LocalGridItem.HeaderItem(
            dateLabel = dateGroup.dateLabel,
            id = "header_${groupIndex}_${dateGroup.dateLabel}"
        ))

        // Add all photos for this date
        dateGroup.photos.forEach { (photo, originalIndex) ->
            dateGroupedItems.add(LocalGridItem.PhotoItem(photo, originalIndex))
        }
    }

    return LayoutCache(
        normalGridItems = normalGridItems,
        dateGroupedItems = dateGroupedItems,
        totalPhotos = allPhotos.size,
        lastUpdateTime = System.currentTimeMillis()
    )
}

@OptIn(ExperimentalAnimationApi::class, ExperimentalSharedTransitionApi::class, ExperimentalMaterial3ExpressiveApi::class, ExperimentalFoundationApi::class)
@Composable
fun LocalPhotoGrid(
    localPhotos: LazyPagingItems<LocalUiPhoto>,
    totalCount: Int,
    allPhotos: List<LocalUiPhoto>,
    expanded: Boolean,
    onExpandedChange: (Boolean) -> Unit,
    selectionMode: Boolean,
    selectedPhotos: Set<String>,
    onSelectionModeChange: (Boolean) -> Unit,
    onSelectedPhotosChange: (Set<String>) -> Unit,
    deletedPhotoIds: List<String> = emptyList(),
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

    val gridState = rememberGridState()
    val isDateGroupedLayout = gridState.isDateGroupedLayout
    
    // Create layout cache first so we can determine initial index
    val layoutCache = remember(allPhotos, isDateGroupedLayout, deletedPhotoIds.toList()) {
        createLayoutCache(allPhotos, deletedPhotoIds)
    }

    val currentLayoutItems = remember { 
        derivedStateOf { 
            if (isDateGroupedLayout) layoutCache.dateGroupedItems else layoutCache.normalGridItems 
        } 
    }.value


    // Initialize scroll state with EXACT position if returning to the same photo
    val (initialIndex, initialOffset) = remember(lastViewedPhotoId, layoutCache, clickedPhotoId, savedIndex, savedOffset) {
        if (!lastViewedPhotoId.isNullOrEmpty() && layoutCache.totalPhotos > 0) {
            if (lastViewedPhotoId == clickedPhotoId) {
                // Return to EXACTLY where we left off
                Log.d(TAG, "Restoring EXACT state: index=$savedIndex, offset=$savedOffset")
                savedIndex to savedOffset
            } else {
                // User swiped to a new photo, find it and scroll to top
                val index = currentLayoutItems.indexOfFirst { 
                    it is LocalGridItem.PhotoItem && it.photo.localId == lastViewedPhotoId 
                }
                val newIndex = if (index != -1) index else 0
                Log.d(TAG, "Restoring to NEW photo: index=$newIndex")
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
    val headerIndices = remember(currentLayoutItems) {
        currentLayoutItems.mapIndexedNotNull { index, item ->
            if (item is LocalGridItem.HeaderItem) index to item.dateLabel else null
        }
    }

    // Aggressive Prefetching (Optimized to prevent ANR)
    LaunchedEffect(currentLayoutItems, isScrollbarDragging) {
        // Disable prefetching during scrollbar dragging to prioritize scroll performance
        if (isScrollbarDragging) return@LaunchedEffect

        snapshotFlow { lazyGridState.layoutInfo.visibleItemsInfo.lastOrNull()?.index }
            .distinctUntilChanged()
            .collectLatest { lastIndex ->
                if (lastIndex == null) return@collectLatest
                
                // Offload to IO but debounce slightly if needed (collectLatest does this implicitly)
                withContext(Dispatchers.IO) {
                    try {
                         // Prefetch a smaller, more targeted range during active scroll
                         // Micro-Thumbnails (64px) are very cheap
                        val prefetchRange = (lastIndex + 1)..(lastIndex + 60) 
                        prefetchRange.forEach { index ->
                            if (index in currentLayoutItems.indices) {
                                when (val item = currentLayoutItems[index]) {
                                    is LocalGridItem.PhotoItem -> {
                                        val microRequest = ImageRequest.Builder(context)
                                            .data(item.photo.pathUri)
                                            .size(64, 64) 
                                            .allowHardware(true)
                                            .allowRgb565(true)
                                            .memoryCachePolicy(coil.request.CachePolicy.ENABLED)
                                            .build()
                                        ImageLoaderModule.thumbnailImageLoader.enqueue(microRequest)

                                        // Only prefetch full thumbnails for immediate next items
                                        if (index <= lastIndex + 12) {
                                            val standardRequest = ImageRequest.Builder(context)
                                                .data(item.photo.pathUri)
                                                .size(Size(thumbnailResolution, thumbnailResolution))
                                                .allowHardware(true)
                                                .allowRgb565(true)
                                                .memoryCachePolicy(coil.request.CachePolicy.ENABLED)
                                                .build()
                                            ImageLoaderModule.thumbnailImageLoader.enqueue(standardRequest)
                                        }
                                    }
                                    else -> {}
                                }
                            }
                        }
                    } catch (e: Exception) {
                        Log.e(TAG, "Prefetch error", e)
                    }
                }
            }
    }

    // Responsive grid configuration (3-6 columns, default 4)
    val columns = gridState.columnCount.coerceIn(3, 6)
    val horizontalSpacing = 12.dp
    val verticalSpacing = 12.dp

    // Sync scroll to last viewed photo (backup for re-entry or updates)
    LaunchedEffect(lastViewedPhotoId, layoutCache) {
        if (!lastViewedPhotoId.isNullOrEmpty() && layoutCache.totalPhotos > 0) {
            // Wait for layout to settle (in case of restoration race condition)
            kotlinx.coroutines.delay(100)
            
            val index = currentLayoutItems.indexOfFirst { 
                it is LocalGridItem.PhotoItem && it.photo.localId == lastViewedPhotoId 
            }
            Log.d(TAG, "Syncing scroll: id=$lastViewedPhotoId, foundIndex=$index")
            if (index != -1) {
                // Check visibility to avoid jumping to top if already visible (e.g. from back nav)
                val visibleItems = lazyGridState.layoutInfo.visibleItemsInfo
                val isVisible = visibleItems.any { it.index == index }
                Log.d(TAG, "Item visibility: isVisible=$isVisible")
                
                if (!isVisible) {
                     Log.d(TAG, "Scrolling to item $index")
                     lazyGridState.scrollToItem(index)
                } else {
                     Log.d(TAG, "Item $index already visible, skipping scroll")
                }
                
                // Do NOT consume the ID immediately. Keep it so if the grid recomposes (e.g. back nav),
                // it initializes at the correct index.
                // onLastViewedPhotoConsumed()
            } else {
                Log.d(TAG, "Photo ID $lastViewedPhotoId not found in grid items")
            }
        } else {
            Log.d(TAG, "Skipping sync: lastViewed=$lastViewedPhotoId, totalPhotos=${layoutCache.totalPhotos}")
        }
    }
    val maxLineSpan = columns

    fun getDateLabel(localId: String): String? {
        val photo = allPhotos.find { it.localId == localId } ?: return null
        return java.text.SimpleDateFormat("EEE d - LLLL yyyy", java.util.Locale.getDefault()).format(java.util.Date(photo.displayDateMillis))
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // Only show loading if we don't have cached photos
        if (localPhotos.loadState.refresh == LoadState.Loading && allPhotos.isEmpty()) {
            LoadAnimation(modifier = Modifier.align(Alignment.Center))
        } else if (allPhotos.isEmpty()) {
            ExpressiveEmptyState(
                icon = Icons.Rounded.PhoneAndroid,
                title = "No photos on device",
                description = "Grant storage permission or capture some memories to see them appear here.",
                actionText = "Grant Permission",
                onActionClick = {
                    // Navigate to settings or trigger permission dialog
                }
            )
        } else {
            Box(modifier = Modifier.fillMaxSize()) {

                // Calculate effective total rows for accurate scrollbar mapping
                val effectiveTotalRows = remember(currentLayoutItems, columns, isDateGroupedLayout) {
                    if (isDateGroupedLayout) {
                        var rows = 0
                        currentLayoutItems.forEach { item ->
                            if (item is LocalGridItem.HeaderItem) rows++
                        }
                        val photos = currentLayoutItems.count { it is LocalGridItem.PhotoItem }
                        rows + kotlin.math.ceil(photos.toFloat() / columns).toInt()
                    } else {
                        kotlin.math.ceil(currentLayoutItems.size.toFloat() / columns).toInt()
                    }
                }

                ExpressiveScrollbar(
                    lazyGridState = lazyGridState,
                    totalItemsCount = effectiveTotalRows * columns,
                    columnCount = columns,
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
                    },
                    modifier = Modifier.align(Alignment.CenterEnd)
                )
                // the grid (unchanged except keep the same lazyGridState variable)
                DragSelectableLazyVerticalGrid(
                    lazyGridState = lazyGridState,
                    selectionEnabled = selectionMode,
                    glideSelectionBehavior = glideSelectionBehavior,
                    onItemSelectionChange = { key, isSelected ->
                        if (key is String && key.startsWith("photo_")) {
                            val parts = key.split("_", limit = 3)
                            if (parts.size == 3) {
                                val photoId = parts[2]
                                val newSelectedPhotos = if (isSelected) {
                                    selectedPhotos + photoId
                                } else {
                                    selectedPhotos - photoId
                                }
                                if (newSelectedPhotos != selectedPhotos) {
                                    onSelectedPhotosChange(newSelectedPhotos)
                                }
                                if (!selectionMode && isSelected) {
                                    onSelectionModeChange(true)
                                }
                            }
                        }
                    },
                    isItemSelected = { key ->
                        if (key is String && key.startsWith("photo_")) {
                            val parts = key.split("_", limit = 3)
                            if (parts.size == 3) {
                                selectedPhotos.contains(parts[2])
                            } else false
                        } else false
                    },
                    onDragSelectionEnd = {
                        // This callback is triggered when drag selection ends.
                        // If no photos are selected after a drag, we might want to exit selection mode.
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
                    contentPadding = PaddingValues(
                        start = 16.dp,
                        top = 8.dp,
                        end = 16.dp,
                        bottom = 96.dp
                    ),
                    verticalArrangement = Arrangement.spacedBy(verticalSpacing),
                    horizontalArrangement = Arrangement.spacedBy(horizontalSpacing),
                    content = {
                        // Unified layout rendering
                        items(
                            count = currentLayoutItems.size,
                            key = { index ->
                                when (val item = currentLayoutItems[index]) {
                                    is LocalGridItem.HeaderItem -> item.id
                                    is LocalGridItem.PhotoItem -> "photo_${item.originalIndex}_${item.photo.localId}"
                                }
                            },
                            span = { index ->
                                when (currentLayoutItems[index]) {
                                    is LocalGridItem.HeaderItem -> GridItemSpan(maxLineSpan)
                                    is LocalGridItem.PhotoItem -> GridItemSpan(1)
                                }
                            }
                        ) { index ->
                            when (val item = currentLayoutItems[index]) {
                                is LocalGridItem.HeaderItem -> {
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
                                is LocalGridItem.PhotoItem -> {
                                    val p = item.photo
                                    val isSelected = selectedPhotos.contains(p.localId)
                                    val isDeleted = deletedPhotoIds.contains(p.localId)
                                    LocalPhotoItem(
                                        photo = p,
                                        index = item.originalIndex,
                                        isSelected = isSelected,
                                        isDeleted = isDeleted,
                                        isScrollbarDragging = isScrollbarDragging,
                                        thumbnailResolution = thumbnailResolution,
                                        sharedTransitionScope = sharedTransitionScope,
                                        animatedVisibilityScope = animatedVisibilityScope,
                                        modifier = Modifier.clickable(
                                            onClick = {
                                                if (selectionMode) {
                                                    toggleSelection(p.localId)
                                                } else {
                                                    // Save exact scroll state before navigating
                                                    onSaveScrollState(
                                                        p.localId, 
                                                        lazyGridState.firstVisibleItemIndex, 
                                                        lazyGridState.firstVisibleItemScrollOffset
                                                    )
                                                    navController.navigate("photo_viewer/${p.localId}/false")
                                                }
                                            }
                                        )
                                    )
                                }
                            }
                        }
                    }
                )
            }
        }
    }
}

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun LocalPhotoItem(
    photo: LocalUiPhoto,
    index: Int,
    isSelected: Boolean,
    isDeleted: Boolean,
    isScrollbarDragging: Boolean = false,
    thumbnailResolution: Int = 150,
    sharedTransitionScope: SharedTransitionScope,
    animatedVisibilityScope: AnimatedVisibilityScope,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    
    // Optimize: logic is simple enough to not need derivedStateOf for a boolean parameter
    val shouldAnimate = !isScrollbarDragging
    
    // Entrance animation state - only initialized when animations are enabled
    var isVisible by remember { mutableStateOf(!shouldAnimate) }
    
    // Only run visibility animation when NOT dragging
    if (shouldAnimate) {
        LaunchedEffect(Unit) {
            isVisible = true
        }
    }

    val entryScale by animateFloatAsState(
        targetValue = if (isVisible) 1f else 0.85f,
        animationSpec = if (shouldAnimate) spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        ) else snap(),
        label = "entry_scale"
    )

    val entryAlpha by animateFloatAsState(
        targetValue = if (isVisible) 1f else 0f,
        animationSpec = if (shouldAnimate) tween(
            durationMillis = 400,
            delayMillis = (index % 12) * 40,
            easing = LinearOutSlowInEasing
        ) else snap(),
        label = "entry_alpha"
    )

    val itemTranslationY by animateFloatAsState(
        targetValue = if (isVisible) 0f else 40f,
        animationSpec = if (shouldAnimate) spring(
            dampingRatio = Spring.DampingRatioNoBouncy,
            stiffness = Spring.StiffnessLow
        ) else snap(),
        label = "entry_translation"
    )

    val scale by animateFloatAsState(
        targetValue = if (isDeleted) 0.8f else 1f,
        animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy),
        label = "item_scale"
    )

    with(sharedTransitionScope) {
        Box(
            modifier = modifier
                .sharedElement(
                    rememberSharedContentState(key = "photo_${photo.localId}"),
                    animatedVisibilityScope = animatedVisibilityScope,
                    boundsTransform = { _, _ -> com.akslabs.cloudgallery.ui.theme.AnimationConstants.PremiumBoundsSpring }
                )
                .aspectRatio(1f)
                .then(
                    if (isSelected) Modifier.border(
                        6.dp, 
                        MaterialTheme.colorScheme.primary, 
                        RoundedCornerShape(20.dp)
                    ) else Modifier
                ),
            contentAlignment = Alignment.Center
        ) {
            // 1. Static Placeholder - ALWAYS VISIBLE (No animation)
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(20.dp))
                    .background(MaterialTheme.colorScheme.surfaceVariant)
            )

            // 1.5 Micro-Thumbnail Layer (Low Quality, Immediate)
            AsyncImage(
                model = ImageRequest.Builder(context)
                    .data(photo.pathUri)
                    .size(64, 64) // Explicit low res
                    .memoryCachePolicy(coil.request.CachePolicy.ENABLED)
                    .crossfade(false)
                    .allowHardware(true)
                    .allowRgb565(true)
                    .build(),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                imageLoader = ImageLoaderModule.thumbnailImageLoader,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(20.dp))
                    .alpha(0.7f) // Slightly transparent blending
            )

            // 2. Animated Content Container
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .then(
                        if (shouldAnimate) {
                            Modifier.graphicsLayer {
                                scaleX = scale * entryScale
                                scaleY = scale * entryScale
                                alpha = entryAlpha
                                // translationY removed to keep it aligned with placeholder
                            }
                        } else {
                            Modifier.graphicsLayer {
                                scaleX = scale
                                scaleY = scale
                                alpha = 1f
                            }
                        }
                    )
                    .then(if (isSelected) Modifier.padding(6.dp) else Modifier)
                    .clip(RoundedCornerShape(if (isSelected) 14.dp else 20.dp))
            ) {
                // Optimized loading: using AsyncImage instead of SubcomposeAsyncImage to avoid subcomposition
                val targetSize = if (isScrollbarDragging) 64 else thumbnailResolution

                AsyncImage(
                    model = ImageRequest.Builder(context)
                        .data(photo.pathUri)
                        .size(Size(targetSize, targetSize))
                        .allowHardware(true)
                        .allowRgb565(true)
                        .memoryCachePolicy(coil.request.CachePolicy.ENABLED)
                        .diskCachePolicy(coil.request.CachePolicy.ENABLED)
                        .build(),
                    contentDescription = stringResource(R.string.photo),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize(),
                    placeholder = null, // Avoiding subcomposition
                    error = null // Avoiding subcomposition
                )
            }

            // Selection Tonal Overlay
            if (isSelected) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.15f))
                )
            }

            // Selection Checkmark (Improved)
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
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onPrimary,
                        modifier = Modifier.size(18.dp)
                    )
                }
            }
        }

        // Cloud Icon (if backed up)
        // Note: Local Photo usually doesn't have remoteId directly, but we check if it's synced
        // For now, if we want to show it, we need to pass a property or look it up.
        // Assuming we might have a way to know if it's backed up.
        // I'll comment this out or use a dummy check for now to fix the build error.
        /*
        if (photo.remoteId != null) {
            Box(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(10.dp)
                    .background(MaterialTheme.colorScheme.surfaceContainer.copy(alpha = 0.8f), CircleShape)
                    .size(24.dp),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Rounded.CloudDone,
                    contentDescription = "Backed up",
                    tint = Color(0xFF4CAF50),
                    modifier = Modifier.size(14.dp)
                )
            }
        }
        */
    }
}

