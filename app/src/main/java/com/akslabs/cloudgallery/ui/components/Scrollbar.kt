//package com.akslabs.cloudgallery.ui.components
//
//import androidx.compose.foundation.Canvas
//import androidx.compose.foundation.gestures.detectVerticalDragGestures
//import androidx.compose.foundation.layout.fillMaxHeight
//import androidx.compose.foundation.layout.width
//import androidx.compose.foundation.lazy.grid.LazyGridState
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.rememberCoroutineScope
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.geometry.CornerRadius
//import androidx.compose.ui.geometry.Offset
//import androidx.compose.ui.geometry.Size
//import androidx.compose.ui.input.pointer.pointerInput
//import androidx.compose.ui.unit.dp
//import kotlinx.coroutines.launch
//import kotlin.math.roundToInt
//
//@Composable
//fun GridVerticalScrollbar(
//    lazyGridState: LazyGridState,
//    modifier: Modifier = Modifier,
//    scrollbarWidth: Float = 6f
//) {
//    val coroutineScope = rememberCoroutineScope()
//
//    val totalItems = lazyGridState.layoutInfo.totalItemsCount
//    if (totalItems == 0) return
//
//    val visibleItems = lazyGridState.layoutInfo.visibleItemsInfo.size
//    if (visibleItems == 0) return
//
//    val firstVisibleItem = lazyGridState.firstVisibleItemIndex
//    val fractionVisible = visibleItems.toFloat() / totalItems.toFloat()
//    val fractionOffset = firstVisibleItem.toFloat() / totalItems.toFloat()
//
//    Canvas(
//        modifier = modifier
//            .fillMaxHeight()
//            .width(scrollbarWidth.dp)
//            // ✅ fix: launch coroutine via rememberCoroutineScope + no composable inside drag lambda
//            .pointerInput(totalItems, visibleItems) {
//                detectVerticalDragGestures { _, dragAmount ->
//                    val totalScrollableItems = totalItems - visibleItems
//                    if (totalScrollableItems > 0) {
//                        val proportion = dragAmount / size.height
//                        val deltaIndex = (proportion * totalScrollableItems).roundToInt()
//                        val targetIndex = (lazyGridState.firstVisibleItemIndex + deltaIndex)
//                            .coerceIn(0, totalScrollableItems)
//                        // move launch into pointerInput safe scope
//                        coroutineScope.launch {
//                            lazyGridState.scrollToItem(targetIndex)
//                        }
//                    }
//                }
//            }
//    ) {
//        // ✅ keep this pure drawing code only
//        val scrollbarHeight = size.height * fractionVisible
//        val scrollbarY = size.height * fractionOffset
//        drawRoundRect(
//            color = MaterialTheme.colorScheme.primary.copy(alpha = 0.7f),
//            topLeft = Offset(x = size.width - scrollbarWidth, y = scrollbarY),
//            size = Size(scrollbarWidth, scrollbarHeight),
//            cornerRadius = CornerRadius(3.dp.toPx())
//        )
//    }
//}
