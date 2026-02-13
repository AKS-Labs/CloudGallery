package com.akslabs.cloudgallery.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.vector.ImageVector
import com.akslabs.cloudgallery.data.localdb.Preferences

@Composable
fun ListDialogCard(
    prefKey: String?,
    title: String,
    icon: ImageVector,
    entries: List<String>,
    values: List<String>,
    defaultValue: String,
    enabled: Boolean = true,
    onChange: (String) -> Unit = {},
) {
    var showDialog by remember {
        mutableStateOf(false)
    }

    val currentValue = prefKey?.let {
        Preferences.getString(it, defaultValue)
    } ?: defaultValue
    var summary by remember {
        mutableStateOf(entries.getOrNull(values.indexOf(currentValue)))
    }

    IconTextCard(
        settingHeaderText = title,
        settingSummaryText = summary,
        imageVector = icon,
        enabled = enabled,
        clickable = { showDialog = true }
    )

    if (showDialog) {
        ListDialog(
            title = title,
            items = entries,
            onDismissRequest = {
                showDialog = false
            },
            onClick = {
                summary = entries[it]
                if (prefKey != null) {
                    Preferences.edit {
                        putString(prefKey, values[it])
                    }
                }
                onChange.invoke(values[it])
                showDialog = false
            }
        )
    }
}
