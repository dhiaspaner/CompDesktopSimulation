# Create new feature module

This guide will help you to create a new feature module in the project.

## Steps

1. Create a new folder in the `feature` folder with the name of the feature (The name needs to in `kebab case`, ex: `auth`, `travel-agent`).
2. Create a new `build.gradle.kts` file in the new folder.
3. Add the following code to the feature `build.gradle.kts` file:

    ```kotlin
    plugins {
        alias(libs.plugins.kotlinMultiplatform)
        alias(libs.plugins.androidLibrary)
        alias(libs.plugins.jetbrainsCompose)
    }
    
    composeMultiplatformSetup()
    koinSetup()
    
    kotlin {
        sourceSets.commonMain.dependencies {
            // Add your dependencies here
        }
    }
    ```
   
4. Add the feature module to the project `settings.gradle.kts` file:

    ```kotlin
    // ...
    // Feature modules
    include(
        // ...
        ":feature:feature-name",
        // ...
    )
    // ...
    ```
   
5. Add the necessary folders to your feature module, your folder structure should look like this:

    ```
    feature
    ├── feature-name
    │   ├── src
    │   │   └── commonMain
    │   │       └── kotlin
    │   │           └── feature-name
    │   └── build.gradle.kts
    ```
   
6. Now you can sync the project and start working on the new feature.

### Next Step: [Feature UI layer](2-feature-ui-layer.md)