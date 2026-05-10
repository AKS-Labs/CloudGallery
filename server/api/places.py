import logging
import math
from fastapi import APIRouter, Depends, HTTPException, Query
from sqlalchemy.orm import Session
from db.database import get_db
from db.models import Location, Photo

logger = logging.getLogger(__name__)
router = APIRouter(prefix="/api/places", tags=["places"])


@router.get("")
def list_places(
    limit: int = Query(100, ge=1, le=1000),
    offset: int = Query(0, ge=0),
    db: Session = Depends(get_db),
):
    """List all locations with photo counts."""
    locations = (
        db.query(Location)
        .order_by(Location.photo_count.desc())
        .offset(offset)
        .limit(limit)
        .all()
    )
    total = db.query(Location).count()
    return {
        "total": total,
        "locations": [loc.to_dict() for loc in locations],
    }


@router.get("/map")
def places_map(db: Session = Depends(get_db)):
    """All locations with lat/lon for map view."""
    locations = db.query(Location).filter(Location.photo_count > 0).all()
    return {
        "locations": [
            {
                "id": loc.id,
                "name": loc.name,
                "lat": loc.lat,
                "lon": loc.lon,
                "photo_count": loc.photo_count,
            }
            for loc in locations
        ]
    }


@router.get("/nearby")
def nearby_photos(
    lat: float = Query(...),
    lon: float = Query(...),
    radius: float = Query(10.0, description="Radius in km"),
    limit: int = Query(50, ge=1, le=500),
    db: Session = Depends(get_db),
):
    """Find photos near a point."""
    # Get all photos with GPS, filter by haversine
    photos = db.query(Photo).filter(Photo.gps_lat.isnot(None), Photo.gps_lon.isnot(None)).all()
    nearby = []
    for p in photos:
        dist = _haversine_km(lat, lon, p.gps_lat, p.gps_lon)
        if dist <= radius:
            d = p.to_dict()
            d["distance_km"] = round(dist, 2)
            nearby.append(d)
    nearby.sort(key=lambda x: x["distance_km"])
    return {"photos": nearby[:limit], "total": len(nearby)}


@router.get("/{location_id}")
def get_place(location_id: int, db: Session = Depends(get_db)):
    """Location detail with sample photos."""
    loc = db.query(Location).filter(Location.id == location_id).first()
    if not loc:
        raise HTTPException(404, "Location not found")
    photos = (
        db.query(Photo)
        .filter(Photo.location_id == location_id)
        .order_by(Photo.date_taken.desc())
        .limit(20)
        .all()
    )
    result = loc.to_dict()
    result["photos"] = [p.to_dict() for p in photos]
    return result


@router.get("/{location_id}/photos")
def get_place_photos(
    location_id: int,
    limit: int = Query(50, ge=1, le=500),
    offset: int = Query(0, ge=0),
    db: Session = Depends(get_db),
):
    """All photos at a location."""
    loc = db.query(Location).filter(Location.id == location_id).first()
    if not loc:
        raise HTTPException(404, "Location not found")
    photos = (
        db.query(Photo)
        .filter(Photo.location_id == location_id)
        .order_by(Photo.date_taken.desc())
        .offset(offset)
        .limit(limit)
        .all()
    )
    total = db.query(Photo).filter(Photo.location_id == location_id).count()
    return {
        "location": loc.to_dict(),
        "total": total,
        "photos": [p.to_dict() for p in photos],
    }


def _haversine_km(lat1: float, lon1: float, lat2: float, lon2: float) -> float:
    R = 6371.0
    dlat = math.radians(lat2 - lat1)
    dlon = math.radians(lon2 - lon1)
    a = math.sin(dlat / 2) ** 2 + math.cos(math.radians(lat1)) * math.cos(math.radians(lat2)) * math.sin(dlon / 2) ** 2
    return R * 2 * math.atan2(math.sqrt(a), math.sqrt(1 - a))
