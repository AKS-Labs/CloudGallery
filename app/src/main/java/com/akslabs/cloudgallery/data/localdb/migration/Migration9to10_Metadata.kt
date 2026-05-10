package com.akslabs.cloudgallery.data.localdb.migration

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

class Migration9to10_Metadata : Migration(9, 10) {
    override fun migrate(db: SupportSQLiteDatabase) {
        // Create people table
        db.execSQL("""
            CREATE TABLE IF NOT EXISTS `people` (
                `id` INTEGER NOT NULL PRIMARY KEY,
                `name` TEXT,
                `photoCount` INTEGER NOT NULL DEFAULT 0,
                `faceSampleRemoteId` TEXT
            )
        """)

        // Create places table
        db.execSQL("""
            CREATE TABLE IF NOT EXISTS `places` (
                `id` INTEGER NOT NULL PRIMARY KEY,
                `name` TEXT NOT NULL DEFAULT '',
                `city` TEXT,
                `state` TEXT,
                `country` TEXT,
                `lat` REAL,
                `lon` REAL,
                `photoCount` INTEGER NOT NULL DEFAULT 0
            )
        """)

        // Add metadata columns to remote_photos
        db.execSQL("ALTER TABLE remote_photos ADD COLUMN dateTaken TEXT DEFAULT NULL")
        db.execSQL("ALTER TABLE remote_photos ADD COLUMN personIds TEXT DEFAULT NULL")
        db.execSQL("ALTER TABLE remote_photos ADD COLUMN placeId INTEGER DEFAULT NULL")
        db.execSQL("ALTER TABLE remote_photos ADD COLUMN placeName TEXT DEFAULT NULL")
    }
}
