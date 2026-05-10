import asyncio
import logging
from contextlib import asynccontextmanager
from fastapi import FastAPI
from db.database import init_db
from api.sync import router as sync_router
from api.timeline import router as timeline_router
from api.photos import router as photos_router
from api.people import router as people_router
from api.places import router as places_router
from workers.ingester import run_ingester

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
    yield
    task.cancel()
    logger.info("CloudGallery Server shutting down")


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


@app.get("/")
async def root():
    return {"service": "CloudGallery Server", "version": "0.1.0", "status": "running"}


if __name__ == "__main__":
    import uvicorn
    uvicorn.run("main:app", host="0.0.0.0", port=8100, reload=True)
