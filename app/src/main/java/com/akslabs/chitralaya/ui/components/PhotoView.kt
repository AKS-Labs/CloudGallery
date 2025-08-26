package com.akslabs.cloudgallery.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import androidx.work.WorkInfo
import coil.compose.AsyncImage
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest
import com.akslabs.cloudgallery.R
import com.akslabs.cloudgallery.data.localdb.DbHolder
import com.akslabs.cloudgallery.data.localdb.entities.Photo
import com.akslabs.cloudgallery.ui.main.screens.local.UploadState
import com.akslabs.cloudgallery.ui.main.screens.remote.DownloadState
import com.akslabs.cloudgallery.utils.coil.ImageLoaderModule
import com.akslabs.cloudgallery.utils.toastFromMainThread
import com.akslabs.cloudgallery.workers.WorkModule
import com.akslabs.cloudgallery.workers.WorkModule.UPLOADING_ID
import com.akslabs.cloudgallery.workers.WorkModule.DOWNLOADING_ID

import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@Composable
fun PhotoView(photo: Photo, isOnlyRemote: Boolean, showUiState: () -> MutableState<Boolean>) {
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
    
    // Dialog state for download confirmation when photo exists
    var showDownloadDialog by rememberSaveable { mutableStateOf(false) }
    var existingPhotoPath by rememberSaveable { mutableStateOf("") }
    
    // Helper function to check if photo exists and handle download
    suspend fun handleDownloadClick(remoteId: String, forceDownload: Boolean = false) {
        android.util.Log.d("PhotoView", "Checking if photo exists for remoteId: $remoteId")
        val existingPhoto = DbHolder.database.photoDao().getByRemoteId(remoteId)
        
        if (existingPhoto != null && !forceDownload) {
            android.util.Log.d("PhotoView", "Photo exists at: ${existingPhoto.pathUri}")
            existingPhotoPath = existingPhoto.pathUri
            showDownloadDialog = true
        } else {
            android.util.Log.d("PhotoView", "Photo doesn't exist or forcing download, starting download")
            WorkModule.InstantDownload(remoteId, forceDownload).enqueue()
            android.util.Log.d("PhotoView", "Download worker enqueued, starting observation")
            WorkModule.observeWorkerByName("$DOWNLOADING_ID:$remoteId")
                .collectLatest {
                    it.first().let { workInfo ->
                        android.util.Log.d("PhotoView", "Worker state changed: ${workInfo.state}")
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

    Box(
        Modifier
            .fillMaxSize()
            .background(Color.Black)
            .pointerInput(Unit) {
                detectTapGestures {
                    showUi = !showUi
                }
            },
        contentAlignment = Alignment.Center
    ) {
        val zoomState = rememberZoomState()

        val alpha by animateFloatAsState(
            targetValue = if (showUi) 0.5f else 0f,
            label = stringResource(R.string.backgroundalpha),
            animationSpec = tween(500)
        )
        AsyncImage(
            imageLoader = ImageLoaderModule.defaultImageLoader,
            model = photo.pathUri,
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .fillMaxSize()
                .blur(50.dp)
                .alpha(alpha)
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .zoomArea(zoomState),
            contentAlignment = Alignment.Center
        ) {
            if (!isOnlyRemote) {
                SubcomposeAsyncImage(
                    model = photo.pathUri,
                    contentDescription = stringResource(R.string.photo),
                    modifier = Modifier
                        .fillMaxSize()
                        .zoomImage(zoomState),
                    contentScale = ContentScale.Fit,
                    error = {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .aspectRatio(1f)
                                .background(MaterialTheme.colorScheme.primaryContainer),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                tint = MaterialTheme.colorScheme.onSurface,
                                imageVector = Icons.Rounded.Error,
                                contentDescription = stringResource(R.string.error),
                                modifier = Modifier
                                    .size(48.dp)
                                    .padding(16.dp)
                            )
                        }
                    }
                )
            } else {
                SubcomposeAsyncImage(
                    imageLoader = ImageLoaderModule.remoteImageLoader,
                    model = ImageRequest.Builder(context)
                        .data(photo.toRemotePhoto())
                        .placeholderMemoryCacheKey(photo.remoteId)
                        .memoryCacheKey(photo.remoteId)
                        .build(),
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .fillMaxSize()
                        .zoomImage(zoomState),
                    contentDescription = stringResource(id = R.string.photo),
                    loading = {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .aspectRatio(1f)
                                .background(MaterialTheme.colorScheme.primaryContainer),
                            contentAlignment = Alignment.Center
                        ) {
                            LoadAnimation()
                        }
                    },
                    error = {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .aspectRatio(1f)
                                .background(MaterialTheme.colorScheme.primaryContainer),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                tint = MaterialTheme.colorScheme.onSurface,
                                imageVector = Icons.Rounded.CloudOff,
                                contentDescription = stringResource(id = R.string.error),
                                modifier = Modifier
                                    .size(48.dp)
                                    .padding(16.dp)
                            )
                        }
                    }
                )
            }
            Column(
                Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Upload button for device photos
                AnimatedVisibility(
                    visible = !isOnlyRemote && showUi
                ) {
                    FloatingBottomBar(
                        modifier = Modifier
                            .padding(bottom = 30.dp)
                            .clip(RoundedCornerShape(16.dp))
                            .background(MaterialTheme.colorScheme.primaryContainer),
                        contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                        uploadState = photoUploadState,
                        onClickUpload = {
                            WorkModule.InstantUpload(photo.pathUri.toUri()).enqueue()
                            scope.launch {
                                WorkModule.observeWorkerByName("$UPLOADING_ID:${photo.localId}")
                                    .collectLatest {
                                        it.first().let { workInfo ->
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
                    )
                }
                
                // Download button for cloud photos
                AnimatedVisibility(
                    visible = isOnlyRemote && showUi
                ) {
                    FloatingDownloadBar(
                        modifier = Modifier
                            .padding(bottom = 30.dp)
                            .clip(RoundedCornerShape(16.dp))
                            .background(MaterialTheme.colorScheme.primaryContainer),
                        contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                        downloadState = photoDownloadState,
                        onClickDownload = {
                            android.util.Log.d("PhotoView", "Download button clicked!")
                            photo.remoteId?.let { remoteId ->
                                scope.launch {
                                    handleDownloadClick(remoteId)
                                }
                            } ?: android.util.Log.e("PhotoView", "No remoteId found for photo!")
                        }
                    )
                }
            }
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
                        // Try to open in gallery
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
}