import com.droidknights.app.setNamespace

plugins {
    id("droidknights.kotlin.multiplatform")
    id("droidknights.compose.multiplatform")
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
    }
}
