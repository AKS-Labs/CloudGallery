package com.akslabs.cloudgallery.data.localdb.migration

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

class Migration3to4_EnhancedRemotePhoto : Migration(3, 4) {

    companion object {
        private const val REMOTE_PHOTOS_TABLE = "remote_photos"
        private const val TEMP_TABLE = "remote_photos_temp"
    }

    override fun migrate(db: SupportSQLiteDatabase) {
        // Create new table with enhanced schema
        db.execSQL(
            """
            CREATE TABLE IF NOT EXISTS `${TEMP_TABLE}` (
                `remoteId` TEXT NOT NULL, 
                `photoType` TEXT NOT NULL, 
                `fileName` TEXT, 
                `fileSize` INTEGER, 
                `uploadedAt` INTEGER NOT NULL DEFAULT ${System.currentTimeMillis()}, 
                `thumbnailCached` INTEGER NOT NULL DEFAULT 0, 
                PRIMARY KEY(`remoteId`)
            )
            """.trimIndent()
        )

        // Copy existing data to new table
        db.execSQL(
            """
            INSERT INTO `${TEMP_TABLE}` (remoteId, photoType, fileName, fileSize, uploadedAt, thumbnailCached)
            SELECT remoteId, photoType, NULL, NULL, ${System.currentTimeMillis()}, 0
            FROM `${REMOTE_PHOTOS_TABLE}`
            """.trimIndent()
        )

        // Drop old table
        db.execSQL("DROP TABLE `${REMOTE_PHOTOS_TABLE}`")

        // Rename temp table to original name
        db.execSQL("ALTER TABLE `${TEMP_TABLE}` RENAME TO `${REMOTE_PHOTOS_TABLE}`")
    }
}
