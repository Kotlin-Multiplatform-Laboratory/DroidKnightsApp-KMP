package com.droidknights.app.core.datastore.di

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.annotation.Named
import org.koin.core.annotation.Single

@Module
@ComponentScan("com.droidknights.app.core.datastore")
class DataStoreModule {
    val dataStoreProvider = DataStoreProvider()

    @Single
    @Named("setting")
    fun provideSettingsDataStore(): DataStore<Preferences> =
        dataStoreProvider.getDataStore(SETTINGS_PREFERENCES_NAME)

    @Single
    @Named("session")
    fun provideSessionDataStore(): DataStore<Preferences> =
        dataStoreProvider.getDataStore(SESSION_PREFERENCES_NAME)
}