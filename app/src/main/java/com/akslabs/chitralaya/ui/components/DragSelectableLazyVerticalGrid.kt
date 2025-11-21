package com.akslabs.chitralaya.ui.components

import androidx.compose.foundation.gestures.detectDragGestures
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
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.input.pointer.PointerInputChange
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalLayoutDirection // New import
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
    onItemSelectionChange: (Any?, Boolean) -> Unit, // Changed: key, isSelected
    isItemSelected: (Any?) -> Boolean, // New: check if item is selected
    onDragSelectionEnd: () -> Unit,
    content: LazyGridScope.() -> Unit
) {
    var isDragging by remember { mutableStateOf(false) }
    var dragStartOffset by remember { mutableStateOf<Offset?>(null) }
    var dragCurrentOffset by remember { mutableStateOf<Offset?>(null) }
    var gridSize by remember { mutableStateOf(IntSize.Zero) }
    var lastGlidedItemKey by remember { mutableStateOf<Any?>(null) } // Track last glided item key
    var dragSelectionMode by remember { mutableStateOf(true) } // true = select, false = deselect

    val density = LocalDensity.current
    val scrollThresholdPx = with(density) { SCROLL_THRESHOLD_DP.dp.toPx() }
    val scrollSpeedPx = with(density) { SCROLL_SPEED_DP.dp.toPx() }
    val coroutineScope = rememberCoroutineScope()
    val layoutDirection = LocalLayoutDirection.current

    LaunchedEffect(isDragging, dragCurrentOffset) {
        if (isDragging && dragCurrentOffset != null) {
            while (isDragging && dragCurrentOffset != null) {
                val currentLayoutInfo = lazyGridState.layoutInfo
                if (currentLayoutInfo.visibleItemsInfo.isNotEmpty()) {
                    val adjustedDragX = dragCurrentOffset!!.x - with(density) { contentPadding.calculateLeftPadding(layoutDirection).toPx() }
                    val adjustedDragY = dragCurrentOffset!!.y - with(density) { contentPadding.calculateTopPadding().toPx() }

                    val currentItem = currentLayoutInfo.visibleItemsInfo.find { itemInfo ->
                        adjustedDragX >= itemInfo.offset.x &&
                        adjustedDragX < itemInfo.offset.x + itemInfo.size.width &&
                        adjustedDragY >= itemInfo.offset.y &&
                        adjustedDragY < itemInfo.offset.y + itemInfo.size.height
                    }

                    if (currentItem != null && currentItem.key != lastGlidedItemKey) {
                        onItemSelectionChange(currentItem.key, dragSelectionMode)
                        lastGlidedItemKey = currentItem.key
                    }
                }
                delay(10) // Control frequency of checks
            }
        }
    }

    // Auto-scrolling LaunchedEffect
    LaunchedEffect(isDragging, dragCurrentOffset) {
        if (!isDragging || dragCurrentOffset == null || gridSize == IntSize.Zero) return@LaunchedEffect

        val currentY = dragCurrentOffset!!.y

        val scrollJob = coroutineScope.launch {
            while (isDragging && dragCurrentOffset != null) {
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

                if (abs(scrollAmount) > 0.1f) { // Only scroll if amount is significant
                    lazyGridState.scrollBy(scrollAmount)
                    delay(10) // Small delay to control scroll speed
                }
                delay(10) // Check scroll condition frequently
            }
        }
        // Cancel scroll job when drag ends
        if (!isDragging) {
            scrollJob.cancel()
        }
    }

    Box(
        modifier = modifier
            .onGloballyPositioned {
                gridSize = it.size
            }
            .pointerInput(selectionEnabled) {
                if (!selectionEnabled) return@pointerInput

                detectDragGestures(
                    onDragStart = { offset ->
                        isDragging = true
                        dragStartOffset = offset
                        dragCurrentOffset = offset
                        lastGlidedItemKey = null // Reset on new drag

                        val adjustedStartX = offset.x - with(density) { contentPadding.calculateLeftPadding(layoutDirection).toPx() }
                        val adjustedStartY = offset.y - with(density) { contentPadding.calculateTopPadding().toPx() }

                        // Immediately select the item under the drag start offset
                        val initialItem = lazyGridState.layoutInfo.visibleItemsInfo.find { itemInfo ->
                            adjustedStartX >= itemInfo.offset.x &&
                            adjustedStartX < itemInfo.offset.x + itemInfo.size.width &&
                            adjustedStartY >= itemInfo.offset.y &&
                            adjustedStartY < itemInfo.offset.y + itemInfo.size.height
                        }

                        if (initialItem != null) {
                            // Determine mode based on initial item state
                            val isCurrentlySelected = isItemSelected(initialItem.key)
                            dragSelectionMode = !isCurrentlySelected // If selected, mode is deselect. If not, mode is select.

                            onItemSelectionChange(initialItem.key, dragSelectionMode)
                            lastGlidedItemKey = initialItem.key
                        } else {
                            // Default to select mode if started on empty space (though less likely to trigger action immediately)
                            dragSelectionMode = true
                        }
                    },
                    onDragEnd = {
                        isDragging = false
                        dragStartOffset = null
                        dragCurrentOffset = null
                        lastGlidedItemKey = null
                        onDragSelectionEnd()
                    },
                    onDragCancel = {
                        isDragging = false
                        dragStartOffset = null
                        dragCurrentOffset = null
                        lastGlidedItemKey = null
                        onDragSelectionEnd()
                    },
                    onDrag = { change: PointerInputChange, _: Offset ->
                        dragCurrentOffset = change.position
                    }
                )
            }
    ) {
        LazyVerticalGrid(
            modifier = Modifier.fillMaxSize(),
            state = lazyGridState,
            columns = columns,
            contentPadding = contentPadding,
            verticalArrangement = verticalArrangement,
            horizontalArrangement = horizontalArrangement,
            content = content
        )
    }
}

private fun androidx.compose.ui.unit.IntOffset.toOffset() = Offset(x.toFloat(), y.toFloat())
private fun androidx.compose.ui.unit.IntSize.toSize() = Size(width.toFloat(), height.toFloat())



