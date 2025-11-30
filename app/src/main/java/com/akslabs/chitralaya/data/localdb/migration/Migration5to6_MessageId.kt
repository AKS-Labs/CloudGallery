package com.akslabs.cloudgallery.data.localdb.migration

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

class Migration5to6_MessageId : Migration(5, 6) {
    override fun migrate(db: SupportSQLiteDatabase) {
        // Add messageId column to remote_photos
        db.execSQL("ALTER TABLE remote_photos ADD COLUMN messageId INTEGER DEFAULT NULL")
        
        // Add messageId column to deleted_photos
        db.execSQL("ALTER TABLE deleted_photos ADD COLUMN messageId INTEGER DEFAULT NULL")
    }
}
