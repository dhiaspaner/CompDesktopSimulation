package navigation.auth.navigation

import auth.ui.navigation.AuthNavigation
import cafe.adriel.voyager.navigator.Navigator
import navigation.auth.login.LoginScreenNav
import navigation.users.adduser.AddUserScreenNav

internal fun Navigator.onNavigate(authScreen: AuthNavigation) {
    when(authScreen) {
        is AuthNavigation.Login -> { push(LoginScreenNav())}
        is AuthNavigation.SignUp -> { }
        is AuthNavigation.SplashScreen -> {}
        is AuthNavigation.Out -> { push(AddUserScreenNav())}
    }
}