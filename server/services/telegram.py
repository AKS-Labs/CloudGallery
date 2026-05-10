import logging
import telegram
from config import BOT_TOKEN

logger = logging.getLogger(__name__)

_bot: telegram.Bot | None = None


def get_bot() -> telegram.Bot:
    global _bot
    if _bot is None:
        _bot = telegram.Bot(token=BOT_TOKEN)
    return _bot


async def download_photo(file_id: str, dest_path: str) -> str:
    """Download a photo from Telegram by file_id. Returns the local path."""
    bot = get_bot()
    try:
        file = await bot.get_file(file_id)
        await file.download_to_drive(dest_path)
        logger.info(f"Downloaded {file_id} -> {dest_path}")
        return dest_path
    except Exception as e:
        logger.error(f"Failed to download {file_id}: {e}")
        raise
