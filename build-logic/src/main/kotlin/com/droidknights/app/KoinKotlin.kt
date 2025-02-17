package com.droidknights.app

import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

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
