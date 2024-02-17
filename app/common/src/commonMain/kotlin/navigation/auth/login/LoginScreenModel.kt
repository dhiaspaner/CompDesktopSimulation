package navigation.auth.login

import auth.domain.repository.AuthRepository
import auth.ui.login.LoginViewModel
import auth.ui.login.LoginState
import cafe.adriel.voyager.core.model.StateScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import org.koin.core.annotation.Factory

@Factory
class LoginScreenModel(
    loginRepository: AuthRepository
): StateScreenModel<LoginState>(LoginState()) {

    private val loginViewModel = LoginViewModel(
        repository = loginRepository,
        scope = screenModelScope,
        loginState = mutableState
    )

    fun login(
        email: String,
        password: String
    ) {
        loginViewModel.onLogin(
            email,
            password
        )
    }
}