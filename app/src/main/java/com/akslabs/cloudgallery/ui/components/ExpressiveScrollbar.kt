package com.akslabs.cloudgallery.ui.components

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.platform.LocalViewConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
    labelProvider: ((Int) -> String)? = null,
    indicatorColor: Color = MaterialTheme.colorScheme.primary,
    onDraggingChange: (Boolean) -> Unit = {}
) {
    val coroutineScope = rememberCoroutineScope()
    val haptic = LocalHapticFeedback.current
    val density = LocalDensity.current
    
    var isDragging by remember { mutableStateOf(false) }
    val isScrolling by remember { derivedStateOf { lazyGridState.isScrollInProgress } }
    var isVisible by remember { mutableStateOf(false) }
    
    // Spring physics for the thumb position
    val animatedProgress = remember { Animatable(0f) }
    
    // Auto-hide logic
    LaunchedEffect(isScrolling, isDragging) {
        if (isDragging) {
            isVisible = true
        } else if (isScrolling) {
            isVisible = true
        } else {
            delay(1500)
            isVisible = false
        }
    }

    LaunchedEffect(isDragging) {
        onDraggingChange(isDragging)
    }

    if (totalItemsCount <= 0 || columnCount <= 0) return

    val totalRows = (totalItemsCount + columnCount - 1) / columnCount
    
    // Update animated progress based on list state
    LaunchedEffect(lazyGridState.firstVisibleItemIndex, totalRows) {
        if (totalRows > 1 && !isDragging) {
            val currentRow = lazyGridState.firstVisibleItemIndex / columnCount
            val targetProgress = currentRow.toFloat() / (totalRows - 1).coerceAtLeast(1)
            animatedProgress.animateTo(
                targetValue = targetProgress,
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioNoBouncy,
                    stiffness = Spring.StiffnessLow
                )
            )
        }
    }

    val visibilityAlpha by animateFloatAsState(
        targetValue = if (isVisible) 1f else 0f,
        animationSpec = tween(300),
        label = "alpha"
    )
    
    val thumbScale by animateFloatAsState(
        targetValue = if (isDragging) 1.2f else 1f,
        animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy),
        label = "scale"
    )

    BoxWithConstraints(
        modifier = modifier
            .fillMaxHeight()
            .width(96.dp) // Even wider to accommodate the mega-pill
            .zIndex(100f)
            .padding(end = 6.dp)
    ) {
        val trackHeightPx = constraints.maxHeight.toFloat()
        val thumbHeightPx = with(density) { 56.dp.toPx() } // Slightly taller
        val maxOffset = trackHeightPx - thumbHeightPx
        
        if (trackHeightPx > thumbHeightPx && totalRows > 1) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .graphicsLayer { alpha = visibilityAlpha }
                    .pointerInput(totalRows, trackHeightPx) {
                        detectTapGestures(
                            onPress = { offset ->
                                isDragging = true
                                val progress = (offset.y / trackHeightPx).coerceIn(0f, 1f)
                                val targetRow = (progress * (totalRows - 1)).toInt()
                                val targetIndex = (targetRow * columnCount).coerceIn(0, totalItemsCount - 1)
                                
                                coroutineScope.launch {
                                    animatedProgress.snapTo(progress)
                                    lazyGridState.scrollToItem(targetIndex)
                                }
                                tryAwaitRelease()
                                isDragging = false
                            }
                        )
                    }
                    .pointerInput(totalRows, trackHeightPx) {
                        var verticalDragOffset = 0f
                        var lastTargetIndex = -1
                        detectDragGestures(
                            onDragStart = { offset -> 
                                isDragging = true
                                val currentThumbOffset = animatedProgress.value * maxOffset
                                verticalDragOffset = offset.y - currentThumbOffset
                            },
                            onDragEnd = { isDragging = false },
                            onDragCancel = { isDragging = false },
                            onDrag = { change, _ ->
                                change.consume()
                                val newThumbTop = (change.position.y - verticalDragOffset).coerceIn(0f, maxOffset)
                                val progress = if (maxOffset > 0) newThumbTop / maxOffset else 0f
                                
                                val targetRow = (progress * (totalRows - 1)).toInt()
                                val targetIndex = (targetRow * columnCount).coerceIn(0, totalItemsCount - 1)
                                
                                if (targetIndex != lastTargetIndex) {
                                    lastTargetIndex = targetIndex
                                    coroutineScope.launch {
                                        animatedProgress.snapTo(progress)
                                        lazyGridState.scrollToItem(targetIndex)
                                        
                                        if (targetIndex % (columnCount * 5) == 0) {
                                            haptic.performHapticFeedback(androidx.compose.ui.hapticfeedback.HapticFeedbackType.TextHandleMove)
                                        }
                                    }
                                } else {
                                    coroutineScope.launch {
                                        animatedProgress.snapTo(progress)
                                    }
                                }
                            }
                        )
                    }
            ) {
                if (isDragging && labelProvider != null) {
                    ScrollbarLabel(
                        progressProvider = { animatedProgress.value },
                        labelProvider = labelProvider,
                        totalItemsCount = totalItemsCount,
                        maxOffset = maxOffset,
                        thumbHeightPx = thumbHeightPx,
                        visibilityAlpha = visibilityAlpha,
                        density = density
                    )
                }

                // The Thumb
                Canvas(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .width(if (isDragging) 20.dp else 10.dp)
                        .height(56.dp)
                        .clip(CircleShape)
                        .graphicsLayer {
                            val currentThumbOffsetPx = animatedProgress.value * maxOffset
                            translationY = currentThumbOffsetPx
                            scaleX = thumbScale
                        }
                ) {
                    drawRoundRect(
                        color = indicatorColor,
                        size = Size(size.width * thumbScale, size.height),
                        cornerRadius = CornerRadius(size.width / 2f)
                    )
                }
            }
        }
    }
}

@Composable
private fun BoxScope.ScrollbarLabel(
    progressProvider: () -> Float,
    labelProvider: (Int) -> String,
    totalItemsCount: Int,
    maxOffset: Float,
    thumbHeightPx: Float,
    visibilityAlpha: Float,
    density: androidx.compose.ui.unit.Density
) {
    Surface(
        modifier = Modifier
            .align(Alignment.TopEnd)
            .offset { 
                val currentThumbOffsetPx = progressProvider() * maxOffset
                IntOffset(
                    x = with(density) { (-90.dp).toPx().roundToInt() }, 
                    y = (currentThumbOffsetPx + thumbHeightPx / 2 - with(density) { 24.dp.toPx() }).roundToInt()
                ) 
            }
            .graphicsLayer { alpha = visibilityAlpha }
            .wrapContentWidth(),
        shape = RoundedCornerShape(24.dp),
        color = MaterialTheme.colorScheme.primaryContainer,
        tonalElevation = 6.dp,
        shadowElevation = 8.dp
    ) {
        val currentLabel = remember(progressProvider(), totalItemsCount) {
            val index = (progressProvider() * (totalItemsCount - 1)).roundToInt()
            labelProvider(index)
        }
        Text(
            text = currentLabel,
            modifier = Modifier.padding(horizontal = 24.dp, vertical = 12.dp),
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Black,
            color = MaterialTheme.colorScheme.onPrimaryContainer,
            maxLines = 1,
            softWrap = false
        )
    }
}
