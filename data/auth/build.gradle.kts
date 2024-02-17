plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinx.serialization)
}

kotlinMultiplatformSetup()
koinSetup()

kotlin {
    sourceSets.commonMain.dependencies {
        with(projects) {
            implementation(core.database)
            implementation(core.network)
        }



        // Ktor Bundle
        implementation(libs.bundles.ktor)
    }
}