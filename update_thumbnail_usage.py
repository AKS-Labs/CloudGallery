import re

file_path = r'c:\Users\ashin\StudioProjects\CloudGallery\app\src\main\java\com\akslabs\chitralaya\ui\main\screens\local\LocalPhotoGrid.kt'

with open(file_path, 'r', encoding='utf-8') as f:
    content = f.read()

# 1. Add state to collect thumbnail resolution in LocalPhotoGrid
old_glide_behavior = """    val glideSelectionBehavior by Preferences.getStringFlow(Preferences.glideSelectionBehaviorKey, "Fixed").collectAsStateWithLifecycle()"""

new_glide_behavior = """    val glideSelectionBehavior by Preferences.getStringFlow(Preferences.glideSelectionBehaviorKey, "Fixed").collectAsStateWithLifecycle()
    val thumbnailResolution = Preferences.getInt(Preferences.thumbnailResolutionKey, Preferences.defaultThumbnailResolution)"""

content = content.replace(old_glide_behavior, new_glide_behavior)

# 2. Pass thumbnailResolution to LocalPhotoItem calls
# Find LocalPhotoItem calls and add the parameter
old_item_call_pattern = r'(LocalPhotoItem\([^)]+isDeleted = isDeleted,)'

def add_resolution_param(match):
    return match.group(1) + '\n                                        thumbnailResolution = thumbnailResolution,'

content = re.sub(old_item_call_pattern, add_resolution_param, content)

# 3. Update LocalPhotoItem signature
old_signature = """fun LocalPhotoItem(
    photo: LocalUiPhoto,
    index: Int,
    isSelected: Boolean,
    isDeleted: Boolean,
    isScrollbarDragging: Boolean = false,
    modifier: Modifier = Modifier
) {"""

new_signature = """fun LocalPhotoItem(
    photo: LocalUiPhoto,
    index: Int,
    isSelected: Boolean,
    isDeleted: Boolean,
    isScrollbarDragging: Boolean = false,
    thumbnailResolution: Int = 150,
    modifier: Modifier = Modifier
) {"""

content = content.replace(old_signature, new_signature)

# 4. Update the image size in SubcomposeAsyncImage
old_image_size = """                model = ImageRequest.Builder(context)
                    .data(photo.pathUri)
                    .size(if (isScrollbarDragging) Size(50, 50) else Size(150, 150))"""

new_image_size = """                model = ImageRequest.Builder(context)
                    .data(photo.pathUri)
                    .size(if (isScrollbarDragging) Size(50, 50) else Size(thumbnailResolution, thumbnailResolution))"""

content = content.replace(old_image_size, new_image_size)

with open(file_path, 'w', encoding='utf-8') as f:
    f.write(content)

print("Successfully updated LocalPhotoGrid.kt to use thumbnail resolution preference")
