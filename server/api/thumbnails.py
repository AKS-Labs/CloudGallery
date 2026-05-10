import logging
from fastapi import APIRouter, Depends, HTTPException, Query
from fastapi.responses import FileResponse, Response
from sqlalchemy import func
from sqlalchemy.orm import Session
from db.database import get_db
from db.models import Photo
from services.thumbnails import get_thumbnail_path

logger = logging.getLogger(__name__)
router = APIRouter(tags=["thumbnails"])

# 1x1 transparent JPEG placeholder
_PLACEHOLDER = (
    b"\xff\xd8\xff\xe0\x00\x10JFIF\x00\x01\x01\x00\x00\x01\x00\x01\x00\x00"
    b"\xff\xdb\x00C\x00\x08\x06\x06\x07\x06\x05\x08\x07\x07\x07\t\t"
    b"\x08\n\x0c\x14\r\x0c\x0b\x0b\x0c\x19\x12\x13\x0f\x14\x1d\x1a"
    b"\x1f\x1e\x1d\x1a\x1c\x1c $.\' \",#\x1c\x1c(7),01444\x1f\'9=82<.342"
    b"\xff\xc0\x00\x0b\x08\x00\x01\x00\x01\x01\x01\x11\x00"
    b"\xff\xc4\x00\x1f\x00\x00\x01\x05\x01\x01\x01\x01\x01\x01\x00\x00"
    b"\x00\x00\x00\x00\x00\x00\x01\x02\x03\x04\x05\x06\x07\x08\t\n\x0b"
    b"\xff\xc4\x00\xb5\x10\x00\x02\x01\x03\x03\x02\x04\x03\x05\x05\x04"
    b"\x04\x00\x00\x01}\x01\x02\x03\x00\x04\x11\x05\x12!1A\x06\x13Qa\x07"
    b"\x22q\x142\x81\x91\xa1\x08#B\xb1\xc1\x15R\xd1\xf0$3br\x82\t\n\x16"
    b"\x17\x18\x19\x1a%&\'()*456789:CDEFGHIJSTUVWXYZcdefghijstuvwxyz"
    b"\x83\x84\x85\x86\x87\x88\x89\x8a\x92\x93\x94\x95\x96\x97\x98\x99"
    b"\x9a\xa2\xa3\xa4\xa5\xa6\xa7\xa8\xa9\xaa\xb2\xb3\xb4\xb5\xb6\xb7"
    b"\xb8\xb9\xba\xc2\xc3\xc4\xc5\xc6\xc7\xc8\xc9\xca\xd2\xd3\xd4\xd5"
    b"\xd6\xd7\xd8\xd9\xda\xe1\xe2\xe3\xe4\xe5\xe6\xe7\xe8\xe9\xea\xf1"
    b"\xf2\xf3\xf4\xf5\xf6\xf7\xf8\xf9\xfa"
    b"\xff\xda\x00\x08\x01\x01\x00\x00?\x00T\xdb\x9e\xa3\x13\xa1\xff\xd9"
)


@router.get("/api/photos/{photo_id}/thumb")
async def get_thumb(
    photo_id: int,
    size: int = Query(150, description="150 for grid, 800 for preview"),
    db: Session = Depends(get_db),
):
    """Serve cached thumbnail with cache headers."""
    if size not in (150, 800):
        raise HTTPException(400, "size must be 150 or 800")

    photo = db.query(Photo).filter(Photo.id == photo_id).first()
    if not photo:
        raise HTTPException(404, "Photo not found")

    path = get_thumbnail_path(photo.telegram_file_id, size)
    if path:
        return FileResponse(
            str(path),
            media_type="image/jpeg",
            headers={"Cache-Control": "public, max-age=86400"},
        )

    # Not ready yet — return placeholder
    return Response(
        content=_PLACEHOLDER,
        media_type="image/jpeg",
        status_code=202,
        headers={"Cache-Control": "no-cache"},
    )


@router.get("/api/thumbnails/status")
async def thumbnail_status(db: Session = Depends(get_db)):
    total = db.query(func.count(Photo.id)).scalar() or 0
    done = db.query(func.count(Photo.id)).filter(Photo.thumbnail_status == "done").scalar() or 0
    pending = db.query(func.count(Photo.id)).filter(Photo.thumbnail_status.in_(["pending", None])).scalar() or 0
    errors = db.query(func.count(Photo.id)).filter(Photo.thumbnail_status == "error").scalar() or 0
    processing = db.query(func.count(Photo.id)).filter(Photo.thumbnail_status == "processing").scalar() or 0
    return {
        "total": total,
        "done": done,
        "pending": pending,
        "processing": processing,
        "errors": errors,
        "percent": round(done / total * 100, 1) if total else 0,
    }


@router.post("/api/thumbnails/generate")
async def trigger_generate():
    """Trigger a batch manually (worker handles it automatically)."""
    import asyncio
    from workers.thumbnail_worker import process_batch
    count = await process_batch()
    return {"processed": count}
