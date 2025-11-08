package com.akslabs.chitralaya.ui.components

import android.net.http.SslCertificate.restoreState
import android.net.http.SslCertificate.saveState
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowUpward
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Cloud
import androidx.compose.material.icons.filled.Download
import androidx.compose.animation.core.*
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.offset
import androidx.compose.material.icons.filled.ArrowUpward
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.HorizontalFloatingToolbar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.*
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex

import androidx.compose.runtime.getValue
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.graphics.Color


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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
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
    var fabState by remember { mutableStateOf(FabState.Inactive) }
    var isUploading by remember { mutableStateOf(false) }


    val transition = rememberInfiniteTransition(label = "")
    val offsetY by transition.animateFloat(
        initialValue = 0f,
        targetValue = -60f,
        animationSpec = infiniteRepeatable(
            animation = tween(1500, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = ""
    )
    val alpha by transition.animateFloat(
        initialValue = 1f,
        targetValue = 0f,
        animationSpec = infiniteRepeatable(
            animation = tween(1500, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = ""
    )

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
                onClick = { isUploading = !isUploading }
            ) {
                if (isUploading) {
                    Icon(
                        imageVector = Icons.Filled.ArrowUpward,
                        contentDescription = "Uploading",
                        modifier = Modifier
                            .offset(y = offsetY.dp)
//                            .alpha(alpha)
                    )
                } else {
                    Icon(
                        imageVector = Icons.Filled.ArrowUpward,
                        contentDescription = "Upload"
                    )
                }
//                Icon(Icons.Filled.ArrowUpward, contentDescription = "Localized description")
            }

        },
    )
}

@Composable
private fun LeadingContent(navController: NavHostController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val isDarkTheme = isSystemInDarkTheme()
    val isSelected = currentRoute == Screens.LocalPhotos.route

    IconButton(
        onClick = {
            navController.navigate(Screens.LocalPhotos.route) {
                popUpTo(navController.graph.startDestinationId) { saveState = true }
                launchSingleTop = true
                restoreState = true
            }
        }
    ) {
        Icon(
            imageVector = Icons.Filled.PhoneAndroid,
            contentDescription = "Device Photos",
            tint = when {
                isSelected -> MaterialTheme.colorScheme.primary
                isDarkTheme -> Color.White
                else -> Color.Black
            }
        )
    }

    Spacer(modifier = Modifier.size(18.dp))
}


@Composable
private fun TrailingContent(navController: NavHostController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val isCloudSelected = currentRoute == Screens.RemotePhotos.route
    val isDarkTheme = isSystemInDarkTheme()

    Spacer(modifier = Modifier.size(18.dp))

    IconButton(
        onClick = {
            navController.navigate(Screens.RemotePhotos.route) {
                popUpTo(navController.graph.startDestinationId) { saveState = true }
                launchSingleTop = true
                restoreState = true
            }
        }
    ) {
        Icon(
            imageVector = Icons.Filled.Cloud,
            contentDescription = "Cloud Photos",
            tint = when {
                isCloudSelected -> MaterialTheme.colorScheme.primary
                isDarkTheme -> Color.White
                else -> Color.Black
            }
        )
    }
}
