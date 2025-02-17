package com.droidknights.app

import org.gradle.kotlin.dsl.configure
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

class KotlinxSerializationPlugin: Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        with(pluginManager) {
            apply("org.jetbrains.kotlin.plugin.serialization")
        }

        extensions.configure<KotlinMultiplatformExtension> {
            apply {
                sourceSets.apply {
                    commonMain.dependencies {
                        implementation(libs.findLibrary("kotlinx-serialization-json").get())
                    }
                }
            }
        }
    }
}
