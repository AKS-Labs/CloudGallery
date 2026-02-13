package com.akslabs.cloudgallery.data.localdb.migration

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

class Migration1to2_NullableRemoteId : Migration(1, 2) {

    companion object {
        private const val PHOTOS_TABLE = "photos"
        private const val PHOTOS_TEMP_TABLE = "photos_temp"
    }

    override fun migrate(db: SupportSQLiteDatabase) {
        val columns = "localId, remoteId, photoType, pathUri"
        db.execSQL(
            "CREATE TABLE IF NOT EXISTS `${PHOTOS_TEMP_TABLE}` (`localId` TEXT NOT NULL, `remoteId` TEXT, " +
                "`photoType` TEXT NOT NULL, `pathUri` TEXT NOT NULL, PRIMARY KEY(`localId`))"
        )
        db.execSQL(
            "INSERT INTO `${PHOTOS_TEMP_TABLE}` ($columns) SELECT $columns FROM `${PHOTOS_TABLE}`"
        )
        db.execSQL("DROP TABLE `${PHOTOS_TABLE}`")
        db.execSQL("ALTER TABLE `${PHOTOS_TEMP_TABLE}` RENAME TO `${PHOTOS_TABLE}`")
    }
}
