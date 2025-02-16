import com.droidknights.app.setNamespace

plugins {
    id("droidknights.kotlin.multiplatform")
    id("droidknights.kotlin.serialization")
}

android {
    setNamespace("core.model")
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(libs.kotlinx.datetime)
        }
    }
}
