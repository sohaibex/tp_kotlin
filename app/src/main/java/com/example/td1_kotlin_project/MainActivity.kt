package com.example.td1_kotlin_project

import HomeNavHost
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.td1_kotlin_project.ui.screen.common.MainTopBar
import com.example.td1_kotlin_project.ui.theme.TD1_kotlin_projectTheme

class MainActivity : ComponentActivity() {

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TD1_kotlin_projectTheme {
                val navController = rememberNavController()
                Scaffold(

                    topBar = {
                        MainTopBar(
                            text = "Android Cloud 2023",
                            navController = navController,
                        )
                    }

                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Spacer(modifier = Modifier.height(30.dp))
                        Box(
                            modifier = Modifier.fillMaxSize()
                        ) {
                            HomeNavHost(navController = navController)

                        }

                    }
                }
            }
        }
    }
}


