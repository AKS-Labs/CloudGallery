import logging
from pathlib import Path
from PIL import Image
from services.telegram import download_photo
from config import THUMBNAIL_DIR

logger = logging.getLogger(__name__)

SIZES = {150: 70, 800: 80}  # size -> jpeg quality


def _thumb_path(file_id: str, size: int) -> Path:
    return THUMBNAIL_DIR / f"{file_id}_{size}.jpg"


def has_thumbnail(file_id: str, size: int = 150) -> bool:
    return _thumb_path(file_id, size).exists()


def get_thumbnail_path(file_id: str, size: int = 150) -> Path | None:
    p = _thumb_path(file_id, size)
    return p if p.exists() else None


def generate_thumbnails_from_file(source_path: str, file_id: str) -> dict[int, str]:
    """Generate 150 and 800 thumbnails from a local image file. Returns {size: path}."""
    results = {}
    try:
        img = Image.open(source_path)
        img = img.convert("RGB")
    except Exception as e:
        logger.error(f"Cannot open image {source_path}: {e}")
        raise

    for size, quality in SIZES.items():
        out = _thumb_path(file_id, size)
        if out.exists():
            results[size] = str(out)
            continue
        thumb = img.copy()
        thumb.thumbnail((size, size), Image.LANCZOS)
        thumb.save(str(out), "JPEG", quality=quality)
        results[size] = str(out)

    return results


async def generate_thumbnails(file_id: str, temp_dir: str = "/tmp") -> dict[int, str]:
    """Download from Telegram and generate both thumbnail sizes."""
    import os
    tmp_path = os.path.join(temp_dir, f"thumb_src_{file_id}.jpg")
    try:
        await download_photo(file_id, tmp_path)
        result = generate_thumbnails_from_file(tmp_path, file_id)
        return result
    finally:
        try:
            os.unlink(tmp_path)
        except OSError:
            pass
