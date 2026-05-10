import logging
import pickle
import numpy as np
from pathlib import Path
from db.database import get_db_ctx
from db.models import Photo, Face

logger = logging.getLogger(__name__)

_face_recognition = None

def _get_fr():
    global _face_recognition
    if _face_recognition is None:
        try:
            import face_recognition
            _face_recognition = face_recognition
        except (SystemExit, Exception) as e:
            logger.warning(f"face_recognition unavailable: {e}")
            raise RuntimeError("face_recognition not available") from e
    return _face_recognition


def detect_faces_in_photo(photo_path: str, photo_id: int) -> int:
    """Detect faces in a photo, save bounding boxes + embeddings to DB.
    Returns number of faces found."""
    fr = _get_fr()
    
    try:
        image = fr.load_image_file(photo_path)
    except Exception as e:
        logger.error(f"Could not load image {photo_path}: {e}")
        return 0

    try:
        locations = fr.face_locations(image, model="hog")
        if not locations:
            return 0
        encodings = fr.face_encodings(image, locations)
    except Exception as e:
        logger.error(f"Face detection failed for photo {photo_id}: {e}")
        return 0

    faces_added = 0
    with get_db_ctx() as db:
        for (top, right, bottom, left), encoding in zip(locations, encodings):
            face = Face(
                photo_id=photo_id,
                x=left,
                y=top,
                w=right - left,
                h=bottom - top,
                embedding=pickle.dumps(encoding),
            )
            db.add(face)
            faces_added += 1

    logger.info(f"Photo {photo_id}: found {faces_added} face(s)")
    return faces_added


def get_all_embeddings() -> tuple[list[int], np.ndarray]:
    """Load all face embeddings from DB. Returns (face_ids, embeddings_matrix)."""
    with get_db_ctx() as db:
        faces = db.query(Face.id, Face.embedding).all()

    if not faces:
        return [], np.array([])

    face_ids = [f.id for f in faces]
    embeddings = np.array([pickle.loads(f.embedding) for f in faces])
    return face_ids, embeddings
