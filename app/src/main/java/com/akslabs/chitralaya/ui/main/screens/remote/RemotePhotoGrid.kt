package com.akslabs.cloudgallery.ui.main.screens.remote

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
import com.akslabs.cloudgallery.utils.coil.ImageLoaderModule

@Composable
fun RemotePhotoGrid(
    cloudPhotos: LazyPagingItems<RemotePhoto>,
    totalCount: Int,
) {
    Log.e(TAG, "🎯 === REMOTE PHOTO GRID COMPOSING ===")
    val context = LocalContext.current
    var selectedIndex by remember { mutableStateOf<Int?>(null) }
    var selectedPhoto by remember { mutableStateOf<RemotePhoto?>(null) }

    // Comprehensive debug logging for cloud photos data
    LaunchedEffect(cloudPhotos.loadState, totalCount, cloudPhotos.itemCount) {
        Log.d(TAG, "=== REMOTE PHOTO GRID DEBUG ===")
        Log.d(TAG, "Total count from ViewModel: $totalCount")
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
        CloudPhotosGrid(
            cloudPhotos = cloudPhotos,
            onPhotoClick = { index, photo ->
                selectedIndex = index
                selectedPhoto = photo
            }
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

@Composable
fun CloudPhotosGrid(
    cloudPhotos: LazyPagingItems<RemotePhoto>,
    onPhotoClick: (Int, RemotePhoto?) -> Unit,
    modifier: Modifier = Modifier
) {
    val gridState = rememberLazyGridState()

    // Get dynamic column count from preferences
    val columnCount = remember {
        Preferences.getInt(Preferences.gridColumnCountKey, Preferences.defaultGridColumnCount)
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
                        text = "No photos in cloud",
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
            else -> {
                LazyVerticalGrid(
                    state = gridState,
                    modifier = Modifier.fillMaxSize(),
                    columns = GridCells.Fixed(columnCount),
                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Log.d(TAG, "=== LAZY GRID ITEMS BLOCK ===")
                    Log.d(TAG, "Creating items for count: ${cloudPhotos.itemCount}")

                    items(
                        count = cloudPhotos.itemCount,
                        key = { index ->
                            val peekedItem = cloudPhotos.peek(index)
                            val key = peekedItem?.remoteId ?: "placeholder_$index"
                            Log.v(TAG, "Key for index $index: $key (peeked item: ${if (peekedItem != null) "exists" else "null"})")
                            key
                        }
                    ) { index ->
                        Log.d(TAG, "=== RENDERING ITEM AT INDEX $index ===")

                        // First check what peek returns
                        val peekedPhoto = cloudPhotos.peek(index)
                        Log.d(TAG, "peek($index) returned: ${if (peekedPhoto != null) "RemotePhoto(${peekedPhoto.remoteId})" else "null"}")

                        // Now get the actual item (this should trigger loading)
                        val remotePhoto = cloudPhotos[index]
                        Log.d(TAG, "cloudPhotos[$index] returned: ${if (remotePhoto != null) "RemotePhoto(${remotePhoto.remoteId})" else "null"}")

                        if (remotePhoto == null && peekedPhoto == null) {
                            Log.w(TAG, "Both peek and direct access returned null for index $index - this indicates loading issue")
                        } else if (remotePhoto == null && peekedPhoto != null) {
                            Log.w(TAG, "Direct access returned null but peek returned data - unusual paging behavior")
                        } else if (remotePhoto != null && peekedPhoto == null) {
                            Log.i(TAG, "Direct access loaded new data for index $index")
                        }

                        CloudPhotoItem(
                            remotePhoto = remotePhoto,
                            index = index, // Pass index for debugging
                            onClick = {
                                Log.d(TAG, "Photo clicked at index: $index, remoteId: ${remotePhoto?.remoteId}")
                                onPhotoClick(index, remotePhoto)
                            }
                        )
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
                .size(Size(150, 150)) // Even smaller for faster loading
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
                    Log.d(TAG, "Item[$index] Showing LOADING state for remoteId=${remotePhoto.remoteId}")
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.7f))
                    )
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
                },
                success = { success ->
                    Log.i(TAG, "Item[$index] Showing SUCCESS state for remoteId=${remotePhoto.remoteId}")
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