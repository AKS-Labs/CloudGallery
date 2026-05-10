import logging
import time
import math
from geopy.geocoders import Nominatim
from geopy.exc import GeocoderTimedOut, GeocoderServiceError
from sqlalchemy.orm import Session
from db.models import Location, Photo

logger = logging.getLogger(__name__)

# Rate limit: track last geocode time
_last_geocode_time = 0.0

geolocator = Nominatim(user_agent="cloudgallery-server/1.0", timeout=10)


def _haversine_km(lat1: float, lon1: float, lat2: float, lon2: float) -> float:
    """Calculate distance between two points in km."""
    R = 6371.0
    dlat = math.radians(lat2 - lat1)
    dlon = math.radians(lon2 - lon1)
    a = math.sin(dlat / 2) ** 2 + math.cos(math.radians(lat1)) * math.cos(math.radians(lat2)) * math.sin(dlon / 2) ** 2
    return R * 2 * math.atan2(math.sqrt(a), math.sqrt(1 - a))


def _rate_limited_geocode(lat: float, lon: float) -> dict | None:
    """Reverse geocode with 1 req/sec rate limit."""
    global _last_geocode_time
    elapsed = time.time() - _last_geocode_time
    if elapsed < 1.0:
        time.sleep(1.0 - elapsed)

    try:
        _last_geocode_time = time.time()
        location = geolocator.reverse(f"{lat}, {lon}", exactly_one=True, language="en")
        if not location:
            return None
        addr = location.raw.get("address", {})
        city = addr.get("city") or addr.get("town") or addr.get("village") or addr.get("hamlet")
        state = addr.get("state")
        country = addr.get("country")

        # Build a nice name
        parts = [p for p in [city, state] if p]
        name = ", ".join(parts) if parts else (country or f"{lat:.4f}, {lon:.4f}")

        return {"name": name, "city": city, "state": state, "country": country}
    except (GeocoderTimedOut, GeocoderServiceError) as e:
        logger.warning(f"Geocoding failed for ({lat}, {lon}): {e}")
        return None
    except Exception as e:
        logger.error(f"Unexpected geocoding error for ({lat}, {lon}): {e}")
        return None


def find_or_create_location(db: Session, lat: float, lon: float, cluster_radius_km: float = 1.0) -> Location | None:
    """Find an existing location within cluster_radius_km, or create a new one via reverse geocoding."""
    # Check existing locations
    locations = db.query(Location).all()
    for loc in locations:
        if _haversine_km(lat, lon, loc.lat, loc.lon) <= cluster_radius_km:
            return loc

    # Reverse geocode
    geo = _rate_limited_geocode(lat, lon)
    if not geo:
        # Still create a location with coords only
        geo = {"name": f"{lat:.4f}, {lon:.4f}", "city": None, "state": None, "country": None}

    loc = Location(
        name=geo["name"],
        city=geo["city"],
        state=geo["state"],
        country=geo["country"],
        lat=lat,
        lon=lon,
        radius_km=cluster_radius_km,
        photo_count=0,
    )
    db.add(loc)
    db.flush()  # get ID
    return loc


def assign_location_to_photo(db: Session, photo: Photo) -> Location | None:
    """If photo has GPS coords, find/create location and link it."""
    if not photo.gps_lat or not photo.gps_lon:
        return None

    loc = find_or_create_location(db, photo.gps_lat, photo.gps_lon)
    if loc:
        photo.location_id = loc.id
        loc.photo_count = db.query(Photo).filter(Photo.location_id == loc.id).count()
    return loc
