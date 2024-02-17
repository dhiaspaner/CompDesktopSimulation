plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.kotlinx.serialization)
}

composeMultiplatformSetup()

kotlin {
    sourceSets.commonMain.dependencies {

        with(libs.kotlinx) {
            implementation(coroutines.core)
            implementation(serialization.json)
        }

        with(projects) {
            implementation(data.users)
            implementation(core.utils)
        }
     }
}