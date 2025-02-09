package com.droidknights.app

import com.android.build.api.dsl.LibraryExtension
import com.android.build.gradle.TestExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

internal fun Project.configureKotlinMultiplatformAndroid(
    extension: LibraryExtension
) = extension.apply {
    compileSdk = libs.findVersion("android.compileSdk").get().requiredVersion.toInt()

    kotlin {
        androidTarget {
            compilerOptions.jvmTarget.set(JvmTarget.JVM_17)
        }
    }
    defaultConfig {
        minSdk = libs.findVersion("android.minSdk").get().requiredVersion.toInt()
        consumerProguardFiles("consumer-proguard-rules.pro")
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    extensions.configure<TestExtension> {
        configureKotlinAndroid()
        sourceSets {
            getByName("main") {
                assets.srcDirs("src/androidMain/assets")
                java.srcDirs("src/androidMain/kotlin", "src/commonMain/kotlin")
                res.srcDirs("src/androidMain/res")
            }
            getByName("test") {
                assets.srcDirs("src/androidUnitTest/assets")
                java.srcDirs("src/androidUnitTest/kotlin", "src/commonTest/kotlin")
                res.srcDirs("src/androidUnitTest/res")
            }
        }
    }
}
