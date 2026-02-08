package com.akslabs.chitralaya.ui.components


import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SupportSheet(
    sheetState: SheetState,
    onDismissRequest: () -> Unit
) {
    val scope = rememberCoroutineScope()
    val uriHandler = LocalUriHandler.current
    var showCryptoOptions by rememberSaveable {
        mutableStateOf(false)
    }
    val clipboard = LocalClipboardManager.current

    data class OptionItem(
        val text: String,
        val summary: String? = null,
        val icon: ImageVector,
        val color: androidx.compose.ui.graphics.Color,
        val onClick: (String) -> Unit
    )

    val mainOptions = remember {
        listOf(
            OptionItem(
                text = "PayPal",
                summary = "Fast and secure checkout",
                icon = Icons.Rounded.Payments,
                color = androidx.compose.ui.graphics.Color(0xFF003087),
                onClick = {
                    uriHandler.openUri("https://paypal.me/AKSLabsOfficial")
                }
            ),
            OptionItem(
                text = "Github Sponsor",
                summary = "Support open source",
                icon = Icons.Rounded.Favorite,
                color = androidx.compose.ui.graphics.Color(0xFFEA4AAA),
                onClick = {
                    uriHandler.openUri("https://github.com/sponsors/AKS-Labs")
                }
            ),
            OptionItem(
                text = "UPI",
                summary = "One-click local transfer",
                icon = Icons.Rounded.AccountBalanceWallet,
                color = androidx.compose.ui.graphics.Color(0xFF6200EE),
                onClick = {
                    showCryptoOptions = true
                }
            )
        )
    }

    val cryptoOnClick: (String) -> Unit = {
        clipboard.setText(AnnotatedString(it))
        scope.launch {
            // Optional: Show a subtle confirmation if needed, but clipboard copy is primary
        }
    }

    val cryptoOptions = remember {
        listOf(
            OptionItem(
                text = "UPI ID",
                summary = "AKSLabs@upi",
                icon = Icons.Rounded.Payments,
                color = androidx.compose.ui.graphics.Color(0xFF6200EE),
                onClick = cryptoOnClick
            )
        )
    }

    if (showCryptoOptions) {
        BackHandler {
            showCryptoOptions = false
        }
    }

    ModalBottomSheet(
        sheetState = sheetState,
        onDismissRequest = {
            if (showCryptoOptions) {
                showCryptoOptions = false
            } else {
                onDismissRequest()
            }
        },
        containerColor = MaterialTheme.colorScheme.surfaceContainerLowest,
        tonalElevation = 0.dp,
        dragHandle = { BottomSheetDefaults.DragHandle() },
        contentWindowInsets = { WindowInsets(0, 0, 0, 0) }
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 32.dp, vertical = 16.dp)
                .navigationBarsPadding()
        ) {
            Text(
                text = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            color = MaterialTheme.colorScheme.onSurface,
                            fontStyle = MaterialTheme.typography.titleLarge.fontStyle,
                            fontSize = MaterialTheme.typography.titleLarge.fontSize,
                            letterSpacing = MaterialTheme.typography.titleLarge.letterSpacing
                        )
                    ) {
                        append("Support the project")
                    }
                    if (showCryptoOptions) {
                        append("\n")
                        withStyle(
                            style = SpanStyle(
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                                fontStyle = MaterialTheme.typography.bodyMedium.fontStyle,
                                fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                                letterSpacing = MaterialTheme.typography.bodyMedium.letterSpacing
                            )
                        ) {
                            append("Click to copy")
                        }
                    }
                },
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier
                    .padding(bottom = 16.dp)
                    .fillMaxWidth()
            )

            val options = remember(showCryptoOptions) {
                (if (showCryptoOptions) cryptoOptions else mainOptions).toMutableStateList()
            }
//            OptionLayout(
//                modifier = Modifier.fillMaxWidth(),
//                optionList = options
//            )
            Column(
                verticalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                options.forEach { option ->
                    Surface(
                        onClick = { option.onClick(option.summary ?: "") },
                        shape = RoundedCornerShape(20.dp),
                        color = MaterialTheme.colorScheme.surfaceContainer,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Row(
                            modifier = Modifier.padding(16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(48.dp)
                                    .clip(RoundedCornerShape(14.dp))
                                    .background(option.color.copy(alpha = 0.15f)),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    imageVector = option.icon,
                                    contentDescription = null,
                                    tint = option.color,
                                    modifier = Modifier.size(24.dp)
                                )
                            }
                            
                            Spacer(modifier = Modifier.width(16.dp))
                            
                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    text = option.text,
                                    style = MaterialTheme.typography.titleMedium,
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                                option.summary?.let {
                                    Text(
                                        text = it,
                                        style = MaterialTheme.typography.bodyMedium,
                                        color = MaterialTheme.colorScheme.onSurfaceVariant
                                    )
                                }
                            }
                            
                            Icon(
                                imageVector = if (showCryptoOptions && option.text == "UPI ID") Icons.Rounded.ContentCopy else Icons.Rounded.ChevronRight,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.6f),
                                modifier = Modifier.size(20.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}