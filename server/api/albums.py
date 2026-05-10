import logging
from fastapi import APIRouter, Depends, HTTPException, Query
from pydantic import BaseModel
from sqlalchemy import func
from sqlalchemy.orm import Session
from db.database import get_db
from db.models import Photo, Album, AlbumPhoto
from typing import List, Optional

logger = logging.getLogger(__name__)
router = APIRouter(prefix="/api", tags=["albums"])


# --- Favorites ---

@router.post("/favorites/{photo_id}")
async def toggle_favorite(photo_id: int, db: Session = Depends(get_db)):
    photo = db.query(Photo).filter(Photo.id == photo_id).first()
    if not photo:
        raise HTTPException(404, "Photo not found")
    photo.is_favorite = not photo.is_favorite
    db.commit()
    return {"photo_id": photo_id, "is_favorite": photo.is_favorite}


@router.get("/favorites")
async def list_favorites(
    page: int = Query(1, ge=1),
    per_page: int = Query(50, ge=1, le=200),
    db: Session = Depends(get_db),
):
    query = db.query(Photo).filter(Photo.is_favorite == True)
    total = query.count()
    photos = query.order_by(Photo.date_taken.desc().nullslast()).offset((page - 1) * per_page).limit(per_page).all()
    return {"photos": [p.to_dict() for p in photos], "total": total, "page": page}


# --- Albums ---

class AlbumCreate(BaseModel):
    name: str
    description: Optional[str] = None

class PhotoIds(BaseModel):
    photo_ids: List[int]


@router.post("/albums")
async def create_album(data: AlbumCreate, db: Session = Depends(get_db)):
    album = Album(name=data.name, description=data.description)
    db.add(album)
    db.commit()
    db.refresh(album)
    return album.to_dict()


@router.get("/albums")
async def list_albums(db: Session = Depends(get_db)):
    albums = db.query(Album).order_by(Album.created_at.desc()).all()
    return {"albums": [a.to_dict() for a in albums], "total": len(albums)}


@router.get("/albums/{album_id}")
async def get_album(album_id: int, page: int = Query(1, ge=1), per_page: int = Query(50, ge=1, le=200), db: Session = Depends(get_db)):
    album = db.query(Album).filter(Album.id == album_id).first()
    if not album:
        raise HTTPException(404, "Album not found")

    ap_query = db.query(AlbumPhoto).filter(AlbumPhoto.album_id == album_id)
    total = ap_query.count()
    photo_ids = [ap.photo_id for ap in ap_query.order_by(AlbumPhoto.added_at.desc()).offset((page - 1) * per_page).limit(per_page).all()]
    photos = db.query(Photo).filter(Photo.id.in_(photo_ids)).all() if photo_ids else []
    photo_map = {p.id: p for p in photos}
    ordered = [photo_map[pid].to_dict() for pid in photo_ids if pid in photo_map]

    result = album.to_dict()
    result["photos"] = ordered
    result["photos_total"] = total
    result["page"] = page
    return result


@router.post("/albums/{album_id}/photos")
async def add_photos_to_album(album_id: int, data: PhotoIds, db: Session = Depends(get_db)):
    album = db.query(Album).filter(Album.id == album_id).first()
    if not album:
        raise HTTPException(404, "Album not found")

    existing = {ap.photo_id for ap in db.query(AlbumPhoto).filter(AlbumPhoto.album_id == album_id).all()}
    added = 0
    for pid in data.photo_ids:
        if pid not in existing:
            db.add(AlbumPhoto(album_id=album_id, photo_id=pid))
            added += 1

    album.photo_count = db.query(func.count(AlbumPhoto.id)).filter(AlbumPhoto.album_id == album_id).scalar() + added
    if not album.cover_photo_id and data.photo_ids:
        album.cover_photo_id = data.photo_ids[0]
    db.commit()
    return {"album_id": album_id, "added": added, "photo_count": album.photo_count}


@router.delete("/albums/{album_id}/photos/{photo_id}")
async def remove_photo_from_album(album_id: int, photo_id: int, db: Session = Depends(get_db)):
    ap = db.query(AlbumPhoto).filter(AlbumPhoto.album_id == album_id, AlbumPhoto.photo_id == photo_id).first()
    if not ap:
        raise HTTPException(404, "Photo not in album")
    db.delete(ap)

    album = db.query(Album).filter(Album.id == album_id).first()
    if album:
        album.photo_count = max(0, (album.photo_count or 0) - 1)
        if album.cover_photo_id == photo_id:
            album.cover_photo_id = None
    db.commit()
    return {"album_id": album_id, "removed_photo_id": photo_id}
