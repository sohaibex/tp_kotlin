package com.example.td1_kotlin_project

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.td1_kotlin_project.ui.theme.TD1_kotlin_projectTheme

class MainActivity : ComponentActivity() {

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TD1_kotlin_projectTheme {
                Scaffold(
                    topBar = { MainTopBar(text = "Android Cloud 2023") }
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Greeting("My name is EL MEDIOUNI Sohaib")
                        Spacer(modifier = Modifier.height(16.dp))
                        Button(onClick = {
                            startActivity(Intent(this@MainActivity, MainActivity2::class.java))
                        }) {
                            Text(text = "Navigate to the fruits ratings")
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TD1_kotlin_projectTheme {
        Greeting("Android")
    }
}
