file_path = r'c:\Users\ashin\StudioProjects\CloudGallery\app\src\main\java\com\akslabs\chitralaya\ui\main\screens\local\LocalPhotoGrid.kt'

with open(file_path, 'r', encoding='utf-8') as f:
    lines = f.readlines()

# We want to keep lines 0 to 321 (inclusive, 1-based index) -> 0 to 321 in 0-based index?
# Line 321 is index 320.
# Line 322 is index 321.

# We want to keep lines up to index 320.
# And then skip until we find the line that matches line 400 (index 399).
# Line 400 is "            Box(modifier = Modifier.fillMaxSize()) {\n"

# Let's verify the content around the cut.
print(f"Line 320: {lines[320]}") # } else {
print(f"Line 321: {lines[321]}") # Box...
print(f"Line 399: {lines[399]}") # Box...

# We want to remove lines[321] to lines[398].
# lines[399] is the one we want to keep.

new_lines = lines[:321] + lines[399:]

with open(file_path, 'w', encoding='utf-8') as f:
    f.writelines(new_lines)

print("Successfully removed duplicate code block.")
