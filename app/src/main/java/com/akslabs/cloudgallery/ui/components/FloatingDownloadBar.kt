package com.akslabs.cloudgallery.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowCircleDown
import androidx.compose.material.icons.rounded.CloudDownload
import androidx.compose.material.icons.rounded.CloudOff
import androidx.compose.material.icons.rounded.CloudSync
import androidx.compose.material.icons.rounded.Done
import androidx.compose.material.icons.rounded.Timer
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.akslabs.cloudgallery.R
import com.akslabs.cloudgallery.ui.main.screens.remote.DownloadState

@Composable
fun FloatingDownloadBar(
    modifier: Modifier = Modifier,
    downloadState: DownloadState,
    onClickDownload: () -> Unit,
    contentColor: Color,
) {
    Box(
        modifier = Modifier,
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            when (downloadState) {
                DownloadState.CHECKING -> TextIcon(
                    imageVector = Icons.Rounded.CloudSync,
                    title = stringResource(R.string.checking_download_status),
                    color = contentColor,
                    isEnabled = false
                )

                DownloadState.DOWNLOADING -> TextIcon(
                    imageVector = Icons.Rounded.ArrowCircleDown,
                    title = stringResource(R.string.downloading),
                    color = contentColor,
                    isEnabled = false
                )

                DownloadState.DOWNLOADED -> TextIcon(
                    imageVector = Icons.Rounded.Done,
                    title = stringResource(R.string.downloaded),
                    color = contentColor,
                    isEnabled = false
                )

                DownloadState.NOT_DOWNLOADED -> TextIcon(
                    imageVector = Icons.Rounded.CloudDownload,
                    title = stringResource(R.string.download_to_device),
                    color = contentColor,
                    isEnabled = true,
                    onItemClick = onClickDownload
                )

                DownloadState.FAILED -> TextIcon(
                    imageVector = Icons.Rounded.CloudOff,
                    title = stringResource(R.string.download_failed),
                    color = contentColor,
                    isEnabled = true,
                    onItemClick = onClickDownload
                )

                DownloadState.ENQUEUED -> TextIcon(
                    imageVector = Icons.Rounded.Timer,
                    title = stringResource(R.string.download_enqueued),
                    color = contentColor,
                    isEnabled = true,
                    onItemClick = onClickDownload
                )

                DownloadState.BLOCKED -> TextIcon(
                    imageVector = Icons.Rounded.CloudOff,
                    title = stringResource(R.string.download_blocked),
                    color = contentColor,
                    isEnabled = false
                )
            }
        }
    }
}
