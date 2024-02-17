package network.util

open class NetworkException(message: String? = null, cause: Throwable? = null) :
    Exception(message, cause)

class UnauthorizedException(cause: Throwable? = null) :
    NetworkException(message = "Unauthorized", cause = cause)

class ServerErrorException : NetworkException(message = "Server error")

class BadRequestException(message: String? = "Bad request") : NetworkException(message = message)

class DataConversionException(cause: Throwable? = null) :
    NetworkException(message = "Data conversion error", cause = cause)

class UnknownNetworkException(cause: Throwable? = null) :
    NetworkException(message = "Unknown network error $cause", cause = cause)