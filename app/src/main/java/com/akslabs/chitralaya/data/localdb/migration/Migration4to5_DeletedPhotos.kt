package com.akslabs.cloudgallery.data.localdb.migration

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

class Migration4to5_DeletedPhotos : Migration(4, 5) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL(
            "CREATE TABLE IF NOT EXISTS `deleted_photos` (" +
                    "`remoteId` TEXT NOT NULL, " +
                    "`photoType` TEXT NOT NULL, " +
                    "`fileName` TEXT, " +
                    "`fileSize` INTEGER, " +
                    "`uploadedAt` INTEGER NOT NULL, " +
                    "`deletedAt` INTEGER NOT NULL, " +
                    "PRIMARY KEY(`remoteId`))"
        )
    }
}
