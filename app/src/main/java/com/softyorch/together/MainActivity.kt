package com.softyorch.together

import android.os.Bundle
import android.text.Editable
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.materialIcon
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.softyorch.together.ui.theme.TogetherTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ViewContainer()

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
        title = {
            Text(
                text = "Together",
                color = colorResource(id = R.color.primal_color)
            )

        },
        actions = {
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Rounded.Home,
                    contentDescription = "Together",
                    tint = colorResource(R.color.primal_color)
                )
            }
        },

/*        navigationIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_round_houses),
                contentDescription = ""
            )
        },*/
        backgroundColor = colorResource(id = R.color.back_ground)
    )
}

@Composable
fun Content() {

    var login by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    val dataOk: Boolean = (login.length >= 3 && password.length >= 8)

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
                        colors = TextFieldDefaults.textFieldColors(
                            placeholderColor = colorResource(R.color.text_hint),
                            textColor = colorResource(R.color.text_shadow),
                            errorCursorColor = Color.Red,
                            focusedIndicatorColor = colorResource(R.color.action_color),
                            unfocusedIndicatorColor = colorResource(R.color.text_hint)
                        ),
                        shape = RoundedCornerShape(
                            topStart = 0.dp,
                            topEnd = 30.dp,
                            bottomStart = 0.dp,
                            bottomEnd = 30.dp
                        ),
                        placeholder = {
                            Text(text = "Login")
                        }
                    )
                }
                Row {
                    TextField(
                        value = password,
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                        modifier = Modifier.align(Alignment.Bottom).padding(bottom = 16.dp),
                        colors = TextFieldDefaults.textFieldColors(
                            placeholderColor = colorResource(R.color.text_hint),
                            textColor = colorResource(R.color.text_shadow),
                            errorCursorColor = Color.Red,
                            focusedIndicatorColor = colorResource(R.color.action_color),
                            unfocusedIndicatorColor = colorResource(R.color.text_hint)
                        ),
                        shape = RoundedCornerShape(
                            topStart = 0.dp,
                            topEnd = 30.dp,
                            bottomStart = 0.dp,
                            bottomEnd = 30.dp
                        ),
                        onValueChange = {
                            password = it
                        },
                        placeholder = {
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
                        backgroundColor = colorResource(R.color.action_color),
                        contentColor = colorResource(R.color.text_shadow)
                    ),
                    enabled = dataOk

                ) {
                    Text(text = "Login")
                }
            }
        }
    }
}