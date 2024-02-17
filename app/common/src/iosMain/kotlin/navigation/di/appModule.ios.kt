package navigation.di

import navigation.di.appModules
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration


actual fun initKoin(appDeclaration: KoinAppDeclaration) {
    startKoin {
        appDeclaration()
        modules(appModules)
    }
}