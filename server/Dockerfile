FROM python:3.12-slim

WORKDIR /app

# Install system deps for Pillow + face_recognition (dlib needs cmake + build tools)
RUN apt-get update && apt-get install -y --no-install-recommends \
    libjpeg62-turbo-dev libwebp-dev \
    cmake build-essential libopenblas-dev liblapack-dev git \
    && rm -rf /var/lib/apt/lists/*

COPY requirements.txt .
RUN pip install --no-cache-dir -r requirements.txt && \
    pip install --no-cache-dir git+https://github.com/ageitgey/face_recognition_models

COPY . .

# Create dirs for data persistence
RUN mkdir -p /data /data/photo_cache /data/thumbnails

ENV DB_PATH=/data/cloudgallery.db
ENV PHOTO_CACHE_DIR=/data/photo_cache
ENV THUMBNAIL_DIR=/data/thumbnails

EXPOSE 8100

CMD ["python3", "main.py"]
