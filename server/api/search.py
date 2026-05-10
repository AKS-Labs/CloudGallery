import logging
from fastapi import APIRouter, Depends, HTTPException, Query
from sqlalchemy import or_, and_
from sqlalchemy.orm import Session
from db.database import get_db
from db.models import Photo, Location
from datetime import datetime

logger = logging.getLogger(__name__)
router = APIRouter(prefix="/api/search", tags=["search"])


@router.get("")
async def search_photos(
    q: str = Query(..., min_length=1),
    page: int = Query(1, ge=1),
    per_page: int = Query(50, ge=1, le=200),
    db: Session = Depends(get_db),
):
    """Search photos by filename, camera info, or location name."""
    pattern = f"%{q}%"
    # Get location IDs matching query
    loc_ids = [
        lid for (lid,) in db.query(Location.id).filter(
            or_(
                Location.name.ilike(pattern),
                Location.city.ilike(pattern),
                Location.state.ilike(pattern),
                Location.country.ilike(pattern),
            )
        ).all()
    ]

    filters = [
        Photo.filename.ilike(pattern),
        Photo.camera_make.ilike(pattern),
        Photo.camera_model.ilike(pattern),
    ]
    if loc_ids:
        filters.append(Photo.location_id.in_(loc_ids))

    query = db.query(Photo).filter(or_(*filters))
    total = query.count()
    photos = query.order_by(Photo.date_taken.desc().nullslast()).offset((page - 1) * per_page).limit(per_page).all()

    return {"photos": [p.to_dict() for p in photos], "total": total, "query": q, "page": page}


@router.get("/date")
async def search_by_date(
    db: Session = Depends(get_db),
    date_from: str = Query(None, alias="from"),
    date_to: str = Query(None, alias="to"),
    page: int = Query(1, ge=1),
    per_page: int = Query(50, ge=1, le=200),
):
    """Search photos by date range."""
    query = db.query(Photo).filter(Photo.date_taken.isnot(None))
    try:
        if date_from:
            query = query.filter(Photo.date_taken >= datetime.fromisoformat(date_from))
        if date_to:
            query = query.filter(Photo.date_taken <= datetime.fromisoformat(date_to + "T23:59:59") if len(date_to) == 10 else Photo.date_taken <= datetime.fromisoformat(date_to))
    except ValueError:
        raise HTTPException(400, "Invalid date format. Use YYYY-MM-DD")

    total = query.count()
    photos = query.order_by(Photo.date_taken.desc()).offset((page - 1) * per_page).limit(per_page).all()
    return {"photos": [p.to_dict() for p in photos], "total": total, "page": page}


@router.get("/similar/{photo_id}")
async def find_similar(photo_id: int, limit: int = Query(10, ge=1, le=50), db: Session = Depends(get_db)):
    """Find visually similar photos by metadata (same camera, similar dimensions, close date)."""
    photo = db.query(Photo).filter(Photo.id == photo_id).first()
    if not photo:
        raise HTTPException(404, "Photo not found")

    filters = [Photo.id != photo_id]
    # Same camera
    if photo.camera_make and photo.camera_model:
        filters.append(and_(Photo.camera_make == photo.camera_make, Photo.camera_model == photo.camera_model))
    # Similar dimensions (within 10%)
    if photo.width and photo.height:
        filters.append(Photo.width.between(int(photo.width * 0.9), int(photo.width * 1.1)))
        filters.append(Photo.height.between(int(photo.height * 0.9), int(photo.height * 1.1)))
    # Same location
    if photo.location_id:
        filters.append(Photo.location_id == photo.location_id)

    similar = db.query(Photo).filter(and_(*filters)).limit(limit).all()
    return {"photo_id": photo_id, "similar": [p.to_dict() for p in similar], "count": len(similar)}
