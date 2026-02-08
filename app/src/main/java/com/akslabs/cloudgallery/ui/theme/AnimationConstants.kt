package com.akslabs.cloudgallery.ui.theme

import androidx.compose.animation.core.CubicBezierEasing
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.SpringSpec
import androidx.compose.ui.geometry.Rect

object AnimationConstants {
    // Emphasized Easing - Standard M3 expressive motion
    // Used for most standard transitions
    val EmphasizedEasing = CubicBezierEasing(0.2f, 0.0f, 0.0f, 1.0f)

    // Emphasized Decelerate - Used for incoming elements
    val EmphasizedDecelerateEasing = CubicBezierEasing(0.05f, 0.7f, 0.1f, 1.0f)
    
    // Emphasized Accelerate - Used for outgoing elements
    val EmphasizedAccelerateEasing = CubicBezierEasing(0.3f, 0.0f, 0.8f, 0.15f)

    // Premium Spring for Shared Elements (Bounds)
    // Low stiffness for a "heavy" premium feel, high damping to prevent excessive bounce
    val PremiumBoundsSpring = SpringSpec<Rect>(
        dampingRatio = 0.85f,
        stiffness = 350f 
    )
    
    // Premium Spring for Alpha/Scale
    val PremiumSpring = SpringSpec<Float>(
        dampingRatio = 0.85f,
        stiffness = 350f
    )

    // Duration for standard screen transitions (Standard is usually 300ms)
    // We use 500ms for a more deliberate, premium feel
    const val NavTransitionDuration = 500
}
