"""Phase H: Metadata export + Telegram push endpoints."""

import asyncio
import logging
from fastapi import APIRouter, BackgroundTasks

from services.metadata_export import generate_and_push, get_status

logger = logging.getLogger(__name__)
router = APIRouter(prefix="/api/metadata", tags=["metadata"])


@router.post("/generate")
async def trigger_generate(background_tasks: BackgroundTasks):
    """Trigger metadata DB generation and Telegram upload."""
    status = get_status()
    if status["state"] in ("generating", "uploading"):
        return {"message": "Already in progress", "status": status}

    background_tasks.add_task(generate_and_push)
    return {"message": "Metadata generation started", "status": "generating"}


@router.get("/status")
async def metadata_status():
    """Get current metadata generation status."""
    return get_status()
