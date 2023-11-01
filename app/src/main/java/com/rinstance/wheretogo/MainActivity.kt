package com.rinstance.wheretogo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                App()
            }
        }
    }

    @Composable
    fun <T> state(init: T): MutableState<T> =
        remember { mutableStateOf(init) }

    @Composable
    fun App() {
        val f = remember { mutableStateOf(0) }
        val s = remember { mutableStateOf(0) }
        val t = remember { mutableStateOf(0) }
        val counterData = mapOf(
            "первый" to f,
            "второй" to s,
            "третий" to t,
        )
        Column {
            counterData.forEach { (title, counterState) ->
                Counter(title, counterState)
            }
            Button(
                onClick = {
                    counterData.forEach{ (_, countState) ->
                        countState.value++
                    }
                }
            ) {
                Text(text = "Increase All!",)
            }
        }

        SideEffect {
            Log.d("loggg", "App")
        }
    }

    @Composable
    fun Counter(
        text: String,
        countState: MutableState<Int>
    ) {
        Log.d("loggg", "countState $text ${countState.value}")
        Button(
            onClick = { countState.value += 1 }
        ) {
            Text(text = "$text: ${countState.value}")
        }
        SideEffect {
            Log.d("loggg", "Counter $text: ${countState.value}")
        }
    }

    @Composable
    fun Counter2() {
        val countState = remember { mutableStateOf(0) }
        Log.d("loggg", "countState ${countState.value}")
        Button(
            onClick = { countState.value += 1 }
        ) {
            Text(text = "test: ${countState.value}")
        }
        SideEffect {
            Log.d("loggg", "Counter2:")
        }
    }

    @Preview
    @Composable
    private fun AppNav() {
        val navController = rememberNavController()

        NavHost(navController = navController, startDestination = "auth") {
            navigation(
                startDestination = "login1",
                route = "auth"
            ) {
                composable(route = "login1") {
                    Button(onClick = {
                        navController.navigate("login2")
                    }) {
                        Text(text = "login1")
                    }
                }
                composable(route = "login2") {
                    Button(onClick = {
                        navController.navigate("home") {
                            popUpTo("auth") {
                                inclusive = true
                            }
                        }
                    }) {
                        Text(text = "login2")
                    }
                }
            }
            //-----
            navigation(
                startDestination = "home1",
                route = "home"
            ) {
                composable(route = "home1") {
                    Button(onClick = {
                        navController.navigate("home2")
                    }) {
                        Text(text = "home1")
                    }
                }
                composable(route = "home2") {
                    Button(onClick = {
//                        navController.navigate("home1")
                    }) {
                        Text(text = "home2")
                    }
                }
            }
        }
    }

}