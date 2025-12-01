import re

file_path = r'c:\Users\ashin\StudioProjects\CloudGallery\app\src\main\java\com\akslabs\chitralaya\ui\main\screens\local\LocalPhotoGrid.kt'

with open(file_path, 'r', encoding='utf-8') as f:
    lines = f.readlines()

# Find package declaration
package_idx = -1
for i, line in enumerate(lines):
    if line.strip().startswith('package '):
        package_idx = i
        break

if package_idx == -1:
    print("Error: Could not find package declaration")
    exit(1)

# Collect all imports and code after package
imports = []
code_lines = [lines[package_idx]]  # Start with package line

i = package_idx + 1
while i < len(lines):
    line = lines[i]
    if line.strip().startswith('import '):
        import_stmt = line.strip()
        if import_stmt not in imports:
            imports.append(import_stmt)
    elif line.strip() == '' or not line.strip().startswith('import '):
        # End of imports, rest is code
        code_lines.extend(lines[i:])
        break
    i += 1

# Ensure essential imports are present
essential_imports = [
    'import android.app.Activity',
    'import android.content.Context',
    'import android.content.ContextWrapper',
    'import android.content.ContentUris',
    'import android.provider.MediaStore',
]

for imp in essential_imports:
    if imp not in imports:
        imports.insert(0, imp)

# Sort imports
imports.sort()

# Reconstruct file
new_content = code_lines[0]  # package line
if not new_content.endswith('\n'):
    new_content += '\n'
new_content += '\n'

for imp in imports:
    new_content += imp + '\n'

# Add rest of code (skip first line which is package)
new_content += ''.join(code_lines[1:])

with open(file_path, 'w', encoding='utf-8') as f:
    f.write(new_content)

print("Successfully fixed imports in LocalPhotoGrid.kt")
