package com.akslabs.cloudgallery.ui.permission

import android.Manifest
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.akslabs.cloudgallery.R
import com.akslabs.cloudgallery.ui.components.PermissionDialog
import com.akslabs.cloudgallery.ui.components.PhotosPermissionTextProvider

@Composable
fun PermissionDialogScreen(
    modifier: Modifier = Modifier,
    permissionsToRequest: Array<String>,
    onPermissionLauncherResult: (Map<String, Boolean>) -> Unit,
    dialogQueue: List<String>,
    isPermanentyDeclined: (String) -> Boolean,
    onGoToAppSettingsClick: () -> Unit,
    onDismissDialog: () -> Unit,
    onOkClick: () -> Unit,
) {
    val multiplePermissionResultLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestMultiplePermissions(),
        onResult = onPermissionLauncherResult
    )
    Surface(
        color = MaterialTheme.colorScheme.background,
        shape = MaterialTheme.shapes.medium
    ) {
        Column(
            modifier = Modifier.padding(40.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(R.string.permissions_required),
                style = MaterialTheme.typography.headlineLarge
            )
            Spacer(modifier = Modifier.size(40.dp))
            Text(
                text = stringResource(R.string.this_app_requires_permission_to_photos_and_notifications) +
                    stringResource(R.string.to_work_as_intended_please_grant_the_permissions_to_continue)
            )
            Spacer(modifier = Modifier.size(40.dp))
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                onClick = {
                    multiplePermissionResultLauncher.launch(
                        permissionsToRequest
                    )
                },
                shape = RoundedCornerShape(16.dp)
            ) {
                Text(
                    text = stringResource(R.string.grant_permissions),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }

    dialogQueue
        .reversed()
        .forEach { permission ->
            PermissionDialog(
                permissionTextProvider = when (permission) {
                    Manifest.permission.READ_MEDIA_IMAGES -> {
                        PhotosPermissionTextProvider()
                    }

                    Manifest.permission.READ_EXTERNAL_STORAGE -> {
                        PhotosPermissionTextProvider()
                    }

                    else -> return@forEach
                },
                isPermanentlyDeclined = isPermanentyDeclined(permission),
                onDismiss = onDismissDialog,
                onOkClick = onOkClick,
                onGoToAppSettingsClick = onGoToAppSettingsClick
            )
        }
}