pluginManagement {
    includeBuild("build-logic")
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
        maven("https://packages.jetbrains.team/maven/p/firework/dev")
    }
}

@Suppress("UnstableApiUsage")
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven("https://packages.jetbrains.team/maven/p/firework/dev")
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}

rootProject.name = "DroidKnights"
include(":app")

// Baseline Profile
include(":baselineprofile")

// core
include(
    ":core:designsystem",
    ":core:data",
    ":core:data-api",
    ":core:domain",
    ":core:navigation",
    ":core:model",
    ":core:ui",
    ":core:ui-test-hilt-manifest",
    ":core:testing",
    ":core:datastore",
)

// Feature
include(
    ":feature:main",
    ":feature:home",
    ":feature:session",
    ":feature:setting",
    ":feature:contributor",
    ":feature:bookmark",
)

include(
    ":widget"
)
