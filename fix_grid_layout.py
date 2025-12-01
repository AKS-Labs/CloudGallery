import re

file_path = r'c:\Users\ashin\StudioProjects\CloudGallery\app\src\main\java\com\akslabs\chitralaya\ui\main\screens\local\LocalPhotoGrid.kt'

with open(file_path, 'r', encoding='utf-8') as f:
    content = f.read()

# Change 1: groupPhotosByDateOptimized signature and body
old_group_sig = """private fun groupPhotosByDateOptimized(
    localPhotos: LazyPagingItems<LocalUiPhoto>,
    dateMap: Map<String, Long>
): List<DateGroup> {"""

new_group_sig = """private fun groupPhotosByDateOptimized(
    localPhotos: LazyPagingItems<LocalUiPhoto>,
    dateMap: Map<String, Long>,
    deletedPhotoIds: List<String>
): List<DateGroup> {"""

content = content.replace(old_group_sig, new_group_sig)

old_group_loop = """    // Process ALL photos - no filtering
    for (i in 0 until localPhotos.itemCount) {
        val photo = localPhotos.peek(i)
        if (photo != null) {"""

new_group_loop = """    // Process ALL photos - no filtering
    for (i in 0 until localPhotos.itemCount) {
        val photo = localPhotos.peek(i)
        if (photo != null && !deletedPhotoIds.contains(photo.localId)) {"""

content = content.replace(old_group_loop, new_group_loop)

# Change 2: createLayoutCache signature and body
old_cache_sig = """private fun createLayoutCache(
    localPhotos: LazyPagingItems<LocalUiPhoto>,
    dateMap: Map<String, Long>
): LayoutCache {"""

new_cache_sig = """private fun createLayoutCache(
    localPhotos: LazyPagingItems<LocalUiPhoto>,
    dateMap: Map<String, Long>,
    deletedPhotoIds: List<String>
): LayoutCache {"""

content = content.replace(old_cache_sig, new_cache_sig)

old_cache_normal = """    // Create normal grid items
    val normalGridItems = (0 until localPhotos.itemCount).mapNotNull { index ->
        localPhotos.peek(index)?.let { photo ->
            LocalGridItem.PhotoItem(photo, index)
        }
    }"""

new_cache_normal = """    // Create normal grid items
    val normalGridItems = (0 until localPhotos.itemCount).mapNotNull { index ->
        localPhotos.peek(index)?.let { photo ->
            if (deletedPhotoIds.contains(photo.localId)) null else LocalGridItem.PhotoItem(photo, index)
        }
    }"""

content = content.replace(old_cache_normal, new_cache_normal)

old_cache_call = """    // Create date grouped items
    val dateGroups = groupPhotosByDateOptimized(localPhotos, dateMap)"""

new_cache_call = """    // Create date grouped items
    val dateGroups = groupPhotosByDateOptimized(localPhotos, dateMap, deletedPhotoIds)"""

content = content.replace(old_cache_call, new_cache_call)

# Change 3: LocalPhotoGrid remember block
old_remember = """    // Create layout cache
    val layoutCache = remember(localPhotos.itemCount, isDateGroupedLayout, dateMap) {
        createLayoutCache(localPhotos, dateMap)
    }"""

new_remember = """    // Create layout cache
    val layoutCache = remember(localPhotos.itemCount, isDateGroupedLayout, dateMap, deletedPhotoIds) {
        createLayoutCache(localPhotos, dateMap, deletedPhotoIds)
    }"""

content = content.replace(old_remember, new_remember)

with open(file_path, 'w', encoding='utf-8') as f:
    f.write(content)

print("Successfully updated LocalPhotoGrid.kt")
