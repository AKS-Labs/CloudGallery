package com.akslabs.cloudgallery.data.localdb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.akslabs.cloudgallery.data.localdb.dao.PhotoDao
import com.akslabs.cloudgallery.data.localdb.dao.RemotePhotoDao
import com.akslabs.cloudgallery.data.localdb.entities.Photo
import com.akslabs.cloudgallery.data.localdb.entities.RemotePhoto
import com.akslabs.cloudgallery.data.localdb.migration.Migration1to2_NullableRemoteId
import com.akslabs.cloudgallery.data.localdb.migration.Migration2to3_RemotePhotoTable
import com.akslabs.cloudgallery.data.localdb.migration.Migration3to4_EnhancedRemotePhoto

@Database(
    entities = [
        Photo::class, RemotePhoto::class
    ],
    version = 4
)
abstract class WhDatabase : RoomDatabase() {
    abstract fun photoDao(): PhotoDao
    abstract fun remotePhotoDao(): RemotePhotoDao

    companion object {
        private const val DATABASE_NAME = "TeledriveDb"

        private fun migrations() = arrayOf(
            Migration1to2_NullableRemoteId(),
            Migration2to3_RemotePhotoTable(),
            Migration3to4_EnhancedRemotePhoto()
        )

        fun create(applicationContext: Context): WhDatabase {
            return Room
                .databaseBuilder(
                    applicationContext,
                    WhDatabase::class.java,
                    DATABASE_NAME
                )
                .addMigrations(*migrations())
                .build()
        }
    }
}