package com.akslabs.cloudgallery.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.CloudDone
import androidx.compose.material.icons.rounded.CloudOff
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.akslabs.cloudgallery.R
import com.akslabs.cloudgallery.utils.connectivity.ConnectivityObserver
import com.akslabs.cloudgallery.utils.connectivity.ConnectivityStatus
import kotlinx.coroutines.delay

@Composable
fun ConnectivityStatusPopup() {
    val connectivityObserver = remember { ConnectivityObserver }
    val connection by connectivityObserver.observe()
        .collectAsState(initial = ConnectivityStatus.Unavailable)
    val isConnected = connection === ConnectivityStatus.Available

    var visibility by remember { mutableStateOf(false) }

    AnimatedVisibility(
        visible = visibility,
        enter = expandVertically(),
        exit = shrinkVertically()
    ) {
        ConnectivityStatusBox(isConnected = isConnected)
    }

    LaunchedEffect(isConnected) {
        if (!isConnected) {
            delay(500)
            visibility = true
        } else {
            delay(2000)
            visibility = false
        }
    }
}

@Composable
fun ConnectivityStatusBox(isConnected: Boolean) {
    val backgroundColor by animateColorAsState(
        targetValue = if (isConnected) MaterialTheme.colorScheme.errorContainer else MaterialTheme.colorScheme.error,
        label = stringResource(R.string.connectivity_status_background_color)
    )
    val contentColor by animateColorAsState(
        targetValue = if (isConnected) MaterialTheme.colorScheme.onErrorContainer else MaterialTheme.colorScheme.onError,
        label = stringResource(R.string.connectivity_status_content_color)
    )
    val message = if (isConnected) {
        stringResource(
            R.string.back_online
        )
    } else {
        stringResource(R.string.no_internet_connection)
    }
    val iconVector = if (isConnected) {
        Icons.Rounded.CloudDone
    } else {
        Icons.Rounded.CloudOff
    }

    Box(
        modifier = Modifier
            .background(backgroundColor)
            .fillMaxWidth()
            .height(60.dp)
            .padding(8.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = iconVector,
                stringResource(R.string.connectivity_icon),
                tint = contentColor
            )
            Spacer(modifier = Modifier.size(8.dp))
            Text(message, color = contentColor, fontSize = 15.sp)
        }
    }
}
