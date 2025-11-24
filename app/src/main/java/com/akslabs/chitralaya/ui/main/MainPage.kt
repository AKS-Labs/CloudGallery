package com.akslabs.cloudgallery.ui.main


import android.content.Context
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import android.app.Activity
import android.os.Build
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
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.TextButton
import android.content.ContentUris
import android.provider.MediaStore
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

    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry?.destination?.route

    // Selection state (shared between screens)
    var selectionMode by remember { mutableStateOf(false) }
    var selectedPhotos by remember { mutableStateOf<Set<String>>(emptySet()) }
    val deletedPhotoIds = remember { androidx.compose.runtime.mutableStateListOf<String>() }

    fun clearSelection() {
        selectedPhotos = emptySet()
        selectionMode = false
    }

    // This is a proactive fix to prevent confusion.
    // When the user navigates between tabs, clear any active selection.
    LaunchedEffect(currentRoute) {
        if (selectionMode) {
            clearSelection()
        }
    }

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

    val localPhotos = viewModel.localPhotosFlow.collectAsLazyPagingItems()
    val allCloudPhotos = viewModel.allCloudPhotosFlow.collectAsLazyPagingItems()

    val areAllSelected = remember(selectedPhotos, currentRoute, localPhotos.itemCount, allCloudPhotos.itemCount) {
        val totalCount = if (currentRoute == Screens.LocalPhotos.route) localPhotos.itemCount else allCloudPhotos.itemCount
        totalCount > 0 && selectedPhotos.size == totalCount
    }

    fun toggleSelectAll() {
        if (areAllSelected) {
            clearSelection()
        } else {
            selectedPhotos = if (currentRoute == Screens.LocalPhotos.route) {
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
        val isSettingsScreen = currentRoute == Screens.Settings.route || isNavigatingToSettings
        val showAppLayout = !isSettingsScreen

        LaunchedEffect(isNavigatingToSettings) {
            if (isNavigatingToSettings) {
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
                                    selectedPhotos = selectedPhotos,
                                    currentRoute = currentRoute,
                                    onDeletionComplete = {
                                        val idsToDelete = selectedPhotos.toList()
                                        deletedPhotoIds.addAll(idsToDelete)
                                        scope.launch {
                                            kotlinx.coroutines.delay(400)
                                            localPhotos.refresh()
                                            kotlinx.coroutines.delay(1000)
                                            deletedPhotoIds.removeAll(idsToDelete)
                                        }
                                    }
                                )
                            } else {
                                Column {
                                    TopAppBar(
                                        title = {
                                            Box(
                                                modifier = Modifier.fillMaxWidth(),
                                                contentAlignment = Alignment.CenterStart
                                            ) {
                                                val titleText = when (currentRoute) {
                                                    Screens.LocalPhotos.route -> "Device ${photoCounts[0]}"
                                                    Screens.RemotePhotos.route -> "Cloud ${photoCounts[1]}"
                                                    else -> ""
                                                }
                                                Text(
                                                    text = titleText,
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
                                                        HorizontalDivider(modifier = Modifier.padding(vertical = 4.dp))
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
                                                    scrollBehavior.state.heightOffset = 0f
                                                    scrollBehavior.state.heightOffsetLimit = 0f
                                                    navController.navigate(Screens.Settings.route)
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
                        onSelectedPhotosChange = { selectedPhotos = it },
                        deletedPhotoIds = deletedPhotoIds
                    )
                }
            }
        } else {
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
                    onSelectedPhotosChange = { selectedPhotos = it },
                    deletedPhotoIds = deletedPhotoIds
                )
            }
        }

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

        AnimatedVisibility(visible = syncState == SyncState.SYNCING && currentRoute == Screens.RemotePhotos.route) {
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
    selectedPhotos: Set<String>,
    currentRoute: String?,
    onDeletionComplete: () -> Unit
) {
    var showExtraActions by remember { mutableStateOf(false) }

    val deleteRequestLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartIntentSenderForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            scope.launch {
                context.toastFromMainThread("Photos deleted successfully.")
            }
            onDeletionComplete()
        } else {
            scope.launch {
                context.toastFromMainThread("Couldn't get permission to delete photos.")
            }
        }
        onClearSelection()
    }

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
            IconButton(onClick = onToggleSelectAll) {
                Icon(
                    imageVector = Icons.Default.ChecklistRtl,
                    contentDescription = if (areAllSelected) "Deselect All" else "Select All",
                    tint = if (areAllSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface
                )
            }
            Box {
                IconButton(onClick = { showExtraActions = true }) {
                    Icon(Icons.Default.MoreVert, contentDescription = "More actions")
                }
                DropdownMenu(
                    expanded = showExtraActions,
                    onDismissRequest = { showExtraActions = false }
                ) {
                    if (currentRoute == Screens.LocalPhotos.route) { // Device photos
                        DropdownMenuItem(
                            text = { Text("Upload to Cloud") },
                            onClick = {
                                showExtraActions = false
                                scope.launch {
                                    context.toastFromMainThread("Uploading selected images to Cloud...")
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
                            text = { Text("Delete From Device") },
                            onClick = {
                                showExtraActions = false
                                scope.launch(Dispatchers.IO) {
                                    val urisToDelete = selectedPhotos.map { id ->
                                        ContentUris.withAppendedId(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, id.toLong())
                                    }
                                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) { // Android 11+
                                        val pendingIntent = MediaStore.createDeleteRequest(context.contentResolver, urisToDelete)
                                        val intentSenderRequest = IntentSenderRequest.Builder(pendingIntent.intentSender).build()
                                        deleteRequestLauncher.launch(intentSenderRequest)
                                    } else {
                                        // Fallback for older Android versions
                                        try {
                                            var deletedCount = 0
                                            urisToDelete.forEach { uri ->
                                                if (context.contentResolver.delete(uri, null, null) > 0) {
                                                    deletedCount++
                                                }
                                            }
                                            withContext(Dispatchers.Main) {
                                                context.toastFromMainThread("$deletedCount photos deleted.")
                                                onDeletionComplete()
                                                onClearSelection()
                                            }
                                        } catch (e: SecurityException) {
                                            withContext(Dispatchers.Main) {
                                                context.toastFromMainThread("Permission denied. Could not delete photos.")
                                            }
                                            Log.e("Delete", "SecurityException while deleting photos.", e)
                                        } catch (e: Exception) {
                                             withContext(Dispatchers.Main) {
                                                context.toastFromMainThread("Error deleting photos.")
                                            }
                                            Log.e("Delete", "Error while deleting photos.", e)
                                        }
                                    }
                                }
                            }
                        )
                    } else { // Cloud photos
                        DropdownMenuItem(
                            text = { Text("Move to Trash Bin") },
                            onClick = {
                                // TODO: Delete Selected Images from Cloud and Move it to Trash Bin
                                showExtraActions = false
                            }
                        )
                    }
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
