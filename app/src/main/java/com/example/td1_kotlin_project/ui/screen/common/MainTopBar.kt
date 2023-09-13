package com.example.td1_kotlin_project.ui.screen.common

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun MainTopBar(
    text: String,
    navController: NavController,
) {

    TopAppBar(
        title = { Text(text) },
        navigationIcon = {

            IconButton(onClick = {
                navController.popBackStack()
            }) {
                Icon(imageVector = Icons.Rounded.ArrowBack, contentDescription = null)
            }

        }
    )
}
