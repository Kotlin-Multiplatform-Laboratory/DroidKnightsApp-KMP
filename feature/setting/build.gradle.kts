import com.droidknights.app.setNamespace

plugins {
    id("droidknights.kotlin.multiplatform")
    id("droidknights.compose.multiplatform")
}

android {
    setNamespace("feature.setting")
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.core.designsystem)
            implementation(projects.core.navigation)
            implementation(libs.landscapist.coil3)
            implementation(libs.landscapist.placeholder)
            implementation(libs.compose.navigation)
        }
        androidMain.dependencies {
            implementation(libs.androidx.appcompat)
            implementation(libs.oss.licenses)
        }
    }
}
