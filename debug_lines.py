file_path = r'c:\Users\ashin\StudioProjects\CloudGallery\app\src\main\java\com\akslabs\chitralaya\ui\main\screens\local\LocalPhotoGrid.kt'

with open(file_path, 'r', encoding='utf-8') as f:
    lines = f.readlines()

for i in range(610, 630):
    if i < len(lines):
        print(f"{i+1}: {lines[i]}", end='')
