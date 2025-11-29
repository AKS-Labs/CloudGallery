package com.akslabs.cloudgallery.ui.main.screens.local

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.provider.MediaStore
import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.compose.animation.core.animateFloatAsState
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
import androidx.compose.material.icons.rounded.BrokenImage
import androidx.compose.material.icons.rounded.Cloud
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
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest
import coil.size.Size
import com.akslabs.chitralaya.ui.components.DragSelectableLazyVerticalGrid
import com.akslabs.chitralaya.ui.components.ExpressiveScrollbar
import com.akslabs.cloudgallery.BuildConfig
import com.akslabs.cloudgallery.R
import com.akslabs.cloudgallery.data.localdb.Preferences
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

private suspend fun buildPhotoDateMap(context: Context): Map<String, Long> = withContext(Dispatchers.IO) {
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
        } else {
            skippedCount++
        }
    }

    Log.d(TAG, "✅ Date grouping complete: $processedCount processed, $skippedCount skipped")

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

    // Create normal grid items
    val normalGridItems = (0 until localPhotos.itemCount).mapNotNull { index ->
        localPhotos.peek(index)?.let { photo ->
            LocalGridItem.PhotoItem(photo, index)
        }
    }

    // Create date grouped items
    val dateGroups = groupPhotosByDateOptimized(localPhotos, dateMap)
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
        totalPhotos = localPhotos.itemCount,
        lastUpdateTime = System.currentTimeMillis()
    )
}

@OptIn(ExperimentalMaterial3ExpressiveApi::class, ExperimentalFoundationApi::class)
@Composable
fun LocalPhotoGrid(
    localPhotos: LazyPagingItems<LocalUiPhoto>,
    totalCount: Int,
    expanded: Boolean,
    onExpandedChange: (Boolean) -> Unit,
    selectionMode: Boolean,
    selectedPhotos: Set<String>,
    onSelectionModeChange: (Boolean) -> Unit,
    onSelectedPhotosChange: (Set<String>) -> Unit,
    deletedPhotoIds: List<String>
) {
    val context = LocalContext.current
    val activity = context.findActivity()
    val window = activity?.window

    var selectedIndex by remember { mutableStateOf<Int?>(null) }
    var selectedPhoto by remember { mutableStateOf<LocalUiPhoto?>(null) }

    val glideSelectionBehavior by Preferences.getStringFlow(Preferences.glideSelectionBehaviorKey, "Fixed").collectAsStateWithLifecycle()

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

    // Create layout cache
    val layoutCache = remember(localPhotos.itemCount, isDateGroupedLayout, dateMap) {
        createLayoutCache(localPhotos, dateMap)
    }

    val currentLayoutItems = if (isDateGroupedLayout) layoutCache.dateGroupedItems else layoutCache.normalGridItems
    val maxLineSpan = columns

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
                                        modifier = Modifier.clickable(
                                            onClick = {
                                                if (selectionMode) {
                                                    toggleSelection(p.localId)
                                                } else {
                                                    selectedIndex = item.originalIndex
                                                    selectedPhoto = p
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

                if (window != null) {
                    PhotoPageView(
                        initialPage = safeIndex,
                        onlyRemotePhotos = false,
                        photos = loadedPhotos,
                        window = window
                    ) {
                        selectedIndex = null
                        selectedPhoto = null
                    }
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
    photo: LocalUiPhoto,
    index: Int,
    isSelected: Boolean,
    isDeleted: Boolean,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current

    // Animate scale/alpha if deleted
    val scale by animateFloatAsState(
        targetValue = if (isDeleted) 0f else 1f,
        animationSpec = tween(300),
        label = "scale"
    )

    if (scale > 0f) {
        Box(
            modifier = modifier
                .aspectRatio(1f)
                .graphicsLayer {
                    scaleX = scale
                    scaleY = scale
                    alpha = scale
                }
                .clip(RoundedCornerShape(16.dp)) // Clip the whole item to rounded shape
                .background(MaterialTheme.colorScheme.surfaceVariant) // Base background
                .then(if (isSelected) Modifier.border(8.dp, MaterialTheme.colorScheme.primary, RoundedCornerShape(16.dp)) else Modifier), // Thicker border
            contentAlignment = Alignment.Center
        ) {
            // Content Wrapper for padding
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .then(if (isSelected) Modifier.padding(4.dp) else Modifier) // Padding for the content
            ) {
                SubcomposeAsyncImage(
                    model = ImageRequest.Builder(context)
                        .data(photo.pathUri)
                        .size(Size(150, 150)) // Thumbnail size
                        .crossfade(true)
                        .build(),
                    contentDescription = stringResource(R.string.photo),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize(),
                    loading = {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(MaterialTheme.colorScheme.surfaceVariant),
                            contentAlignment = Alignment.Center
                        ) {
                            // Optional: small loading indicator or just color
                        }
                    },
                    error = {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(MaterialTheme.colorScheme.surfaceVariant),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Rounded.BrokenImage,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }
                )
            }

            // Selection Checkmark
            if (isSelected) {
                Box(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(8.dp)
                        .background(MaterialTheme.colorScheme.primary, CircleShape)
                        .size(24.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Check,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onPrimary,
                        modifier = Modifier.size(16.dp)
                    )
                }
            }

            // Cloud Icon (if backed up)
            if (photo.remoteId != null) {
                Box(
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(8.dp)
                        .background(MaterialTheme.colorScheme.surface.copy(alpha = 0.6f), CircleShape)
                        .size(24.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Rounded.Cloud,
                        contentDescription = "Backed up",
                        tint = Color(0xFF4CAF50), // Green color
                        modifier = Modifier.size(16.dp)
                    )
                }
            }
        }
    }
}

private const val TAG = "LocalPhotoGrid"

// Helper function to find the current activity from the context
private fun Context.findActivity(): Activity? {
    var context = this
    while (context is ContextWrapper) {
        if (context is Activity) return context
        context = context.baseContext
    }
    return null
}