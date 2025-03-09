package com.droidknights.app

import androidx.compose.runtime.Composable
import com.droidknights.app.core.designsystem.theme.KnightsTheme
import com.droidknights.app.feature.main.MainScreen

@Composable
internal fun App() = KnightsTheme {
    MainScreen()
}
