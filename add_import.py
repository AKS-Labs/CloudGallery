import re

# Read the file
with open(r'c:\Users\ashin\StudioProjects\CloudGallery\app\src\main\java\com\akslabs\chitralaya\ui\components\PhotoView.kt', 'r', encoding='utf-8') as f:
    content = f.read()

# Add import for ExperimentalMaterial3ExpressiveApi after material3 imports
content = content.replace(
    'import androidx.compose.material3.TextButton',
    'import androidx.compose.material3.TextButton\nimport androidx.compose.material3.ExperimentalMaterial3ExpressiveApi'
)

# Write back
with open(r'c:\Users\ashin\StudioProjects\CloudGallery\app\src\main\java\com\akslabs\chitralaya\ui\components\PhotoView.kt', 'w', encoding='utf-8') as f:
    f.write(content)

print("Successfully added ExperimentalMaterial3ExpressiveApi import")
