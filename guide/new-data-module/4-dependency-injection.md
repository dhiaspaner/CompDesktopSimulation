# Add Dependency Injection

This guide will help you to add dependency injection to a data module.

## Steps

1. Create a new `di` folder in the data module folder, your folder structure should look like this:

    ```
    data
    ├── model-name
    │   ├── src
    │   │   └── commonMain
    │   │       └── kotlin
    │   │           └── model-name
    │   │               └── di
    │   └── build.gradle.kts
    ```
   
2. Create a new `DataModelModule` class in the `di` folder.

    ```kotlin
    package model-name.di
   
    import org.koin.core.annotation.ComponentScan
    import org.koin.core.annotation.Module

    @Module
    @ComponentScan("model-name")
    class DataModelModule
    ```
   
3. Make sure to add the `DataModelModule` to your koin app module.

[Back to Home](../../README.md)