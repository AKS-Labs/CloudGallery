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

@Composable
fun ExpressiveScrollbar(
    lazyGridState: LazyGridState,
    totalItemsCount: Int,
    columnCount: Int,
    modifier: Modifier = Modifier,
    indicatorColor: Color = MaterialTheme.colorScheme.primary,
    trackColor: Color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.3f),
    thumbWidth: Dp = 8.dp,
    thumbHeightMin: Dp = 34.dp,
    thumbCornerRadius: Dp = 10.dp,
    paddingEnd: Dp = 4.dp,
    gridContentPadding: PaddingValues = PaddingValues(0.dp)
) {
    val coroutineScope = rememberCoroutineScope()
    val isScrolling by remember { derivedStateOf { lazyGridState.isScrollInProgress } }
    var isDragging by remember { mutableStateOf(false) }
    var dragStartY by remember { mutableStateOf(0f) }
    var dragStartThumbOffset by remember { mutableStateOf(0f) }
    var currentDragThumbOffset by remember { mutableStateOf(0f) }

    val draggableAreaWidth = thumbWidth + 16.dp

    val showScrollbar = remember { MutableTransitionState(ScrollbarVisibilityState.Hidden) }
    val transition = updateTransition(showScrollbar, label = "ScrollbarVisibility")

    val alpha by transition.animateFloat(
        transitionSpec = { tween(durationMillis = 300) },
        label = "ScrollbarAlpha"
    ) { state ->
        if (state == ScrollbarVisibilityState.Visible) 1f else 0f
    }

    LaunchedEffect(isScrolling, isDragging) {
        if (isScrolling || isDragging) {
            showScrollbar.targetState = ScrollbarVisibilityState.Visible
        } else {
            delay(1000)
            showScrollbar.targetState = ScrollbarVisibilityState.Hidden
        }
    }

    if (totalItemsCount == 0) return

    BoxWithConstraints(
        modifier = modifier
            .fillMaxHeight()
            .padding(end = paddingEnd + gridContentPadding.calculateEndPadding(LocalLayoutDirection.current))
            .width(draggableAreaWidth)
            .zIndex(10f)
            .alpha(alpha),
        contentAlignment = Alignment.TopEnd
    ) {
        val density = LocalDensity.current
        val thumbWidthPx = with(density) { thumbWidth.toPx() }
        val thumbHeightMinPx = with(density) { thumbHeightMin.toPx() }

        val animatedThumbWidth by animateDpAsState(
            targetValue = if (isDragging) thumbWidth + 4.dp else thumbWidth,
            animationSpec = tween(durationMillis = 150), label = "animatedThumbWidth"
        )
        val currentThumbWidthPx = with(density) { animatedThumbWidth.toPx() }

        val viewportHeight by remember { derivedStateOf { lazyGridState.layoutInfo.viewportSize.height.toFloat() } }
        val singleItemHeight by remember { derivedStateOf { lazyGridState.layoutInfo.visibleItemsInfo.firstOrNull()?.size?.height?.toFloat() ?: 0f } }
        val mainAxisSpacing by remember { derivedStateOf { lazyGridState.layoutInfo.mainAxisItemSpacing.toFloat() } }

        val totalContentHeightPx by remember(totalItemsCount, columnCount, singleItemHeight, mainAxisSpacing) {
            derivedStateOf {
                if (totalItemsCount == 0 || singleItemHeight == 0f || columnCount == 0) return@derivedStateOf 0f
                val numRows = ceil(totalItemsCount.toFloat() / columnCount)
                (numRows * singleItemHeight) + ((numRows - 1).coerceAtLeast(0f) * mainAxisSpacing)
            }
        }

        val currentScrollOffsetPx by remember {
            derivedStateOf {
                if (lazyGridState.layoutInfo.visibleItemsInfo.isEmpty() || singleItemHeight == 0f || columnCount == 0) return@derivedStateOf 0f
                val firstVisibleItemIndex = lazyGridState.firstVisibleItemIndex
                val firstVisibleItemRow = firstVisibleItemIndex / columnCount
                firstVisibleItemRow.toFloat() * (singleItemHeight + mainAxisSpacing) + lazyGridState.firstVisibleItemScrollOffset.toFloat()
            }
        }

        val scrollbarTrackHeight = constraints.maxHeight.toFloat()
        
        val thumbHeightPx by remember(totalContentHeightPx, viewportHeight) {
            derivedStateOf {
                 if (totalContentHeightPx <= viewportHeight) thumbHeightMinPx
                 else {
                     val height = (viewportHeight / totalContentHeightPx) * scrollbarTrackHeight
                     height.coerceAtLeast(thumbHeightMinPx)
                 }
            }
        }

        val thumbOffsetPx by remember(currentScrollOffsetPx, totalContentHeightPx, viewportHeight, scrollbarTrackHeight, thumbHeightPx) {
            derivedStateOf {
                if (totalContentHeightPx <= viewportHeight) 0f
                else {
                    val maxScrollPx = totalContentHeightPx - viewportHeight
                    if (maxScrollPx <= 0f) 0f
                    else {
                        val scrollRatio = currentScrollOffsetPx / maxScrollPx
                        (scrollbarTrackHeight - thumbHeightPx) * scrollRatio
                    }
                }
            }
        }

        Box(
            modifier = Modifier
                .fillMaxHeight()
                .width(draggableAreaWidth)
                .pointerInput(totalItemsCount, columnCount) {
                    detectVerticalDragGestures(
                        onDragStart = { offset ->
                            isDragging = true
                            dragStartY = offset.y
                            dragStartThumbOffset = thumbOffsetPx
                            currentDragThumbOffset = thumbOffsetPx
                        },
                        onDragEnd = { isDragging = false },
                        onDragCancel = { isDragging = false },
                        onVerticalDrag = { change, _ ->
                            change.consume()
                            val newThumbOffsetY = dragStartThumbOffset + (change.position.y - dragStartY)
                            val clampedThumbOffsetY = newThumbOffsetY.coerceIn(0f, scrollbarTrackHeight - thumbHeightPx)
                            currentDragThumbOffset = clampedThumbOffsetY

                            val scrollRatio = clampedThumbOffsetY / (scrollbarTrackHeight - thumbHeightPx)
                            val totalRows = ceil(totalItemsCount.toFloat() / columnCount)
                            val targetRow = (scrollRatio * totalRows).toInt()
                            val targetIndex = (targetRow * columnCount).coerceIn(0, (totalItemsCount - 1).coerceAtLeast(0))
                            
                            coroutineScope.launch {
                                lazyGridState.scrollToItem(targetIndex)
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
                    elevation = if (isDragging) 8.dp else 0.dp,
                    shape = RoundedCornerShape(thumbCornerRadius)
                )
                .semantics { contentDescription = "Scrollbar" }
        ) {
            Canvas(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(animatedThumbWidth)
                    .align(Alignment.CenterEnd)
            ) {
                drawRoundRect(
                    color = indicatorColor,
                    topLeft = Offset(x = (size.width - currentThumbWidthPx) / 2f, y = 0f),
                    size = Size(currentThumbWidthPx, thumbHeightPx),
                    cornerRadius = CornerRadius(with(density) { thumbCornerRadius.toPx() })
                )
            }
        }
    }
}