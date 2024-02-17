package auth.ui.signIn

import auth.domain.model.User

data class SignInState(
    val id: String? = null,
    val email: String = "",
    val profilePicUrl: String? = null,
    val userType: String = "",
    val firstName: String = "",
    val lastName: String = ""
) {

    fun toUser() =  User(
        id,
        email,
        profilePicUrl,
        userType,
        firstName,
        lastName
    )

}
