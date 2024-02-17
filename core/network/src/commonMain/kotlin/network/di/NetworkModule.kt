package network.di

import network.createAuthHttpClient
import network.createNoAuthHttpClient
import org.koin.core.qualifier.named
import org.koin.dsl.module
import com.russhwolf.settings.Settings
import network.data.TokenSettings

val networkModule = module {
    single { Settings() }
    single { TokenSettings(get()) }
    single(named(NoAuth)) { createNoAuthHttpClient() }
    single(named(Auth)) { createAuthHttpClient(get(named(NoAuth)),get()) }
}

const val NoAuth = "NoAuth"
const val Auth = "Auth"