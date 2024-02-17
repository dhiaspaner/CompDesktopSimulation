plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
}

kotlinMultiplatformSetup()
koinSetup()


kotlin {
    sourceSets.commonMain.dependencies {
        implementation(libs.bundles.ktor)
    }
}
