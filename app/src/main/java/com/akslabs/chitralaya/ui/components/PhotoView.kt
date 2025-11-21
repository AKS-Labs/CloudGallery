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
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.SideEffect
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
import android.app.Activity
import android.content.Context
import android.content.ContextWrapper

import android.view.Window

@Composable
fun PhotoView(
    photo: Photo,
    isOnlyRemote: Boolean,
    showUiState: () -> MutableState<Boolean>,
    window: Window
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
    
    // Dialog state for download confirmation when photo exists
    var showDownloadDialog by rememberSaveable { mutableStateOf(false) }
    var existingPhotoPath by rememberSaveable { mutableStateOf("") }


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
        WorkModule.InstantUpload(photo.pathUri.toUri()).enqueue()
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
        SubcomposeAsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(if (isOnlyRemote) photo.toRemotePhoto() else photo.pathUri)
                .crossfade(true)
                .build(),
            contentDescription = "Photo",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .fillMaxSize()
                .pointerInput(Unit) {
                    detectTapGestures(
                        onTap = { showUi = !showUi }
                    )
                }
        )

        // Download button for cloud photos
        AnimatedVisibility(
            visible = isOnlyRemote && showUi,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 80.dp)
        ) {
            FloatingDownloadBar(
                modifier = Modifier
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

        // Upload button for local photos
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