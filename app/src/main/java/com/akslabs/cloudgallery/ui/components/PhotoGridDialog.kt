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
import androidx.compose.material.icons.rounded.Image
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.graphicsLayer
import coil.compose.AsyncImage
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest
import coil.size.Size
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
                val state = androidx.compose.foundation.lazy.grid.rememberLazyGridState()
                
                Box(modifier = Modifier.fillMaxSize()) {
                    LazyVerticalGrid(
                        state = state,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(2.dp),
                        columns = GridCells.Fixed(4),
                        verticalArrangement = Arrangement.spacedBy(2.dp),
                        horizontalArrangement = Arrangement.spacedBy(2.dp)
                    ) {
                        itemsIndexed(idList) { index, id ->
                            // Entrance animation state
                            var isVisible by remember { mutableStateOf(false) }
                            LaunchedEffect(Unit) {
                                isVisible = true
                            }

                            val entryScale by animateFloatAsState(
                                targetValue = if (isVisible) 1f else 0.85f,
                                animationSpec = spring(
                                    dampingRatio = Spring.DampingRatioMediumBouncy,
                                    stiffness = Spring.StiffnessLow
                                ),
                                label = "entry_scale"
                            )

                            val entryAlpha by animateFloatAsState(
                                targetValue = if (isVisible) 1f else 0f,
                                animationSpec = tween(durationMillis = 300 + (index % 12) * 30),
                                label = "entry_alpha"
                            )

                            Box(
                                modifier = Modifier
                                    .height(50.dp)
                                .graphicsLayer {
                                    scaleX = entryScale
                                    scaleY = entryScale
                                    // Removed alpha = entryAlpha to keep placeholder visible
                                }
                                .clip(RoundedCornerShape(12.dp))
                                .background(MaterialTheme.colorScheme.surfaceVariant)
                        ) {
                            // Visual Placeholder (Icon)
                            Icon(
                                imageVector = Icons.Rounded.Image,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.2f),
                                modifier = Modifier.size(24.dp)
                            )

                            AsyncImage(
                                imageLoader = ImageLoaderModule.remoteImageLoader,
                                model = ImageRequest.Builder(context)
                                    .data(id)
                                    .size(coil.size.Size(100, 100))
                                    .placeholderMemoryCacheKey(id)
                                    .memoryCacheKey(id)
                                    .crossfade(200)
                                    .allowRgb565(true)
                                    .build(),
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .fillMaxSize()
                                    .graphicsLayer {
                                        alpha = entryAlpha
                                    },
                                contentDescription = context.getString(R.string.photo)
                            )
                        }
                        }
                    }
                    
                    ExpressiveScrollbar(
                        lazyGridState = state,
                        totalRows = (idList.size + 3) / 4,
                        modifier = Modifier.align(androidx.compose.ui.Alignment.CenterEnd),
                        labelProvider = { index -> "${index + 1} / ${idList.size}" }
                    )
                }
            }
        }
    }
}
