plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.kotlinx.serialization)
}

composeMultiplatformSetup()
koinSetup()

kotlin {
    sourceSets.commonMain.dependencies {

        with(projects) {
            implementation(data.auth)
            implementation(core.utils)
        }

        with(libs.kotlinx) {
            implementation(coroutines.core)
            implementation(serialization.json)
        }

        with(libs.voyager) {
            implementation(navigator)
        }

        implementation(libs.multiplatform.settings)
    }
}