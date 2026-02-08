package com.akslabs.cloudgallery.data.localdb.migration

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

class Migration4to5_PhotoDateModified : Migration(4, 5) {
    override fun migrate(db: SupportSQLiteDatabase) {
        // Add dateModified column with default 0 and not null
        db.execSQL("ALTER TABLE photos ADD COLUMN dateModified INTEGER NOT NULL DEFAULT 0")
    }
}

