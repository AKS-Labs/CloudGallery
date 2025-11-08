package com.akslabs.cloudgallery.ui.main.screens.remote

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.material3.FloatingToolbarDefaults.floatingToolbarVerticalNestedScroll

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.CloudOff
import androidx.compose.material.icons.rounded.Cloud
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
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
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest
import coil.size.Size
import com.akslabs.cloudgallery.R
import com.akslabs.cloudgallery.data.localdb.entities.RemotePhoto
import com.akslabs.cloudgallery.data.localdb.Preferences
import com.akslabs.cloudgallery.ui.components.LoadAnimation
import com.akslabs.cloudgallery.ui.components.PhotoPageView
import com.akslabs.cloudgallery.ui.components.itemsPaging
import com.akslabs.cloudgallery.ui.main.rememberGridState
import com.akslabs.cloudgallery.utils.coil.ImageLoaderModule

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

            if (processedCount % 100 == 0) {
                Log.d(TAG, "📊 Processed $processedCount remote photos so far...")
            }
        } else {
            skippedCount++
            Log.w(TAG, "⚠️ Skipped null remote photo at index $i")
        }
    }

    Log.d(TAG, "✅ Remote date grouping complete: $processedCount processed, $skippedCount skipped")
    Log.d(TAG, "📅 Created ${photosByDate.size} remote date groups")

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
    Log.d(TAG, "🚀 Creating remote layout cache for ${cloudPhotos.itemCount} photos")

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

    val endTime = System.currentTimeMillis()
    Log.d(TAG, "⚡ Remote layout cache created in ${endTime - startTime}ms")
    Log.d(TAG, "📊 Normal grid: ${normalGridItems.size} items, Date grouped: ${dateGroupedItems.size} items")

    return RemoteLayoutCache(
        normalGridItems = normalGridItems,
        dateGroupedItems = dateGroupedItems,
        totalPhotos = cloudPhotos.itemCount,
        lastUpdateTime = System.currentTimeMillis()
    )
}


@Composable
fun RemotePhotosGrid(
    cloudPhotos: LazyPagingItems<RemotePhoto>,
    onPhotoClick: (Int, RemotePhoto?) -> Unit,
    expanded: Boolean,
    onExpandedChange: (Boolean) -> Unit
)
 {
    Log.e(TAG, "🎯 === REMOTE PHOTO GRID COMPOSING ===")
    val context = LocalContext.current
    var selectedIndex by remember { mutableStateOf<Int?>(null) }
    var selectedPhoto by remember { mutableStateOf<RemotePhoto?>(null) }

    // Comprehensive debug logging for cloud photos data
    LaunchedEffect(cloudPhotos.loadState, cloudPhotos.itemCount) {
        Log.d(TAG, "=== REMOTE PHOTO GRID DEBUG ===")
//        Log.d(TAG, "Total count from ViewModel: $totalCount")
        Log.d(TAG, "CloudPhotos itemCount: ${cloudPhotos.itemCount}")
        Log.d(TAG, "LoadState.refresh: ${cloudPhotos.loadState.refresh}")
        Log.d(TAG, "LoadState.append: ${cloudPhotos.loadState.append}")
        Log.d(TAG, "LoadState.prepend: ${cloudPhotos.loadState.prepend}")

        // Check if refresh is loading
        if (cloudPhotos.loadState.refresh is LoadState.Loading) {
            Log.i(TAG, "REFRESH is currently LOADING")
        } else if (cloudPhotos.loadState.refresh is LoadState.Error) {
            Log.e(TAG, "REFRESH ERROR: ${(cloudPhotos.loadState.refresh as LoadState.Error).error}")
        } else {
            Log.i(TAG, "REFRESH completed successfully")
        }

        // Check append state for scrolling
        if (cloudPhotos.loadState.append is LoadState.Loading) {
            Log.i(TAG, "APPEND is currently LOADING (scrolling down)")
        } else if (cloudPhotos.loadState.append is LoadState.Error) {
            Log.e(TAG, "APPEND ERROR: ${(cloudPhotos.loadState.append as LoadState.Error).error}")
        }

        if (cloudPhotos.itemCount > 0) {
            Log.i(TAG, "Checking first 5 cloud photos with peek():")
            for (i in 0 until minOf(5, cloudPhotos.itemCount)) {
                val photo = cloudPhotos.peek(i)
                if (photo != null) {
                    Log.d(TAG, "Photo[$i] LOADED: remoteId=${photo.remoteId}, type=${photo.photoType}, fileName=${photo.fileName}")
                } else {
                    Log.w(TAG, "Photo[$i] NULL: not loaded yet or loading")
                }
            }

            // Also check snapshot list
            val snapshotItems = cloudPhotos.itemSnapshotList.items
            Log.i(TAG, "Snapshot list size: ${snapshotItems.size}")
            snapshotItems.take(3).forEachIndexed { index, item ->
                if (item != null) {
                    Log.d(TAG, "Snapshot[$index]: remoteId=${item.remoteId}")
                } else {
                    Log.w(TAG, "Snapshot[$index]: null")
                }
            }
        } else {
            Log.w(TAG, "CloudPhotos itemCount is 0!")
        }
        Log.d(TAG, "=== END REMOTE PHOTO GRID DEBUG ===")
    }

    Box(modifier = Modifier.fillMaxSize()) {
        // Unified cloud photos grid
        // Unified cloud photos grid
        CloudPhotosGrid(
            cloudPhotos = cloudPhotos,
            onPhotoClick = { index, photo ->
                selectedIndex = index
                selectedPhoto = photo
            },
            expanded = expanded,
            onExpandedChange = onExpandedChange
        )


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

                PhotoPageView(
                    initialPage = safeIndex,
                    onlyRemotePhotos = true,
                    photos = loadedPhotos
                ) {
                    selectedIndex = null
                    selectedPhoto = null
                }
            } else {
                selectedIndex = null
                selectedPhoto = null
            }
        }
    }
}

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun CloudPhotosGrid(
    cloudPhotos: LazyPagingItems<RemotePhoto>,
    onPhotoClick: (Int, RemotePhoto?) -> Unit,
    expanded: Boolean,
    onExpandedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier
)
 {
    val lazyGridState = rememberLazyGridState()

    // Responsive grid configuration (3-6 columns, default 4) - matches LocalPhotoGrid
    val gridState = rememberGridState()
    val columns = gridState.columnCount.coerceIn(3, 6)
    val horizontalSpacing = 12.dp
    val verticalSpacing = 12.dp

    // Layout mode configuration
    val isDateGroupedLayout = gridState.isDateGroupedLayout

    fun getDateLabel(uploadedAt: Long): String? {
        return try {
            java.text.SimpleDateFormat("EEE d - LLLL yyyy", java.util.Locale.getDefault()).format(java.util.Date(uploadedAt))
        } catch (e: Exception) {
            null
        }
    }

    // Optimized remote layout cache with instant switching
    val layoutCache = remember(cloudPhotos.itemSnapshotList.items.hashCode()) {
        createRemoteLayoutCache(cloudPhotos)
    }

    // Get current layout items instantly (no recomputation)
    val currentLayoutItems = remember(isDateGroupedLayout, layoutCache) {
        Log.d(TAG, "⚡ Switching to ${if (isDateGroupedLayout) "Date Grouped" else "Normal Grid"} remote layout")
        if (isDateGroupedLayout) {
            layoutCache.dateGroupedItems
        } else {
            layoutCache.normalGridItems
        }
    }

    Box(modifier = modifier.fillMaxSize()) {
        when {
            cloudPhotos.loadState.refresh == LoadState.Loading -> {
                LoadAnimation(modifier = Modifier.align(Alignment.Center))
            }
            cloudPhotos.itemCount == 0 && cloudPhotos.loadState.refresh is LoadState.NotLoading -> {
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
            }
            else -> {
                LazyVerticalGrid(
                    state = lazyGridState,
                    modifier = Modifier
                        .fillMaxSize()
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
                    Log.d(TAG, "=== OPTIMIZED REMOTE LAZY GRID ITEMS BLOCK ===")
                    Log.d(TAG, "Layout mode: ${if (isDateGroupedLayout) "Date Grouped" else "Normal Grid"}")
                    Log.d(TAG, "Rendering ${currentLayoutItems.size} items (Total photos in cache: ${layoutCache.totalPhotos})")

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
                                // Date header with smooth animation
                                androidx.compose.animation.AnimatedVisibility(
                                    visible = true,
                                    enter = androidx.compose.animation.fadeIn() + androidx.compose.animation.slideInVertically(),
                                    exit = androidx.compose.animation.fadeOut()
                                ) {
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
                            }
                            is RemoteGridItem.PhotoItem -> {
                                // Photo item with smooth animation
                                androidx.compose.animation.AnimatedVisibility(
                                    visible = true,
                                    enter = androidx.compose.animation.fadeIn() + androidx.compose.animation.scaleIn(),
                                    exit = androidx.compose.animation.fadeOut()
                                ) {
                                    CloudPhotoItem(
                                        remotePhoto = item.photo,
                                        index = item.originalIndex,
                                        onClick = {
                                            Log.d(TAG, "Photo clicked at index: ${item.originalIndex}, remoteId: ${item.photo.remoteId}")
                                            onPhotoClick(item.originalIndex, item.photo)
                                        }
                                    )
                                }
                            }
                        }
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
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current

    // Comprehensive debug logging for CloudPhotoItem
    LaunchedEffect(remotePhoto, index) {
        Log.d(TAG, "=== CLOUD PHOTO ITEM RENDER ===")
        Log.d(TAG, "Index: $index")
        if (remotePhoto != null) {
            Log.i(TAG, "Item[$index] RENDERING with data: remoteId=${remotePhoto.remoteId}, type=${remotePhoto.photoType}, fileName=${remotePhoto.fileName}")
        } else {
            Log.w(TAG, "Item[$index] RENDERING with NULL data - will show placeholder")
        }
    }

    Box(
        modifier = modifier
            .aspectRatio(1f)
            .clip(RoundedCornerShape(16.dp))
            .background(MaterialTheme.colorScheme.surfaceVariant)
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        if (remotePhoto != null) {
            Log.d(TAG, "Item[$index] Creating ImageRequest for remoteId=${remotePhoto.remoteId}")

            val imageRequest = ImageRequest.Builder(context)
                .data(remotePhoto)
                .size(Size(15, 150)) // Even smaller for faster loading
                .memoryCacheKey("grid_thumb_${remotePhoto.remoteId}")
                .diskCacheKey("grid_thumb_${remotePhoto.remoteId}")
                .crossfade(100) // Faster transition
                .allowHardware(true) // Use hardware acceleration
                .allowRgb565(true) // Use less memory
                .listener(
                    onStart = {
                        Log.i(TAG, "Item[$index] Image loading STARTED for remoteId=${remotePhoto.remoteId}")
                    },
                    onSuccess = { _, result ->
                        Log.i(TAG, "Item[$index] Image loading SUCCESS for remoteId=${remotePhoto.remoteId}, dataSource=${result.dataSource}")
                    },
                    onError = { _, error ->
                        Log.e(TAG, "Item[$index] Image loading ERROR for remoteId=${remotePhoto.remoteId}: ${error.throwable?.message}")
                    }
                )
                .build()

            Log.d(TAG, "Item[$index] ImageRequest created, starting SubcomposeAsyncImage")

            SubcomposeAsyncImage(
                imageLoader = ImageLoaderModule.thumbnailImageLoader,
                model = imageRequest,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize(),
                contentDescription = stringResource(id = R.string.photo),
                loading = {
                    // Use the same loading animation as full-screen image loader
                    LoadAnimation()
                },
                error = { error ->
                    Log.e(TAG, "Item[$index] Showing ERROR state for remoteId=${remotePhoto.remoteId}: ${error.result.throwable?.message}")
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(MaterialTheme.colorScheme.surfaceVariant),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            tint = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.6f),
                            imageVector = Icons.Rounded.CloudOff,
                            contentDescription = null,
                            modifier = Modifier.size(16.dp)
                        )
                    }
                }
            )
        } else {
            Log.w(TAG, "Item[$index] Showing PLACEHOLDER - remotePhoto is null")
            // Simplified placeholder for null items during loading - just background color
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.surfaceVariant)
            )
        }
    }
}

private const val TAG = "RemotePhotoGrid"