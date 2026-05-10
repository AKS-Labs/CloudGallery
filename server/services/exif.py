import logging
from pathlib import Path
from PIL import Image
from PIL.ExifTags import TAGS, GPSTAGS
from datetime import datetime

logger = logging.getLogger(__name__)


def _dms_to_decimal(dms, ref: str) -> float | None:
    """Convert EXIF GPS DMS tuple to decimal degrees."""
    try:
        d, m, s = [float(x) for x in dms]
        decimal = d + m / 60.0 + s / 3600.0
        if ref in ("S", "W"):
            decimal = -decimal
        return decimal
    except Exception:
        return None


def extract_exif(file_path: str) -> dict:
    """Extract EXIF metadata from an image file."""
    result = {
        "date_taken": None,
        "gps_lat": None,
        "gps_lon": None,
        "camera_make": None,
        "camera_model": None,
        "width": None,
        "height": None,
    }

    try:
        img = Image.open(file_path)
        result["width"] = img.width
        result["height"] = img.height

        exif_data = img._getexif()
        if not exif_data:
            return result

        decoded = {TAGS.get(k, k): v for k, v in exif_data.items()}

        # Date taken
        for field in ("DateTimeOriginal", "DateTimeDigitized", "DateTime"):
            if field in decoded and decoded[field]:
                try:
                    result["date_taken"] = datetime.strptime(
                        str(decoded[field]), "%Y:%m:%d %H:%M:%S"
                    )
                    break
                except (ValueError, TypeError):
                    continue

        # Camera info
        result["camera_make"] = str(decoded.get("Make", "")).strip() or None
        result["camera_model"] = str(decoded.get("Model", "")).strip() or None

        # GPS
        gps_info = decoded.get("GPSInfo")
        if gps_info and isinstance(gps_info, dict):
            gps_decoded = {GPSTAGS.get(k, k): v for k, v in gps_info.items()}
            lat = gps_decoded.get("GPSLatitude")
            lat_ref = gps_decoded.get("GPSLatitudeRef", "N")
            lon = gps_decoded.get("GPSLongitude")
            lon_ref = gps_decoded.get("GPSLongitudeRef", "E")
            if lat:
                result["gps_lat"] = _dms_to_decimal(lat, lat_ref)
            if lon:
                result["gps_lon"] = _dms_to_decimal(lon, lon_ref)

    except Exception as e:
        logger.warning(f"EXIF extraction failed for {file_path}: {e}")

    return result


def generate_thumbnail(file_path: str, thumb_path: str, size: tuple[int, int] = (200, 200)) -> str:
    """Generate a thumbnail. Returns the thumbnail path."""
    img = Image.open(file_path)
    img.thumbnail(size, Image.LANCZOS)
    img.save(thumb_path, "JPEG", quality=80)
    return thumb_path
