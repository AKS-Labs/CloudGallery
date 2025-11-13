package com.akslabs.chitralaya.ui.components

import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.unit.IntSize

class ZoomState(
    private val maxScale: Float
) {

    var scale by mutableStateOf(1f)
        private set
    var xOffset by mutableStateOf(0f)
        private set
    var yOffset by mutableStateOf(0f)
        private set

    private var layoutSize = IntSize.Zero
    private var imageSize = IntSize.Zero

    fun setConstraints(layoutSize: IntSize, imageSize: IntSize) {
        this.layoutSize = layoutSize
        this.imageSize = imageSize
    }

    fun update(newScale: Float, newXOffset: Float, newYOffset: Float) {
        scale = newScale.coerceIn(1f, maxScale)

        val imageWidth = imageSize.width * scale
        val imageHeight = imageSize.height * scale

        val maxX = (imageWidth - layoutSize.width).coerceAtLeast(0f) / 2f
        val maxY = (imageHeight - layoutSize.height).coerceAtLeast(0f) / 2f

        xOffset = newXOffset.coerceIn(-maxX, maxX)
        yOffset = newYOffset.coerceIn(-maxY, maxY)
    }
}

@Composable
fun rememberZoomState(maxScale: Float = 5f) = remember { ZoomState(maxScale) }

fun Modifier.zoomArea(zoomState: ZoomState) = pointerInput(Unit) {
    detectTransformGestures { _, pan, zoom, _ ->
        zoomState.update(
            newScale = zoomState.scale * zoom,
            newXOffset = zoomState.xOffset + pan.x,
            newYOffset = zoomState.yOffset + pan.y
        )
    }
}

fun Modifier.zoomImage(zoomState: ZoomState) = this
    .onSizeChanged { zoomState.setConstraints(it, it) }
    .graphicsLayer {
        scaleX = zoomState.scale
        scaleY = zoomState.scale
        translationX = zoomState.xOffset
        translationY = zoomState.yOffset
    }