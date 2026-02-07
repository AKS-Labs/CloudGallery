package com.akslabs.cloudgallery.ui.main
import androidx.compose.ui.text.input.KeyboardType
import com.akslabs.cloudgallery.utils.toastFromMainThread
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.unit.sp


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
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ChecklistRtl
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Cloud
import androidx.compose.material.icons.filled.Dashboard
import androidx.compose.material.icons.filled.DeleteOutline
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
    val context = LocalContext.current
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
    var showThumbnailResolutionDialog by remember { mutableStateOf(false) }

    // State to track if settings is being navigated to
    var isNavigatingToSettings by remember { mutableStateOf(false) }

    // Shared grid state holder
    val gridState = remember { GridStateHolder() }

    // Get photo counts for TopAppBar titles
    val localPhotosCount by DbHolder.database.photoDao().getAllCountFlow()
        .collectAsStateWithLifecycle(initialValue = 0)
    val cloudPhotosCount by DbHolder.database.remotePhotoDao().getTotalCountFlow()
        .collectAsStateWithLifecycle(initialValue = 0)
    val deletedPhotosCount by DbHolder.database.deletedPhotoDao().getCountFlow()
        .collectAsStateWithLifecycle(initialValue = 0)

    val photoCounts = listOf(localPhotosCount, cloudPhotosCount)

    val localPhotos = viewModel.localPhotosFlow.collectAsLazyPagingItems()
    val allCloudPhotos = viewModel.allCloudPhotosFlow.collectAsLazyPagingItems()

    val areAllSelected = remember(selectedPhotos, currentRoute, localPhotosCount, cloudPhotosCount, deletedPhotosCount) {
        val totalCount = when (currentRoute) {
            Screens.LocalPhotos.route -> localPhotosCount
            Screens.TrashBin.route -> deletedPhotosCount
            else -> cloudPhotosCount
        }
        if (com.akslabs.cloudgallery.BuildConfig.DEBUG) {
             Log.d("MainPage", "Selection Debug: selected=${selectedPhotos.size}, total=$totalCount, route=$currentRoute")
        }
        // Use strict equality for areAllSelected to ensure toggle behavior is consistent
        // If selected count >= total count, we consider it all selected.
        // However, for the toggle to work "select all -> deselect all", we need to ensure
        // that if it returns true, the next click clears selection.
        totalCount > 0 && selectedPhotos.size >= totalCount
    }

    fun toggleSelectAll() {
        if (areAllSelected) {
            clearSelection()
        } else {
            if (currentRoute == Screens.LocalPhotos.route) {
                scope.launch(Dispatchers.IO) {
                    val allLocalIds = DbHolder.database.photoDao().getAllLocalIds()
                    withContext(Dispatchers.Main) {
                        selectedPhotos = allLocalIds.toSet()
                    }
                }
            } else if (currentRoute == Screens.TrashBin.route) {
                scope.launch(Dispatchers.IO) {
                    val allDeleted = DbHolder.database.deletedPhotoDao().getAll()
                    val allIds = allDeleted.map { it.remoteId }.toSet()
                    withContext(Dispatchers.Main) {
                        selectedPhotos = allIds
                    }
                }
            } else {
                // Remote photos
                scope.launch(Dispatchers.IO) {
                    val allRemoteIds = DbHolder.database.remotePhotoDao().getAllRemoteIds()
                    withContext(Dispatchers.Main) {
                        selectedPhotos = allRemoteIds.toSet()
                    }
                }
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
                                val ctx = LocalContext.current
                                SelectionTopAppBar(
                                    selectedCount = selectedPhotos.size,
                                    onClearSelection = { clearSelection() },
                                    onToggleSelectAll = { toggleSelectAll() },
                                    areAllSelected = areAllSelected,
                                    scope = scope,
                                    context = ctx,
                                    selectedPhotos = selectedPhotos,
                                    currentRoute = currentRoute,
                                    onDeletionComplete = {
                                        val idsToDelete = selectedPhotos.toList()
                                        deletedPhotoIds.addAll(idsToDelete)
                                        scope.launch {
                                            Log.d("MainPage", "🗑️ Deletion animation started for ${idsToDelete.size} items")
                                            // Wait for animation (300ms) + buffer for MediaStore update
                                            kotlinx.coroutines.delay(1000) 
                                            // Remove from local database immediately
                                            withContext(Dispatchers.IO) {
                                                idsToDelete.forEach { localId ->
                                                    DbHolder.database.photoDao().deleteById(localId)
                                                }
                                            }
                                            Log.d("MainPage", "Refresh local photos after deletion")
                                            localPhotos.refresh()
                                        }
                                    },
                                    onRestore = {
                                        scope.launch(Dispatchers.IO) {
                                            val dao = DbHolder.database.deletedPhotoDao()
                                            val remoteDao = DbHolder.database.remotePhotoDao()
                                            selectedPhotos.forEach { id ->
                                                val photo = dao.getById(id)
                                                if (photo != null) {
                                                    remoteDao.insertAll(com.akslabs.cloudgallery.data.localdb.entities.RemotePhoto(
                                                        remoteId = photo.remoteId,
                                                        photoType = photo.photoType,
                                                        fileName = photo.fileName,
                                                        fileSize = photo.fileSize,
                                                        uploadedAt = photo.uploadedAt,
                                                        messageId = photo.messageId
                                                    ))
                                                    dao.delete(photo)
                                                }
                                            }
                                            withContext(Dispatchers.Main) {
                                                ctx.toastFromMainThread("Restored ${selectedPhotos.size} photos")
                                                clearSelection()
                                            }
                                        }
                                    },
                                    onPermanentlyDelete = {
                                        scope.launch(Dispatchers.IO) {
                                            val dao = DbHolder.database.deletedPhotoDao()
                                            selectedPhotos.forEach { id ->
                                                dao.deleteById(id)
                                            }
                                            withContext(Dispatchers.Main) {
                                                ctx.toastFromMainThread("Deleted ${selectedPhotos.size} photos permanently")
                                                clearSelection()
                                            }
                                        }
                                    }
                                )
                            } else {
                                Column {
                                    TopAppBar(
                                        title = {
                                            Column(modifier = Modifier.padding(top = 30.dp)) {
                                                val titleText = when (currentRoute) {
                                                    Screens.LocalPhotos.route -> " Device Photos"
                                                    Screens.RemotePhotos.route -> " Cloud Gallery"
                                                    Screens.TrashBin.route -> " Trash Bin"
                                                    else -> " Cloud Gallery"
                                                }
                                                Text(
                                                    text = titleText,
                                                    style = MaterialTheme.typography.headlineSmall,
                                                    fontWeight = FontWeight.ExtraBold,
                                                    color = MaterialTheme.colorScheme.onSurface,
                                                    letterSpacing = (-0.5).sp
                                                )
                                                // Show total size if available
                                                val context = LocalContext.current
                                                val localViewModel: com.akslabs.cloudgallery.ui.main.screens.local.LocalViewModel = screenScopedViewModel()
                                                val remoteViewModel: com.akslabs.cloudgallery.ui.main.screens.remote.RemoteViewModel = screenScopedViewModel()
                                                val trashViewModel: com.akslabs.cloudgallery.ui.main.screens.trash.TrashViewModel = screenScopedViewModel()
                                                
                                                val totalSize = when (currentRoute) {
                                                    Screens.LocalPhotos.route -> localViewModel.totalSize.collectAsStateWithLifecycle().value ?: 0L
                                                    Screens.RemotePhotos.route -> remoteViewModel.totalSize.collectAsStateWithLifecycle().value ?: 0L
                                                    Screens.TrashBin.route -> trashViewModel.totalSize.collectAsStateWithLifecycle().value ?: 0L
                                                    else -> 0L
                                                }
                                                
                                                if (totalSize > 0) {
                                                    val count = when (currentRoute) {
                                                        Screens.LocalPhotos.route -> localPhotosCount
                                                        Screens.RemotePhotos.route -> cloudPhotosCount
                                                        Screens.TrashBin.route -> if (currentRoute == Screens.TrashBin.route) {
                                                            trashViewModel.deletedPhotosFlow.collectAsLazyPagingItems().itemCount
                                                        } else 0
                                                        else -> 0
                                                    }
                                                    
                                                    
                                                    Row(
                                                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                                                        verticalAlignment = Alignment.CenterVertically
                                                    ) {
                                                        Surface(
                                                            color = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.7f),
                                                            contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                                                            shape = CircleShape
                                                        ) {
                                                            Text(
                                                                text = android.text.format.Formatter.formatFileSize(context, totalSize),
                                                                modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp),
                                                                style = MaterialTheme.typography.labelMedium,
                                                                fontWeight = FontWeight.ExtraBold,
                                                                letterSpacing = 0.2.sp
                                                            )
                                                        }
                                                        
                                                        Surface(
                                                            color = MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.7f),
                                                            contentColor = MaterialTheme.colorScheme.onSecondaryContainer,
                                                            shape = CircleShape
                                                        ) {
                                                            Text(
                                                                text = "$count photos",
                                                                modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp),
                                                                style = MaterialTheme.typography.labelMedium,
                                                                fontWeight = FontWeight.ExtraBold,
                                                                letterSpacing = 0.2.sp
                                                            )
                                                        }
                                                    }
                                                }
                                            }
                                        },
                                        navigationIcon = {
                                            if (currentRoute == Screens.TrashBin.route) {
                                                IconButton(
                                                    onClick = { navController.popBackStack() },
                                                    modifier = Modifier.padding(top = 30.dp)
                                                ) {
                                                    Icon(
                                                        imageVector = Icons.Filled.ArrowBack,
                                                        contentDescription = "Back",
                                                        tint = MaterialTheme.colorScheme.onSurface
                                                    )
                                                }
                                            }
                                        },
                                        expandedHeight = 95.dp,
                                        actions = {
                                            Row(
                                                modifier = Modifier.padding(top = 30.dp)
                                            ) {
                                                if (currentRoute == Screens.RemotePhotos.route) {
                                                    IconButton(onClick = { navController.navigate(Screens.TrashBin.route) }) {
                                                        Icon(
                                                            imageVector = Icons.Default.DeleteOutline,
                                                            contentDescription = "Trash Bin",
                                                            tint = MaterialTheme.colorScheme.onSurface
                                                        )
                                                    }
                                                }
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
                                                        HorizontalDivider(modifier = Modifier.padding(vertical = 4.dp))
                                                        DropdownMenuItem(
                                                            text = {
                                                                Text(
                                                                    text = "Grid Thumbnail Resolution",
                                                                    color = MaterialTheme.colorScheme.onSurface
                                                                )
                                                            },
                                                            onClick = {
                                                                showThumbnailResolutionDialog = true
                                                                showGridOptionsDropdown = false
                                                            }
                                                        )
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
                    viewModel = viewModel,
                    modifier = Modifier.align(Alignment.BottomCenter)
                )
            }
        }


        // Thumbnail Resolution Dialog
        if (showThumbnailResolutionDialog) {
            var inputValue by remember { 
                mutableStateOf(Preferences.getInt(Preferences.thumbnailResolutionKey, Preferences.defaultThumbnailResolution).toString()) 
            }
            var errorMessage by remember { mutableStateOf<String?>(null) }

            AlertDialog(
                onDismissRequest = { showThumbnailResolutionDialog = false },
                title = { Text("Grid Thumbnail Resolution") },
                text = {
                    Column {
                        Text(
                            text = "Set the resolution (in pixels) for image thumbnails in the grid. Lower values load faster but with less quality. Higher values provide better quality but may load slower.",
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        OutlinedTextField(
                            value = inputValue,
                            onValueChange = { 
                                inputValue = it
                                errorMessage = null
                            },
                            label = { Text("Resolution (px)") },
                            placeholder = { Text("150") },
                            isError = errorMessage != null,
                            supportingText = errorMessage?.let { { Text(it, color = MaterialTheme.colorScheme.error) } },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                            singleLine = true
                        )
                        Text(
                            text = "Recommended: 100-300px",
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            modifier = Modifier.padding(top = 4.dp)
                        )
                    }
                },
                confirmButton = {
                    TextButton(
                        onClick = {
                            val value = inputValue.toIntOrNull()
                            when {
                                value == null -> errorMessage = "Please enter a valid number"
                                value < 10 -> errorMessage = "Minimum resolution is 10px"
                                value > 500 -> errorMessage = "Maximum resolution is 500px"
                                else -> {
                                    Preferences.edit { putInt(Preferences.thumbnailResolutionKey, value) }
                                    showThumbnailResolutionDialog = false
                                    scope.launch {
                                        context.toastFromMainThread("Thumbnail resolution set to ${value}px")
                                    }
                                }
                            }
                        }
                    ) {
                        Text("Set")
                    }
                },
                dismissButton = {
                    TextButton(onClick = { showThumbnailResolutionDialog = false }) {
                        Text("Cancel")
                    }
                }
            )
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
    onDeletionComplete: () -> Unit,
    onRestore: () -> Unit = {},
    onPermanentlyDelete: () -> Unit = {}
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
        expandedHeight = 95.dp,
        windowInsets = WindowInsets(0, 0, 0, 0),
        title = {
            Box(modifier = Modifier.padding(top = 30.dp)) {
                SplitButtonLayout(
                    leadingButton = {
                        Surface(
                            color = MaterialTheme.colorScheme.primaryContainer,
                            contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                            shape = RoundedCornerShape(topStart = 24.dp, bottomStart = 24.dp, topEnd = 4.dp, bottomEnd = 4.dp),
                            onClick = onClearSelection,
                            modifier = Modifier.height(40.dp)
                        ) {
                        Box(
                            modifier = Modifier.padding(horizontal = 12.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                Icons.Default.Close,
                                contentDescription = "Close selection mode",
                                modifier = Modifier.size(20.dp)
                            )
                        }
                    }
                },
                trailingButton = {
                    Surface(
                        color = MaterialTheme.colorScheme.primary.copy(alpha = 0.1f),
                        contentColor = MaterialTheme.colorScheme.primary,
                        shape = RoundedCornerShape(topStart = 4.dp, bottomStart = 4.dp, topEnd = 24.dp, bottomEnd = 24.dp),
                        modifier = Modifier.height(40.dp)
                    ) {
                        Box(
                            modifier = Modifier.padding(horizontal = 16.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "$selectedCount Selected",
                                style = MaterialTheme.typography.titleSmall,
                                fontWeight = FontWeight.ExtraBold,
                                letterSpacing = 0.1.sp
                            )
                        }
                    }
                }
            )
        }
    },
        actions = {
            Row(
                modifier = Modifier.padding(top = 30.dp, end = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                    Surface(
                        color = if (areAllSelected) MaterialTheme.colorScheme.primaryContainer else MaterialTheme.colorScheme.surfaceContainerHighest,
                        contentColor = if (areAllSelected) MaterialTheme.colorScheme.onPrimaryContainer else MaterialTheme.colorScheme.onSurface,
                        shape = CircleShape
                    ) {
                        IconButton(onClick = onToggleSelectAll) {
                            Icon(
                                imageVector = Icons.Default.ChecklistRtl,
                                contentDescription = if (areAllSelected) "Deselect All" else "Select All"
                            )
                        }
                    }
                    
                    Surface(
                        color = MaterialTheme.colorScheme.surfaceContainerHighest,
                        shape = CircleShape
                    ) {
                        Box {
                            IconButton(onClick = { showExtraActions = true }) {
                                Icon(
                                    imageVector = Icons.Default.MoreVert,
                                    contentDescription = "More actions"
                                )
                            }
                        DropdownMenu(
                            expanded = showExtraActions,
                            onDismissRequest = { showExtraActions = false }
                        ) {
                            if (currentRoute == Screens.LocalPhotos.route) { // Device photos
                                DropdownMenuItem(
                                    text = { Text("Upload to Cloud", fontWeight = FontWeight.SemiBold) },
                                    leadingIcon = { Icon(Icons.Default.Cloud, contentDescription = null, tint = MaterialTheme.colorScheme.primary) },
                                    onClick = {
                                        showExtraActions = false
                                        scope.launch {
                                            context.toastFromMainThread("Uploading selected images to Cloud...")
                                            val channelId = Preferences.getEncryptedLong(Preferences.channelId, 0L)
                                            if (channelId == 0L) {
                                                context.toastFromMainThread("Please configure Telegram channel in settings first.")
                                                return@launch
                                            }

                                            withContext(Dispatchers.IO) {
                                                selectedPhotos.forEach { localId ->
                                                    val photo = DbHolder.database.photoDao().getPhotoByLocalId(localId)
                                                    photo?.pathUri?.toUri()?.let { uri ->
                                                        WorkModule.InstantUpload(uri).enqueue()
                                                    }
                                                }
                                            }
                                            context.toastFromMainThread("Photos queued for upload")

                                            onClearSelection()
                                        }
                                    }
                                )
                                DropdownMenuItem(
                                    text = { Text("Delete From Device", fontWeight = FontWeight.SemiBold) },
                                    leadingIcon = { Icon(Icons.Default.DeleteOutline, contentDescription = null, tint = MaterialTheme.colorScheme.error) },
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
                            } else if (currentRoute == Screens.RemotePhotos.route) { // Cloud photos
                                val viewModel: com.akslabs.cloudgallery.ui.main.screens.remote.RemoteViewModel = screenScopedViewModel()
                                DropdownMenuItem(
                                    text = { Text("Move to Trash Bin", fontWeight = FontWeight.SemiBold) },
                                    leadingIcon = { Icon(Icons.Default.DeleteOutline, contentDescription = null, tint = MaterialTheme.colorScheme.error) },
                                    onClick = {
                                        showExtraActions = false
                                        scope.launch {
                                            viewModel.moveToTrash(selectedPhotos)
                                            context.toastFromMainThread("Moved ${selectedPhotos.size} photos to Trash Bin")
                                            onClearSelection()
                                        }
                                    }
                                )
                            } else if (currentRoute == Screens.TrashBin.route) { // Trash Bin
                                DropdownMenuItem(
                                    text = { Text("Restore", fontWeight = FontWeight.SemiBold) },
                                    leadingIcon = { Icon(Icons.Default.Cloud, contentDescription = null, tint = MaterialTheme.colorScheme.primary) },
                                    onClick = {
                                        showExtraActions = false
                                        onRestore()
                                    }
                                )
                                DropdownMenuItem(
                                    text = { Text("Delete Permanently", fontWeight = FontWeight.SemiBold) },
                                    leadingIcon = { Icon(Icons.Default.DeleteOutline, contentDescription = null, tint = MaterialTheme.colorScheme.error) },
                                    onClick = {
                                        showExtraActions = false
                                        onPermanentlyDelete()
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
                                text = { Text("Glide: ${if (currentGlideBehavior == "Toggle") "Toggle Selection" else "Select Only"}", fontWeight = FontWeight.SemiBold) },
                                leadingIcon = { Icon(Icons.Default.Smartphone, contentDescription = null, tint = MaterialTheme.colorScheme.primary) },
                                onClick = {
                                    onGlideBehaviorChange(if (currentGlideBehavior == "Toggle") "Fixed" else "Toggle")
                                    showExtraActions = false
                                }
                            )
                        }
                    }
                }
            }
        },
        navigationIcon = {},
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.background
        )
    )
}
