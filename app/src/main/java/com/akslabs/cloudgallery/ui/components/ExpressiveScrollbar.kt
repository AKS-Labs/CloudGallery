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
    totalRows: Int,
    modifier: Modifier = Modifier,
    labelProvider: ((Int) -> String)? = null,
    indicatorColor: Color = MaterialTheme.colorScheme.primaryContainer,
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

    if (totalRows <= 1) return

    // State for immediate drag responsiveness - Using simple remembers to avoid boxing overhead
    var rawDragOffset by remember { mutableFloatStateOf(0f) }
    var useRawOffset by remember { mutableStateOf(false) }
    
    // Channel for conflated scroll updates to prevent main thread saturation (ANR)
    val scrollChannel = remember { kotlinx.coroutines.channels.Channel<Int>(kotlinx.coroutines.channels.Channel.CONFLATED) }
    
    // Collector for throttled scroll updates
    LaunchedEffect(scrollChannel) {
        for (targetIndex in scrollChannel) {
            lazyGridState.scrollToItem(targetIndex)
            // Sync animated progress in background without blocking the drag loop
            val progress = (targetIndex.toFloat() / lazyGridState.layoutInfo.totalItemsCount.coerceAtLeast(1))
            animatedProgress.snapTo(progress)
        }
    }

    // Update animated progress based on list state when NOT dragging
    LaunchedEffect(lazyGridState.firstVisibleItemIndex) {
        if (!isDragging) {
            val firstVisibleItem = lazyGridState.layoutInfo.visibleItemsInfo.firstOrNull()
            if (firstVisibleItem != null) {
                val progress = (firstVisibleItem.index.toFloat() / lazyGridState.layoutInfo.totalItemsCount.coerceAtLeast(1))
                    .coerceIn(0f, 1f)
                
                animatedProgress.animateTo(
                    targetValue = progress,
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioNoBouncy,
                        stiffness = Spring.StiffnessLow
                    )
                )
            }
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
            .width(52.dp) // Even tighter
            .zIndex(100f)
            .padding(end = 1.dp) 
    ) {
        val trackHeightPx = constraints.maxHeight.toFloat()
        val thumbHeightPx = with(density) { 56.dp.toPx() }
        val maxOffset = trackHeightPx - thumbHeightPx
        
        if (trackHeightPx > thumbHeightPx) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .graphicsLayer { alpha = visibilityAlpha }
                    .pointerInput(totalRows, trackHeightPx) {
                        detectTapGestures(
                            onPress = { offset ->
                                isDragging = true
                                useRawOffset = true
                                val progress = (offset.y / trackHeightPx.coerceAtLeast(1f)).coerceIn(0f, 1f)
                                rawDragOffset = (progress * maxOffset)
                                
                                val totalItems = lazyGridState.layoutInfo.totalItemsCount
                                if (totalItems > 0) {
                                    val targetIndex = (progress * (totalItems - 1)).toInt().coerceIn(0, totalItems - 1)
                                    scrollChannel.trySend(targetIndex)
                                }
                                tryAwaitRelease()
                                isDragging = false
                                useRawOffset = false
                            }
                        )
                    }
                    .pointerInput(totalRows, trackHeightPx) {
                        var verticalDragOffset = 0f
                        var lastTargetRow = -1
                        detectDragGestures(
                            onDragStart = { offset -> 
                                isDragging = true
                                useRawOffset = true
                                val currentThumbOffset = animatedProgress.value * maxOffset
                                verticalDragOffset = offset.y - currentThumbOffset
                                rawDragOffset = currentThumbOffset
                            },
                            onDragEnd = { 
                                isDragging = false
                                useRawOffset = false
                            },
                            onDragCancel = { 
                                isDragging = false
                                useRawOffset = false
                            },
                            onDrag = { change, _ ->
                                change.consume()
                                val newThumbTop = (change.position.y - verticalDragOffset).coerceIn(0f, maxOffset.coerceAtLeast(1f))
                                rawDragOffset = newThumbTop // ZERO-OVERHEAD tracking
                                
                                val progress = if (maxOffset > 0) newThumbTop / maxOffset else 0f
                                val totalItems = lazyGridState.layoutInfo.totalItemsCount
                                
                                if (totalItems > 0) {
                                    val targetIndex = (progress * (totalItems - 1)).toInt().coerceIn(0, totalItems - 1)
                                    val targetRow = (progress * (totalRows - 1)).toInt().coerceIn(0, totalRows - 1)
                                    
                                    // Throttled scroll update via conflated channel (Safe for Main Thread)
                                    scrollChannel.trySend(targetIndex)
                                    
                                    if (targetRow != lastTargetRow) {
                                        lastTargetRow = targetRow
                                        if (targetRow % 10 == 0) {
                                            haptic.performHapticFeedback(androidx.compose.ui.hapticfeedback.HapticFeedbackType.TextHandleMove)
                                        }
                                    }
                                }
                            }
                        )
                    }
            ) {
                val currentProgress = if (useRawOffset) rawDragOffset / maxOffset.coerceAtLeast(1f) else animatedProgress.value

                if (isDragging && labelProvider != null) {
                    ScrollbarLabel(
                        progressProvider = { currentProgress },
                        labelProvider = labelProvider,
                        totalItemsCount = lazyGridState.layoutInfo.totalItemsCount,
                        maxOffset = maxOffset,
                        thumbHeightPx = thumbHeightPx,
                        visibilityAlpha = visibilityAlpha,
                        density = density
                    )
                }

                // The Thumb - Glued to finger with absolute zero lag
                Canvas(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .width(7.dp) // Sleek 7dp
                        .height(56.dp)
                        .graphicsLayer {
                            val thumbOffset = if (useRawOffset) rawDragOffset else (animatedProgress.value * maxOffset)
                            translationY = thumbOffset.coerceIn(0f, maxOffset)
                            scaleX = thumbScale
                            scaleY = thumbScale
                            alpha = visibilityAlpha
                            transformOrigin = androidx.compose.ui.graphics.TransformOrigin(1f, 0.5f)
                        }
                ) {
                    drawRoundRect(
                        color = indicatorColor.copy(alpha = 1f),
                        size = size,
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
                    x = with(density) { (-70.dp).toPx().roundToInt() }, // Closer to thumb
                    y = (currentThumbOffsetPx + thumbHeightPx / 2 - with(density) { 20.dp.toPx() }).roundToInt()
                ) 
            }
            .graphicsLayer { alpha = visibilityAlpha }
            .wrapContentWidth(),
        shape = RoundedCornerShape(16.dp), // More compact
        color = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.95f),
        tonalElevation = 4.dp,
        shadowElevation = 6.dp
    ) {
        // Debounce label updates slightly to prevent flickering during rapid movement
        var debouncedIndex by remember { mutableIntStateOf(0) }
        LaunchedEffect(progressProvider()) {
            val target = (progressProvider() * (totalItemsCount - 1)).roundToInt().coerceIn(0, totalItemsCount - 1)
            if ((target - debouncedIndex).absoluteValue > 5 || target == 0 || target == totalItemsCount - 1) {
                debouncedIndex = target
            }
        }

        val currentLabel = remember(debouncedIndex) {
            labelProvider(debouncedIndex)
        }
        Text(
            text = currentLabel,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp), // More compact padding
            style = MaterialTheme.typography.labelLarge, // Smaller font
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onPrimaryContainer,
            maxLines = 1,
            softWrap = false
        )
    }
}
