package com.akslabs.cloudgallery.ui.main.nav

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.EaseOutQuart
import androidx.compose.animation.core.EaseInQuart
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.compose.runtime.rememberUpdatedState
import androidx.navigation.compose.NavHost
import androidx.compose.ui.graphics.TransformOrigin
import androidx.navigation.compose.composable
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.akslabs.cloudgallery.ui.main.MainViewModel
import com.akslabs.cloudgallery.ui.main.screens.local.LocalPhotoGrid
import com.akslabs.cloudgallery.ui.main.screens.remote.RemotePhotosGrid
import com.akslabs.cloudgallery.ui.main.screens.settings.SettingsScreen
import com.akslabs.cloudgallery.ui.main.screens.trash.TrashBinScreen
import com.akslabs.cloudgallery.ui.components.PhotoPageView
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.paging.compose.collectAsLazyPagingItems
import android.app.Activity
import androidx.compose.ui.platform.LocalContext

@OptIn(ExperimentalAnimationApi::class, ExperimentalSharedTransitionApi::class)
@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    expanded: Boolean,
    onExpandedChange: (Boolean) -> Unit,
    selectionMode: Boolean,
    selectedPhotos: Set<String>,
    onSelectionModeChange: (Boolean) -> Unit,
    onSelectedPhotosChange: (Set<String>) -> Unit,
    deletedPhotoIds: List<String> = emptyList(),
    sharedTransitionScope: SharedTransitionScope,
    animatedVisibilityScope: AnimatedVisibilityScope? = null
) {
    val currentSelectionMode by rememberUpdatedState(selectionMode)
    val currentOnSelectionModeChange by rememberUpdatedState(onSelectionModeChange)
    val currentOnSelectedPhotosChange by rememberUpdatedState(onSelectedPhotosChange)

    LaunchedEffect(navController) {
        navController.addOnDestinationChangedListener { _, _, _ ->
            if (currentSelectionMode) {
                currentOnSelectionModeChange(false)
                currentOnSelectedPhotosChange(emptySet())
            }
        }
    }

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Screens.LocalPhotos.route,
        enterTransition = {
            slideInHorizontally(
                initialOffsetX = { it },
                animationSpec = tween(durationMillis = 400, easing = EaseOutQuart)
            ) + fadeIn(animationSpec = tween(300))
        },
        exitTransition = {
            slideOutHorizontally(
                targetOffsetX = { -it / 3 },
                animationSpec = tween(durationMillis = 400, easing = EaseInQuart)
            ) + fadeOut(animationSpec = tween(300))
        },
        popEnterTransition = {
            slideInHorizontally(
                initialOffsetX = { -it / 3 },
                animationSpec = tween(durationMillis = 400, easing = EaseOutQuart)
            ) + fadeIn(animationSpec = tween(300))
        },
        popExitTransition = {
            slideOutHorizontally(
                targetOffsetX = { it },
                animationSpec = tween(durationMillis = 400, easing = EaseInQuart)
            ) + fadeOut(animationSpec = tween(300))
        }
    ) {
        composable(route = Screens.LocalPhotos.route) {
            val viewModel: MainViewModel = screenScopedViewModel()
            val localPhotos = viewModel.localPhotosFlow.collectAsLazyPagingItems()
            val localPhotosCount by viewModel.localPhotosCount.collectAsStateWithLifecycle()

            LocalPhotoGrid(
                localPhotos = localPhotos,
                totalCount = localPhotosCount,
                expanded = expanded,
                onExpandedChange = onExpandedChange,
                selectionMode = selectionMode,
                selectedPhotos = selectedPhotos,
                onSelectionModeChange = onSelectionModeChange,
                onSelectedPhotosChange = onSelectedPhotosChange,
                deletedPhotoIds = deletedPhotoIds,
                navController = navController,
                sharedTransitionScope = sharedTransitionScope,
                animatedVisibilityScope = this@composable
            )
        }

        composable(route = Screens.RemotePhotos.route) {
            val viewModel: MainViewModel = screenScopedViewModel()
            val allCloudPhotos = viewModel.allCloudPhotosFlow.collectAsLazyPagingItems()
            val totalCloudPhotosCount by viewModel.totalCloudPhotosCount.collectAsStateWithLifecycle()

            RemotePhotosGrid(
                cloudPhotos = allCloudPhotos,
                onPhotoClick = { _, photo -> 
                    photo?.let { navController.navigate("photo_viewer/${it.remoteId}/true") }
                },
                expanded = expanded,
                onExpandedChange = onExpandedChange,
                selectionMode = selectionMode,
                selectedPhotos = selectedPhotos,
                onSelectionModeChange = onSelectionModeChange,
                onSelectedPhotosChange = onSelectedPhotosChange,
                sharedTransitionScope = sharedTransitionScope,
                animatedVisibilityScope = this@composable
            )

        }

        composable(
            route = Screens.PhotoViewer.route,
            arguments = listOf(
                navArgument("id") { type = NavType.StringType },
                navArgument("isRemote") { type = NavType.BoolType }
            )
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getString("id") ?: ""
            val isRemote = backStackEntry.arguments?.getBoolean("isRemote") ?: false
            val viewModel: MainViewModel = screenScopedViewModel()
            val context = LocalContext.current
            
            // Collect the appropriate list of photos
            val allLocalPhotos by viewModel.allLocalPhotos.collectAsStateWithLifecycle()
            val allRemotePhotos by viewModel.allRemotePhotos.collectAsStateWithLifecycle()
            
            val activity = context as Activity
            
            PhotoPageView(
                initialPhotoId = id,
                localPhotos = allLocalPhotos,
                cloudPhotos = allRemotePhotos,
                isRemote = isRemote,
                window = activity.window,
                onDismissRequest = { navController.popBackStack() },
                sharedTransitionScope = sharedTransitionScope,
                animatedVisibilityScope = this@composable
            )
        }

        composable(route = Screens.Settings.route) {
            SettingsScreen()
        }

        composable(route = Screens.TrashBin.route) {
            TrashBinScreen(
                expanded = expanded,
                onExpandedChange = onExpandedChange,
                selectionMode = selectionMode,
                selectedPhotos = selectedPhotos,
                onSelectionModeChange = onSelectionModeChange,
                onSelectedPhotosChange = onSelectedPhotosChange,
                sharedTransitionScope = sharedTransitionScope,
                animatedVisibilityScope = this@composable
            )
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
