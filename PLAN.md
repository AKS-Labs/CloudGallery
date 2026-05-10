# CloudGallery Bug Fix Plan

## Architecture Summary

**Chitralaya CloudGallery** is an Android app (Kotlin, Jetpack Compose, Room, WorkManager) that uses a Telegram bot as a private photo cloud storage backend.

### Data Flow
1. **Local photos** are discovered via MediaStore and stored in `photos` table (Room DB)
2. **Uploads** send files to a Telegram channel via Bot API (`BotApi.sendFile`), then update `photos.remoteId` and insert into `remote_photos` table
3. **Sync** uses `getUpdates()` (Bot API polling) to discover remote photos and populate `remote_photos`
4. **Downloads** fetch files via `BotApi.getFile(fileId)` and save to MediaStore

### Key Components
| Layer | Files | Purpose |
|-------|-------|---------|
| DB | `WhDatabase`, `PhotoDao`, `RemotePhotoDao`, `DeletedPhotoDao` | Room DB v7, 3 tables |
| Entities | `Photo` (local+remote link), `RemotePhoto` (cloud state), `DeletedPhoto` (trash) |
| Workers | `PeriodicPhotoBackupWorker` (batch upload), `InstantPhotoUploadWorker` (single upload), `CloudPhotoSyncWorker` (discover remote), `SyncDbMediaStoreWorker` (local scan), `SyncRemoteSizesWorker`, `DailyDatabaseBackupWorker` |
| Services | `CloudPhotoSyncService` (sync orchestrator), `HistoricalImageDiscoveryService` (channel scanner) |
| API | `BotApi` (kotlin-telegram-bot wrapper), `TelegramHttp`/`TelegramRawApi` (validation) |
| Upload util | `sendFileViaUri()` / `sendFileApi()` in `Utils.kt` |

### Build Info
- **compileSdk:** 36, **targetSdk:** 36, **minSdk:** 29
- **Kotlin:** via version catalog (likely 1.9.x+), **JVM target:** 1.8
- **Room:** v? (via libs catalog), **WorkManager:** via `androidx.work.runtime`
- **Telegram lib:** `com.github.kotlin-telegram-bot` (Bot API wrapper)
- **No Android SDK** found on this machine (`ANDROID_HOME` not set) — can't build here

---

## Bug 1: Database Sync Not Working

### Root Cause Analysis

**PRIMARY ISSUE: `scanChannelForMedia()` uses `getUpdates()` — fundamentally wrong for channel scanning.**

In `BotApi.kt` line ~140, `scanChannelForMedia()` calls `bot.getUpdates()`. This is the **Bot API polling endpoint** which:
- Only returns **unprocessed incoming updates** (new messages/commands sent TO the bot)
- Does NOT return historical channel messages
- Updates are **consumed after reading** — once acknowledged, they're gone forever
- Has a 24-hour retention window
- Cannot scan a channel's message history at all

This means:
1. `HistoricalImageDiscoveryService` gets zero or near-zero results from `scanChannelForMedia()`
2. The `remote_photos` table is never properly populated from existing channel content
3. Local ↔ remote sync is fundamentally broken because the remote inventory is incomplete

**SECONDARY ISSUES:**
- **No transactional consistency** between `photos` and `remote_photos` updates in `sendFileApi()`. The `updateRemoteIdForPath` + `insertAll(RemotePhoto)` are two separate DB calls — a crash between them leaves inconsistent state
- **`SyncDbMediaStoreWorker` deletes photos that moved** — it queries all MediaStore images, then deletes any DB entry whose `localId` doesn't match. If a photo moves (URI changes), it gets deleted from DB, losing its `remoteId` link
- **`RemotePhotoDao.insertAll` uses `REPLACE` strategy** — re-inserting an existing remoteId overwrites all fields including `thumbnailCached`, `fileSize`, etc.

### Proposed Fix

**Fix 1A — Replace `getUpdates()` with proper channel history scanning (CRITICAL)**

File: `api/BotApi.kt`

The Bot API does NOT have a `getMessages` or `getChatHistory` method. There are two approaches:

**Option A (Recommended): Use `forwardMessage` probing + stored message IDs**
- When uploading, we already store `messageId` in `RemotePhoto`
- For sync, iterate known message IDs and call `getFile` to verify they still exist
- For discovery of uploads done outside the app, this won't work — but that's a niche case

**Option B (Better but harder): Use Telegram TDLib or MTProto**
- Replace the Bot API for sync operations with TDLib (Telegram Database Library)
- TDLib provides `getChatHistory()` which can scan all messages
- This is a significant architectural change

**Option C (Pragmatic): Track uploads properly so sync isn't needed**
- Since the app itself does all uploads, ensure `remote_photos` is always updated atomically during upload
- Use the upload path as the source of truth instead of trying to discover from channel
- Only use sync for the "restore after reinstall" scenario, where the DB backup file is restored from Telegram

**Recommended approach: Option C for now, Option B as a future enhancement.**

- In `sendFileApi()`, wrap the two DB operations in a Room `@Transaction`
- Add a `SyncVerificationWorker` that checks known `remoteId`s still resolve via `getFile`
- For restore-after-reinstall, rely on the daily DB backup feature (already implemented)

**Fix 1B — Protect `SyncDbMediaStoreWorker` from deleting moved photos**

File: `workers/SyncDbMediaStoreWorker.kt`

```kotlin
// BEFORE: deletes by localId mismatch (breaks on URI changes)
val deletedPhotos = photosInDb.filter { photo ->
    photosOnDevice.none { it.localId == photo.localId }
}

// AFTER: only delete if photo is truly gone AND has no remoteId (preserve cloud-linked records)
val deletedPhotos = photosInDb.filter { photo ->
    photosOnDevice.none { it.localId == photo.localId } && photo.remoteId == null
}
```

**Fix 1C — Add `@Transaction` to upload DB operations**

File: `utils/Utils.kt` — `sendFileApi()`

Wrap the `updateRemoteIdForPath` + `remotePhotoDao().insertAll()` in a single Room transaction (add a new DAO method that does both atomically).

---

## Bug 2: Background Upload Stops After Some Time

### Root Cause Analysis

**PRIMARY ISSUE: `PeriodicPhotoBackupWorker` processes ALL un-uploaded photos in a single `doWork()` call with no batching or checkpointing.**

In `PeriodicPhotoBackupWorker.kt`:
1. `getAllNotUploaded()` fetches the entire list at once
2. Iterates with `fastForEachIndexed` uploading one-by-one sequentially
3. If ANY photo fails with `IOException`, the entire worker returns `Result.retry()` — **restarting from scratch**
4. WorkManager has a **10-minute execution limit** for expedited work. After that, the worker is killed.
5. The worker uses `setExpedited(OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST)` — when the expedited quota is exhausted, it runs as regular work which has even stricter limits
6. **No checkpointing** — there's no record of which photos were successfully uploaded in the current run, so retries re-upload everything

**SECONDARY ISSUES:**
- **No rate limiting for Telegram API** — Telegram Bot API has rate limits (~30 messages/second to a group, 20 messages/minute to a bot chat). Rapid sequential uploads can trigger 429 errors which aren't caught specifically
- **Temp files use `deleteOnExit()` not `delete()`** — temp files accumulate until process death, wasting storage during long upload sessions
- **`Result.retry()` on any IOException** — network blips on photo #500 restarts from photo #1
- **WorkManager `REPLACE` policy** for instant backup means starting a new backup cancels the running one

### Proposed Fix

**Fix 2A — Implement batched uploading with checkpointing (CRITICAL)**

File: `workers/PeriodicPhotoBackupWorker.kt`

```kotlin
// Upload in batches of 20, checkpoint after each batch
val BATCH_SIZE = 20
val imageList = DbHolder.database.photoDao().getAllNotUploaded()
val batches = imageList.chunked(BATCH_SIZE)

for ((batchIndex, batch) in batches.withIndex()) {
    for (photo in batch) {
        // upload single photo (existing logic)
        // On success, the DB is already updated via sendFileApi()
        // so this photo won't appear in getAllNotUploaded() on retry
    }
    // After each batch, yield to let WorkManager check constraints
    // The already-uploaded photos won't be re-fetched on retry
}
```

The key insight: `sendFileApi()` already calls `updateRemoteIdForPath()` on success, so `getAllNotUploaded()` (which queries `WHERE remoteId IS NULL`) naturally excludes completed uploads. The fix is just to **not abort the entire run on a single failure** — skip the failing photo and continue.

**Fix 2B — Replace IOException catch-all with per-photo error handling**

```kotlin
imageList.forEach { photo ->
    try {
        // upload logic
    } catch (e: IOException) {
        Log.e("PeriodicBackup", "Failed to upload ${photo.localId}, skipping: ${e.message}")
        failedCount++
        // Continue to next photo instead of aborting
    } finally {
        tempFile.delete() // not deleteOnExit()
    }
}
// Return success (all attempted) or retry (if too many failures)
return if (failedCount > imageList.size / 2) Result.retry() else Result.success()
```

**Fix 2C — Add Telegram rate limiting**

File: `utils/Utils.kt` or new `utils/RateLimiter.kt`

```kotlin
// Add delay between uploads to respect Telegram rate limits
private const val UPLOAD_DELAY_MS = 1500L // ~40 uploads/minute, well under limits

// In the upload loop:
delay(UPLOAD_DELAY_MS)
```

**Fix 2D — Use `APPEND` instead of `REPLACE` for periodic work**

File: `workers/WorkModule.kt` — `PeriodicBackup.enqueue()`

Change the instant backup from `ExistingWorkPolicy.REPLACE` to `ExistingWorkPolicy.KEEP` to avoid cancelling a running upload when a new one is triggered.

---

## Bug 3: Uploading is Slow

### Root Cause Analysis

**PRIMARY ISSUE: Uploads are completely sequential — one file at a time.**

In both `PeriodicPhotoBackupWorker` and the upload utils:
1. Each file is uploaded one-by-one in a `forEach` loop
2. Each upload involves: read file → create temp file → HTTP POST to Telegram → wait for response → update DB
3. No parallelism whatsoever
4. The Telegram Bot API `sendDocument` call blocks until the file is fully uploaded AND processed by Telegram servers

**SECONDARY ISSUES:**
- **Entire file read into memory** — `openInputStream(uri).readBytes()` loads the entire file into a byte array, then writes to temp file. For large photos (10-50MB), this wastes memory and time
- **Unnecessary compression check** — the 50MB threshold compression logic decodes the entire bitmap even when compression isn't needed (it always runs the BitmapFactory.decodeByteArray even for small files in the control flow, though the compress loop is gated)
- **Temp file creation uses random names** — no caching/reuse
- **No progress tracking per-file** — the user sees "uploading" but no individual file progress

### Proposed Fix

**Fix 3A — Parallel uploads with coroutine concurrency (HIGH IMPACT)**

File: `workers/PeriodicPhotoBackupWorker.kt`

```kotlin
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope

// Upload 3 files in parallel (conservative to respect Telegram limits)
val PARALLELISM = 3
val DELAY_BETWEEN_BATCHES_MS = 500L

imageList.chunked(PARALLELISM).forEach { batch ->
    coroutineScope {
        batch.map { photo ->
            async(Dispatchers.IO) {
                uploadSinglePhoto(photo) // extract current per-photo logic
            }
        }.awaitAll()
    }
    delay(DELAY_BETWEEN_BATCHES_MS)
}
```

**Fix 3B — Stream file directly instead of reading into memory**

File: `utils/Utils.kt` — `sendFileViaUri()`

```kotlin
// BEFORE: reads entire file into memory
val bytes = contentResolver.openInputStream(uri)?.use { it.readBytes() }

// AFTER: stream directly to temp file
contentResolver.openInputStream(uri)?.use { input ->
    tempFile.outputStream().use { output ->
        input.copyTo(output, bufferSize = 8192)
    }
}
```

**Fix 3C — Skip compression for files under 50MB (already gated but optimize)**

The compression logic reads the entire file into `bytes` first regardless. Move the size check earlier:

```kotlin
val fileSize = contentResolver.openFileDescriptor(uri, "r")?.statSize ?: 0
if (fileSize > FIFTY_MB) {
    // Only then read bytes and compress
} else {
    // Stream directly to temp file
}
```

**Fix 3D — Use OkHttp directly for upload with progress tracking**

The `kotlin-telegram-bot` library's `sendDocument` doesn't support progress callbacks. For better UX, consider using OkHttp directly with a `ProgressRequestBody` wrapper that reports upload progress to the foreground notification.

---

## Priority Order

| # | Fix | Bug | Impact | Effort | Files Changed |
|---|-----|-----|--------|--------|---------------|
| 1 | **2A** — Batched upload with checkpointing | Upload stops | 🔴 Critical | Medium | `PeriodicPhotoBackupWorker.kt` |
| 2 | **2B** — Per-photo error handling | Upload stops | 🔴 Critical | Low | `PeriodicPhotoBackupWorker.kt` |
| 3 | **1A-C** — Fix sync to use upload-time tracking | DB sync | 🔴 Critical | Medium | `BotApi.kt`, `Utils.kt`, `PhotoDao.kt` |
| 4 | **3A** — Parallel uploads | Slow uploads | 🟡 High | Medium | `PeriodicPhotoBackupWorker.kt` |
| 5 | **2C** — Telegram rate limiting | Upload stops | 🟡 High | Low | `Utils.kt` or new file |
| 6 | **3B** — Stream instead of memory load | Slow uploads | 🟡 High | Low | `Utils.kt` |
| 7 | **1B** — Protect SyncDbMediaStore | DB sync | 🟠 Medium | Low | `SyncDbMediaStoreWorker.kt` |
| 8 | **2D** — KEEP policy for work | Upload stops | 🟠 Medium | Low | `WorkModule.kt` |
| 9 | **3C** — Optimize compression skip | Slow uploads | 🟢 Low | Low | `PeriodicPhotoBackupWorker.kt` |
| 10 | **3D** — Progress tracking | Slow uploads (UX) | 🟢 Low | High | Multiple files |

---

## Build & Test Instructions

### This Machine (aj-HP-EliteBook)
- **No Android SDK installed** — `ANDROID_HOME` is not set
- Cannot build or run emulator here
- To set up: install Android Studio or Android command-line tools, set `ANDROID_HOME`

### To Build
```bash
# After installing Android SDK:
export ANDROID_HOME=~/Android/Sdk
cd /home/aj/Project/CloudGallery
./gradlew assembleDebug
# APK at: app/build/outputs/apk/debug/app-debug.apk
```

### To Test
1. Install APK on physical device or emulator
2. Configure Telegram bot token + channel ID in app settings
3. Test upload: select photos → start backup → verify all complete
4. Test sync: check Cloud tab shows all uploaded photos
5. Test background: start large batch upload → switch apps → wait 10+ minutes → verify it continues

### Key Test Scenarios
- **Bug 1:** Upload 10 photos, check `remote_photos` table matches, force-close and reopen — verify cloud count is correct
- **Bug 2:** Queue 100+ photos for upload, lock phone screen, wait 15 minutes — verify uploads continue
- **Bug 3:** Time uploading 50 photos before/after parallel upload fix — should see ~3x speedup

---

## Summary

The three bugs share a common theme: **the sync/upload pipeline was built for small-scale use and breaks under real-world conditions.**

- **DB sync** is broken because it uses `getUpdates()` (wrong API) instead of tracking uploads at write-time
- **Upload stopping** is caused by no checkpointing + WorkManager time limits + IOException aborting the entire batch
- **Slow uploads** are simply sequential when they could be parallel

Fixes 1-3 (checkpointing, error handling, sync fix) are critical and should be done first. Parallel uploads (fix 4) gives the biggest UX improvement. All other fixes are incremental improvements.
