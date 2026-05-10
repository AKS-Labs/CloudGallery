package com.akslabs.cloudgallery.services

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.util.Log
import com.akslabs.cloudgallery.data.localdb.DbHolder
import com.akslabs.cloudgallery.data.localdb.Preferences
import com.akslabs.cloudgallery.data.localdb.entities.Person
import com.akslabs.cloudgallery.data.localdb.entities.Place
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONObject
import java.io.File

/**
 * Downloads the metadata.db from Telegram (pinned message) and imports
 * people, places, and photo metadata into the local Room database.
 */
object MetadataSyncService {
    private const val TAG = "MetadataSyncService"
    private val client = OkHttpClient()

    /**
     * Returns the file_id of the pinned metadata.db document, or null.
     */
    suspend fun findMetadataFileId(): String? = withContext(Dispatchers.IO) {
        try {
            val token = Preferences.getEncryptedString(Preferences.botToken, "")
            val chatId = Preferences.getEncryptedLong(Preferences.channelId, 0L)
            if (token.isBlank() || chatId == 0L) return@withContext null

            val url = "https://api.telegram.org/bot$token/getChat?chat_id=$chatId"
            val request = Request.Builder().url(url).build()
            val response = client.newCall(request).execute()
            val body = response.body?.string() ?: return@withContext null
            val json = JSONObject(body)

            if (!json.getBoolean("ok")) return@withContext null

            val result = json.getJSONObject("result")
            if (!result.has("pinned_message")) return@withContext null

            val pinned = result.getJSONObject("pinned_message")
            val caption = pinned.optString("caption", "")
            if (!caption.contains("#cloudgallery_metadata_v1")) return@withContext null

            val document = pinned.optJSONObject("document") ?: return@withContext null
            document.getString("file_id")
        } catch (e: Exception) {
            Log.e(TAG, "findMetadataFileId failed", e)
            null
        }
    }

    /**
     * Downloads a Telegram file by file_id and saves to app internal storage.
     */
    suspend fun downloadFile(context: Context, fileId: String): File? = withContext(Dispatchers.IO) {
        try {
            val token = Preferences.getEncryptedString(Preferences.botToken, "")

            // Get file path
            val getFileUrl = "https://api.telegram.org/bot$token/getFile?file_id=$fileId"
            val req1 = Request.Builder().url(getFileUrl).build()
            val resp1 = client.newCall(req1).execute()
            val json = JSONObject(resp1.body?.string() ?: return@withContext null)
            if (!json.getBoolean("ok")) return@withContext null
            val filePath = json.getJSONObject("result").getString("file_path")

            // Download file
            val downloadUrl = "https://api.telegram.org/file/bot$token/$filePath"
            val req2 = Request.Builder().url(downloadUrl).build()
            val resp2 = client.newCall(req2).execute()
            val bytes = resp2.body?.bytes() ?: return@withContext null

            val outFile = File(context.filesDir, "metadata.db")
            outFile.writeBytes(bytes)
            Log.i(TAG, "Downloaded metadata.db (${bytes.size} bytes)")
            outFile
        } catch (e: Exception) {
            Log.e(TAG, "downloadFile failed", e)
            null
        }
    }

    /**
     * Imports data from the downloaded metadata.db into Room.
     */
    suspend fun importMetadata(metadataDbFile: File) = withContext(Dispatchers.IO) {
        val db = SQLiteDatabase.openDatabase(metadataDbFile.absolutePath, null, SQLiteDatabase.OPEN_READONLY)
        try {
            importPeople(db)
            importPlaces(db)
            importPhotoMetadata(db)
            Log.i(TAG, "Metadata import complete")
        } finally {
            db.close()
        }
    }

    private suspend fun importPeople(db: SQLiteDatabase) {
        val people = mutableListOf<Person>()
        val cursor = db.rawQuery("SELECT id, name, photo_count, face_sample_remote_id FROM people", null)
        cursor.use {
            while (it.moveToNext()) {
                people.add(Person(
                    id = it.getInt(0),
                    name = it.getString(1),
                    photoCount = it.getInt(2),
                    faceSampleRemoteId = it.getString(3)
                ))
            }
        }
        val dao = DbHolder.database.personDao()
        dao.deleteAll()
        dao.insertAll(people)
        Log.i(TAG, "Imported ${people.size} people")
    }

    private suspend fun importPlaces(db: SQLiteDatabase) {
        val places = mutableListOf<Place>()
        val cursor = db.rawQuery("SELECT id, name, city, state, country, lat, lon, photo_count FROM places", null)
        cursor.use {
            while (it.moveToNext()) {
                places.add(Place(
                    id = it.getInt(0),
                    name = it.getString(1) ?: "",
                    city = it.getString(2),
                    state = it.getString(3),
                    country = it.getString(4),
                    lat = if (it.isNull(5)) null else it.getDouble(5),
                    lon = if (it.isNull(6)) null else it.getDouble(6),
                    photoCount = it.getInt(7)
                ))
            }
        }
        val dao = DbHolder.database.placeDao()
        dao.deleteAll()
        dao.insertAll(places)
        Log.i(TAG, "Imported ${places.size} places")
    }

    private suspend fun importPhotoMetadata(db: SQLiteDatabase) {
        val roomDb = DbHolder.database.openHelper.writableDatabase
        val cursor = db.rawQuery(
            "SELECT remote_id, date_taken, person_ids, place_name FROM photo_metadata", null
        )
        cursor.use {
            roomDb.beginTransaction()
            try {
                while (it.moveToNext()) {
                    val remoteId = it.getString(0) ?: continue
                    val dateTaken = it.getString(1)
                    val personIds = it.getString(2)
                    val placeName = it.getString(3)
                    roomDb.execSQL(
                        "UPDATE remote_photos SET dateTaken = ?, personIds = ?, placeName = ? WHERE remoteId = ?",
                        arrayOf(dateTaken, personIds, placeName, remoteId)
                    )
                }
                roomDb.setTransactionSuccessful()
            } finally {
                roomDb.endTransaction()
            }
        }
        Log.i(TAG, "Updated photo metadata in remote_photos")
    }
}
