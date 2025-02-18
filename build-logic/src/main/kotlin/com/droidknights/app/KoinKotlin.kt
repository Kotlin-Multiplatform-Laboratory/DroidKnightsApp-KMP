package com.droidknights.app

import com.android.build.gradle.internal.utils.isKspPluginApplied
import com.google.devtools.ksp.gradle.KspExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

class KoinPlugin : Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        with(pluginManager) {
            apply("com.google.devtools.ksp")
        }

        extensions.configure<KotlinMultiplatformExtension> {
            kotlin {
                with(sourceSets) {
                    commonMain.dependencies {
                        implementation(libs.findLibrary("koin-core").get())
                        implementation(libs.findLibrary("koin-annotations").get())
                        implementation(libs.findLibrary("koin-compose").get())
                        implementation(libs.findLibrary("koin-compose-viewmodel").get())
                        implementation(libs.findLibrary("koin-compose-viewmodel-navigation").get())
                    }
                }
            }
            dependencies {
                add("kspCommonMainMetadata", libs.findLibrary("koin-ksp-compiler").get())
                add("kspAndroid", libs.findLibrary("koin-ksp-compiler").get())
                add("kspIosArm64", libs.findLibrary("koin-ksp-compiler").get())
                add("kspIosSimulatorArm64", libs.findLibrary("koin-ksp-compiler").get())
            }
            extensions.configure<KspExtension> {
                arg("KOIN_CONFIG_CHECK", "true")
                arg("KOIN_DEFAULT_MODULE", "false")
            }
        }
    }
}

internal fun Project.configureKoinKotlin() {
    with(pluginManager) {
        apply("com.google.devtools.ksp")
    }

    dependencies {
        "implementation"(libs.findLibrary("koin-core").get())
        "implementation"(libs.findLibrary("koin-annotations").get())
        "implementation"(libs.findLibrary("koin-compose").get())
        "implementation"(libs.findLibrary("koin-compose-viewmodel").get())
        "implementation"(libs.findLibrary("koin-compose-viewmodel-navigation").get())

        add("ksp", libs.findLibrary("koin-ksp-compiler").get())
//        add("kspCommonMainMetadata", libs.findLibrary("koin-ksp-compiler").get())
//        add("kspAndroid", libs.findLibrary("koin-ksp-compiler").get())
//        add("kspIosArm64", libs.findLibrary("koin-ksp-compiler").get())
//        add("kspIosSimulatorArm64", libs.findLibrary("koin-ksp-compiler").get())
    }
}
