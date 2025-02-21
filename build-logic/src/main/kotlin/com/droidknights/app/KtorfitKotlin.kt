package com.droidknights.app

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

class KtorfitPlugin : Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        with(pluginManager) {
            apply("de.jensklingenberg.ktorfit")
        }

        extensions.configure<KotlinMultiplatformExtension> {
            kotlin {
                sourceSets.apply {
                    commonMain.dependencies {
                        implementation(libs.findLibrary("ktor-client-content-negotiation").get())
                        implementation(libs.findLibrary("ktor-serialization-kotlinx-json").get())
                        implementation(libs.findLibrary("ktor-logging").get())
                        implementation(libs.findLibrary("ktor-client-encoding").get())
                        implementation(libs.findLibrary("coroutines-core").get())
                        implementation(libs.findLibrary("ktorfit-lib").get())
                    }
                    androidMain.dependencies {
                        implementation(libs.findLibrary("ktor-client-okhttp").get())
                        implementation(libs.findLibrary("coroutines-android").get())
                    }
                    iosMain.dependencies {
                        implementation(libs.findLibrary("ktor-client-darwin").get())
                    }
                }
            }
        }
    }
}
