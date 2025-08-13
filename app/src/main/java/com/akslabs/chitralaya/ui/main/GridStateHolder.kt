package com.akslabs.cloudgallery.ui.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import com.akslabs.cloudgallery.data.localdb.Preferences

@Stable
class GridStateHolder {
    var columnCount by mutableStateOf(Preferences.getInt(Preferences.gridColumnCountKey, Preferences.defaultGridColumnCount))
        private set
    
    var isDateGroupedLayout by mutableStateOf(Preferences.getBoolean("date_grouped_layout", false))
        private set
    
    fun updateColumnCount(count: Int) {
        columnCount = count
        Preferences.edit { putInt(Preferences.gridColumnCountKey, count) }
    }
    
    fun updateDateGroupedLayout(isGrouped: Boolean) {
        isDateGroupedLayout = isGrouped
        Preferences.edit { putBoolean("date_grouped_layout", isGrouped) }
    }
}

val LocalGridState = staticCompositionLocalOf { GridStateHolder() }

@Composable
fun rememberGridState(): GridStateHolder {
    return LocalGridState.current
}
