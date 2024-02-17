# Add Feature UI Layer

This guide will help you to create the UI layer for a feature module.

## Steps

1. Create a new `ui` folder in the feature module folder, your folder structure should look like this:

    ```
    features
    ├── feature-name
    │   ├── src
    │   │   └── commonMain
    │   │       └── kotlin
    │   │           └── feature-name
    │   │               └── ui
    │   └── build.gradle.kts
    ```
   
2. Create a new `components` folder in the `ui` folder.

    ```
    ui
    └── components
    ```
   > You are going to put the components that are used in the feature screen here.
   
3. Create a new `FeatureNameState` data class in the `ui` folder.

    ```kotlin
    package feature-name.ui
        
    data class FeatureName(
        val getProfile: State<ProfileModel>,
        val getAllPost: State<List<PostModel>>,
        val updateProfile: State<ProfileModel>,
        // Add your properties here
    )
    ```
   
4. Create a new `FeatureNameEvent` sealed interface in the `ui` folder.

    ```kotlin
    package feature-name.ui
        
    sealed interface FeatureNameEvent {
        data object GetProfile : FeatureNameEvent()
        data object GetAllPost : FeatureNameEvent()
        data object UpdateProfile : FeatureNameEvent()
        // Add your events here
    }
    ```
   
5. Create a new `FeatureNameViewModel` class in the `ui` folder.

    ```kotlin
    package feature-name.ui
   
    class FeatureNameViewModel(
        private val featureNameRepository: FeatureNameRepository,
        override val scope: CoroutineScope,
        private val state: MutableStateFlow<FeatureNameState>,
    ): ViewModel() {
   
        fun onEvent(event: FeatureNameEvent) {
            // Add your event handling here
            when (event) {
                is FeatureNameEvent.GetProfile -> getProfile()
                is FeatureNameEvent.GetAllPost -> getAllPost()
                is FeatureNameEvent.UpdateProfile -> updateProfile()
            }
        }

        // Add your functions here
   
        private fun getProfile() {
            // Add your logic here
            getData(
               getData = { profileRepository.get() },
               getState = { state.value.getProfile },
               setState = { newState -> state.update { it.copy(getProfile = newState) } },
            )
        }
   
        private fun getAllPost() {
            // Add your logic here
        }
   
        private fun updateProfile() {
            // Add your logic here
        }
    }
    ```
   
6. Create a new `FeatureNameNavigation` sealed interface in the `ui` folder.

    ```kotlin
    package feature-name.ui
        
    sealed interface FeatureNameNavigation {
        // Add your navigation here
        
        data object Home : FeatureNameNavigation
    }
    ```

7. Create a new `FeatureNameScreen` composable function in the `ui` folder.

    ```kotlin
    package feature-name.ui
        
    @Composable
    fun FeatureNameScreen(
        state: FeatureNameState,
        onEvent: (FeatureNameEvent) -> Unit,
        onNavigation: (FeatureNameNavigation) -> Unit,
    ) {
        // Add your composable here
    }
    ```
   
8. The final folder structure should look like this:

    ```
    ui
    ├── components
    ├── FeatureNameEvent.kt
    ├── FeatureNameNavigation.kt
    ├── FeatureNameState.kt
    ├── FeatureNameScreen.kt
    └── FeatureNameViewModel.kt
    ```

[Back to Home](../../README.md)