package com.droidknights.app.multiplatform

import com.android.build.api.dsl.LibraryExtension
import com.droidknights.app.configureKotlinMultiplatform
import com.droidknights.app.configureKotlinMultiplatformAndroid
import com.droidknights.app.configureKotlinMultiplatformIos
import com.droidknights.app.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

class KotlinMultiplatformConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        with(pluginManager) {
            apply(libs.findPlugin("kotlin-multiplatform").get().get().pluginId)
            apply(libs.findPlugin("android-library").get().get().pluginId)
            apply(libs.findPlugin("kotlin-serialization").get().get().pluginId)
        }

        extensions.configure<KotlinMultiplatformExtension>(::configureKotlinMultiplatform)
        extensions.configure<LibraryExtension>(::configureKotlinMultiplatformAndroid)
        configureKotlinMultiplatformIos()
    }
}
