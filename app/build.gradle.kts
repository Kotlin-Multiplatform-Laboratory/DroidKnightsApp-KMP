import org.jetbrains.compose.reload.ComposeHotRun
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    id("com.android.application")
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.jetbrains.compose)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.baselineprofile)
    alias(libs.plugins.roborazzi.plugin)
    alias(libs.plugins.ksp)
    alias(libs.plugins.compose.hotreload)
}


kotlin {
    androidTarget {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_17)
        }
    }

    listOf(
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
            optimized = true
        }
    }

    sourceSets {
        androidMain.dependencies {
            implementation(compose.preview)
            implementation(libs.androidx.activity.compose)

            implementation(libs.koin.android)
            implementation(libs.hilt.android)
            implementation(libs.hilt.core)
        }

        commonMain.dependencies {
            implementation(projects.core.model)
            implementation(projects.core.datastore)

            implementation(compose.material3)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)

            api(libs.koin.core)
            implementation(libs.koin.compose)
        }

        jvmMain.dependencies {
            implementation(compose.desktop.currentOs)
        }

        iosMain.dependencies {

        }
    }
}

compose.desktop {
    application {
        mainClass = "com.droidknights.app.MainKt"
    }
}

android {
    namespace = "com.droidknights.app"
    compileSdk = 35

    defaultConfig {
        minSdk = 28
        targetSdk = 35

        applicationId = "com.droidknights.app"
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    buildTypes {
        getByName("release") {
            signingConfig = signingConfigs.getByName("debug")
        }

        create("benchmark") {
            matchingFallbacks.add("release")
            signingConfig = signingConfigs.getByName("debug")
            isDebuggable = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17

        isCoreLibraryDesugaringEnabled = true
    }

    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(projects.core.navigation)
    implementation(projects.feature.main)
    implementation(projects.feature.home)
    implementation(projects.feature.bookmark)
    implementation(projects.core.data)
    implementation(projects.core.domain)
    implementation(projects.core.designsystem)

    implementation(projects.widget)

    baselineProfile(projects.baselineprofile)
    implementation(libs.androidx.profileinstaller)

    testImplementation(projects.core.testing)

    coreLibraryDesugaring(libs.android.desugarJdkLibs)
}

tasks.register<ComposeHotRun>("runHot") {
    mainClass.set("com.droidknights.app.MainKt")
}