import re

# Read the file
with open(r"c:\Users\ashin\StudioProjects\CloudGallery\app\src\main\java\com\akslabs\chitralaya\ui\main\screens\remote\RemotePhotoGrid.kt", "r", encoding="utf-8") as f:
    content = f.read()

# 1. Add parameters to CloudPhotoItem call
content = re.sub(
    r'(CloudPhotoItem\(\s*remotePhoto = item\.photo,\s*index = item\.originalIndex,\s*isSelected = isSelected,\s*)(modifier = Modifier\.clickable\()',
    r'\1isScrollbarDragging = isScrollbarDragging,\n                                thumbnailResolution = thumbnailResolution,\n                                \2',
    content,
    count=1
)

# 2. Update CloudPhotoItem signature
content = re.sub(
    r'fun CloudPhotoItem\(\s*remotePhoto: RemotePhoto\?,\s*index: Int,\s*isSelected: Boolean,\s*modifier: Modifier = Modifier',
    '''fun CloudPhotoItem(
    remotePhoto: RemotePhoto?,
    index: Int,
    isSelected: Boolean,
    isScrollbarDragging: Boolean = false,
    thumbnailResolution: Int = 150,
    modifier: Modifier = Modifier''',
    content,
    count=1
)

# 3. Update ImageRequest in CloudPhotoItem
old_image_request = r'''val imageRequest = ImageRequest\.Builder\(context\)
                    \.data\(remotePhoto\)
                    \.size\(Size\(150, 150\)\) // Even smaller for faster loading
                    \.memoryCacheKey\("grid_thumb_\$\{remotePhoto\.remoteId\}"\)
                    \.diskCacheKey\("grid_thumb_\$\{remotePhoto\.remoteId\}"\)
                    \.crossfade\(100\) // Faster transition
                    \.allowHardware\(true\) // Use hardware acceleration
                    \.allowRgb565\(true\) // Use less memory
                    \.build\(\)'''

new_image_request = '''val targetSize = if (isScrollbarDragging) 50 else thumbnailResolution
                
                val imageRequest = ImageRequest.Builder(context)
                    .data(remotePhoto)
                    .size(Size(targetSize, targetSize))
                    .memoryCacheKey("grid_thumb_${remotePhoto.remoteId}")
                    .diskCacheKey("grid_thumb_${remotePhoto.remoteId}")
                    .crossfade(if (isScrollbarDragging) false else 100)
                    .allowHardware(!isScrollbarDragging)
                    .allowRgb565(true)
                    .build()'''

content = re.sub(old_image_request, new_image_request, content, count=1)

# Write back
with open(r"c:\Users\ashin\StudioProjects\CloudGallery\app\src\main\java\com\akslabs\chitralaya\ui\main\screens\remote\RemotePhotoGrid.kt", "w", encoding="utf-8") as f:
    f.write(content)

print("RemotePhotoGrid.kt updated successfully!")
