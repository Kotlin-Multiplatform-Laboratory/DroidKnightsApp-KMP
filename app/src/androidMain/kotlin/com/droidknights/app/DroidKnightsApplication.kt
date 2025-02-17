package com.droidknights.app

import android.app.Application
import com.droidknights.app.core.data.di.ApiModule
import com.droidknights.app.core.data.di.DataModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.ksp.generated.module

class DroidKnightsApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@DroidKnightsApplication)
            androidLogger()
            modules(
                ApiModule().module,
                DataModule().module,
            )
        }
    }
}
