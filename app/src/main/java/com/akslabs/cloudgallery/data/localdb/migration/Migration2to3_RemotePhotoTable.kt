package com.akslabs.cloudgallery.data.localdb.migration

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

class Migration2to3_RemotePhotoTable : Migration(2, 3) {

    companion object {
        private const val REMOTE_PHOTOS_TABLE = "remote_photos"
        private const val PHOTOS_TABLE = "photos"
    }

    override fun migrate(db: SupportSQLiteDatabase) {
        val columns = "remoteId, photoType"
        db.execSQL(
            "CREATE TABLE IF NOT EXISTS `${REMOTE_PHOTOS_TABLE}` (`remoteId` TEXT NOT NULL, " +
                "`photoType` TEXT NOT NULL, PRIMARY KEY(`remoteId`))"
        )
        db.execSQL(
            "INSERT INTO `${REMOTE_PHOTOS_TABLE}` ($columns) SELECT $columns FROM `${PHOTOS_TABLE}` WHERE `remoteId` IS NOT NULL"
        )
    }
}
