package network.data

import com.russhwolf.settings.Settings
import org.koin.core.annotation.Single

@Single
class TokenSettings(
    private val settings: Settings
) {
    var accessToken
        get() = settings.getStringOrNull(AccessToken) ?: ""
        set(value) {
            value.let { settings.putString(AccessToken, it) }
        }

    var refreshToken
        get() = settings.getStringOrNull(RefreshToken) ?: ""
        set(value) {
            value.let { settings.putString(RefreshToken, it) }
        }
    fun clear() {
        settings.putString(AccessToken, "")
        settings.putString(RefreshToken, "")
    }

    companion object {
        private const val AccessToken = "AccessToken"
        private const val RefreshToken = "RefreshToken"
    }
}
