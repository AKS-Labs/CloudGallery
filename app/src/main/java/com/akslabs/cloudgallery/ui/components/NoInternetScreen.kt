package com.akslabs.cloudgallery.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.CloudOff
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.akslabs.cloudgallery.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

// @Preview
@Composable
fun NoInternetScreen(modifier: Modifier = Modifier, isConnected: Boolean) {
    var showSpinner by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()
    val context = LocalContext.current

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        ExpressiveEmptyState(
            icon = Icons.Rounded.CloudOff,
            title = stringResource(R.string.no_internet_connection),
            description = stringResource(R.string.oops_looks_like_there_s_no_internet_connection) +
                    "\n" + stringResource(R.string.please_check_your_connection_and_try_again),
            actionText = if (showSpinner) "Checking..." else stringResource(R.string.retry),
            onActionClick = {
                scope.launch {
                    showSpinner = true
                    delay(1500) // Slightly longer for "expressive" feel
                    showSpinner = false
                }
            }
        )

        if (showSpinner || isConnected) {
            CircularProgressIndicator(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 64.dp)
                    .size(32.dp),
                strokeWidth = 3.dp,
                strokeCap = StrokeCap.Round
            )
        }
    }
}
