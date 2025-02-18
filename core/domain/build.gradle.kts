import com.droidknights.app.setNamespace

plugins {
    id("droidknights.kotlin.multiplatform")
    id("droidknights.kotlin.koin")
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.core.dataApi)
            implementation(projects.core.model)
        }
    }
}

android {
    setNamespace("core.domain")
}
