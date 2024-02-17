# Create new data module

This guide will help you to create a new data module in the project.

## Steps

1. Create a new folder in the `data` folder with the name of the model (The name needs to in `kebab case`, ex: `profile`, `travel-agent`).
2. Create a new `build.gradle.kts` file in the new folder.
3. Add the following code to the data module `build.gradle.kts` file:

    ```kotlin
    plugins {
        alias(libs.plugins.kotlinMultiplatform)
        alias(libs.plugins.androidLibrary)
    }
    
    kotlinMultiplatformSetup()
    koinSetup()
    
    kotlin {
        sourceSets.commonMain.dependencies {
            // Add your dependencies here
        }
    }
    ```
   
4. Add the data module to the project `settings.gradle.kts` file:

    ```kotlin
    // ...
    // Data modules
    include(
        // ...
        ":data:model-name",
        // ...
    )
    // ...
    ```
   
5. Add the necessary folders to your data module, your folder structure should look like this:

    ```
    data
    ├── model-name
    │   ├── src
    │   │   └── commonMain
    │   │       └── kotlin
    │   │           └── model-name
    │   └── build.gradle.kts
    ```
   
6. Now you can sync the project and start working on the new data module.

> model-name is the name of the model in `kebab case`.

### Next Step: [Domain layer](2-domain-layer.md)