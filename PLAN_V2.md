# CloudGallery Plan V2 — Telegram-Native Architecture (Final)

## Core Principle
**Everything goes through Telegram. No HTTP server connection from the app. Ever.**

The server is a background processor that:
1. Downloads photos from Telegram
2. Runs face detection, EXIF extraction, location geocoding
3. Pushes the processed metadata DB back to Telegram as a file
4. App downloads and merges that metadata DB

## Architecture

```
┌─────────────────────────────────────────┐
│          Telegram Channel               │
│                                         │
│  Photos (documents with thumbnails)     │
│  Metadata DB (SQLite file, pinned msg)  │
│                                         │
└──────────────┬──────────────────────────┘
               │
    ┌──────────┴──────────┐
    │                     │
    ▼                     ▼
┌─────────┐         ┌──────────┐
│  Phone  │         │  Server  │
│  (App)  │         │ (Docker) │
│         │         │          │
│ - Grid  │         │ - Face   │
│ - View  │         │ - EXIF   │
│ - Sync  │         │ - Places │
│ - Search│         │ - Albums │
└─────────┘         └──────────┘
```

## How Metadata Sync Works

### Server Side (runs at home, background)
1. Server processes all photos: face detection, EXIF, GPS, clustering
2. Generates a `metadata.db` SQLite file containing:
   - `people` table: person_id, name, face_thumbnail_file_id, photo_ids
   - `places` table: place_id, name, city, country, lat, lon, photo_ids  
   - `photo_metadata` table: remote_id, date_taken, camera, width, height, person_ids, place_id
   - `albums` table: album_id, name, photo_ids (auto-generated: favorites, trips, etc.)
3. Uploads `metadata.db` to the Telegram channel as a document
4. Pins the message (or uses a known caption like `#cloudgallery_metadata_v1`)
5. Re-runs periodically (daily, or when new photos are uploaded)

### App Side
1. On app launch: check for pinned message or search for `#cloudgallery_metadata_v1`
2. Compare message_id with last synced message_id (stored in SharedPreferences)
3. If new metadata available: download the SQLite file
4. Import into local Room DB: merge people, places, photo_metadata
5. Now the app has all AI features locally — People, Places, Search by date/location

### Benefits
- ✅ Works from anywhere (mobile data, any WiFi)
- ✅ No HTTP connection needed
- ✅ No port forwarding, no LAN dependency
- ✅ Metadata is always up-to-date (server pushes new DB when ready)
- ✅ App is fully offline-capable after first sync
- ✅ Server can be turned off after processing — data persists in Telegram

## What's Already Built

### App (all deployed ✅)
| Feature | Status |
|---------|--------|
| Local thumbnail DB (zero-network scroll) | ✅ |
| ThumbnailSyncWorker (10 concurrent, newest-first) | ✅ |
| Amazon Photos grid UX (date groups, 2dp gaps) | ✅ |
| Full-screen preview (zoom, download, share, delete) | ✅ |
| Server settings UI (HTTP — will be replaced) | ✅ |
| Cleartext HTTP allowed | ✅ |
| Aggressive paging (200 per page, auto-load all) | ✅ |

### Server (Docker, port 8100)
| Phase | Feature | Status |
|-------|---------|--------|
| 1 | EXIF + Timeline | ✅ |
| 2 | Face Detection | ✅ |
| 3 | Places + Geocoding | ✅ |
| 4 | Search + Albums | ✅ |
| 5 | Web Dashboard | ✅ |
| 6 | Thumbnail Worker | ✅ (generating) |

## Remaining Phases

### Phase H: Telegram Metadata Push (Server Side)
1. Server generates `metadata.db` from processed data
2. Uploads to Telegram channel with caption `#cloudgallery_metadata_v1`
3. Pins the message
4. Cron job: re-generate and re-upload daily

### Phase I: Telegram Metadata Pull (App Side)  
1. App searches channel for `#cloudgallery_metadata_v1` message
2. Downloads the SQLite file
3. Imports into local Room DB (People, Places, Photo metadata)
4. UI: People tab, Places tab, enhanced Search
5. Shows "Last synced: 2 hours ago" with manual refresh button

### Phase J: People & Places UI
1. People grid: circular face thumbnails with name
2. Tap person → see all their photos
3. Places list: location cards with photo count
4. Tap place → see photos from that location
5. Search: by person name, place, date, camera

### Phase K: Auto-Albums & Smart Features
1. Server generates auto-albums: trips, events, favorites
2. "On This Day" memories
3. Duplicate detection surfaced in app
4. Storage stats and cleanup tools

## Performance Targets
- Grid: 60fps, 9,500+ photos, zero network during scroll
- Thumbnail sync: ~6 min for 9,500 photos (10 concurrent)
- Metadata sync: <5 seconds (download one SQLite file)
- Full photo: <3s download from Telegram CDN
- Works on: WiFi, mobile data, airplane mode (after initial sync)
