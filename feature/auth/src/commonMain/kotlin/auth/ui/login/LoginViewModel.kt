package auth.ui.login

import auth.domain.model.LoginModel
import auth.domain.repository.AuthRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import utils.viewmodel.ViewModel
import utils.viewmodel.getData

class LoginViewModel(
    private val repository: AuthRepository,
    override val scope: CoroutineScope,
    val loginState: MutableStateFlow<LoginState>
) : ViewModel {
    fun onLogin(email: String, password: String) {
        scope.launch {
            getData(
                getData = {
                    repository.login(
                            email = email,
                            password = password
                        )
                },
                getState = { loginState.value.login },
                setState = { loginState.value = loginState.value.copy(login = it) },
                onFailure = { exception ->
                    loginState.value = loginState.value.copy(
                        error = exception.message ?: "Unknown Error"
                    )
                }
            )
        }
    }
}