import logging
import numpy as np
from sklearn.cluster import DBSCAN
from db.database import get_db_ctx
from db.models import Face, Person
from services.faces import get_all_embeddings
from sqlalchemy import func

logger = logging.getLogger(__name__)


def cluster_faces(eps: float = 0.45, min_samples: int = 2):
    """Cluster all face embeddings using DBSCAN and create/update Person records."""
    face_ids, embeddings = get_all_embeddings()
    if len(face_ids) == 0:
        logger.info("No faces to cluster")
        return 0

    logger.info(f"Clustering {len(face_ids)} faces (eps={eps})")

    # face_recognition encodings use Euclidean distance; 0.6 is the default threshold
    # DBSCAN eps=0.45 is a good balance for grouping same person
    clustering = DBSCAN(eps=eps, min_samples=min_samples, metric="euclidean", n_jobs=-1)
    labels = clustering.fit_predict(embeddings)

    n_clusters = len(set(labels) - {-1})
    logger.info(f"Found {n_clusters} clusters, {(labels == -1).sum()} noise faces")

    with get_db_ctx() as db:
        # Clear existing person assignments for re-clustering
        db.query(Face).update({Face.person_id: None})
        db.query(Person).delete()
        db.flush()

        label_to_person = {}
        for face_id, label in zip(face_ids, labels):
            if label == -1:
                continue  # noise / unassigned

            if label not in label_to_person:
                person = Person(name=None, photo_count=0)
                db.add(person)
                db.flush()
                label_to_person[label] = person
            else:
                person = label_to_person[label]

            face = db.query(Face).filter(Face.id == face_id).first()
            if face:
                face.person_id = person.id

        # Update photo counts and set thumbnail for each person
        for person in label_to_person.values():
            face_count = db.query(Face).filter(Face.person_id == person.id).count()
            photo_count = (
                db.query(func.count(func.distinct(Face.photo_id)))
                .filter(Face.person_id == person.id)
                .scalar()
            )
            person.photo_count = photo_count
            # Pick the first face as thumbnail
            first_face = db.query(Face).filter(Face.person_id == person.id).first()
            if first_face:
                person.thumbnail_face_id = first_face.id

    logger.info(f"Clustering complete: {n_clusters} people created")
    return n_clusters
