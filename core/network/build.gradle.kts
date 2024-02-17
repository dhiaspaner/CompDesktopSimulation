plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinx.serialization)
}


kotlinMultiplatformSetup()
koinSetup()



kotlin {
    sourceSets.commonMain.dependencies {
        with(libs.kotlinx) {
            implementation(coroutines.core)
            implementation(serialization.json)

        }

        implementation(libs.multiplatform.settings)
        implementation(libs.multiplatform.settings.no.arg)

        with(libs.ktor) {
            implementation(serialization.json)
            implementation(content.negotiation)
            implementation(client.auth)
            implementation(logging)

        }

    }

    sourceSets.androidMain.dependencies {
        with(libs.ktor) {
            implementation(engine.android)
            implementation(client.okhttp)
        }
    }

    sourceSets.desktopMain.dependencies {
        with(libs.ktor) {
            implementation(engine.apache5)
            implementation(client.okhttp)

        }
    }

//    sourceSets.jsMain.dependencies {
//        with(libs.ktor) {
//            implementation(engine.js)
//            implementation(client.okhttp)
//
//        }
//    }

    sourceSets.iosMain.dependencies {
        with(libs.ktor) {
            implementation(engine.darwin)

        }
    }

}