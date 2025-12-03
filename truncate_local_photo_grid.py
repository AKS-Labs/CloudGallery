file_path = r'c:\Users\ashin\StudioProjects\CloudGallery\app\src\main\java\com\akslabs\chitralaya\ui\main\screens\local\LocalPhotoGrid.kt'

with open(file_path, 'r', encoding='utf-8') as f:
    lines = f.readlines()

# Keep lines 0 to 618 (inclusive, 0-based index) -> 0 to 618.
# Line 618 is index 618.
# Wait, line numbers in view_file are 1-based.
# So line 618 is index 617.
# Let's verify.

# Line 618 in view_file is "}"
# Line 619 is empty line?
# Line 620 is "private const val TAG = ..."

# I want to keep up to line 618 (index 617).
# So lines[:618]

# Let's verify line 617 (1-based 618)
print(f"Line 618: {lines[617]}")

# Let's verify line 619 (1-based 619)
if len(lines) > 618:
    print(f"Line 619: {lines[618]}")

new_lines = lines[:618]

with open(file_path, 'w', encoding='utf-8') as f:
    f.writelines(new_lines)

print("Successfully truncated file.")
