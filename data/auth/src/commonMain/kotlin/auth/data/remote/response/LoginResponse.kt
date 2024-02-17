package auth.data.remote.response

import auth.domain.model.LoginModel
import auth.domain.model.User
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import network.domain.Token

@Serializable
data class LoginResponse(
    val data: Data? = null,
)

@Serializable
data class Data(
    val tokens: Tokens,
    val user: UserDto
) {
    fun toModel() = LoginModel(
        user = user.toUserModel()
    )
}

@Serializable
data class Tokens(
    val accessToken: String? = null,
    val refreshToken: String? = null
) {
    fun toToken() = Token(
        accessToken = accessToken ?: "",
        refreshToken = refreshToken ?: "",
    )
}

@Serializable
data class UserDto(
    @SerialName("_id") val id: String? = null,
    val documentVerified: Boolean? = null,
    val email: String? = null,
    val firstName: String? = null,
    val isBanned: Boolean? = null,
    val lastName: String? = null,
    val profilePicUrl: String? = null,
    val userType: UserType? = null,
    val verified: Boolean? = null
) {
    fun toUserModel() = User(
        id = id ?: "",
        firstName = firstName ?: "",
        lastName = lastName ?: "",
        profilePicUrl = profilePicUrl ?: "",
        userType = userType?.name ?: "",
        email = email ?: "",
    )
}

@Serializable
data class UserType(
    @SerialName("_id") val id: String? = null,
    val name: String? = null,
)