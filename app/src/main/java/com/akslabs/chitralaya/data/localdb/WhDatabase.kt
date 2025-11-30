package com.akslabs.cloudgallery.data.localdb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.akslabs.cloudgallery.data.localdb.dao.DeletedPhotoDao
import com.akslabs.cloudgallery.data.localdb.dao.PhotoDao
import com.akslabs.cloudgallery.data.localdb.dao.RemotePhotoDao
import com.akslabs.cloudgallery.data.localdb.entities.DeletedPhoto
import com.akslabs.cloudgallery.data.localdb.entities.Photo
import com.akslabs.cloudgallery.data.localdb.entities.RemotePhoto
import com.akslabs.cloudgallery.data.localdb.migration.Migration1to2_NullableRemoteId
import com.akslabs.cloudgallery.data.localdb.migration.Migration2to3_RemotePhotoTable
import com.akslabs.cloudgallery.data.localdb.migration.Migration3to4_EnhancedRemotePhoto
import com.akslabs.cloudgallery.data.localdb.migration.Migration4to5_DeletedPhotos

@Database(
    entities = [Photo::class, RemotePhoto::class, DeletedPhoto::class],
    version = 6,
    exportSchema = false
)
abstract class WhDatabase : RoomDatabase() {
    abstract fun photoDao(): PhotoDao
    abstract fun remotePhotoDao(): RemotePhotoDao
    abstract fun deletedPhotoDao(): DeletedPhotoDao

    companion object {
        private const val DATABASE_NAME = "wh_database"

        @Volatile
        private var INSTANCE: WhDatabase? = null

        fun getInstance(context: Context): WhDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    WhDatabase::class.java,
                    DATABASE_NAME
                )
                    .addMigrations(
                        Migration1to2_NullableRemoteId(),
                        Migration2to3_RemotePhotoTable(),
                        Migration3to4_EnhancedRemotePhoto(),
                        Migration4to5_DeletedPhotos(),
                        com.akslabs.cloudgallery.data.localdb.migration.Migration5to6_MessageId()
                    )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}