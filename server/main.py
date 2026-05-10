import asyncio
import logging
from contextlib import asynccontextmanager
from fastapi import FastAPI
from fastapi.staticfiles import StaticFiles
from db.database import init_db
from api.sync import router as sync_router
from api.timeline import router as timeline_router
from api.photos import router as photos_router
from api.people import router as people_router
from api.places import router as places_router
from api.search import router as search_router
from api.albums import router as albums_router
from workers.ingester import run_ingester
from workers.thumbnail_worker import run_thumbnail_worker
from services.metadata_export import generate_and_push

logging.basicConfig(
    level=logging.INFO,
    format="%(asctime)s [%(levelname)s] %(name)s: %(message)s",
)
logger = logging.getLogger(__name__)


@asynccontextmanager
async def lifespan(app: FastAPI):
    logger.info("CloudGallery Server starting up")
    init_db()
    task = asyncio.create_task(run_ingester())
    thumb_task = asyncio.create_task(run_thumbnail_worker())
    metadata_task = asyncio.create_task(_delayed_metadata_push())
    yield
    task.cancel()
    thumb_task.cancel()
    metadata_task.cancel()
    logger.info("CloudGallery Server shutting down")


async def _delayed_metadata_push():
    """Periodically push metadata DB — every 30 min."""
    try:
        await asyncio.sleep(120)  # 2 min initial delay for ingester
        while True:
            logger.info("Running periodic metadata push")
            try:
                await asyncio.to_thread(generate_and_push)
            except Exception as e:
                logger.error(f"Metadata push failed: {e}")
            await asyncio.sleep(1800)  # Every 30 min
    except asyncio.CancelledError:
        pass


app = FastAPI(
    title="CloudGallery Server",
    description="EXIF extraction + Timeline API for CloudGallery",
    version="0.1.0",
    lifespan=lifespan,
)

app.include_router(sync_router)
app.include_router(timeline_router)
app.include_router(photos_router)
app.include_router(people_router)
app.include_router(places_router)
app.include_router(search_router)
from api.thumbnails import router as thumbnails_router
app.include_router(albums_router)
from api.metadata import router as metadata_router
app.include_router(metadata_router)
app.include_router(thumbnails_router)

app.mount("/dashboard", StaticFiles(directory="static", html=True), name="dashboard")


@app.get("/")
async def root():
    return {"service": "CloudGallery Server", "version": "0.1.0", "status": "running"}


if __name__ == "__main__":
    import uvicorn
    uvicorn.run("main:app", host="0.0.0.0", port=8100, reload=True)
