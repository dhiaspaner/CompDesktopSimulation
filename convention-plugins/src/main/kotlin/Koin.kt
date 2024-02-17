

import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.the
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.dsl.KotlinCompile

fun Project.koinSetup(
    withAnnotations: Boolean = true,
) {
    val libs = the<LibrariesForLibs>()

    if (withAnnotations)
        apply(plugin = libs.plugins.ksp.get().pluginId)

    kotlin {
        sourceSets.commonMain {
            kotlin.srcDir("build/generated/ksp/metadata/commonMain/kotlin")
        }

        sourceSets.commonMain.dependencies {
            with(libs.koin) {
                implementation(core)
                if (withAnnotations)
                    implementation(annotations)
            }
            implementation(libs.stately)
        }
    }

    if (withAnnotations) {
        dependencies {
            add("kspCommonMainMetadata", libs.koin.ksp.compiler)
        }

        tasks.withType<KotlinCompile<*>>().configureEach {
            if (name != "kspCommonMainKotlinMetadata") {
                dependsOn("kspCommonMainKotlinMetadata")
            }
        }
    }
}