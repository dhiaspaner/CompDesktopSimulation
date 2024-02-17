package users.ui.user

import users.domain.model.User

sealed class UserEvent {
    data class AddUser(val user: User) : UserEvent()
    data class PickBirthDate(val date: Long) : UserEvent()
}