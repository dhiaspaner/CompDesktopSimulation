plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
}

kotlinMultiplatformSetup()
koinSetup()

kotlin {
    sourceSets.commonMain.dependencies {
        with(projects) {
            implementation(core.database)
        }

        with(libs.koin) {
            implementation(core)
            implementation(compose)
            implementation(annotations)
        }

        // Koin
        implementation(libs.koin.core)
        implementation(libs.koin.compose)
        implementation(libs.koin.annotations)

        implementation(libs.sqldelight.coroutinesExtensions)
    }
}