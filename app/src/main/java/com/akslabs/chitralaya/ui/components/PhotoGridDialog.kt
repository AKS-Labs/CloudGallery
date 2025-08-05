package com.akslabs.cloudgallery.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.CloudOff
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest
import com.akslabs.cloudgallery.R
import com.akslabs.cloudgallery.utils.coil.ImageLoaderModule

@Composable
fun PhotoGridDialog(
    visible: Boolean,
    idList: List<String>,
    modifier: Modifier = Modifier,
    onDismiss: () -> Unit,
) {
    val context = LocalContext.current
    AnimatedVisibility(visible = visible) {
        Dialog(onDismissRequest = onDismiss) {
            Column(
                modifier = modifier
                    .background(color = MaterialTheme.colorScheme.surfaceVariant)
                    .height(400.dp)
                    .width(225.dp)
            ) {
                LazyVerticalGrid(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(2.dp),
                    columns = GridCells.Fixed(4),
                    verticalArrangement = Arrangement.spacedBy(2.dp),
                    horizontalArrangement = Arrangement.spacedBy(2.dp)
                ) {
                    items(idList) { id ->
                        Box(
                            modifier = Modifier
                                .height(50.dp)
                                .background(MaterialTheme.colorScheme.surface)
                        ) {
                            SubcomposeAsyncImage(
                                imageLoader = ImageLoaderModule.remoteImageLoader,
                                model = ImageRequest.Builder(context)
                                    .data(id)
                                    .placeholderMemoryCacheKey(id)
                                    .memoryCacheKey(id)
                                    .build(),
                                contentScale = ContentScale.Crop,
                                modifier = Modifier.fillMaxSize(),
                                contentDescription = context.getString(R.string.photo),
                                loading = {
                                    LoadAnimation()
                                },
                                error = {
                                    Icon(
                                        tint = MaterialTheme.colorScheme.onSurfaceVariant,
                                        imageVector = Icons.Rounded.CloudOff,
                                        contentDescription = stringResource(R.string.load_error),
                                        modifier = Modifier
                                            .size(20.dp)
                                    )
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}