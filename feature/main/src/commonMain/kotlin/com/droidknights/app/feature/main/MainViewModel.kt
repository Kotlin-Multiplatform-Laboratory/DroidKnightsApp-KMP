package com.droidknights.app.feature.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.droidknights.app.core.data.repository.api.SettingsRepository
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class MainViewModel(
    private val settingsRepository: SettingsRepository,
) : ViewModel() {

    val isDarkTheme = settingsRepository.flowIsDarkTheme()

    fun updateIsDarkTheme(isDarkTheme: Boolean) =
        viewModelScope.launch {
            settingsRepository.updateIsDarkTheme(isDarkTheme)
        }
}
