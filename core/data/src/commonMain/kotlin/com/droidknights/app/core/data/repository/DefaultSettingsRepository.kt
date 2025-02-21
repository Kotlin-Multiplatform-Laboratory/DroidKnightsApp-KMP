package com.droidknights.app.core.data.repository

import com.droidknights.app.core.data.repository.api.SettingsRepository
import com.droidknights.app.core.datastore.datasource.SettingsPreferencesDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.koin.core.annotation.Single

@Single(binds = [SettingsRepository::class])
class DefaultSettingsRepository(
    private val preferencesDataSource: SettingsPreferencesDataSource
) : SettingsRepository {

    override fun flowIsDarkTheme(): Flow<Boolean> =
        preferencesDataSource.settingsData.map { settingsData -> settingsData.isDarkTheme }

    override suspend fun updateIsDarkTheme(isDarkTheme: Boolean) {
        preferencesDataSource.updateIsDarkTheme(isDarkTheme)
    }
}
