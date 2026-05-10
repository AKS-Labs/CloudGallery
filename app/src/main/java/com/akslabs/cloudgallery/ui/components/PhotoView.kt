package com.akslabs.cloudgallery.ui.components
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material.icons.rounded.CloudDownload
import androidx.compose.material.icons.rounded.Done
import androidx.compose.material.icons.rounded.HourglassTop
import com.akslabs.cloudgallery.api.BotApi

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.CloudOff
import androidx.compose.material.icons.rounded.Error
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.work.WorkInfo
import coil.compose.AsyncImage
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest
import androidx.compose.animation.*
import com.akslabs.cloudgallery.R
import com.akslabs.cloudgallery.data.localdb.DbHolder
import com.akslabs.cloudgallery.data.localdb.Preferences
import com.akslabs.cloudgallery.data.localdb.entities.Photo
import com.akslabs.cloudgallery.ui.main.screens.local.UploadState
import com.akslabs.cloudgallery.ui.main.screens.remote.DownloadState
import com.akslabs.cloudgallery.utils.coil.ImageLoaderModule
import com.akslabs.cloudgallery.utils.toastFromMainThread
import com.akslabs.cloudgallery.workers.WorkModule
import com.akslabs.cloudgallery.workers.WorkModule.UPLOADING_ID
import com.akslabs.cloudgallery.workers.WorkModule.DOWNLOADING_ID
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import android.app.Activity
import android.content.Context
import android.content.ContextWrapper

import android.view.Window

@OptIn(ExperimentalAnimationApi::class, ExperimentalSharedTransitionApi::class, ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun PhotoView(
    photo: Photo,
    isOnlyRemote: Boolean,
    showUiState: () -> MutableState<Boolean>,
    window: Window,
    sharedTransitionScope: SharedTransitionScope,
    animatedVisibilityScope: AnimatedVisibilityScope,
    onDeletePhoto: (() -> Unit)? = null
) {
    val context = LocalContext.current
    var showUi by showUiState()
    val scope = rememberCoroutineScope()
    val isOnlyOnDevice = rememberSaveable { photo.remoteId == null }
    var photoUploadState by rememberSaveable {
        mutableStateOf(
            if (isOnlyOnDevice) UploadState.NOT_UPLOADED else UploadState.UPLOADED
        )
    }
    
    // Download state for remote photos
    val isAlreadyOnDevice = rememberSaveable { photo.remoteId != null && !isOnlyRemote }
    var photoDownloadState by rememberSaveable {
        mutableStateOf(
            if (isAlreadyOnDevice) DownloadState.DOWNLOADED else DownloadState.NOT_DOWNLOADED
        )
    }
    
    // Dialog states
    var showDownloadDialog by rememberSaveable { mutableStateOf(false) }
    var existingPhotoPath by rememberSaveable { mutableStateOf("") }
    var showDeleteDialog by rememberSaveable { mutableStateOf(false) }
    var showInfoDialog by rememberSaveable { mutableStateOf(false) }
    var isDeleting by rememberSaveable { mutableStateOf(false) }

    // Zoom & pan state
    var scale by remember { mutableFloatStateOf(1f) }
    var offsetX by remember { mutableFloatStateOf(0f) }
    var offsetY by remember { mutableFloatStateOf(0f) }

    // Full-res loading state for remote photos (thumbnail-first crossfade)
    var fullResLoaded by remember { mutableStateOf(false) }
    val fullResAlpha by animateFloatAsState(
        targetValue = if (fullResLoaded) 1f else 0f,
        animationSpec = tween(500),
        label = "fullres_crossfade"
    )

    val view = LocalView.current
    if (!view.isInEditMode) {
        DisposableEffect(Unit) {
            val insetsController = WindowCompat.getInsetsController(window, view)
            insetsController.isAppearanceLightStatusBars = false
            insetsController.hide(WindowInsetsCompat.Type.systemBars())
            insetsController.systemBarsBehavior =
                WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
            onDispose {
                insetsController.show(WindowInsetsCompat.Type.systemBars())
                insetsController.isAppearanceLightStatusBars = true
            }
        }
    }
    
    // Helper function to check if photo exists and handle download
    suspend fun handleDownloadClick(remoteId: String, forceDownload: Boolean = false) {
        android.util.Log.d("PhotoView", "Checking if photo exists for remoteId: $remoteId")
        val existingPhoto = DbHolder.database.photoDao().getByRemoteId(remoteId)
        
        if (existingPhoto != null && !forceDownload) {
            android.util.Log.d("PhotoView", "Photo exists at: ${existingPhoto.pathUri}")
            existingPhotoPath = existingPhoto.pathUri
            showDownloadDialog = true
        } else {
            android.util.Log.d("PhotoView", "Starting download for remoteId: $remoteId")
            WorkModule.InstantDownload(remoteId, forceDownload).enqueue()
            photoDownloadState = DownloadState.ENQUEUED
        }
    }

    // Helper function to handle upload
    fun handleUploadClick() {
        android.util.Log.d("PhotoView", "Starting upload for photo: ${photo.localId}")
        WorkModule.InstantUpload(photo.pathUri.toUri(), type = "manual_backup").enqueue()
        photoUploadState = UploadState.ENQUEUED
    }

    // Observe download worker
    androidx.compose.runtime.LaunchedEffect(photo.remoteId) {
        photo.remoteId?.let { remoteId ->
            WorkModule.observeWorkerByName("${WorkModule.DOWNLOADING_ID}:$remoteId").collectLatest { workInfoList ->
                workInfoList.firstOrNull()?.let { workInfo ->
                    android.util.Log.d("PhotoView", "Download worker state changed: ${workInfo.state}")
                    photoDownloadState = when (workInfo.state) {
                        WorkInfo.State.ENQUEUED -> DownloadState.ENQUEUED
                        WorkInfo.State.RUNNING -> DownloadState.DOWNLOADING
                        WorkInfo.State.SUCCEEDED -> DownloadState.DOWNLOADED
                        WorkInfo.State.FAILED -> DownloadState.FAILED
                        WorkInfo.State.BLOCKED -> DownloadState.BLOCKED
                        WorkInfo.State.CANCELLED -> DownloadState.FAILED
                    }
                }
            }
        }
    }

    // Observe upload worker
    androidx.compose.runtime.LaunchedEffect(photo.pathUri) {
        if (isOnlyOnDevice) {
            val uniqueWorkName = "${WorkModule.UPLOADING_ID}:${photo.pathUri.toUri().lastPathSegment}"
            WorkModule.observeWorkerByName(uniqueWorkName).collectLatest { workInfoList ->
                workInfoList.firstOrNull()?.let { workInfo ->
                    android.util.Log.d("PhotoView", "Upload worker state changed: ${workInfo.state}")
                    photoUploadState = when (workInfo.state) {
                        WorkInfo.State.ENQUEUED -> UploadState.ENQUEUED
                        WorkInfo.State.RUNNING -> UploadState.UPLOADING
                        WorkInfo.State.SUCCEEDED -> UploadState.UPLOADED
                        WorkInfo.State.FAILED -> UploadState.FAILED
                        WorkInfo.State.BLOCKED -> UploadState.BLOCKED
                        WorkInfo.State.CANCELLED -> UploadState.FAILED
                    }
                }
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        with(sharedTransitionScope) {
            if (isOnlyRemote) {
                // === REMOTE PHOTO: Thumbnail-first with crossfade to full-res ===
                val remotePhoto = photo.toRemotePhoto()

                // Layer 1: Thumbnail (immediate, from cache)
                AsyncImage(
                    imageLoader = ImageLoaderModule.thumbnailImageLoader,
                    model = ImageRequest.Builder(context)
                        .data(remotePhoto)
                        .memoryCacheKey("rt_thumb_${remotePhoto.remoteId}")
                        .diskCacheKey("rt_thumb_${remotePhoto.remoteId}")
                        .build(),
                    contentDescription = "Photo thumbnail",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .sharedElement(
                            rememberSharedContentState(key = "photo_${photo.remoteId}"),
                            animatedVisibilityScope = animatedVisibilityScope,
                            boundsTransform = { _, _ -> com.akslabs.cloudgallery.ui.theme.AnimationConstants.PremiumBoundsSpring }
                        )
                        .fillMaxSize()
                        .graphicsLayer {
                            scaleX = scale
                            scaleY = scale
                            translationX = offsetX
                            translationY = offsetY
                            // Hide thumbnail when full-res is loaded
                            alpha = 1f - fullResAlpha
                        }
                )

                // Layer 2: Full resolution (loads in background, crossfades in)
                SubcomposeAsyncImage(
                    imageLoader = ImageLoaderModule.remoteImageLoader,
                    model = ImageRequest.Builder(context)
                        .data(remotePhoto)
                        .build(),
                    contentDescription = "Photo full resolution",
                    contentScale = ContentScale.Fit,
                    loading = {
                        // Invisible placeholder while loading — thumbnail shows through
                    },
                    onSuccess = {
                        fullResLoaded = true
                    },
                    modifier = Modifier
                        .fillMaxSize()
                        .graphicsLayer {
                            scaleX = scale
                            scaleY = scale
                            translationX = offsetX
                            translationY = offsetY
                            alpha = fullResAlpha
                        }
                )

                // Gesture layer on top
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .pointerInput(Unit) {
                            detectTransformGestures { _, pan, zoom, _ ->
                                scale = (scale * zoom).coerceIn(1f, 5f)
                                if (scale > 1f) {
                                    offsetX += pan.x
                                    offsetY += pan.y
                                } else {
                                    offsetX = 0f
                                    offsetY = 0f
                                }
                            }
                        }
                        .pointerInput(Unit) {
                            detectTapGestures(
                                onTap = { showUi = !showUi },
                                onDoubleTap = {
                                    if (scale > 1.1f) {
                                        scale = 1f
                                        offsetX = 0f
                                        offsetY = 0f
                                    } else {
                                        scale = 3f
                                    }
                                }
                            )
                        }
                )
            } else {
                // === LOCAL PHOTO: existing behavior with zoom ===
                SubcomposeAsyncImage(
                    imageLoader = ImageLoaderModule.defaultImageLoader,
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(photo.pathUri)
                        .crossfade(500)
                        .build(),
                    contentDescription = "Photo",
                    contentScale = ContentScale.Fit,
                    loading = {
                        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                            androidx.compose.material3.ContainedLoadingIndicator()
                        }
                    },
                    modifier = Modifier
                        .sharedElement(
                            rememberSharedContentState(key = "photo_${photo.localId}"),
                            animatedVisibilityScope = animatedVisibilityScope,
                            boundsTransform = { _, _ -> com.akslabs.cloudgallery.ui.theme.AnimationConstants.PremiumBoundsSpring }
                        )
                        .fillMaxSize()
                        .graphicsLayer {
                            scaleX = scale
                            scaleY = scale
                            translationX = offsetX
                            translationY = offsetY
                        }
                        .pointerInput(Unit) {
                            detectTransformGestures { _, pan, zoom, _ ->
                                scale = (scale * zoom).coerceIn(1f, 5f)
                                if (scale > 1f) {
                                    offsetX += pan.x
                                    offsetY += pan.y
                                } else {
                                    offsetX = 0f
                                    offsetY = 0f
                                }
                            }
                        }
                        .pointerInput(Unit) {
                            detectTapGestures(
                                onTap = { showUi = !showUi },
                                onDoubleTap = {
                                    if (scale > 1.1f) {
                                        scale = 1f
                                        offsetX = 0f
                                        offsetY = 0f
                                    } else {
                                        scale = 3f
                                    }
                                }
                            )
                        }
                )
            }
        }

        // === BOTTOM ACTION BAR ===
        AnimatedVisibility(
            visible = showUi,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 32.dp),
            enter = fadeIn() + slideInVertically { it },
            exit = fadeOut() + slideOutVertically { it }
        ) {
            Row(
                modifier = Modifier
                    .clip(RoundedCornerShape(24.dp))
                    .background(MaterialTheme.colorScheme.surfaceContainer.copy(alpha = 0.92f))
                    .padding(horizontal = 8.dp, vertical = 4.dp),
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (isOnlyRemote) {
                    // Download button
                    IconButton(
                        onClick = {
                            photo.remoteId?.let { remoteId ->
                                scope.launch { handleDownloadClick(remoteId) }
                            }
                        },
                        enabled = photoDownloadState != DownloadState.DOWNLOADING && photoDownloadState != DownloadState.DOWNLOADED
                    ) {
                        Icon(
                            imageVector = when (photoDownloadState) {
                                DownloadState.DOWNLOADED -> Icons.Rounded.Done
                                DownloadState.DOWNLOADING, DownloadState.ENQUEUED -> Icons.Rounded.HourglassTop
                                else -> Icons.Rounded.CloudDownload
                            },
                            contentDescription = when (photoDownloadState) {
                                DownloadState.DOWNLOADED -> "Already downloaded"
                                DownloadState.DOWNLOADING -> "Downloading"
                                else -> "Download"
                            },
                            tint = if (photoDownloadState == DownloadState.DOWNLOADED)
                                MaterialTheme.colorScheme.primary
                            else MaterialTheme.colorScheme.onSurface
                        )
                    }
                }

                // Share button
                IconButton(onClick = {
                    scope.launch {
                        try {
                            if (isOnlyRemote && photo.remoteId != null) {
                                android.widget.Toast.makeText(context, "Preparing to share...", android.widget.Toast.LENGTH_SHORT).show()
                                val bytes = BotApi.getFile(photo.remoteId!!)
                                if (bytes != null) {
                                    val tempFile = java.io.File(context.cacheDir, "share_${System.currentTimeMillis()}.${photo.photoType}")
                                    tempFile.writeBytes(bytes)
                                    val shareUri = androidx.core.content.FileProvider.getUriForFile(
                                        context, "${context.packageName}.provider", tempFile
                                    )
                                    val shareIntent = android.content.Intent(android.content.Intent.ACTION_SEND).apply {
                                        type = "image/${photo.photoType}"
                                        putExtra(android.content.Intent.EXTRA_STREAM, shareUri)
                                        addFlags(android.content.Intent.FLAG_GRANT_READ_URI_PERMISSION)
                                    }
                                    context.startActivity(android.content.Intent.createChooser(shareIntent, "Share photo"))
                                } else {
                                    android.widget.Toast.makeText(context, "Failed to download photo", android.widget.Toast.LENGTH_SHORT).show()
                                }
                            } else {
                                val photoUri = android.net.Uri.parse(photo.pathUri)
                                val mimeType = context.contentResolver.getType(photoUri) ?: "image/*"
                                val shareIntent = android.content.Intent(android.content.Intent.ACTION_SEND).apply {
                                    type = mimeType
                                    putExtra(android.content.Intent.EXTRA_STREAM, photoUri)
                                    addFlags(android.content.Intent.FLAG_GRANT_READ_URI_PERMISSION)
                                }
                                context.startActivity(android.content.Intent.createChooser(shareIntent, "Share photo"))
                            }
                        } catch (e: Exception) {
                            android.widget.Toast.makeText(context, "Share failed: ${e.message}", android.widget.Toast.LENGTH_SHORT).show()
                        }
                    }
                }) {
                    Icon(
                        imageVector = Icons.Rounded.Share,
                        contentDescription = "Share",
                        tint = MaterialTheme.colorScheme.onSurface
                    )
                }

                // Delete button (cloud photos only)
                if (isOnlyRemote) {
                    IconButton(onClick = { showDeleteDialog = true }) {
                        Icon(
                            imageVector = Icons.Rounded.Delete,
                            contentDescription = "Delete",
                            tint = MaterialTheme.colorScheme.error
                        )
                    }
                }

                // Info button (cloud photos only)
                if (isOnlyRemote) {
                    IconButton(onClick = { showInfoDialog = true }) {
                        Icon(
                            imageVector = Icons.Rounded.Info,
                            contentDescription = "Info",
                            tint = MaterialTheme.colorScheme.onSurface
                        )
                    }
                }
            }
        }

        // Download state indicator for remote photos (replaces old FloatingDownloadBar)
        if (isOnlyRemote && showUi && (photoDownloadState == DownloadState.DOWNLOADING || photoDownloadState == DownloadState.ENQUEUED)) {
            Box(
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .padding(top = 48.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.9f))
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            ) {
                Text(
                    text = if (photoDownloadState == DownloadState.DOWNLOADING) "Downloading..." else "Download queued...",
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    style = MaterialTheme.typography.labelMedium
                )
            }
        }

        // Upload button for local photos (keep old behavior)
        AnimatedVisibility(
            visible = !isOnlyRemote && showUi,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 80.dp)
        ) {
            FloatingBottomBar(
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .background(MaterialTheme.colorScheme.primaryContainer),
                contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                uploadState = photoUploadState,
                onClickUpload = {
                    handleUploadClick()
                }
            )
        }
    }
    
    // Download confirmation dialog when photo already exists
    if (showDownloadDialog) {
        AlertDialog(
            onDismissRequest = { showDownloadDialog = false },
            title = { Text("Photo Already Downloaded") },
            text = { 
                Text("This photo is already downloaded to your device at:\n\n$existingPhotoPath\n\nWhat would you like to do?")
            },
            confirmButton = {
                Button(
                    onClick = {
                        showDownloadDialog = false
                        photo.remoteId?.let { remoteId ->
                            scope.launch {
                                handleDownloadClick(remoteId, forceDownload = true)
                            }
                        }
                    }
                ) {
                    Text("Download Anyway")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        showDownloadDialog = false
                        try {
                            val intent = android.content.Intent(android.content.Intent.ACTION_VIEW).apply {
                                setDataAndType(existingPhotoPath.toUri(), "image/*")
                                addFlags(android.content.Intent.FLAG_GRANT_READ_URI_PERMISSION)
                            }
                            context.startActivity(intent)
                        } catch (e: Exception) {
                            android.util.Log.e("PhotoView", "Failed to open in gallery: ${e.message}")
                            scope.launch {
                                context.toastFromMainThread("Unable to open in gallery")
                            }
                        }
                    }
                ) {
                    Text("View in Gallery")
                }
            }
        )
    }

    // Delete confirmation dialog
    if (showDeleteDialog) {
        AlertDialog(
            onDismissRequest = { if (!isDeleting) showDeleteDialog = false },
            title = { Text("Delete from Cloud?") },
            text = {
                Text("This will permanently delete this photo from your Telegram cloud storage. This cannot be undone.")
            },
            confirmButton = {
                Button(
                    onClick = {
                        isDeleting = true
                        scope.launch {
                            try {
                                val remoteId = photo.remoteId ?: return@launch
                                // Get RemotePhoto from DB for messageId
                                val remotePhoto = withContext(Dispatchers.IO) {
                                    DbHolder.database.remotePhotoDao().getById(remoteId)
                                }
                                val channelId = Preferences.getEncryptedLong(Preferences.channelId, 0L)
                                
                                // Delete message from Telegram
                                if (remotePhoto?.messageId != null && channelId != 0L) {
                                    withContext(Dispatchers.IO) {
                                        BotApi.deleteMessage(channelId, remotePhoto.messageId!!)
                                    }
                                }
                                
                                // Delete from local DB
                                withContext(Dispatchers.IO) {
                                    DbHolder.database.remotePhotoDao().delete(remoteId)
                                }
                                
                                android.widget.Toast.makeText(context, "Photo deleted from cloud", android.widget.Toast.LENGTH_SHORT).show()
                                showDeleteDialog = false
                                isDeleting = false
                                onDeletePhoto?.invoke()
                            } catch (e: Exception) {
                                android.util.Log.e("PhotoView", "Delete failed: ${e.message}", e)
                                android.widget.Toast.makeText(context, "Delete failed: ${e.message}", android.widget.Toast.LENGTH_SHORT).show()
                                isDeleting = false
                            }
                        }
                    },
                    enabled = !isDeleting,
                    colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.error
                    )
                ) {
                    Text(if (isDeleting) "Deleting..." else "Delete")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = { showDeleteDialog = false },
                    enabled = !isDeleting
                ) {
                    Text("Cancel")
                }
            }
        )
    }

    // Info dialog
    if (showInfoDialog) {
        val remotePhoto = photo.toRemotePhoto()
        val uploadDate = remember(remotePhoto.uploadedAt) {
            java.text.SimpleDateFormat("MMM d, yyyy 'at' h:mm a", java.util.Locale.getDefault())
                .format(java.util.Date(remotePhoto.uploadedAt))
        }
        AlertDialog(
            onDismissRequest = { showInfoDialog = false },
            title = { Text("Photo Info") },
            text = {
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text("File: ${remotePhoto.fileName ?: "Unknown"}")
                    Text("Type: ${remotePhoto.photoType}")
                    remotePhoto.fileSize?.let { size ->
                        val sizeStr = when {
                            size > 1024 * 1024 -> "%.1f MB".format(size / (1024.0 * 1024.0))
                            size > 1024 -> "%.1f KB".format(size / 1024.0)
                            else -> "$size bytes"
                        }
                        Text("Size: $sizeStr")
                    }
                    Text("Uploaded: $uploadDate")
                    Text("ID: ${remotePhoto.remoteId.take(20)}...")
                }
            },
            confirmButton = {
                TextButton(onClick = { showInfoDialog = false }) {
                    Text("Close")
                }
            }
        )
    }
}
