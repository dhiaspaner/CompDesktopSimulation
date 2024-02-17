package users.data.repository

import kotlinx.coroutines.flow.Flow
import org.koin.core.annotation.Single
import users.data.local.UserLocalDataSource
import users.domain.model.User
import users.domain.repository.UserRepository
@Single
internal class UserRepositoryImpl(
    private val usersLocalDataSource: UserLocalDataSource
) : UserRepository {
    override suspend fun addUser(user: User) = usersLocalDataSource.addUser(user)
    override suspend fun deleteUser(user: User) =
        usersLocalDataSource.deleteUser(user.lastName, user.firstName)
    override suspend fun updateUser(user: User) =
        usersLocalDataSource.updateUser(user)
    override suspend fun getUsers() = usersLocalDataSource.getAllUsers()
    override suspend fun getUserFlow() = usersLocalDataSource.getUserFlow()
}