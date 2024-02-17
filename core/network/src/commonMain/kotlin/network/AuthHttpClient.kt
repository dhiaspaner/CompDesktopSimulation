package network

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.statement.HttpResponse
import kotlinx.serialization.ExperimentalSerializationApi
import io.ktor.client.plugins.auth.Auth
import io.ktor.client.plugins.auth.providers.BearerTokens
import io.ktor.client.plugins.auth.providers.bearer
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.bearerAuth
import io.ktor.client.request.headers
import io.ktor.client.request.post
import io.ktor.client.request.request
import io.ktor.client.request.setBody
import io.ktor.http.HttpHeaders
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import network.data.TokenDto
import network.data.TokenSettings
import network.util.UnauthorizedException
import network.util.NetworkConstants

@OptIn(ExperimentalSerializationApi::class)
fun createAuthHttpClient(
    noAuthClient: HttpClient,
    tokenSettings: TokenSettings
): HttpClient {
    return createNoAuthHttpClient().config {
        install(Auth) {
            bearer {
                loadTokens{
                    BearerTokens(
                        tokenSettings.accessToken,
                        tokenSettings.refreshToken
                    )
                }
                refreshTokens {
                    try {
                        val response: HttpResponse =
                            noAuthClient.post(urlString = NetworkConstants.RefreshUrl) {
                                request {
                                    bearerAuth(
                                        tokenSettings.accessToken
                                    )
                                    setBody(
                                        hashMapOf(
                                            "refreshToken" to tokenSettings.refreshToken,
                                        ),
                                    )
                                }
                            }

                        val token = response.body<TokenDto>()

                        tokenSettings.accessToken = token.accessToken ?: ""
                        tokenSettings.refreshToken = token.refreshToken ?: ""

                        BearerTokens(
                            accessToken = token.accessToken ?: "",
                            refreshToken = token.refreshToken ?: "",
                        )
                    } catch (e: Exception) {
                        e.printStackTrace()
                        tokenSettings.accessToken = ""
                        tokenSettings.refreshToken = ""
                        throw UnauthorizedException()
                    }
                }

            }
        }

        install(ContentNegotiation) {
            json(
                Json {
                    ignoreUnknownKeys = true
                    explicitNulls = false
                },
            )
        }
        defaultRequest {
            bearerAuth(
                tokenSettings.accessToken
            )
            headers {
                append(HttpHeaders.Accept, "application/json")
                append(HttpHeaders.ContentType, "application/json")
            }
        }
    }
}