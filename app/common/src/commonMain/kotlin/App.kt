import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import navigation.auth.login.LoginScreenNav
import cafe.adriel.voyager.navigator.Navigator

@Composable
fun App() {
    MaterialTheme {
        Navigator(LoginScreenNav())
    }
}