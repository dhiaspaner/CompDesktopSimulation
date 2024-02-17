import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.jetbrainsCompose)
}

composeMultiplatformSetup()
koinSetup()

kotlin {
    targets
        .filterIsInstance<KotlinNativeTarget>()
        .forEach { iosTarget ->
            iosTarget.binaries.framework {
                baseName = "Common"
                isStatic = true
            }
        }

    sourceSets.commonMain.dependencies {
        with(projects){
            with(core) {
                implementation(network)
                implementation(database)
                implementation(utils)
            }

            with(feature){
                implementation(auth)
                implementation(users)
            }

            with(data) {
                implementation(auth)
                implementation(users)
            }
        }
        with(compose) {
            implementation(components.resources)
        }

        with(libs.voyager) {
            implementation(koin)
            implementation(navigator)
            implementation(transitions)
        }
    }

    sourceSets.androidMain.dependencies {
        implementation(libs.koin.android)
        implementation(libs.koin.core)
    }
}