package auth.data.remote

import io.ktor.client.HttpClient
import network.di.NoAuth
import org.koin.core.annotation.Named
import org.koin.core.annotation.Single
import network.data.TokenSettings
import auth.data.remote.response.LoginResponse
import auth.data.remote.response.SignUpDto
import auth.domain.model.User
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse
import io.ktor.http.ContentType
import io.ktor.http.contentType
import network.helper.handleErrors

@Single
internal class AuthRemoteDataSource(
    @Named(NoAuth) private val noAuthClient: HttpClient,
    private val settings: TokenSettings,
) {
    suspend fun login(emailOrPhoneNb: String, password: String): LoginResponse =
        handleErrors<LoginResponse> {
            val response: HttpResponse =
                noAuthClient.post(urlString = LoginUrl) {
                    setBody(
                        hashMapOf(
                            "email" to emailOrPhoneNb,
                            "password" to password,
                        ),
                    )

                }

            val result = response.body<LoginResponse>()
            settings.accessToken = result.data?.tokens?.accessToken ?: ""
            settings.refreshToken = result.data?.tokens?.refreshToken ?: ""

            return@handleErrors response
        }


    suspend fun signup(signUpRequest: SignUpDto): User =
        handleErrors<User> {
            noAuthClient.post(urlString = "") {
                contentType(ContentType.Application.Json)
                setBody(
                    signUpRequest
                )
            }
        }

    companion object {
        const val LoginUrl = "auth/login"
    }
}
