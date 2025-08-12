package com.akslabs.cloudgallery.ui.main.screens.local

import android.content.ContentUris
import android.provider.MediaStore
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.BrokenImage
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest
import coil.size.Size
import com.akslabs.cloudgallery.R
import com.akslabs.cloudgallery.data.localdb.entities.Photo
import com.akslabs.cloudgallery.data.localdb.Preferences
import com.akslabs.cloudgallery.ui.components.LoadAnimation
import com.akslabs.cloudgallery.ui.components.PhotoPageView
import com.akslabs.cloudgallery.ui.components.itemsPaging

// Sealed class for grid items to support date grouping
sealed class LocalGridItem {
    data class PhotoItem(val photo: Photo, val originalIndex: Int) : LocalGridItem()
    data class HeaderItem(val dateLabel: String, val id: String) : LocalGridItem()
}

// Data class for date groups
data class DateGroup(
    val dateLabel: String,
    val photos: List<Pair<Photo, Int>>, // Photo with original index
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
    localPhotos: LazyPagingItems<Photo>,
): List<DateGroup> {
    val photosByDate = mutableMapOf<String, MutableList<Pair<Photo, Int>>>()
    var processedCount = 0
    var skippedCount = 0

    Log.d(TAG, "🔍 Starting date grouping for ${localPhotos.itemCount} photos")

    // Process ALL photos - no filtering
    for (i in 0 until localPhotos.itemCount) {
        val photo = localPhotos.peek(i)
        if (photo != null) {
            val timestamp = safeTimestampFromLocalId(photo.localId)
            val dateLabel = formatPhotoDate(timestamp)

            photosByDate.getOrPut(dateLabel) { mutableListOf() }.add(photo to i)
            processedCount++

            if (processedCount % 100 == 0) {
                Log.d(TAG, "📊 Processed $processedCount photos so far...")
            }
        } else {
            skippedCount++
            Log.w(TAG, "⚠️ Skipped null photo at index $i")
        }
    }

    Log.d(TAG, "✅ Date grouping complete: $processedCount processed, $skippedCount skipped")
    Log.d(TAG, "📅 Created ${photosByDate.size} date groups")

    // Convert to sorted list of DateGroups (most recent first)
    return photosByDate.map { (dateLabel, photos) ->
        val sortKey = photos.maxOfOrNull { safeTimestampFromLocalId(it.first.localId) } ?: 0L
        DateGroup(
            dateLabel = dateLabel,
            photos = photos.sortedByDescending { safeTimestampFromLocalId(it.first.localId) },
            sortKey = sortKey
        )
    }.sortedByDescending { it.sortKey }
}

// Optimized function to create layout cache
private fun createLayoutCache(
    localPhotos: LazyPagingItems<Photo>,
): LayoutCache {
    val start = System.currentTimeMillis()
    val normalGridItems = buildList {
        for (i in 0 until localPhotos.itemCount) {
            val p = localPhotos.peek(i) ?: continue
            add(LocalGridItem.PhotoItem(p, i))
        }
    }
    val dateGroups = groupPhotosByDateOptimized(localPhotos)
    val dateGroupedItems = buildList {
        dateGroups.forEachIndexed { idx, group ->
            add(LocalGridItem.HeaderItem(group.dateLabel, "header_${idx}_${group.dateLabel}"))
            group.photos.forEach { (p, originalIndex) -> add(LocalGridItem.PhotoItem(p, originalIndex)) }
        }
    }
    Log.d(TAG, "Layout cache in ${System.currentTimeMillis() - start}ms; normal=${normalGridItems.size}, grouped=${dateGroupedItems.size}")
    return LayoutCache(normalGridItems, dateGroupedItems, localPhotos.itemCount, System.currentTimeMillis())
}

@Composable
fun LocalPhotoGrid(localPhotos: LazyPagingItems<Photo>, totalCount: Int) {
    Log.e(TAG, "🎯 === LOCAL PHOTO GRID COMPOSING ===")
    val context = LocalContext.current
    var selectedIndex by remember { mutableStateOf<Int?>(null) }
    var selectedPhoto by remember { mutableStateOf<Photo?>(null) }

    // Preserve scroll
    val gridState = rememberLazyGridState()
    // Responsive grid configuration (3-6 columns, default 4)
    val columns = remember { Preferences.getInt(Preferences.gridColumnCountKey, Preferences.defaultGridColumnCount).coerceIn(3, 6) }
    val horizontalSpacing = 12.dp
    val verticalSpacing = 12.dp

    // Layout mode configuration
    val isDateGroupedLayout = remember { Preferences.getBoolean("date_grouped_layout", false) }

    // Optimized layout cache with instant switching
    val layoutCache = remember(localPhotos.itemSnapshotList.items.hashCode()) {
        createLayoutCache(localPhotos)
    }

    // Get current layout items instantly (no recomputation)
    val currentLayoutItems = remember(isDateGroupedLayout, layoutCache) {
        Log.d(TAG, "⚡ Switching to ${if (isDateGroupedLayout) "Date Grouped" else "Normal Grid"} layout")
        if (isDateGroupedLayout) {
            layoutCache.dateGroupedItems
        } else {
            layoutCache.normalGridItems
        }
    }

    // Comprehensive debug logging for local photos data
    LaunchedEffect(localPhotos.loadState, totalCount, localPhotos.itemCount) {
        Log.d(TAG, "=== LOCAL PHOTO GRID DEBUG ===")
        Log.d(TAG, "Total count from ViewModel: $totalCount")
        Log.d(TAG, "LocalPhotos itemCount: ${localPhotos.itemCount}")
        Log.d(TAG, "LoadState.refresh: ${localPhotos.loadState.refresh}")
        Log.d(TAG, "LoadState.append: ${localPhotos.loadState.append}")
        Log.d(TAG, "LoadState.prepend: ${localPhotos.loadState.prepend}")

        // Check if refresh is loading
        if (localPhotos.loadState.refresh is LoadState.Loading) {
            Log.i(TAG, "REFRESH is currently LOADING")
        } else if (localPhotos.loadState.refresh is LoadState.Error) {
            Log.e(TAG, "REFRESH ERROR: ${(localPhotos.loadState.refresh as LoadState.Error).error}")
        } else {
            Log.i(TAG, "REFRESH completed successfully")
        }

        // Check append state for scrolling
        if (localPhotos.loadState.append is LoadState.Loading) {
            Log.i(TAG, "APPEND is currently LOADING (scrolling down)")
        } else if (localPhotos.loadState.append is LoadState.Error) {
            Log.e(TAG, "APPEND ERROR: ${(localPhotos.loadState.append as LoadState.Error).error}")
        }

        if (localPhotos.itemCount > 0) {
            Log.i(TAG, "Checking first 5 local photos with peek():")
            for (i in 0 until minOf(5, localPhotos.itemCount)) {
                val photo = localPhotos.peek(i)
                if (photo != null) {
                    Log.d(TAG, "Photo[$i] LOADED: localId=${photo.localId}, pathUri=${photo.pathUri}")
                } else {
                    Log.w(TAG, "Photo[$i] NULL: not loaded yet or loading")
                }
            }

            // Also check snapshot list
            val snapshotItems = localPhotos.itemSnapshotList.items
            Log.i(TAG, "Snapshot list size: ${snapshotItems.size}")
            snapshotItems.take(3).forEachIndexed { index, item ->
                if (item != null) {
                    Log.d(TAG, "Snapshot[$index]: localId=${item.localId}")
                } else {
                    Log.w(TAG, "Snapshot[$index]: null")
                }
            }
        } else {
            Log.w(TAG, "LocalPhotos itemCount is 0!")
        }
        Log.d(TAG, "=== END LOCAL PHOTO GRID DEBUG ===")
    }

    fun getDateLabel(localId: String): String? {
        val millis = runCatching {
            val idLong = localId.toLongOrNull() ?: return null
            val uri = ContentUris.withAppendedId(
                MediaStore.Images.Media.getContentUri(MediaStore.VOLUME_EXTERNAL), idLong
            )
            context.contentResolver.query(
                uri,
                arrayOf(MediaStore.Images.ImageColumns.DATE_MODIFIED),
                null,
                null,
                null
            )?.use { c -> if (c.moveToFirst()) (c.getLong(0) * 1000L) else null }
        }.getOrNull()
        millis ?: return null
        return java.text.SimpleDateFormat("EEE d - LLLL yyyy", java.util.Locale.getDefault()).format(java.util.Date(millis))
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        if (localPhotos.loadState.refresh == LoadState.Loading) {
            LoadAnimation(modifier = Modifier.align(Alignment.Center))
        } else {
            LazyVerticalGrid(
                state = gridState,
                modifier = Modifier.fillMaxSize(),
                columns = GridCells.Fixed(columns),
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                verticalArrangement = Arrangement.spacedBy(verticalSpacing),
                horizontalArrangement = Arrangement.spacedBy(horizontalSpacing)
            ) {
                Log.d(TAG, "=== OPTIMIZED LAZY GRID ITEMS BLOCK ===")
                Log.d(TAG, "Layout mode: ${if (isDateGroupedLayout) "Date Grouped" else "Normal Grid"}")
                Log.d(TAG, "Rendering ${currentLayoutItems.size} items (Total photos in cache: ${layoutCache.totalPhotos})")

                // Unified layout rendering with smooth transitions
                items(
                    count = currentLayoutItems.size,
                    key = { index ->
                        when (val item = currentLayoutItems[index]) {
                            is LocalGridItem.HeaderItem -> item.id
                            is LocalGridItem.PhotoItem -> item.photo.localId
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
                        is LocalGridItem.PhotoItem -> {
                            // Photo item with smooth animation
                            androidx.compose.animation.AnimatedVisibility(
                                visible = true,
                                enter = androidx.compose.animation.fadeIn() + androidx.compose.animation.scaleIn(),
                                exit = androidx.compose.animation.fadeOut()
                            ) {
                                LocalPhotoItem(
                                    photo = item.photo,
                                    index = item.originalIndex,
                                    getDateLabel = ::getDateLabel,
                                    onClick = {
                                        Log.d(TAG, "Photo clicked at index: ${item.originalIndex}, localId: ${item.photo.localId}")
                                        selectedIndex = item.originalIndex
                                        selectedPhoto = item.photo
                                    }
                                )
                            }
                        }
                    }
                }
            }
        }
        // Photo viewer overlay
        selectedIndex?.let { index ->
            // Build photo list from loaded items only
            val loadedPhotos = mutableListOf<Photo>()
            var targetIndex = 0

            // Collect all loaded photos and find the target index
            for (i in 0 until localPhotos.itemCount) {
                val photo = localPhotos.peek(i) // Use peek to get already loaded items
                if (photo != null) {
                    if (i == index) {
                        targetIndex = loadedPhotos.size // Current position in loaded list
                    }
                    loadedPhotos.add(photo)
                }
            }

            if (loadedPhotos.isNotEmpty()) {
                // Ensure target index is within bounds
                val safeIndex = targetIndex.coerceIn(0, loadedPhotos.size - 1)

                Log.d(TAG, "Opening photo viewer: originalIndex=$index, mappedIndex=$safeIndex, totalLoaded=${loadedPhotos.size}")

                PhotoPageView(
                    initialPage = safeIndex,
                    onlyRemotePhotos = false,
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

@Composable
fun LocalPhotoItem(
    photo: Photo?,
    index: Int,
    getDateLabel: (String) -> String?,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current

    // Comprehensive debug logging for LocalPhotoItem
    LaunchedEffect(photo, index) {
        Log.d(TAG, "=== LOCAL PHOTO ITEM RENDER ===")
        Log.d(TAG, "Index: $index")
        if (photo != null) {
            Log.i(TAG, "Item[$index] RENDERING with data: localId=${photo.localId}, pathUri=${photo.pathUri}")
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
        if (photo != null) {
            val request = ImageRequest.Builder(context)
                .data(photo.pathUri)
                .size(Size(150, 150))
                .crossfade(100)
                .allowHardware(true)
                .allowRgb565(true)
                .build()

            SubcomposeAsyncImage(
                model = request,
                contentDescription = stringResource(id = R.string.photo),
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize(),
                loading = {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.7f))
                    )
                },
                error = {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(MaterialTheme.colorScheme.surfaceVariant),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            tint = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.6f),
                            imageVector = Icons.Rounded.BrokenImage,
                            contentDescription = stringResource(id = R.string.load_error),
                            modifier = Modifier.size(16.dp)
                        )
                    }
                }
            )
        } else {
            Log.w(TAG, "Item[$index] Showing PLACEHOLDER - photo is null")
            // Simplified placeholder for null items during loading - just background color
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.surfaceVariant)
            )
        }
    }
}

private const val TAG = "LocalPhotoGrid"