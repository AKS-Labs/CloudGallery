package com.akslabs.cloudgallery.ui.components

import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.akslabs.cloudgallery.data.localdb.entities.Photo

@OptIn(ExperimentalAnimationApi::class, ExperimentalSharedTransitionApi::class)
@Composable
fun PhotoPageView(
    initialPhotoId: String,
    localPhotos: List<Photo>,
    cloudPhotos: List<Photo>,
    isRemote: Boolean,
    window: android.view.Window,
    onDismissRequest: () -> Unit,
    sharedTransitionScope: SharedTransitionScope,
    animatedVisibilityScope: AnimatedVisibilityScope,
    onPhotoChanged: (String) -> Unit = {}
) {
    val showUiState = remember { androidx.compose.runtime.mutableStateOf(true) }
    
    // Choose the list based on which grid we started from
    val activePhotos = remember(isRemote, localPhotos, cloudPhotos) {
        if (isRemote) cloudPhotos else localPhotos
    }

    // Solve "first image bug": Wait for activePhotos to be non-empty and find the index of initialPhotoId
    val initialIndex = remember(activePhotos, initialPhotoId) {
        if (activePhotos.isEmpty()) 0 
        else activePhotos.indexOfFirst { 
            if (isRemote) it.remoteId == initialPhotoId else it.localId == initialPhotoId 
        }.coerceAtLeast(0)
    }

    // We only create the pager state once we potentially have the correct index or photos
    // Using a key ensures it re-initializes if the initial index changes significantly (e.g. from 0 to actual)
    val pagerState = androidx.compose.foundation.pager.rememberPagerState(
        initialPage = initialIndex,
        initialPageOffsetFraction = 0f
    ) {
        activePhotos.size
    }
    
    // Effect to scroll to the correct index if for some reason the pager state was initialized with 0
    // but the actual photo is elsewhere. This is a safety measure.
    androidx.compose.runtime.LaunchedEffect(initialIndex) {
        if (initialIndex > 0 && pagerState.currentPage == 0 && activePhotos.size > initialIndex) {
            pagerState.scrollToPage(initialIndex)
        }
    }
    
    Box(modifier = Modifier.fillMaxSize().background(Color.Black)) {
        androidx.compose.foundation.pager.HorizontalPager(
            modifier = Modifier.fillMaxSize(),
            state = pagerState,
            beyondViewportPageCount = 1
        ) { pageIndex ->
            // Notify when page changes
            androidx.compose.runtime.LaunchedEffect(pagerState.currentPage) {
                if (pagerState.currentPage == pageIndex && pageIndex < activePhotos.size) {
                    val photo = activePhotos[pageIndex]
                    val id = if (isRemote) photo.remoteId else photo.localId
                    if (id != null) {
                        onPhotoChanged(id)
                        // android.widget.Toast.makeText(context, "Viewed: $id", android.widget.Toast.LENGTH_SHORT).show()
                    }
                }
            }
            if (pageIndex < activePhotos.size) {
                PhotoView(
                    photo = activePhotos[pageIndex],
                    isOnlyRemote = isRemote,
                    showUiState = { showUiState },
                    window = window,
                    sharedTransitionScope = sharedTransitionScope,
                    animatedVisibilityScope = animatedVisibilityScope
                )
            }
        }
    }
}
