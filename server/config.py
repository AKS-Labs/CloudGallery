import os
from pathlib import Path
from dotenv import load_dotenv

load_dotenv()

BOT_TOKEN: str = os.getenv("BOT_TOKEN", "")
CHAT_ID: int = int(os.getenv("CHAT_ID", "0"))
DB_PATH: str = os.getenv("DB_PATH", "./cloudgallery.db")
PHOTO_CACHE_DIR: Path = Path(os.getenv("PHOTO_CACHE_DIR", "./photo_cache"))
THUMBNAIL_DIR: Path = Path(os.getenv("THUMBNAIL_DIR", str(PHOTO_CACHE_DIR / "thumbnails")))

# Ensure dirs exist
PHOTO_CACHE_DIR.mkdir(parents=True, exist_ok=True)
THUMBNAIL_DIR.mkdir(parents=True, exist_ok=True)

INGESTER_INTERVAL_SECONDS: int = int(os.getenv("INGESTER_INTERVAL", "30"))
THUMBNAIL_SIZE: tuple[int, int] = (200, 200)
