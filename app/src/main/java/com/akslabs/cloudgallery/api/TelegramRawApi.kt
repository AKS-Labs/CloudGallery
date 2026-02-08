package com.akslabs.cloudgallery.api

import com.akslabs.cloudgallery.data.localdb.Preferences
import com.akslabs.cloudgallery.utils.Constants
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Minimal, lenient Telegram Bot API client for validation-only calls.
 * We purposefully map only fields we need so unknown fields like pinned_message
 * don't break deserialization.
 */
interface TelegramRawApi {
    @GET("getChat")
    suspend fun getChat(@Query("chat_id") chatId: Long): TelegramResponse<ChatMinimal>

    data class TelegramResponse<T>(
        val ok: Boolean,
        val result: T?
    )
    data class ChatMinimal(
        val id: Long,
        val type: String?
    )

    companion object {
        fun create(): TelegramRawApi {
            val token = Preferences.getEncryptedString(Preferences.botToken, Constants.SAMPLE_API_KEY)
            val baseUrl = "https://api.telegram.org/bot${token}/"
            val retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(TelegramRawApi::class.java)
        }
    }
}

