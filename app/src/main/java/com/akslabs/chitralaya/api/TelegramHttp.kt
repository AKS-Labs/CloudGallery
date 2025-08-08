package com.akslabs.cloudgallery.api

import android.util.Log
import com.akslabs.cloudgallery.data.localdb.Preferences
import com.akslabs.cloudgallery.utils.Constants
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
     * Returns true if Telegram Bot API getChat(chat_id) returns ok=true with a result.id matching chatId
     */
    fun validateChat(chatId: Long): Boolean {
        return try {
            val token = Preferences.getEncryptedString(Preferences.botToken, Constants.SAMPLE_API_KEY)
            val url = "https://api.telegram.org/bot${token}/getChat?chat_id=${chatId}"
            val req = Request.Builder().url(url).get().build()
            client.newCall(req).execute().use { resp ->
                val body = resp.body?.string() ?: return false
                val json = JSONObject(body)
                val ok = json.optBoolean("ok", false)
                if (!ok) {
                    Log.w(TAG, "getChat returned ok=false: ${json.optInt("error_code")} ${json.optString("description")}")
                    return false
                }
                val result = json.optJSONObject("result") ?: return false
                val id = result.optLong("id", Long.MIN_VALUE)
                id == chatId
            }
        } catch (e: Exception) {
            Log.w(TAG, "validateChat failed", e)
            false
        }
    }
}

