import com.droidknights.app.setNamespace

plugins {
    id("droidknights.kotlin.multiplatform")
    id("droidknights.compose.multiplatform")
    id("droidknights.kotlin.koin")
    id("droidknights.kotlin.serialization")
    id("droidknights.kotlin.ktorfit")
    id("kotlinx-serialization")
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.core.model)
            implementation(projects.core.datastore)
            implementation(projects.core.dataApi)
            implementation(libs.kotlinx.datetime)
            implementation(libs.kotlinx.serialization.json.okio)
            implementation(libs.okio)
            implementation(compose.components.resources)
        }
        commonTest.dependencies {
            implementation(libs.turbine)
        }
        androidMain.dependencies {
            implementation(libs.koin.android)
        }
        iosMain.dependencies {
            implementation(projects.core.model)
            implementation(projects.core.datastore)
            implementation(projects.core.dataApi)
        }
    }
}

android {
    setNamespace("core.data")
    sourceSets["main"].apply {
        assets.srcDirs("src/commonMain/resources/assets")
    }
}

ktorfit {
    kotlinVersion = "2.1.0"
}
