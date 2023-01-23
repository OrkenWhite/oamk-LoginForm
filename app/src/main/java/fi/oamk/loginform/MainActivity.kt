package fi.oamk.loginform

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fi.oamk.loginform.ui.theme.LoginFormTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginFormTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    LoginForm()
                }
            }
        }
    }
}

@Composable
fun LoginForm() {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.padding(8.dp).fillMaxWidth()
    ){
        Text(
            stringResource(R.string.loginText),
            color= MaterialTheme.colors.primary,
            fontSize = 24.sp,
            modifier = Modifier.padding(vertical = 24.dp)
        )
        OutlinedTextField(
            value = username,
            onValueChange ={username = it},
            label = {Text(stringResource(R.string.usernameText))},
            trailingIcon = { Icon(imageVector = Icons.Default.Person , contentDescription = stringResource(R.string.usernameText))},
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = password,
            onValueChange = {password = it},
            visualTransformation = PasswordVisualTransformation(),
            label = {Text(stringResource(R.string.passwordText))},
            trailingIcon = { Icon(imageVector = Icons.Default.Lock , contentDescription = stringResource(R.string.passwordText))},
            modifier = Modifier.fillMaxWidth()
        )
        Button(
            onClick = {},
            modifier = Modifier.fillMaxWidth()
        ){
          Text(text = stringResource(R.string.loginText))
        }
    }
}