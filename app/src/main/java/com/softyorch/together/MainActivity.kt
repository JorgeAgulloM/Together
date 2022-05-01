package com.softyorch.together

import android.os.Bundle
import android.text.Editable
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.softyorch.together.ui.theme.TogetherTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ViewContainer()
            Greeting("Matrix")
        }
    }
}

@Preview
@Composable
fun ViewContainer() {
    Scaffold(
        topBar = { Toolbar() },
        content = { Content() }
    )
}

@Composable
fun Toolbar() {
    TopAppBar(
        title = { Text(text = "Together", color = colorResource(id = R.color.primal_color)) },
        backgroundColor = colorResource(id = R.color.back_ground)
    )
}

@Composable
fun Content() {

    var login by rememberSaveable { mutableStateOf("Text") }
    var password by rememberSaveable { mutableStateOf("Text") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.primal_color))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(bottom = 32.dp)

        ) {
            Column(modifier = Modifier.padding(bottom = 16.dp)) {
                Row {
                    //Imagen a mostrar
                    TextField(
                        modifier = Modifier.align(Alignment.Bottom).padding(bottom = 16.dp),
                        value = login,
                        onValueChange = {
                            login = it
                        },
                        label = {
                            Text(text = "Login")
                        }
                    )
                }
                Row {
                    TextField(
                        value = password,
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                        modifier = Modifier.align(Alignment.Bottom).padding(bottom = 16.dp),
                        onValueChange = {
                            password = it
                        },
                        label = {
                            Text(text = "Password")
                        }
                    )
                }
            }
            Row(
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Button(
                    onClick = {},
                    modifier = Modifier
                        .align(Alignment.Bottom),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = colorResource(R.color.back_ground),
                        contentColor = colorResource(R.color.primal_color)
                    )

                ) {
                    Text(text = "Login")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TogetherTheme {
        Greeting("Android")
    }
}