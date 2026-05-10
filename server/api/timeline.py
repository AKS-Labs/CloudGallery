import logging
from datetime import datetime
from fastapi import APIRouter, Depends, Query
from sqlalchemy import func, extract
from sqlalchemy.orm import Session
from db.database import get_db
from db.models import Photo

logger = logging.getLogger(__name__)
router = APIRouter(prefix="/api/timeline", tags=["timeline"])


@router.get("")
async def get_timeline(
    page: int = Query(1, ge=1),
    per_page: int = Query(30, ge=1, le=100),
    db: Session = Depends(get_db),
):
    """Photos grouped by date (using date_taken or date_uploaded)."""
    # Get distinct dates
    date_col = func.coalesce(
        func.date(Photo.date_taken), func.date(Photo.date_uploaded)
    )

    date_counts = (
        db.query(date_col.label("photo_date"), func.count(Photo.id).label("count"))
        .group_by("photo_date")
        .order_by(date_col.desc())
        .offset((page - 1) * per_page)
        .limit(per_page)
        .all()
    )

    timeline = []
    for row in date_counts:
        date_str = row.photo_date
        if not date_str:
            continue
        photos = (
            db.query(Photo)
            .filter(
                func.coalesce(func.date(Photo.date_taken), func.date(Photo.date_uploaded))
                == date_str
            )
            .order_by(Photo.date_uploaded.desc())
            .all()
        )
        timeline.append({
            "date": date_str,
            "count": row.count,
            "photos": [p.to_dict() for p in photos],
        })

    total_dates = db.query(func.count(func.distinct(date_col))).scalar() or 0

    return {
        "timeline": timeline,
        "page": page,
        "per_page": per_page,
        "total_dates": total_dates,
    }


@router.get("/on-this-day")
async def on_this_day(db: Session = Depends(get_db)):
    """Photos from this day in previous years."""
    today = datetime.utcnow()
    month, day = today.month, today.day

    photos = (
        db.query(Photo)
        .filter(
            extract("month", func.coalesce(Photo.date_taken, Photo.date_uploaded)) == month,
            extract("day", func.coalesce(Photo.date_taken, Photo.date_uploaded)) == day,
        )
        .order_by(Photo.date_taken.desc())
        .all()
    )

    # Group by year
    by_year: dict[int, list] = {}
    for p in photos:
        dt = p.date_taken or p.date_uploaded
        if dt:
            yr = dt.year
            by_year.setdefault(yr, []).append(p.to_dict())

    return {
        "date": f"{month:02d}-{day:02d}",
        "years": [{"year": y, "count": len(ps), "photos": ps} for y, ps in sorted(by_year.items(), reverse=True)],
        "total": len(photos),
    }
