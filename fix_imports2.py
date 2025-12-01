import re

file_path = r'c:\Users\ashin\StudioProjects\CloudGallery\app\src\main\java\com\akslabs\chitralaya\ui\main\screens\local\LocalPhotoGrid.kt'

with open(file_path, 'r', encoding='utf-8') as f:
    content = f.read()

# Remove the misplaced import at the beginning
content = content.replace("import android.content.Context\npackage com.akslabs.cloudgallery.ui.main.screens.local", "package com.akslabs.cloudgallery.ui.main.screens.local")

# Remove duplicate ContextWrapper import
lines = content.split('\n')
seen_imports = set()
new_lines = []
for line in lines:
    if line.strip().startswith('import '):
        if line.strip() not in seen_imports:
            seen_imports.add(line.strip())
            new_lines.append(line)
    else:
        new_lines.append(line)

content = '\n'.join(new_lines)

# Now add Context import after package if not present
if 'import android.content.Context' not in content:
    content = content.replace(
        'package com.akslabs.cloudgallery.ui.main.screens.local\n\n',
        'package com.akslabs.cloudgallery.ui.main.screens.local\n\nimport android.content.Context\n'
    )

# Write back
with open(file_path, 'w', encoding='utf-8') as f:
    f.write(content)

print("Successfully fixed import order in LocalPhotoGrid.kt")
