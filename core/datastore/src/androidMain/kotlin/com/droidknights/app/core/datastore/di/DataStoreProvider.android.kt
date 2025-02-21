package com.droidknights.app.core.datastore.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import org.koin.core.annotation.Single
import org.koin.java.KoinJavaComponent

@Single
@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual class DataStoreProvider actual constructor() {
    private val context: Context = KoinJavaComponent.getKoin().get()

    actual fun getDataStore(name: String): DataStore<Preferences> {
        return createDataStoreWithDefaults(
            migrations = emptyList()
        ) {
            context.filesDir.resolve(name).absolutePath
        }
    }
}
