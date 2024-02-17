package users.data.local

import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import database.Database
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.koin.core.annotation.Single
import users.data.local.mapper.toUser
import users.data.local.mapper.toUserEntity
import users.domain.model.User

@Single
internal class UserLocalDataSource(
    database: Database
) {


    private val userQueries = database.userEntityQueries


    fun getAllUsers(): List<User> {
        return userQueries.getAllUsers().executeAsList().map { it.toUser() }
    }

    fun getUserFlow(): Flow<List<User>> =
        userQueries.getAllUsers().asFlow().mapToList(Dispatchers.IO).map {
            it.map { userEntity -> userEntity.toUser() }
        }


    suspend fun addUser(user: User) {
        userQueries.insert(user.toUserEntity())
    }

    suspend fun updateUser(user: User) {
        userQueries.update(
            user.firstName,
            user.lastName,
            user.age.toLong(),
            user.birthDate
        )
    }


    suspend fun deleteUser(lastName: String, firstName: String) {
        userQueries.delete(lastName, firstName)
    }


}