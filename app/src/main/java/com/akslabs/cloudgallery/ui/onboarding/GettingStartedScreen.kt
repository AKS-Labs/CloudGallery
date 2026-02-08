package com.akslabs.cloudgallery.ui.onboarding

import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material.icons.rounded.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.platform.LocalClipboardManager
import com.akslabs.cloudgallery.R
import com.akslabs.cloudgallery.api.BotApi
import com.akslabs.cloudgallery.api.TelegramRawApi
import com.akslabs.cloudgallery.api.TelegramHttp
import com.akslabs.cloudgallery.data.localdb.Preferences
import com.akslabs.cloudgallery.utils.connectivity.ConnectivityObserver
import com.akslabs.cloudgallery.utils.connectivity.ConnectivityStatus
import com.akslabs.cloudgallery.utils.toastFromMainThread
import com.github.kotlintelegrambot.entities.ChatId
import kotlinx.coroutines.launch
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarDuration
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.ui.text.AnnotatedString
import com.akslabs.cloudgallery.utils.Constants


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GettingStartedScreen(
    onProceed: () -> Unit,
    modifier: Modifier = Modifier,
    onBack: (() -> Unit)? = null,
    botApi: BotApi = BotApi
) {

    val context = LocalContext.current
    val clipboardManager = LocalClipboardManager.current
    val scope = rememberCoroutineScope()
    var isVisible by remember { mutableStateOf(false) }
    var botToken by remember { mutableStateOf("") }
    var chatId by remember { mutableStateOf("") }
    var showToken by remember { mutableStateOf(false) }
    var isValidToken by remember { mutableStateOf(true) }
    var isValidChatId by remember { mutableStateOf(true) }
    var isLoading by remember { mutableStateOf(false) }
    var currentStep by remember { mutableStateOf(1) }
    var validationError by remember { mutableStateOf<String?>(null) }
    var showErrorDialog by remember { mutableStateOf(false) }

    // Focus state tracking for keyboard handling (Chat ID only)
    var isChatIdFocused by remember { mutableStateOf(false) }
    val chatIdFocusRequester = remember { FocusRequester() }

    val alpha by animateFloatAsState(
        targetValue = if (isVisible) 1f else 0f,
        animationSpec = tween(durationMillis = 800),
        label = "getting_started_fade_in"
    )

    fun openLinkFromHref(href: String) {
        context.startActivity(
            Intent(Intent.ACTION_VIEW, Uri.parse(href))
        )
    }

    LaunchedEffect(Unit) {
        isVisible = true
        botApi.create()
        botApi.startPolling()
    }
    val snackbarHostState = remember { SnackbarHostState() }
    Scaffold(

        modifier = modifier.alpha(alpha),
        snackbarHost = {
            SnackbarHost(
                hostState = snackbarHostState,
                modifier = Modifier
                    .padding(bottom = 80.dp) // 👈 ye line snackbar ko thoda upar laayegi
            )
        },

        ) { paddingValues ->

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

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 24.dp)
                .padding(
                    bottom = if (isChatIdFocused || chatId.isNotEmpty()) 350.dp else 0.dp
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(25.dp))
            // App Icon
            Image(
                painter = painterResource(id = R.drawable.chitralaya),
                contentDescription = stringResource(R.string.app_icon),
                modifier = Modifier
                    .size(110.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.FillBounds
            )
//            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "Let's set up your Images sync",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.primary
            )

            Spacer(modifier = Modifier.height(18.dp))

            Text(
                text = "Follow these steps to create your Telegram bot and start syncing",
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(modifier = Modifier.height(7.dp))

            // Step-by-step instructions
            SetupStep(
                stepNumber = 1,
                icon = Icons.Rounded.SmartToy,
                title = "Create Your Telegram Bot",
                description = "Open Official Telegram and search for @BotFather",
                details = listOf(
                    "Send /newbot to @BotFather",
                    "Choose a name for your bot (e.g., 'Cloud Gallery Bot')",
                    "Choose a username ending in 'bot' (e.g., 'cloudgallery_bot')",
                    "Copy the bot token that BotFather gives you"
                ),
                isActive = currentStep >= 1
            )

            Spacer(modifier = Modifier.height(7.dp))

            SetupStep(
                stepNumber = 2,
                icon = Icons.Rounded.Key,
                title = "Enter Your Bot Token",
                description = "Paste the token from BotFather below",
                isActive = currentStep >= 2
            )

            Spacer(modifier = Modifier.height(6.dp))

            // Bot Token Input
            OutlinedTextField(
                value = botToken,
                onValueChange = {
                    botToken = it
                    isValidToken = true
                    validationError = null
                    if (it.isNotBlank()) currentStep = maxOf(currentStep, 3)
                },
                label = { Text("Bot Token") },
                placeholder = { Text("123456:ABC-DEF1234ghIkl-zyx57W2v1u123ew11") },
                isError = !isValidToken,
                supportingText = {
                    AnimatedContent(targetState = isValidToken, label = "token_error") { valid ->
                        if (!valid) {
                            Text(
                                text = "Bot token cannot be empty",
                                color = MaterialTheme.colorScheme.error
                            )
                        } else {
                            Text("Keep this token secure - it's like a password for your bot")
                        }
                    }
                },
                trailingIcon = {
                    IconButton(onClick = { showToken = !showToken }) {
                        Icon(
                            imageVector = if (showToken) Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
                            contentDescription = if (showToken) "Hide token" else "Show token"
                        )
                    }
                },
                visualTransformation = if (showToken) VisualTransformation.None else PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp)
            )

            Spacer(modifier = Modifier.height(7.dp))

            SetupStep(
                stepNumber = 3,
                icon = Icons.Rounded.Group,
                title = "Create a Private Group",
                description = "Set up a private group for your Images",
                details = listOf(
                    "Create a new private group in Official Telegram",
                    "Add your bot to the group as an admin",
                    "Send /start in the group",
                    "Be patient it can take some time to show chat id",
                    "It'll only work when Bot himself sends you chat ID in your Group",
                    "Copy the group ID that appears (including the minus sign if any)"
                ),
                isActive = currentStep >= 3
            )

            Spacer(modifier = Modifier.height(6.dp))

            // Chat ID Input
            OutlinedTextField(
                value = chatId,
                onValueChange = {
                    chatId = it
                    isValidChatId = true
                    validationError = null
                },
                label = { Text("Chat/Group ID") },
                placeholder = { Text("-1234567890") },
                isError = !isValidChatId,
                supportingText = {
                    AnimatedContent(targetState = isValidChatId, label = "chatid_error") { valid ->
                        if (!valid) {
                            Text(
                                text = "Invalid chat ID or bot cannot access the group",
                                color = MaterialTheme.colorScheme.error
                            )
                        } else {
                            Text("Can be positive or negative (e.g., -1234567890). Don't ignore the minus sign!")
                        }
                    }
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier
                    .fillMaxWidth()
                    .focusRequester(chatIdFocusRequester)
                    .onFocusChanged { focusState ->
                        isChatIdFocused = focusState.isFocused
                    },
                shape = RoundedCornerShape(12.dp)
            )

            AnimatedVisibility(visible = validationError != null) {
                TextButton(onClick = { showErrorDialog = true }) {
                    Text("See/Copy Error")
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Help Card
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.secondaryContainer
                ),
                shape = RoundedCornerShape(16.dp)
            ) {
                Column(
                    modifier = Modifier.padding(20.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Rounded.Help,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.onSecondaryContainer,
                            modifier = Modifier.size(24.dp)
                        )
                        Spacer(modifier = Modifier.width(12.dp))
                        Text(
                            text = "Need Help?",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSecondaryContainer
                        )
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    Text(
                        text = "• Make sure your bot is added to the group as an admin\n" +
                                "• The chat ID should include the minus sign if negative\n" +
                                "• Your bot token should be kept private and secure\n" +
                                "• If validation fails, double-check your bot setup",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSecondaryContainer,
                        lineHeight = MaterialTheme.typography.bodyMedium.lineHeight * 1.3
                    )

                    Spacer(modifier = Modifier.height(12.dp))
                    // 🔹 Clickable text with Telegram icon
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.clickable {
                            openLinkFromHref(Constants.joinTelegra)
                        }
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.telegram),
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.size(20.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "Join Telegram Group for more help",
                            color = MaterialTheme.colorScheme.primary,
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Medium
                        )
                    }

                }
            }



        // Proceed Button
        Spacer(modifier = Modifier.height(32.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp),
            horizontalArrangement = Arrangement.End
        ) {
            Button(
                onClick = {
                    scope.launch {
                        // Check connectivity first
                        val connectivityStatus = ConnectivityObserver.status()
                        if (connectivityStatus != ConnectivityStatus.Available) {
                            context.toastFromMainThread("No internet connection. Please check your connection and try again.")
                            return@launch
                        }

                        if (botToken.isBlank()) {
                            isValidToken = false
                            return@launch
                        }

                        if (chatId.isBlank()) {
                            isValidChatId = false
                            return@launch
                        }

                        isLoading = true
                        validationError = null

                        try {
                            // Save bot token
                            Preferences.editEncrypted {
                                putString(Preferences.botToken, botToken)
                            }

                            // Validate chat ID
                            val id = chatId.toLongOrNull()
                            if (id != null) {
                                Log.i("GettingStartedScreen", "Validating chat ID: $id")

                                val validationResult = TelegramHttp.validateChat(id)

                                if (validationResult.first) {
                                    Preferences.editEncrypted {
                                        putLong(Preferences.channelId, id)
                                    }
                                    botApi.stopPolling()
                                    onProceed()
                                } else {
                                    isValidChatId = false
                                    validationError = validationResult.second ?: "Validation failed with no error message."
                                }
                            } else {
                                isValidChatId = false
                                validationError = "Invalid chat ID format: $chatId"
                            }
                        } catch (e: Exception) {
                            Log.e("GettingStartedScreen", "Error validating inputs", e)
                            isValidChatId = false
                            validationError = e.stackTraceToString()
                        } finally {
                            isLoading = false
                        }
                    }
                },
                enabled = !isLoading && botToken.isNotBlank() && chatId.isNotBlank(),
                modifier = Modifier
                    .height(56.dp)
                    .widthIn(min = 120.dp),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )
            ) {
                if (isLoading) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(20.dp),
                        strokeWidth = 2.dp,
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                } else {
                    Icon(
                        imageVector = Icons.Rounded.ArrowForward,
                        contentDescription = null,
                        modifier = Modifier.size(20.dp)
                    )
                }
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = if (isLoading) "Validating..." else "Proceed",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.SemiBold
                )
            }}
        }
    }
}


@Composable
fun ErrorDialog(error: String, onDismiss: () -> Unit, onCopy: () -> Unit) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Validation Error") },
        text = {
            Column {
                Text("The following error occurred:")
                Spacer(modifier = Modifier.height(8.dp))
                Text(error, style = MaterialTheme.typography.bodySmall)
            }
        },
        confirmButton = {
            Button(onClick = onCopy) {
                Text("Copy Error")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Dismiss")
            }
        }
    )
}



@Composable

private fun SetupStep(

    stepNumber: Int,

    icon: ImageVector,

    title: String,

    description: String,

    details: List<String> = emptyList(),

    isActive: Boolean = false,

    modifier: Modifier = Modifier

) {

    Card(

        modifier = modifier.fillMaxWidth(),

        colors = CardDefaults.cardColors(

            containerColor = if (isActive) {

                MaterialTheme.colorScheme.primaryContainer

            } else {

                MaterialTheme.colorScheme.surfaceVariant

            }

        ),

        shape = RoundedCornerShape(16.dp)

    ) {

        Column(

            modifier = Modifier.padding(20.dp)

        ) {

            Row(

                verticalAlignment = Alignment.CenterVertically,

                modifier = Modifier.fillMaxWidth()

            ) {

                Surface(

                    shape = CircleShape,

                    color = if (isActive) {

                        MaterialTheme.colorScheme.primary

                    } else {

                        MaterialTheme.colorScheme.outline

                    },

                    modifier = Modifier.size(32.dp)

                ) {

                    Box(

                        contentAlignment = Alignment.Center,

                        modifier = Modifier.fillMaxSize()

                    ) {

                        Text(

                            text = stepNumber.toString(),

                            style = MaterialTheme.typography.labelLarge,

                            fontWeight = FontWeight.Bold,

                            color = if (isActive) {

                                MaterialTheme.colorScheme.onPrimary

                            } else {

                                MaterialTheme.colorScheme.onSurface

                            }

                        )

                    }

                }



                Spacer(modifier = Modifier.width(16.dp))



                Icon(

                    imageVector = icon,

                    contentDescription = null,

                    tint = if (isActive) {

                        MaterialTheme.colorScheme.onPrimaryContainer

                    } else {

                        MaterialTheme.colorScheme.onSurfaceVariant

                    },

                    modifier = Modifier.size(24.dp)

                )



                Spacer(modifier = Modifier.width(12.dp))



                Column(modifier = Modifier.weight(1f)) {

                    Text(

                        text = title,

                        style = MaterialTheme.typography.titleMedium,

                        fontWeight = FontWeight.Bold,

                        color = if (isActive) {

                            MaterialTheme.colorScheme.onPrimaryContainer

                        } else {

                            MaterialTheme.colorScheme.onSurfaceVariant

                        }

                    )

                    Text(

                        text = description,

                        style = MaterialTheme.typography.bodyMedium,

                        color = if (isActive) {

                            MaterialTheme.colorScheme.onPrimaryContainer

                        } else {

                            MaterialTheme.colorScheme.onSurfaceVariant

                        }

                    )

                }

            }



            if (details.isNotEmpty() && isActive) {

                Spacer(modifier = Modifier.height(16.dp))

                details.forEach { detail ->

                    Row(

                        modifier = Modifier.padding(vertical = 2.dp)

                    ) {

                        Text(

                            text = "• ",

                            style = MaterialTheme.typography.bodyMedium,

                            color = MaterialTheme.colorScheme.onPrimaryContainer

                        )

                        Text(

                            text = detail,

                            style = MaterialTheme.typography.bodyMedium,

                            color = MaterialTheme.colorScheme.onPrimaryContainer

                        )

                    }

                }

            }

        }

    }

}
