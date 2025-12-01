import re

# Fix RemotePhotoGrid.kt
file_path_remote = r'c:\Users\ashin\StudioProjects\CloudGallery\app\src\main\java\com\akslabs\chitralaya\ui\main\screens\remote\RemotePhotoGrid.kt'

with open(file_path_remote, 'r', encoding='utf-8') as f:
    content = f.read()

# Find and replace ExpressiveScrollbar call
old_scrollbar = """            ExpressiveScrollbar(
                lazyGridState = lazyGridState,
                modifier = Modifier.align(Alignment.CenterEnd)
            )"""

new_scrollbar = """            ExpressiveScrollbar(
                lazyGridState = lazyGridState,
                totalItemsCount = cloudPhotos.itemCount,
                columnCount = columns,
                modifier = Modifier.align(Alignment.CenterEnd)
            )"""

content = content.replace(old_scrollbar, new_scrollbar)

with open(file_path_remote, 'w', encoding='utf-8') as f:
    f.write(content)

print("Updated RemotePhotoGrid.kt")

# Fix TrashBinScreen.kt  
file_path_trash = r'c:\Users\ashin\StudioProjects\CloudGallery\app\src\main\java\com\akslabs\chitralaya\ui\main\screens\trash\TrashBinScreen.kt'

with open(file_path_trash, 'r', encoding='utf-8') as f:
    content = f.read()

old_scrollbar_trash = """            ExpressiveScrollbar(
                lazyGridState = lazyGridState,
                modifier = Modifier.align(Alignment.CenterEnd)
            )"""

new_scrollbar_trash = """            ExpressiveScrollbar(
                lazyGridState = lazyGridState,
                totalItemsCount = deletedPhotos.itemCount,
                columnCount = columns,
                modifier = Modifier.align(Alignment.CenterEnd)
            )"""

content = content.replace(old_scrollbar_trash, new_scrollbar_trash)

with open(file_path_trash, 'w', encoding='utf-8') as f:
    f.write(content)

print("Updated TrashBinScreen.kt")
print("\nAll scrollbar calls updated successfully!")
