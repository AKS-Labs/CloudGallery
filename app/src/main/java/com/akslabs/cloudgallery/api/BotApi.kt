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
import com.github.kotlintelegrambot.entities.ReplyParameters
import com.github.kotlintelegrambot.entities.TelegramFile
import com.github.kotlintelegrambot.entities.Update
import com.github.kotlintelegrambot.entities.files.Document
import com.github.kotlintelegrambot.entities.files.PhotoSize
import com.github.kotlintelegrambot.network.Response
import com.github.kotlintelegrambot.types.TelegramBotResult
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.File
import java.io.IOException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MultipartBody
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody

/**
 * The remote API module of the project.
 * Exposes functions to upload and download files.
 */
object BotApi {
    private const val TAG = "BotApi"
    private lateinit var bot: Bot
    var chatId: Long? = null

    /** In-memory cache of topic name → messageThreadId to avoid re-creating topics. */
    val topicCache = java.util.concurrent.ConcurrentHashMap<String, Long>()

    /** Remove a topic from cache (e.g. after a failed upload to that topic). */
    fun removeTopicFromCache(topicName: String?) {
        if (topicName != null) {
            topicCache.remove(topicName)
            Log.w(TAG, "Removed topic '$topicName' from cache due to upload failure")
        }
    }

    private val httpClient: okhttp3.OkHttpClient by lazy {
        okhttp3.OkHttpClient.Builder()
            .connectTimeout(60, java.util.concurrent.TimeUnit.SECONDS)
            .readTimeout(60, java.util.concurrent.TimeUnit.SECONDS)
            .writeTimeout(120, java.util.concurrent.TimeUnit.SECONDS)
            .build()
    }

    private val gson: Gson = Gson()

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
        caption: String? = null,
        replyToMessageId: Long? = null,
        messageThreadId: Long? = null
    ): Pair<retrofit2.Response<Response<Message>?>?, Exception?> {
        if (!file.exists()) {
            Log.e(TAG, "❌ sendFile: File does not exist: ${file.absolutePath}")
            return Pair(null, java.io.FileNotFoundException("File not found: ${file.absolutePath}"))
        }
        if (channelId == 0L) {
            Log.e(TAG, "❌ sendFile: Invalid channel ID: $channelId")
            return Pair(null, IllegalArgumentException("Invalid channel ID: $channelId"))
        }
        return withContext(Dispatchers.IO) {
            try {
                if (messageThreadId != null) {
                    sendDocumentMultipart(file, channelId, caption, replyToMessageId, messageThreadId)
                } else {
                    val replyParams = replyToMessageId?.let { ReplyParameters(messageId = it) }
                    bot.sendDocument(
                        chatId = ChatId.fromId(channelId),
                        document = TelegramFile.ByFile(file),
                        caption = caption,
                        parseMode = ParseMode.HTML,
                        disableContentTypeDetection = true,
                        replyParameters = replyParams
                    )
                }
            } catch (e: Exception) {
                Log.e(TAG, "❌ sendFile: Exception during upload", e)
                Pair(null, e)
            }
        }
    }

    /**
     * Sends a file as a document to a forum topic using a direct HTTP multipart call.
     * Uses sendDocument (not sendPhoto) so original file quality is preserved.
     */
    private suspend fun sendDocumentMultipart(
        file: File,
        channelId: Long,
        caption: String?,
        replyToMessageId: Long?,
        messageThreadId: Long
    ): Pair<retrofit2.Response<Response<Message>?>?, Exception?> {
        return withContext(Dispatchers.IO) {
            try {
                val token = Preferences.getEncryptedString(Preferences.botToken, SAMPLE_API_KEY)
                val url = "https://api.telegram.org/bot${token}/sendDocument"

                val mediaType = "application/octet-stream".toMediaType()
                val fileRequestBody = okhttp3.RequestBody.create(mediaType, file)
                val bodyBuilder = MultipartBody.Builder()
                    .setType(MultipartBody.FORM)
                    .addFormDataPart("chat_id", channelId.toString())
                    .addFormDataPart("message_thread_id", messageThreadId.toString())
                    .addFormDataPart("document", file.name, fileRequestBody)

                if (caption != null) {
                    bodyBuilder.addFormDataPart("caption", caption)
                    bodyBuilder.addFormDataPart("parse_mode", "HTML")
                }

                if (replyToMessageId != null) {
                    bodyBuilder.addFormDataPart("reply_parameters", """{"message_id":$replyToMessageId}""")
                }

                bodyBuilder.addFormDataPart("disable_content_type_detection", "true")

                val request = Request.Builder()
                    .url(url)
                    .post(bodyBuilder.build())
                    .build()

                val okResponse = httpClient.newCall(request).execute()
                val bodyString = okResponse.body?.string()

                if (!okResponse.isSuccessful) {
                    Log.e(TAG, "❌ sendDocumentMultipart: HTTP ${okResponse.code}: $bodyString")
                    val errorBody = okResponse.body?.let {
                        okhttp3.ResponseBody.create("application/json".toMediaType(), bodyString ?: "")
                    }
                    val retrofitResponse = retrofit2.Response.error<Response<Message>?>(
                        okResponse.code,
                        errorBody ?: okhttp3.ResponseBody.create("application/json".toMediaType(), """{"ok":false,"description":"HTTP ${okResponse.code}"}""")
                    )
                    return@withContext Pair(retrofitResponse, null)
                }

                val type = object : TypeToken<Response<Message>>() {}.type
                val apiResponse = gson.fromJson<Response<Message>>(bodyString, type)
                @Suppress("UNCHECKED_CAST")
                val retrofitResponse = retrofit2.Response.success<Response<Message>?>(apiResponse as Response<Message>?)
                Pair(retrofitResponse, null)
            } catch (e: Exception) {
                Log.e(TAG, "❌ sendDocumentMultipart: Exception", e)
                Pair(null, e)
            }
        }
    }

    suspend fun sendPhoto(
        file: File,
        channelId: Long,
        caption: String? = null,
        replyToMessageId: Long? = null,
        messageThreadId: Long? = null
    ): Pair<retrofit2.Response<Response<Message>?>?, Exception?> {
        if (!file.exists()) {
            Log.e(TAG, "❌ sendPhoto: File does not exist: ${file.absolutePath}")
            return Pair(null, java.io.FileNotFoundException("File not found: ${file.absolutePath}"))
        }
        if (channelId == 0L) {
            Log.e(TAG, "❌ sendPhoto: Invalid channel ID: $channelId")
            return Pair(null, IllegalArgumentException("Invalid channel ID: $channelId"))
        }
        return withContext(Dispatchers.IO) {
            try {
                bot.sendPhoto(
                    chatId = ChatId.fromId(channelId),
                    photo = TelegramFile.ByFile(file),
                    caption = caption,
                    parseMode = ParseMode.HTML,
                    replyParameters = replyToMessageId?.let { ReplyParameters(messageId = it) },
                    messageThreadId = messageThreadId
                )
            } catch (e: Exception) {
                Log.e(TAG, "❌ sendPhoto: Exception during upload", e)
                Pair(null, e)
            }
        }
    }

    suspend fun createForumTopic(
        chatId: Long,
        name: String
    ): Long? {
        return withContext(Dispatchers.IO) {
            val displayName = "$name"
            try {
                Log.d(TAG, "📋 Creating forum topic '$displayName' in chat $chatId")
                val result = bot.createForumTopic(
                    chatId = ChatId.fromId(chatId),
                    name = displayName
                )
                result.fold(
                    ifSuccess = { topic ->
                        Log.d(TAG, "✅ Forum topic '$displayName' created: messageThreadId=${topic.messageThreadId}")
                        topic.messageThreadId
                    },
                    ifError = { err ->
                        val msg = err.toString()
                        when {
                            msg.contains("401") || msg.contains("Unauthorized") ->
                                Log.e(TAG, "❌ Bot unauthorized for chat $chatId — check bot token and ensure bot is admin in the group")
                            msg.contains("TOPICS_NOT_ENABLED") || msg.contains("can't create topic") ->
                                Log.w(TAG, "⚠️ Forum topics not enabled in chat $chatId — photos will upload to General topic")
                            else ->
                                Log.w(TAG, "⚠️ Failed to create forum topic '$displayName': $msg")
                        }
                        null
                    }
                )
            } catch (e: Exception) {
                Log.e(TAG, "❌ Exception creating forum topic '$displayName'", e)
                null
            }
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

    suspend fun getFile(fileId: String): ByteArray? {
        return withContext(Dispatchers.IO) {
            bot.downloadFileBytes(fileId)
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
                            if (message.chat.id == channelId) {
                                lastMessageId = message.messageId.toLong()

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
