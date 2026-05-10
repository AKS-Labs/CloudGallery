# CloudGallery V2 — Amazon Photos-Like Experience

## Vision

Transform CloudGallery from a simple Telegram backup tool into a smart photo gallery with organized views (timeline, people, places, years), intelligent search, and featured photos — powered by a laptop server that acts as the "brain" for ML processing.

**Core Principle:** The phone app works independently for backup (existing functionality). The laptop server *enhances* it with smart features. No server = still a working backup app. Server connected = Amazon Photos-like experience.

---

## 1. Architecture Overview

```
┌──────────────────┐         ┌─────────────────────────┐
│   Android App    │◄──REST──►│    Laptop Server        │
│  (CloudGallery)  │         │  (Python FastAPI)        │
│                  │         │                          │
│  • Photo backup  │         │  • EXIF extraction       │
│  • Gallery UI    │         │  • Face detection        │
│  • Offline-first │         │  • Location geocoding    │
│  • Room DB       │         │  • CLIP embeddings       │
│                  │         │  • Aesthetic scoring     │
│                  │         │  • SQLite/PostgreSQL     │
└────────┬─────────┘         └────────┬────────────────┘
         │                            │
         │     ┌──────────────┐       │
         └────►│  Telegram    │◄──────┘
               │  Channel     │
               │  (storage)   │
               └──────────────┘
```

**Data flow:**
1. App uploads photos to Telegram (existing) and notifies server of new uploads
2. Server downloads photos from Telegram via Bot API, extracts metadata (EXIF, faces, CLIP embeddings)
3. Server stores enriched metadata in its database
4. App fetches organized metadata from server (people, places, timeline, search results)
5. App caches server metadata locally for offline access

---

## 2. Laptop Server

### 2.1 Why Python FastAPI

| Factor | FastAPI (Python) | Ktor (Kotlin) |
|--------|-----------------|---------------|
| ML ecosystem | ✅ Native (face_recognition, CLIP, PIL) | ❌ JVM wrappers, painful |
| EXIF parsing | ✅ Pillow, exifread | ⚠️ metadata-extractor works but verbose |
| Dev speed | ✅ Rapid prototyping | ⚠️ More boilerplate |
| Same language as app | ❌ | ✅ |
| Async support | ✅ Native async/await | ✅ Coroutines |

**Decision: Python FastAPI.** The ML ecosystem advantage is decisive. Face recognition, CLIP, and image processing libraries are Python-first. The server is a separate concern from the app.

### 2.2 Server Structure

```
cloudgallery-server/
├── main.py                 # FastAPI app entry point
├── config.py               # Settings (Telegram token, DB path, etc.)
├── requirements.txt
├── db/
│   ├── models.py           # SQLAlchemy models
│   ├── database.py         # DB connection/session
│   └── migrations/         # Alembic migrations
├── services/
│   ├── telegram.py         # Telegram Bot API client (pyrogram or python-telegram-bot)
│   ├── exif.py             # EXIF extraction (Pillow + exifread)
│   ├── faces.py            # Face detection & recognition (InsightFace)
│   ├── places.py           # Reverse geocoding (geopy + Nominatim)
│   ├── clip.py             # CLIP embeddings for search
│   ├── aesthetics.py       # Photo quality scoring
│   └── processor.py        # Orchestrates all processing for a photo
├── api/
│   ├── photos.py           # /api/photos endpoints
│   ├── people.py           # /api/people endpoints
│   ├── places.py           # /api/places endpoints
│   ├── search.py           # /api/search endpoints
│   ├── sync.py             # /api/sync endpoints
│   └── featured.py         # /api/featured endpoints
└── workers/
    ├── ingester.py          # Background photo processing queue
    └── scheduler.py         # Periodic tasks (featured photos, re-processing)
```

### 2.3 Telegram Access Strategy

The server needs to **read channel history** — something the Bot API can't do (as documented in PLAN.md Bug 1 analysis). Two options:

**Option A: Pyrogram (MTProto) — Recommended**
- Full access to channel message history via `get_chat_history()`
- Can download any file by `file_id`
- Needs a user account session (not just bot token)
- One-time interactive login, then session file persists

**Option B: Telethon**
- Same MTProto capabilities as Pyrogram
- Slightly different API style
- Equally viable

**Decision: Pyrogram.** Better docs, active maintenance, async-native.

```python
# Server connects to Telegram via Pyrogram
from pyrogram import Client

app = Client(
    "cloudgallery_server",
    api_id=API_ID,        # from my.telegram.org
    api_hash=API_HASH,
    # First run: interactive phone login
    # After: uses session file automatically
)

async def get_all_photos(channel_id: int):
    async for message in app.get_chat_history(channel_id):
        if message.document or message.photo:
            yield message
```

**Bonus:** This also fixes Bug 1 from PLAN.md — the server becomes the authoritative source for channel contents, eliminating the broken `getUpdates()` approach entirely.

### 2.4 Running as a Service

```bash
# systemd service: /etc/systemd/system/cloudgallery-server.service
[Unit]
Description=CloudGallery Server
After=network.target

[Service]
User=aj
WorkingDirectory=/home/aj/Project/cloudgallery-server
ExecStart=/home/aj/Project/cloudgallery-server/.venv/bin/uvicorn main:app --host 0.0.0.0 --port 8100
Restart=always
Environment=PYTHONUNBUFFERED=1

[Install]
WantedBy=multi-user.target
```

**Connectivity:** Use Tailscale for phone ↔ laptop. AJ already uses Tailscale, so the phone can reach the server at its Tailscale IP regardless of network. No mDNS or port forwarding needed.

Server port: **8100** (avoid conflicts with existing services).

---

## 3. Database Schema (Server-Side)

**Engine: SQLite** for Phase 1-3 (simple, zero config, sufficient for personal use). Migrate to PostgreSQL + pgvector only if CLIP vector search performance demands it.

```sql
-- Core photo record (server's enriched view of each photo)
CREATE TABLE photos (
    id              INTEGER PRIMARY KEY AUTOINCREMENT,
    telegram_file_id TEXT NOT NULL UNIQUE,  -- maps to RemotePhoto.remoteId
    telegram_msg_id INTEGER,                -- message ID in channel
    filename        TEXT,
    mime_type       TEXT,
    file_size       INTEGER,
    width           INTEGER,
    height          INTEGER,

    -- EXIF metadata
    date_taken      DATETIME,               -- from EXIF DateTimeOriginal
    date_uploaded   DATETIME NOT NULL,
    gps_lat         REAL,
    gps_lon         REAL,
    camera_make     TEXT,
    camera_model    TEXT,
    orientation     INTEGER,

    -- Processing state
    exif_extracted  BOOLEAN DEFAULT FALSE,
    faces_detected  BOOLEAN DEFAULT FALSE,
    clip_embedded   BOOLEAN DEFAULT FALSE,
    aesthetic_scored BOOLEAN DEFAULT FALSE,
    processed_at    DATETIME,

    -- Derived
    location_id     INTEGER REFERENCES locations(id),
    aesthetic_score REAL,                    -- 0.0 to 1.0
    is_favorite     BOOLEAN DEFAULT FALSE,

    created_at      DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_at      DATETIME DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_photos_date_taken ON photos(date_taken);
CREATE INDEX idx_photos_location ON photos(location_id);
CREATE INDEX idx_photos_aesthetic ON photos(aesthetic_score DESC);

-- Face detections
CREATE TABLE faces (
    id          INTEGER PRIMARY KEY AUTOINCREMENT,
    photo_id    INTEGER NOT NULL REFERENCES photos(id) ON DELETE CASCADE,
    x           REAL NOT NULL,  -- bounding box (normalized 0-1)
    y           REAL NOT NULL,
    w           REAL NOT NULL,
    h           REAL NOT NULL,
    confidence  REAL,
    encoding    BLOB,           -- face embedding vector (512-dim float32)
    person_id   INTEGER REFERENCES people(id),
    created_at  DATETIME DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_faces_photo ON faces(photo_id);
CREATE INDEX idx_faces_person ON faces(person_id);

-- Named people (user-labeled)
CREATE TABLE people (
    id              INTEGER PRIMARY KEY AUTOINCREMENT,
    name            TEXT NOT NULL,
    thumbnail_face_id INTEGER REFERENCES faces(id),
    photo_count     INTEGER DEFAULT 0,
    created_at      DATETIME DEFAULT CURRENT_TIMESTAMP
);

-- Clustered but unnamed face groups (before user labels them)
CREATE TABLE face_clusters (
    id              INTEGER PRIMARY KEY AUTOINCREMENT,
    representative_face_id INTEGER REFERENCES faces(id),
    person_id       INTEGER REFERENCES people(id),  -- NULL until user labels
    face_count      INTEGER DEFAULT 0,
    created_at      DATETIME DEFAULT CURRENT_TIMESTAMP
);

-- Named locations (reverse-geocoded clusters)
CREATE TABLE locations (
    id          INTEGER PRIMARY KEY AUTOINCREMENT,
    name        TEXT NOT NULL,           -- "Austin, TX" or "Kathmandu, Nepal"
    city        TEXT,
    state       TEXT,
    country     TEXT,
    lat         REAL NOT NULL,
    lon         REAL NOT NULL,
    radius_km   REAL DEFAULT 5.0,        -- clustering radius
    photo_count INTEGER DEFAULT 0,
    created_at  DATETIME DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_locations_coords ON locations(lat, lon);

-- Albums (auto-generated and manual)
CREATE TABLE albums (
    id              INTEGER PRIMARY KEY AUTOINCREMENT,
    name            TEXT NOT NULL,
    type            TEXT NOT NULL CHECK(type IN ('auto', 'manual', 'person', 'location', 'year', 'featured')),
    cover_photo_id  INTEGER REFERENCES photos(id),
    photo_count     INTEGER DEFAULT 0,
    created_at      DATETIME DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE album_photos (
    album_id    INTEGER NOT NULL REFERENCES albums(id) ON DELETE CASCADE,
    photo_id    INTEGER NOT NULL REFERENCES photos(id) ON DELETE CASCADE,
    position    INTEGER,
    PRIMARY KEY (album_id, photo_id)
);

-- CLIP text/image embeddings for semantic search
CREATE TABLE embeddings (
    id          INTEGER PRIMARY KEY AUTOINCREMENT,
    photo_id    INTEGER NOT NULL UNIQUE REFERENCES photos(id) ON DELETE CASCADE,
    vector      BLOB NOT NULL            -- CLIP embedding (512-dim float32)
);

-- ML-generated tags
CREATE TABLE tags (
    id          INTEGER PRIMARY KEY AUTOINCREMENT,
    photo_id    INTEGER NOT NULL REFERENCES photos(id) ON DELETE CASCADE,
    tag         TEXT NOT NULL,
    confidence  REAL,
    source      TEXT DEFAULT 'clip'      -- 'clip', 'manual', 'exif'
);

CREATE INDEX idx_tags_photo ON tags(photo_id);
CREATE INDEX idx_tags_tag ON tags(tag);

-- Server sync state (tracks what the app has fetched)
CREATE TABLE sync_cursors (
    client_id   TEXT PRIMARY KEY,         -- app instance identifier
    last_sync   DATETIME,
    last_photo_id INTEGER
);
```

### Vector Search Strategy

For CLIP semantic search with SQLite, use **sqlite-vss** (SQLite vector search extension) or compute similarity in Python:

```python
# Simple approach: load all embeddings, compute cosine similarity in numpy
# Works fine for <100K photos (personal collection)
import numpy as np

def search(query_embedding, all_embeddings, top_k=20):
    similarities = np.dot(all_embeddings, query_embedding)
    top_indices = np.argsort(similarities)[-top_k:][::-1]
    return top_indices
```

If performance becomes an issue (>50K photos), switch to **PostgreSQL + pgvector** or **ChromaDB**.

---

## 4. REST API Design

Base URL: `http://<tailscale-ip>:8100/api/v1`

### 4.1 Sync & Discovery

```
POST   /sync/notify          # App notifies server of new uploads
GET    /sync/status           # Server processing status
POST   /sync/full-scan        # Trigger full channel re-scan
GET    /sync/changes?since=<timestamp>  # Get changes since last sync
```

**Sync notify payload:**
```json
{
  "photos": [
    {
      "telegram_file_id": "BQACAgIAAxkB...",
      "message_id": 12345,
      "filename": "IMG_20250510.jpg",
      "file_size": 4500000,
      "uploaded_at": "2025-05-10T14:00:00Z"
    }
  ]
}
```

### 4.2 Timeline

```
GET    /photos/timeline                    # Grouped by date (paginated)
GET    /photos/timeline/{year}             # All months in a year
GET    /photos/timeline/{year}/{month}     # All days in a month
GET    /photos/timeline/{year}/{month}/{day}  # All photos on a day
GET    /photos/on-this-day                 # Photos from today's date in previous years
```

**Timeline response:**
```json
{
  "groups": [
    {
      "date": "2025-05-10",
      "count": 15,
      "photos": [
        {
          "id": 1,
          "telegram_file_id": "...",
          "thumbnail_url": "/api/v1/photos/1/thumbnail",
          "date_taken": "2025-05-10T14:30:00",
          "location": "Austin, TX",
          "has_faces": true
        }
      ]
    }
  ],
  "next_cursor": "2025-05-09"
}
```

### 4.3 People

```
GET    /people                             # All named people + unnamed clusters
GET    /people/{id}/photos                 # Photos of a person
POST   /people/{cluster_id}/name           # Name a face cluster
POST   /people/{id}/merge/{other_id}       # Merge two people
DELETE /people/{id}/faces/{face_id}         # Remove misidentified face
```

### 4.4 Places

```
GET    /places                             # All location groups
GET    /places/{id}/photos                 # Photos at a location
GET    /places/map                         # All photo coordinates for map view
GET    /places/near?lat=X&lon=Y&radius=10  # Photos near a point
```

### 4.5 Search

```
GET    /search?q=sunset+beach              # Semantic search (CLIP)
GET    /search?person=3&location=5&year=2024  # Filtered search
GET    /search/tags?q=dog                  # Tag-based search
```

### 4.6 Featured

```
GET    /featured/today                     # Today's featured photos
GET    /featured/week                      # This week's highlights
GET    /featured/memories                  # "On This Day" + best-of compilations
```

### 4.7 Photos

```
GET    /photos/{id}                        # Full photo metadata
GET    /photos/{id}/thumbnail              # Server-generated thumbnail (cached)
GET    /photos/{id}/faces                  # Detected faces in photo
GET    /photos/{id}/similar               # Visually similar photos (CLIP)
POST   /photos/{id}/favorite              # Toggle favorite
```

### 4.8 Auth

Simple bearer token auth (single user, personal server):

```python
# config.py
API_TOKEN = "cg-server-secret-token-here"

# middleware
@app.middleware("http")
async def auth(request, call_next):
    if request.url.path.startswith("/api/"):
        token = request.headers.get("Authorization", "").replace("Bearer ", "")
        if token != settings.API_TOKEN:
            return JSONResponse(status_code=401, content={"error": "unauthorized"})
    return await call_next(request)
```

---

## 5. Photo Organization Features

### 5.1 Timeline / "This Day"

**How it works:**
1. Server extracts `DateTimeOriginal` from EXIF via Pillow
2. Falls back to `DateTime`, then file modification time, then upload time
3. Photos grouped into year → month → day hierarchy
4. "On This Day" queries: `WHERE strftime('%m-%d', date_taken) = strftime('%m-%d', 'now')`

**EXIF extraction:**
```python
from PIL import Image
from PIL.ExifTags import TAGS, GPSTAGS
import exifread

def extract_exif(file_path: str) -> dict:
    img = Image.open(file_path)
    exif_data = img._getexif() or {}

    result = {}
    for tag_id, value in exif_data.items():
        tag = TAGS.get(tag_id, tag_id)
        if tag == "DateTimeOriginal":
            result["date_taken"] = parse_exif_date(value)
        elif tag == "GPSInfo":
            result["gps"] = parse_gps(value)
        elif tag == "Make":
            result["camera_make"] = value
        elif tag == "Model":
            result["camera_model"] = value
    return result
```

### 5.2 People (Face Recognition)

**Pipeline:**
1. **Detection:** InsightFace `buffalo_l` model detects faces + generates 512-dim embeddings
2. **Clustering:** DBSCAN or Chinese Whispers on face embeddings to group similar faces
3. **User labeling:** App shows unnamed clusters → user taps to name → creates `person`
4. **Incremental:** New photos processed → embeddings compared to known people → auto-assigned if confidence > 0.6

**Why InsightFace over face_recognition:**
- InsightFace is more accurate (ArcFace architecture)
- Better with diverse faces
- GPU-accelerated (can offload to W7900 if needed)
- `face_recognition` uses dlib which is CPU-only and less accurate

```python
import insightface
from insightface.app import FaceAnalysis

face_app = FaceAnalysis(name='buffalo_l', providers=['CPUExecutionProvider'])
face_app.prepare(ctx_id=0, det_size=(640, 640))

def detect_faces(image_path: str) -> list[dict]:
    img = cv2.imread(image_path)
    faces = face_app.get(img)
    return [
        {
            "bbox": face.bbox.tolist(),      # [x1, y1, x2, y2]
            "confidence": float(face.det_score),
            "embedding": face.embedding.tobytes(),  # 512-dim float32
            "age": face.age,
            "gender": "M" if face.gender == 1 else "F",
        }
        for face in faces
    ]
```

**Clustering (initial grouping before user labels):**
```python
from sklearn.cluster import DBSCAN
import numpy as np

def cluster_faces(embeddings: list[np.ndarray], eps=0.5, min_samples=3):
    X = np.array(embeddings)
    clustering = DBSCAN(eps=eps, min_samples=min_samples, metric='cosine')
    labels = clustering.fit_predict(X)
    return labels  # -1 = noise/singleton, 0+ = cluster ID
```

### 5.3 Places

**Pipeline:**
1. Extract GPS from EXIF (lat/lon)
2. Cluster nearby coordinates (within ~5km radius) using simple distance grouping
3. Reverse geocode cluster centroids via Nominatim (free, no API key)
4. Cache geocoded names in `locations` table

```python
from geopy.geocoders import Nominatim
from geopy.distance import geodesic

geocoder = Nominatim(user_agent="cloudgallery-server")

def reverse_geocode(lat: float, lon: float) -> dict:
    location = geocoder.reverse(f"{lat}, {lon}", language="en")
    address = location.raw.get("address", {})
    return {
        "name": f"{address.get('city', address.get('town', 'Unknown'))}, {address.get('country', '')}",
        "city": address.get("city") or address.get("town"),
        "state": address.get("state"),
        "country": address.get("country"),
    }

def cluster_locations(photos_with_gps: list, radius_km=5.0) -> list:
    """Simple greedy clustering: assign each photo to nearest existing cluster or create new."""
    clusters = []
    for photo in photos_with_gps:
        point = (photo.gps_lat, photo.gps_lon)
        assigned = False
        for cluster in clusters:
            if geodesic(point, cluster["centroid"]).km <= radius_km:
                cluster["photos"].append(photo)
                # Update centroid
                assigned = True
                break
        if not assigned:
            clusters.append({"centroid": point, "photos": [photo]})
    return clusters
```

**Rate limiting for Nominatim:** max 1 request/second, cache aggressively. Most photos from the same location hit cache.

### 5.4 Years

Simple `GROUP BY strftime('%Y', date_taken)` query. Each year gets:
- Total photo count
- Cover photo (highest aesthetic score from that year)
- Monthly breakdown chart data

### 5.5 Featured Photos

**Aesthetic scoring** using NIMA (Neural Image Assessment) or a simpler approach:

```python
import cv2
import numpy as np

def score_photo(image_path: str) -> float:
    """Quick heuristic scoring (0-1). Replace with NIMA for better results."""
    img = cv2.imread(image_path)
    scores = []

    # Sharpness (Laplacian variance)
    gray = cv2.cvtColor(img, cv2.COLOR_BGR2GRAY)
    sharpness = cv2.Laplacian(gray, cv2.CV_64F).var()
    scores.append(min(sharpness / 500.0, 1.0))

    # Colorfulness
    (B, G, R) = cv2.split(img.astype("float"))
    rg = np.absolute(R - G)
    yb = np.absolute(0.5 * (R + G) - B)
    colorfulness = np.sqrt(rg.mean()**2 + yb.mean()**2) + 0.3 * np.sqrt(rg.std()**2 + yb.std()**2)
    scores.append(min(colorfulness / 100.0, 1.0))

    # Has faces (bonus)
    # Already known from face detection step

    # Resolution (higher = better, up to a point)
    h, w = img.shape[:2]
    megapixels = (h * w) / 1_000_000
    scores.append(min(megapixels / 12.0, 1.0))

    return np.mean(scores)
```

**Featured selection:**
- **Daily:** Top 5 photos uploaded today by aesthetic score
- **Weekly:** Top 10 from the week
- **Memories:** "On This Day" photos from previous years, ranked by score
- **Best Of:** Yearly highlights — top 20 per year

### 5.6 Search (CLIP Semantic Search)

```python
import clip
import torch
from PIL import Image

model, preprocess = clip.load("ViT-B/32", device="cpu")
# Use GPU on W7900: device="cuda" or "rocm"

def embed_image(image_path: str) -> np.ndarray:
    image = preprocess(Image.open(image_path)).unsqueeze(0)
    with torch.no_grad():
        embedding = model.encode_image(image)
    return embedding.numpy().flatten()

def embed_text(query: str) -> np.ndarray:
    text = clip.tokenize([query])
    with torch.no_grad():
        embedding = model.encode_text(text)
    return embedding.numpy().flatten()

def search_photos(query: str, all_embeddings: np.ndarray, top_k=20):
    query_emb = embed_text(query)
    # Normalize
    query_emb /= np.linalg.norm(query_emb)
    all_embeddings /= np.linalg.norm(all_embeddings, axis=1, keepdims=True)
    similarities = all_embeddings @ query_emb
    top_indices = np.argsort(similarities)[-top_k:][::-1]
    return top_indices, similarities[top_indices]
```

**Search supports:**
- Natural language: "sunset at the beach", "birthday party", "dog playing"
- Combined with filters: person, location, date range
- Tag search: exact match on ML-generated tags

---

## 6. Server-Phone Communication

### 6.1 Discovery

**Tailscale** — AJ's laptop and phone are both on Tailscale. The server is reachable at its Tailscale IP (e.g., `100.x.y.z:8100`). Configure once in app settings.

```
App Settings:
  Server URL: http://100.x.y.z:8100
  Server Token: cg-server-secret-token-here
```

Fallback for local network: mDNS (`_cloudgallery._tcp`) for automatic discovery when both devices are on the same WiFi.

### 6.2 Sync Protocol

```
┌─────────┐                          ┌──────────┐
│  Phone   │                          │  Server  │
└────┬─────┘                          └────┬─────┘
     │  POST /sync/notify                  │
     │  {new uploads since last sync}      │
     │────────────────────────────────────►│
     │                                     │  ← Server queues processing
     │                                     │
     │  GET /sync/changes?since=T          │
     │────────────────────────────────────►│
     │  {processed metadata, new faces,    │
     │   locations, tags since T}          │
     │◄────────────────────────────────────│
     │                                     │
     │  (App caches metadata locally)      │
     │                                     │
```

**Offline behavior:**
- App works fully without server (backup/restore still works via Telegram)
- Server metadata cached in Room DB on the phone
- When server becomes reachable, delta sync catches up
- Phone periodically attempts connection (every 15 min via WorkManager)

### 6.3 Thumbnail Strategy

Server generates and caches thumbnails (300px) for fast gallery loading:
- Stored on server filesystem: `thumbnails/{photo_id}.webp`
- Served via `/api/v1/photos/{id}/thumbnail`
- App caches thumbnails in Glide/Coil disk cache
- Much faster than downloading from Telegram every time

---

## 7. App Changes

### 7.1 New Bottom Navigation

```
┌─────────────────────────────────────────┐
│                                         │
│           [Photo Content Area]          │
│                                         │
├─────────┬────────┬────────┬────────────┤
│ 📷      │ 👥     │ 📍     │ 🔍        │
│ Photos  │ People │ Places │ Search     │
└─────────┴────────┴────────┴────────────┘
```

Replace the current tab layout with a bottom nav bar (Material 3 `NavigationBar`):
- **Photos** — Timeline view with year/month headers (replaces current grid)
- **People** — Face groups with named/unnamed sections
- **Places** — Location clusters with map toggle
- **Search** — Semantic search + filters

### 7.2 New Screens

| Screen | Description |
|--------|-------------|
| `TimelineScreen` | Photos grouped by date with sticky year/month headers |
| `OnThisDayScreen` | Carousel of photos from today's date in past years |
| `PeopleScreen` | Grid of face thumbnails, tap to see all photos of person |
| `PersonDetailScreen` | Photos of a specific person, option to rename |
| `PlacesScreen` | Location cards with photo counts, map view toggle |
| `PlaceDetailScreen` | Photos from a specific location |
| `SearchScreen` | Text input + results grid + filter chips |
| `YearsScreen` | Year cards with cover photo and count |
| `FeaturedScreen` | Curated highlights, "On This Day", best-of |
| `ServerSettingsScreen` | Server URL, token, connection status, sync controls |

### 7.3 New Data Layer

```kotlin
// New module: data/server/

// Retrofit API client
interface CloudGalleryServerApi {
    @POST("sync/notify")
    suspend fun notifyUploads(@Body uploads: SyncNotifyRequest): SyncNotifyResponse

    @GET("sync/changes")
    suspend fun getChanges(@Query("since") since: String): SyncChangesResponse

    @GET("photos/timeline")
    suspend fun getTimeline(@Query("cursor") cursor: String?): TimelineResponse

    @GET("people")
    suspend fun getPeople(): PeopleResponse

    @GET("people/{id}/photos")
    suspend fun getPersonPhotos(@Path("id") id: Int): PhotoListResponse

    @GET("places")
    suspend fun getPlaces(): PlacesResponse

    @GET("search")
    suspend fun search(@Query("q") query: String): SearchResponse

    @GET("featured/today")
    suspend fun getFeatured(): FeaturedResponse

    @GET("photos/{id}/thumbnail")
    suspend fun getThumbnail(@Path("id") id: Int): ResponseBody
}

// New Room entities for cached server data
@Entity(tableName = "server_people")
data class ServerPerson(
    @PrimaryKey val serverId: Int,
    val name: String,
    val photoCount: Int,
    val thumbnailUrl: String?,
    val lastSynced: Long
)

@Entity(tableName = "server_locations")
data class ServerLocation(
    @PrimaryKey val serverId: Int,
    val name: String,
    val lat: Double,
    val lon: Double,
    val photoCount: Int,
    val lastSynced: Long
)

@Entity(tableName = "server_photo_metadata")
data class ServerPhotoMetadata(
    @PrimaryKey val telegramFileId: String,  // links to RemotePhoto.remoteId
    val dateTaken: Long?,
    val locationId: Int?,
    val locationName: String?,
    val hasFaces: Boolean,
    val aestheticScore: Float?,
    val clipEmbedded: Boolean,
    val lastSynced: Long
)
```

### 7.4 Room DB Migration

New tables added to `WhDatabase` (v7 → v8):
- `server_people`
- `server_locations`
- `server_photo_metadata`
- `server_sync_state` (last sync timestamp, server URL)

---

## 8. ML Processing Pipeline

### 8.1 Photo Processing Flow (Server)

```python
async def process_photo(photo_record):
    """Full processing pipeline for one photo."""
    # 1. Download from Telegram
    file_path = await telegram.download_file(photo_record.telegram_file_id)

    # 2. EXIF extraction (~1ms)
    exif = extract_exif(file_path)
    update_photo_metadata(photo_record.id, exif)

    # 3. Face detection (~200ms CPU, ~50ms GPU)
    faces = detect_faces(file_path)
    for face in faces:
        save_face(photo_record.id, face)
        # Try to match to known person
        person = match_face_to_person(face["embedding"])
        if person:
            assign_face_to_person(face_id, person.id)

    # 4. Location geocoding (~100ms, cached)
    if exif.get("gps"):
        location = get_or_create_location(exif["gps"])
        assign_photo_to_location(photo_record.id, location.id)

    # 5. CLIP embedding (~500ms CPU, ~100ms GPU)
    embedding = embed_image(file_path)
    save_embedding(photo_record.id, embedding)

    # 6. Aesthetic scoring (~100ms)
    score = score_photo(file_path)
    update_aesthetic_score(photo_record.id, score)

    # 7. Generate thumbnail
    generate_thumbnail(file_path, photo_record.id)

    # 8. Cleanup
    os.remove(file_path)
```

### 8.2 Performance Estimates

| Operation | CPU Time | GPU Time (W7900) | Per 1000 Photos |
|-----------|----------|-------------------|-----------------|
| EXIF extraction | 1ms | N/A | 1 sec |
| Face detection (InsightFace) | 200ms | 50ms | 3 min / 50 sec |
| CLIP embedding | 500ms | 100ms | 8 min / 100 sec |
| Aesthetic scoring | 100ms | 30ms | 100 sec / 30 sec |
| Reverse geocoding | 100ms (cached) | N/A | ~2 min (mostly cached) |
| Thumbnail generation | 50ms | N/A | 50 sec |
| **Total per photo** | **~950ms** | **~330ms** | **~16 min / ~5 min** |

For AJ's collection (estimated 5-20K photos), initial processing: **1-5 hours on laptop CPU, or 30-90 min on W7900 GPU.**

### 8.3 GPU Offloading to W7900

For the initial bulk processing, offload to the W7900 machine (48GB VRAM):

```python
# config.py
GPU_SERVER = "http://192.168.1.185:8100"  # or run processing directly on W7900
USE_GPU = True

# InsightFace with ROCm
face_app = FaceAnalysis(name='buffalo_l', providers=['ROCMExecutionProvider'])

# CLIP with ROCm PyTorch
device = "cuda"  # ROCm maps to cuda in PyTorch
model, preprocess = clip.load("ViT-B/32", device=device)
```

After initial processing, incremental processing (new uploads) is fast enough on the laptop CPU.

---

## 9. Implementation Phases

### Phase 1: Server Foundation + Timeline (2-3 weeks)

**Goal:** Server running, EXIF extraction working, timeline view in app.

**Server tasks:**
- [ ] Set up FastAPI project with SQLite
- [ ] Pyrogram integration — connect to Telegram, scan channel history
- [ ] EXIF extraction service (date, GPS, camera info)
- [ ] Photo ingestion pipeline (download → extract EXIF → store metadata → cleanup)
- [ ] Timeline API endpoints (`/photos/timeline`, `/photos/on-this-day`)
- [ ] Thumbnail generation and serving
- [ ] Systemd service + Tailscale connectivity
- [ ] Simple bearer token auth

**App tasks:**
- [ ] Server settings screen (URL, token, test connection)
- [ ] Retrofit client for server API
- [ ] `SyncWorker` — periodic sync with server
- [ ] Replace photo grid with `TimelineScreen` (grouped by date)
- [ ] `OnThisDayScreen` with photo carousel
- [ ] Room DB migration for server metadata cache

**Deliverable:** App shows photos organized by date with "On This Day" feature.

### Phase 2: People & Faces (2-3 weeks)

**Goal:** Face detection, clustering, and user labeling.

**Server tasks:**
- [ ] InsightFace integration — detect faces, generate embeddings
- [ ] DBSCAN clustering for face grouping
- [ ] People API endpoints
- [ ] Face-to-person matching for new photos
- [ ] Merge/split people endpoints

**App tasks:**
- [ ] `PeopleScreen` — grid of face clusters
- [ ] `PersonDetailScreen` — all photos of a person
- [ ] Name/rename person dialog
- [ ] Bottom nav bar with People tab
- [ ] Cache people data in Room

**Deliverable:** App shows people albums, user can name faces.

### Phase 3: Places & Map (1-2 weeks)

**Goal:** Location-based organization with map view.

**Server tasks:**
- [ ] GPS extraction from EXIF (already done in Phase 1, just need clustering)
- [ ] Location clustering algorithm
- [ ] Reverse geocoding via Nominatim
- [ ] Places API endpoints

**App tasks:**
- [ ] `PlacesScreen` — location cards with counts
- [ ] `PlaceDetailScreen` — photos at a location
- [ ] Map view (Google Maps or OSM) showing photo locations
- [ ] Bottom nav Places tab

**Deliverable:** Photos grouped by location with map view.

### Phase 4: Search & Tags (2 weeks)

**Goal:** Semantic search with CLIP, tag-based filtering.

**Server tasks:**
- [ ] CLIP model integration — image embeddings
- [ ] Text-to-image search endpoint
- [ ] Auto-tagging from CLIP (top-k labels per photo)
- [ ] Combined search (text + filters: person, place, date)

**App tasks:**
- [ ] `SearchScreen` — text input with results grid
- [ ] Filter chips (person, location, date range)
- [ ] Search history / suggestions
- [ ] Bottom nav Search tab

**Deliverable:** User can search "birthday cake" or "mountains" and find matching photos.

### Phase 5: Featured & Polish (1-2 weeks)

**Goal:** Smart highlights, aesthetic scoring, year view.

**Server tasks:**
- [ ] Aesthetic scoring model (NIMA or heuristic)
- [ ] Featured photo selection algorithm
- [ ] Memories/highlights generation
- [ ] Years summary endpoint

**App tasks:**
- [ ] `FeaturedScreen` — daily/weekly highlights
- [ ] `YearsScreen` — year cards with best photo
- [ ] Memories notifications (optional)
- [ ] Polish all screens, transitions, loading states

**Deliverable:** Full Amazon Photos-like experience.

---

## 10. Tech Stack Summary

| Component | Technology | Why |
|-----------|-----------|-----|
| Server framework | **Python FastAPI** | Best ML ecosystem, async, fast |
| Telegram access | **Pyrogram** | MTProto = full channel history access |
| Server DB | **SQLite** (→ PostgreSQL later) | Zero config, sufficient for personal scale |
| Face detection | **InsightFace (buffalo_l)** | State-of-art accuracy, GPU support |
| Semantic search | **OpenAI CLIP (ViT-B/32)** | Text-to-image search, zero-shot |
| EXIF parsing | **Pillow + exifread** | Comprehensive EXIF/GPS extraction |
| Geocoding | **geopy + Nominatim** | Free, no API key, good enough |
| Aesthetic scoring | **Custom heuristic** (→ NIMA later) | Simple, no extra model weight |
| Thumbnail format | **WebP** | Small files, good quality |
| Phone↔Server | **Tailscale** | Already in use, works everywhere |
| Server hosting | **AJ's EliteBook** (→ W7900 for bulk ML) | Already available, free |
| App HTTP client | **Retrofit + OkHttp** | Standard for Android |
| App image loading | **Coil** (or existing Glide) | Kotlin-first, Compose-native |

---

## 11. Risks & Mitigations

| Risk | Impact | Mitigation |
|------|--------|------------|
| Pyrogram needs user login (not just bot) | Setup friction | One-time interactive setup, session persists |
| InsightFace slow on CPU | Long initial processing | Offload to W7900 GPU for bulk, CPU fine for incremental |
| CLIP model is 400MB+ | Disk/memory | Load on demand, unload after batch processing |
| Nominatim rate limit (1 req/sec) | Slow geocoding | Aggressive caching, batch after clustering |
| Telegram download rate limits | Slow initial scan | Throttle downloads, process over hours/overnight |
| Laptop not always on | Server unavailable | App works fully offline, syncs when server reachable |
| SQLite vector search perf at scale | Slow search >50K photos | Migrate to pgvector or ChromaDB if needed |

---

## 12. Relationship to Existing PLAN.md Bugs

This V2 plan **supersedes** some fixes from PLAN.md:

- **Bug 1 (DB Sync):** Fully resolved — server uses Pyrogram for channel history, becomes authoritative metadata source
- **Bug 2 (Upload Stops):** Still relevant — app upload pipeline fixes are independent of server
- **Bug 3 (Slow Uploads):** Still relevant — parallel upload fix is independent of server

**Recommendation:** Fix Bugs 2 & 3 from PLAN.md first (they're app-only changes), then start Phase 1 of this plan.

---

## 13. Quick Start (Phase 1 Bootstrap)

```bash
# On AJ's laptop
mkdir -p ~/Project/cloudgallery-server && cd $_
python3 -m venv .venv && source .venv/bin/activate

pip install fastapi uvicorn pyrogram tgcrypto pillow exifread sqlalchemy aiosqlite

# Create config
cat > config.py << 'EOF'
TELEGRAM_API_ID = 12345          # from my.telegram.org
TELEGRAM_API_HASH = "abc123..."  # from my.telegram.org
TELEGRAM_CHANNEL_ID = -100...    # CloudGallery channel
API_TOKEN = "cg-$(openssl rand -hex 16)"
DB_PATH = "cloudgallery.db"
THUMBNAIL_DIR = "thumbnails"
SERVER_PORT = 8100
EOF

# First run: Pyrogram will prompt for phone number login
python main.py
```

---

*This plan turns CloudGallery from a backup tool into a smart photo gallery. The server does the heavy lifting; the app stays lightweight. Ship Phase 1 first — timeline alone is a huge UX upgrade.*
