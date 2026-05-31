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
import com.github.kotlintelegrambot.entities.ParseMode
import com.github.kotlintelegrambot.entities.TelegramFile
import com.github.kotlintelegrambot.entities.Update
import com.github.kotlintelegrambot.entities.files.Document
import com.github.kotlintelegrambot.entities.files.PhotoSize
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
            Log.d(TAG, "📤 sendFile: file=${file.name}, size=${file.length()}, channel=$channelId, captionLen=${caption?.length ?: 0}")
            if (!file.exists()) {
                Log.e(TAG, "❌ sendFile: File does not exist: ${file.absolutePath}")
                return@withContext Pair(null, java.io.FileNotFoundException("File not found: ${file.absolutePath}"))
            }
            if (channelId == 0L) {
                Log.e(TAG, "❌ sendFile: Invalid channel ID: $channelId")
                return@withContext Pair(null, IllegalArgumentException("Invalid channel ID: $channelId"))
            }
            try {
                val result = bot.sendDocument(
                    chatId = ChatId.fromId(channelId),
                    document = TelegramFile.ByFile(file),
                    caption = caption,
                    parseMode = ParseMode.HTML,
                    disableContentTypeDetection = true
                )
                val (response, error) = result
                if (error != null) {
                    Log.e(TAG, "❌ sendFile: API error", error)
                } else {
                    Log.d(TAG, "📤 sendFile: Response code=${response?.code()}, isSuccessful=${response?.isSuccessful}")
                }
                result
            } catch (e: Exception) {
                Log.e(TAG, "❌ sendFile: Exception during upload", e)
                Pair(null, e)
            }
        }
    }

    suspend fun sendPhoto(
        file: File,
        channelId: Long,
        caption: String? = null
    ): Pair<retrofit2.Response<Response<Message>?>?, Exception?> {
        return withContext(Dispatchers.IO) {
            Log.d(TAG, "📤 sendPhoto: file=${file.name}, size=${file.length()}, channel=$channelId")
            if (!file.exists()) {
                Log.e(TAG, "❌ sendPhoto: File does not exist: ${file.absolutePath}")
                return@withContext Pair(null, java.io.FileNotFoundException("File not found: ${file.absolutePath}"))
            }
            if (channelId == 0L) {
                Log.e(TAG, "❌ sendPhoto: Invalid channel ID: $channelId")
                return@withContext Pair(null, IllegalArgumentException("Invalid channel ID: $channelId"))
            }
            try {
                val result = bot.sendPhoto(
                    chatId = ChatId.fromId(channelId),
                    photo = TelegramFile.ByFile(file),
                    caption = caption,
                    parseMode = ParseMode.HTML
                )
                val (response, error) = result
                if (error != null) {
                    Log.e(TAG, "❌ sendPhoto: API error", error)
                } else {
                    Log.d(TAG, "📤 sendPhoto: Response code=${response?.code()}, isSuccessful=${response?.isSuccessful}")
                }
                result
            } catch (e: Exception) {
                Log.e(TAG, "❌ sendPhoto: Exception during upload", e)
                Pair(null, e)
            }
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
     * Get file metadata from Telegram (for individual file size lookups).
     * Returns the file size in bytes, or null if not available.
     */
    suspend fun getFileSize(fileId: String): Long? {
        return withContext(Dispatchers.IO) {
            try {
                val result = bot.getFile(fileId)
                val (response, error) = result
                if (error != null) {
                    Log.e(TAG, "Error getting file size for $fileId", error)
                    return@withContext null
                }
                response?.body()?.result?.fileSize?.toLong()
            } catch (e: Exception) {
                Log.e(TAG, "Error getting file size for $fileId", e)
                null
            }
        }
    }

    /**
     * Scan Telegram channel/chat for all media files (documents and photos)
     * Returns a list of discovered media files with their metadata
     */
    suspend fun scanChannelForMedia(
        channelId: Long,
        limit: Int = 100,
        offsetMessageId: Long? = null
    ): ChannelScanResult {
        return withContext(Dispatchers.IO) {
            try {
                Log.d(TAG, "=== SCANNING CHANNEL FOR MEDIA ===")
                Log.d(TAG, "Channel ID: $channelId, Limit: $limit, Offset: $offsetMessageId")

                val updates = bot.getUpdates(
                    offset = offsetMessageId,
                    limit = limit,
                    timeout = 30
                )

                val mediaFiles = mutableListOf<DiscoveredMediaFile>()
                var lastMessageId: Long? = null

                if (updates.isSuccess) {
                    val updateList = updates.get()
                    Log.i(TAG, "Received ${updateList.size} updates from Telegram")

                    updateList.forEach { update ->
                        update.message?.let { message ->
                            // Only process messages from the target channel
                            if (message.chat.id == channelId) {
                                lastMessageId = message.messageId.toLong()

                                // Check for document attachments
                                message.document?.let { document ->
                                    val mediaFile = DiscoveredMediaFile(
                                        fileId = document.fileId,
                                        fileName = document.fileName,
                                        fileSize = document.fileSize?.toLong(),
                                        mimeType = document.mimeType,
                                        uploadDate = message.date * 1000L,
                                        messageId = message.messageId.toInt(),
                                        mediaType = MediaType.DOCUMENT
                                    )
                                    mediaFiles.add(mediaFile)
                                    Log.d(TAG, "Found document: ${document.fileName} (${document.fileId})")
                                }

                                // Check for photo attachments
                                message.photo?.let { photos ->
                                    val largestPhoto = photos.maxByOrNull { it.fileSize ?: 0 }
                                    largestPhoto?.let { photo ->
                                        val mediaFile = DiscoveredMediaFile(
                                            fileId = photo.fileId,
                                            fileName = "photo_${message.messageId}.jpg",
                                            fileSize = photo.fileSize?.toLong(),
                                            mimeType = "image/jpeg",
                                            uploadDate = message.date * 1000L,
                                            messageId = message.messageId.toInt(),
                                            mediaType = MediaType.PHOTO
                                        )
                                        mediaFiles.add(mediaFile)
                                        Log.d(TAG, "Found photo: ${photo.fileId}")
                                    }
                                }
                            }
                        }
                    }

                    Log.i(TAG, "Scan complete: Found ${mediaFiles.size} media files")
                    ChannelScanResult.Success(
                        mediaFiles = mediaFiles,
                        hasMore = updateList.size == limit,
                        nextOffset = lastMessageId?.plus(1)
                    )
                } else {
                    Log.e(TAG, "Failed to get updates from Telegram")
                    ChannelScanResult.Error("Failed to fetch updates from Telegram")
                }
            } catch (e: Exception) {
                Log.e(TAG, "Exception during channel scan", e)
                ChannelScanResult.Error("Exception during channel scan: ${e.message}")
            }
        }
    }
}
