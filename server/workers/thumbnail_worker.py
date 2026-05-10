import asyncio
import logging
import time
from db.database import get_db_ctx
from db.models import Photo
from services.thumbnails import generate_thumbnails, has_thumbnail
from config import PHOTO_CACHE_DIR

logger = logging.getLogger(__name__)

BATCH_SIZE = 50
RATE_LIMIT_DELAY = 1.0 / 25  # 25 calls/sec max


async def process_batch() -> int:
    """Process one batch. Returns count processed."""
    with get_db_ctx() as db:
        photos = (
            db.query(Photo)
            .filter(Photo.thumbnail_status.in_(["pending", None]))
            .limit(BATCH_SIZE)
            .all()
        )
        if not photos:
            return 0
        batch = [(p.id, p.telegram_file_id, p.filename) for p in photos]
        for p in photos:
            p.thumbnail_status = "processing"

    done = 0
    for pid, file_id, filename in batch:
        # Check if we can use local cached file instead of downloading
        local_path = None
        if filename:
            candidate = PHOTO_CACHE_DIR / filename
            if candidate.exists():
                local_path = str(candidate)
        if not local_path:
            candidate = PHOTO_CACHE_DIR / f"{file_id}.jpg"
            if candidate.exists():
                local_path = str(candidate)

        try:
            if local_path:
                from services.thumbnails import generate_thumbnails_from_file
                generate_thumbnails_from_file(local_path, file_id)
            else:
                await generate_thumbnails(file_id)
                await asyncio.sleep(RATE_LIMIT_DELAY)

            with get_db_ctx() as db:
                p = db.query(Photo).filter(Photo.id == pid).first()
                if p:
                    p.thumbnail_status = "done"
                    p.thumbnail_error = None
            done += 1
        except Exception as e:
            with get_db_ctx() as db:
                p = db.query(Photo).filter(Photo.id == pid).first()
                if p:
                    p.thumbnail_status = "error"
                    p.thumbnail_error = str(e)[:500]
            logger.error(f"Thumbnail failed for photo {pid}: {e}")

    return done


async def run_thumbnail_worker():
    """Background worker that continuously generates thumbnails."""
    logger.info("Thumbnail worker started")
    total_done = 0
    start = time.time()

    while True:
        try:
            count = await process_batch()
            if count == 0:
                await asyncio.sleep(30)  # idle wait
                continue

            total_done += count
            if total_done % 100 == 0 or (total_done < 100 and total_done % 20 == 0):
                elapsed = time.time() - start
                rate = total_done / elapsed if elapsed > 0 else 0
                logger.info(f"Thumbnail progress: {total_done} done ({rate:.1f}/sec)")

        except Exception as e:
            logger.error(f"Thumbnail worker error: {e}")
            await asyncio.sleep(10)
