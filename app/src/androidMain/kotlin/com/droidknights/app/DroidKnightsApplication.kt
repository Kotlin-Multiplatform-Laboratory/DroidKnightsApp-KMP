package com.droidknights.app

import android.app.Application
import com.droidknights.app.core.data.di.ApiModule
import com.droidknights.app.core.data.di.FakeModule
import com.droidknights.app.core.domain.UseCaseModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.ksp.generated.module
import com.droidknights.app.core.datastore.di.DataStoreModule
import com.droidknights.app.feature.contributor.ContributorModule

class DroidKnightsApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@DroidKnightsApplication)
            androidLogger()
            modules(
                ApiModule().module,
                UseCaseModule().module,
                FakeModule().module,
                ContributorModule().module,
                DataStoreModule().module
            )
        }
    }
}
