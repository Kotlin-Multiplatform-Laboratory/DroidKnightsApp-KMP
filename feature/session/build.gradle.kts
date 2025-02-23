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
        commonMain.dependencies {
            implementation(libs.kotlinx.immutable)
        }
        androidMain.dependencies {
            implementation(project(":core:model"))
            implementation(project(":core:data"))
            implementation(project(":core:designsystem"))
            implementation(project(":core:domain"))
            implementation(project(":core:navigation"))
            implementation(project(":core:ui"))

            implementation(projects.widget)
        }
        iosMain.dependencies {

        }
    }
}
