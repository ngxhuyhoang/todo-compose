package com.houzerd.todocompose.ui.composable

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun App() {
    val taskInput = remember { mutableStateOf("") }

    Column {
        TopAppBar(
            title = { Text("Todo Compose") }
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = taskInput.value,
                onValueChange = { taskInput.value = it },
                placeholder = { Text("New task here") },
                label = { Text("New task here") }
            )
            Button(
                onClick = { print("Pressed") },
                content = { Text("Add new task") },
            )
        }
    }
}