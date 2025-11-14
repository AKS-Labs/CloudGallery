package com.akslabs.cloudgallery.ui.main.nav

import RemotePhotosGrid
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleOut
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.TransformOrigin
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import androidx.paging.compose.collectAsLazyPagingItems
import com.akslabs.cloudgallery.ui.main.screens.local.LocalPhotoGrid
import com.akslabs.cloudgallery.ui.main.screens.local.LocalViewModel

import com.akslabs.cloudgallery.ui.main.screens.remote.RemoteViewModel
import com.akslabs.cloudgallery.ui.main.screens.settings.SettingsScreen

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    expanded: Boolean,
    onExpandedChange: (Boolean) -> Unit
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Screens.LocalPhotos.route,

        popEnterTransition = { EnterTransition.None },
        popExitTransition = {
            scaleOut(
                targetScale = 0.7F,
                transformOrigin = TransformOrigin(pivotFractionX = 0.5f, pivotFractionY = 0.5f)
            )
        },
            ) {
        composable(route = Screens.LocalPhotos.route) {
            val viewModel: LocalViewModel = screenScopedViewModel()
            val localPhotos = viewModel.localPhotosFlow.collectAsLazyPagingItems()
            val localPhotosCount by viewModel.localPhotosCount.collectAsStateWithLifecycle()

            LocalPhotoGrid(
                localPhotos = localPhotos,
                totalCount = localPhotosCount,
                expanded = expanded,
                onExpandedChange = onExpandedChange
            )
        }

        composable(route = Screens.RemotePhotos.route) {
            val viewModel: RemoteViewModel = screenScopedViewModel()
            val allCloudPhotos = viewModel.allCloudPhotosFlow.collectAsLazyPagingItems()
            val totalCloudPhotosCount by viewModel.totalCloudPhotosCount.collectAsStateWithLifecycle()

            RemotePhotosGrid(
                cloudPhotos = allCloudPhotos,
                onPhotoClick = { _, _ -> },
                expanded = expanded,
                onExpandedChange = onExpandedChange
            )

        }

        composable(route = Screens.Settings.route) {
            SettingsScreen()
        }
    }
}

/**
 * Provides a [ViewModel] instance scoped the screen's life.
 * When the user navigates away from the screen all screen scoped
 * viewModels are destroyed.
 */
@Composable
inline fun <reified T : ViewModel> screenScopedViewModel(
    factory: ViewModelProvider.Factory? = null,
): T {
    val viewModelStoreOwner = LocalViewModelStoreOwner.current
    requireNotNull(viewModelStoreOwner) { "No ViewModelStoreOwner provided" }
    val viewModelProvider = factory?.let {
        ViewModelProvider(viewModelStoreOwner, it)
    } ?: ViewModelProvider(viewModelStoreOwner)
    return viewModelProvider[T::class.java]
}
