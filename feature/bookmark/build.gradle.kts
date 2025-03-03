import com.droidknights.app.kotlin
import com.droidknights.app.setNamespace

plugins {
    id("droidknights.kotlin.multiplatform")
    id("droidknights.compose.multiplatform")
    id("droidknights.kotlin.koin")
}

android {
    setNamespace("feature.bookmark")
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.core.designsystem)
            implementation(projects.core.domain)
            implementation(projects.core.model)
            implementation(projects.core.navigation)
            implementation(projects.core.ui)

            implementation(libs.kotlinx.immutable)
        }
    }
}
