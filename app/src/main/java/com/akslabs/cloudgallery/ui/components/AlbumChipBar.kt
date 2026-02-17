package com.akslabs.cloudgallery.ui.components

// ──────────────────────────────────────────────────────────────────────────────
// AlbumChipBar — Replication of the ImageToolbox MediaPicker album chip bar.
//
// Reference mapping:
//   Reference `Album.id`        → AlbumInfo.id
//   Reference `Album.label`     → AlbumInfo.label
//   Reference `Album.uri`       → AlbumInfo.coverUri
//   Reference `Album.count`     → AlbumInfo.count
//   Reference `selectedAlbumIndex` → selectedAlbumId
//   Reference `showAlbumThumbnail` → showThumbnails (expand/collapse toggle)
//   Reference `EnhancedChip`    → FilterChip (Material 3)
//   Reference `Picture`         → AsyncImage (Coil)
//   Reference `AutoSizeText`    → Text with headlineLarge style
//   Reference `enhancedFlingBehavior` → default LazyRow fling
//   Reference `fadingEdges`     → fadingEdges modifier (custom)
//   Reference `BoxAnimatedVisibility` → AnimatedVisibility (Compose)
//   Reference `animateContentSizeNoClip` → Modifier.animateContentSize
//   Reference `drawHorizontalStroke` → HorizontalDivider
// ──────────────────────────────────────────────────────────────────────────────

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.CompositingStrategy
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.coerceAtLeast
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.offset
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Shadow
import coil.compose.AsyncImage
import com.akslabs.cloudgallery.data.mediastore.AlbumInfo

/**
 * A horizontal bar of album filter chips, matching the reference ImageToolbox design.
 *
 * Collapsed state: compact text-only chips.
 * Expanded state:  chips show album thumbnail with photo-count overlay.
 *
 * @param albums          List of albums (including "All" at index 0)
 * @param selectedAlbumId Currently selected album ID (-1L = All)
 * @param onAlbumSelected Callback when an album chip is tapped
 * @param modifier        Modifier for the outer container
 */
@Composable
fun AlbumChipBar(
    albums: List<AlbumInfo>,
    selectedAlbumId: Long,
    onAlbumSelected: (Long) -> Unit,
    modifier: Modifier = Modifier
) {
    // Maps to reference `showAlbumThumbnail` — toggles expanded/collapsed
    var showThumbnails by rememberSaveable { mutableStateOf(false) }

    // Only render when there are multiple albums (matches reference: `albums.size > 1`)
    if (albums.size <= 1) return

    Column(modifier = modifier.fillMaxWidth()) {
        val listState = rememberLazyListState()

        Row(
            modifier = Modifier
                .fillMaxWidth()
                // Match app bar background
                .background(MaterialTheme.colorScheme.surface),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // ── LazyRow of album chips ──────────────────────────────────
            // Maps to reference LazyRow with fadingEdges, spacing, and contentPadding
            LazyRow(
                modifier = Modifier
                    .weight(1f)
                    .fadingEdges(listState)
                    .padding(vertical = 0.dp),
                horizontalArrangement = Arrangement.spacedBy(6.dp),
                contentPadding = PaddingValues(start = 17.dp, end = 8.dp),
                state = listState
            ) {
                items(
                    items = albums,
                    key = AlbumInfo::toString
                ) { album ->
                    val selected = selectedAlbumId == album.id
                    // Maps to reference `isImageVisible = showAlbumThumbnail && album.uri.isNotEmpty()`
                    val isImageVisible = showThumbnails && album.coverUri.isNotEmpty()

                    // Maps to reference `animateDpAsState` for content padding
                    val horizontalPadding by animateDpAsState(
                        targetValue = if (isImageVisible) 0.dp else 0.dp,
                        label = "chip_h_padding"
                    )
                    val verticalPadding by animateDpAsState(
                        targetValue = if (isImageVisible) 8.dp else 0.dp,
                        label = "chip_v_padding"
                    )

                    // Maps to reference `EnhancedChip` → M3 FilterChip
                    FilterChip(
                        selected = selected,
                        onClick = { onAlbumSelected(album.id) },
                        label = {
                            // Maps to reference Column with animateContentSizeNoClip
                            Column(
                                modifier = Modifier
                                    .animateContentSize(alignment = Alignment.Center)
                                    .padding(
                                        horizontal = horizontalPadding,
                                        vertical = verticalPadding
                                    )
                                    .then(
                                        // Maps to reference: fixed height filler for albums with no thumbnail
                                        if (showThumbnails && album.coverUri.isEmpty()) {
                                            Modifier.height(140.dp)
                                        } else Modifier
                                    ),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                // ── Label text ──────────────────────────────────
                                // Maps to reference `Text(text = title, ...)`
                                val title = if (album.id == -1L) "All" else album.label
                                var measuredWidth by remember { mutableStateOf(1.dp) }
                                val density = LocalDensity.current

                                Text(
                                    text = title,
                                    modifier = Modifier.onSizeChanged {
                                        measuredWidth = with(density) {
                                            it.width.toDp().coerceAtLeast(100.dp)
                                        }
                                    }
                                )

                                // ── Expanded thumbnail + count overlay ──────────
                                // Maps to reference `BoxAnimatedVisibility(visible = isImageVisible, ...)`
                                // Wrapped in Box to avoid ColumnScope.AnimatedVisibility implicit receiver
                                Box {
                                    androidx.compose.animation.AnimatedVisibility(
                                        visible = isImageVisible,
                                        enter = fadeIn() + expandVertically(),
                                        exit = fadeOut() + shrinkVertically()
                                    ) {
                                        Box {
                                            // Maps to reference inner `BoxAnimatedVisibility(visible = width > 1.dp, ...)`
                                            androidx.compose.animation.AnimatedVisibility(
                                                visible = measuredWidth > 1.dp,
                                                enter = fadeIn() + scaleIn(),
                                                exit = fadeOut() + scaleOut()
                                            ) {
                                                // Maps to reference `Picture(model = album.uri, ...)`
                                                AsyncImage(
                                                    model = album.coverUri,
                                                    contentDescription = album.label,
                                                    contentScale = ContentScale.Crop,
                                                    modifier = Modifier
                                                        .padding(top = 2.dp)
                                                        .height(100.dp)
                                                        .width(measuredWidth)
                                                        .clip(RoundedCornerShape(12.dp))
                                                )
                                            }

                                            // Maps to reference semi-transparent overlay with count
                                            Box(
                                                modifier = Modifier
                                                    .padding(top = 2.dp)
                                                    .height(100.dp)
                                                    .width(measuredWidth)
                                                    .clip(RoundedCornerShape(12.dp))
                                                    .background(
                                                        // Removed whitish tint, use subtle dark overlay for text readability
                                                        Color.Black.copy(alpha = 0.0f)
                                                    ),
                                                contentAlignment = Alignment.Center
                                            ) {
                                                // Maps to reference `AutoSizeText(text = album.count.toString(), ...)`
                                                Text(
                                                    text = album.count.toString(),
                                                    style = MaterialTheme.typography.headlineLarge.copy(
                                                        fontSize = 20.sp,
                                                        color = MaterialTheme.colorScheme.onSecondaryContainer,
                                                        fontWeight = FontWeight.Bold,
//                                                        shadow = Shadow(
//                                                            color = Color.Black.copy(alpha = 0.6f),
//                                                            offset = Offset(0f, 2f),
//                                                            blurRadius = 6f
//                                                        )

                                                    )

                                                )
                                            }
                                        }
                                    }
                                }
                            }
                        },
                        shape = RoundedCornerShape(24.dp),
                        colors = FilterChipDefaults.filterChipColors(
                            // Maps to reference `selectedColor = secondaryContainer`
                            selectedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                            selectedLabelColor = MaterialTheme.colorScheme.onSecondaryContainer,
                            // Maps to reference `unselectedColor = surfaceContainerHigh`
                            containerColor = MaterialTheme.colorScheme.surfaceContainerHigh,
                            labelColor = MaterialTheme.colorScheme.onSurfaceVariant
                        ),
                        border = null
                    )
                }
            }

            // ── Expand/collapse toggle ──────────────────────────────────
            // Maps to reference `EnhancedIconButton(onClick = { showAlbumThumbnail = !showAlbumThumbnail })`
            IconButton(
                onClick = { showThumbnails = !showThumbnails },
                modifier = Modifier
                    .padding(end = 4.dp)
                    .then(
                        if (showThumbnails) Modifier.background(
                            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.1f),
                            shape = CircleShape
                        ) else Modifier
                    )
            ) {
                // Maps to reference `animateFloatAsState(if (showAlbumThumbnail) 180f else 0f)`
                val rotation by animateFloatAsState(
                    targetValue = if (showThumbnails) 180f else 0f,
                    label = "arrow_rotation"
                )
                Icon(
                    imageVector = Icons.Rounded.KeyboardArrowDown,
                    contentDescription = if (showThumbnails) "Collapse albums" else "Expand albums",
                    modifier = Modifier.rotate(rotation)
                )
            }
        }
    }
}

// ──────────────────────────────────────────────────────────────────────────────
// fadingEdges — Custom modifier replicating the reference `fadingEdges(listState)`
// Draws horizontal fade-out gradients at the start and end of a LazyRow.
// ──────────────────────────────────────────────────────────────────────────────
private fun Modifier.fadingEdges(
    listState: LazyListState,
    edgeWidth: Float = 48f
): Modifier = this
    .graphicsLayer(compositingStrategy = CompositingStrategy.Offscreen)
    .drawWithContent {
    drawContent()

    val layoutInfo = listState.layoutInfo
    val totalItems = layoutInfo.totalItemsCount
    val visibleItems = layoutInfo.visibleItemsInfo

    if (visibleItems.isEmpty() || totalItems <= 1) return@drawWithContent

    // Fade at start when scrolled past the first item
    val firstVisible = visibleItems.first()
    val startAlpha = if (firstVisible.index > 0 || firstVisible.offset < 0) 1f else {
        ((-firstVisible.offset).toFloat() / edgeWidth).coerceIn(0f, 1f)
    }
    if (startAlpha > 0f) {
        drawRect(
            brush = Brush.horizontalGradient(
                colors = listOf(Color.Transparent, Color.Black),
                startX = 0f,
                endX = edgeWidth
            ),
            blendMode = androidx.compose.ui.graphics.BlendMode.DstIn
        )
    }

    // Fade at end when there are items not yet visible
    val lastVisible = visibleItems.last()
    val isLastFullyVisible = lastVisible.index == totalItems - 1 &&
            (lastVisible.offset + lastVisible.size) <= layoutInfo.viewportEndOffset
    if (!isLastFullyVisible) {
        drawRect(
            brush = Brush.horizontalGradient(
                colors = listOf(Color.Black, Color.Transparent),
                startX = size.width - edgeWidth,
                endX = size.width
            ),
            blendMode = androidx.compose.ui.graphics.BlendMode.DstIn
        )
    }
}
