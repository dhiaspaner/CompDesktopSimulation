import org.gradle.api.NamedDomainObjectContainer
import org.gradle.api.NamedDomainObjectProvider
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet

@OptIn(ExperimentalKotlinGradlePluginApi::class)
fun KotlinMultiplatformExtension.applyHierarchyTemplate() {
    applyDefaultHierarchyTemplate {
        common {

            group("skiko") {
//                withWasm()
                withJvm()
                withIos()
            }

            group("nonDesktop") {
//                withWasm()
                withIos()
                withAndroidTarget()
            }

            group("nonWasmJs") {
                withAndroidTarget()
                withJvm()
                withIos()
            }
        }
    }
}

val NamedDomainObjectContainer<KotlinSourceSet>.desktopMain: NamedDomainObjectProvider<KotlinSourceSet>
    get() = named("desktopMain")

val NamedDomainObjectContainer<KotlinSourceSet>.skikoMain: NamedDomainObjectProvider<KotlinSourceSet>
    get() = named("skikoMain")

val NamedDomainObjectContainer<KotlinSourceSet>.nonDesktopMain: NamedDomainObjectProvider<KotlinSourceSet>
    get() = named("nonDesktopMain")

val NamedDomainObjectContainer<KotlinSourceSet>.nonWasmJsMain: NamedDomainObjectProvider<KotlinSourceSet>
    get() = named("nonWasmJsMain")