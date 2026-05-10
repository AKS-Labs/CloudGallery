import logging
from datetime import datetime
from fastapi import APIRouter, Depends
from pydantic import BaseModel
from sqlalchemy.orm import Session
from db.database import get_db
from db.models import Photo

logger = logging.getLogger(__name__)
router = APIRouter(prefix="/api/sync", tags=["sync"])


class NotifyRequest(BaseModel):
    telegram_file_id: str
    filename: str | None = None
    file_size: int | None = None
    telegram_message_id: int | None = None
    mime_type: str | None = None


class ImportItem(BaseModel):
    telegram_file_id: str | None = None
    file_id: str | None = None  # alias from app backup
    remoteId: str | None = None  # from CloudGallery backup JSON
    localId: str | None = None
    pathUri: str | None = None
    photoType: str | None = None
    filename: str | None = None
    file_size: int | None = None
    telegram_message_id: int | None = None
    message_id: int | None = None
    mime_type: str | None = None
    width: int | None = None
    height: int | None = None
    date_uploaded: str | None = None
    timestamp: int | None = None


class ImportRequest(BaseModel):
    photos: list[ImportItem] = []
    remotePhotos: list[ImportItem] = []


@router.post("/notify")
async def sync_notify(req: NotifyRequest, db: Session = Depends(get_db)):
    """App calls this when a new photo is uploaded to Telegram."""
    existing = db.query(Photo).filter(Photo.telegram_file_id == req.telegram_file_id).first()
    if existing:
        return {"status": "exists", "id": existing.id}

    photo = Photo(
        telegram_file_id=req.telegram_file_id,
        telegram_message_id=req.telegram_message_id,
        filename=req.filename,
        file_size=req.file_size,
        mime_type=req.mime_type,
        date_uploaded=datetime.utcnow(),
        processed=False,
    )
    db.add(photo)
    db.commit()
    db.refresh(photo)
    logger.info(f"Queued photo {photo.id} for processing")
    return {"status": "queued", "id": photo.id}


@router.post("/import-db")
async def import_db(req: ImportRequest, db: Session = Depends(get_db)):
    """Bulk import from CloudGallery backup JSON."""
    added = 0
    skipped = 0

    all_items = req.photos + req.remotePhotos
    for item in all_items:
        fid = item.telegram_file_id or item.file_id or item.remoteId
        if not fid:
            skipped += 1
            continue

        existing = db.query(Photo).filter(Photo.telegram_file_id == fid).first()
        if existing:
            skipped += 1
            continue

        date_up = None
        if item.date_uploaded:
            try:
                date_up = datetime.fromisoformat(item.date_uploaded)
            except (ValueError, TypeError):
                pass
        if not date_up and item.timestamp:
            try:
                date_up = datetime.utcfromtimestamp(item.timestamp / 1000)
            except (ValueError, TypeError, OSError):
                pass

        photo = Photo(
            telegram_file_id=fid,
            telegram_message_id=item.telegram_message_id or item.message_id,
            filename=item.filename,
            file_size=item.file_size,
            mime_type=item.mime_type,
            width=item.width,
            height=item.height,
            date_uploaded=date_up or datetime.utcnow(),
            processed=False,
        )
        db.add(photo)
        added += 1

    db.commit()
    logger.info(f"Imported {added} photos, skipped {skipped}")
    return {"status": "ok", "added": added, "skipped": skipped}
