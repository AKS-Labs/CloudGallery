package com.akslabs.cloudgallery.ui.main.screens.local

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import android.content.ContentUris
import android.provider.MediaStore
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.BrokenImage
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import coil.compose.SubcomposeAsyncImage
import com.akslabs.cloudgallery.R
import com.akslabs.cloudgallery.data.localdb.entities.Photo
import com.akslabs.cloudgallery.data.localdb.Preferences
import com.akslabs.cloudgallery.ui.components.LoadAnimation
import com.akslabs.cloudgallery.ui.components.PhotoPageView
import com.akslabs.cloudgallery.ui.components.itemsPaging

@Composable
fun LocalPhotoGrid(localPhotos: LazyPagingItems<Photo>, totalCount: Int) {
    val context = LocalContext.current
    var selectedIndex by remember { mutableStateOf<Int?>(null) }

    // Fixed grid to match screenshot
    val columns = 4
    val horizontalSpacing = 12.dp
    val verticalSpacing = 12.dp

    // Cache date lookups
    val dateCache = remember { mutableStateMapOf<String, Long>() }

    fun getDateLabel(localId: String): String? {
        val cached = dateCache[localId]
        val millis = if (cached != null) cached else runCatching {
            val idLong = localId.toLongOrNull() ?: return null
            val uri = ContentUris.withAppendedId(
                MediaStore.Images.Media.getContentUri(MediaStore.VOLUME_EXTERNAL), idLong
            )
            context.contentResolver.query(
                uri,
                arrayOf(MediaStore.Images.ImageColumns.DATE_MODIFIED),
                null,
                null,
                null
            )?.use { c -> if (c.moveToFirst()) (c.getLong(0) * 1000L).also { dateCache[localId] = it } else null }
        }.getOrNull()
        millis ?: return null
        return java.text.SimpleDateFormat("EEE d - LLLL yyyy", java.util.Locale.getDefault()).format(java.util.Date(millis))
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        if (localPhotos.loadState.refresh == LoadState.Loading) {
            LoadAnimation(modifier = Modifier.align(Alignment.Center))
        } else {
            LazyVerticalGrid(
                modifier = Modifier.fillMaxSize(),
                columns = GridCells.Fixed(columns),
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                verticalArrangement = Arrangement.spacedBy(verticalSpacing),
                horizontalArrangement = Arrangement.spacedBy(horizontalSpacing)
            ) {
                var lastHeader: String? = null
                for (i in 0 until localPhotos.itemCount) {
                    val peek = localPhotos.peek(i)
                    val label = peek?.localId?.let { getDateLabel(it) }
                    if (label != null && label != lastHeader) {
                        item(span = { GridItemSpan(maxLineSpan) }) {
                            Text(
                                text = label,
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.SemiBold,
                                color = MaterialTheme.colorScheme.onSurface,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 8.dp)
                            )
                        }
                        lastHeader = label
                    }
                    item(key = peek?.localId ?: "ph_$i") {
                        Box(
                            modifier = Modifier
                                .aspectRatio(1f)
                                .clip(RoundedCornerShape(16.dp))
                                .background(MaterialTheme.colorScheme.surfaceVariant)
                                .clickable { selectedIndex = i },
                            contentAlignment = Alignment.Center
                        ) {
                            SubcomposeAsyncImage(
                                model = peek?.pathUri,
                                contentDescription = stringResource(id = R.string.photo),
                                contentScale = ContentScale.Crop,
                                modifier = Modifier.fillMaxSize(),
                                error = {
                                    Icon(
                                        tint = MaterialTheme.colorScheme.onSurfaceVariant,
                                        imageVector = Icons.Rounded.BrokenImage,
                                        contentDescription = stringResource(id = R.string.load_error),
                                        modifier = Modifier.size(20.dp)
                                    )
                                }
                            )
                        }
                    }
                }
            }
        }
        selectedIndex?.let {
            PhotoPageView(
                initialPage = it,
                onlyRemotePhotos = false,
                photos = localPhotos.itemSnapshotList.items
            ) { selectedIndex = null }
        }
    }
}