package users.ui.user

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import users.domain.model.User
import users.domain.repository.UserRepository
import utils.viewmodel.ViewModel

class UserViewModel(
    private val userRepository: UserRepository,
    override val scope: CoroutineScope,
    val state: MutableStateFlow<UserState>
) : ViewModel {
    fun onEvent(event: UserEvent) {
        when(event) {
            is UserEvent.AddUser -> onAddUser(event.user)
            is UserEvent.PickBirthDate -> onPickBirthDate(event.date)
        }
    }
    private fun onAddUser(user: User) {
        scope.launch {
            userRepository.addUser(user)
        }
    }
    private fun onPickBirthDate(date: Long) {
        state.update {
            it.copy(
                user = it.user?.copy(
                    birthDate = date.formatBirthDate()
                )
            )
        }
    }

    private fun Long.formatBirthDate() = with(this) {
        println(this)
        toString()
    }

}