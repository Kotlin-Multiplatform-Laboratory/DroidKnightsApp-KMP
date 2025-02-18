plugins {
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
}

dependencies {
    implementation(libs.android.gradlePlugin)
    implementation(libs.kotlin.gradlePlugin)
    implementation(libs.verify.detektPlugin)
    compileOnly(libs.compose.compiler.gradle.plugin)
    compileOnly(libs.compose.gradle.plugin)
    compileOnly(libs.ksp.gradle.plugin)
}

tasks {
    validatePlugins {
        enableStricterValidation = true
        failOnWarning = true
    }
}

gradlePlugin {
    plugins {
        register("androidHilt") {
            id = "droidknights.android.hilt"
            implementationClass = "com.droidknights.app.HiltAndroidPlugin"
        }
        register("kotlinHilt") {
            id = "droidknights.kotlin.hilt"
            implementationClass = "com.droidknights.app.HiltKotlinPlugin"
        }
        register("kotlinMultiplatform") {
            id = "droidknights.kotlin.multiplatform"
            implementationClass = "com.droidknights.app.multiplatform.KotlinMultiplatformConventionPlugin"
        }
        register("composeMultiplatform") {
            id = "droidknights.compose.multiplatform"
            implementationClass = "com.droidknights.app.multiplatform.ComposeMultiplatformConventionPlugin"
        }
        register("kotlinxSerialization") {
            id = "droidknights.kotlin.serialization"
            implementationClass = "com.droidknights.app.KotlinxSerializationPlugin"
        }
        register("koin") {
            id = "droidknights.kotlin.koin"
            implementationClass = "com.droidknights.app.KoinPlugin"
        }
    }
}
