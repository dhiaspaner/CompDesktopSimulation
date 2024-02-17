package auth.ui.navigation

import cafe.adriel.voyager.core.registry.ScreenProvider


sealed class AuthNavigation : ScreenProvider {
    data object SplashScreen : AuthNavigation()
    data object Login : AuthNavigation()
    data object SignUp : AuthNavigation()
    data object Out : AuthNavigation()

}