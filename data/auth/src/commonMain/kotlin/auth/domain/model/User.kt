package auth.domain.model

data class User(
    val id: String? = null,
    val email: String = "",
    val profilePicUrl: String? = null,
    val userType: String = "",
    val firstName: String = "",
    val lastName: String = ""
)