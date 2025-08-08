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
    val context = LocalContext.current
    var selectedIndex by remember { mutableStateOf<Int?>(null) }

    // Debug logging for cloud photos data
    LaunchedEffect(cloudPhotos.loadState, totalCount) {
        Log.d(TAG, "=== REMOTE PHOTO GRID DEBUG ===")
        Log.d(TAG, "Total count from ViewModel: $totalCount")
        Log.d(TAG, "CloudPhotos itemCount: ${cloudPhotos.itemCount}")
        Log.d(TAG, "LoadState.refresh: ${cloudPhotos.loadState.refresh}")
        Log.d(TAG, "LoadState.append: ${cloudPhotos.loadState.append}")
        Log.d(TAG, "LoadState.prepend: ${cloudPhotos.loadState.prepend}")

        if (cloudPhotos.itemCount > 0) {
            Log.i(TAG, "First few cloud photos:")
            for (i in 0 until minOf(3, cloudPhotos.itemCount)) {
                val photo = cloudPhotos.peek(i)
                if (photo != null) {
                    Log.d(TAG, "Photo[$i]: remoteId=${photo.remoteId}, type=${photo.photoType}, fileName=${photo.fileName}")
                } else {
                    Log.d(TAG, "Photo[$i]: null (not loaded yet)")
                }
            }
        } else {
            Log.w(TAG, "No cloud photos to display")
        }
        Log.d(TAG, "=== END REMOTE PHOTO GRID DEBUG ===")
    }

    Box(modifier = Modifier.fillMaxSize()) {
        // Unified cloud photos grid
        CloudPhotosGrid(
            cloudPhotos = cloudPhotos,
            onPhotoClick = { index -> selectedIndex = index }
        )

        // Photo viewer overlay
        selectedIndex?.let { index ->
            PhotoPageView(
                initialPage = index,
                onlyRemotePhotos = true,
                photos = cloudPhotos.itemSnapshotList.items.map { it.toPhoto() }
            ) {
                selectedIndex = null
            }
        }
    }
}

@Composable
fun CloudPhotosGrid(
    cloudPhotos: LazyPagingItems<RemotePhoto>,
    onPhotoClick: (Int) -> Unit,
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
                    columns = GridCells.Fixed(4),
                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    var lastHeader: String? = null
                    for (i in 0 until cloudPhotos.itemCount) {
                        val item = cloudPhotos.peek(i)
                        val label = item?.uploadedAt?.let { ms ->
                            java.text.SimpleDateFormat("EEE d - LLLL yyyy", java.util.Locale.getDefault()).format(java.util.Date(ms))
                        }
                        if (label != null && label != lastHeader) {
                            item(span = { GridItemSpan(maxLineSpan) }) {
                                Text(
                                    text = label,
                                    style = MaterialTheme.typography.titleMedium,
                                    fontWeight = FontWeight.SemiBold,
                                    color = MaterialTheme.colorScheme.onSurface,
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(top = 8.dp)
                                )
                            }
                            lastHeader = label
                        }
                        item(key = item?.remoteId ?: "rp_$i") {
                            CloudPhotoItem(
                                remotePhoto = item,
                                onClick = { onPhotoClick(i) }
                            )
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
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current

    // Debug logging for each photo item
    LaunchedEffect(remotePhoto) {
        if (remotePhoto != null) {
            Log.d(TAG, "CloudPhotoItem: Loading photo remoteId=${remotePhoto.remoteId}, type=${remotePhoto.photoType}")
            Log.v(TAG, "Photo details: fileName=${remotePhoto.fileName}, size=${remotePhoto.fileSize}, uploadedAt=${remotePhoto.uploadedAt}")
        } else {
            Log.v(TAG, "CloudPhotoItem: remotePhoto is null")
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
            val imageRequest = ImageRequest.Builder(context)
                .data(remotePhoto)
                .size(Size(300, 300)) // Thumbnail size for better performance
                .placeholderMemoryCacheKey("thumb_${remotePhoto.remoteId}")
                .memoryCacheKey("thumb_${remotePhoto.remoteId}")
                .diskCacheKey("thumb_${remotePhoto.remoteId}")
                .listener(
                    onStart = {
                        Log.d(TAG, "Image loading started for remoteId=${remotePhoto.remoteId}")
                    },
                    onSuccess = { _, _ ->
                        Log.i(TAG, "Image loading SUCCESS for remoteId=${remotePhoto.remoteId}")
                    },
                    onError = { _, error ->
                        Log.e(TAG, "Image loading ERROR for remoteId=${remotePhoto.remoteId}: ${error.throwable?.message}", error.throwable)
                    }
                )
                .build()

            Log.v(TAG, "Creating ImageRequest for remoteId=${remotePhoto.remoteId} with thumbnailImageLoader")

            SubcomposeAsyncImage(
                imageLoader = ImageLoaderModule.thumbnailImageLoader,
                model = imageRequest,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize(),
                contentDescription = stringResource(id = R.string.photo),
                loading = {
                    Log.v(TAG, "Showing loading state for remoteId=${remotePhoto.remoteId}")
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(MaterialTheme.colorScheme.surfaceVariant),
                        contentAlignment = Alignment.Center
                    ) {
                        LoadAnimation()
                    }
                },
                error = { error ->
                    Log.e(TAG, "Showing error state for remoteId=${remotePhoto.remoteId}: ${error.result.throwable?.message}")
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(MaterialTheme.colorScheme.errorContainer),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            tint = MaterialTheme.colorScheme.onErrorContainer,
                            imageVector = Icons.Rounded.CloudOff,
                            contentDescription = stringResource(id = R.string.load_error),
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }
            )
        } else {
            // Placeholder for null items during loading
            Log.v(TAG, "Showing placeholder for null remotePhoto")
            LoadAnimation()
        }
    }
}

private const val TAG = "RemotePhotoGrid"