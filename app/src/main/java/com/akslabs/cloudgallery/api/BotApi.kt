package com.akslabs.cloudgallery.api

import android.util.Log
import com.akslabs.cloudgallery.data.localdb.Preferences
import com.akslabs.cloudgallery.utils.Constants.SAMPLE_API_KEY
import com.github.kotlintelegrambot.Bot
import com.github.kotlintelegrambot.bot
import com.github.kotlintelegrambot.dispatch
import com.github.kotlintelegrambot.dispatcher.command
import com.github.kotlintelegrambot.entities.ChatId
import com.github.kotlintelegrambot.entities.Message
import com.github.kotlintelegrambot.entities.TelegramFile
import com.github.kotlintelegrambot.network.Response
import java.io.File
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * The remote API module of the project.
 * Exposes functions to upload and download files.
 */
object BotApi {
    private const val TAG = "BotApi"
    private lateinit var bot: Bot
    var chatId: Long? = null

    fun create() {
        bot = bot {
            token = Preferences.getEncryptedString(
                Preferences.botToken,
                SAMPLE_API_KEY
            )
            dispatch {
                command("start") {
                    chatId = message.chat.id
                    chatId?.let { id ->
                        // Store chat ID in preferences for historical sync
                        Preferences.edit {
                            putString("telegram_chat_id", id.toString())
                        }
                        Log.i(TAG, "Chat ID stored: $id")

                        val result = bot.sendMessage(
                            chatId = ChatId.fromId(id),
                            text = chatId.toString()
                        )
                    }
                }
            }
        }
    }

    fun startPolling() {
        bot.startPolling()
    }

    fun stopPolling() {
        bot.stopPolling()
    }

    suspend fun getChat(chatId: ChatId): Boolean {
        return withContext(Dispatchers.IO) {
            try {
                Log.i(TAG, "Attempting to get chat info for: $chatId")
                val result = bot.getChat(chatId)
                Log.i(TAG, "getChat result - isSuccess: ${result.isSuccess}")
                if (!result.isSuccess) {
                    Log.w(TAG, "getChat failed - result: $result")
                }
                result.isSuccess
            } catch (e: Exception) {
                Log.e(TAG, "Exception in getChat for $chatId", e)
                false
            }
        }
    }

    suspend fun sendFile(
        file: File,
        channelId: Long,
        caption: String? = null
    ): Pair<retrofit2.Response<Response<Message>?>?, Exception?> {
        return withContext(Dispatchers.IO) {
            bot.sendDocument(
                chatId = ChatId.fromId(channelId),
                document = TelegramFile.ByFile(file),
                caption = caption,
                disableContentTypeDetection = false
            )
        }
    }

    suspend fun getFile(fileId: String): ByteArray? {
        return withContext(Dispatchers.IO) {
            bot.downloadFileBytes(fileId)
        }
    }

    suspend fun deleteMessage(chatId: Long, messageId: Long): Boolean {
        return withContext(Dispatchers.IO) {
            try {
                val result = bot.deleteMessage(ChatId.fromId(chatId), messageId)
                result.isSuccess
            } catch (e: Exception) {
                Log.e(TAG, "Error deleting message $messageId from chat $chatId", e)
                false
            }
        }
    }

    /**
     * Scan for cloud photos by verifying known uploads.
     *
     * NOTE: The Telegram Bot API does NOT support reading channel message history.
     * `getUpdates()` only returns unprocessed incoming updates (24h window) and is
     * fundamentally wrong for channel scanning.  Instead we rely on upload-time
     * tracking: every successful upload already inserts into `remote_photos`.
     *
     * This method now returns an empty success result. Historical discovery from
     * the channel is not possible via Bot API — use the daily DB backup/restore
     * flow for the "reinstall" scenario.
     */
    suspend fun scanChannelForMedia(
        channelId: Long,
        limit: Int = 100,
        offsetMessageId: Long? = null
    ): ChannelScanResult {
        return withContext(Dispatchers.IO) {
            Log.i(TAG, "scanChannelForMedia called — Bot API cannot read channel history.")
            Log.i(TAG, "Cloud photo inventory is maintained at upload time. Returning empty result.")

            // Return empty success — the remote_photos table is the source of truth,
            // populated during each upload in sendFileApi().
            ChannelScanResult.Success(
                mediaFiles = emptyList(),
                hasMore = false,
                nextOffset = null
            )
        }
    }
}
