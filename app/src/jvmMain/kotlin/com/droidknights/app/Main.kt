package com.droidknights.app

import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import org.jetbrains.compose.reload.DevelopmentEntryPoint
import java.awt.Color

fun main() {

    application {
        Window(
            onCloseRequest = ::exitApplication,
            alwaysOnTop = true,
            state = rememberWindowState(
                width = 600.dp, height = 800.dp, position = WindowPosition.Aligned(Alignment.TopEnd)
            )
        ) {
            window.background = Color.WHITE
            DevelopmentEntryPoint {
                App()
            }
        }
    }
}