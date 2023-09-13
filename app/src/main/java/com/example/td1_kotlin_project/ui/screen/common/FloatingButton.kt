package com.example.td1_kotlin_project.ui.screen.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp


@Composable
fun FloatingActionButtons(
    firstIcon: ImageVector,
    firstContentDescription: String,
    onFirstClick: () -> Unit,
    secondIcon: ImageVector,
    secondContentDescription: String,
    onSecondClick: () -> Unit,
    secondButtonColor: Color = Color.Red
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.BottomEnd
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            FloatingActionButton(
                content = { Icon(firstIcon, contentDescription = firstContentDescription) },
                onClick = onFirstClick
            )
            FloatingActionButton(
                content = { Icon(secondIcon, contentDescription = secondContentDescription) },
                onClick = onSecondClick,
                containerColor = secondButtonColor,
                contentColor = Color.White
            )
        }
    }
}