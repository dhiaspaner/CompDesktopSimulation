package auth.data.repository

import auth.data.remote.response.SignUpDto
import auth.data.remote.AuthRemoteDataSource
import auth.domain.model.LoginModel
import auth.domain.model.User
import auth.domain.repository.AuthRepository
import org.koin.core.annotation.Single

@Single
internal class AuthRepositoryImpl(
    private val remote: AuthRemoteDataSource
): AuthRepository {

    override suspend fun login(email: String, password: String): Result<LoginModel> =
        runCatching {
            remote.login(
                emailOrPhoneNb = email,
                password = password
            ).data?.toModel() ?: throw Exception("No Data")
        }

    override suspend fun signUp(newUser: User): Result<User> =
        runCatching {
            remote.signup(
                signUpRequest = SignUpDto.formUser(newUser)
            )
        }
}