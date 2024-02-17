# Add Domain Layer

This guide will help you to create the domain layer for a data module.

## Steps

1. Create a new `domain` folder in the data module folder, your folder structure should look like this:

    ```
    data
    ├── model-name
    │   ├── src
    │   │   └── commonMain
    │   │       └── kotlin
    │   │           └── model-name
    │   │               └── domain
    │   └── build.gradle.kts
    ```
   
2. Create a `model` and `repository` folders in the `domain` folder.

   ```
    domain
    ├── model
    └── repository
    ```
   
3. Create a new `DataModelModel` data class in the `model` folder.

    ```kotlin
    package data-model.domain.model

    data class DataModelModel(
        // Add your properties here
    )
    ```
   
4. Create a new `DataModelRepository` interface in the `repository` folder.

    ```kotlin
    package data-model.domain.repository
   
    interface DataModelRepository {
        // Add your functions here
    }
    ```
   
5. The final folder structure should look like this:


   ```
    domain
    ├── model
    │   └── DataModelModel.kt
    └── repository
        └── DataModelRepository.kt
      
   ```

### Next Step: [Data layer](3-data-layer.md)