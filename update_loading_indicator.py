import re

# Read the file
with open(r'c:\Users\ashin\StudioProjects\CloudGallery\app\src\main\java\com\akslabs\chitralaya\ui\components\PhotoView.kt', 'r', encoding='utf-8') as f:
    content = f.read()

# Change 1: Add @OptIn annotation before @Composable
content = content.replace(
    '@Composable\nfun PhotoView(',
    '@OptIn(ExperimentalMaterial3ExpressiveApi::class)\n@Composable\nfun PhotoView('
)

# Change 2: Replace CircularProgressIndicator with ContainedLoadingIndicator
content = content.replace(
    'androidx.compose.material3.CircularProgressIndicator(color = Color.White)',
    'androidx.compose.material3.ContainedLoadingIndicator()'
)

# Write back
with open(r'c:\Users\ashin\StudioProjects\CloudGallery\app\src\main\java\com\akslabs\chitralaya\ui\components\PhotoView.kt', 'w', encoding='utf-8') as f:
    f.write(content)

print("Successfully updated PhotoView.kt with ContainedLoadingIndicator")
