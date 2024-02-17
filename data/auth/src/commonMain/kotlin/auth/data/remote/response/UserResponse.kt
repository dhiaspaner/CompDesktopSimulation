package auth.data.remote.response

import auth.domain.model.User
import kotlinx.serialization.Serializable

@Serializable
data class SignUpDto(
    val firstName: String,
    val lastName: String,
    val email: String? = null,
    val phoneNumber: String? = null,
    val password: String,
    val userType: String,
    val country: String,
    val birthDay: String,
    val gender: String,
    val confirmationType: String,
) {
    companion object {
        fun formUser(user: User): SignUpDto =
            SignUpDto(
                firstName = user.firstName,
                lastName = user.lastName,
                email = user.email,
                birthDay = "",
                password = "",
                userType = "",
                confirmationType = "",
                gender = "",
                country = ""
            )
    }
}