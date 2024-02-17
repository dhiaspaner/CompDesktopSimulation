package users.data.local.mapper

import migration.UserEntity
import users.domain.model.User

fun User.toUserEntity() =
    UserEntity(
        firstName = firstName,
        lastName = lastName,
        age = age.toLong(),
        birthDate = birthDate
    )

fun UserEntity.toUser() = User(
    firstName = firstName,
    lastName = lastName,
    age = age.toInt(),
    birthDate = birthDate
)