import re

file_path = r'c:\Users\ashin\StudioProjects\CloudGallery\app\src\main\java\com\akslabs\chitralaya\ui\main\screens\local\LocalPhotoGrid.kt'

with open(file_path, 'r', encoding='utf-8') as f:
    content = f.read()

# Fix imports
# Remove duplicate Context import and fix ContentUris
content = content.replace("import android.content.Context\nimport android.content.Context", "import android.content.Context")
content = content.replace("import android.content.ContentUrisWrapper", "") # Remove if present (error log said Unresolved reference 'ContentUrisWrapper' - wait, error said 'Unresolved reference ContentUrisWrapper' at line 7? No, error said 'Unresolved reference ContentUrisWrapper' at line 7. I probably messed up the previous script replacement)

# Let's just clean up imports manually via regex
content = re.sub(r'import android\.content\.Context\s+import android\.content\.Context', 'import android.content.Context', content)

# Fix ContextWrapper and baseContext unresolved reference
# It seems I might have deleted the import for ContextWrapper or the findActivity function is broken
# The error says: Unresolved reference 'ContextWrapper' at line 603
# Check if ContextWrapper is imported
if "import android.content.ContextWrapper" not in content:
    content = content.replace("import android.content.Context", "import android.content.Context\nimport android.content.ContextWrapper")

# Fix ambiguous Context import
# The error says: Conflicting import: imported name 'Context' is ambiguous.
# This usually happens if I imported it twice.
# I'll remove all "import android.content.Context" and add it once.
content = re.sub(r'import android\.content\.Context\n', '', content)
content = "import android.content.Context\n" + content

# Write back
with open(file_path, 'w', encoding='utf-8') as f:
    f.write(content)

print("Successfully fixed imports in LocalPhotoGrid.kt")
