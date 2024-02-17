package auth.ui.signIn

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import auth.domain.model.LoginModel

@Composable
fun SignUpScreen(
    onEvent: (LoginModel) -> Unit,
    onNavigation: () -> Unit,
    initialInput: String,
    initialPassword: String,
) {

    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }


    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        TextField(
            value = email,
            onValueChange = { newValue ->
                email += newValue
            },
            label = {
                Text("email /  phone number")
            }
        )

        Spacer(modifier = Modifier.height(10.dp))

        TextField(
            value = password,
            onValueChange = { newValue ->
                password += newValue
            },
            label = {
                Text("password")
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        )

    }
}