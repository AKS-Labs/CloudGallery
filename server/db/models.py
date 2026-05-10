from sqlalchemy import Column, Integer, String, Float, Boolean, DateTime, ForeignKey, LargeBinary
from sqlalchemy.orm import declarative_base, relationship
from sqlalchemy.sql import func
from datetime import datetime

Base = declarative_base()


class Photo(Base):
    __tablename__ = "photos"

    id = Column(Integer, primary_key=True)
    telegram_file_id = Column(String, unique=True, index=True)
    telegram_message_id = Column(Integer)
    filename = Column(String)
    file_size = Column(Integer)
    mime_type = Column(String)
    width = Column(Integer)
    height = Column(Integer)
    date_taken = Column(DateTime)
    date_uploaded = Column(DateTime, default=datetime.utcnow)
    gps_lat = Column(Float)
    gps_lon = Column(Float)
    camera_make = Column(String)
    camera_model = Column(String)
    processed = Column(Boolean, default=False)
    processing_error = Column(String, nullable=True)
    faces_processed = Column(Boolean, default=False)
    location_id = Column(Integer, ForeignKey("locations.id"), nullable=True, index=True)

    faces = relationship("Face", back_populates="photo")
    location = relationship("Location", back_populates="photos")

    def to_dict(self) -> dict:
        return {
            "id": self.id,
            "telegram_file_id": self.telegram_file_id,
            "telegram_message_id": self.telegram_message_id,
            "filename": self.filename,
            "file_size": self.file_size,
            "mime_type": self.mime_type,
            "width": self.width,
            "height": self.height,
            "date_taken": self.date_taken.isoformat() if self.date_taken else None,
            "date_uploaded": self.date_uploaded.isoformat() if self.date_uploaded else None,
            "gps_lat": self.gps_lat,
            "gps_lon": self.gps_lon,
            "camera_make": self.camera_make,
            "camera_model": self.camera_model,
            "processed": self.processed,
            "location_id": self.location_id,
        }


class Face(Base):
    __tablename__ = "faces"

    id = Column(Integer, primary_key=True)
    photo_id = Column(Integer, ForeignKey("photos.id"), index=True)
    x = Column(Integer)
    y = Column(Integer)
    w = Column(Integer)
    h = Column(Integer)
    embedding = Column(LargeBinary)  # pickled numpy array
    person_id = Column(Integer, ForeignKey("people.id"), nullable=True, index=True)

    photo = relationship("Photo", back_populates="faces")
    person = relationship("Person", back_populates="faces")


class Location(Base):
    __tablename__ = "locations"

    id = Column(Integer, primary_key=True)
    name = Column(String)  # "Austin, TX" or "Yellowstone National Park"
    city = Column(String, nullable=True)
    state = Column(String, nullable=True)
    country = Column(String, nullable=True)
    lat = Column(Float)
    lon = Column(Float)
    radius_km = Column(Float, default=1.0)
    photo_count = Column(Integer, default=0)
    created_at = Column(DateTime, default=func.now())

    photos = relationship("Photo", back_populates="location")

    def to_dict(self) -> dict:
        return {
            "id": self.id,
            "name": self.name,
            "city": self.city,
            "state": self.state,
            "country": self.country,
            "lat": self.lat,
            "lon": self.lon,
            "radius_km": self.radius_km,
            "photo_count": self.photo_count,
            "created_at": self.created_at.isoformat() if self.created_at else None,
        }


class Person(Base):
    __tablename__ = "people"

    id = Column(Integer, primary_key=True)
    name = Column(String, nullable=True)
    thumbnail_face_id = Column(Integer, nullable=True)
    photo_count = Column(Integer, default=0)
    created_at = Column(DateTime, default=func.now())

    faces = relationship("Face", back_populates="person")

    def to_dict(self) -> dict:
        return {
            "id": self.id,
            "name": self.name,
            "thumbnail_face_id": self.thumbnail_face_id,
            "photo_count": self.photo_count,
            "created_at": self.created_at.isoformat() if self.created_at else None,
        }
