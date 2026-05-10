import logging
import os
from pathlib import Path
from fastapi import APIRouter, Depends, HTTPException, Query
from fastapi.responses import FileResponse
from sqlalchemy import func
from sqlalchemy.orm import Session
from db.database import get_db
from db.models import Photo, Album
from services.exif import generate_thumbnail
from services.duplicates import find_duplicates
from config import PHOTO_CACHE_DIR, THUMBNAIL_DIR, THUMBNAIL_SIZE

logger = logging.getLogger(__name__)
router = APIRouter(prefix="/api/photos", tags=["photos"])


@router.get("")
async def list_photos(
    page: int = Query(1, ge=1),
    per_page: int = Query(50, ge=1, le=200),
    db: Session = Depends(get_db),
):
    """Paginated photo list."""
    total = db.query(func.count(Photo.id)).scalar() or 0
    photos = (
        db.query(Photo)
        .order_by(Photo.date_uploaded.desc())
        .offset((page - 1) * per_page)
        .limit(per_page)
        .all()
    )
    return {
        "photos": [p.to_dict() for p in photos],
        "page": page,
        "per_page": per_page,
        "total": total,
    }


@router.get("/stats", name="photo_stats")
async def stats(db: Session = Depends(get_db)):
    """Server stats."""
    total = db.query(func.count(Photo.id)).scalar() or 0
    processed = db.query(func.count(Photo.id)).filter(Photo.processed == True).scalar() or 0
    errors = db.query(func.count(Photo.id)).filter(Photo.processing_error.isnot(None)).scalar() or 0

    # Storage used
    cache_size = sum(f.stat().st_size for f in PHOTO_CACHE_DIR.rglob("*") if f.is_file())

    favorites = db.query(func.count(Photo.id)).filter(Photo.is_favorite == True).scalar() or 0
    album_count = db.query(func.count(Album.id)).scalar() or 0

    # Photos by month
    month_rows = (
        db.query(func.strftime("%Y-%m", Photo.date_taken), func.count(Photo.id))
        .filter(Photo.date_taken.isnot(None))
        .group_by(func.strftime("%Y-%m", Photo.date_taken))
        .order_by(func.strftime("%Y-%m", Photo.date_taken).desc())
        .all()
    )
    by_month = {m: c for m, c in month_rows} if month_rows else {}

    # Storage by type
    images = db.query(func.count(Photo.id)).filter(Photo.mime_type.like("image/%")).scalar() or 0
    videos = db.query(func.count(Photo.id)).filter(Photo.mime_type.like("video/%")).scalar() or 0

    return {
        "total_photos": total,
        "processed": processed,
        "unprocessed": total - processed,
        "errors": errors,
        "favorites": favorites,
        "albums": album_count,
        "by_month": by_month,
        "by_type": {"images": images, "videos": videos},
        "storage_bytes": cache_size,
        "storage_mb": round(cache_size / (1024 * 1024), 2),
    }


@router.get("/duplicates")
async def get_duplicates(db: Session = Depends(get_db)):
    """Find potential duplicate photos."""
    groups = find_duplicates(db)
    return {"duplicate_groups": groups, "total_groups": len(groups)}


@router.get("/{photo_id}")
async def get_photo(photo_id: int, db: Session = Depends(get_db)):
    """Single photo detail."""
    photo = db.query(Photo).filter(Photo.id == photo_id).first()
    if not photo:
        raise HTTPException(status_code=404, detail="Photo not found")
    return photo.to_dict()


@router.get("/{photo_id}/thumbnail")
async def get_thumbnail(photo_id: int, db: Session = Depends(get_db)):
    """Returns 200x200 thumbnail, generating on first request."""
    photo = db.query(Photo).filter(Photo.id == photo_id).first()
    if not photo:
        raise HTTPException(status_code=404, detail="Photo not found")

    thumb_path = THUMBNAIL_DIR / f"{photo_id}.jpg"
    if thumb_path.exists():
        return FileResponse(str(thumb_path), media_type="image/jpeg")

    # Try to generate from cached original
    filename = photo.filename or f"{photo.telegram_file_id}.jpg"
    original = PHOTO_CACHE_DIR / filename
    if not original.exists():
        raise HTTPException(status_code=404, detail="Original not cached yet; wait for processing")

    generate_thumbnail(str(original), str(thumb_path), THUMBNAIL_SIZE)
    return FileResponse(str(thumb_path), media_type="image/jpeg")
