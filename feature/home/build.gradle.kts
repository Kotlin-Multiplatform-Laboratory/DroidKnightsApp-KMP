import com.droidknights.app.setNamespace

plugins {
    id("droidknights.kotlin.multiplatform")
    id("droidknights.compose.multiplatform")
    id("droidknights.kotlin.koin")
    id("droidknights.kotlin.kotest")
}

android {
    setNamespace("feature.home")
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.core.domain)
            implementation(projects.core.navigation)
            implementation(projects.core.designsystem)
            implementation(projects.core.model)

            implementation(libs.compose.shimmer)
        }
        commonTest.dependencies {
            implementation(projects.core.dataApi)
            implementation(libs.coroutines.test)
            implementation(libs.turbine)
        }
        androidUnitTest.dependencies {
            implementation(libs.kotest.runner.junit5)
        }
    }
}