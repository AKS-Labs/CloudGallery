import re

# Read the file
with open(r"c:\Users\ashin\StudioProjects\CloudGallery\app\src\main\java\com\akslabs\chitralaya\ui\main\screens\trash\TrashBinScreen.kt", "r", encoding="utf-8") as f:
    content = f.read()

# 1. Add thumbnailResolution and isScrollbarDragging after glideSelectionBehavior
old_glide = r'val glideSelectionBehavior by Preferences\.getStringFlow\(Preferences\.glideSelectionBehaviorKey, "Fixed"\)\.collectAsStateWithLifecycle\(\)'
new_glide = '''val glideSelectionBehavior by Preferences.getStringFlow(Preferences.glideSelectionBehaviorKey, "Fixed").collectAsStateWithLifecycle()
    val thumbnailResolution = Preferences.getInt(Preferences.thumbnailResolutionKey, Preferences.defaultThumbnailResolution)
    var isScrollbarDragging by remember { mutableStateOf(false) }'''

content = re.sub(old_glide, new_glide, content, count=1)

# 2. Add onDraggingChange to ExpressiveScrollbar
content = re.sub(
    r'(ExpressiveScrollbar\(\s*lazyGridState = lazyGridState,\s*totalItemsCount = deletedPhotos\.itemCount,\s*columnCount = columns,\s*)(modifier = Modifier\.align\(Alignment\.CenterEnd\))',
    r'\1\2,\n                onDraggingChange = { isDragging -> isScrollbarDragging = isDragging }',
    content,
    count=1
)

# 3. Add parameters to TrashPhotoItem call
content = re.sub(
    r'(TrashPhotoItem\(\s*remotePhoto = remotePhoto,\s*isSelected = isSelected,\s*)(modifier = Modifier\.clickable)',
    r'\1isScrollbarDragging = isScrollbarDragging,\n                                thumbnailResolution = thumbnailResolution,\n                                \2',
    content,
    count=1
)

# 4. Update TrashPhotoItem signature
content = re.sub(
    r'fun TrashPhotoItem\(\s*remotePhoto: RemotePhoto,\s*isSelected: Boolean,\s*modifier: Modifier = Modifier',
    '''fun TrashPhotoItem(
    remotePhoto: RemotePhoto,
    isSelected: Boolean,
    isScrollbarDragging: Boolean = false,
    thumbnailResolution: Int = 150,
    modifier: Modifier = Modifier''',
    content,
    count=1
)

# 5. Update ImageRequest to use dynamic sizing
old_trash_image_request = r'''val imageRequest = ImageRequest\.Builder\(context\)
                \.data\(remotePhoto\)
                \.size\(Size\(150, 150\)\)
                \.crossfade\(100\)
                \.build\(\)'''

new_trash_image_request = '''val targetSize = if (isScrollbarDragging) 50 else thumbnailResolution
            
            val imageRequest = ImageRequest.Builder(context)
                .data(remotePhoto)
                .size(Size(targetSize, targetSize))
                .crossfade(if (isScrollbarDragging) false else 100)
                .allowHardware(!isScrollbarDragging)
                .build()'''

content = re.sub(old_trash_image_request, new_trash_image_request, content, count=1)

# Write back
with open(r"c:\Users\ashin\StudioProjects\CloudGallery\app\src\main\java\com\akslabs\chitralaya\ui\main\screens\trash\TrashBinScreen.kt", "w", encoding="utf-8") as f:
    f.write(content)

print("TrashBinScreen.kt updated successfully!")
