plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.sqldelight)
}

kotlinMultiplatformSetup()


sqldelight {
    databases {
        create("Database") {
            packageName.set("database")
            schemaOutputDirectory = file("src/commonMain/sqldelight/database")
            deriveSchemaFromMigrations = true
            verifyMigrations = true
        }
    }


}
kotlin {
    sourceSets.commonMain.dependencies {
        implementation(libs.sqldelight.coroutinesExtensions)
        implementation(libs.sqldelight.primitiveAdapters)

        implementation(libs.bundles.koin)
    }

    sourceSets.androidMain.dependencies {
        //SqlDelight
        implementation(libs.sqldelight.driver.android)
        implementation(libs.sqldelight.coroutinesExtensions)
        // Koin
        implementation(libs.koin.android)
    }

    sourceSets.iosMain.dependencies {
        //SqlDelight
        implementation(libs.ktor.client.darwin)
        implementation(libs.sqldelight.driver.native)
    }

    sourceSets.desktopMain.dependencies {
        //Ktor
        implementation(libs.ktor.client.okhttp)
        //SqlDelight
        implementation(libs.sqldelight.sqliteDriver)

    }
}
