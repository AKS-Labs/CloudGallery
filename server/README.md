# CloudGallery Server — Phase 1

EXIF extraction + Timeline API backend for CloudGallery.

## Setup

```bash
cd server
python -m venv .venv
source .venv/bin/activate
pip install -r requirements.txt
```

## Configure

Edit `.env` with your bot token and chat ID (already pre-filled).

## Run

```bash
python main.py
```

Server starts on `http://0.0.0.0:8100`

## API Endpoints

| Method | Path | Description |
|--------|------|-------------|
| GET | `/` | Health check |
| POST | `/api/sync/notify` | Notify server of new upload |
| POST | `/api/sync/import-db` | Bulk import from backup JSON |
| GET | `/api/timeline` | Photos grouped by date |
| GET | `/api/timeline/on-this-day` | Photos from this day in past years |
| GET | `/api/photos` | Paginated photo list |
| GET | `/api/photos/{id}` | Single photo detail |
| GET | `/api/photos/{id}/thumbnail` | 200x200 thumbnail |
| GET | `/api/photos/stats` | Server statistics |

## Import existing data

```bash
# Convert your backup JSON to the expected format:
curl -X POST http://localhost:8100/api/sync/import-db \
  -H "Content-Type: application/json" \
  -d '{"photos": [{"telegram_file_id": "...", "filename": "...", ...}]}'
```
