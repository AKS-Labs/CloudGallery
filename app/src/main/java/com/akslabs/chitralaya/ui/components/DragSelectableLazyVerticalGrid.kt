package com.akslabs.chitralaya.ui.components

import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectDragGesturesAfterLongPress
import androidx.compose.foundation.gestures.scrollBy
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.input.pointer.PointerInputChange
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.platform.LocalViewConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.math.abs

private const val SCROLL_THRESHOLD_DP = 24
private const val SCROLL_SPEED_DP = 1.5f

@Composable
fun DragSelectableLazyVerticalGrid(
    modifier: Modifier = Modifier,
    lazyGridState: LazyGridState = rememberLazyGridState(),
    selectionEnabled: Boolean,
    columns: GridCells,
    contentPadding: PaddingValues,
    verticalArrangement: Arrangement.Vertical,
    horizontalArrangement: Arrangement.Horizontal,
    onItemSelectionChange: (Any?, Boolean) -> Unit,
    isItemSelected: (Any?) -> Boolean,
    onDragSelectionEnd: () -> Unit,
    glideSelectionBehavior: String = "Toggle",
    userScrollEnabled: Boolean = true, // Default to true, but we override it
    content: LazyGridScope.() -> Unit
) {
    val currentOnItemSelectionChange by rememberUpdatedState(onItemSelectionChange)
    val currentIsItemSelected by rememberUpdatedState(isItemSelected)
    val currentOnDragSelectionEnd by rememberUpdatedState(onDragSelectionEnd)

    var isDragging by remember { mutableStateOf(false) }
    var dragStartOffset by remember { mutableStateOf<Offset?>(null) }
    var dragCurrentOffset by remember { mutableStateOf<Offset?>(null) }
    var gridSize by remember { mutableStateOf(IntSize.Zero) }
    var lastGlidedItemKey by remember { mutableStateOf<Any?>(null) }
    var dragSelectionMode by remember { mutableStateOf(true) }

    // New state for touch slop
    var initialDownPosition by remember { mutableStateOf<Offset?>(null) }
    var hasMovedPastSlop by remember { mutableStateOf(false) }
    val viewConfiguration = LocalViewConfiguration.current
    val touchSlop = viewConfiguration.touchSlop

    val density = LocalDensity.current
    val scrollThresholdPx = with(density) { SCROLL_THRESHOLD_DP.dp.toPx() }
    val scrollSpeedPx = with(density) { SCROLL_SPEED_DP.dp.toPx() }
    val coroutineScope = rememberCoroutineScope()
    val layoutDirection = LocalLayoutDirection.current

    // Selection update loop
    LaunchedEffect(isDragging) {
        if (isDragging) {
            while (isDragging) {
                val currentOffset = dragCurrentOffset
                if (currentOffset != null) {
                    val currentLayoutInfo = lazyGridState.layoutInfo
                    if (currentLayoutInfo.visibleItemsInfo.isNotEmpty()) {
                        // visibleItemsInfo offsets are relative to the grid viewport and INCLUDE content padding.
                        // So we compare raw touch offsets (relative to the grid/box) directly.
                        val adjustedDragX = currentOffset.x
                        val adjustedDragY = currentOffset.y

                        val currentItem = currentLayoutInfo.visibleItemsInfo.find { itemInfo ->
                            adjustedDragX >= itemInfo.offset.x &&
                            adjustedDragX < itemInfo.offset.x + itemInfo.size.width &&
                            adjustedDragY >= itemInfo.offset.y &&
                            adjustedDragY < itemInfo.offset.y + itemInfo.size.height
                        }

                        if (currentItem != null && currentItem.key != lastGlidedItemKey) {
                            if (glideSelectionBehavior == "Fixed") {
                                currentOnItemSelectionChange(currentItem.key, dragSelectionMode)
                            } else {
                                val isSelected = currentIsItemSelected(currentItem.key)
                                currentOnItemSelectionChange(currentItem.key, !isSelected)
                            }
                            lastGlidedItemKey = currentItem.key
                        }
                    }
                }
                delay(20) // Check every 20ms
            }
        }
    }

    // Auto-scrolling loop
    LaunchedEffect(isDragging) {
        if (isDragging) {
            while (isDragging) {
                val currentOffset = dragCurrentOffset
                if (currentOffset != null && gridSize != IntSize.Zero) {
                    val currentY = currentOffset.y
                    val scrollAmount = when {
                        // Scroll up
                        currentY < scrollThresholdPx -> {
                            val factor = (scrollThresholdPx - currentY) / scrollThresholdPx
                            -scrollSpeedPx * factor
                        }
                        // Scroll down
                        currentY > gridSize.height - scrollThresholdPx -> {
                            val factor = (currentY - (gridSize.height - scrollThresholdPx)) / scrollThresholdPx
                            scrollSpeedPx * factor
                        }
                        else -> 0f
                    }

                    if (abs(scrollAmount) > 0.1f) {
                        lazyGridState.scrollBy(scrollAmount)
                    }
                }
                delay(16) // Run at approx 60fps
            }
        }
    }

    Box(
        modifier = modifier
            .onGloballyPositioned {
                gridSize = it.size
            }
            .pointerInput(selectionEnabled) {
                if (selectionEnabled) {
                    detectDragGestures(
                        onDragStart = { offset ->
                            initialDownPosition = offset // Store the initial touch position
                            dragStartOffset = offset
                            dragCurrentOffset = offset
                            lastGlidedItemKey = null
                            hasMovedPastSlop = false // Reset slop flag
                        },
                        onDragEnd = {
                            if (isDragging) { // Only call end actions if a drag was actually started
                                isDragging = false
                                dragStartOffset = null
                                dragCurrentOffset = null
                                lastGlidedItemKey = null
                                currentOnDragSelectionEnd()
                            }
                        },
                        onDragCancel = {
                            if (isDragging) { // Only call cancel actions if a drag was actually started
                                isDragging = false
                                dragStartOffset = null
                                dragCurrentOffset = null
                                lastGlidedItemKey = null
                                currentOnDragSelectionEnd()
                            }
                        },
                        onDrag = { change, _ ->
                            if (!isDragging) {
                                // Check if we've moved beyond the touch slop
                                initialDownPosition?.let { initial ->
                                    if ((change.position - initial).getDistance() > touchSlop) {
                                        hasMovedPastSlop = true

                                        // If we have moved past slop, and we are in selection mode,
                                        // then this is now considered a drag for selection.
                                        isDragging = true

                                        // Perform the initial item selection here as well
                                        // This ensures the item under the *initial down position* is selected
                                        val adjustedStartX = initial.x
                                        val adjustedStartY = initial.y
                                        val initialItem = lazyGridState.layoutInfo.visibleItemsInfo.find { itemInfo ->
                                            adjustedStartX >= itemInfo.offset.x &&
                                                    adjustedStartX < itemInfo.offset.x + itemInfo.size.width &&
                                                    adjustedStartY >= itemInfo.offset.y &&
                                                    adjustedStartY < itemInfo.offset.y + itemInfo.size.height
                                        }

                                        if (initialItem != null) {
                                            val isCurrentlySelected = currentIsItemSelected(initialItem.key)
                                            if (glideSelectionBehavior == "Fixed") {
                                                dragSelectionMode = !isCurrentlySelected
                                                currentOnItemSelectionChange(initialItem.key, dragSelectionMode)
                                            } else {
                                                currentOnItemSelectionChange(initialItem.key, !isCurrentlySelected)
                                            }
                                            lastGlidedItemKey = initialItem.key
                                        }
                                    }
                                }
                            }

                            if (isDragging) {
                                change.consume()
                                dragCurrentOffset = change.position
                            }
                        }
                    )
                }
            }
    ) {
        LazyVerticalGrid(
            modifier = Modifier.fillMaxSize(),
            state = lazyGridState,
            columns = columns,
            contentPadding = contentPadding,
            verticalArrangement = verticalArrangement,
            horizontalArrangement = horizontalArrangement,
            userScrollEnabled = !isDragging, // Disable user scroll while dragging
            content = content
        )
    }
}

private fun androidx.compose.ui.unit.IntOffset.toOffset() = Offset(x.toFloat(), y.toFloat())
private fun androidx.compose.ui.unit.IntSize.toSize() = Size(width.toFloat(), height.toFloat())
