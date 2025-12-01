import re

file_path = r'c:\Users\ashin\StudioProjects\CloudGallery\app\src\main\java\com\akslabs\chitralaya\ui\main\screens\local\LocalPhotoGrid.kt'

with open(file_path, 'r', encoding='utf-8') as f:
    content = f.read()

# Change: Use deletedPhotoIds.toList() in remember key
old_remember = """    // Create layout cache
    val layoutCache = remember(localPhotos.itemCount, isDateGroupedLayout, dateMap, deletedPhotoIds) {
        createLayoutCache(localPhotos, dateMap, deletedPhotoIds)
    }"""

new_remember = """    // Create layout cache
    val layoutCache = remember(localPhotos.itemCount, isDateGroupedLayout, dateMap, deletedPhotoIds.toList()) {
        createLayoutCache(localPhotos, dateMap, deletedPhotoIds)
    }"""

content = content.replace(old_remember, new_remember)

with open(file_path, 'w', encoding='utf-8') as f:
    f.write(content)

print("Successfully updated LocalPhotoGrid.kt remember key")
