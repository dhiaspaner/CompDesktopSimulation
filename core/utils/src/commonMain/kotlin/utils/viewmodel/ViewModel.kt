package utils.viewmodel

import io.ktor.utils.io.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.yield

interface ViewModel {
     val scope: CoroutineScope
}

fun <T> ViewModel.getData(
    getData: suspend () -> Result<T>,
    getState: () -> State<T> = { State.initial() },
    setState: (State<T>) -> Unit,
    ignoreLoading: Boolean = false,
    onSuccess: suspend (T) -> Unit = {},
    onFailure: suspend (Throwable) -> Unit = {},
): Job =
    scope.launch {
        getDataSuspend(
            getData = getData,
            getState = getState,
            setState = setState,
            ignoreLoading = ignoreLoading,
            onSuccess = onSuccess,
            onFailure = onFailure,
        )
    }

suspend fun <T> getDataSuspend(
    getData: suspend () -> Result<T>,
    getState: () -> State<T> = { State.initial() },
    setState: (State<T>) -> Unit,
    ignoreLoading: Boolean = false,
    onSuccess: suspend (T) -> Unit = {},
    onFailure: suspend (Throwable) -> Unit = {},
) {
   try {
       yield()
       if ( !ignoreLoading && getState().isLoading) return

       yield()

       setState(State.loading(getState().data))

       yield()

       getData()
           .onSuccess {
               yield()

               setState(State.success(it))
               onSuccess(it)
           }
           .onFailure {
               yield()
               setState(State.failure(getState().data))
               onFailure(it)
           }
   } catch (e: CancellationException) {
       setState(getState().copy(isLoading = false))
       onFailure(e)
   }
}

