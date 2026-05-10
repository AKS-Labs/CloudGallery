package com.akslabs.cloudgallery.data.localdb.migration

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

class Migration8to9_ThumbnailBlob : Migration(8, 9) {
    override fun migrate(db: SupportSQLiteDatabase) {
        db.execSQL("ALTER TABLE remote_photos ADD COLUMN thumbnailBytes BLOB DEFAULT NULL")
        db.execSQL("ALTER TABLE remote_photos ADD COLUMN thumbSynced INTEGER NOT NULL DEFAULT 0")
    }
}
