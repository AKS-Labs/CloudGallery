package com.akslabs.cloudgallery.data.localdb.migration

import android.util.Log
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

class Migration7to8_MultiDevice : Migration(7, 8) {
    override fun migrate(db: SupportSQLiteDatabase) {
        Log.i("Migration7to8", "Starting migration 7 → 8 (Multi-Device Support)")

        // ── photos table: new columns ──
        db.execSQL("ALTER TABLE photos ADD COLUMN contentHash TEXT DEFAULT NULL")
        db.execSQL("ALTER TABLE photos ADD COLUMN uploadStatus TEXT NOT NULL DEFAULT 'NONE'")
        db.execSQL("ALTER TABLE photos ADD COLUMN deviceId TEXT DEFAULT NULL")
        db.execSQL("ALTER TABLE photos ADD COLUMN lastUploadAttempt INTEGER DEFAULT NULL")
        db.execSQL("ALTER TABLE photos ADD COLUMN uploadRetryCount INTEGER NOT NULL DEFAULT 0")

        // ── photos table: indexes ──
        db.execSQL("CREATE INDEX IF NOT EXISTS index_photos_remoteId ON photos(remoteId)")
        db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS index_photos_pathUri ON photos(pathUri)")
        db.execSQL("CREATE INDEX IF NOT EXISTS index_photos_contentHash ON photos(contentHash)")
        db.execSQL("CREATE INDEX IF NOT EXISTS index_photos_uploadStatus ON photos(uploadStatus)")

        // Mark already‑uploaded photos as DONE
        db.execSQL("UPDATE photos SET uploadStatus = 'DONE' WHERE remoteId IS NOT NULL")

        // ── remote_photos table: new columns ──
        db.execSQL("ALTER TABLE remote_photos ADD COLUMN localId TEXT DEFAULT NULL")
        db.execSQL("ALTER TABLE remote_photos ADD COLUMN contentHash TEXT DEFAULT NULL")
        db.execSQL("ALTER TABLE remote_photos ADD COLUMN status TEXT NOT NULL DEFAULT 'ACTIVE'")
        db.execSQL("ALTER TABLE remote_photos ADD COLUMN deletedAt INTEGER DEFAULT NULL")
        db.execSQL("ALTER TABLE remote_photos ADD COLUMN uploadedByDevice TEXT DEFAULT NULL")
        db.execSQL("ALTER TABLE remote_photos ADD COLUMN deletedByDevice TEXT DEFAULT NULL")

        // ── remote_photos table: indexes ──
        db.execSQL("CREATE INDEX IF NOT EXISTS index_remote_photos_uploadedAt ON remote_photos(uploadedAt)")
        db.execSQL("CREATE INDEX IF NOT EXISTS index_remote_photos_contentHash ON remote_photos(contentHash)")
        db.execSQL("CREATE INDEX IF NOT EXISTS index_remote_photos_localId ON remote_photos(localId)")
        db.execSQL("CREATE INDEX IF NOT EXISTS index_remote_photos_status ON remote_photos(status)")

        // ── Migrate deleted_photos → remote_photos with status = 'DELETED' ──
        db.execSQL("""
            INSERT OR IGNORE INTO remote_photos (remoteId, photoType, fileName, fileSize, uploadedAt, thumbnailCached, messageId, status, deletedAt)
            SELECT remoteId, photoType, fileName, fileSize, uploadedAt, 0, messageId, 'DELETED', deletedAt
            FROM deleted_photos
        """.trimIndent())

        // ── upload_queue table ──
        db.execSQL("""
            CREATE TABLE IF NOT EXISTS upload_queue (
                id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
                localId TEXT NOT NULL,
                pathUri TEXT NOT NULL,
                contentHash TEXT,
                status TEXT NOT NULL DEFAULT 'PENDING',
                workerType TEXT NOT NULL,
                workManagerId TEXT,
                deviceId TEXT NOT NULL,
                createdAt INTEGER NOT NULL,
                startedAt INTEGER,
                completedAt INTEGER,
                errorMessage TEXT,
                retryCount INTEGER NOT NULL DEFAULT 0
            )
        """.trimIndent())
        db.execSQL("CREATE INDEX IF NOT EXISTS index_upload_queue_localId ON upload_queue(localId)")
        db.execSQL("CREATE INDEX IF NOT EXISTS index_upload_queue_status ON upload_queue(status)")
        db.execSQL("CREATE INDEX IF NOT EXISTS index_upload_queue_contentHash ON upload_queue(contentHash)")

        // ── sync_metadata table ──
        db.execSQL("""
            CREATE TABLE IF NOT EXISTS sync_metadata (
                `key` TEXT NOT NULL PRIMARY KEY,
                value TEXT NOT NULL,
                updatedAt INTEGER NOT NULL
            )
        """.trimIndent())

        Log.i("Migration7to8", "Migration 7 → 8 completed successfully")
    }
}
