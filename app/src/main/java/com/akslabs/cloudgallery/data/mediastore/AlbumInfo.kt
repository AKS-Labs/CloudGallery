package com.akslabs.cloudgallery.data.mediastore

/**
 * Represents a device album (folder) for the album chip bar.
 * Maps to the reference file's `Album` domain model.
 *
 * @param id      BUCKET_ID from MediaStore, or -1L for the synthetic "All" album
 * @param label   BUCKET_DISPLAY_NAME, or "All" for the synthetic entry
 * @param count   Number of photos in this album
 * @param coverUri URI of the most recent photo (used as thumbnail in expanded chips)
 */
data class AlbumInfo(
    val id: Long,
    val label: String,
    val count: Int,
    val coverUri: String
) {
    override fun toString(): String = "album_${id}_${label}"
}
