import re

# Fix RemotePhotoGrid.kt
with open(r"c:\Users\ashin\StudioProjects\CloudGallery\app\src\main\java\com\akslabs\chitralaya\ui\main\screens\remote\RemotePhotoGrid.kt", "r", encoding="utf-8") as f:
    content = f.read()

# Replace the crossfade conditional with separate builder calls
old_pattern = r'''val targetSize = if \(isScrollbarDragging\) 50 else thumbnailResolution
                
                val imageRequest = ImageRequest\.Builder\(context\)
                    \.data\(remotePhoto\)
                    \.size\(Size\(targetSize, targetSize\)\)
                    \.memoryCacheKey\("grid_thumb_\$\{remotePhoto\.remoteId\}"\)
                    \.diskCacheKey\("grid_thumb_\$\{remotePhoto\.remoteId\}"\)
                    \.crossfade\(if \(isScrollbarDragging\) false else 100\)
                    \.allowHardware\(!isScrollbarDragging\)
                    \.allowRgb565\(true\)
                    \.build\(\)'''

new_pattern = '''val targetSize = if (isScrollbarDragging) 50 else thumbnailResolution
                
                val imageRequestBuilder = ImageRequest.Builder(context)
                    .data(remotePhoto)
                    .size(Size(targetSize, targetSize))
                    .memoryCacheKey("grid_thumb_${remotePhoto.remoteId}")
                    .diskCacheKey("grid_thumb_${remotePhoto.remoteId}")
                    .allowRgb565(true)
                
                if (!isScrollbarDragging) {
                    imageRequestBuilder.crossfade(100)
                }
                
                val imageRequest = imageRequestBuilder.build()'''

content = re.sub(old_pattern, new_pattern, content, count=1)

with open(r"c:\Users\ashin\StudioProjects\CloudGallery\app\src\main\java\com\akslabs\chitralaya\ui\main\screens\remote\RemotePhotoGrid.kt", "w", encoding="utf-8") as f:
    f.write(content)

print("RemotePhotoGrid.kt fixed!")

# Fix TrashBinScreen.kt
with open(r"c:\Users\ashin\StudioProjects\CloudGallery\app\src\main\java\com\akslabs\chitralaya\ui\main\screens\trash\TrashBinScreen.kt", "r", encoding="utf-8") as f:
    content = f.read()

old_trash_pattern = r'''val targetSize = if \(isScrollbarDragging\) 50 else thumbnailResolution
            
            val imageRequest = ImageRequest\.Builder\(context\)
                \.data\(remotePhoto\)
                \.size\(Size\(targetSize, targetSize\)\)
                \.crossfade\(if \(isScrollbarDragging\) false else 100\)
                \.allowHardware\(!isScrollbarDragging\)
                \.build\(\)'''

new_trash_pattern = '''val targetSize = if (isScrollbarDragging) 50 else thumbnailResolution
            
            val imageRequestBuilder = ImageRequest.Builder(context)
                .data(remotePhoto)
                .size(Size(targetSize, targetSize))
            
            if (!isScrollbarDragging) {
                imageRequestBuilder.crossfade(100)
            }
            
            val imageRequest = imageRequestBuilder.build()'''

content = re.sub(old_trash_pattern, new_trash_pattern, content, count=1)

with open(r"c:\Users\ashin\StudioProjects\CloudGallery\app\src\main\java\com\akslabs\chitralaya\ui\main\screens\trash\TrashBinScreen.kt", "w", encoding="utf-8") as f:
    f.write(content)

print("TrashBinScreen.kt fixed!")
