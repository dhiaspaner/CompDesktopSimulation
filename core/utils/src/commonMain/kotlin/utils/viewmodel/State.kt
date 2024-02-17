package utils.viewmodel

data class State<T>(
    val isLoading: Boolean = false,
    val isFailure: Boolean = false,
    val isSuccess: Boolean = false,
    val data: T? = null,
) {
    companion object {

        fun <T> initial() = State<T>()

        fun <T> loading(data: T? = null) =
            State(
                isLoading = true,
                data = data
            )

        fun <T> failure(data: T? = null) =
            State(
                isFailure = true,
                data = data
            )

        fun <T> success(data: T? = null) =
            State(
                isSuccess = true,
                data = data
            )
    }
}