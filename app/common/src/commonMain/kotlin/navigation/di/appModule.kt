package navigation.di


import auth.di.AuthModule
import database.di.databaseModule
import navigation.NavModule
import network.di.networkModule
import org.koin.dsl.KoinAppDeclaration
import org.koin.ksp.generated.module
import users.di.UsersModule


expect fun initKoin(appDeclaration: KoinAppDeclaration)


val appModules = listOf(
    networkModule,
    databaseModule,
    AuthModule().module,
    UsersModule().module,
    NavModule().module
)