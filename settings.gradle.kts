rootProject.name = "KotlinStarter"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    includeBuild("convention-plugins")
    repositories {
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}

dependencyResolutionManagement {
    @Suppress("UnstableApiUsage")
    repositories {
        google()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}

// Executable apps
include(
    ":app:android",
    ":app:desktop",
    ":app:web",
    ":app:common",
)

// Core modules
include(
    ":core:database",
    ":core:network",
    ":core:utils",
    ":core:core",
)

// Data modules
include(
    ":data:users",
    ":data:auth",
)

// Feature modules
include(
    ":feature:auth",
    ":feature:users",
)