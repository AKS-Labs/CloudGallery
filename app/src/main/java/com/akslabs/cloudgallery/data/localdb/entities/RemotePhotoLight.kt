package com.akslabs.cloudgallery.data.localdb.entities

/**
 * Lightweight projection of RemotePhoto — excludes thumbnailBytes BLOB.
 * Used for grid listing where we don't need the actual thumbnail bytes
 * (Coil loads them separately via LocalThumbnailFetcher).
 */
data class RemotePhotoLight(
    val remoteId: String,
    val photoType: String,
    val fileName: String? = null,
    val fileSize: Long? = null,
    val uploadedAt: Long = 0L,
    val thumbnailCached: Boolean = false,
    val messageId: Long? = null,
    val uploadType: String? = null,
    val thumbFileId: String? = null,
    val thumbSynced: Boolean = false,
    val dateTaken: String? = null,
    val personIds: String? = null,
    val placeId: Int? = null,
    val placeName: String? = null,
) {
    fun toRemotePhoto(): RemotePhoto = RemotePhoto(
        remoteId = remoteId,
        photoType = photoType,
        fileName = fileName,
        fileSize = fileSize,
        uploadedAt = uploadedAt,
        thumbnailCached = thumbnailCached,
        messageId = messageId,
        uploadType = uploadType,
        thumbFileId = thumbFileId,
        thumbSynced = thumbSynced,
        dateTaken = dateTaken,
        personIds = personIds,
        placeId = placeId,
        placeName = placeName,
    )
}
