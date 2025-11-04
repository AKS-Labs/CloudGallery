package com.akslabs.chitralaya.ui.components

import android.net.http.SslCertificate.restoreState
import android.net.http.SslCertificate.saveState
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Cloud
import androidx.compose.material.icons.filled.Download
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.PhoneAndroid
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.FloatingToolbarDefaults.ScreenOffset
import androidx.compose.material3.HorizontalFloatingToolbar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.navigation.NavHostController

import com.akslabs.cloudgallery.ui.main.nav.Screens

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun BottomToolbarFAB(
    expanded: Boolean,
    onExpandedChange: (Boolean) -> Unit,
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    HorizontalFloatingToolbar(
        modifier = modifier
            .offset(y = -ScreenOffset)
            .zIndex(1f),
        expanded = expanded,
        leadingContent = { LeadingContent(navController) },
        trailingContent = { TrailingContent(navController) },
        content = {
            FilledIconButton(
                modifier = Modifier.width(64.dp),
                onClick = { /* TODO: action */ },
            ) {
                androidx.compose.material3.Icon(
                    Icons.Filled.Add,
                    contentDescription = "Add"
                )
            }
        },
    )
}

@Composable
private fun LeadingContent(navController: NavHostController) {
    IconButton(
        onClick = {
            navController.navigate(Screens.LocalPhotos.route) {
                popUpTo(navController.graph.startDestinationId) { saveState = true }
                launchSingleTop = true
                restoreState = true
            }
        }
    ) {
        Icon(Icons.Filled.PhoneAndroid, contentDescription = "Device Photos")
    }

    Spacer(modifier = Modifier.size(18.dp)) // optional spacing between icons


}

@Composable
private fun TrailingContent(navController: NavHostController) {

    Spacer(modifier = Modifier.size(18.dp)) // optional

    IconButton(
        onClick = {
            navController.navigate(Screens.RemotePhotos.route) {
                popUpTo(navController.graph.startDestinationId) { saveState = true }
                launchSingleTop = true
                restoreState = true
            }
        }
    ) {
        Icon(Icons.Filled.Cloud, contentDescription = "Cloud Photos")
    }
}
