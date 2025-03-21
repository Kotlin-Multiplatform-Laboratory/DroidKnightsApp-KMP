package com.droidknights.app.multiplatform

import com.droidknights.app.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.testing.Test
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

class KotestMultiplatformConventionPlugin : Plugin<Project> {
    override fun apply(target: Project): Unit = with(target) {
        with(pluginManager) {
            apply(libs.findPlugin("kotest-multiplatform").get().get().pluginId)
        }
        extensions.configure<KotlinMultiplatformExtension> {
            sourceSets.apply {
                commonTest {
                    dependencies {
                        implementation(libs.findLibrary("kotest.assertions.core").get())
                        implementation(libs.findLibrary("kotest.framework.engine").get())
                    }
                }
            }
        }
        tasks.withType<Test> {
            useJUnitPlatform()
        }
    }
}