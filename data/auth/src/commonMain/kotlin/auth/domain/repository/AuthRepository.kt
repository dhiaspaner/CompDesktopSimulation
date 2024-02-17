package auth.domain.repository

import auth.domain.model.LoginModel
import auth.domain.model.User

interface AuthRepository {
    suspend fun login(email: String, password: String) : Result<LoginModel>
    suspend fun signUp(newUser: User) : Result<User>

}