package com.akslabs.chitralaya.ui.components

import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectVerticalDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import kotlin.math.ceil
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

private enum class ScrollbarVisibilityState { Hidden, Visible }

/**
 * An expressive, performant, and Material3-style scrollbar for LazyVerticalGrid.
 *
 * @param lazyGridState The [LazyGridState] of the grid to connect this scrollbar to.
 * @param modifier The modifier to be applied to the scrollbar container.
 * @param indicatorColor The color of the scrollbar thumb. Defaults to `MaterialTheme.colorScheme.primary.copy(alpha = 0.7f)`.
 * @param trackColor The color of the scrollbar track. Defaults to `MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.3f)`.
 * @param thumbWidth The width of the scrollbar thumb. Defaults to 6.dp.
 * @param thumbHeightMin The minimum height of the scrollbar thumb. Defaults to 24.dp.
 * @param thumbCornerRadius The corner radius of the scrollbar thumb. Defaults to 3.dp.
 * @param paddingEnd The padding at the end of the scrollbar. Defaults to 4.dp.
 * @param gridContentPadding The content padding of the grid, used to align the scrollbar correctly.
 */
@Composable
fun ExpressiveScrollbar(
    lazyGridState: LazyGridState,
    modifier: Modifier = Modifier,
    indicatorColor: Color = MaterialTheme.colorScheme.primary,
    trackColor: Color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.3f),
    thumbWidth: Dp = 8.dp,
    thumbHeightMin: Dp = 34.dp,
    thumbCornerRadius: Dp = 10.dp,
    paddingEnd: Dp = 4.dp,
    gridContentPadding: PaddingValues = PaddingValues(0.dp) // Default to no padding
) {
    val coroutineScope = rememberCoroutineScope()
    val isScrolling by remember { derivedStateOf { lazyGridState.isScrollInProgress } }
    var isDragging by remember { mutableStateOf(false) } // State for elevation and visibility
    var dragStartY by remember { mutableStateOf(0f) }
    var dragStartThumbOffset by remember { mutableStateOf(0f) }
    var currentDragThumbOffset by remember { mutableStateOf(0f) }

    val draggableAreaWidth = thumbWidth + 8.dp // Total width of the scrollbar area including extra padding for draggable target

    val showScrollbar = remember { MutableTransitionState(ScrollbarVisibilityState.Hidden) }
    val transition = updateTransition(showScrollbar, label = "ScrollbarVisibility")

    val alpha by transition.animateFloat(
        transitionSpec = { tween(durationMillis = 300) },
        label = "ScrollbarAlpha"
    ) { state ->
        if (state == ScrollbarVisibilityState.Visible) 1f else 0f
    }

    LaunchedEffect(isScrolling) {
        if (isScrolling) {
            showScrollbar.targetState = ScrollbarVisibilityState.Visible
        } else {
            delay(600) // Auto-hide after 600ms of inactivity
            showScrollbar.targetState = ScrollbarVisibilityState.Hidden
        }
    }

    // Only render if there's enough content to scroll
    val canScroll by remember {
        derivedStateOf {
            lazyGridState.layoutInfo.totalItemsCount > lazyGridState.layoutInfo.visibleItemsInfo.size
        }
    }

    if (!canScroll && showScrollbar.currentState == ScrollbarVisibilityState.Hidden) return

    BoxWithConstraints( // Outermost container to get constraints (maxHeight)
        modifier = modifier // This `modifier` is from the function parameter
            .fillMaxHeight()
            .padding(end = paddingEnd + gridContentPadding.calculateEndPadding(LocalLayoutDirection.current))
            .width(draggableAreaWidth) // Total width of the scrollbar area including extra padding for draggable target
            .zIndex(10f) // Ensure the entire scrollbar component is above the grid
            .alpha(alpha), // Overall fading
        contentAlignment = Alignment.TopEnd // Align content (the thumb) to top-end within this BoxWithConstraints
    ) {
        val density = LocalDensity.current
        val thumbWidthPx = with(density) { thumbWidth.toPx() }
        val thumbHeightMinPx = with(density) { thumbHeightMin.toPx() }

        val animatedThumbWidth by animateDpAsState(
            targetValue = if (isDragging) thumbWidth + 3.dp else thumbWidth,
            animationSpec = tween(durationMillis = 150), label = "animatedThumbWidth"
        )
        val currentThumbWidthPx = with(density) { animatedThumbWidth.toPx() }

        val totalItemsCount by remember { derivedStateOf { lazyGridState.layoutInfo.totalItemsCount } }
        val viewportHeight by remember { derivedStateOf { lazyGridState.layoutInfo.viewportSize.height.toFloat() } }
        val singleItemHeight by remember { derivedStateOf { lazyGridState.layoutInfo.visibleItemsInfo.firstOrNull()?.size?.height?.toFloat() ?: 0f } }
        val mainAxisSpacing by remember { derivedStateOf { lazyGridState.layoutInfo.mainAxisItemSpacing.toFloat() } }

        val totalContentHeightPx by remember {
            derivedStateOf {
                val layoutInfo = lazyGridState.layoutInfo
                if (totalItemsCount == 0 || singleItemHeight == 0f) return@derivedStateOf 0f

                val spanCount = layoutInfo.visibleItemsInfo.maxOfOrNull { it.column }?.plus(1) ?: 1
                if (spanCount == 0) return@derivedStateOf 0f

                val numRows = ceil(totalItemsCount.toFloat() / spanCount)
                val contentPadding = (layoutInfo.beforeContentPadding + layoutInfo.afterContentPadding).toFloat()

                (numRows * singleItemHeight) + ((numRows - 1).coerceAtLeast(0f) * mainAxisSpacing) + contentPadding
            }
        }

        val currentScrollOffsetPx by remember {
            derivedStateOf {
                val layoutInfo = lazyGridState.layoutInfo
                if (layoutInfo.visibleItemsInfo.isEmpty() || singleItemHeight == 0f) return@derivedStateOf 0f

                val spanCount = layoutInfo.visibleItemsInfo.maxOfOrNull { it.column }?.plus(1) ?: 1
                if (spanCount == 0) return@derivedStateOf 0f

                val firstVisibleItemRow = lazyGridState.firstVisibleItemIndex / spanCount
                firstVisibleItemRow.toFloat() * (singleItemHeight + mainAxisSpacing) + lazyGridState.firstVisibleItemScrollOffset.toFloat()
            }
        }

        val scrollbarTrackHeight = constraints.maxHeight.toFloat()
        val thumbHeightPx by remember {
            derivedStateOf {
                thumbHeightMinPx
            }
        }

        val thumbOffsetPx by remember {
            derivedStateOf {
                if (totalItemsCount == 0 || totalContentHeightPx <= viewportHeight) 0f // No scroll needed
                else {
                    val maxScrollPx = totalContentHeightPx - viewportHeight // Total actual scrollable distance in content
                    if (maxScrollPx <= 0f) 0f // Avoid division by zero
                    else {
                        val scrollRatio = currentScrollOffsetPx / maxScrollPx
                        (scrollbarTrackHeight - thumbHeightPx) * scrollRatio // Thumb travel distance in scrollbar track
                    }
                }
            }
        }

        // Inner Box acts as the draggable area and visual container for the thumb
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .width(draggableAreaWidth) // Draggable area is wider than visual thumb
                .pointerInput(lazyGridState) {
                    detectVerticalDragGestures(
                        onDragStart = { offset ->
                            isDragging = true
                            showScrollbar.targetState = ScrollbarVisibilityState.Visible
                            dragStartY = offset.y
                            dragStartThumbOffset = thumbOffsetPx
                            currentDragThumbOffset = thumbOffsetPx
                        },
                        onDragEnd = {
                            isDragging = false
                            coroutineScope.launch {
                                delay(600)
                                showScrollbar.targetState = ScrollbarVisibilityState.Hidden
                            }
                        },
                        onDragCancel = {
                            isDragging = false
                            coroutineScope.launch {
                                delay(600)
                                showScrollbar.targetState = ScrollbarVisibilityState.Hidden
                            }
                        },
                        onVerticalDrag = { change, _ ->
                            change.consume()

                            val newThumbOffsetY = dragStartThumbOffset + (change.position.y - dragStartY)
                            val clampedThumbOffsetY = newThumbOffsetY.coerceIn(0f, scrollbarTrackHeight - thumbHeightPx)
                            currentDragThumbOffset = clampedThumbOffsetY

                            val scrollRatio = clampedThumbOffsetY / (scrollbarTrackHeight - thumbHeightPx)
                            val targetScrollPx = scrollRatio * (totalContentHeightPx - viewportHeight).coerceAtLeast(0f)

                            val layoutInfo = lazyGridState.layoutInfo
                            val spanCount = layoutInfo.visibleItemsInfo.maxOfOrNull { it.column }?.plus(1) ?: 1
                            if (spanCount > 0) {
                                val averageRowHeight = singleItemHeight + mainAxisSpacing
                                if (averageRowHeight > 0f) {
                                    val targetRow = (targetScrollPx / averageRowHeight).toInt()
                                    val targetRowOffset = (targetScrollPx % averageRowHeight).toInt()
                                    val targetItemIndex = (targetRow * spanCount).coerceIn(0, totalItemsCount - 1)

                                    coroutineScope.launch {
                                        lazyGridState.scrollToItem(targetItemIndex, targetRowOffset)
                                    }
                                }
                            }
                        }
                    )
                }
                .offset {
                    val yOffset = if (isDragging) {
                        currentDragThumbOffset
                    } else {
                        thumbOffsetPx
                    }.coerceIn(0f, (scrollbarTrackHeight - thumbHeightPx).coerceAtLeast(0f))
                    IntOffset(0, yOffset.toInt())
                }
                .shadow(
                    elevation = if (isDragging) 8.dp else 0.dp, // Elevation while dragging
                    shape = RoundedCornerShape(thumbCornerRadius)
                )
                .semantics { contentDescription = "Scrollbar for photo grid" } // Accessibility
        ) {
            // Visual thumb (Canvas)
            Canvas(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(animatedThumbWidth) // The actual visual thumb width
                    .align(Alignment.CenterEnd) // Align the visual thumb to the end of its draggable parent
            ) {
                // Draw thumb
                drawRoundRect(
                    color = indicatorColor,
                    topLeft = Offset(x = (size.width - currentThumbWidthPx) / 2f, y = 0f), // Center the visual thumb
                    size = Size(currentThumbWidthPx, thumbHeightPx),
                    cornerRadius = CornerRadius(with(density) { thumbCornerRadius.toPx() })
                )
            }
        }
    }
}