package com.akslabs.cloudgallery.ui.main.screens.local

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
    var selectedIndex by remember { mutableStateOf<Int?>(null) }

    // Get dynamic column count from preferences
    val columnCount = remember {
        Preferences.getInt(Preferences.gridColumnCountKey, Preferences.defaultGridColumnCount)
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
            if (localPhotos.loadState.refresh == LoadState.Loading) {
                LoadAnimation(modifier = Modifier.align(Alignment.Center))
            } else {
                LazyVerticalGrid(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(2.dp),
                    columns = GridCells.Fixed(columnCount),
                    verticalArrangement = Arrangement.spacedBy(4.dp),
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    itemsPaging(
                        items = localPhotos,
                        { it.localId }
                    ) { localPhoto, index ->
                        Box(
                            modifier = Modifier
                                .aspectRatio(1f)
                                .clip(RoundedCornerShape(12.dp))
                                .background(MaterialTheme.colorScheme.surfaceVariant)
                                .clickable {
                                    selectedIndex = index
                                },
                            contentAlignment = Alignment.Center
                        ) {
                            SubcomposeAsyncImage(
                                model = localPhoto?.pathUri,
                                contentDescription = stringResource(id = R.string.photo),
                                contentScale = ContentScale.Crop,
                                modifier = Modifier.fillMaxSize(),
                                error = {
                                    Icon(
                                        tint = MaterialTheme.colorScheme.onSurfaceVariant,
                                        imageVector = Icons.Rounded.BrokenImage,
                                        contentDescription = stringResource(
                                            id = R.string.load_error
                                        ),
                                        modifier = Modifier
                                            .size(20.dp)
                                    )
                                }
                            )
                        }
                    }
                }
            }
        selectedIndex?.let {
            PhotoPageView(
                initialPage = it,
                onlyRemotePhotos = false,
                photos = localPhotos.itemSnapshotList.items
            ) {
                selectedIndex = null
            }
        }
    }
}