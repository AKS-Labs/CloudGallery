import asyncio
import logging
from pathlib import Path
from db.database import get_db_ctx
from db.models import Photo
from services.telegram import download_photo
from services.exif import extract_exif, generate_thumbnail
from config import PHOTO_CACHE_DIR, THUMBNAIL_DIR, THUMBNAIL_SIZE, INGESTER_INTERVAL_SECONDS

logger = logging.getLogger(__name__)


async def process_photo(photo_id: int):
    """Download, extract EXIF, generate thumbnail for a single photo."""
    with get_db_ctx() as db:
        photo = db.query(Photo).filter(Photo.id == photo_id).first()
        if not photo or photo.processed:
            return

        file_id = photo.telegram_file_id
        filename = photo.filename or f"{file_id}.jpg"
        dest = str(PHOTO_CACHE_DIR / filename)

        try:
            await download_photo(file_id, dest)

            exif = extract_exif(dest)
            photo.width = exif.get("width") or photo.width
            photo.height = exif.get("height") or photo.height
            photo.date_taken = exif.get("date_taken") or photo.date_taken
            photo.gps_lat = exif.get("gps_lat")
            photo.gps_lon = exif.get("gps_lon")
            photo.camera_make = exif.get("camera_make")
            photo.camera_model = exif.get("camera_model")

            # Thumbnail
            thumb_path = str(THUMBNAIL_DIR / f"{photo.id}.jpg")
            generate_thumbnail(dest, thumb_path, THUMBNAIL_SIZE)

            photo.processed = True
            photo.processing_error = None
            logger.info(f"Processed photo {photo.id} ({filename})")

            # Location assignment
            try:
                from services.places import assign_location_to_photo
                assign_location_to_photo(db, photo)
            except Exception as le:
                logger.error(f"Location assignment failed for photo {photo.id}: {le}")

            # Face detection (non-blocking, errors logged and skipped)
            try:
                from services.faces import detect_faces_in_photo
                detect_faces_in_photo(dest, photo.id)
                photo.faces_processed = True
            except (SystemExit, Exception) as fe:
                logger.error(f"Face detection failed for photo {photo.id}: {fe}")

        except Exception as e:
            photo.processing_error = str(e)[:500]
            logger.error(f"Failed to process photo {photo.id}: {e}")


async def run_face_backfill():
    """One-time backfill: run face detection on already-processed photos that haven't had faces scanned."""
    logger.info("Face backfill starting")
    batch_size = 50
    total_done = 0
    while True:
        with get_db_ctx() as db:
            photos = (
                db.query(Photo)
                .filter(Photo.processed == True, Photo.faces_processed == False)
                .limit(batch_size)
                .all()
            )
            if not photos:
                break
            batch_info = [(p.id, p.filename or f"{p.telegram_file_id}.jpg") for p in photos]

        for pid, filename in batch_info:
            dest = str(PHOTO_CACHE_DIR / filename)
            try:
                from services.faces import detect_faces_in_photo
                detect_faces_in_photo(dest, pid)
                with get_db_ctx() as db:
                    p = db.query(Photo).filter(Photo.id == pid).first()
                    if p:
                        p.faces_processed = True
            except (SystemExit, Exception) as e:
                with get_db_ctx() as db:
                    p = db.query(Photo).filter(Photo.id == pid).first()
                    if p:
                        p.faces_processed = True  # mark done to avoid retrying bad images
            total_done += 1
            if total_done % 50 == 0:
                logger.info(f"Face backfill progress: {total_done} photos processed")
            await asyncio.sleep(0.1)

    logger.info(f"Face backfill complete: {total_done} photos")
    if total_done > 0:
        logger.info("Running face clustering...")
        try:
            from services.clustering import cluster_faces
            cluster_faces()
        except Exception as e:
            logger.error(f"Clustering failed: {e}")


async def run_location_backfill():
    """Backfill: assign locations to processed photos that have GPS but no location_id."""
    logger.info("Location backfill starting")
    batch_size = 50
    total_done = 0
    while True:
        with get_db_ctx() as db:
            photos = (
                db.query(Photo)
                .filter(
                    Photo.processed == True,
                    Photo.gps_lat.isnot(None),
                    Photo.gps_lon.isnot(None),
                    Photo.location_id.is_(None),
                )
                .limit(batch_size)
                .all()
            )
            if not photos:
                break
            for photo in photos:
                try:
                    from services.places import assign_location_to_photo
                    assign_location_to_photo(db, photo)
                    total_done += 1
                except Exception as e:
                    logger.error(f"Location backfill failed for photo {photo.id}: {e}")
                if total_done % 50 == 0:
                    logger.info(f"Location backfill progress: {total_done} photos")
    logger.info(f"Location backfill complete: {total_done} photos assigned locations")


async def run_ingester():
    """Background loop that processes unprocessed photos."""
    logger.info("Ingester started")

    # Kick off face backfill for existing photos
    asyncio.create_task(run_face_backfill())

    # Kick off location backfill for existing photos with GPS
    asyncio.create_task(run_location_backfill())

    while True:
        try:
            with get_db_ctx() as db:
                unprocessed = (
                    db.query(Photo)
                    .filter(Photo.processed == False)
                    .limit(10)
                    .all()
                )
                ids = [p.id for p in unprocessed]

            for pid in ids:
                await process_photo(pid)
                await asyncio.sleep(1)  # rate limit

        except Exception as e:
            logger.error(f"Ingester error: {e}")

        await asyncio.sleep(INGESTER_INTERVAL_SECONDS)
