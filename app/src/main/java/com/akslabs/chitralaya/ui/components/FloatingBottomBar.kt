package com.akslabs.cloudgallery.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowCircleUp
import androidx.compose.material.icons.rounded.CloudDone
import androidx.compose.material.icons.rounded.CloudOff
import androidx.compose.material.icons.rounded.CloudSync
import androidx.compose.material.icons.rounded.CloudUpload
import androidx.compose.material.icons.rounded.Timer
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.akslabs.cloudgallery.R
import com.akslabs.cloudgallery.ui.main.screens.local.UploadState

@Composable
fun FloatingBottomBar(
    modifier: Modifier = Modifier,
    uploadState: UploadState,
    onClickUpload: () -> Unit,
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
            when (uploadState) {
                UploadState.CHECKING -> TextIcon(
                    imageVector = Icons.Rounded.CloudSync,
                    title = stringResource(R.string.checking_backup_status),
                    color = contentColor,
                    isEnabled = false
                )

                UploadState.UPLOADING -> TextIcon(
                    imageVector = Icons.Rounded.ArrowCircleUp,
                    title = stringResource(R.string.uploading),
                    color = contentColor,
                    isEnabled = false
                )

                UploadState.UPLOADED -> TextIcon(
                    imageVector = Icons.Rounded.CloudDone,
                    title = stringResource(R.string.backed_up),
                    color = contentColor,
                    isEnabled = false
                )

                UploadState.NOT_UPLOADED -> TextIcon(
                    imageVector = Icons.Rounded.CloudUpload,
                    title = stringResource(R.string.backup_to_cloud),
                    color = contentColor,
                    isEnabled = true,
                    onItemClick = onClickUpload
                )

                UploadState.FAILED -> TextIcon(
                    imageVector = Icons.Rounded.CloudOff,
                    title = stringResource(R.string.upload_failed),
                    color = contentColor,
                    isEnabled = true,
                    onItemClick = onClickUpload
                )

                UploadState.ENQUEUED -> TextIcon(
                    imageVector = Icons.Rounded.Timer,
                    title = stringResource(R.string.upload_enqueued),
                    color = contentColor,
                    isEnabled = true,
                    onItemClick = onClickUpload
                )

                UploadState.BLOCKED -> TextIcon(
                    imageVector = Icons.Rounded.CloudOff,
                    title = stringResource(R.string.upload_blocked),
                    color = contentColor,
                    isEnabled = false
                )
            }
        }
    }
}