import com.droidknights.app.setNamespace

plugins {
    id("droidknights.kotlin.multiplatform")
    id("droidknights.compose.multiplatform")
    id("droidknights.kotlin.koin")
}

android {
    setNamespace("feature.home")
}

kotlin {
    sourceSets {
        androidMain.dependencies {
            implementation(libs.kotlinx.immutable)
            implementation(libs.compose.shimmer)
        }
        commonMain.dependencies {
            implementation(projects.core.domain)
            implementation(projects.core.navigation)
            implementation(projects.core.designsystem)

            implementation(libs.kotlinx.immutable)
            implementation(libs.compose.shimmer)
        }
    }
}
