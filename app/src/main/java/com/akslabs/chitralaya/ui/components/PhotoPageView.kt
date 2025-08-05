package com.akslabs.cloudgallery.ui.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.akslabs.cloudgallery.data.localdb.entities.Photo

@Composable
fun PhotoPageView(
    initialPage: Int,
    photos: List<Photo>,
    onlyRemotePhotos: Boolean,
    onDismissRequest: () -> Unit,
) {
    val showUiState = remember { mutableStateOf(true) }
    val pagerState = rememberPagerState(
        initialPage = initialPage,
        initialPageOffsetFraction = 0f
    ) {
        photos.size
    }
    Dialog(
        onDismissRequest = onDismissRequest,
        properties = remember { DialogProperties(usePlatformDefaultWidth = false) }
    ) {
        HorizontalPager(modifier = Modifier.fillMaxSize(), state = pagerState) {
            PhotoView(
                photo = photos[it],
                isOnlyRemote = onlyRemotePhotos,
                showUiState = { showUiState }
            )
        }
    }
}