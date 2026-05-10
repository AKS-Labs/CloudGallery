from sqlalchemy import create_engine
from sqlalchemy.orm import sessionmaker, Session
from contextlib import contextmanager
from config import DB_PATH
from db.models import Base

engine = create_engine(f"sqlite:///{DB_PATH}", connect_args={"check_same_thread": False})
SessionLocal = sessionmaker(bind=engine)


def init_db():
    Base.metadata.create_all(bind=engine)
    # Migrate: add thumbnail columns if missing
    from sqlalchemy import text, inspect
    insp = inspect(engine)
    cols = [c["name"] for c in insp.get_columns("photos")]
    with engine.begin() as conn:
        if "thumbnail_status" not in cols:
            conn.execute(text("ALTER TABLE photos ADD COLUMN thumbnail_status VARCHAR DEFAULT 'pending'"))
        if "thumbnail_error" not in cols:
            conn.execute(text("ALTER TABLE photos ADD COLUMN thumbnail_error VARCHAR"))


def get_db():
    db = SessionLocal()
    try:
        yield db
    finally:
        db.close()


@contextmanager
def get_db_ctx() -> Session:
    db = SessionLocal()
    try:
        yield db
        db.commit()
    except Exception:
        db.rollback()
        raise
    finally:
        db.close()
