package com.droidknights.app.feature.setting.navigation

import android.content.Context
import android.content.Intent
import com.google.android.gms.oss.licenses.OssLicensesMenuActivity
import org.koin.mp.KoinPlatformTools

actual fun navigateToOssLicense() {
    val context = KoinPlatformTools.defaultContext()
        .get()
        .get<Context>()
    context.startActivity(Intent(context, OssLicensesMenuActivity::class.java))
}