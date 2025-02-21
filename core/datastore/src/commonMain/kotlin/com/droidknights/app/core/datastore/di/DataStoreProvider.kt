package com.droidknights.app.core.datastore.di

import androidx.datastore.core.DataMigration
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import okio.Path.Companion.toPath
import org.koin.core.annotation.Single

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
@Single
expect class DataStoreProvider() {
    fun getDataStore(name: String): DataStore<Preferences>
}

internal const val SETTINGS_PREFERENCES_NAME = "SETTINGS_PREFERENCES.preferences_pb"
internal const val SESSION_PREFERENCES_NAME = "SESSION_PREFERENCES.preferences_pb"

internal fun createDataStoreWithDefaults(
    migrations: List<DataMigration<Preferences>> = emptyList(),
    producePath: () -> String,
) = PreferenceDataStoreFactory
    .createWithPath(
        corruptionHandler = null,
        migrations = migrations,
        produceFile = {
            producePath().toPath()
        }
    )
