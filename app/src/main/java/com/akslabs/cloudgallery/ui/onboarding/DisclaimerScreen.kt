package com.akslabs.cloudgallery.ui.onboarding

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.akslabs.cloudgallery.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DisclaimerScreen(
    onAcknowledge: () -> Unit,
    modifier: Modifier = Modifier
) {
    var isVisible by remember { mutableStateOf(false) }
    val alpha by animateFloatAsState(
        targetValue = if (isVisible) 1f else 0f,
        animationSpec = tween(durationMillis = 800),
        label = "disclaimer_fade_in"
    )

    LaunchedEffect(Unit) {
        isVisible = true
    }

    Scaffold(
        modifier = modifier.alpha(alpha),
        containerColor = MaterialTheme.colorScheme.surfaceContainerLow,
        bottomBar = {
            Surface(
                modifier = Modifier.fillMaxWidth(),
                color = MaterialTheme.colorScheme.surfaceContainerLow,
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp, vertical = 20.dp),
                    horizontalArrangement = Arrangement.End
                ) {
                    Button(
                        onClick = onAcknowledge,
                        modifier = Modifier
                            .height(56.dp)
                            .widthIn(min = 160.dp),
                        shape = RoundedCornerShape(28.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.primary
                        ),
                        elevation = ButtonDefaults.buttonElevation(
                            defaultElevation = 0.dp,
                            pressedElevation = 2.dp
                        )
                    ) {
                        Icon(
                            imageVector = Icons.Rounded.CheckCircle,
                            contentDescription = null,
                            modifier = Modifier.size(20.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "I Acknowledge",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(25.dp))
            
            // Large App Icon (No background)
            Image(
                painter = painterResource(id = R.drawable.chitralaya),
                contentDescription = stringResource(R.string.app_icon),
                modifier = Modifier
                    .size(210.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.FillBounds
            )
            
//            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "Chitralaya",
                style = MaterialTheme.typography.displaySmall.copy(
                    fontWeight = FontWeight.Black,
                    letterSpacing = (-1).sp
                ),
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.primary
            )
            
            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "Where Your Memories Get To Live Forever",
                style = MaterialTheme.typography.titleLarge.copy(
                    fontWeight = FontWeight.Black,
                    letterSpacing = 0.5.sp
                ),
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.primary
            )
            
            Spacer(modifier = Modifier.height(20.dp))
            
            Text(
                text = "Before we begin, please read and understand the following important information:",
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            
            Spacer(modifier = Modifier.height(32.dp))
            
            // Privacy Policy Section
            DisclaimerSection(
                icon = Icons.Rounded.Security,
                title = "Privacy & Data Handling",
                content = """
                    • Your images are synced directly to YOUR Telegram bot
                    • We do NOT store, access, or transmit your data to any servers
                    • All data remains under YOUR complete control
                    • Zero analytics, tracking, or third-party data sharing
                    • Your bot token and chat ID are encrypted locally using AES-256
                    • You can delete all data at any time
                """.trimIndent(),
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.onPrimaryContainer
            )
            
            Spacer(modifier = Modifier.height(20.dp))
            
            // User Responsibilities Section
            DisclaimerSection(
                icon = Icons.Rounded.Person,
                title = "Your Responsibilities",
                content = """
                    • You are responsible for creating and managing your Telegram bot
                    • Ensure your bot token is kept secure and not shared
                    • Use this app only for legitimate Images synchronization purposes
                    • Comply with Telegram's Terms of Service and local laws
                    • This app is not intended for spam or malicious activities
                    • Use at your own responsibility and discretion
                """.trimIndent(),
                containerColor = MaterialTheme.colorScheme.secondaryContainer,
                contentColor = MaterialTheme.colorScheme.onSecondaryContainer
            )
            
            Spacer(modifier = Modifier.height(20.dp))
            
            // Terms of Use Section
            DisclaimerSection(
                icon = Icons.Rounded.Gavel,
                title = "Terms of Use",
                content = """
                    • This app requires READ_IMAGES permission to access your Images
                    • Internet permission is used ONLY for Telegram API communication
                    • Background services monitor Images changes for real-time sync
                    • The app is provided "as-is" without warranties
                    • We are not liable for any data loss or service interruptions
                    • You can stop using the app and delete all data at any time
                """.trimIndent(),
                containerColor = MaterialTheme.colorScheme.tertiaryContainer,
                contentColor = MaterialTheme.colorScheme.onTertiaryContainer
            )
            
            Spacer(modifier = Modifier.height(20.dp))
            
            // Telegram Bot Requirements
            DisclaimerSection(
                icon = Icons.Rounded.SmartToy,
                title = "Telegram Bot Setup",
                content = """
                    • You must create your own Telegram bot using @BotFather
                    • The bot acts as a secure bridge for your Images
                    • You need to create a private group/channel for images storage
                    • Your bot token is like a password - keep it secure
                    • Only you have access to your bot and synced messages
                    • The bot operates independently of any servers
                """.trimIndent(),
                containerColor = MaterialTheme.colorScheme.errorContainer,
                contentColor = MaterialTheme.colorScheme.onErrorContainer
            )
            
            Spacer(modifier = Modifier.height(32.dp))
            
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.7f)
                ),
                shape = RoundedCornerShape(24.dp)
            ) {
                Column(
                    modifier = Modifier.padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Accept Terms & Conditions",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        text = "By clicking 'I Acknowledge', you confirm that you have read, understood, and agree to these terms and conditions.",
                        style = MaterialTheme.typography.bodyMedium,
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colorScheme.onPrimaryContainer,
                        lineHeight = 22.sp
                    )
                }
            }
            
            Spacer(modifier = Modifier.height(40.dp))
            
//            Text(
//                text = "By clicking 'I Acknowledge', you confirm that you have read, understood, and agree to these terms and conditions.",
//                style = MaterialTheme.typography.bodyMedium,
//                textAlign = TextAlign.Center,
//                color = MaterialTheme.colorScheme.onSurfaceVariant,
//                fontWeight = FontWeight.Medium
//            )
//
//            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}

@Composable
private fun DisclaimerSection(
    icon: ImageVector,
    title: String,
    content: String,
    containerColor: Color,
    contentColor: Color,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = containerColor
        ),
        shape = RoundedCornerShape(24.dp)
    ) {
        Column(
            modifier = Modifier.padding(24.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Surface(
                    modifier = Modifier.size(40.dp),
                    shape = RoundedCornerShape(12.dp),
                    color = contentColor.copy(alpha = 0.15f)
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Icon(
                            imageVector = icon,
                            contentDescription = null,
                            tint = contentColor,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = contentColor,
                    letterSpacing = 0.sp
                )
            }
            
            Spacer(modifier = Modifier.height(16.dp))
            
            Text(
                text = content,
                style = MaterialTheme.typography.bodyMedium,
                color = contentColor.copy(alpha = 0.85f),
                lineHeight = 22.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}
