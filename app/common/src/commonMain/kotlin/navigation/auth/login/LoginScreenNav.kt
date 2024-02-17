package navigation.auth.login

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import auth.ui.login.LoginScreen
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import navigation.auth.navigation.onNavigate
//import navigation.adduser.AddUserScreenNav
import org.koin.core.annotation.Factory


@Factory
class LoginScreenNav : Screen {
    @Composable
    override fun Content() {
        val loginScreenModel = getScreenModel<LoginScreenModel>()

        val state = loginScreenModel.state.collectAsState()

        val navigator = LocalNavigator.currentOrThrow

        LoginScreen(
           login =  loginScreenModel::login,
            loginState = state.value,
            onNavigation = {
                navigator.onNavigate(it)
            }
        )
    }

}