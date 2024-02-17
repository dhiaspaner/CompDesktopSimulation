package auth.ui.login

import auth.domain.model.LoginModel
import utils.viewmodel.State


val Loading: Nothing? = null

data class LoginState(
    val login: State<LoginModel> = State(),
    val error: String? = Loading,
)