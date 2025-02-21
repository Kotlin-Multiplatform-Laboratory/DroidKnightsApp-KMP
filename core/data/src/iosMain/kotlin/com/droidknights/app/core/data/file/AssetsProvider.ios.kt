package com.droidknights.app.core.data.file

import okio.FileSystem
import okio.Path.Companion.toPath
import okio.buffer
import platform.Foundation.NSBundle

actual val defaultAssetFileProvider: AssetFileProvider = AssetFileProvider { path ->
    val assetFile = NSBundle.mainBundle.resourcePath + "/compose-resources/" + path
    FileSystem.SYSTEM.source(assetFile.toPath()).buffer()
}