package com.droidknights.app.core.data.file

import android.content.Context
import okio.buffer
import okio.source
import org.koin.mp.KoinPlatformTools

actual val defaultAssetFileProvider: AssetFileProvider = AssetFileProvider {
    KoinPlatformTools.defaultContext()
        .get()
        .get<Context>()
        .assets
        .open(it.removePrefix("assets/"))
        .source()
        .buffer()
}