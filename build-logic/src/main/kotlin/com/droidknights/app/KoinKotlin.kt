package com.droidknights.app

import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

internal fun Project.configureKoinKotlin() {
    with(pluginManager) {
        apply("com.google.devtools.ksp")
    }

    val libs = extensions.libs
    dependencies {
        "implementation"(libs.findLibrary("koin-core").get())
        "implementation"(libs.findLibrary("koin-annotations").get())
    }
}
