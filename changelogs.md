# Changelog

All notable changes to this project will be documented in this file.

## [Unreleased] - 2026-06-04

### Features
- **Telegram topic based folder specific uploads** (PR26): Implemented forum topic creation/lookup for uploads. Workers create or look up forum topics via `createForumTopic`, cache them in `topicCache`, and persist `topicId` and `topicName` to the `remote_photos` table for topic-specific uploads.
- **Album chip bar in cloud screen** (PR26): Added album chip bar UI above the cloud photo grid showing topic-based albums.
- **Custom preview size selector** (PR28): Added compact chip selector for image preview size (25KB, 50KB, 100KB, 200KB, 400KB, Custom) with centered underline-only input field for custom sizes (in KB). Preference stored via `syncImagePreviewSizeKey`.

### Fixes
- **Duplicate topic prevention** (PR26): Added `RemotePhotoDao.getTopicIdByName()` so workers check the database (survives app restarts) before calling Telegram API to create a topic, preventing duplicate topics for the same folder.
- **PagingSource crash fix** (PR26): Changed `allCloudPhotosFlow` implementation to move PagingSource creation inside `flatMapLatest` factory lambda, preventing `IllegalStateException: An instance of PagingSource was re-used`.
- **Preview sent to General fix** (PR26): Added `messageThreadId` and `topicName` parameters to `uploadPreviewFile`; both `PeriodicPhotoBackupWorker` and `InstantPhotoUploadWorker` now pass them through so previews are posted to the correct forum topic instead of General chat.
- **Removed pending/queued items from RemotePhotoGrid** (PR26): Deleted `PendingItem`, `PendingPhotoItem` classes and removed `pendingPhotos` parameter from `RemotePhotoGrid`; cleaned up associated wiring in `AppNavHost`.
- **Manage Uploads thumbnails fix** (PR26): Updated `mapRemotePhotoToUiItem` in `ManageUploadsViewModel` to use `FileIdData(fileId)` instead of `RemotePhoto` object when local file is missing; upload item card sets proper cache keys for `FileIdData` so Coil can download thumbnail via custom fetcher.
- **Backup compatibility for older backups** (PR26): 
  - `RemotePhoto` entity fields `topicId` and `topicName` made nullable with default `null` via `@JsonCreator`; Jackson’s `ObjectMapper` configured with `FAIL_ON_UNKNOWN_PROPERTIES = false`.
  - Changed `importDatabase` and `downloadDatabaseFromTelegram` in `BackupHelper` to use `insertPhotos` (`OnConflictStrategy.IGNORE`) for `photos` table and `insertAllIfNotExists` (`OnConflictStrategy.IGNORE`) for `remote_photos` table. This prevents overwriting existing rows (and thus losing newer fields like `topicId`, `topicName`, `previewRemoteId`, etc.) when importing an older backup that lacks those columns.

### Internal / Refactor
- Added `RemotePhotoDao.insertAllIfNotExists` method (`@Insert(onConflict = OnConflictStrategy.IGNORE)`) for safe backup imports.
- Updated Preferences to include `syncImagePreviewSizeKey` for storing user-selected preview size threshold.
- Various DAO and worker adjustments to support topic-based uploads and related features.
