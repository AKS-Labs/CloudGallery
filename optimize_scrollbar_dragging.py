import re

file_path = r'c:\Users\ashin\StudioProjects\CloudGallery\app\src\main\java\com\akslabs\chitralaya\ui\main\screens\local\LocalPhotoGrid.kt'

with open(file_path, 'r', encoding='utf-8') as f:
    content = f.read()

# 1. Add dragging state at the beginning of LocalPhotoGrid function
old_func_start = """@OptIn(ExperimentalMaterial3ExpressiveApi::class, ExperimentalFoundationApi::class)
@Composable
fun LocalPhotoGrid(
    localPhotos: LazyPagingItems<LocalUiPhoto>,
    totalCount: Int,
    expanded: Boolean,
    onExpandedChange: (Boolean) -> Unit,
    selectionMode: Boolean,
    selectedPhotos: Set<String>,
    onSelectionModeChange: (Boolean) -> Unit,
    onSelectedPhotosChange: (Set<String>) -> Unit,
    deletedPhotoIds: List<String>
) {
    val context = LocalContext.current
    val activity = context.findActivity()
    val window = activity?.window

    var selectedIndex by remember { mutableStateOf<Int?>(null) }
    var selectedPhoto by remember { mutableStateOf<LocalUiPhoto?>(null) }

    val glideSelectionBehavior by Preferences.getStringFlow(Preferences.glideSelectionBehaviorKey, "Fixed").collectAsStateWithLifecycle()"""

new_func_start = """@OptIn(ExperimentalMaterial3ExpressiveApi::class, ExperimentalFoundationApi::class)
@Composable
fun LocalPhotoGrid(
    localPhotos: LazyPagingItems<LocalUiPhoto>,
    totalCount: Int,
    expanded: Boolean,
    onExpandedChange: (Boolean) -> Unit,
    selectionMode: Boolean,
    selectedPhotos: Set<String>,
    onSelectionModeChange: (Boolean) -> Unit,
    onSelectedPhotosChange: (Set<String>) -> Unit,
    deletedPhotoIds: List<String>
) {
    val context = LocalContext.current
    val activity = context.findActivity()
    val window = activity?.window

    var selectedIndex by remember { mutableStateOf<Int?>(null) }
    var selectedPhoto by remember { mutableStateOf<LocalUiPhoto?>(null) }
    var isScrollbarDragging by remember { mutableStateOf(false) }

    val glideSelectionBehavior by Preferences.getStringFlow(Preferences.glideSelectionBehaviorKey, "Fixed").collectAsStateWithLifecycle()"""

content = content.replace(old_func_start, new_func_start)

# 2. Update ExpressiveScrollbar call to include onDraggingChange
old_scrollbar_pattern = r'(ExpressiveScrollbar\(\s*lazyGridState\s*=\s*lazyGridState,\s*totalItemsCount\s*=\s*[^,]+,\s*columnCount\s*=\s*[^,]+,)'

new_scrollbar = r'\1\n                    onDraggingChange = { isScrollbarDragging = it },'

content = re.sub(old_scrollbar_pattern, new_scrollbar, content)

# 3. Update LocalPhotoItem call to pass dragging state
old_item_call = """                                    LocalPhotoItem(
                                        photo = p,
                                        index = item.originalIndex,
                                        isSelected = isSelected,
                                        isDeleted = isDeleted,"""

new_item_call = """                                    LocalPhotoItem(
                                        photo = p,
                                        index = item.originalIndex,
                                        isSelected = isSelected,
                                        isDeleted = isDeleted,
                                        isScrollbarDragging = isScrollbarDragging,"""

content = content.replace(old_item_call, new_item_call)

# 4. Update LocalPhotoItem signature and implementation
old_item_sig = """@Composable
fun LocalPhotoItem(
    photo: LocalUiPhoto,
    index: Int,
    isSelected: Boolean,
    isDeleted: Boolean,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current"""

new_item_sig = """@Composable
fun LocalPhotoItem(
    photo: LocalUiPhoto,
    index: Int,
    isSelected: Boolean,
    isDeleted: Boolean,
    isScrollbarDragging: Boolean = false,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current"""

content = content.replace(old_item_sig, new_item_sig)

# 5. Update image request to use lower quality when dragging
old_image_request = """            SubcomposeAsyncImage(
                model = ImageRequest.Builder(context)
                    .data(photo.pathUri)
                    .size(Size(150, 150)) // Thumbnail size
                    .crossfade(true)
                    .build(),"""

new_image_request = """            SubcomposeAsyncImage(
                model = ImageRequest.Builder(context)
                    .data(photo.pathUri)
                    .size(if (isScrollbarDragging) Size(50, 50) else Size(150, 150))
                    .allowHardware(!isScrollbarDragging)
                    .crossfade(!isScrollbarDragging)
                    .memoryCachePolicy(if (isScrollbarDragging) coil.request.CachePolicy.ENABLED else coil.request.CachePolicy.ENABLED)
                    .diskCachePolicy(if (isScrollbarDragging) coil.request.CachePolicy.ENABLED else coil.request.CachePolicy.ENABLED)
                    .build(),"""

content = content.replace(old_image_request, new_image_request)

with open(file_path, 'w', encoding='utf-8') as f:
    f.write(content)

print("Successfully optimized LocalPhotoGrid for scrollbar dragging")
