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
import androidx.compose.material.icons.rounded.Image
import androidx.compose.material3.*
import androidx.navigation.NavController
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import coil.compose.AsyncImage
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
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.debounce
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
import coil.request.ImageRequest
import coil.size.Size
import coil.size.Precision
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
import kotlinx.coroutines.yield

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
    val idToNormalIndex: Map<String, Int>,
    val idToDateGroupedIndex: Map<String, Int>,
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
    
    val deletedSet = deletedPhotoIds.toSet()
    allPhotos.forEachIndexed { index, photo ->
        if (!deletedSet.contains(photo.localId)) {
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

    val deletedSet = deletedPhotoIds.toSet()
    // Create normal grid items
    val normalGridItems = allPhotos.mapIndexedNotNull { index, photo ->
        if (deletedSet.contains(photo.localId)) null else LocalGridItem.PhotoItem(photo, index)
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

    val idToNormalIndex = mutableMapOf<String, Int>()
    normalGridItems.forEachIndexed { index, item ->
        idToNormalIndex[item.photo.localId] = index
    }

    val idToDateGroupedIndex = mutableMapOf<String, Int>()
    dateGroupedItems.forEachIndexed { index, item ->
        if (item is LocalGridItem.PhotoItem) idToDateGroupedIndex[item.photo.localId] = index
    }

    return LayoutCache(
        normalGridItems = normalGridItems,
        dateGroupedItems = dateGroupedItems,
        idToNormalIndex = idToNormalIndex,
        idToDateGroupedIndex = idToDateGroupedIndex,
        totalPhotos = allPhotos.size,
        lastUpdateTime = System.currentTimeMillis()
    )
}

@OptIn(ExperimentalAnimationApi::class, ExperimentalSharedTransitionApi::class, ExperimentalMaterial3ExpressiveApi::class, ExperimentalFoundationApi::class, kotlinx.coroutines.FlowPreview::class)
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
    
    // Responsive grid configuration (3-6 columns, default 4)
    val columns = gridState.columnCount.coerceIn(3, 6)
    
    // Create layout cache off-thread to prevent UI jank
    var layoutCache by remember { 
        mutableStateOf(LayoutCache(emptyList(), emptyList(), emptyMap(), emptyMap(), 0, 0L)) 
    }

    LaunchedEffect(allPhotos, isDateGroupedLayout, deletedPhotoIds.toList()) {
        withContext(Dispatchers.Default) {
            val newCache = createLayoutCache(allPhotos, deletedPhotoIds)
            withContext(Dispatchers.Main) {
                layoutCache = newCache
            }
        }
    }

    // Move heavy list processing and indexing to background thread
    var headerIndices by remember { mutableStateOf<List<Pair<Int, String>>>(emptyList()) }
    var effectiveTotalRows by remember { mutableStateOf(0) }

    val currentLayoutItems: List<LocalGridItem> = remember(layoutCache, isDateGroupedLayout) {
        if (isDateGroupedLayout) layoutCache.dateGroupedItems else layoutCache.normalGridItems
    }

    LaunchedEffect(currentLayoutItems, columns, isDateGroupedLayout) {
        withContext(Dispatchers.Default) {
            val indices = currentLayoutItems.mapIndexedNotNull { index: Int, item: LocalGridItem ->
                if (item is LocalGridItem.HeaderItem) Pair(index, item.dateLabel) else null
            }

            val totalRows = if (isDateGroupedLayout) {
                var headerCount = 0
                currentLayoutItems.forEach { if (it is LocalGridItem.HeaderItem) headerCount++ }
                val photosCount = currentLayoutItems.count { it is LocalGridItem.PhotoItem }
                headerCount + kotlin.math.ceil(photosCount.toFloat() / columns).toInt()
            } else {
                kotlin.math.ceil(currentLayoutItems.size.toFloat() / columns).toInt()
            }

            withContext(Dispatchers.Main) {
                headerIndices = indices
                effectiveTotalRows = totalRows
            }
        }
    }


    // Initialize scroll state with EXACT position if returning to the same photo
    val (initialIndex, initialOffset) = remember(lastViewedPhotoId, layoutCache, clickedPhotoId, savedIndex, savedOffset) {
        if (!lastViewedPhotoId.isNullOrEmpty() && layoutCache.totalPhotos > 0) {
            if (lastViewedPhotoId == clickedPhotoId) {
                // Return to EXACTLY where we left off
                Log.d(TAG, "Restoring EXACT state: index=$savedIndex, offset=$savedOffset")
                savedIndex to savedOffset
            } else {
                // User swiped to a new photo, find it and scroll to top
                val indexMap = if (isDateGroupedLayout) layoutCache.idToDateGroupedIndex else layoutCache.idToNormalIndex
                val index = indexMap[lastViewedPhotoId] ?: -1
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

    // Calculate Scroll Velocity for Adaptive Loading
    var scrollVelocity by remember { mutableStateOf(0f) }
    LaunchedEffect(lazyGridState) {
        var lastOffset = lazyGridState.firstVisibleItemScrollOffset
        var lastIndex = lazyGridState.firstVisibleItemIndex
        var lastTime = System.currentTimeMillis()
        
        snapshotFlow { 
            Triple(lazyGridState.firstVisibleItemScrollOffset, lazyGridState.firstVisibleItemIndex, lazyGridState.isScrollInProgress) 
        }
        .collect { (offset, index, isScrolling) ->
            if (!isScrolling) {
                scrollVelocity = 0f
                lastOffset = offset
                lastIndex = index
                lastTime = System.currentTimeMillis()
                return@collect
            }
            
            val currentTime = System.currentTimeMillis()
            val deltaT = (currentTime - lastTime).coerceAtLeast(1)
            // Approximate pixels traveled (item height is roughly 150dp -> 450px)
            val deltaX = (index - lastIndex) * 450 + (offset - lastOffset)
            scrollVelocity = kotlin.math.abs(deltaX.toFloat() / deltaT * 1000f)
            
            lastOffset = offset
            lastIndex = index
            lastTime = currentTime
        }
    }
    val isScrollingFast = scrollVelocity > 2500f // px per second


    // Intelligent Directional Prefetching (V3)
    var lastPrefetchRange by remember { mutableStateOf(0..0) }
    var prevFirstVisible by remember { mutableStateOf(-1) }
    var prevLastVisible by remember { mutableStateOf(-1) }
    
    // session prefetched IDs to avoid redundant enqueuing
    val enqueuedPrefetchIds = remember { mutableSetOf<String>() }
    
    LaunchedEffect(currentLayoutItems, isScrollbarDragging) {
        val prefetchDebounce = if (isScrollbarDragging) 50L else 100L
        
        snapshotFlow { 
            val layoutInfo = lazyGridState.layoutInfo
            val visibleItems = layoutInfo.visibleItemsInfo
            if (visibleItems.isEmpty()) null
            else {
                val first = visibleItems.first().index
                val last = visibleItems.last().index
                Triple(first, last, layoutInfo.totalItemsCount)
            }
        }
        .distinctUntilChanged()
        .debounce(prefetchDebounce)
        .collectLatest { info ->
            if (info == null || layoutCache.totalPhotos == 0) return@collectLatest
            val (firstVisible, lastVisible, totalItems) = info

            // Robust Direction Detection: Compare both first and last index shifts
            val firstShift = firstVisible - prevFirstVisible
            val lastShift = lastVisible - prevLastVisible
            
            // If we don't have previous state, assume down (1)
            val direction = if (prevFirstVisible == -1) 1 else {
                if (firstShift > 0 || lastShift > 0) 1 else if (firstShift < 0 || lastShift < 0) -1 else 0
            }
            
            prevFirstVisible = firstVisible
            prevLastVisible = lastVisible
            
            if (direction == 0) return@collectLatest

            withContext(Dispatchers.IO) {
                try {
                    // Prefetch ahead based on direction
                    val range = if (direction > 0) {
                        (lastVisible + 1)..(lastVisible + 100).coerceAtMost(totalItems - 1)
                    } else {
                        (firstVisible - 100).coerceAtLeast(0)..(firstVisible - 1)
                    }

                    if (range.isEmpty() || range == lastPrefetchRange) return@withContext
                    lastPrefetchRange = range

                    range.forEach { index ->
                        if (index in currentLayoutItems.indices) {
                            yield()
                            val item = currentLayoutItems[index]
                            if (item is LocalGridItem.PhotoItem) {
                                val photoId = item.photo.localId
                                
                                // 1. Micro-Thumbnail (64x64)
                                if (!enqueuedPrefetchIds.contains("micro_$photoId")) {
                                    val microRequest = ImageRequest.Builder(context)
                                        .data(item.photo.pathUri)
                                        .size(64, 64)
                                        .memoryCacheKey("micro_$photoId")
                                        .diskCacheKey("micro_$photoId")
                                        .precision(coil.size.Precision.INEXACT)
                                        .allowHardware(true)
                                        .bitmapConfig(android.graphics.Bitmap.Config.RGB_565)
                                        .build()
                                    ImageLoaderModule.thumbnailImageLoader.enqueue(microRequest)
                                    enqueuedPrefetchIds.add("micro_$photoId")
                                }

                                // 2. Standard Thumbnail (User Resolution) - Immediate buffer
                                val distance = if (direction > 0) index - lastVisible else firstVisible - index
                                if (distance <= 10 && !enqueuedPrefetchIds.contains("thumb_$photoId")) {
                                    val thumbRequest = ImageRequest.Builder(context)
                                        .data(item.photo.pathUri)
                                        .size(thumbnailResolution, thumbnailResolution)
                                        .memoryCacheKey("lt_thumb_$photoId")
                                        .diskCacheKey("lt_thumb_$photoId")
                                        .allowHardware(true)
                                        .bitmapConfig(android.graphics.Bitmap.Config.RGB_565)
                                        .build()
                                    ImageLoaderModule.thumbnailImageLoader.enqueue(thumbRequest)
                                    enqueuedPrefetchIds.add("thumb_$photoId")
                                }
                            }
                        }
                    }
                    
                    // Periodically prune the set if it gets too large
                    if (enqueuedPrefetchIds.size > 1000) {
                        enqueuedPrefetchIds.clear()
                    }
                } catch (e: Exception) {
                    if (BuildConfig.DEBUG) Log.e(TAG, "Prefetch error", e)
                }
            }
        }
    }

    val horizontalSpacing = 12.dp
    val verticalSpacing = 12.dp

    // Sync scroll to last viewed photo (backup for re-entry or updates)
    LaunchedEffect(lastViewedPhotoId, layoutCache) {
        if (!lastViewedPhotoId.isNullOrEmpty() && layoutCache.totalPhotos > 0) {
            // Wait for layout to settle (in case of restoration race condition)
            kotlinx.coroutines.delay(100)
            
            val index = if (expanded) {
                layoutCache.idToDateGroupedIndex[lastViewedPhotoId] ?: -1
            } else {
                layoutCache.idToNormalIndex[lastViewedPhotoId] ?: -1
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

                ExpressiveScrollbar(
                    lazyGridState = lazyGridState,
                    totalRows = effectiveTotalRows,
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
                        top = 0.dp,
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
                                        isScrollingFast = isScrollingFast,
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
    isScrollingFast: Boolean = false,
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

    val deletionScale by animateFloatAsState(
        targetValue = if (isDeleted) 0.8f else 1f,
        animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy),
        label = "deletion_scale"
    )

    with(sharedTransitionScope) {
        Box(
            modifier = modifier
                .then(
                    if (!isScrollbarDragging) {
                        Modifier.sharedElement(
                            rememberSharedContentState(key = "photo_${photo.localId}"),
                            animatedVisibilityScope = animatedVisibilityScope,
                            boundsTransform = { _, _ -> com.akslabs.cloudgallery.ui.theme.AnimationConstants.PremiumBoundsSpring }
                        )
                    } else Modifier
                )
                .aspectRatio(1f)
                .graphicsLayer {
                    val entrance = if (skipEntrance) 1f else animatedValues
                    // Removed alpha = entrance to keep placeholder visible
                    scaleX = deletionScale * (0.92f + 0.08f * entrance)
                    scaleY = deletionScale * (0.92f + 0.08f * entrance)
                    translationY = (1f - entrance) * 15f
                }
                .clip(RoundedCornerShape(16.dp))
                .background(MaterialTheme.colorScheme.surfaceVariant)
                .then(
                    if (isSelected) Modifier.border(
                        6.dp, 
                        MaterialTheme.colorScheme.primary, 
                        RoundedCornerShape(16.dp)
                    ) else Modifier
                ),
            contentAlignment = Alignment.Center
        ) {
            // Placeholder background only (Icons removed per user request)
            
            // Adaptive Loading: Only upgrade to High-Res when scrolling slowed down
            val loadHighRes = !isScrollingFast
            
            // Tier 1: Micro-Thumbnail (Decoupled lifecycle to ensure it stays in memory as a base layer)
            val microRequest = remember(photo.localId) {
                ImageRequest.Builder(context)
                    .data(photo.pathUri)
                    .size(64, 64)
                    .memoryCacheKey("micro_${photo.localId}")
                    .diskCacheKey("micro_${photo.localId}")
                    .precision(Precision.INEXACT)
                    .allowHardware(true)
                    .bitmapConfig(android.graphics.Bitmap.Config.RGB_565)
                    .build()
            }

            // Tier 2: Standard Thumbnail (Uses Micro as a persistent placeholder)
            val imageRequest = remember(photo.localId, loadHighRes, thumbnailResolution) {
                ImageRequest.Builder(context)
                    .data(photo.pathUri)
                    .size(thumbnailResolution, thumbnailResolution) 
                    .memoryCacheKey("lt_thumb_${photo.localId}")
                    .diskCacheKey("lt_thumb_${photo.localId}")
                    .allowHardware(true)
                    .bitmapConfig(android.graphics.Bitmap.Config.RGB_565)
                    // If we're scrolling fast, ONLY return the micro-version immediately
                    .apply { 
                        if (!loadHighRes) {
                            size(64, 64)
                            memoryCacheKey("micro_${photo.localId}")
                        } else {
                            crossfade(if (skipEntrance) 0 else 200)
                            placeholderMemoryCacheKey("micro_${photo.localId}")
                        }
                    }
                    .build()
            }
            
            AsyncImage(
                model = imageRequest,
                contentDescription = stringResource(R.string.photo),
                contentScale = ContentScale.Crop,
                imageLoader = ImageLoaderModule.thumbnailImageLoader,
                modifier = Modifier
                    .fillMaxSize()
                    .graphicsLayer {
                        // Apply entrance alpha ONLY to the image
                        alpha = if (skipEntrance) 1f else animatedValues
                    }
            )

            if (isSelected) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(if (isSelected) 6.dp else 0.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.15f))
                )
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
        }
    }
}
