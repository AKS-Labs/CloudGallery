package com.akslabs.cloudgallery.ui.main


import android.content.Context
import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
//import com.akslabs.chitralaya.ui.main.nav.AppNavHost

import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChecklistRtl
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Cloud
import androidx.compose.material.icons.filled.Dashboard
import androidx.compose.material.icons.filled.GridView
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.SelectAll
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Smartphone
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.SplitButtonDefaults
import androidx.compose.material3.SplitButtonLayout
import androidx.compose.material3.FloatingToolbarDefaults.floatingToolbarVerticalNestedScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.zIndex
import androidx.core.view.WindowCompat
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.work.WorkInfo
import com.akslabs.chitralaya.ui.components.BottomToolbarFAB
import com.akslabs.chitralaya.ui.components.FabState
import androidx.compose.material3.HorizontalDivider
import com.akslabs.cloudgallery.data.localdb.Preferences
import android.net.Uri
import androidx.core.net.toUri
import com.akslabs.cloudgallery.api.BotApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import com.akslabs.cloudgallery.utils.sendFileViaUri
import com.akslabs.cloudgallery.utils.toastFromMainThread
import android.util.Log
import androidx.compose.ui.platform.LocalContext
import com.akslabs.cloudgallery.R
import com.akslabs.cloudgallery.data.localdb.DbHolder
import com.akslabs.cloudgallery.ui.components.ConnectivityStatusPopup
import com.akslabs.cloudgallery.ui.main.nav.AppNavHost
import com.akslabs.cloudgallery.ui.main.nav.Screens
import com.akslabs.cloudgallery.ui.main.nav.screenScopedViewModel
import com.akslabs.cloudgallery.workers.WorkModule
import com.akslabs.cloudgallery.workers.WorkModule.SYNC_MEDIA_STORE_WORK
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun MainPage(viewModel: MainViewModel = screenScopedViewModel()) {
    val scope = rememberCoroutineScope()
    val navController = rememberNavController()
    val syncState by viewModel.syncState.collectAsStateWithLifecycle()

    // State for bottom navigation
    var selectedTab by remember { mutableStateOf(0) }
    val tabs = listOf(
        Triple("Device", Icons.Default.Smartphone, Screens.LocalPhotos.route),
        Triple("Cloud", Icons.Default.Cloud, Screens.RemotePhotos.route)
    )

    // State for grid customization menu
    var showGridOptionsDropdown by remember { mutableStateOf(false) }

    // State to track if settings is being navigated to
    var isNavigatingToSettings by remember { mutableStateOf(false) }

    // Shared grid state holder
    val gridState = remember { GridStateHolder() }

    // Get photo counts for TopAppBar titles
    val localPhotosCount by DbHolder.database.photoDao().getAllCountFlow()
        .collectAsStateWithLifecycle(initialValue = 0)
    val cloudPhotosCount by DbHolder.database.remotePhotoDao().getTotalCountFlow()
        .collectAsStateWithLifecycle(initialValue = 0)

    val photoCounts = listOf(localPhotosCount, cloudPhotosCount)

    // Selection state
    var selectionMode by remember { mutableStateOf(false) }
    var selectedPhotos by remember { mutableStateOf<Set<String>>(emptySet()) }

    val localPhotos = viewModel.localPhotosFlow.collectAsLazyPagingItems()
    val allCloudPhotos = viewModel.allCloudPhotosFlow.collectAsLazyPagingItems()

    fun clearSelection() {
        selectedPhotos = emptySet()
        selectionMode = false
    }

    val areAllSelected = remember(selectedPhotos, selectedTab, localPhotos.itemCount, allCloudPhotos.itemCount) {
        val totalCount = if (selectedTab == 0) localPhotos.itemCount else allCloudPhotos.itemCount
        totalCount > 0 && selectedPhotos.size == totalCount
    }

    fun toggleSelectAll() {
        if (areAllSelected) {
            clearSelection()
        } else {
            selectedPhotos = if (selectedTab == 0) {
                (0 until localPhotos.itemCount).mapNotNull { localPhotos.peek(it)?.localId }.toSet()
            } else {
                (0 until allCloudPhotos.itemCount).mapNotNull { allCloudPhotos.peek(it)?.remoteId }.toSet()
            }
        }
    }

    // Back press handler to exit selection mode
    BackHandler(enabled = selectionMode) {
        clearSelection()
    }


    // Improved scrollable TopAppBar behavior - shows on scroll up, hides on scroll down
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    // Status bar control for immersive experience
    val view = LocalView.current
    SideEffect {
        val window = (view.context as androidx.activity.ComponentActivity).window
        WindowCompat.setDecorFitsSystemWindows(window, false)
        window.statusBarColor = android.graphics.Color.TRANSPARENT
        WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = false
    }

    LaunchedEffect(viewModel) {
        // Always open on Device screen on app start
        selectedTab = 0
    }

    LaunchedEffect(viewModel) {
        WorkModule.SyncMediaStore.enqueueInstant()
        scope.launch {
            WorkModule.observeWorkerByName(SYNC_MEDIA_STORE_WORK)
                .collectLatest {
                    it.firstOrNull()?.let { workInfo ->
                        when (workInfo.state) {
                            WorkInfo.State.RUNNING -> viewModel.updateSyncState(SyncState.SYNCING)
                            WorkInfo.State.SUCCEEDED -> {
                                viewModel.updateSyncState(SyncState.IDLE)
                                WorkModule.SyncMediaStore.enqueuePeriodic()
                            }

                            else -> viewModel.updateSyncState(SyncState.IDLE)
                        }
                    }
                }
        }
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        val backStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = backStackEntry?.destination?.route
        val isSettingsScreen = currentRoute == Screens.Settings.route || isNavigatingToSettings
        val showAppLayout = !isSettingsScreen

        LaunchedEffect(isNavigatingToSettings) {
            if (isNavigatingToSettings) {
                // Wait 1 frame so UI update (AppBar hide) happens instantly
//                kotlinx.coroutines.android.awaitFrame()

                navController.navigate(Screens.Settings.route) {
                    launchSingleTop = true
                }
            }
        }

        // Reset navigation flag when route changes
        LaunchedEffect(currentRoute) {
            if (currentRoute == Screens.Settings.route) {
                isNavigatingToSettings = false
            } else if (currentRoute != Screens.Settings.route && isNavigatingToSettings) {
                // Reset flag when navigating away from settings
                isNavigatingToSettings = false
            }
        }
        var expanded by rememberSaveable { mutableStateOf(true) }
        if (showAppLayout) {


            Scaffold(
//            modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
                modifier = if (!isSettingsScreen) Modifier.nestedScroll(scrollBehavior.nestedScrollConnection) else Modifier,
                topBar = {
                    if (!isSettingsScreen) {
                        AnimatedContent(
                            targetState = selectionMode,
                            transitionSpec = {
                                fadeIn(animationSpec = tween(300)) togetherWith fadeOut(animationSpec = tween(300))
                            }
                        ) { mode ->
                            if (mode) {
                                SelectionTopAppBar(
                                    selectedCount = selectedPhotos.size,
                                    onClearSelection = { clearSelection() },
                                    onToggleSelectAll = { toggleSelectAll() },
                                    areAllSelected = areAllSelected,
                                    scope = scope,
                                    context = LocalContext.current,
                                    selectedPhotos = selectedPhotos
                                )
                            } else {
                                Column(
//                        modifier = Modifier.statusBarsPadding()
//                        modifier = Modifier.windowInsetsPadding(WindowInsets.statusBars)
                                ) {

                                    TopAppBar(

                                        title = {
//                                Column {
//
//                                    Spacer(modifier = Modifier.height(35.dp))
                                            Box(
                                                modifier = Modifier.fillMaxWidth(),
                                                contentAlignment = Alignment.CenterStart
                                            ) {

                                                Text(
                                                    text = "${tabs[selectedTab].first} ${photoCounts[selectedTab]}",
                                                    color = MaterialTheme.colorScheme.onSurface,
                                                    modifier = Modifier.padding(top = 30.dp)

                                                )
                                            }
                                        },expandedHeight = 90.dp,
                                        actions = {
                                            Row(
                                                modifier = Modifier.padding(top = 30.dp)
                                            ) {
                                                // Grid options menu button
                                                Box {
                                                    IconButton(onClick = { showGridOptionsDropdown = true }) {
                                                        Icon(
                                                            imageVector = Icons.Default.Dashboard,
                                                            contentDescription = "Grid options",
                                                            tint = MaterialTheme.colorScheme.onSurface
                                                        )
                                                    }

                                                    DropdownMenu(
                                                        expanded = showGridOptionsDropdown,
                                                        onDismissRequest = { showGridOptionsDropdown = false }
                                                    ) {
                                                        Text(
                                                            text = "Layout",
                                                            style = MaterialTheme.typography.labelMedium,
                                                            color = MaterialTheme.colorScheme.primary,
                                                            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                                                        )

                                                        DropdownMenuItem(
                                                            text = {
                                                                Text(
                                                                    text = "Grid View",
                                                                    color = if (!gridState.isDateGroupedLayout) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface
                                                                )
                                                            },
                                                            onClick = {
                                                                gridState.updateDateGroupedLayout(false)
                                                                showGridOptionsDropdown = false
                                                            }
                                                        )
                                                        DropdownMenuItem(
                                                            text = {
                                                                Text(
                                                                    text = "Date Grouped",
                                                                    color = if (gridState.isDateGroupedLayout) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface
                                                                )
                                                            },
                                                            onClick = {
                                                                gridState.updateDateGroupedLayout(true)
                                                                showGridOptionsDropdown = false
                                                            }
                                                        )
                                                        androidx.compose.material3.HorizontalDivider(modifier = Modifier.padding(vertical = 4.dp))
                                                        Text(
                                                            text = "Columns",
                                                            style = MaterialTheme.typography.labelMedium,
                                                            color = MaterialTheme.colorScheme.primary,
                                                            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                                                        )
                                                        listOf(3, 4, 5, 6).forEach { columnCount ->
                                                            DropdownMenuItem(
                                                                text = {
                                                                    Text(
                                                                        text = "$columnCount columns",
                                                                        color = if (columnCount == gridState.columnCount) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface
                                                                    )
                                                                },
                                                                onClick = {
                                                                    gridState.updateColumnCount(columnCount)
                                                                    showGridOptionsDropdown = false
                                                                }
                                                            )
                                                        }
                                                    }
                                                }

                                                // Settings button
                                                IconButton(onClick = {
//                                            isNavigatingToSettings = true
                                                    // Stop any scroll animation immediately
                                                    scrollBehavior.state.heightOffset = 0f
                                                    scrollBehavior.state.heightOffsetLimit = 0f

                                                    // Navigate instantly without waiting
                                                    navController.navigate(Screens.Settings.route)
//                                    navController.navigate(Screens.Settings.route)
                                                }) {
                                                    Icon(
                                                        imageVector = Icons.Default.Settings,
                                                        contentDescription = "Settings",
                                                        tint = MaterialTheme.colorScheme.onSurface
                                                    )
                                                }
                                            }
                                        },
                                        windowInsets = WindowInsets(0, 0, 0, 0),
                                        scrollBehavior = scrollBehavior,
                                        colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.surface.copy(alpha = 0.95f))
                                    )
                                    ConnectivityStatusPopup()
                                }
                            }
                        }
                    }
                },
                contentWindowInsets = WindowInsets.navigationBars
            ) { paddingValues ->
                CompositionLocalProvider(LocalGridState provides gridState) {
                    AppNavHost(
                        modifier = Modifier
                            .padding(paddingValues)
                            .fillMaxSize(),
                        navController = navController,
                        expanded = expanded,
                        onExpandedChange = { expanded = it },
                        selectionMode = selectionMode,
                        selectedPhotos = selectedPhotos,
                        onSelectionModeChange = { selectionMode = it },
                        onSelectedPhotosChange = { selectedPhotos = it }
                    )
                }
            }
        } else {
            // Ye Scaffold Settings screen ke liye (AppBar aur BottomBar hata do)
            Scaffold(
                contentWindowInsets = WindowInsets.navigationBars
            ) { paddingValues ->
                AppNavHost(
                    modifier = Modifier
                        .padding(paddingValues)
                        .fillMaxSize(),
                    navController = navController,
                    expanded = expanded,
                    onExpandedChange = { expanded = it },
                    selectionMode = selectionMode,
                    selectedPhotos = selectedPhotos,
                    onSelectionModeChange = { selectionMode = it },
                    onSelectedPhotosChange = { selectedPhotos = it }
                )
            }
        }
//        var fabState by remember { mutableStateOf(FabState.Inactive) }

        // Truly floating bottom navigation
        if (!isSettingsScreen) {
            Box(modifier = Modifier.fillMaxSize()) {
                BottomToolbarFAB(
                    expanded = expanded,
                    onExpandedChange = { expanded = it },
                    navController = navController,
                    modifier = Modifier.align(Alignment.BottomCenter)
                )
            }
        }

        // Only show syncing animation on cloud photos screen, not device screen
        AnimatedVisibility(visible = syncState == SyncState.SYNCING && selectedTab == 1) {
            Dialog({}) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    CircularProgressIndicator(color = MaterialTheme.colorScheme.primaryContainer, strokeCap = StrokeCap.Square)
                    Spacer(Modifier.size(16.dp))
                    Text(
                        text = stringResource(R.string.syncing_your_photos),
                        color = MaterialTheme.colorScheme.secondaryContainer,
                        fontStyle = FontStyle.Italic
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun SelectionTopAppBar(
    selectedCount: Int,
    onClearSelection: () -> Unit,
    onToggleSelectAll: () -> Unit,
    areAllSelected: Boolean,
    scope: CoroutineScope,
    context: Context,
    selectedPhotos: Set<String>
) {
    var showExtraActions by remember { mutableStateOf(false) }

    TopAppBar(
        title = {
            SplitButtonLayout(
                leadingButton = {
                    SplitButtonDefaults.LeadingButton(onClick = onClearSelection) {
                        Icon(
                            Icons.Default.Close,
                            contentDescription = "Close selection mode"
                        )
                    }
                },
                trailingButton = {
                    val endShape = RoundedCornerShape(topStartPercent = 0, bottomStartPercent = 0, topEndPercent = 50, bottomEndPercent = 50)
                    Box(
                        modifier = Modifier
                            .fillMaxHeight()
                            .background(
                                color = MaterialTheme.colorScheme.surfaceContainer,
                                shape = endShape
                            )
                            .padding(horizontal = 12.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("$selectedCount Selected  ",
                        fontWeight = FontWeight.SemiBold)
                    }
                }
            )
        },
        actions = {
            // Select All button
            IconButton(onClick = onToggleSelectAll) {
                Icon(
                    imageVector = Icons.Default.ChecklistRtl,
                    contentDescription = if (areAllSelected) "Deselect All" else "Select All",
                    tint = if (areAllSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface
                )
            }
            // The more actions button and its dropdown menu
            Box {
                IconButton(onClick = { showExtraActions = true }) {
                    Icon(Icons.Default.MoreVert, contentDescription = "More actions")
                }
                DropdownMenu(
                    expanded = showExtraActions,
                    onDismissRequest = { showExtraActions = false }
                ) {
                    DropdownMenuItem(
                        text = { Text("Upload to Cloud") },
                        onClick = {
                            showExtraActions = false
                            scope.launch {
                                context.toastFromMainThread("Uploading selected images...")
                                val channelId = Preferences.getEncryptedLong(Preferences.channelId, 0L)
                                if (channelId == 0L) {
                                    context.toastFromMainThread("Please configure Telegram channel in settings first.")
                                    return@launch
                                }

                                val successfulUploads = withContext(Dispatchers.IO) {
                                    var count = 0
                                    selectedPhotos.forEach { localId ->
                                        val photo = DbHolder.database.photoDao().getPhotoByLocalId(localId)
                                        if (photo?.pathUri != null) {
                                            try {
                                                sendFileViaUri(
                                                    photo.pathUri.toUri(),
                                                    context.contentResolver,
                                                    channelId,
                                                    BotApi,
                                                    context
                                                )
                                                count++
                                            } catch (e: Exception) {
                                                Log.e("Upload", "Failed to upload photo $localId: ${e.message}")
                                            }
                                        }
                                    }
                                    count
                                }

                                if (successfulUploads > 0) {
                                    context.toastFromMainThread("$successfulUploads images uploaded to Cloud.")
                                } else {
                                    context.toastFromMainThread("No images uploaded or failed to find selected images.")
                                }
                                onClearSelection()
                            }
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Move to Trash Bin") },
                        onClick = {
                            // TODO: Delete Selected Images from Cloud and Move it to Trash Bin
                            showExtraActions = false
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Delete From Device") },
                        onClick = {
                            // TODO: Delete Selected Images from Device
                            showExtraActions = false
                        }
                    )
                    HorizontalDivider()
                    // Glide Selection Behavior
                    var currentGlideBehavior by remember {
                        mutableStateOf(Preferences.getString(Preferences.glideSelectionBehaviorKey, "Fixed"))
                    }
                    val onGlideBehaviorChange: (String) -> Unit = { value ->
                        Preferences.edit {
                            putString(Preferences.glideSelectionBehaviorKey, value)
                        }
                        currentGlideBehavior = value
                    }
                    DropdownMenuItem(
                        text = { Text("Glide: ${if (currentGlideBehavior == "Toggle") "Toggle Selection" else "Select Only)"}") },
                        onClick = {
                            onGlideBehaviorChange(if (currentGlideBehavior == "Toggle") "Fixed" else "Toggle")
                            showExtraActions = false
                        }
                    )
                }
            }
        },
        navigationIcon = {},
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.background
        )
    )
}
