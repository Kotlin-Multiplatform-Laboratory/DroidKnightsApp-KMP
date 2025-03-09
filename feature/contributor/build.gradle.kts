import com.droidknights.app.kotlin
import com.droidknights.app.setNamespace

plugins {
    id("droidknights.kotlin.multiplatform")
    id("droidknights.compose.multiplatform")
    id("droidknights.kotlin.koin")
}

android {
    setNamespace("feature.contributor")
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.core.model)
            implementation(projects.core.designsystem)
            implementation(projects.core.domain)
            implementation(projects.core.navigation)

            implementation(libs.compose.shimmer)
            implementation(libs.kotlinx.immutable)
        }
    }
}
