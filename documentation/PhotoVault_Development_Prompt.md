# PhotoVault Android App Development Prompt

## Project Overview
I need you to help me build **PhotoVault**, a modern Android photo backup application from scratch. This app should provide seamless cloud storage integration through Telegram Bot API with a clean, intuitive Material Design 3 interface.

## Core Requirements

### Primary Features
1. **Device Photos Screen**: Display all photos currently on the device in a grid layout
2. **Uploaded Photos Screen**: Display all photos that have been backed up to cloud
3. **Photo Viewer**: Full-screen photo viewing with zoom/pan capabilities
4. **Cloud Backup**: Upload photos to Telegram using Bot API
5. **Settings Screen**: Configure backup preferences and bot credentials
6. **Background Sync**: Automatic periodic backup and MediaStore synchronization
7. **Database Export/Import**: Backup and restore app data

### Simplified Logic (Key Requirement)
- **Two clear sections only**: "Device Photos" and "Uploaded Photos"
- **Device Photos**: All photos currently on the device (from MediaStore)
- **Uploaded Photos**: All photos that have been backed up to cloud (marked as uploaded in database)
- **No complex filtering**: Remove any "on device" vs "not on device" logic

## Technical Stack Requirements

### Architecture & Frameworks
- **UI**: Jetpack Compose with Material Design 3
- **Architecture**: MVVM with Clean Architecture principles
- **Database**: Room with SQLite
- **Networking**: Retrofit with OkHttp for Telegram Bot API
- **Image Loading**: Coil with proper caching
- **Background Work**: WorkManager for uploads and sync
- **DI**: Hilt for dependency injection
- **Async**: Kotlin Coroutines + Flow
- **Navigation**: Compose Navigation
- **State Management**: StateFlow + Compose State

### Database Schema
```kotlin
// Photo Entity
@Entity(tableName = "photos")
data class Photo(
    @PrimaryKey val id: String,           // MediaStore ID
    @ColumnInfo val fileName: String,     // Original filename
    @ColumnInfo val filePath: String,     // Content URI
    @ColumnInfo val mimeType: String,     // MIME type
    @ColumnInfo val fileSize: Long,       // File size in bytes
    @ColumnInfo val dateAdded: Long,      // Date added to device
    @ColumnInfo val dateModified: Long,   // Last modified date
    @ColumnInfo val isUploaded: Boolean = false,  // Upload status
    @ColumnInfo val uploadedAt: Long? = null,     // Upload timestamp
    @ColumnInfo val remoteFileId: String? = null, // Telegram file ID
    @ColumnInfo val compressionRatio: Float? = null // Compression applied
)

// Upload Queue Entity
@Entity(tableName = "upload_queue")
data class UploadQueueItem(
    @PrimaryKey val id: String = UUID.randomUUID().toString(),
    @ColumnInfo val photoId: String,      // Reference to Photo
    @ColumnInfo val priority: Int = 0,    // Upload priority
    @ColumnInfo val retryCount: Int = 0,  // Number of retry attempts
    @ColumnInfo val status: UploadStatus, // PENDING, IN_PROGRESS, FAILED, COMPLETED
    @ColumnInfo val errorMessage: String? = null,
    @ColumnInfo val createdAt: Long = System.currentTimeMillis()
)

// App Settings Entity
@Entity(tableName = "app_settings")
data class AppSettings(
    @PrimaryKey val id: Int = 1,
    @ColumnInfo val botToken: String? = null,
    @ColumnInfo val channelId: String? = null,
    @ColumnInfo val autoBackupEnabled: Boolean = false,
    @ColumnInfo val backupOnWifiOnly: Boolean = true,
    @ColumnInfo val compressionQuality: Int = 85,
    @ColumnInfo val maxFileSize: Long = 50 * 1024 * 1024, // 50MB
    @ColumnInfo val backupFrequency: BackupFrequency = BackupFrequency.DAILY,
    @ColumnInfo val lastBackupTime: Long? = null
)
```

## UI/UX Requirements

### Material Design 3 Implementation
- **Theme**: Use Material Design 3 color scheme and typography
- **Components**: Cards, FABs, TopAppBars, FilterChips, etc.
- **Animations**: Smooth transitions between screens and states
- **Grid Layout**: Photos displayed in adaptive grid (GridCells.Adaptive)
- **Rounded Corners**: 12dp radius for photo grid items
- **Status Indicators**: Cloud icons for uploaded photos

### Screen Structure
```
MainActivity
├── MainNavigation
    ├── DevicePhotosScreen
    │   ├── PhotoGrid (LazyVerticalGrid)
    │   ├── PhotoViewer (HorizontalPager with zoom)
    │   └── UploadFab (Manual upload trigger)
    ├── UploadedPhotosScreen
    │   ├── PhotoGrid (LazyVerticalGrid)
    │   ├── PhotoViewer (HorizontalPager with zoom)
    │   └── DownloadFab (Download from cloud)
    └── SettingsScreen
        ├── Bot Configuration
        ├── Backup Preferences
        └── App Settings
```

### Key Composables Needed
1. **PhotoGrid**: Lazy grid with pagination support
2. **PhotoGridItem**: Individual photo card with upload status indicator
3. **PhotoViewer**: Full-screen viewer with zoom/pan and navigation
4. **UploadProgressIndicator**: Show upload progress
5. **SettingsCard**: Reusable settings item component

## Package Structure
```
com.photovault.app/
├── data/
│   ├── database/ (entities, dao, database)
│   ├── repository/ (PhotoRepository, BackupRepository, SettingsRepository)
│   ├── remote/ (TelegramApiService, DTOs)
│   └── local/ (MediaStoreDataSource, PreferencesDataSource)
├── domain/
│   ├── model/ (domain models)
│   ├── repository/ (repository interfaces)
│   └── usecase/ (GetDevicePhotosUseCase, UploadPhotoUseCase, etc.)
├── presentation/
│   ├── ui/screen/ (DevicePhotosScreen, UploadedPhotosScreen, SettingsScreen)
│   ├── ui/component/ (PhotoGrid, PhotoViewer, etc.)
│   ├── ui/theme/ (Material Design 3 theme)
│   ├── viewmodel/ (screen ViewModels)
│   └── navigation/ (NavHost setup)
├── worker/ (BackupWorker, SyncWorker, CleanupWorker)
└── di/ (Hilt modules)
```

## Core Functionality Implementation

### 1. MediaStore Integration
- Scan device photos using MediaStore API
- Extract metadata (filename, size, date, etc.)
- Monitor changes and sync with local database
- Handle permissions properly

### 2. Telegram Bot API Integration
- Implement file upload using sendDocument API
- Handle large files with proper compression
- Implement retry mechanism for failed uploads
- Store Telegram file IDs for uploaded photos

### 3. Background Processing
- **BackupWorker**: Periodic photo backup
- **SyncWorker**: Sync with MediaStore changes
- **CleanupWorker**: Remove orphaned database entries
- Use WorkManager constraints (WiFi, battery, etc.)

### 4. Image Compression
- Compress photos before upload based on settings
- Maintain quality while reducing file size
- Support JPEG, PNG, WebP formats
- Configurable compression quality (default 85%)

### 5. Database Operations
- Efficient pagination for large photo collections
- Proper indexing for performance
- Export/import functionality for backup
- Migration strategy for schema changes

## Performance Requirements
- **Memory Efficient**: Use Coil for image loading with proper caching
- **Smooth Scrolling**: Implement proper pagination (20-50 items per page)
- **Background Processing**: Non-blocking uploads and sync operations
- **Network Optimization**: Compress images, handle rate limiting
- **Battery Friendly**: Use appropriate WorkManager constraints

## Development Approach
1. **Start with**: Basic project setup, navigation, and Material Design 3 theme
2. **Phase 1**: Implement MediaStore integration and Device Photos screen
3. **Phase 2**: Add database layer and photo management
4. **Phase 3**: Implement Telegram API integration and upload functionality
5. **Phase 4**: Add Uploaded Photos screen and photo viewer
6. **Phase 5**: Implement Settings screen and background workers
7. **Phase 6**: Add export/import functionality and polish UI

## Key Implementation Notes
- Use `LazyVerticalGrid` with `GridCells.Adaptive(minSize = 120.dp)` for photo grids
- Implement proper error handling with user-friendly messages
- Use `PagingSource` for efficient large dataset handling
- Implement proper state management with `StateFlow` and Compose state
- Add loading states and progress indicators for better UX
- Use `Card` composables with `RoundedCornerShape(12.dp)` for photo items
- Implement proper navigation with Compose Navigation
- Add upload status indicators (cloud icons) on photo grid items

## Success Criteria
- Clean, modern Material Design 3 interface
- Smooth performance with large photo collections
- Reliable cloud backup functionality
- Intuitive two-section layout (Device/Uploaded)
- Proper error handling and user feedback
- Efficient background processing
- Maintainable, well-organized code structure

Please help me implement this PhotoVault application step by step, starting with the basic project setup and progressing through each phase. Focus on clean architecture, modern Android development practices, and excellent user experience.
