import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import navigation.di.initKoin

fun main() {
    initKoin { }
    application {
        Window(
            onCloseRequest = ::exitApplication,
            title = "KotlinStarter"
        ) {
            App()
        }
    }
}

@Preview
@Composable
private fun AppDesktopPreview() {
    App()
}
