package com.akslabs.cloudgallery.ui.onboarding

import android.util.Log
import androidx.compose.animation.AnimatedContent
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GettingStartedScreen(
    onProceed: () -> Unit,
    modifier: Modifier = Modifier,
    onBack: (() -> Unit)? = null,
    botApi: BotApi = BotApi
) {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    var isVisible by remember { mutableStateOf(false) }
    var botToken by remember { mutableStateOf("") }
    var chatId by remember { mutableStateOf("") }
    var showToken by remember { mutableStateOf(false) }
    var isValidToken by remember { mutableStateOf(true) }
    var isValidChatId by remember { mutableStateOf(true) }
    var isLoading by remember { mutableStateOf(false) }
    var currentStep by remember { mutableStateOf(1) }

    // Focus state tracking for keyboard handling (Chat ID only)
    var isChatIdFocused by remember { mutableStateOf(false) }
    val chatIdFocusRequester = remember { FocusRequester() }

    val alpha by animateFloatAsState(
        targetValue = if (isVisible) 1f else 0f,
        animationSpec = tween(durationMillis = 800),
        label = "getting_started_fade_in"
    )

    LaunchedEffect(Unit) {
        isVisible = true
        botApi.create()
        botApi.startPolling()
    }

    Scaffold(
        modifier = modifier.alpha(alpha),

    ) { paddingValues ->
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
            
            // App Icon
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = stringResource(R.string.app_icon),
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.FillBounds
            )
            
            Text(
                text = "Let's set up your SMS sync",
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
                    "Choose a name for your bot (e.g., 'My SMS Bot')",
                    "Choose a username ending in 'bot' (e.g., 'mysms_bot')",
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
                description = "Set up a private group for your SMS messages",
                details = listOf(
                    "Create a new private group in Official Telegram",
                    "Add your bot to the group as an admin",
                    "Send /start in the group",
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

                            try {
                                // Save bot token
                                Preferences.editEncrypted {
                                    putString(Preferences.botToken, botToken)
                                }

                                // Validate chat ID
                                val id = chatId.toLongOrNull()
                                if (id != null) {
                                    Log.i("GettingStartedScreen", "Validating chat ID: $id")
                                    // Use raw Telegram API to avoid strict JSON parsing issues on pinned_message
                                    val canAccess = try {
                                        // First try very-lenient HTTP+JSONObject path
                                        TelegramHttp.validateChat(id).takeIf { it } ?: run {
                                            val api = TelegramRawApi.create()
                                            val resp = api.getChat(id)
                                            resp.ok && resp.result?.id == id
                                        }
                                    } catch (e: Exception) {
                                        Log.w("GettingStartedScreen", "Raw getChat failed, falling back to BotApi", e)
                                        botApi.getChat(ChatId.fromId(id))
                                    }

                                    if (canAccess) {
                                        Preferences.editEncrypted {
                                            putLong(Preferences.channelId, id)
                                        }
                                        botApi.stopPolling()
                                        onProceed()
                                    } else {
                                        isValidChatId = false
                                    }
                                } else {
                                    isValidChatId = false
                                }
                            } catch (e: Exception) {
                                Log.e("GettingStartedScreen", "Error validating inputs", e)
                                isValidChatId = false
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
                }
            }
        }
    }
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
                                MaterialTheme.colorScheme.surface
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

