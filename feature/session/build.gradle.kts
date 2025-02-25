import com.droidknights.app.setNamespace

plugins {
    id("droidknights.kotlin.multiplatform")
    id("droidknights.compose.multiplatform")
}

android {
    setNamespace("feature.session")
}

kotlin {
    sourceSets {
        androidMain.dependencies {
            implementation(projects.core.model)
            implementation(projects.core.data)
            implementation(projects.core.designsystem)
            implementation(projects.core.domain)
            implementation(projects.core.navigation)
            implementation(projects.core.ui)
            implementation(projects.widget)
        }
        commonMain.dependencies {
            implementation(projects.core.model)

            implementation(libs.kotlinx.immutable)
        }
        iosMain.dependencies {

        }
    }
}
