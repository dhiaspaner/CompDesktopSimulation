import org.gradle.api.Action
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

/**
 * Retrieves the [kotlin][org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension] extension.
 */
internal
val org.gradle.api.Project.kotlin: org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension get() =
    (this as org.gradle.api.plugins.ExtensionAware).extensions.getByName("kotlin") as org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

/**
 * Configures the [kotlin][org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension] extension.
 */
internal
fun org.gradle.api.Project.kotlin(configure: Action<KotlinMultiplatformExtension>): Unit =
    (this as org.gradle.api.plugins.ExtensionAware).extensions.configure("kotlin", configure)

/**
 * Retrieves the [compose][org.jetbrains.compose.ComposePlugin.Dependencies] extension.
 */
internal
val org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension.compose: org.jetbrains.compose.ComposePlugin.Dependencies get() =
    (this as org.gradle.api.plugins.ExtensionAware).extensions.getByName("compose") as org.jetbrains.compose.ComposePlugin.Dependencies

/**
 * Configures the [compose][org.jetbrains.compose.ComposePlugin.Dependencies] extension.
 */
internal
fun org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension.compose(configure: Action<org.jetbrains.compose.ComposePlugin.Dependencies>): Unit =
    (this as org.gradle.api.plugins.ExtensionAware).extensions.configure("compose", configure)