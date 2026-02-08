package com.akslabs.cloudgallery.ui.onboarding

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedContent
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.akslabs.cloudgallery.api.BotApi
import kotlinx.coroutines.delay

@Preview
@Composable
fun OnboardingPage(
    onProceed: () -> Unit = {},  // Changed from onOnboardingComplete
    modifier: Modifier = Modifier,
    botApi: BotApi = BotApi
) {
    var showDisclaimer by remember { mutableStateOf(true) }
    var showGettingStarted by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        delay(1000)
        botApi.create()
        botApi.startPolling()
    }

    AnimatedContent(
        targetState = when {
            showDisclaimer -> "disclaimer"
            showGettingStarted -> "getting_started"
            else -> "complete"
        },
        label = "onboarding_content"
    ) { state ->
        when (state) {
            "disclaimer" -> {
                DisclaimerScreen(
                    onAcknowledge = {
                        showDisclaimer = false
                        showGettingStarted = true
                    },
                    modifier = modifier
                )
            }
            "getting_started" -> {
                // Handle back navigation from GettingStartedScreen to DisclaimerScreen
                BackHandler {
                    showGettingStarted = false
                    showDisclaimer = true
                }

                GettingStartedScreen(
                    onProceed = {
                        showGettingStarted = false
                        onProceed()  // Changed from onOnboardingComplete
                    },
                    onBack = {
                        showGettingStarted = false
                        showDisclaimer = true
                    },
                    modifier = modifier,
                    botApi = botApi
                )
            }
        }
    }
}

@Preview
@Composable
fun OnboardingPagePreview() {
    OnboardingPage()
}
