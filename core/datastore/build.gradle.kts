import com.droidknights.app.setNamespace

plugins {
    id("droidknights.kotlin.multiplatform")
    id("droidknights.compose.multiplatform")
    id("droidknights.kotlin.koin")
}

android {
    setNamespace("core.datastore")
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(libs.androidx.datastore.core.okio)
            implementation(libs.androidx.datastore.preferences.core)
        }
        androidUnitTest.dependencies {
            implementation(libs.junit4)
            implementation(libs.kotlin.test)
        }
    }
}
