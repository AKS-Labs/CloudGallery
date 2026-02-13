package com.akslabs.cloudgallery.ui.onboarding

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
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
        transitionSpec = {
            if (targetState == "getting_started" || targetState == "complete") {
                (slideInHorizontally(
                    initialOffsetX = { it },
                    animationSpec = tween(500, easing = com.akslabs.cloudgallery.ui.theme.AnimationConstants.EmphasizedEasing)
                ) + fadeIn(
                    animationSpec = tween(500)
                )).togetherWith(
                    slideOutHorizontally(
                        targetOffsetX = { -it / 3 },
                        animationSpec = tween(500, easing = com.akslabs.cloudgallery.ui.theme.AnimationConstants.EmphasizedEasing)
                    ) + fadeOut(
                        animationSpec = tween(500)
                    )
                )
            } else {
                (slideInHorizontally(
                    initialOffsetX = { -it / 3 },
                    animationSpec = tween(500, easing = com.akslabs.cloudgallery.ui.theme.AnimationConstants.EmphasizedEasing)
                ) + fadeIn(
                    animationSpec = tween(500)
                )).togetherWith(
                    slideOutHorizontally(
                        targetOffsetX = { it },
                        animationSpec = tween(500, easing = com.akslabs.cloudgallery.ui.theme.AnimationConstants.EmphasizedEasing)
                    ) + fadeOut(
                        animationSpec = tween(500)
                    )
                )
            }
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
