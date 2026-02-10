package com.akslabs.cloudgallery.ui.main.screens.trash

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import androidx.activity.compose.BackHandler
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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.rounded.CloudOff
import androidx.compose.material.icons.rounded.DeleteOutline
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.FloatingToolbarDefaults.floatingToolbarVerticalNestedScroll
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest
import coil.size.Size
import com.akslabs.cloudgallery.ui.components.DragSelectableLazyVerticalGrid
import com.akslabs.cloudgallery.ui.components.ExpressiveScrollbar
import com.akslabs.cloudgallery.R
import com.akslabs.cloudgallery.data.localdb.Preferences
import com.akslabs.cloudgallery.data.localdb.entities.RemotePhoto
import com.akslabs.cloudgallery.ui.components.LoadAnimation
import com.akslabs.cloudgallery.ui.components.PhotoPageView
import com.akslabs.cloudgallery.ui.main.rememberGridState
import androidx.compose.animation.*
import com.akslabs.cloudgallery.ui.components.ExpressiveEmptyState
import com.akslabs.cloudgallery.utils.coil.ImageLoaderModule
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3ExpressiveApi::class, ExperimentalSharedTransitionApi::class, ExperimentalAnimationApi::class)
@Composable
fun TrashBinScreen(
    viewModel: TrashViewModel = viewModel(),
    expanded: Boolean,
    onExpandedChange: (Boolean) -> Unit,
    selectionMode: Boolean,
    selectedPhotos: Set<String>,
    onSelectionModeChange: (Boolean) -> Unit,
    onSelectedPhotosChange: (Set<String>) -> Unit,
    navController: NavHostController,
    sharedTransitionScope: SharedTransitionScope,
    animatedVisibilityScope: AnimatedVisibilityScope
) {
    val deletedPhotos = viewModel.deletedPhotosFlow.collectAsLazyPagingItems()
    val context = LocalContext.current
    
    var selectedPhotoId by remember { mutableStateOf<String?>(null) }
    
    val glideSelectionBehavior by Preferences.getStringFlow(Preferences.glideSelectionBehaviorKey, "Fixed").collectAsStateWithLifecycle()
    val thumbnailResolution = Preferences.getInt(Preferences.thumbnailResolutionKey, Preferences.defaultThumbnailResolution)
    var isScrollbarDragging by remember { mutableStateOf(false) }

    // Helper to toggle selection
    fun toggleSelection(photoId: String) {
        val newSelected = if (selectedPhotos.contains(photoId)) {
            selectedPhotos - photoId
        } else {
            selectedPhotos + photoId
        }
        onSelectedPhotosChange(newSelected)
        if (newSelected.isEmpty()) {
            onSelectionModeChange(false)
        }
    }

    // Handle Back Press in Selection Mode
    if (selectionMode) {
        BackHandler(enabled = true) {
            onSelectionModeChange(false)
            onSelectedPhotosChange(emptySet())
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        if (deletedPhotos.itemCount == 0 && deletedPhotos.loadState.refresh is LoadState.NotLoading) {
            ExpressiveEmptyState(
                icon = Icons.Rounded.DeleteOutline,
                title = "Trash is empty",
                description = "Stay efficient! Deleted photos will appear here before being permanently removed.",
                actionText = "Back to Gallery",
                onActionClick = {
                    navController.popBackStack()
                }
            )
        } else {
            val lazyGridState = rememberLazyGridState()
            val gridState = rememberGridState()
            val columns = gridState.columnCount.coerceIn(3, 6)
            
            ExpressiveScrollbar(
                lazyGridState = lazyGridState,
                totalItemsCount = deletedPhotos.itemCount,
                columnCount = columns,
                modifier = Modifier.align(Alignment.CenterEnd),
                onDraggingChange = { isDragging -> isScrollbarDragging = isDragging }
            )
            
            DragSelectableLazyVerticalGrid(
                lazyGridState = lazyGridState,
                selectionEnabled = selectionMode,
                glideSelectionBehavior = glideSelectionBehavior,
                onItemSelectionChange = { key, isSelected ->
                    if (key is String) {
                        val currentlySelected = selectedPhotos.contains(key)
                        if (isSelected != currentlySelected) {
                            toggleSelection(key)
                        }
                        if (!selectionMode && isSelected) {
                            onSelectionModeChange(true)
                        }
                    }
                },
                isItemSelected = { key ->
                    if (key is String) selectedPhotos.contains(key) else false
                },
                onDragSelectionEnd = {
                    if (selectedPhotos.isEmpty()) onSelectionModeChange(false)
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
                verticalArrangement = Arrangement.spacedBy(12.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(
                    count = deletedPhotos.itemCount,
                    key = { index -> 
                        deletedPhotos.peek(index)?.remoteId ?: index 
                    }
                ) { index ->
                    val photo = deletedPhotos[index]
                    if (photo != null) {
                        val isSelected = selectedPhotos.contains(photo.remoteId)
                        // Map DeletedPhoto to RemotePhoto for display
                        val remotePhoto = RemotePhoto(
                            remoteId = photo.remoteId,
                            photoType = photo.photoType,
                            fileName = photo.fileName,
                            fileSize = photo.fileSize,
                            uploadedAt = photo.uploadedAt,
                            messageId = photo.messageId
                        )
                        
                        TrashPhotoItem(
                            remotePhoto = remotePhoto,
                            isSelected = isSelected,
                            isScrollbarDragging = isScrollbarDragging,
                                thumbnailResolution = thumbnailResolution,
                                modifier = Modifier.clickable {
                                if (selectionMode) {
                                    toggleSelection(photo.remoteId)
                                } else {
                                    // selectedIndex removed

                                    selectedPhotoId = photo.remoteId
                                }
                            }
                        )
                    }
                }
            }
        }
        
        // Photo Viewer
        selectedPhotoId?.let { photoId ->
            val loadedPhotos = mutableListOf<com.akslabs.cloudgallery.data.localdb.entities.Photo>()
            
            for (i in 0 until deletedPhotos.itemCount) {
                val photo = deletedPhotos.peek(i)
                if (photo != null) {
                    loadedPhotos.add(
                        com.akslabs.cloudgallery.data.localdb.entities.Photo(
                            "", photo.remoteId, photo.photoType, ""
                        )
                    )
                }
            }
            
            if (loadedPhotos.isNotEmpty()) {
                val window = (context.findActivity())?.window
                if (window != null) {
                    PhotoPageView(
                        initialPhotoId = photoId,
                        localPhotos = emptyList(),
                        cloudPhotos = loadedPhotos,
                        isRemote = true,
                        window = window,
                        onDismissRequest = { selectedPhotoId = null },
                        sharedTransitionScope = sharedTransitionScope,
                        animatedVisibilityScope = animatedVisibilityScope
                    )
                }
            }
        }
    }
}

@Composable
fun TrashPhotoItem(
    remotePhoto: RemotePhoto,
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
            val targetSize = if (isScrollbarDragging) 50 else thumbnailResolution
            
            val imageRequestBuilder = ImageRequest.Builder(context)
                .data(remotePhoto)
                .size(Size(targetSize, targetSize))
            
            if (!isScrollbarDragging) {
                imageRequestBuilder.crossfade(100)
            }
            
            val imageRequest = imageRequestBuilder.build()

            SubcomposeAsyncImage(
                imageLoader = ImageLoaderModule.thumbnailImageLoader,
                model = imageRequest,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize(),
                contentDescription = null,
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
                error = {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(MaterialTheme.colorScheme.surfaceContainerLow),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Rounded.CloudOff,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.6f),
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

private fun Context.findActivity(): Activity? {
    var context = this
    while (context is ContextWrapper) {
        if (context is Activity) return context
        context = context.baseContext
    }
    return null
}
