package com.akslabs.cloudgallery.api

import com.akslabs.cloudgallery.data.localdb.Preferences

/**
 * Server configuration for the CloudGallery thumbnail server.
 * Stores the server URL in SharedPreferences so the user can change it.
 */
object ServerConfig {
    private const val SERVER_URL_KEY = "server_url"
    private const val SERVER_ENABLED_KEY = "server_enabled"
    private const val DEFAULT_SERVER_URL = "http://192.168.1.188:8100"

    fun getServerUrl(): String {
        return Preferences.getString(SERVER_URL_KEY, DEFAULT_SERVER_URL)
    }

    fun setServerUrl(url: String) {
        Preferences.edit { putString(SERVER_URL_KEY, url.trimEnd('/')) }
    }

    fun isServerEnabled(): Boolean {
        return Preferences.getBoolean(SERVER_ENABLED_KEY, true)
    }

    fun setServerEnabled(enabled: Boolean) {
        Preferences.edit { putBoolean(SERVER_ENABLED_KEY, enabled) }
    }

    fun isServerConfigured(): Boolean {
        return getServerUrl().isNotBlank()
    }
}
