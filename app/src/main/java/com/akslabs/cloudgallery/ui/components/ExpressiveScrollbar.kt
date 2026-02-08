package com.akslabs.cloudgallery.ui.components

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.math.absoluteValue
import kotlin.math.roundToInt

@Composable
fun ExpressiveScrollbar(
    lazyGridState: LazyGridState,
    totalItemsCount: Int,
    columnCount: Int,
    modifier: Modifier = Modifier,
    indicatorColor: Color = MaterialTheme.colorScheme.primary,
    trackColor: Color = Color.Transparent, 
    thumbWidth: Dp = 8.dp,
    thumbHeight: Dp = 48.dp,
    thumbExpandedWidth: Dp = 20.dp,
    paddingEnd: Dp = 4.dp,
    onDraggingChange: (Boolean) -> Unit = {}
) {
    val coroutineScope = rememberCoroutineScope()
    val haptic = LocalHapticFeedback.current
    
    // State to track if the user is currently dragging the scrollbar
    var isDragging by remember { mutableStateOf(false) }
    
    // Helper to detect if the list is scrolling (user fling or drag)
    val isScrolling by remember { derivedStateOf { lazyGridState.isScrollInProgress } }
    
    // Visibility state: Show if scrolling OR dragging
    var isVisible by remember { mutableStateOf(false) }
    
    // Auto-hide logic
    LaunchedEffect(isScrolling, isDragging) {
        if (isDragging) {
            isVisible = true
        } else if (isScrolling) {
            isVisible = true
        } else {
            delay(1500) // Keep visible for 1.5s after stop
            isVisible = false
        }
    }

    // Sync isDragging with callback
    LaunchedEffect(isDragging) {
        onDraggingChange(isDragging)
    }

    // Calculations for scrollbar position
    val firstVisibleItemIndex by remember { derivedStateOf { lazyGridState.firstVisibleItemIndex } }
    
    // Avoid division by zero
    if (totalItemsCount <= 0 || columnCount <= 0) return

    BoxWithConstraints(
        modifier = modifier
            .fillMaxHeight()
            .width(thumbExpandedWidth + 32.dp) // Touch target area wider than visual
            .zIndex(10f)
            .padding(end = paddingEnd)
    ) {
        val density = LocalDensity.current
        val trackHeightPx = constraints.maxHeight.toFloat()
        val thumbHeightPx = with(density) { thumbHeight.toPx() }
        
        // Effective total rows
        // Note: We use a simplified row calculation. For perfect mapping with headers, 
        // passing totalItemsCount as "effective items" (headers + photos) is crucial.
        val totalRows = (totalItemsCount + columnCount - 1) / columnCount
        
        // Calculate the visual offset of the thumb based on List state (Source of Truth)
        val viewportOffsetPx by remember {
            derivedStateOf {
                if (totalRows <= 0) return@derivedStateOf 0f
                
                // Current scroll progress (0f..1f)
                // We use firstVisibleItemIndex as a rough proxy. 
                // Adding firstVisibleItemScrollOffset / itemHeight would be more precise but requires consistent item heights.
                val currentRow = firstVisibleItemIndex / columnCount
                val scrollProgress = currentRow.toFloat() / (totalRows - 1).coerceAtLeast(1)
                
                // Map 0..1 to 0..(trackHeight - thumbHeight)
                scrollProgress * (trackHeightPx - thumbHeightPx)
            }
        }

        // Animation states
        val alpha by animateFloatAsState(
            targetValue = if (isVisible) 1f else 0f,
            animationSpec = tween(durationMillis = 300),
            label = "alpha"
        )
        
        val currentThumbWidth by animateDpAsState(
            targetValue = if (isDragging) thumbExpandedWidth else thumbWidth,
            animationSpec = tween(durationMillis = 200),
            label = "width"
        )

        // Only show if there's enough content to scroll
        if (trackHeightPx > thumbHeightPx && totalRows > 1) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .alpha(alpha)
                    // Touch input handling
                    .pointerInput(totalRows, trackHeightPx, thumbHeightPx) {
                        detectTapGestures(
                            onPress = { offset ->
                                isDragging = true
                                // Calculate target index immediately on tap
                                val progress = (offset.y / trackHeightPx).coerceIn(0f, 1f)
                                val targetRow = (progress * (totalRows - 1)).roundToInt()
                                val targetIndex = (targetRow * columnCount).coerceIn(0, totalItemsCount - 1)
                                
                                coroutineScope.launch {
                                    lazyGridState.scrollToItem(targetIndex)
                                }
                                tryAwaitRelease()
                                isDragging = false
                            }
                        )
                    }
                    .pointerInput(totalRows, trackHeightPx, thumbHeightPx) {
                        detectDragGestures(
                            onDragStart = { isDragging = true },
                            onDragEnd = { isDragging = false },
                            onDragCancel = { isDragging = false },
                            onDrag = { change, _ ->
                                change.consume()
                                val y = change.position.y
                                val progress = (y / trackHeightPx).coerceIn(0f, 1f)
                                
                                val targetRow = (progress * (totalRows - 1)).roundToInt()
                                val targetIndex = (targetRow * columnCount).coerceIn(0, totalItemsCount - 1)
                                
                                coroutineScope.launch {
                                    lazyGridState.scrollToItem(targetIndex)
                                }
                            }
                        )
                    }
            ) {
                // The Thumb
                // We use Modifier.offset to position it.
                // When dragging, we could use the raw touch Y for "stick to finger" feel, 
                // but relying on the List state (viewportOffsetPx) ensures the thumb 
                // always represents the REAL list position, preventing desync.
                // Since we scrollToItem instantly, usage of viewportOffsetPx feels responsive 
                // AND keeps the thumb effectively under the finger (modulo list quantization).
                
                Canvas(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .width(currentThumbWidth)
                        .offset { IntOffset(0, viewportOffsetPx.roundToInt()) }
                ) {
                    drawRoundRect(
                        color = indicatorColor,
                        size = Size(size.width, thumbHeightPx),
                        cornerRadius = CornerRadius(size.width / 2f)
                    )
                }
            }
        }
    }
}
