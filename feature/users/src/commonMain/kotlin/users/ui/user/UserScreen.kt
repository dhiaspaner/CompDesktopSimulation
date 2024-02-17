package users.ui.user

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SelectableDates
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import users.domain.model.User


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserScreen(
    state: UserState,
    onEvent: (UserEvent) -> Unit
) {

    var firstName by remember {
        mutableStateOf("")
    }

    var lastName by remember {
        mutableStateOf("")
    }

    var age by remember {
        mutableStateOf("")
    }

    var birthDate  by remember {
        mutableStateOf("")
    }


    val datePickerState = rememberDatePickerState(selectableDates = object : SelectableDates {
        override fun isSelectableDate(utcTimeMillis: Long): Boolean {
            onEvent(UserEvent.PickBirthDate(utcTimeMillis))
            return true
        }

    })

    Column (
        modifier = Modifier.fillMaxSize()
    ) {
        TextField(
            value = firstName,
            onValueChange = { newValue ->
                firstName = newValue
            },
            label =  {
                Text("first Name")
            }
        )

        Spacer(modifier = Modifier.height(20.dp))

        TextField(
            value = lastName,
            onValueChange = { newValue ->
                lastName = newValue
            },
            label =  {
                Text("Last Name")
            }
        )

        Spacer(modifier = Modifier.height(20.dp))


        TextField(
            value = age,
            onValueChange = { newValue ->
                age = newValue
            },
            label =  {
                Text("Age")
            }
        )

        Spacer(modifier = Modifier.height(20.dp))


        DatePicker(
            datePickerState
        )

        Button(
            onClick = {
                UserEvent.AddUser(
                    User(
                        firstName,
                        lastName,
                        age = age.toInt(),
                        birthDate = datePickerState.toString()
                    )
                )
            },
        ) {
            Text("ADD USER")
        }

    }
}