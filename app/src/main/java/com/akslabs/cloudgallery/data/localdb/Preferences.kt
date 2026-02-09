package com.akslabs.cloudgallery.data.localdb

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys

@Suppress("ktlint:standard:property-naming")
object Preferences {

    // encrypted preferences
    const val botToken: String = "botToken"
    const val channelId: String = "channelId"

    // non-encrypted preferences
    const val startTabKey: String = "startTab"
    const val gridColumnCountKey: String = "gridColumnCount"
    const val isAutoBackupEnabledKey: String = "isPeriodicPhotoBackupEnabled"
    const val isAutoCloudBackupEnabledKey: String = "isAutoCloudBackupEnabled"
    const val autoBackupIntervalKey: String = "periodicPhotoBackupInterval"
    const val autoBackupNetworkTypeKey: String = "periodicPhotoBackupNetworkType"
    const val isAutoExportDatabaseEnabledKey: String = "isAutoExportDatabaseEnabled"
    const val autoExportDatabaseIntervalKey: String = "autoExportDatabaseInterval"
    const val autoExportDatabseLocation: String = "autoExportDatabaseLocation"
    const val defaultAutoExportDatabaseIntervalKey: Long = 7
    const val defaultAutoBackupInterval: Long = 7
    const val defaultGridColumnCount: Int = 4
    const val glideSelectionBehaviorKey: String = "glideSelectionBehavior"
    const val thumbnailResolutionKey: String = "thumbnailResolution"
    const val defaultThumbnailResolution: Int = 150

    private const val prefFile: String = "preferences"
    private const val encryptedPrefFile: String = "encryptedPreferences"
    private lateinit var preferences: SharedPreferences
    private lateinit var encryptedPreferences: SharedPreferences

    private val observableStringPreferences = mutableMapOf<String, MutableStateFlow<String>>()
    private lateinit var preferenceChangeListener: SharedPreferences.OnSharedPreferenceChangeListener

    fun init(context: Context) {
        try {
            preferences = context.getSharedPreferences(prefFile, Context.MODE_PRIVATE)
            val keyGenParameterSpec = MasterKeys.AES256_GCM_SPEC
            val masterKeyAlias = MasterKeys.getOrCreate(keyGenParameterSpec)
            encryptedPreferences = EncryptedSharedPreferences.create(
                encryptedPrefFile,
                masterKeyAlias,
                context,
                EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
                EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
            )
            migrateToEncrypted(preferences.all.filterKeys { it == botToken || it == channelId })

            // Initialize StateFlows with current values for observable keys
            observableStringPreferences[glideSelectionBehaviorKey] = MutableStateFlow(getString(glideSelectionBehaviorKey, "Fixed"))

            // Register a listener for SharedPreferences changes to update StateFlows
            // Store the listener reference to prevent garbage collection
            preferenceChangeListener = SharedPreferences.OnSharedPreferenceChangeListener { sharedPreferences, key ->
                when (key) {
                    glideSelectionBehaviorKey -> {
                        // Use the correct default value when updating the flow
                        val newValue = sharedPreferences.getString(key, "Fixed") ?: "Fixed"
                        observableStringPreferences[key]?.update { newValue }
                    }
                    // Handle other observable keys here if needed
                }
            }
            preferences.registerOnSharedPreferenceChangeListener(preferenceChangeListener)

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun getBoolean(key: String, defValue: Boolean) = preferences.getBoolean(key, defValue)
    fun getString(key: String, defValue: String) = preferences.getString(key, defValue) ?: defValue
    fun getFloat(key: String, defValue: Float) = preferences.getFloat(key, defValue)
    fun getLong(key: String, defValue: Long): Long {
        return try {
            preferences.getLong(key, defValue)
        } catch (e: ClassCastException) {
            try {
                val stringValue = preferences.getString(key, null)
                val longValue = stringValue?.toLongOrNull()
                if (longValue != null) {
                    // Fix the preference type
                    edit { putLong(key, longValue) }
                    longValue
                } else {
                    Log.e("Preferences", "Error getting long for key $key", e)
                    edit { remove(key) }
                    defValue
                }
            } catch (e2: Exception) {
                Log.e("Preferences", "Error recovering long for key $key", e2)
                edit { remove(key) }
                defValue
            }
        }
    }
    fun getInt(key: String, defValue: Int) = preferences.getInt(key, defValue)
    fun getStringSet(key: String, defValue: Set<String>) =
        preferences.getStringSet(key, defValue) ?: defValue

    fun getStringFlow(key: String, defValue: String): StateFlow<String> {
        // Ensure the flow is initialized. If not, create it and populate with current value.
        // This handles cases where a flow might be requested before init() or for a new key.
        return observableStringPreferences.getOrPut(key) {
            MutableStateFlow(getString(key, defValue))
        }.asStateFlow()
    }

    fun edit(action: SharedPreferences.Editor.() -> Unit) {
        preferences.edit().apply(action).apply()
    }

    fun getEncryptedBoolean(key: String, defValue: Boolean) = encryptedPreferences.getBoolean(key, defValue)
    fun getEncryptedString(key: String, defValue: String) = encryptedPreferences.getString(key, defValue) ?: defValue
    fun getEncryptedFloat(key: String, defValue: Float) = encryptedPreferences.getFloat(key, defValue)
    fun getEncryptedLong(key: String, defValue: Long) = encryptedPreferences.getLong(key, defValue)
    fun getEncryptedStringSet(key: String, defValue: Set<String>) =
        encryptedPreferences.getStringSet(key, defValue) ?: defValue

    fun editEncrypted(action: SharedPreferences.Editor.() -> Unit) {
        encryptedPreferences.edit().apply(action).apply()
    }

    fun migrateAllToEncrypted(context: Context) {
        if (preferences.all.isNotEmpty()) {
            migrateToEncrypted(preferences.all)
        }
    }

    private fun migrateToEncrypted(keys: Map<String, *>) {
        for ((key, value1) in keys) {
            val value = value1!!
            Log.d("map values", "$key: $value")
            when (value) {
                is Int -> {
                    editEncrypted { putInt(key, value) }
                    edit { remove(key) }
                }

                is Boolean -> {
                    editEncrypted { putBoolean(key, value) }
                    edit { remove(key) }
                }

                is Long -> {
                    editEncrypted { putLong(key, value) }
                    edit { remove(key) }
                }

                is Float -> {
                    editEncrypted { putFloat(key, value) }
                    edit { remove(key) }
                }

                else -> {
                    editEncrypted { putString(key, value.toString()) }
                    edit { remove(key) }
                }
            }
        }
    }
}
