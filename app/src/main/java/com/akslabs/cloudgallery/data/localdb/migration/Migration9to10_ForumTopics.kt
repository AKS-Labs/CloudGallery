package com.akslabs.cloudgallery.data.localdb.migration

import android.util.Log
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

class Migration9to10_ForumTopics : Migration(9, 10) {
    override fun migrate(db: SupportSQLiteDatabase) {
        Log.i("Migration9to10", "Starting migration 9 → 10 (Forum Topics)")

        db.execSQL("ALTER TABLE remote_photos ADD COLUMN topicId INTEGER DEFAULT NULL")
        db.execSQL("ALTER TABLE remote_photos ADD COLUMN topicName TEXT DEFAULT NULL")

        Log.i("Migration9to10", "Migration 9 → 10 completed successfully")
    }
}
