package com.akslabs.cloudgallery.utils

/**
 * Configuration object for metadata upload feature
 */
object MetadataConfig {
    
    /**
     * Whether to include metadata as captions when uploading images
     * This can be controlled via app settings
     */
    const val INCLUDE_METADATA_DEFAULT = true
    
    /**
     * Maximum length for metadata caption (Telegram limit is 1024)
     */
    const val MAX_CAPTION_LENGTH = 1000
    
    /**
     * Check if metadata should be included based on preferences
     */
    fun shouldIncludeMetadata(): Boolean {
        return com.akslabs.cloudgallery.data.localdb.Preferences.getBoolean(
            "include_metadata_in_upload",
            INCLUDE_METADATA_DEFAULT
        )
    }
    
    /**
     * Toggle metadata inclusion setting
     */
    fun setIncludeMetadata(include: Boolean) {
        com.akslabs.cloudgallery.data.localdb.Preferences.edit {
            putBoolean("include_metadata_in_upload", include)
        }
    }
}