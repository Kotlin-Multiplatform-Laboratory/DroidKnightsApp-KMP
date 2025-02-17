import com.droidknights.app.setNamespace

plugins {
    id("droidknights.android.library")
    id("kotlinx-serialization")
    alias(libs.plugins.ktorfit)
}

android {
    setNamespace("core.data")
}

dependencies {
    implementation(projects.core.model)
    implementation(projects.core.datastore)
    implementation(projects.core.dataApi)

    implementation(libs.ktorfit.lib)

    implementation(libs.ktor.client.core)
    implementation(libs.ktor.client.content.negotiation)
    implementation(libs.ktor.serialization.kotlinx.json)

    implementation(libs.kotlinx.serialization.json)
    implementation(libs.kotlinx.datetime)
    testImplementation(libs.turbine)
}