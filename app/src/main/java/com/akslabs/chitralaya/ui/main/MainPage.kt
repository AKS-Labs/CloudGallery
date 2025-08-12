package com.akslabs.cloudgallery.ui.main

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cloud
import androidx.compose.material.icons.filled.GridView
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Smartphone
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.work.WorkInfo
import com.akslabs.cloudgallery.R
import com.akslabs.cloudgallery.data.localdb.DbHolder
import com.akslabs.cloudgallery.data.localdb.Preferences
import com.akslabs.cloudgallery.ui.components.ConnectivityStatusPopup
import com.akslabs.cloudgallery.ui.main.nav.AppNavHost
import com.akslabs.cloudgallery.ui.main.nav.NavDrawer
import com.akslabs.cloudgallery.ui.main.nav.Screens
import com.akslabs.cloudgallery.ui.main.nav.screenScopedViewModel
import com.akslabs.cloudgallery.workers.WorkModule
import com.akslabs.cloudgallery.workers.WorkModule.SYNC_MEDIA_STORE_WORK
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
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
    var currentColumnCount by remember {
        mutableStateOf(Preferences.getInt(Preferences.gridColumnCountKey, Preferences.defaultGridColumnCount))
    }
    var isDateGroupedLayout by remember { mutableStateOf(Preferences.getBoolean("date_grouped_layout", false)) }

    // Get photo counts for TopAppBar titles
    val localPhotosCount by DbHolder.database.photoDao().getAllCountFlow()
        .collectAsStateWithLifecycle(initialValue = 0)
    val cloudPhotosCount by DbHolder.database.remotePhotoDao().getTotalCountFlow()
        .collectAsStateWithLifecycle(initialValue = 0)

    val photoCounts = listOf(localPhotosCount, cloudPhotosCount)

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
        navController.navigate(Screens.LocalPhotos.route) {
            popUpTo(0) { inclusive = false }
            launchSingleTop = true
            restoreState = true
        }
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
        val isSettingsScreen = currentRoute == Screens.Settings.route

        Scaffold(
            modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
            topBar = {
                if (!isSettingsScreen) {
                    Column(
                        modifier = Modifier.windowInsetsPadding(WindowInsets.statusBars)
                    ) {
                        TopAppBar(
                            title = {
                                Text(
                                    text = "${tabs[selectedTab].first} ${photoCounts[selectedTab]}",
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                            },
                            actions = {
                                // Grid options menu button
                                Box {
                                    IconButton(onClick = { showGridOptionsDropdown = true }) {
                                        Icon(
                                            imageVector = Icons.Default.GridView,
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
                                            text = { Text(text = "Grid View", color = if (!isDateGroupedLayout) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface) },
                                            onClick = {
                                                isDateGroupedLayout = false
                                                Preferences.edit { putBoolean("date_grouped_layout", false) }
                                                showGridOptionsDropdown = false
                                            }
                                        )
                                        DropdownMenuItem(
                                            text = { Text(text = "Date Grouped", color = if (isDateGroupedLayout) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface) },
                                            onClick = {
                                                isDateGroupedLayout = true
                                                Preferences.edit { putBoolean("date_grouped_layout", true) }
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
                                                text = { Text(text = "$columnCount columns", color = if (columnCount == currentColumnCount) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface) },
                                                onClick = {
                                                    currentColumnCount = columnCount
                                                    Preferences.edit { putInt(Preferences.gridColumnCountKey, columnCount) }
                                                    showGridOptionsDropdown = false
                                                }
                                            )
                                        }
                                    }
                                }

                                // Settings button
                                IconButton(onClick = { navController.navigate(Screens.Settings.route) }) {
                                    Icon(imageVector = Icons.Default.Settings, contentDescription = "Settings", tint = MaterialTheme.colorScheme.onSurface)
                                }
                            },
                            scrollBehavior = scrollBehavior,
                            colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.surface.copy(alpha = 0.95f))
                        )
                        ConnectivityStatusPopup()
                    }
                }
            },
            contentWindowInsets = WindowInsets(0, 0, 0, 0)
        ) { paddingValues ->
            AppNavHost(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize(),
                navController = navController
            )
        }

        // Truly floating bottom navigation
        if (!isSettingsScreen) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 16.dp),
                contentAlignment = Alignment.BottomCenter
            ) {
                BottomAppBar(
                    modifier = Modifier
                        .width(200.dp)
                        .clip(RoundedCornerShape(24.dp)),
                    containerColor = MaterialTheme.colorScheme.surfaceContainer.copy(alpha = 0.9f),
                    tonalElevation = 12.dp
                ) {
                    tabs.forEachIndexed { index, (title, icon, route) ->
                        NavigationBarItem(
                            selected = selectedTab == index,
                            onClick = {
                                selectedTab = index
                                navController.navigate(route) {
                                    popUpTo(navController.graph.startDestinationId) { saveState = true }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            },
                            icon = { Icon(imageVector = icon, contentDescription = title) },
                            label = { Text(text = title, style = MaterialTheme.typography.labelSmall) }
                        )
                    }
                }
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
