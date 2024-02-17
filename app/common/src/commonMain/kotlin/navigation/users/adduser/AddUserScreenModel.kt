package navigation.users.adduser

import auth.domain.repository.AuthRepository
import cafe.adriel.voyager.core.model.StateScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import org.koin.core.annotation.Factory
import users.domain.repository.UserRepository
import users.ui.user.UserEvent
import users.ui.user.UserState
import users.ui.user.UserViewModel

@Factory
class AddUserScreenModel(
    userRepository: UserRepository
): StateScreenModel<UserState>(UserState()) {

    private val userViewModel = UserViewModel(
        userRepository = userRepository,
        scope = screenModelScope,
        state = mutableState
    )

    fun onEvent(event: UserEvent) {
        userViewModel.onEvent(event)
    }

}