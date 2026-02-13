package com.akslabs.cloudgallery.api

import android.util.Log
import com.akslabs.cloudgallery.data.localdb.Preferences
import com.akslabs.cloudgallery.utils.Constants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONObject
import java.util.concurrent.TimeUnit

object TelegramHttp {
    private const val TAG = "TelegramHttp"

    private val client: OkHttpClient by lazy {
        OkHttpClient.Builder()
            .connectTimeout(20, TimeUnit.SECONDS)
            .readTimeout(20, TimeUnit.SECONDS)
            .writeTimeout(20, TimeUnit.SECONDS)
            .build()
    }

    /**
     * Returns a pair of <success, error_message>
     * success is true if Telegram Bot API getChat(chat_id) returns ok=true with a result.id matching chatId
     * error_message is the description from the API on failure
     */
    suspend fun validateChat(chatId: Long): Pair<Boolean, String?> {
        return withContext(Dispatchers.IO) {
            try {
                val token = Preferences.getEncryptedString(Preferences.botToken, Constants.SAMPLE_API_KEY)
                val url = "https://api.telegram.org/bot${token}/getChat?chat_id=${chatId}"
                val req = Request.Builder().url(url).get().build()
                client.newCall(req).execute().use { resp ->
                    val body = resp.body?.string()
                    if (body == null) {
                        return@withContext Pair(false, "Empty response body")
                    }
                    val json = JSONObject(body)
                    val ok = json.optBoolean("ok", false)
                    if (!ok) {
                        val description = json.optString("description", "Unknown error")
                        Log.w(TAG, "getChat returned ok=false: ${json.optInt("error_code")} $description")
                        return@withContext Pair(false, "Telegram API error: $description")
                    }
                    val result = json.optJSONObject("result")
                    if (result == null) {
                        return@withContext Pair(false, "Missing 'result' field in response")
                    }
                    val id = result.optLong("id", Long.MIN_VALUE)
                    if (id == chatId) {
                        Pair(true, null)
                    } else {
                        Pair(false, "Chat ID mismatch in response")
                    }
                }
            } catch (e: Exception) {
                Log.w(TAG, "validateChat failed", e)
                Pair(false, "Exception: ${e.stackTraceToString()}")
            }
        }
    }
}

