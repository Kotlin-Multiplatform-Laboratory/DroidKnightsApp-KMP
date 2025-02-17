package com.droidknights.app.core.datastore.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.annotation.Named
import org.koin.core.annotation.Single

@Module
@ComponentScan
object DataStoreModule {

    private const val SETTING_DATASTORE_NAME = "SETTINGS_PREFERENCES"

    private val Context.settingDataStore by preferencesDataStore(SETTING_DATASTORE_NAME)

    private const val SESSION_DATASTORE_NAME = "SESSION_PREFERENCES"

    private val Context.sessionDataStore by preferencesDataStore(SESSION_DATASTORE_NAME)

    @Single
    @Named("setting")
    fun provideSettingsDataStore(
        context: Context,
    ): DataStore<Preferences> =
        context.settingDataStore

    @Single
    @Named("session")
    fun provideSessionDataStore(
        context: Context,
    ): DataStore<Preferences> =
        context.sessionDataStore
}
