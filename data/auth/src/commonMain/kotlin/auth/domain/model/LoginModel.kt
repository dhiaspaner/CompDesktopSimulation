package auth.domain.model

import network.domain.Token

data class LoginModel(
    val user : User = User()
)