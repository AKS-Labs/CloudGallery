package com.akslabs.cloudgallery.ui.main.screens.trash

import android.text.format.Formatter
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DeleteForever
import androidx.compose.material.icons.filled.Restore
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.akslabs.cloudgallery.ui.main.screens.remote.CloudPhotoItem
import com.akslabs.cloudgallery.data.localdb.entities.RemotePhoto

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TrashBinScreen(
    viewModel: TrashViewModel = viewModel()
) {
    val deletedPhotos = viewModel.deletedPhotosFlow.collectAsLazyPagingItems()
    val totalSize by viewModel.totalSize.collectAsState()
    val context = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text("Trash Bin")
                        Text(
                            text = "Total Size: ${Formatter.formatFileSize(context, totalSize)}",
                            style = MaterialTheme.typography.labelMedium
                        )
                    }
                }
            )
        }
    ) { padding ->
        if (deletedPhotos.itemCount == 0) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text("Trash is empty")
            }
        } else {
            LazyVerticalGrid(
                columns = GridCells.Adaptive(100.dp),
                contentPadding = PaddingValues(4.dp),
                modifier = Modifier.padding(padding)
            ) {
                items(deletedPhotos.itemCount) { index ->
                    val photo = deletedPhotos[index]
                    if (photo != null) {
                        // We reuse CloudPhotoItem but need to map DeletedPhoto to RemotePhoto for display
                        // Or create a simple item. Let's reuse CloudPhotoItem logic or similar.
                        // Since CloudPhotoItem expects RemotePhoto, let's map it temporarily.
                        val remotePhoto = RemotePhoto(
                            remoteId = photo.remoteId,
                            photoType = photo.photoType,
                            fileName = photo.fileName,
                            fileSize = photo.fileSize,
                            uploadedAt = photo.uploadedAt
                        )
                        
                        Box {
                            CloudPhotoItem(
                                remotePhoto = remotePhoto,
                                index = index,
                                isSelected = false
                            )
                            // Overlay actions
                            Column(modifier = Modifier.align(Alignment.BottomEnd)) {
                                IconButton(onClick = { viewModel.restore(photo) }) {
                                    Icon(Icons.Default.Restore, "Restore", tint = MaterialTheme.colorScheme.primary)
                                }
                                IconButton(onClick = { viewModel.permanentlyDelete(photo) }) {
                                    Icon(Icons.Default.DeleteForever, "Delete", tint = MaterialTheme.colorScheme.error)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
