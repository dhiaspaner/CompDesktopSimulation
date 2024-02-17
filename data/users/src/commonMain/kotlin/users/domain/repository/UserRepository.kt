package users.domain.repository

import kotlinx.coroutines.flow.Flow
import users.domain.model.User

interface UserRepository {

    suspend fun addUser(user: User)

    suspend fun deleteUser(user: User)

    suspend fun updateUser(user: User)

    suspend fun getUsers() : List<User>

    suspend fun getUserFlow() : Flow<List<User>>

}