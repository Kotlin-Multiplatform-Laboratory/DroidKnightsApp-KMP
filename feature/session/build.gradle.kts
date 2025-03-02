import com.droidknights.app.setNamespace

plugins {
    id("droidknights.kotlin.multiplatform")
    id("droidknights.compose.multiplatform")
    id("droidknights.kotlin.koin")
}

android {
    setNamespace("feature.session")
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.core.model)
            implementation(projects.core.designsystem)
            implementation(projects.core.domain)
            implementation(projects.core.navigation)
            implementation(projects.core.ui)

            implementation(compose.components.resources)
            implementation(libs.kotlinx.immutable)
            implementation(libs.compose.navigation)
        }
    }
}
