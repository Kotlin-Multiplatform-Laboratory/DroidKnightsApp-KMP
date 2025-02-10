package com.droidknights.app

import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

internal fun Project.configureKotlinMultiplatform(
    extension: KotlinMultiplatformExtension
) = extension.apply {
    jvmToolchain(17)
    with(pluginManager) {
        apply("org.jetbrains.kotlin.multiplatform")
    }
    applyDefaultHierarchyTemplate()

    sourceSets.apply {
        commonMain {
            dependencies {
                implementation(libs.findLibrary("coroutine.core").get())
                implementation(libs.findLibrary("kermit").get())
            }
        }
        androidMain {
            dependencies {
                implementation(libs.findLibrary("coroutines-android").get())
            }
        }
    }
    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinNativeLink>().configureEach {
        notCompatibleWithConfigurationCache("Configuration cache not supported for a system property read at configuration time")
    }
}

fun Project.kotlin(action: KotlinMultiplatformExtension.() -> Unit) {
    extensions.configure(action)
}