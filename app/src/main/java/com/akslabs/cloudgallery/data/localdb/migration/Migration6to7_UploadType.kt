package com.akslabs.cloudgallery.data.localdb.migration

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

class Migration6to7_UploadType : Migration(6, 7) {
    override fun migrate(db: SupportSQLiteDatabase) {
        db.execSQL("ALTER TABLE remote_photos ADD COLUMN uploadType TEXT DEFAULT NULL")
    }
}
