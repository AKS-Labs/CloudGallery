
content = r"""package com.akslabs.cloudgallery.ui.main.screens.local

import android.app.Activity
import android.content.ContentUris
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

private suspend fun fetchAllLocalPhotos(context: Context): List<LocalUiPhoto> = withContext(Dispatchers.IO) {
    val resolver = context.contentResolver
    val collection = MediaStore.Images.Media.getContentUri(MediaStore.VOLUME_EXTERNAL)
    val projection = arrayOf(
        MediaStore.Images.ImageColumns._ID,
        MediaStore.Images.ImageColumns.DATE_TAKEN,
        MediaStore.Images.ImageColumns.DATE_ADDED,
        MediaStore.Images.ImageColumns.DATE_MODIFIED,
        MediaStore.Images.ImageColumns.MIME_TYPE,
        MediaStore.Images.ImageColumns.SIZE
    )
    val photos = ArrayList<LocalUiPhoto>(4096)
    resolver.query(collection, projection, null, null, "${MediaStore.Images.ImageColumns.DATE_TAKEN} DESC")?.use { cursor ->
        val idIdx = cursor.getColumnIndexOrThrow(MediaStore.Images.ImageColumns._ID)
        val takenIdx = cursor.getColumnIndexOrThrow(MediaStore.Images.ImageColumns.DATE_TAKEN)
        val addedIdx = cursor.getColumnIndexOrThrow(MediaStore.Images.ImageColumns.DATE_ADDED)
        val modIdx = cursor.getColumnIndexOrThrow(MediaStore.Images.ImageColumns.DATE_MODIFIED)
        val mimeIdx = cursor.getColumnIndexOrThrow(MediaStore.Images.ImageColumns.MIME_TYPE)
        val sizeIdx = cursor.getColumnIndexOrThrow(MediaStore.Images.ImageColumns.SIZE)

        while (cursor.moveToNext()) {
            val id = cursor.getLong(idIdx).toString()
            val taken = runCatching { cursor.getLong(takenIdx) }.getOrDefault(0L)
            val added = runCatching { cursor.getLong(addedIdx) }.getOrDefault(0L)
            val modified = runCatching { cursor.getLong(modIdx) }.getOrDefault(0L)
            val mimeType = cursor.getString(mimeIdx) ?: "image/jpeg"
            val size = cursor.getLong(sizeIdx)

            val tsMillis = when {
                taken > 0L -> taken
                added > 0L -> added * 1000L
                modified > 0L -> modified * 1000L
                else -> 0L
            }
            
            val uri = ContentUris.withAppendedId(collection, id.toLong()).toString()

            photos.add(LocalUiPhoto(
                localId = id,
                pathUri = uri,
                mimeType = mimeType,
                displayDateMillis = tsMillis,
                size = size,
                remoteId = null
            ))
        }
    }
    photos
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

    // Load all photos in background
    var allPhotos by remember { mutableStateOf<List<LocalUiPhoto>>(emptyList()) }
    LaunchedEffect(Unit) {
        if (allPhotos.isEmpty()) {
            allPhotos = fetchAllLocalPhotos(context)
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
    val layoutCache = remember(allPhotos, isDateGroupedLayout, deletedPhotoIds.toList()) {
        createLayoutCache(allPhotos, deletedPhotoIds)
    }

    val currentLayoutItems = if (isDateGroupedLayout) layoutCache.dateGroupedItems else layoutCache.normalGridItems
    val maxLineSpan = columns

    fun getDateLabel(localId: String): String? {
        val photo = allPhotos.find { it.localId == localId } ?: return null
        return java.text.SimpleDateFormat("EEE d - LLLL yyyy", java.util.Locale.getDefault()).format(java.util.Date(photo.displayDateMillis))
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        if (localPhotos.loadState.refresh == LoadState.Loading) {
            LoadAnimation(modifier = Modifier.align(Alignment.Center))
        } else {
            Box(modifier = Modifier.fillMaxSize()) {
                // Calculate effective total items for scrollbar (accounting for headers)
                val totalRows = if (isDateGroupedLayout) {
                    val headers = layoutCache.dateGroupedItems.count { it is LocalGridItem.HeaderItem }
                    val photos = layoutCache.dateGroupedItems.count { it is LocalGridItem.PhotoItem }
                    headers + kotlin.math.ceil(photos.toFloat() / columns).toInt()
                } else {
                    kotlin.math.ceil(layoutCache.normalGridItems.size.toFloat() / columns).toInt()
                }
                val effectiveTotalItems = totalRows * columns

                ExpressiveScrollbar(
                    lazyGridState = lazyGridState,
                    totalItemsCount = effectiveTotalItems,
                    columnCount = columns,
                    onDraggingChange = { isDragging -> isScrollbarDragging = isDragging },
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
                                        isScrollbarDragging = isScrollbarDragging,
                                        thumbnailResolution = thumbnailResolution,
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
            // Use allPhotos directly
            allPhotos.forEachIndexed { i, photo ->
                if (i == index) {
                    targetIndex = loadedPhotos.size
                }
                loadedPhotos.add(
                    com.akslabs.cloudgallery.data.localdb.entities.Photo(
                        localId = photo.localId,
                        remoteId = null,
                        photoType = photo.mimeType.substringAfter('/').ifEmpty { "jpg" },
                        pathUri = photo.pathUri
                    )
                )
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
    isScrollbarDragging: Boolean = false,
    thumbnailResolution: Int = 150,
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
                        .size(if (isScrollbarDragging) Size(50, 50) else Size(thumbnailResolution, thumbnailResolution))
                        .crossfade(!isScrollbarDragging)
                        .allowHardware(false) // Disable hardware bitmaps to avoid issues during rapid scroll? Or maybe true is better. Let's stick to false for now as per previous optimization attempts or default. Actually default is true.
                        // Let's use the optimized settings:
                        .memoryCachePolicy(coil.request.CachePolicy.ENABLED)
                        .diskCachePolicy(coil.request.CachePolicy.ENABLED)
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
"""
with open(r'c:\Users\ashin\StudioProjects\CloudGallery\app\src\main\java\com\akslabs\chitralaya\ui\main\screens\local\LocalPhotoGrid.kt', 'w', encoding='utf-8') as f:
    f.write(content)
