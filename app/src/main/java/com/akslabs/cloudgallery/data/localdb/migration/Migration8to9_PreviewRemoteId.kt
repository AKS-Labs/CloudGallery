package com.akslabs.cloudgallery.data.localdb.migration

import android.util.Log
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

class Migration8to9_PreviewRemoteId : Migration(8, 9) {
    override fun migrate(db: SupportSQLiteDatabase) {
        Log.i("Migration8to9", "Starting migration 8 → 9 (Preview Remote ID)")

        db.execSQL("ALTER TABLE photos ADD COLUMN previewRemoteId TEXT DEFAULT NULL")
        db.execSQL("ALTER TABLE remote_photos ADD COLUMN previewRemoteId TEXT DEFAULT NULL")

        Log.i("Migration8to9", "Migration 8 → 9 completed successfully")
    }
}
