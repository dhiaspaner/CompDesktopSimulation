package navigation.users

import cafe.adriel.voyager.core.registry.ScreenProvider

sealed class UserNavigation : ScreenProvider {

    enum class UserScreenMode{
        ADD,
        Update
    }

    data class UserScreen(val mode: UserScreenMode = UserScreenMode.ADD) : UserNavigation()
    data object DisplayUsers : UserNavigation()

}