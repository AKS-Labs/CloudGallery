"""
Phase H: Metadata DB generator + Telegram push.
Generates a standalone SQLite metadata.db and uploads it to Telegram.
"""

import logging
import sqlite3
import time
from datetime import datetime, timezone
from pathlib import Path

import requests
from sqlalchemy import func

from config import BOT_TOKEN, CHAT_ID, DB_PATH
from db.database import get_db_ctx
from db.models import Photo, Person, Face, Location, Album, AlbumPhoto

logger = logging.getLogger(__name__)

METADATA_DB_PATH = Path("/data/metadata.db") if Path("/data").exists() else Path("./metadata.db")

# Generation state
_status = {
    "state": "idle",  # idle | generating | uploading | done | error
    "last_generated": None,
    "last_error": None,
    "stats": {},
}


def get_status() -> dict:
    return dict(_status)


def generate_metadata_db() -> Path:
    """Generate standalone metadata.db from the main CloudGallery database."""
    _status["state"] = "generating"
    _status["last_error"] = None

    try:
        db_path = METADATA_DB_PATH
        db_path.parent.mkdir(parents=True, exist_ok=True)
        # Remove old file
        if db_path.exists():
            db_path.unlink()

        conn = sqlite3.connect(str(db_path))
        c = conn.cursor()

        # Create tables
        c.executescript("""
            CREATE TABLE photo_metadata (
                remote_id TEXT PRIMARY KEY,
                date_taken TEXT,
                camera_make TEXT,
                camera_model TEXT,
                width INTEGER,
                height INTEGER,
                file_size INTEGER,
                lat REAL,
                lon REAL,
                place_name TEXT,
                place_city TEXT,
                place_country TEXT,
                person_ids TEXT,
                thumbnail_status TEXT
            );
            CREATE TABLE people (
                id INTEGER PRIMARY KEY,
                name TEXT,
                photo_count INTEGER,
                face_sample_remote_id TEXT
            );
            CREATE TABLE places (
                id INTEGER PRIMARY KEY,
                name TEXT,
                city TEXT,
                state TEXT,
                country TEXT,
                lat REAL,
                lon REAL,
                photo_count INTEGER
            );
            CREATE TABLE albums (
                id INTEGER PRIMARY KEY,
                name TEXT,
                description TEXT,
                photo_ids TEXT,
                photo_count INTEGER
            );
            CREATE TABLE meta (
                key TEXT PRIMARY KEY,
                value TEXT
            );
        """)

        with get_db_ctx() as db:
            # Photos
            photos = db.query(Photo).all()
            total_photos = len(photos)

            # Build person_ids lookup: photo_id -> [person_id, ...]
            faces = db.query(Face).filter(Face.person_id.isnot(None)).all()
            photo_person_map: dict[int, set[int]] = {}
            for f in faces:
                photo_person_map.setdefault(f.photo_id, set()).add(f.person_id)

            # Location lookup
            locations = {loc.id: loc for loc in db.query(Location).all()}

            for p in photos:
                loc = locations.get(p.location_id)
                person_ids = ",".join(str(pid) for pid in sorted(photo_person_map.get(p.id, [])))
                c.execute(
                    "INSERT INTO photo_metadata VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)",
                    (
                        p.telegram_file_id,
                        p.date_taken.isoformat() if p.date_taken else None,
                        p.camera_make,
                        p.camera_model,
                        p.width,
                        p.height,
                        p.file_size,
                        p.gps_lat,
                        p.gps_lon,
                        loc.name if loc else None,
                        loc.city if loc else None,
                        loc.country if loc else None,
                        person_ids or None,
                        p.thumbnail_status,
                    ),
                )

            # People
            people = db.query(Person).all()
            for person in people:
                # Get a sample face's photo remote_id
                sample_face = db.query(Face).filter(Face.person_id == person.id).first()
                sample_remote_id = None
                if sample_face:
                    sample_photo = db.query(Photo).filter(Photo.id == sample_face.photo_id).first()
                    if sample_photo:
                        sample_remote_id = sample_photo.telegram_file_id
                c.execute(
                    "INSERT INTO people VALUES (?,?,?,?)",
                    (person.id, person.name, person.photo_count, sample_remote_id),
                )

            # Places
            for loc in locations.values():
                c.execute(
                    "INSERT INTO places VALUES (?,?,?,?,?,?,?,?)",
                    (loc.id, loc.name, loc.city, loc.state, loc.country, loc.lat, loc.lon, loc.photo_count),
                )

            # Albums
            albums = db.query(Album).all()
            for album in albums:
                album_photo_ids = (
                    db.query(Photo.telegram_file_id)
                    .join(AlbumPhoto, AlbumPhoto.photo_id == Photo.id)
                    .filter(AlbumPhoto.album_id == album.id)
                    .all()
                )
                photo_ids_str = ",".join(r[0] for r in album_photo_ids if r[0])
                c.execute(
                    "INSERT INTO albums VALUES (?,?,?,?,?)",
                    (album.id, album.name, album.description, photo_ids_str or None, album.photo_count),
                )

            total_people = len(people)
            total_places = len(locations)

        # Meta
        now = datetime.now(timezone.utc).isoformat()
        c.execute("INSERT INTO meta VALUES ('version', '1')")
        c.execute("INSERT INTO meta VALUES ('generated_at', ?)", (now,))
        c.execute("INSERT INTO meta VALUES ('total_photos', ?)", (str(total_photos),))
        c.execute("INSERT INTO meta VALUES ('total_people', ?)", (str(total_people),))
        c.execute("INSERT INTO meta VALUES ('total_places', ?)", (str(total_places),))

        conn.commit()
        conn.close()

        _status["stats"] = {
            "total_photos": total_photos,
            "total_people": total_people,
            "total_places": total_places,
        }
        _status["last_generated"] = now
        logger.info(f"Metadata DB generated: {total_photos} photos, {total_people} people, {total_places} places")
        return db_path

    except Exception as e:
        _status["state"] = "error"
        _status["last_error"] = str(e)
        logger.exception("Failed to generate metadata DB")
        raise


def upload_to_telegram(db_path: Path) -> dict:
    """Upload metadata.db to Telegram channel and pin it."""
    _status["state"] = "uploading"
    
    channel_id = CHAT_ID
    if not BOT_TOKEN or not channel_id:
        raise ValueError("BOT_TOKEN or CHAT_ID not configured")

    stats = _status["stats"]
    caption = (
        f"#cloudgallery_metadata_v1\n"
        f"Generated: {_status['last_generated']}\n"
        f"Photos: {stats.get('total_photos', 0)}\n"
        f"People: {stats.get('total_people', 0)}\n"
        f"Places: {stats.get('total_places', 0)}"
    )

    url = f"https://api.telegram.org/bot{BOT_TOKEN}/sendDocument"
    with open(db_path, "rb") as f:
        resp = requests.post(
            url,
            data={"chat_id": channel_id, "caption": caption},
            files={"document": ("metadata.db", f, "application/x-sqlite3")},
            timeout=60,
        )

    if not resp.ok:
        raise RuntimeError(f"Telegram upload failed: {resp.status_code} {resp.text}")

    result = resp.json()["result"]
    message_id = result["message_id"]

    # Pin the message
    pin_resp = requests.post(
        f"https://api.telegram.org/bot{BOT_TOKEN}/pinChatMessage",
        data={"chat_id": channel_id, "message_id": message_id, "disable_notification": True},
        timeout=30,
    )
    pinned = pin_resp.ok

    _status["state"] = "done"
    logger.info(f"Metadata DB uploaded to Telegram (msg {message_id}, pinned={pinned})")
    return {"message_id": message_id, "pinned": pinned}


def generate_and_push() -> dict:
    """Full pipeline: generate metadata DB then upload to Telegram."""
    try:
        db_path = generate_metadata_db()
        result = upload_to_telegram(db_path)
        return {"status": "ok", **result, **_status["stats"]}
    except Exception as e:
        _status["state"] = "error"
        _status["last_error"] = str(e)
        return {"status": "error", "error": str(e)}
