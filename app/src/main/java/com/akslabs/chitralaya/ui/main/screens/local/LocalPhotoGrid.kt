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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateMapOf
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
import com.akslabs.cloudgallery.R
import com.akslabs.cloudgallery.data.localdb.entities.Photo
import com.akslabs.cloudgallery.data.localdb.Preferences
import com.akslabs.cloudgallery.ui.components.LoadAnimation
import com.akslabs.cloudgallery.ui.components.PhotoPageView
import com.akslabs.cloudgallery.ui.components.itemsPaging

@Composable
fun LocalPhotoGrid(localPhotos: LazyPagingItems<Photo>, totalCount: Int) {
    Log.e(TAG, "🎯 === LOCAL PHOTO GRID COMPOSING ===")
    val context = LocalContext.current
    var selectedIndex by remember { mutableStateOf<Int?>(null) }
    var selectedPhoto by remember { mutableStateOf<Photo?>(null) }

    // Fixed grid to match screenshot
    val columns = 4
    val horizontalSpacing = 12.dp
    val verticalSpacing = 12.dp

    // Cache date lookups
    val dateCache = remember { mutableStateMapOf<String, Long>() }

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
        val cached = dateCache[localId]
        val millis = if (cached != null) cached else runCatching {
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
            )?.use { c -> if (c.moveToFirst()) (c.getLong(0) * 1000L).also { dateCache[localId] = it } else null }
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
                modifier = Modifier.fillMaxSize(),
                columns = GridCells.Fixed(columns),
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                verticalArrangement = Arrangement.spacedBy(verticalSpacing),
                horizontalArrangement = Arrangement.spacedBy(horizontalSpacing)
            ) {
                Log.d(TAG, "=== LAZY GRID ITEMS BLOCK ===")
                Log.d(TAG, "Creating items for count: ${localPhotos.itemCount}")

                items(
                    count = localPhotos.itemCount,
                    key = { index ->
                        val peekedItem = localPhotos.peek(index)
                        val key = peekedItem?.localId ?: "placeholder_$index"
                        Log.v(TAG, "Key for index $index: $key (peeked item: ${if (peekedItem != null) "exists" else "null"})")
                        key
                    }
                ) { index ->
                    Log.d(TAG, "=== RENDERING LOCAL ITEM AT INDEX $index ===")

                    // First check what peek returns
                    val peekedPhoto = localPhotos.peek(index)
                    Log.d(TAG, "peek($index) returned: ${if (peekedPhoto != null) "Photo(${peekedPhoto.localId})" else "null"}")

                    // Now get the actual item (this should trigger loading)
                    val photo = localPhotos[index]
                    Log.d(TAG, "localPhotos[$index] returned: ${if (photo != null) "Photo(${photo.localId})" else "null"}")

                    if (photo == null && peekedPhoto == null) {
                        Log.w(TAG, "Both peek and direct access returned null for index $index - this indicates loading issue")
                    } else if (photo == null && peekedPhoto != null) {
                        Log.w(TAG, "Direct access returned null but peek returned data - unusual paging behavior")
                    } else if (photo != null && peekedPhoto == null) {
                        Log.i(TAG, "Direct access loaded new data for index $index")
                    }

                    LocalPhotoItem(
                        photo = photo,
                        index = index,
                        getDateLabel = ::getDateLabel,
                        onClick = {
                            Log.d(TAG, "Photo clicked at index: $index, localId: ${photo?.localId}")
                            selectedIndex = index
                            selectedPhoto = photo
                        }
                    )
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
            Log.d(TAG, "Item[$index] Creating image for localId=${photo.localId}, pathUri=${photo.pathUri}")

            SubcomposeAsyncImage(
                model = photo.pathUri,
                contentDescription = stringResource(id = R.string.photo),
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize(),
                loading = {
                    Log.d(TAG, "Item[$index] Showing LOADING state for localId=${photo.localId}")
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.7f))
                    )
                },
                error = { error ->
                    Log.e(TAG, "Item[$index] Showing ERROR state for localId=${photo.localId}: ${error.result.throwable?.message}")
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
                },
                onSuccess = { success ->
                    Log.i(TAG, "Item[$index] Image SUCCESS for localId=${photo.localId}, dataSource=${success.result.dataSource}")
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