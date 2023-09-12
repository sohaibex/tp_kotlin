package com.example.td1_kotlin_project

import androidx.activity.ComponentActivity
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

@Composable
fun MainTopBar(text: String, showBackButton: Boolean = false) {
    TopAppBar(
        title = { Text(text) },
        navigationIcon = {
            if (showBackButton) {
                val context = LocalContext.current
                IconButton(onClick = {
                    if (context is ComponentActivity) {
                        context.finish()
                    }
                }) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
                }
            }
        }
    )
}