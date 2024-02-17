package network.helper

import io.ktor.client.call.body
import io.ktor.client.statement.HttpResponse
import io.ktor.utils.io.errors.IOException
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext
import kotlinx.serialization.Serializable
import network.util.BadRequestException
import network.util.DataConversionException
import network.util.ServerErrorException
import network.util.UnauthorizedException
import network.util.UnknownNetworkException

suspend inline fun <reified T> handleErrors(crossinline response: suspend () -> HttpResponse): T =
    withContext(ioDispatcher) {
        var errorResponse: ErrorResponse? = null
        val httpResponse =
            try {
                response().also {
                    errorResponse = it.body<ErrorResponse>()
                }
            } catch (e: UnauthorizedException) {
                throw e
            } catch (e: Exception) {
                e.printStackTrace()
                throw UnknownNetworkException(e)
            }

        when (httpResponse.status.value) {
            in 200..299 -> Unit
            401 -> throw UnauthorizedException()
            in 400..499 -> throw BadRequestException(message = errorResponse?.message)
            in 500..599 -> throw ServerErrorException()
            else -> throw UnknownNetworkException()
        }

        return@withContext try {
            httpResponse.body<T>()
        } catch (e: Exception) {
            e.printStackTrace()
            throw DataConversionException(e)
        }
    }
@Serializable
data class ErrorResponse(
    val statusCode: Int? = null,
    val message: String? = null
)

suspend inline fun handleErrorsSimple(crossinline response: suspend () -> HttpResponse) =
    withContext(ioDispatcher) {
        val httpResponse =
            try {
                response()
            } catch (e: IOException) {
                throw UnknownNetworkException(e)
            }

        when (httpResponse.status.value) {
            in 200..299 -> Unit
            401 -> throw UnauthorizedException()
            in 400..499 -> throw BadRequestException()
            in 500..599 -> throw ServerErrorException()
            else -> throw UnknownNetworkException()
        }
    }

//expect val ioDispatcher: CoroutineDispatcher
val ioDispatcher: CoroutineDispatcher = kotlinx.coroutines.Dispatchers.IO