import logging
from sqlalchemy import func
from sqlalchemy.orm import Session
from db.models import Photo
from collections import defaultdict

logger = logging.getLogger(__name__)


def find_duplicates(db: Session) -> list:
    """Find potential duplicate photos by file_size + dimensions match."""
    # Group by (file_size, width, height) where all three are non-null
    groups = (
        db.query(Photo.file_size, Photo.width, Photo.height, func.count(Photo.id))
        .filter(Photo.file_size.isnot(None), Photo.width.isnot(None), Photo.height.isnot(None))
        .group_by(Photo.file_size, Photo.width, Photo.height)
        .having(func.count(Photo.id) > 1)
        .all()
    )

    result = []
    for file_size, width, height, count in groups:
        photos = (
            db.query(Photo)
            .filter(Photo.file_size == file_size, Photo.width == width, Photo.height == height)
            .all()
        )
        result.append({
            "file_size": file_size,
            "width": width,
            "height": height,
            "count": count,
            "photos": [p.to_dict() for p in photos],
        })

    return result
