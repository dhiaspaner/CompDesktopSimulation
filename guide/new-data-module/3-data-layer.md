# Add Data Layer

This guide will help you to create the data layer for a data module.

## Steps

1. Create a new `data` folder in the data module folder, your folder structure should look like this:

    ```
    data
    ├── model-name
    │   ├── src
    │   │   └── commonMain
    │   │       └── kotlin
    │   │           └── model-name
    │   │               └── data
    │   └── build.gradle.kts
    ```
   
2. Create a new `remote`, `local`, and `repository` folders in the `data` folder.

    ```
    data
    ├── local
    ├── remote
    └── repository
    ```
   > You can have only `remote` or `local` or both, it depends on your data module requirements.

3. Create a new `request` and `response` folders in the `remote` folder.

    ```
    remote
    ├── request
    └── response
    ```
   > You are going to put your request and response DTOs in these folders.

4. Create a new `DataModelResponse` data class in the `response` folder.

    ```kotlin
    package data-model.data.remote.response
    
    @Serializable
    data class DataModelResponse(
        // Add your properties here
    ) {
        // Add the mapping function here
        fun toModel() =
            DataModelModel(
                // Map the properties here
            )
        
        companion object {
            // Add the factory function here
            fun fromModel(model: DataModelModel) =
                DataModelResponse(
                    // Map the properties here
                )
        }
    }
    ```
   > You can use the `@Serializable` annotation to make the class serializable with kotlinx.serialization.
   > You can add the mapping function to convert the response to the model and vice versa.

5. Create a new `DataModelRequest` data class in the `request` folder.

    ```kotlin
    package data-model.data.remote.request
    
    @Serializable
    data class DataModelRequest(
        // Add your properties here
    ) {
        companion object {
            // Add the factory function here
            fun fromModel(model: DataModelModel) =
                DataModelRequest(
                    // Map the properties here
                )
        }
    }
    ```
   > You can use the `@Serializable` annotation to make the class serializable with kotlinx.serialization.
   > You can add the factory function to create the request from the model.

6. Create a new `DataModelRemoteDataSource` class in the `remote` folder.

    ```kotlin
    package data-model.data.remote
    
    @Single
    internal class DataModelRemoteDataSource {
        // Add your functions here
    }
    ```
   > You can use `@Single` annotation to inject the class as a single instance with koin.
   > Make sure to mark the class as `internal` because it should not be accessible from outside the module.

7. Create a new `DataModelLocalDataSource` class in the `local` folder.

   ```kotlin
   package data-model.data.local
   
   @Single
   internal class DataModelLocalDataSource {
     // Add your functions here
   }
   ```
   > You can use `@Single` annotation to inject the class as a single instance with koin.
   > Make sure to mark the class as `internal` because it should not be accessible from outside the module.

8. Create a new `mapper` folder in the `local` folder.

    ```
    local
    └── mapper
    ```
   > You are going to put your mappers in this folder.

9. Create a new `DataModelRepositoryImpl` interface in the `repository` folder.

   ```kotlin
   package data-model.data.repository
   
   @Single
   internal class DataModelRepositoryImpl(
       private val remote: DataModelRemoteDataSource,
       private val local: DataModelLocalDataSource
   ) {
     // Add your functions here
   }
   ```
   > You can use `@Single` annotation to inject the class as a single instance with koin.
   > Make sure to mark the class as `internal` because we shouldn't expose the implementation.
   > The mapping should be done in the repository layer.

10. The final folder structure should look like this:

    ```
    data
    ├── local
    │   └── DataModelLocalDataSource.kt
    ├── remote
    │   ├── request
    │   │   └── DataModelRequest.kt
    │   ├── response
    │   │   └── DataModelResponse.kt
    │   └── DataModelRemoteDataSource.kt
    └── repository
        └── DataModelRepositoryImpl.kt
    ```

### Next Step: [Dependency injection](4-dependency-injection.md)