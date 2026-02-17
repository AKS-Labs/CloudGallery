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
    animatedVisibilityScope: AnimatedVisibilityScope? = null,
    viewModel: MainViewModel
) {
    val currentSelectionMode by rememberUpdatedState(selectionMode)
    val currentOnSelectionModeChange by rememberUpdatedState(onSelectionModeChange)
    val currentOnSelectedPhotosChange by rememberUpdatedState(onSelectedPhotosChange)

    LaunchedEffect(navController) {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (currentSelectionMode) {
                currentOnSelectionModeChange(false)
                currentOnSelectedPhotosChange(emptySet())
            }
            
            // Clear lastViewedPhotoId if we are navigating to something that is NOT the viewer or the grids
            // This prevents stale scroll jumps if we come back from Settings etc.
            val route = destination.route
            val isPhotoRoute = route == Screens.PhotoViewer.route || 
                             route == Screens.LocalPhotos.route || 
                             route == Screens.RemotePhotos.route
            
            if (!isPhotoRoute) {
                 viewModel.updateLastViewedPhotoId("")
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
                animationSpec = tween(durationMillis = com.akslabs.cloudgallery.ui.theme.AnimationConstants.NavTransitionDuration, easing = com.akslabs.cloudgallery.ui.theme.AnimationConstants.EmphasizedEasing)
            ) + fadeIn(animationSpec = tween(com.akslabs.cloudgallery.ui.theme.AnimationConstants.NavTransitionDuration))
        },
        exitTransition = {
            slideOutHorizontally(
                targetOffsetX = { -it / 3 },
                animationSpec = tween(durationMillis = com.akslabs.cloudgallery.ui.theme.AnimationConstants.NavTransitionDuration, easing = com.akslabs.cloudgallery.ui.theme.AnimationConstants.EmphasizedEasing)
            ) + fadeOut(animationSpec = tween(com.akslabs.cloudgallery.ui.theme.AnimationConstants.NavTransitionDuration))
        },
        popEnterTransition = {
            slideInHorizontally(
                initialOffsetX = { -it / 3 },
                animationSpec = tween(durationMillis = com.akslabs.cloudgallery.ui.theme.AnimationConstants.NavTransitionDuration, easing = com.akslabs.cloudgallery.ui.theme.AnimationConstants.EmphasizedEasing)
            ) + fadeIn(animationSpec = tween(com.akslabs.cloudgallery.ui.theme.AnimationConstants.NavTransitionDuration))
        },
        popExitTransition = {
            slideOutHorizontally(
                targetOffsetX = { it },
                animationSpec = tween(durationMillis = com.akslabs.cloudgallery.ui.theme.AnimationConstants.NavTransitionDuration, easing = com.akslabs.cloudgallery.ui.theme.AnimationConstants.EmphasizedEasing)
            ) + fadeOut(animationSpec = tween(com.akslabs.cloudgallery.ui.theme.AnimationConstants.NavTransitionDuration))
        }
    ) {
        composable(route = Screens.LocalPhotos.route) {
            val localPhotos = viewModel.localPhotosFlow.collectAsLazyPagingItems()
            val localPhotosCount by viewModel.localPhotosCount.collectAsStateWithLifecycle()
            
            // Sync grid position if returning from viewer
            val lastViewedId by viewModel.lastViewedPhotoId.collectAsStateWithLifecycle()
            val allMediaStorePhotos by viewModel.filteredMediaStorePhotos.collectAsStateWithLifecycle()

            // Album chip bar data
            val albums by viewModel.albums.collectAsStateWithLifecycle()
            val selectedAlbumId by viewModel.selectedAlbumId.collectAsStateWithLifecycle()

            LocalPhotoGrid(
                localPhotos = localPhotos,
                totalCount = localPhotosCount,
                allPhotos = allMediaStorePhotos,
                expanded = expanded,
                onExpandedChange = onExpandedChange,
                selectionMode = selectionMode,
                selectedPhotos = selectedPhotos,
                onSelectionModeChange = onSelectionModeChange,
                onSelectedPhotosChange = onSelectedPhotosChange,
                deletedPhotoIds = deletedPhotoIds,
                albums = albums,
                selectedAlbumId = selectedAlbumId,
                onAlbumSelected = { viewModel.selectAlbum(it) },
                navController = navController,
                sharedTransitionScope = sharedTransitionScope,
                animatedVisibilityScope = this@composable,
                lastViewedPhotoId = lastViewedId,
                clickedPhotoId = viewModel.clickedPhotoId,
                savedIndex = viewModel.savedScrollIndex,
                savedOffset = viewModel.savedScrollOffset,
                onSaveScrollState = { id, index, offset -> viewModel.saveScrollState(id, index, offset) },
                onLastViewedPhotoConsumed = { viewModel.updateLastViewedPhotoId("") }
            )
        }

        composable(route = Screens.RemotePhotos.route) {
            val allCloudPhotos = viewModel.allCloudPhotosFlow.collectAsLazyPagingItems()
            val totalCloudPhotosCount by viewModel.totalCloudPhotosCount.collectAsStateWithLifecycle()
            val lastViewedId by viewModel.lastViewedPhotoId.collectAsStateWithLifecycle()

            RemotePhotosGrid(
                cloudPhotos = allCloudPhotos,
                onPhotoClick = { _, photo -> 
                    photo?.let { 
                        viewModel.updateLastViewedPhotoId(it.remoteId)
                        navController.navigate("photo_viewer/${it.remoteId}/true") 
                    }
                },
                expanded = expanded,
                onExpandedChange = onExpandedChange,
                selectionMode = selectionMode,
                selectedPhotos = selectedPhotos,
                onSelectionModeChange = onSelectionModeChange,
                onSelectedPhotosChange = onSelectedPhotosChange,
                navController = navController,
                sharedTransitionScope = sharedTransitionScope,
                animatedVisibilityScope = this@composable,
                lastViewedPhotoId = lastViewedId,
                clickedPhotoId = viewModel.clickedPhotoId,
                savedIndex = viewModel.savedScrollIndex,
                savedOffset = viewModel.savedScrollOffset,
                onSaveScrollState = { id, index, offset -> viewModel.saveScrollState(id, index, offset) },
                onLastViewedPhotoConsumed = { viewModel.updateLastViewedPhotoId("") }
            )

        }

        composable(
            route = Screens.PhotoViewer.route,
            arguments = listOf(
                navArgument("id") { type = NavType.StringType },
                navArgument("isRemote") { type = NavType.BoolType }
            ),
            enterTransition = {
                fadeIn(
                    animationSpec = tween(
                        durationMillis = com.akslabs.cloudgallery.ui.theme.AnimationConstants.NavTransitionDuration,
                        easing = com.akslabs.cloudgallery.ui.theme.AnimationConstants.EmphasizedDecelerateEasing
                    )
                )
            },
            exitTransition = {
                fadeOut(
                    animationSpec = tween(
                        durationMillis = com.akslabs.cloudgallery.ui.theme.AnimationConstants.NavTransitionDuration,
                        easing = com.akslabs.cloudgallery.ui.theme.AnimationConstants.EmphasizedAccelerateEasing
                    )
                )
            },
            popEnterTransition = {
                fadeIn(
                    animationSpec = tween(
                        durationMillis = com.akslabs.cloudgallery.ui.theme.AnimationConstants.NavTransitionDuration,
                        easing = com.akslabs.cloudgallery.ui.theme.AnimationConstants.EmphasizedDecelerateEasing
                    )
                )
            },
            popExitTransition = {
                fadeOut(
                    animationSpec = tween(
                        durationMillis = com.akslabs.cloudgallery.ui.theme.AnimationConstants.NavTransitionDuration,
                        easing = com.akslabs.cloudgallery.ui.theme.AnimationConstants.EmphasizedAccelerateEasing
                    )
                )
            }
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getString("id") ?: ""
            val isRemote = backStackEntry.arguments?.getBoolean("isRemote") ?: false
            val context = LocalContext.current
            
            // Collect the appropriate list of photos
            val allLocalPhotos by viewModel.allLocalPhotos.collectAsStateWithLifecycle()
            val allRemotePhotos by viewModel.allRemotePhotos.collectAsStateWithLifecycle()
            
            val activity = context as Activity
            
            // Keep track of which photo we are viewing to sync grid on return
            LaunchedEffect(id) {
                viewModel.updateLastViewedPhotoId(id)
            }
            
            PhotoPageView(
                initialPhotoId = id,
                localPhotos = allLocalPhotos,
                cloudPhotos = allRemotePhotos,
                isRemote = isRemote,
                window = activity.window,
                onDismissRequest = { navController.popBackStack() },
                sharedTransitionScope = sharedTransitionScope,
                animatedVisibilityScope = this@composable,
                onPhotoChanged = { newId -> viewModel.updateLastViewedPhotoId(newId) }
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
                navController = navController,
                sharedTransitionScope = sharedTransitionScope,
                animatedVisibilityScope = this@composable
            )
        }

        composable(route = Screens.ManageUploads.route) {
            com.akslabs.cloudgallery.ui.main.screens.uploads.ManageUploadsScreen(navController = navController)
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
