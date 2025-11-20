package com.akslabs.cloudgallery.ui.main.screens.local

import android.app.Activity
import android.provider.MediaStore
import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.rounded.BrokenImage
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import coil.compose.SubcomposeAsyncImage
import coil.request.CachePolicy
import coil.request.ImageRequest
import coil.size.Size
import com.akslabs.chitralaya.ui.components.ExpressiveScrollbar
import com.akslabs.cloudgallery.BuildConfig
import com.akslabs.cloudgallery.R
import com.akslabs.cloudgallery.data.mediastore.LocalUiPhoto
import com.akslabs.cloudgallery.ui.components.LoadAnimation
import com.akslabs.cloudgallery.ui.components.PhotoPageView
import com.akslabs.cloudgallery.ui.main.rememberGridState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

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

private suspend fun buildPhotoDateMap(context: android.content.Context): Map<String, Long> = withContext(Dispatchers.IO) {
    val resolver = context.contentResolver
    val collection = MediaStore.Images.Media.getContentUri(MediaStore.VOLUME_EXTERNAL)
    val projection = arrayOf(
        MediaStore.Images.ImageColumns._ID,
        MediaStore.Images.ImageColumns.DATE_TAKEN,
        MediaStore.Images.ImageColumns.DATE_ADDED,
        MediaStore.Images.ImageColumns.DATE_MODIFIED
    )
    val map = HashMap<String, Long>(4096)
    resolver.query(collection, projection, null, null, null)?.use { cursor ->
        val idIdx = cursor.getColumnIndexOrThrow(MediaStore.Images.ImageColumns._ID)
        val takenIdx = cursor.getColumnIndexOrThrow(MediaStore.Images.ImageColumns.DATE_TAKEN)
        val addedIdx = cursor.getColumnIndexOrThrow(MediaStore.Images.ImageColumns.DATE_ADDED)
        val modIdx = cursor.getColumnIndexOrThrow(MediaStore.Images.ImageColumns.DATE_MODIFIED)
        while (cursor.moveToNext()) {
            val id = cursor.getLong(idIdx).toString()
            val taken = runCatching { cursor.getLong(takenIdx) }.getOrDefault(0L)
            val added = runCatching { cursor.getLong(addedIdx) }.getOrDefault(0L)
            val modified = runCatching { cursor.getLong(modIdx) }.getOrDefault(0L)
            val tsSec = when {
                taken > 0L -> taken / 1000L
                added > 0L -> added
                modified > 0L -> modified
                else -> 0L
            }
            map[id] = tsSec * 1000L
        }
    }
    map
}

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
    localPhotos: LazyPagingItems<LocalUiPhoto>,
    dateMap: Map<String, Long>
): List<DateGroup> {
    val photosByDate = mutableMapOf<String, MutableList<Pair<LocalUiPhoto, Int>>>()
    var processedCount = 0
    var skippedCount = 0

    Log.d(TAG, "🔍 Starting date grouping for ${localPhotos.itemCount} photos")

    // Process ALL photos - no filtering
    for (i in 0 until localPhotos.itemCount) {
        val photo = localPhotos.peek(i)
        if (photo != null) {
            val timestamp = dateMap[photo.localId] ?: safeTimestampFromLocalId(photo.localId)
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
        val sortKey = photos.maxOfOrNull { dateMap[it.first.localId] ?: safeTimestampFromLocalId(it.first.localId) } ?: 0L
        DateGroup(
            dateLabel = dateLabel,
            photos = photos.sortedByDescending { dateMap[it.first.localId] ?: safeTimestampFromLocalId(it.first.localId) },
            sortKey = sortKey
        )
    }.sortedByDescending { it.sortKey }
}

// Optimized function to create layout cache
private fun createLayoutCache(
    localPhotos: LazyPagingItems<LocalUiPhoto>,
    dateMap: Map<String, Long>
): LayoutCache {
    val start = System.currentTimeMillis()
    val normalGridItems = buildList {
        for (i in 0 until localPhotos.itemCount) {
            val p = localPhotos.peek(i) ?: continue
            add(LocalGridItem.PhotoItem(p, i))
        }
    }
    val dateGroups = groupPhotosByDateOptimized(localPhotos, dateMap)
    val dateGroupedItems = buildList {
        dateGroups.forEachIndexed { idx, group ->
            add(LocalGridItem.HeaderItem(group.dateLabel, "header_${idx}_${group.dateLabel}"))
            group.photos.forEach { (p, originalIndex) -> add(LocalGridItem.PhotoItem(p, originalIndex)) }
        }
    }
    Log.d(TAG, "Layout cache in ${System.currentTimeMillis() - start}ms; normal=${normalGridItems.size}, grouped=${dateGroupedItems.size}")
    return LayoutCache(normalGridItems, dateGroupedItems, localPhotos.itemCount, System.currentTimeMillis())
}


@OptIn(ExperimentalMaterial3ExpressiveApi::class, ExperimentalFoundationApi::class)
@Composable
fun LocalPhotoGrid(
    localPhotos: LazyPagingItems<LocalUiPhoto>,
    totalCount: Int,
    expanded: Boolean,
    onExpandedChange: (Boolean) -> Unit
) {

    if (BuildConfig.DEBUG) Log.d(TAG, "🎯 LocalPhotoGrid composing")
    val context = LocalContext.current
    var selectedIndex by remember { mutableStateOf<Int?>(null) }
    var selectedPhoto by remember { mutableStateOf<LocalUiPhoto?>(null) }
    var selectionMode by remember { mutableStateOf(false) }
    var selectedPhotos by remember { mutableStateOf<Set<String>>(emptySet()) }
    val window = (context as Activity).window

    fun toggleSelection(photoId: String) {
        selectedPhotos = if (selectedPhotos.contains(photoId)) {
            selectedPhotos - photoId
        } else {
            selectedPhotos + photoId
        }
        if (selectedPhotos.isEmpty()) {
            selectionMode = false
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

    // Build MediaStore date map in background (once per dataset size change)
    var dateMap by remember { mutableStateOf<Map<String, Long>>(emptyMap()) }
    LaunchedEffect(Unit) {
        if (dateMap.isEmpty()) {
            dateMap = buildPhotoDateMap(context)
        }
    }

    // Debug logging (guarded)
    LaunchedEffect(localPhotos.loadState, totalCount, localPhotos.itemCount) {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "=== LOCAL PHOTO GRID DEBUG ===")
            Log.d(TAG, "Total count from ViewModel: $totalCount")
            Log.d(TAG, "LocalPhotos itemCount: ${localPhotos.itemCount}")
            Log.d(TAG, "LoadState.refresh: ${localPhotos.loadState.refresh}")
            Log.d(TAG, "LoadState.append: ${localPhotos.loadState.append}")
            Log.d(TAG, "LoadState.prepend: ${localPhotos.loadState.prepend}")
            Log.d(TAG, "=== END LOCAL PHOTO GRID DEBUG ===")
        }
    }

    // No heavy cache for grouped layout; we stream headers/items inline for parity with normal grid

    fun getDateLabel(localId: String): String? {
        val millis = dateMap[localId] ?: return null
        return java.text.SimpleDateFormat("EEE d - LLLL yyyy", java.util.Locale.getDefault()).format(java.util.Date(millis))
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        if (localPhotos.loadState.refresh == LoadState.Loading) {
            LoadAnimation(modifier = Modifier.align(Alignment.Center))
        } else {
            Box(modifier = Modifier.fillMaxSize()) {
                ExpressiveScrollbar(
                    lazyGridState = lazyGridState,
                    modifier = Modifier.align(Alignment.CenterEnd)
                )
                // the grid (unchanged except keep the same lazyGridState variable)
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
                    contentPadding = PaddingValues(
                        start = 16.dp,
                        top = 8.dp,
                        end = 16.dp,
                        bottom = 96.dp
                    ),
                    verticalArrangement = Arrangement.spacedBy(verticalSpacing),
                    horizontalArrangement = Arrangement.spacedBy(horizontalSpacing)
                                )
                                {
                                if (isDateGroupedLayout) {
                                    // Stream grouped headers/items inline to match normal grid count
                                    for (index in 0 until localPhotos.itemCount) {
                                        val current = localPhotos.peek(index)
                                        val prev = if (index > 0) localPhotos.peek(index - 1) else null
                                        val currentLabel = current?.let {
                                            val ts = dateMap[it.localId] ?: safeTimestampFromLocalId(it.localId)
                                            formatPhotoDate(ts)
                                        }
                                        val prevLabel = prev?.let {
                                            val ts = dateMap[it.localId] ?: safeTimestampFromLocalId(it.localId)
                                            formatPhotoDate(ts)
                                        }
                                        if (currentLabel != null && currentLabel != prevLabel) {
                                            item(key = "header_${index}_$currentLabel", span = { GridItemSpan(maxLineSpan) }) {
                                                Text(
                                                    text = currentLabel,
                                                    style = MaterialTheme.typography.titleMedium,
                                                    fontWeight = FontWeight.SemiBold,
                                                    color = MaterialTheme.colorScheme.onSurface,
                                                    modifier = Modifier
                                                        .fillMaxWidth()
                                                        .padding(top = 8.dp, bottom = 4.dp)
                                                )
                                            }
                                        }
                                        val key = current?.localId ?: "placeholder"
                                        item(key = "photo_${index}_$key") {
                                            val p = localPhotos[index]
                                            if (p != null) {
                                                val isSelected = selectedPhotos.contains(p.localId)
                                                LocalPhotoItem(
                                                    photo = p,
                                                    index = index,
                                                    isSelected = isSelected,
                                                    modifier = Modifier.combinedClickable(
                                                        onClick = {
                                                            if (selectionMode) {
                                                                toggleSelection(p.localId)
                                                            } else {
                                                                selectedIndex = index
                                                                selectedPhoto = p
                                                            }
                                                        },
                                                        onLongClick = {
                                                            if (!selectionMode) {
                                                                selectionMode = true
                                                            }
                                                            toggleSelection(p.localId)
                                                        }
                                                    )
                                                )
                                            } else {
                                                LocalPhotoItem(photo = null, index = index, isSelected = false)
                                            }
                                        }
                                    }
                                } else {
                                    // Normal grid with stable unique keys per index to avoid duplicate key crashes
                                    items(
                                        count = localPhotos.itemCount,
                                        key = { i ->
                                            val p = localPhotos.peek(i)
                                            if (p != null) "photo_${i}_${p.localId}" else "photo_placeholder_${i}"
                                        }
                                    ) { i ->
                                        val p = localPhotos[i]
                                        if (p != null) {
                                            val isSelected = selectedPhotos.contains(p.localId)
                                            LocalPhotoItem(
                                                photo = p,
                                                index = i,
                                                isSelected = isSelected,
                                                modifier = Modifier.combinedClickable(
                                                    onClick = {
                                                        if (selectionMode) {
                                                            toggleSelection(p.localId)
                                                        } else {
                                                            selectedIndex = i
                                                            selectedPhoto = p
                                                        }
                                                    },
                                                    onLongClick = {
                                                        if (!selectionMode) {
                                                            selectionMode = true
                                                        }
                                                        toggleSelection(p.localId)
                                                    }
                                                )
                                            )
                                        } else {
                                            LocalPhotoItem(photo = null, index = i, isSelected = false)
                                        }
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
                            for (i in 0 until localPhotos.itemCount) {
                                val photo = localPhotos.peek(i) // Use peek to get already loaded items
                                if (photo != null) {
                                    if (i == index) {
                                        targetIndex = loadedPhotos.size // Current position in loaded list
                                    }
                                    // Map UI photo to entity for viewer compatibility
                                    loadedPhotos.add(
                                        com.akslabs.cloudgallery.data.localdb.entities.Photo(
                                            localId = photo.localId,
                                            remoteId = null,
                                            photoType = photo.mimeType.substringAfter('/').ifEmpty { "jpg" },
                                            pathUri = photo.pathUri
                                        )
                                    )
                                }
                            }
                
                            if (loadedPhotos.isNotEmpty()) {
                                // Ensure target index is within bounds
                                val safeIndex = targetIndex.coerceIn(0, loadedPhotos.size - 1)
                
                                Log.d(TAG, "Opening photo viewer: originalIndex=$index, mappedIndex=$safeIndex, totalLoaded=${loadedPhotos.size}")
                
                                PhotoPageView(
                                    initialPage = safeIndex,
                                    onlyRemotePhotos = false,
                                    photos = loadedPhotos,
                                    window = window
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
                    photo: LocalUiPhoto?,
                    index: Int,
                    isSelected: Boolean,
                    modifier: Modifier = Modifier
                ) {
                    val context = LocalContext.current
                
                    // Per-item logging removed to avoid main-thread overhead during fast scroll
                
                    Box(
                        modifier = modifier
                            .aspectRatio(1f)
                            .clip(RoundedCornerShape(16.dp))
                            .background(MaterialTheme.colorScheme.surfaceVariant),
                        contentAlignment = Alignment.Center
                    ) {
                        if (photo != null) {
                            val request = ImageRequest.Builder(context)
                                .data(photo.pathUri)
                                .size(Size(110, 110))
                                .crossfade(false)
                                .allowHardware(false)
                //                .allowRgb565(true)
                                .memoryCachePolicy(CachePolicy.ENABLED)
                                .diskCachePolicy(CachePolicy.ENABLED)
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
                                            .background(MaterialTheme.colorScheme.surfaceVariant)
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
                        if (isSelected) {
                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.4f))
                            )
                            Icon(
                                imageVector = Icons.Filled.CheckCircle,
                                contentDescription = "Selected",
                                tint = Color.White,
                                modifier = Modifier
                                    .align(Alignment.TopEnd)
                                    .padding(8.dp)
                            )
                        }
                    }
                }
                
                private const val TAG = "LocalPhotoGrid"
                