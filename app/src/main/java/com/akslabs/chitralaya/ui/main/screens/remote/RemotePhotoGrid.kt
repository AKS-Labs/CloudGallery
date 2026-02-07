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
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.FloatingToolbarDefaults.floatingToolbarVerticalNestedScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
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
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest
import coil.size.Size
import com.akslabs.chitralaya.ui.components.DragSelectableLazyVerticalGrid
import com.akslabs.chitralaya.ui.components.ExpressiveScrollbar
import com.akslabs.cloudgallery.R
import com.akslabs.cloudgallery.data.localdb.entities.RemotePhoto
import com.akslabs.cloudgallery.ui.components.LoadAnimation
import com.akslabs.cloudgallery.ui.components.PhotoPageView
import com.akslabs.cloudgallery.ui.main.rememberGridState
import com.akslabs.cloudgallery.utils.coil.ImageLoaderModule
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.akslabs.cloudgallery.data.localdb.Preferences

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

    return RemoteLayoutCache(
        normalGridItems = normalGridItems,
        dateGroupedItems = dateGroupedItems,
        totalPhotos = cloudPhotos.itemCount,
        lastUpdateTime = System.currentTimeMillis()
    )
}

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
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
) {
    Log.e(TAG, "🎯 === REMOTE PHOTO GRID COMPOSING ===")
    val context = LocalContext.current
    val activity = context.findActivity()
    val window = activity?.window
    var selectedIndex by remember { mutableStateOf<Int?>(null) }
    var selectedPhoto by remember { mutableStateOf<RemotePhoto?>(null) }

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

    // Preserve scroll
    val lazyGridState = rememberLazyGridState()
    // Responsive grid configuration (3-6 columns, default 4)
    val gridState = rememberGridState()
    val columns = gridState.columnCount.coerceIn(3, 6)
    val horizontalSpacing = 12.dp
    val verticalSpacing = 12.dp

    // Layout mode configuration
    val isDateGroupedLayout = gridState.isDateGroupedLayout

    // Create layout cache
    val layoutCache = remember(cloudPhotos.itemCount, isDateGroupedLayout) {
        createRemoteLayoutCache(cloudPhotos)
    }

    val currentLayoutItems = if (isDateGroupedLayout) layoutCache.dateGroupedItems else layoutCache.normalGridItems
    val maxLineSpan = columns

    Box(modifier = Modifier.fillMaxSize()) {
        if (cloudPhotos.loadState.refresh == LoadState.Loading) {
            LoadAnimation(modifier = Modifier.align(Alignment.Center))
        } else if (cloudPhotos.itemCount == 0 && cloudPhotos.loadState.refresh is LoadState.NotLoading) {
             // Empty state
            Column(
                modifier = Modifier.align(Alignment.Center),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    imageVector = Icons.Rounded.Cloud,
                    contentDescription = "No cloud photos",
                    tint = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.size(48.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Sync images to view here",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        } else {
            // Calculate effective total items for scrollbar (accounting for headers)
            val effectiveTotalItems = remember(layoutCache, columns) {
                if (isDateGroupedLayout) {
                    val headers = layoutCache.dateGroupedItems.count { it is RemoteGridItem.HeaderItem }
                    val photos = layoutCache.dateGroupedItems.count { it is RemoteGridItem.PhotoItem }
                    val totalRows = headers + kotlin.math.ceil(photos.toFloat() / columns).toInt()
                    totalRows * columns
                } else {
                    layoutCache.normalGridItems.size
                }
            }

            ExpressiveScrollbar(
                lazyGridState = lazyGridState,
                totalItemsCount = effectiveTotalItems,
                columnCount = columns,
                modifier = Modifier.align(Alignment.CenterEnd),
                onDraggingChange = { isDragging -> isScrollbarDragging = isDragging }
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
                                modifier = Modifier.clickable(
                                    onClick = {
                                        if (selectionMode) {
                                            toggleSelection(item.photo.remoteId)
                                        } else {
                                            onPhotoClick(item.originalIndex, item.photo)
                                            selectedIndex = item.originalIndex
                                            selectedPhoto = item.photo
                                        }
                                    }
                                )
                            )
                        }
                    }
                }
            }
        }

        // Photo viewer overlay
        selectedIndex?.let { index ->
            // Build photo list from loaded items only
            val loadedPhotos = mutableListOf<com.akslabs.cloudgallery.data.localdb.entities.Photo>()
            var targetIndex = 0

            // Collect all loaded photos and find the target index
            for (i in 0 until cloudPhotos.itemCount) {
                val photo = cloudPhotos.peek(i) // Use peek to get already loaded items
                if (photo != null) {
                    if (i == index) {
                        targetIndex = loadedPhotos.size // Current position in loaded list
                    }
                    loadedPhotos.add(photo.toPhoto())
                }
            }

            if (loadedPhotos.isNotEmpty()) {
                // Ensure target index is within bounds
                val safeIndex = targetIndex.coerceIn(0, loadedPhotos.size - 1)

                if (window != null) {
                    PhotoPageView(
                        initialPage = safeIndex,
                        onlyRemotePhotos = true,
                        photos = loadedPhotos,
                        window = window
                    ) {
                        selectedIndex = null
                        selectedPhoto = null
                    }
                }
            }
        }
    }
}

@Composable
fun CloudPhotoItem(
    remotePhoto: RemotePhoto?,
    index: Int,
    isSelected: Boolean,
    isScrollbarDragging: Boolean = false,
    thumbnailResolution: Int = 150,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current

    Box(
        modifier = modifier
            .aspectRatio(1f)
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
        Box(
            modifier = Modifier
                .fillMaxSize()
                .then(if (isSelected) Modifier.padding(6.dp) else Modifier)
                .clip(RoundedCornerShape(if (isSelected) 10.dp else 16.dp))
        ) {
            if (remotePhoto != null) {
                val targetSize = if (isScrollbarDragging) 50 else thumbnailResolution
                
                val imageRequestBuilder = ImageRequest.Builder(context)
                    .data(remotePhoto)
                    .size(Size(targetSize, targetSize))
                    .memoryCacheKey("grid_thumb_${remotePhoto.remoteId}")
                    .diskCacheKey("grid_thumb_${remotePhoto.remoteId}")
                    .allowRgb565(true)
                
                if (!isScrollbarDragging) {
                    imageRequestBuilder.crossfade(100)
                }
                
                val imageRequest = imageRequestBuilder.build()

                SubcomposeAsyncImage(
                    imageLoader = ImageLoaderModule.thumbnailImageLoader,
                    model = imageRequest,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize(),
                    contentDescription = stringResource(id = R.string.photo),
                    loading = {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(MaterialTheme.colorScheme.surfaceContainerLow),
                            contentAlignment = Alignment.Center
                        ) {
                            LoadAnimation()
                        }
                    },
                    error = { error ->
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(MaterialTheme.colorScheme.surfaceContainerLow),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                tint = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.6f),
                                imageVector = Icons.Rounded.CloudOff,
                                contentDescription = null,
                                modifier = Modifier.size(24.dp)
                            )
                        }
                    }
                )

                // Selection Tonal Overlay
                if (isSelected) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
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

private const val TAG = "RemotePhotoGrid"

// Helper function to find the current activity from the context
private fun Context.findActivity(): Activity? {
    var context = this
    while (context is ContextWrapper) {
        if (context is Activity) return context
        context = context.baseContext
    }
    return null
}