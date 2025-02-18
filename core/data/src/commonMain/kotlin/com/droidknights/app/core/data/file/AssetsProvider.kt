package com.droidknights.app.core.data.file

import okio.BufferedSource

expect val defaultAssetFileProvider: AssetFileProvider

fun interface AssetFileProvider {
    fun get(path: String): BufferedSource
}