package com.houzerd.todocompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import com.houzerd.todocompose.ui.theme.TodoComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TodoComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    App()
                }
            }
        }
    }
}

@Composable
fun App() {
    val todos = mutableListOf("Go to school", "Go to work", "Go to home")
    val textState = remember { mutableStateOf(TextFieldValue()) }


    

    Column {
        TopAppBar(title = { Text("Todo App Compose") })
        Row(verticalAlignment = Alignment.CenterVertically) {
            TextField(
                value = textState.value,
                onValueChange = { textState.value = it },
                placeholder = { Text(text = "Add new Todo") }
            )
            Button(onClick = { }, content = { Text("Add") })
        }

        Column {
            todos.forEach {
                todo -> Text(todo)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TodoComposeTheme {
        App()
    }
}