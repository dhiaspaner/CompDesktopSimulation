import com.android.build.gradle.internal.scope.ProjectInfo.Companion.getBaseName
import io.gitlab.arturbosch.detekt.Detekt

plugins {
    // this is necessary to avoid the plugins to be loaded multiple times
    // in each subproject's classloader
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.androidLibrary) apply false
    alias(libs.plugins.jetbrainsCompose) apply false
    alias(libs.plugins.kotlinAndroid) apply false
    alias(libs.plugins.ksp) apply  false
    alias(libs.plugins.kotlinJvm) apply false
    alias(libs.plugins.kotlinMultiplatform) apply false
    alias(libs.plugins.softylines) apply false
    alias(libs.plugins.sqldelight) apply false
    alias(libs.plugins.detekt)
}

val detektPluginId: String = libs.plugins.detekt.get().pluginId
val detektFormatting: Provider<MinimalExternalModuleDependency> = libs.detekt.formatting
val detektComposeRules: Provider<MinimalExternalModuleDependency> = libs.detekt.compose.rules

allprojects {
    apply(plugin = detektPluginId)

    detekt {
        config.setFrom(file("${rootProject.rootDir}/config/detekt/detekt.yml"))
        buildUponDefaultConfig = true
        basePath = rootProject.rootDir.absolutePath
    }

    dependencies {
        detektPlugins(detektFormatting)
        detektPlugins(detektComposeRules)
    }

    tasks.withType<Detekt>().configureEach {
        basePath = rootProject.rootDir.absolutePath

        reports {
            xml.required.set(true)
            html.required.set(true)
            txt.required.set(true)
            sarif.required.set(true)
            md.required.set(true)
        }
    }
}