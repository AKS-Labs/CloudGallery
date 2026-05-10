package com.akslabs.cloudgallery.ui.main.screens.server

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.rounded.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.akslabs.cloudgallery.api.ServerApi
import com.akslabs.cloudgallery.api.ServerConfig
import com.akslabs.cloudgallery.ui.main.screens.settings.SettingsItem
import com.akslabs.cloudgallery.ui.main.screens.settings.SettingsSection
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ServerFeaturesScreen() {
    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior(rememberTopAppBarState())

    var isOnline by remember { mutableStateOf<Boolean?>(null) }
    var serverVersion by remember { mutableStateOf("") }
    var stats by remember { mutableStateOf<ServerApi.StatsResponse?>(null) }
    var peopleCount by remember { mutableIntStateOf(0) }
    var placesCount by remember { mutableIntStateOf(0) }
    var albums by remember { mutableStateOf<List<ServerApi.Album>>(emptyList()) }
    var searchQuery by remember { mutableStateOf("") }
    var searchResults by remember { mutableStateOf<List<ServerApi.SearchResult>?>(null) }
    var isSearching by remember { mutableStateOf(false) }

    // Load data & periodic check
    LaunchedEffect(Unit) {
        while (true) {
            val status = ServerApi.getServerStatus()
            isOnline = status != null
            if (status != null) {
                serverVersion = status.version
                stats = ServerApi.getPhotoStats()
                val people = ServerApi.getPeople()
                peopleCount = people.size
                val places = ServerApi.getPlaces()
                placesCount = places.size
                albums = ServerApi.getAlbums()
            }
            delay(30_000)
        }
    }

    fun doSearch() {
        if (searchQuery.isBlank()) return
        isSearching = true
        scope.launch {
            searchResults = ServerApi.search(searchQuery)
            isSearching = false
        }
    }

    Scaffold(
        modifier = Modifier
            .clip(RoundedCornerShape(32.dp))
            .background(MaterialTheme.colorScheme.background),
        topBar = {
            LargeTopAppBar(
                title = {
                    Text("Server Features", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
                },
                navigationIcon = {
                    IconButton(onClick = { (context as? androidx.activity.ComponentActivity)?.onBackPressedDispatcher?.onBackPressed() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                scrollBehavior = scrollBehavior,
                colors = TopAppBarDefaults.largeTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background,
                    scrolledContainerColor = MaterialTheme.colorScheme.background
                )
            )
        },
        containerColor = MaterialTheme.colorScheme.background
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 12.dp)
        ) {
            // Offline banner
            if (isOnline == false) {
                Surface(
                    modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp),
                    shape = RoundedCornerShape(16.dp),
                    color = MaterialTheme.colorScheme.errorContainer
                ) {
                    Row(
                        modifier = Modifier.padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(Icons.Rounded.Warning, contentDescription = null, tint = MaterialTheme.colorScheme.error)
                        Spacer(Modifier.width(12.dp))
                        Text("⚠️ Server offline", style = MaterialTheme.typography.bodyLarge, color = MaterialTheme.colorScheme.onErrorContainer)
                    }
                }
            } else if (isOnline == true) {
                Surface(
                    modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp),
                    shape = RoundedCornerShape(16.dp),
                    color = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.5f)
                ) {
                    Row(
                        modifier = Modifier.padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(Icons.Rounded.CheckCircle, contentDescription = null, tint = MaterialTheme.colorScheme.primary)
                        Spacer(Modifier.width(12.dp))
                        Text("✅ Connected — CloudGallery Server $serverVersion", style = MaterialTheme.typography.bodyLarge)
                    }
                }
            }

            // STATS
            SettingsSection(title = "Statistics")
            Surface(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(24.dp),
                color = MaterialTheme.colorScheme.surfaceContainerLow
            ) {
                Column {
                    SettingsItem(
                        icon = Icons.Rounded.Photo,
                        title = "Total Photos",
                        subtitle = "${stats?.totalPhotos ?: "—"} photos on server",
                        onClick = {}
                    )
                    SettingsItem(
                        icon = Icons.Rounded.Favorite,
                        title = "Favorites",
                        subtitle = "${stats?.favorites ?: "—"} favorites",
                        onClick = {}
                    )
                    SettingsItem(
                        icon = Icons.Rounded.AutoAwesome,
                        title = "Processed",
                        subtitle = "${stats?.processed ?: "—"} analyzed by AI",
                        onClick = {}
                    )
                }
            }

            // AI FEATURES
            Spacer(Modifier.height(16.dp))
            SettingsSection(title = "AI Features")
            Surface(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(24.dp),
                color = MaterialTheme.colorScheme.surfaceContainerLow
            ) {
                Column {
                    SettingsItem(
                        icon = Icons.Rounded.Face,
                        title = "People",
                        subtitle = "$peopleCount people detected",
                        onClick = {}
                    )
                    SettingsItem(
                        icon = Icons.Rounded.Place,
                        title = "Places",
                        subtitle = "$placesCount locations",
                        onClick = {}
                    )
                }
            }

            // SEARCH
            Spacer(Modifier.height(16.dp))
            SettingsSection(title = "Search")
            Surface(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(24.dp),
                color = MaterialTheme.colorScheme.surfaceContainerLow
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    OutlinedTextField(
                        value = searchQuery,
                        onValueChange = { searchQuery = it },
                        label = { Text("Search photos...") },
                        leadingIcon = { Icon(Icons.Rounded.Search, contentDescription = null) },
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true,
                        shape = RoundedCornerShape(16.dp),
                        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
                        keyboardActions = KeyboardActions(onSearch = { doSearch() })
                    )
                    Spacer(Modifier.height(8.dp))
                    Button(
                        onClick = { doSearch() },
                        enabled = searchQuery.isNotBlank() && !isSearching,
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(16.dp)
                    ) {
                        if (isSearching) {
                            CircularProgressIndicator(modifier = Modifier.size(20.dp), strokeWidth = 2.dp)
                            Spacer(Modifier.width(8.dp))
                        }
                        Text(if (isSearching) "Searching..." else "Search")
                    }

                    searchResults?.let { results ->
                        Spacer(Modifier.height(12.dp))
                        if (results.isEmpty()) {
                            Text("No results found", style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
                        } else {
                            Text("${results.size} results", style = MaterialTheme.typography.labelLarge, fontWeight = FontWeight.Bold)
                            Spacer(Modifier.height(8.dp))
                            results.take(20).forEach { result ->
                                Text("• ${result.filename}", style = MaterialTheme.typography.bodyMedium, modifier = Modifier.padding(vertical = 2.dp))
                            }
                            if (results.size > 20) {
                                Text("...and ${results.size - 20} more", style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
                            }
                        }
                    }
                }
            }

            // ALBUMS
            if (albums.isNotEmpty()) {
                Spacer(Modifier.height(16.dp))
                SettingsSection(title = "Albums")
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(24.dp),
                    color = MaterialTheme.colorScheme.surfaceContainerLow
                ) {
                    Column {
                        albums.forEach { album ->
                            SettingsItem(
                                icon = Icons.Rounded.PhotoAlbum,
                                title = album.name,
                                subtitle = "${album.photoCount} photos",
                                onClick = {}
                            )
                        }
                    }
                }
            }

            // DASHBOARD
            Spacer(Modifier.height(16.dp))
            SettingsSection(title = "Dashboard")
            Surface(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(24.dp),
                color = MaterialTheme.colorScheme.surfaceContainerLow
            ) {
                Column {
                    SettingsItem(
                        icon = Icons.Rounded.Dashboard,
                        title = "Open Dashboard",
                        subtitle = "Full web dashboard in browser",
                        onClick = {
                            val url = "${ServerConfig.getServerUrl()}/dashboard/"
                            context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
                        }
                    )
                }
            }

            Spacer(Modifier.height(32.dp))
        }
    }
}
