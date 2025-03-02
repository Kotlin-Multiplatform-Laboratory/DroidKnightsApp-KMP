import com.droidknights.app.setNamespace

plugins {
    id("droidknights.kotlin.multiplatform")
    id("droidknights.compose.multiplatform")
}

android {
    setNamespace("core.ui")
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.core.model)
            implementation(projects.core.designsystem)
            implementation(libs.compose.component.resource)
        }
    }
}

compose.resources {
    publicResClass = true
    packageOfResClass = "com.droidknights.app.resources"
    generateResClass = always
}

