import com.droidknights.app.setNamespace

plugins {
    id("droidknights.kotlin.multiplatform")
    id("droidknights.compose.multiplatform")
    id("droidknights.kotlin.koin")
}

android {
    setNamespace("feature.main")

    defaultConfig {
        testInstrumentationRunner =
            "com.droidknights.app.core.testing.runner.DroidKnightsTestRunner"
    }
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.feature.home)
            implementation(projects.feature.setting)
            implementation(projects.feature.contributor)
            implementation(projects.feature.session)
            implementation(projects.feature.bookmark)
            implementation(projects.core.dataApi)
            implementation(projects.core.data)
            implementation(projects.core.navigation)
            implementation(projects.core.designsystem)
            implementation(projects.core.model)

            implementation(libs.compose.shimmer)
            implementation(libs.compose.navigation)
            implementation(libs.kotlinx.immutable)
        }

        androidMain.dependencies {
            implementation(libs.androidx.appcompat)
            implementation(libs.androidx.activity.compose)
            implementation(libs.androidx.lifecycle.runtimeCompose)
            implementation(libs.androidx.lifecycle.viewModelCompose)
            implementation(libs.androidx.core.ktx)
        }

        androidInstrumentedTest {
            dependencies {
                implementation(projects.core.testing)
            }
        }
    }
}

dependencies {
    debugImplementation(projects.core.uiTestHiltManifest)
    androidTestImplementation(libs.hilt.android.testing)
    kspAndroidTest(libs.hilt.android.compiler)
}
