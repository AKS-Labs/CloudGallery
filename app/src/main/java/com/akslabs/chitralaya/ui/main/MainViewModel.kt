package com.akslabs.cloudgallery.ui.main

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.akslabs.cloudgallery.ui.main.nav.Screens
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel : ViewModel() {
    var currentDestination by mutableStateOf<Screens>(Screens.LocalPhotos)
        private set

    fun updateDestination(destination: Screens) {
        currentDestination = destination
    }

    private val _syncState = MutableStateFlow(SyncState.IDLE)
    val syncState: StateFlow<SyncState> = _syncState.asStateFlow()

    fun updateSyncState(newState: SyncState) {
        _syncState.value = newState
    }
}