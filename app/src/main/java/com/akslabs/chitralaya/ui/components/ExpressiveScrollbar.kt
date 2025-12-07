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
import androidx.compose.runtime.mutableFloatStateOf
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
    thumbHeight: Dp = 48.dp,
    thumbCornerRadius: Dp = 10.dp,
    paddingEnd: Dp = 4.dp,
    gridContentPadding: PaddingValues = PaddingValues(0.dp),
    onDraggingChange: (Boolean) -> Unit = {}
) {
    val coroutineScope = rememberCoroutineScope()
    val isScrolling by remember { derivedStateOf { lazyGridState.isScrollInProgress } }
    var isDragging by remember { mutableStateOf(false) }
    var dragThumbY by remember { mutableFloatStateOf(0f) }

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
    
    // Notify dragging change
    LaunchedEffect(isDragging) {
        onDraggingChange(isDragging)
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
        val thumbHeightPx = with(density) { thumbHeight.toPx() }

        val animatedThumbWidth by animateDpAsState(
            targetValue = if (isDragging) thumbWidth + 4.dp else thumbWidth,
            animationSpec = tween(durationMillis = 150), label = "animatedThumbWidth"
        )
        val currentThumbWidthPx = with(density) { animatedThumbWidth.toPx() }

        val scrollbarTrackHeight = constraints.maxHeight.toFloat()
        
        // Calculate thumb position based on scroll position (when not dragging)
        val thumbOffsetPx by remember {
            derivedStateOf {
                if (totalItemsCount <= 0 || columnCount <= 0) return@derivedStateOf 0f
                
                val firstVisibleItemIndex = lazyGridState.firstVisibleItemIndex
                val totalRows = ceil(totalItemsCount.toFloat() / columnCount)
                val currentRow = firstVisibleItemIndex.toFloat() / columnCount
                
                val scrollRatio = if (totalRows > 1) currentRow / (totalRows - 1) else 0f
                val maxThumbOffset = scrollbarTrackHeight - thumbHeightPx
                (scrollRatio * maxThumbOffset).coerceIn(0f, maxThumbOffset)
            }
        }

        Box(
            modifier = Modifier
                .fillMaxHeight()
                .width(draggableAreaWidth)
                .pointerInput(totalItemsCount, columnCount, scrollbarTrackHeight, thumbHeightPx) {
                    detectVerticalDragGestures(
                        onDragStart = { offset ->
                            isDragging = true
                            dragThumbY = offset.y.coerceIn(0f, scrollbarTrackHeight - thumbHeightPx)
                        },
                        onDragEnd = { isDragging = false },
                        onDragCancel = { isDragging = false },
                        onVerticalDrag = { change, _ ->
                            change.consume()
                            
                            // Update thumb position immediately for real-time feedback
                            dragThumbY = change.position.y.coerceIn(0f, scrollbarTrackHeight - thumbHeightPx)
                            
                            // Calculate scroll position
                            val maxThumbOffset = scrollbarTrackHeight - thumbHeightPx
                            val scrollRatio = if (maxThumbOffset > 0) dragThumbY / maxThumbOffset else 0f
                            val totalRows = ceil(totalItemsCount.toFloat() / columnCount)
                            val targetRow = (scrollRatio * totalRows).toInt().coerceIn(0, totalRows.toInt() - 1)
                            val targetIndex = (targetRow * columnCount).coerceIn(0, totalItemsCount - 1)
                            
                            // Instant scroll for real-time sync
                            coroutineScope.launch {
                                lazyGridState.scrollToItem(targetIndex)
                            }
                        }
                    )
                }
                .offset {
                    val yOffset = if (isDragging) {
                        dragThumbY
                    } else {
                        thumbOffsetPx
                    }.coerceIn(0f, (scrollbarTrackHeight - thumbHeightPx).coerceAtLeast(0f))
                    IntOffset(0, yOffset.toInt())
                }
//                .shadow(
//                    elevation = if (isDragging) 8.dp else 2.dp,
//                    shape = RoundedCornerShape(thumbCornerRadius)
//                )
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