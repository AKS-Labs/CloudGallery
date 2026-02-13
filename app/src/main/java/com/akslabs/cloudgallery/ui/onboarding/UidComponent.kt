package com.akslabs.cloudgallery.ui.onboarding

import android.util.Log
import android.widget.Toast
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.Send
import androidx.compose.material.icons.rounded.AddCircle
import androidx.compose.material.icons.rounded.CheckCircle
import androidx.compose.material.icons.rounded.ContentCopy
import androidx.compose.material.icons.rounded.PersonAdd
import androidx.compose.material.icons.rounded.Send
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.akslabs.cloudgallery.R
import com.akslabs.cloudgallery.api.BotApi
import com.akslabs.cloudgallery.api.TelegramHttp
import com.akslabs.cloudgallery.data.localdb.Preferences

import kotlinx.coroutines.launch

@Composable
fun UidComponent(
    modifier: Modifier = Modifier,
    onDismissRequest: () -> Unit,
    onNavigate: () -> Unit,
    botApi: BotApi = BotApi,
) {
    var inputIdState by remember { mutableStateOf("") }
    var isValidInput by remember { mutableStateOf(true) }
    var showStepsDisclaimer by remember { mutableStateOf(true) }
    val scope = rememberCoroutineScope()
    var validationError by remember { mutableStateOf<String?>(null) }
    var showErrorDialog by remember { mutableStateOf(false) }
    val clipboardManager = LocalClipboardManager.current
    val context = LocalContext.current

    LaunchedEffect(key1 = Unit) {
        botApi.create()
        botApi.startPolling()
    }

    if (showErrorDialog) {
        ErrorDialog(
            error = validationError ?: "Unknown error",
            onDismiss = { showErrorDialog = false },
            onCopy = {
                clipboardManager.setText(AnnotatedString(validationError ?: "Unknown error"))
                showErrorDialog = false
                Toast.makeText(context, "Error copied to clipboard", Toast.LENGTH_SHORT).show()
            }
        )
    }

    Dialog(
        onDismissRequest = onDismissRequest,
        properties = remember { DialogProperties(usePlatformDefaultWidth = false) }
    ) {
        AnimatedVisibility(visible = showStepsDisclaimer) {
            AlertDialog(
                onDismissRequest = {},
                confirmButton = {
                    TextButton(
                        onClick = { showStepsDisclaimer = false },
                        modifier = Modifier.padding(8.dp)
                    ) {
                        Text(
                            text = stringResource(id = R.string.got_it),
                            style = MaterialTheme.typography.labelLarge,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                },
                shape = RoundedCornerShape(28.dp),
                containerColor = MaterialTheme.colorScheme.surfaceContainer,
                title = { 
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Surface(
                            modifier = Modifier.size(80.dp),
                            shape = RoundedCornerShape(20.dp),
                            color = MaterialTheme.colorScheme.primary.copy(alpha = 0.1f)
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_launcher_foreground),
                                    contentDescription = stringResource(id = R.string.app_icon),
                                    tint = MaterialTheme.colorScheme.primary,
                                    modifier = Modifier.size(56.dp)
                                )
                            }
                        }
                        Spacer(modifier = Modifier.height(20.dp))
                        Text(
                            text = stringResource(R.string.just_a_few_more),
                            style = MaterialTheme.typography.headlineSmall,
                            fontWeight = FontWeight.ExtraBold,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth(),
                            letterSpacing = (-0.5).sp
                        )
                    }
                },
                text = {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 8.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp),
                        horizontalAlignment = Alignment.Start
                    ) {
                        StepItem(
                            text = stringResource(R.string._1_create_a_private_group_on_telegram),
                            icon = Icons.Rounded.AddCircle,
                            color = MaterialTheme.colorScheme.primary
                        )
                        StepItem(
                            text = stringResource(R.string._2_add_the_bot_to_the_group),
                            icon = Icons.Rounded.PersonAdd,
                            color = MaterialTheme.colorScheme.secondary
                        )
                        StepItem(
                            text = stringResource(R.string._3_type_start_in_the_group),
                            icon = Icons.Rounded.Send,
                            color = MaterialTheme.colorScheme.tertiary
                        )
                        StepItem(
                            text = stringResource(R.string._4_copy_and_paste_the_unique_id_here),
                            icon = Icons.Rounded.ContentCopy,
                            color = MaterialTheme.colorScheme.primary
                        )
                        StepItem(
                            text = stringResource(id = R.string._5_click_on_proceed),
                            icon = Icons.Rounded.CheckCircle,
                            color = MaterialTheme.colorScheme.secondary
                        )
                    }
                }
            )
        }
        Box(
            modifier = Modifier
                .padding(24.dp)
                .clip(RoundedCornerShape(28.dp))
                .background(MaterialTheme.colorScheme.surfaceContainer)
                .padding(24.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = modifier.padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TextField(
                    value = inputIdState,
                    onValueChange = {
                        inputIdState = it
                        isValidInput = true
                        validationError = null
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number
                    ),
                    isError = !isValidInput,
                    supportingText = {
                        AnimatedContent(
                            targetState = isValidInput,
                            label = stringResource(R.string.supporttext)
                        ) {
                            Column {
                                if (!it) {
                                    Text(
                                        text = stringResource(R.string.invalid_uid_or_token),
                                        style = MaterialTheme.typography.bodySmall,
                                        color = MaterialTheme.colorScheme.error
                                    )
                                } else {
                                    Text(
                                        text = stringResource(
                                            R.string.can_be_ve_or_ve_e_g_1234567890_do_not_ignore_the_sign
                                        ),
                                        style = MaterialTheme.typography.bodySmall,
                                        color = MaterialTheme.colorScheme.onSurfaceVariant
                                    )
                                }
                                Spacer(modifier = Modifier.height(8.dp))
                            }
                        }
                    },
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = MaterialTheme.colorScheme.surfaceContainerHighest,
                        unfocusedContainerColor = MaterialTheme.colorScheme.surfaceContainerHighest,
                        errorContainerColor = MaterialTheme.colorScheme.errorContainer.copy(alpha = 0.3f),
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        errorIndicatorColor = Color.Transparent,
                    ),
                    label = { Text(text = stringResource(R.string.unique_id_start_in_gc)) },
                    singleLine = true,
                    shape = RoundedCornerShape(16.dp),
                    textStyle = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.fillMaxWidth()
                )
                AnimatedVisibility(visible = validationError != null) {
                    TextButton(onClick = { showErrorDialog = true }) {
                        Text("See/Copy Error", color = MaterialTheme.colorScheme.error)
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    shape = RoundedCornerShape(28.dp),
                    elevation = ButtonDefaults.buttonElevation(defaultElevation = 0.dp),
                    onClick = {
                        scope.launch {
                            try {
                                Log.i("UidComponent", "Attempting to validate chat ID: $inputIdState")
                                val id = inputIdState.toLongOrNull()
                                if (id != null) {
                                    Log.i("UidComponent", "Parsed chat ID: $id")

                                    val validationResult = TelegramHttp.validateChat(id)
                                    if (validationResult.first) {
                                        // verification successful
                                        Log.i("UidComponent", "Chat ID verification successful, saving to preferences")
                                        Preferences.editEncrypted { putLong(Preferences.channelId, id) }
                                        botApi.stopPolling()
                                        Log.i("UidComponent", "Successfully configured chat ID: $id")
                                        // navigate to main screen
                                        onNavigate()
                                    } else {
                                        Log.w("UidComponent", "Chat ID validation failed")
                                        isValidInput = false
                                        validationError = validationResult.second ?: "Validation failed with no error message."
                                    }
                                } else {
                                    Log.w("UidComponent", "Invalid chat ID format: $inputIdState")
                                    isValidInput = false
                                    validationError = "Invalid chat ID format: $inputIdState"
                                }
                            } catch (e: Exception) {
                                Log.e("UidComponent", "Error validating chat ID: $inputIdState", e)
                                isValidInput = false
                                validationError = e.stackTraceToString()
                            }
                        }
                    }
                ) {
                    Text(
                        text = stringResource(id = R.string.proceed),
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}

@Composable
private fun StepItem(text: String, icon: ImageVector, color: Color) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Surface(
            modifier = Modifier.size(36.dp),
            shape = RoundedCornerShape(10.dp),
            color = color.copy(alpha = 0.1f)
        ) {
            Box(contentAlignment = Alignment.Center) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = color,
                    modifier = Modifier.size(18.dp)
                )
            }
        }
        Text(
            text = text,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            lineHeight = 20.sp,
            fontWeight = FontWeight.Medium
        )
    }
}
