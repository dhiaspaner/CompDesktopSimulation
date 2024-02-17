import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.api.Project
import org.gradle.kotlin.dsl.the

fun Project.composeMultiplatformSetup() {
    require(plugins.any { it.toString().startsWith("org.jetbrains.kotlin") }) {
        "Kotlin plugin must be applied before to use Compose Multiplatform"
    }
    require(plugins.any { it.toString().startsWith("org.jetbrains.compose") }) {
        "Compose plugin must be applied before to use Compose Multiplatform"
    }

    val libs = the<LibrariesForLibs>()

    kotlin {
        applyHierarchyTemplate()

        applyTargets()

        sourceSets.commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material3)

            implementation(libs.kotlinx.coroutines.core)
        }

        sourceSets.commonTest.dependencies {
            implementation(kotlin("test"))
        }

        sourceSets.androidMain.dependencies {
            implementation(libs.kotlinx.coroutines.android)
        }

        sourceSets.desktopMain.dependencies {
            implementation(libs.kotlinx.coroutines.swing)
        }
    }

    androidLibrarySetup()
}