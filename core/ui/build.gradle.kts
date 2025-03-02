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
            implementation(compose.components.resources)
        }
    }
}

compose.resources {
    publicResClass = true
    packageOfResClass = "com.droidknights.app.resources"
    generateResClass = always
}

