package com.akslabs.cloudgallery.ui.components

import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectDragGesturesAfterLongPress
import androidx.compose.foundation.gestures.scrollBy
import androidx.compose.foundation.gestures.awaitEachGesture
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.awaitLongPressOrCancellation
import androidx.compose.foundation.gestures.awaitTouchSlopOrCancellation
import androidx.compose.foundation.gestures.drag
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
import androidx.compose.ui.input.pointer.PointerEventPass
import androidx.compose.ui.input.pointer.PointerInputChange
import androidx.compose.ui.input.pointer.changedToUp
import androidx.compose.ui.input.pointer.positionChange
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
    val currentSelectionEnabled by rememberUpdatedState(selectionEnabled)

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
                delay(40) // Reduced frequency (approx 25fps) to save main thread
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
                delay(32) // Approx 30fps
            }
        }
    }

    Box(
        modifier = modifier
            .onGloballyPositioned {
                gridSize = it.size
            }
            .pointerInput(Unit) {
                awaitEachGesture {
                    val down = awaitFirstDown(requireUnconsumed = false)
                    
                    var dragStarted = false
                    var initialDragOffset: Offset? = null
                    
                    // Use the latest value of selectionEnabled
                    if (currentSelectionEnabled) {
                        // If selection is enabled, we need to distinguish between a TAP (toggle) and a DRAG (glide).
                        // We wait for touch slop.
                        val drag = awaitTouchSlopOrCancellation(down.id) { change, over ->
                            change.consume()
                        }
                        
                        if (drag != null) {
                            // Slop exceeded, it's a drag
                            dragStarted = true
                            initialDragOffset = drag.position
                            
                            // Determine initial selection mode based on the item where drag started (original down position)
                            // We use the down position because that's where the user intended to start
                            val adjustedX = down.position.x
                            val adjustedY = down.position.y
                            val initialItem = lazyGridState.layoutInfo.visibleItemsInfo.find { itemInfo ->
                                adjustedX >= itemInfo.offset.x &&
                                adjustedX < itemInfo.offset.x + itemInfo.size.width &&
                                adjustedY >= itemInfo.offset.y &&
                                adjustedY < itemInfo.offset.y + itemInfo.size.height
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
                    } else {
                        // If selection is NOT enabled, we wait for a long press
                        val longPress = awaitLongPressOrCancellation(down.id)
                        if (longPress != null) {
                            dragStarted = true
                            initialDragOffset = longPress.position
                            
                            // Trigger initial selection for the long-pressed item
                            val adjustedX = longPress.position.x
                            val adjustedY = longPress.position.y
                            val initialItem = lazyGridState.layoutInfo.visibleItemsInfo.find { itemInfo ->
                                adjustedX >= itemInfo.offset.x &&
                                adjustedX < itemInfo.offset.x + itemInfo.size.width &&
                                adjustedY >= itemInfo.offset.y &&
                                adjustedY < itemInfo.offset.y + itemInfo.size.height
                            }

                            if (initialItem != null) {
                                val isCurrentlySelected = currentIsItemSelected(initialItem.key)
                                if (!isCurrentlySelected) {
                                     currentOnItemSelectionChange(initialItem.key, true)
                                }
                                lastGlidedItemKey = initialItem.key
                                dragSelectionMode = true
                            }
                        }
                    }

                    if (dragStarted && initialDragOffset != null) {
                        isDragging = true
                        dragStartOffset = initialDragOffset
                        dragCurrentOffset = initialDragOffset
                        
                        try {
                            // Custom drag loop to explicitly consume the UP event.
                            // This prevents the 'clickable' modifier on items from firing onClick
                            // when the finger is lifted after a long press (which would deselect the item).
                            while (true) {
                                // We MUST check in the Initial pass to consume the UP event BEFORE the child 'clickable' sees it.
                                // 'clickable' handles events in the Main pass. If we wait for Main, it's too late.
                                val event = awaitPointerEvent(PointerEventPass.Initial)
                                val change = event.changes.find { it.id == down.id }

                                if (change == null) {
                                    break // Pointer is gone
                                }

                                if (change.changedToUp()) {
                                    // User lifted finger. Consume this UP event!
                                    change.consume()
                                    break
                                }

                                if (change.positionChange() != Offset.Zero) {
                                    dragCurrentOffset = change.position
                                    change.consume()
                                }
                            }
                        } finally {
                            isDragging = false
                            dragStartOffset = null
                            dragCurrentOffset = null
                            lastGlidedItemKey = null
                            currentOnDragSelectionEnd()
                        }
                    }
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
