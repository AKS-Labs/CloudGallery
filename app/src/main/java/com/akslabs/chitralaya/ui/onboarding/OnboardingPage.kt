package com.akslabs.cloudgallery.ui.onboarding

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.akslabs.cloudgallery.R
import com.akslabs.cloudgallery.api.BotApi
import com.akslabs.cloudgallery.data.localdb.Preferences
import com.akslabs.cloudgallery.ui.components.NoInternetScreen
import com.akslabs.cloudgallery.utils.connectivity.ConnectivityObserver
import com.akslabs.cloudgallery.utils.connectivity.ConnectivityStatus
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Preview
@Composable
fun OnboardingPage(
    modifier: Modifier = Modifier,
    botApi: BotApi = BotApi,
    onProceed: () -> Unit = {},
) {
    val connectivityObserver = remember { ConnectivityObserver }
    val connection by connectivityObserver.observe()
        .collectAsState(initial = ConnectivityStatus.Unavailable)
    val isConnected = connection === ConnectivityStatus.Available

    var visibility by remember { mutableStateOf(false) }

    AnimatedContent(
        targetState = visibility,
        label = stringResource(R.string.onboarding_visibility)
    ) {
        if (it) {
            NoInternetScreen(isConnected = isConnected)
        } else {
            Onboarding { onProceed() }
        }
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
fun Onboarding(
    onProceed: () -> Unit = {},
) {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    var inputToken by remember { mutableStateOf("") }
    var isValidToken by remember { mutableStateOf(true) }
    var showDisclaimer by remember { mutableStateOf(true) }
    var showUidComponent by remember { mutableStateOf(false) }
    var showToken by remember { mutableStateOf(value = false) }
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Spacer(modifier = Modifier.weight(1f))
            Image(
                modifier = Modifier.clip(CircleShape),
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentScale = ContentScale.FillBounds,
                contentDescription = null
            )
            Spacer(modifier = Modifier.height(80.dp))
            TextField(
                value = inputToken,
                onValueChange = { inputToken = it },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                ),
                isError = !isValidToken,
                supportingText = {
                    Column {
                        AnimatedContent(
                            targetState = isValidToken,
                            label = stringResource(R.string.supporttext)
                        ) {
                            if (it) {
                                Text(
                                    text = stringResource(
                                        R.string.recommended_to_only_copy_paste_to_avoid_error
                                    ),
                                    style = MaterialTheme.typography.bodySmall
                                )
                            } else {
                                Text(
                                    text = stringResource(R.string.token_cannot_be_empty),
                                    style = MaterialTheme.typography.bodySmall
                                )
                            }
                        }
                        Spacer(modifier = Modifier.height(12.dp))
                    }
                },
                colors = TextFieldDefaults.colors().copy(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    errorIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                ),
                label = { Text(text = stringResource(R.string.bot_token)) },
                singleLine = true,
                shape = RoundedCornerShape(16.dp),
                textStyle = MaterialTheme.typography.bodySmall,
                trailingIcon = {
                    if (showToken) {
                        IconButton(onClick = { showToken = false }) {
                            Icon(
                                imageVector = Icons.Filled.Visibility,
                                contentDescription = "hide_password"
                            )
                        }
                    } else {
                        IconButton(
                            onClick = { showToken = true }
                        ) {
                            Icon(
                                imageVector = Icons.Filled.VisibilityOff,
                                contentDescription = "hide_password"
                            )
                        }
                    }
                },
                visualTransformation = if (showToken) VisualTransformation.None else PasswordVisualTransformation(),
                modifier = Modifier
                    .width(300.dp)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Button(
                modifier = Modifier
                    .width(300.dp)
                    .height(50.dp),
                shape = RoundedCornerShape(16.dp),
                onClick = {
                    scope.launch {
                        if (inputToken.isNotBlank()) {
                            Preferences.editEncrypted {
                                putString(Preferences.botToken, inputToken)
                            }
                            showUidComponent = true
                        } else {
                            isValidToken = false
                        }
                    }
                }
            ) {
                Text(text = stringResource(R.string.next))
                Spacer(modifier = Modifier.size(16.dp))
                Icon(modifier = Modifier.size(18.dp), imageVector = Icons.Rounded.ArrowForward, contentDescription = "Next")
            }
            Spacer(modifier = Modifier.weight(1f))
        }
        AnimatedVisibility(visible = showDisclaimer) {
            var showSteps by remember { mutableStateOf(false) }
            AlertDialog(
                onDismissRequest = {},
                icon = {
                    Image(
                        painter = painterResource(id = R.drawable.ic_launcher_foreground),
                        contentDescription = stringResource(R.string.app_icon)
                    )
                },
                confirmButton = {
                    AnimatedContent(targetState = showSteps) {
                        if (!it) {
                            TextButton(onClick = { showSteps = true }) {
                                Text(
                                    text = stringResource(R.string.ok),
                                    style = MaterialTheme.typography.bodyLarge,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        } else {
                            TextButton(onClick = { showDisclaimer = false }) {
                                Text(
                                    text = stringResource(R.string.got_it),
                                    style = MaterialTheme.typography.bodyLarge,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                    }
                },
                title = {
                    AnimatedContent(targetState = showSteps) { showSteps ->
                        if (!showSteps) {
                            Text(text = "Disclaimer")
                        } else {
                            Text(text = stringResource(R.string.getting_started))
                        }
                    }
                },
                text = {
                    AnimatedContent(targetState = showSteps) { showSteps ->
                        if (!showSteps) {
                            Text(
                                text = buildString {
                                    append(stringResource(R.string.this_app_uses_your_telegram_bot__))
                                    append(stringResource(R.string.your_bot_is_responsible_for_all__))
                                    append(stringResource(R.string.client_to_interact_with_the_bot__))
                                    append(stringResource(R.string.please_use_it_at_your_own_responsibility__))
                                }
                            )
                        } else {
                            Column {
                                Text(text = stringResource(R.string._1_visit_botfather_on_telegram))
                                Text(text = stringResource(R.string._2_create_a_new_bot))
                                Text(text = stringResource(R.string._3_get_the_bot_token_from_botfather))
                                Text(text = stringResource(R.string._4_paste_the_token_here))
                                Text(text = stringResource(R.string._5_click_on_proceed))
                            }
                        }
                    }
                }
            )
        }
        if (showUidComponent) {
            UidComponent(
                onDismissRequest = {},
                onNavigate = {
                    onProceed()
                }
            )
        }
    }
}