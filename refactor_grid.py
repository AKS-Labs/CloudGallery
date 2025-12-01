import re

file_path = r'c:\Users\ashin\StudioProjects\CloudGallery\app\src\main\java\com\akslabs\chitralaya\ui\main\screens\local\LocalPhotoGrid.kt'

with open(file_path, 'r', encoding='utf-8') as f:
    content = f.read()

# 1. Add Import
if "import android.content.ContentUris" not in content:
    content = content.replace("import android.content.Context", "import android.content.Context\nimport android.content.ContentUris")

# 2. Replace buildPhotoDateMap with fetchAllLocalPhotos
old_fetch = """private suspend fun buildPhotoDateMap(context: Context): Map<String, Long> = withContext(Dispatchers.IO) {
    val resolver = context.contentResolver
    val collection = MediaStore.Images.Media.getContentUri(MediaStore.VOLUME_EXTERNAL)
    val projection = arrayOf(
        MediaStore.Images.ImageColumns._ID,
        MediaStore.Images.ImageColumns.DATE_TAKEN,
        MediaStore.Images.ImageColumns.DATE_ADDED,
        MediaStore.Images.ImageColumns.DATE_MODIFIED
    )
    val map = HashMap<String, Long>(4096)
    resolver.query(collection, projection, null, null, null)?.use { cursor ->
        val idIdx = cursor.getColumnIndexOrThrow(MediaStore.Images.ImageColumns._ID)
        val takenIdx = cursor.getColumnIndexOrThrow(MediaStore.Images.ImageColumns.DATE_TAKEN)
        val addedIdx = cursor.getColumnIndexOrThrow(MediaStore.Images.ImageColumns.DATE_ADDED)
        val modIdx = cursor.getColumnIndexOrThrow(MediaStore.Images.ImageColumns.DATE_MODIFIED)
        while (cursor.moveToNext()) {
            val id = cursor.getLong(idIdx).toString()
            val taken = runCatching { cursor.getLong(takenIdx) }.getOrDefault(0L)
            val added = runCatching { cursor.getLong(addedIdx) }.getOrDefault(0L)
            val modified = runCatching { cursor.getLong(modIdx) }.getOrDefault(0L)
            val tsSec = when {
                taken > 0L -> taken / 1000L
                added > 0L -> added
                modified > 0L -> modified
                else -> 0L
            }
            map[id] = tsSec * 1000L
        }
    }
    map
}"""

new_fetch = """private suspend fun fetchAllLocalPhotos(context: Context): List<LocalUiPhoto> = withContext(Dispatchers.IO) {
    val resolver = context.contentResolver
    val collection = MediaStore.Images.Media.getContentUri(MediaStore.VOLUME_EXTERNAL)
    val projection = arrayOf(
        MediaStore.Images.ImageColumns._ID,
        MediaStore.Images.ImageColumns.DATE_TAKEN,
        MediaStore.Images.ImageColumns.DATE_ADDED,
        MediaStore.Images.ImageColumns.DATE_MODIFIED,
        MediaStore.Images.ImageColumns.MIME_TYPE,
        MediaStore.Images.ImageColumns.SIZE
    )
    val photos = ArrayList<LocalUiPhoto>(4096)
    resolver.query(collection, projection, null, null, "${MediaStore.Images.ImageColumns.DATE_TAKEN} DESC")?.use { cursor ->
        val idIdx = cursor.getColumnIndexOrThrow(MediaStore.Images.ImageColumns._ID)
        val takenIdx = cursor.getColumnIndexOrThrow(MediaStore.Images.ImageColumns.DATE_TAKEN)
        val addedIdx = cursor.getColumnIndexOrThrow(MediaStore.Images.ImageColumns.DATE_ADDED)
        val modIdx = cursor.getColumnIndexOrThrow(MediaStore.Images.ImageColumns.DATE_MODIFIED)
        val mimeIdx = cursor.getColumnIndexOrThrow(MediaStore.Images.ImageColumns.MIME_TYPE)
        val sizeIdx = cursor.getColumnIndexOrThrow(MediaStore.Images.ImageColumns.SIZE)

        while (cursor.moveToNext()) {
            val id = cursor.getLong(idIdx).toString()
            val taken = runCatching { cursor.getLong(takenIdx) }.getOrDefault(0L)
            val added = runCatching { cursor.getLong(addedIdx) }.getOrDefault(0L)
            val modified = runCatching { cursor.getLong(modIdx) }.getOrDefault(0L)
            val mimeType = cursor.getString(mimeIdx) ?: "image/jpeg"
            val size = cursor.getLong(sizeIdx)

            val tsMillis = when {
                taken > 0L -> taken
                added > 0L -> added * 1000L
                modified > 0L -> modified * 1000L
                else -> 0L
            }
            
            val uri = ContentUris.withAppendedId(collection, id.toLong()).toString()

            photos.add(LocalUiPhoto(
                localId = id,
                pathUri = uri,
                mimeType = mimeType,
                displayDateMillis = tsMillis,
                size = size,
                remoteId = null
            ))
        }
    }
    photos
}"""

content = content.replace(old_fetch, new_fetch)

# 3. Replace groupPhotosByDateOptimized
old_group = """private fun groupPhotosByDateOptimized(
    localPhotos: LazyPagingItems<LocalUiPhoto>,
    dateMap: Map<String, Long>,
    deletedPhotoIds: List<String>
): List<DateGroup> {
    val photosByDate = mutableMapOf<String, MutableList<Pair<LocalUiPhoto, Int>>>()
    var processedCount = 0
    var skippedCount = 0

    Log.d(TAG, "🔍 Starting date grouping for ${localPhotos.itemCount} photos")

    // Process ALL photos - no filtering
    for (i in 0 until localPhotos.itemCount) {
        val photo = localPhotos.peek(i)
        if (photo != null && !deletedPhotoIds.contains(photo.localId)) {
            val timestamp = dateMap[photo.localId] ?: safeTimestampFromLocalId(photo.localId)
            val dateLabel = formatPhotoDate(timestamp)

            photosByDate.getOrPut(dateLabel) { mutableListOf() }.add(photo to i)
            processedCount++
        } else {
            skippedCount++
        }
    }

    Log.d(TAG, "✅ Date grouping complete: $processedCount processed, $skippedCount skipped")

    // Convert to sorted list of DateGroups (most recent first)
    return photosByDate.map { (dateLabel, photos) ->
        val sortKey = photos.maxOfOrNull { dateMap[it.first.localId] ?: safeTimestampFromLocalId(it.first.localId) } ?: 0L
        DateGroup(
            dateLabel = dateLabel,
            photos = photos.sortedByDescending { dateMap[it.first.localId] ?: safeTimestampFromLocalId(it.first.localId) },
            sortKey = sortKey
        )
    }.sortedByDescending { it.sortKey }
}"""

new_group = """private fun groupPhotosByDateOptimized(
    allPhotos: List<LocalUiPhoto>,
    deletedPhotoIds: List<String>
): List<DateGroup> {
    val photosByDate = mutableMapOf<String, MutableList<Pair<LocalUiPhoto, Int>>>()
    
    allPhotos.forEachIndexed { index, photo ->
        if (!deletedPhotoIds.contains(photo.localId)) {
            val dateLabel = formatPhotoDate(photo.displayDateMillis)
            photosByDate.getOrPut(dateLabel) { mutableListOf() }.add(photo to index)
        }
    }

    return photosByDate.map { (dateLabel, photos) ->
        val sortKey = photos.maxOfOrNull { it.first.displayDateMillis } ?: 0L
        DateGroup(
            dateLabel = dateLabel,
            photos = photos.sortedByDescending { it.first.displayDateMillis },
            sortKey = sortKey
        )
    }.sortedByDescending { it.sortKey }
}"""

content = content.replace(old_group, new_group)

# 4. Replace createLayoutCache
old_cache = """private fun createLayoutCache(
    localPhotos: LazyPagingItems<LocalUiPhoto>,
    dateMap: Map<String, Long>,
    deletedPhotoIds: List<String>
): LayoutCache {
    val start = System.currentTimeMillis()

    // Create normal grid items
    val normalGridItems = (0 until localPhotos.itemCount).mapNotNull { index ->
        localPhotos.peek(index)?.let { photo ->
            if (deletedPhotoIds.contains(photo.localId)) null else LocalGridItem.PhotoItem(photo, index)
        }
    }

    // Create date grouped items
    val dateGroups = groupPhotosByDateOptimized(localPhotos, dateMap, deletedPhotoIds)
    val dateGroupedItems = mutableListOf<LocalGridItem>()

    dateGroups.forEachIndexed { groupIndex, dateGroup ->
        // Add date header
        dateGroupedItems.add(LocalGridItem.HeaderItem(
            dateLabel = dateGroup.dateLabel,
            id = "header_${groupIndex}_${dateGroup.dateLabel}"
        ))

        // Add all photos for this date
        dateGroup.photos.forEach { (photo, originalIndex) ->
            dateGroupedItems.add(LocalGridItem.PhotoItem(photo, originalIndex))
        }
    }

    return LayoutCache(
        normalGridItems = normalGridItems,
        dateGroupedItems = dateGroupedItems,
        totalPhotos = localPhotos.itemCount,
        lastUpdateTime = System.currentTimeMillis()
    )
}"""

new_cache = """private fun createLayoutCache(
    allPhotos: List<LocalUiPhoto>,
    deletedPhotoIds: List<String>
): LayoutCache {
    val start = System.currentTimeMillis()

    // Create normal grid items
    val normalGridItems = allPhotos.mapIndexedNotNull { index, photo ->
        if (deletedPhotoIds.contains(photo.localId)) null else LocalGridItem.PhotoItem(photo, index)
    }

    // Create date grouped items
    val dateGroups = groupPhotosByDateOptimized(allPhotos, deletedPhotoIds)
    val dateGroupedItems = mutableListOf<LocalGridItem>()

    dateGroups.forEachIndexed { groupIndex, dateGroup ->
        // Add date header
        dateGroupedItems.add(LocalGridItem.HeaderItem(
            dateLabel = dateGroup.dateLabel,
            id = "header_${groupIndex}_${dateGroup.dateLabel}"
        ))

        // Add all photos for this date
        dateGroup.photos.forEach { (photo, originalIndex) ->
            dateGroupedItems.add(LocalGridItem.PhotoItem(photo, originalIndex))
        }
    }

    return LayoutCache(
        normalGridItems = normalGridItems,
        dateGroupedItems = dateGroupedItems,
        totalPhotos = allPhotos.size,
        lastUpdateTime = System.currentTimeMillis()
    )
}"""

content = content.replace(old_cache, new_cache)

# 5. Update LocalPhotoGrid composable logic
# Replace dateMap state with allPhotos state
old_state = """    // Build MediaStore date map in background (once per dataset size change)
    var dateMap by remember { mutableStateOf<Map<String, Long>>(emptyMap()) }
    LaunchedEffect(Unit) {
        if (dateMap.isEmpty()) {
            dateMap = buildPhotoDateMap(context)
        }
    }"""

new_state = """    // Load all photos in background
    var allPhotos by remember { mutableStateOf<List<LocalUiPhoto>>(emptyList()) }
    LaunchedEffect(Unit) {
        if (allPhotos.isEmpty()) {
            allPhotos = fetchAllLocalPhotos(context)
        }
    }"""

content = content.replace(old_state, new_state)

# Replace remember layoutCache
old_remember = """    // Create layout cache
    val layoutCache = remember(localPhotos.itemCount, isDateGroupedLayout, dateMap, deletedPhotoIds.toList()) {
        createLayoutCache(localPhotos, dateMap, deletedPhotoIds)
    }"""

new_remember = """    // Create layout cache
    val layoutCache = remember(allPhotos, isDateGroupedLayout, deletedPhotoIds.toList()) {
        createLayoutCache(allPhotos, deletedPhotoIds)
    }"""

content = content.replace(old_remember, new_remember)

# Update getDateLabel
old_get_label = """    fun getDateLabel(localId: String): String? {
        val millis = dateMap[localId] ?: return null
        return java.text.SimpleDateFormat("EEE d - LLLL yyyy", java.util.Locale.getDefault()).format(java.util.Date(millis))
    }"""

new_get_label = """    fun getDateLabel(localId: String): String? {
        val photo = allPhotos.find { it.localId == localId } ?: return null
        return java.text.SimpleDateFormat("EEE d - LLLL yyyy", java.util.Locale.getDefault()).format(java.util.Date(photo.displayDateMillis))
    }"""

content = content.replace(old_get_label, new_get_label)

# Update ExpressiveScrollbar call
old_scrollbar = """                ExpressiveScrollbar(
                    lazyGridState = lazyGridState,
                    modifier = Modifier.align(Alignment.CenterEnd)
                )"""

new_scrollbar = """                // Calculate effective total items for scrollbar (accounting for headers)
                val totalRows = if (isDateGroupedLayout) {
                    val headers = layoutCache.dateGroupedItems.count { it is LocalGridItem.HeaderItem }
                    val photos = layoutCache.dateGroupedItems.count { it is LocalGridItem.PhotoItem }
                    headers + kotlin.math.ceil(photos.toFloat() / columns).toInt()
                } else {
                    kotlin.math.ceil(layoutCache.normalGridItems.size.toFloat() / columns).toInt()
                }
                val effectiveTotalItems = totalRows * columns

                ExpressiveScrollbar(
                    lazyGridState = lazyGridState,
                    totalItemsCount = effectiveTotalItems,
                    columnCount = columns,
                    modifier = Modifier.align(Alignment.CenterEnd)
                )"""

content = content.replace(old_scrollbar, new_scrollbar)

# Update photo viewer logic (remove peek)
old_viewer = """            // Collect all loaded photos and find the target index
            for (i in 0 until localPhotos.itemCount) {
                val photo = localPhotos.peek(i) // Use peek to get already loaded items
                if (photo != null) {
                    if (i == index) {
                        targetIndex = loadedPhotos.size // Current position in loaded list
                    }
                    // Map UI photo to entity for viewer compatibility
                    loadedPhotos.add(
                        com.akslabs.cloudgallery.data.localdb.entities.Photo(
                            localId = photo.localId,
                            remoteId = null,
                            photoType = photo.mimeType.substringAfter('/').ifEmpty { "jpg" },
                            pathUri = photo.pathUri
                        )
                    )
                }
            }"""

new_viewer = """            // Collect all loaded photos and find the target index
            // Use allPhotos directly
            allPhotos.forEachIndexed { i, photo ->
                if (i == index) {
                    targetIndex = loadedPhotos.size
                }
                loadedPhotos.add(
                    com.akslabs.cloudgallery.data.localdb.entities.Photo(
                        localId = photo.localId,
                        remoteId = null,
                        photoType = photo.mimeType.substringAfter('/').ifEmpty { "jpg" },
                        pathUri = photo.pathUri
                    )
                )
            }"""

content = content.replace(old_viewer, new_viewer)

with open(file_path, 'w', encoding='utf-8') as f:
    f.write(content)

print("Successfully updated LocalPhotoGrid.kt to use full photo list")
