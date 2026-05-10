import logging
from fastapi import APIRouter, Depends, HTTPException, Query
from fastapi.responses import FileResponse
from sqlalchemy import func, distinct
from sqlalchemy.orm import Session
from db.database import get_db, get_db_ctx
from db.models import Face, Person, Photo

from config import PHOTO_CACHE_DIR
from PIL import Image
from pathlib import Path
import io

logger = logging.getLogger(__name__)
router = APIRouter(tags=["people"])

FACE_THUMB_DIR = PHOTO_CACHE_DIR / "face_thumbs"
FACE_THUMB_DIR.mkdir(parents=True, exist_ok=True)


@router.get("/api/people")
async def list_people(
    page: int = Query(1, ge=1),
    per_page: int = Query(50, ge=1, le=200),
    db: Session = Depends(get_db),
):
    """List all people with face count."""
    total = db.query(func.count(Person.id)).scalar() or 0
    people = (
        db.query(Person)
        .order_by(Person.photo_count.desc())
        .offset((page - 1) * per_page)
        .limit(per_page)
        .all()
    )
    return {
        "people": [p.to_dict() for p in people],
        "page": page,
        "per_page": per_page,
        "total": total,
    }


@router.get("/api/people/{person_id}")
async def get_person(person_id: int, db: Session = Depends(get_db)):
    person = db.query(Person).filter(Person.id == person_id).first()
    if not person:
        raise HTTPException(404, "Person not found")
    face_count = db.query(Face).filter(Face.person_id == person_id).count()
    return {**person.to_dict(), "face_count": face_count}


@router.put("/api/people/{person_id}")
async def rename_person(person_id: int, body: dict, db: Session = Depends(get_db)):
    person = db.query(Person).filter(Person.id == person_id).first()
    if not person:
        raise HTTPException(404, "Person not found")
    person.name = body.get("name", person.name)
    db.commit()
    db.refresh(person)
    return person.to_dict()


@router.post("/api/people/merge")
async def merge_people(body: dict, db: Session = Depends(get_db)):
    """Merge source_id into target_id."""
    source_id = body.get("source_id")
    target_id = body.get("target_id")
    if not source_id or not target_id:
        raise HTTPException(400, "Need source_id and target_id")

    source = db.query(Person).filter(Person.id == source_id).first()
    target = db.query(Person).filter(Person.id == target_id).first()
    if not source or not target:
        raise HTTPException(404, "Person not found")

    db.query(Face).filter(Face.person_id == source_id).update({Face.person_id: target_id})
    target.photo_count = (
        db.query(func.count(distinct(Face.photo_id)))
        .filter(Face.person_id == target_id)
        .scalar()
    )
    db.delete(source)
    db.commit()
    return {"merged": True, "target": target.to_dict()}


@router.get("/api/people/{person_id}/photos")
async def person_photos(
    person_id: int,
    page: int = Query(1, ge=1),
    per_page: int = Query(50, ge=1, le=200),
    db: Session = Depends(get_db),
):
    person = db.query(Person).filter(Person.id == person_id).first()
    if not person:
        raise HTTPException(404, "Person not found")

    photo_ids_q = (
        db.query(distinct(Face.photo_id))
        .filter(Face.person_id == person_id)
    )
    total = photo_ids_q.count()
    photo_ids = [
        r[0] for r in photo_ids_q
        .offset((page - 1) * per_page)
        .limit(per_page)
        .all()
    ]
    photos = db.query(Photo).filter(Photo.id.in_(photo_ids)).all()
    return {
        "photos": [p.to_dict() for p in photos],
        "page": page,
        "per_page": per_page,
        "total": total,
    }


@router.get("/api/people/{person_id}/thumbnail")
async def person_thumbnail(person_id: int, db: Session = Depends(get_db)):
    """Crop the thumbnail face from the original photo."""
    person = db.query(Person).filter(Person.id == person_id).first()
    if not person or not person.thumbnail_face_id:
        raise HTTPException(404, "No thumbnail")

    face = db.query(Face).filter(Face.id == person.thumbnail_face_id).first()
    if not face:
        raise HTTPException(404, "Face not found")

    # Check cached crop
    crop_path = FACE_THUMB_DIR / f"person_{person_id}.jpg"
    if crop_path.exists():
        return FileResponse(str(crop_path), media_type="image/jpeg")

    photo = db.query(Photo).filter(Photo.id == face.photo_id).first()
    if not photo:
        raise HTTPException(404, "Photo not found")

    filename = photo.filename or f"{photo.telegram_file_id}.jpg"
    original = PHOTO_CACHE_DIR / filename
    if not original.exists():
        raise HTTPException(404, "Original not cached")

    try:
        img = Image.open(str(original))
        # Add padding around face
        pad = int(max(face.w, face.h) * 0.3)
        left = max(0, face.x - pad)
        top = max(0, face.y - pad)
        right = min(img.width, face.x + face.w + pad)
        bottom = min(img.height, face.y + face.h + pad)
        crop = img.crop((left, top, right, bottom))
        crop = crop.resize((200, 200))
        crop.save(str(crop_path), "JPEG", quality=85)
        return FileResponse(str(crop_path), media_type="image/jpeg")
    except Exception as e:
        raise HTTPException(500, f"Crop failed: {e}")


@router.get("/api/faces/unassigned")
async def unassigned_faces(
    page: int = Query(1, ge=1),
    per_page: int = Query(50, ge=1, le=200),
    db: Session = Depends(get_db),
):
    total = db.query(func.count(Face.id)).filter(Face.person_id.is_(None)).scalar() or 0
    faces = (
        db.query(Face)
        .filter(Face.person_id.is_(None))
        .offset((page - 1) * per_page)
        .limit(per_page)
        .all()
    )
    return {
        "faces": [
            {"id": f.id, "photo_id": f.photo_id, "x": f.x, "y": f.y, "w": f.w, "h": f.h}
            for f in faces
        ],
        "total": total,
        "page": page,
        "per_page": per_page,
    }


@router.post("/api/faces/cluster")
async def trigger_clustering(db: Session = Depends(get_db)):
    """Manually trigger face clustering."""
    from services.clustering import cluster_faces
    n = cluster_faces()
    return {"status": "done", "people_created": n}
