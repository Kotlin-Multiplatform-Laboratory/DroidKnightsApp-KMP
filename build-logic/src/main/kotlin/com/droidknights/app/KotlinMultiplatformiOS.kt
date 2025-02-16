package com.droidknights.app

import org.gradle.api.Project
import org.gradle.kotlin.dsl.get
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget
import java.util.Properties

internal enum class Arch(val arch: String?) {
    ARM("arm64"),
    X86("x86_64"),
    ALL(null);

    companion object {
        fun of(arch: String?): Arch {
            return values().firstOrNull { it.arch == arch } ?: ALL
        }
    }
}


internal val Project.activeArch
    get() = Arch.of(
        rootProject.layout.projectDirectory.file("local.properties").asFile.takeIf { it.exists() }
            ?.let {
                Properties().apply {
                    load(it.reader(Charsets.UTF_8))
                }.getProperty("arch")
            } ?: System.getenv("arch")
    )

internal fun Project.configureKotlinMultiplatformIos() {
    kotlin {
        when (activeArch) {
            Arch.ARM -> iosSimulatorArm64()
            Arch.X86 -> iosX64()
            Arch.ALL -> {
                iosArm64()
                iosX64()
                iosSimulatorArm64()
            }
        }

        targets.withType<KotlinNativeTarget> {
            compilations["main"].kotlinOptions.freeCompilerArgs += "-Xexport-kdoc"
        }
    }
}
