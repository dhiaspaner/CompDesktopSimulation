package network.data

import kotlinx.serialization.Serializable
import network.domain.Token

@Serializable
data class TokenDto(
    val accessToken: String? = null,
    val refreshToken: String? = null,
) {
    fun toModel() = Token(
        accessToken = accessToken ?: "",
        refreshToken = refreshToken ?: "",
    )
}
