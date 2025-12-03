import re

file_path = r'c:\Users\ashin\StudioProjects\CloudGallery\app\src\main\java\com\akslabs\chitralaya\ui\main\MainPage.kt'

with open(file_path, 'r', encoding='utf-8') as f:
    content = f.read()

# 1. Add dialog state
content = content.replace(
    "    var showGridOptionsDropdown by remember { mutableStateOf(false) }",
    "    var showGridOptionsDropdown by remember { mutableStateOf(false) }\n    var showThumbnailResolutionDialog by remember { mutableStateOf(false) }"
)

# 2. Add thumbnail resolution menu item before the closing brace of dropdown
menu_item = """                                                        HorizontalDivider(modifier = Modifier.padding(vertical = 4.dp))
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
                                                }"""

old_menu_end = """                                                            )
                                                        }
                                                    }
                                                }"""

content = content.replace(old_menu_end, menu_item)

# 3. Add the dialog at the end of MainPage composable, before the closing braces
dialog_code = '''
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
                                value < 50 -> errorMessage = "Minimum resolution is 50px"
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
        }'''

# Find the end of MainPage function  (before the last closing brace)
# Insert dialog before the final closing braces
content = content.replace(
    "        AnimatedVisibility(visible = syncState == SyncState.SYNCING && currentRoute == Screens.RemotePhotos.route) {",
    dialog_code + "\n\n        AnimatedVisibility(visible = syncState == SyncState.SYNCING && currentRoute == Screens.RemotePhotos.route) {"
)

# Add necessary imports at the top if not present
imports_to_add = [
    "import androidx.compose.material3.AlertDialog",
    "import androidx.compose.material3.OutlinedTextField",
    "import androidx.compose.foundation.text.KeyboardOptions",
    "import androidx.compose.ui.text.input.KeyboardType",
    "import androidx.compose.ui.unit.dp"
]

for imp in imports_to_add:
    if imp not in content:
        # Add after package declaration
        content = content.replace(
            "package com.akslabs.cloudgallery.ui.main\n",
            f"package com.akslabs.cloudgallery.ui.main\n{imp}\n",
            1
        )

with open(file_path, 'w', encoding='utf-8') as f:
    f.write(content)

print("Successfully added thumbnail resolution dialog to MainPage.kt")
