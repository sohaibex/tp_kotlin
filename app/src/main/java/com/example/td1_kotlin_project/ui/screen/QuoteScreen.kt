package com.example.td1_kotlin_project.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.td1_kotlin_project.ui.data.ChuckItemUi
import com.example.td1_kotlin_project.ui.screen.common.FloatingActionButtons
import com.example.td1_kotlin_project.ui.viewmodel.ChuckNorrisViewModel

@Composable
fun QuoteScreen() {
    val viewModel: ChuckNorrisViewModel = viewModel()
    val quotes = viewModel.quote.collectAsState(emptyList()).value

    Box(modifier = Modifier.fillMaxSize()) {
        QuoteList(quotes = quotes)

        getFloatingActionButtons(viewModel)
    }
}

@Composable
fun QuoteList(quotes: List<ChuckItemUi>) {
    LazyColumn(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        // Display each quote
        items(quotes) { quote ->
            QuoteItem(quote)
        }
    }
}

@Composable
fun QuoteItem(quote: ChuckItemUi) {
    Text(
        text = "Name = ${quote.quote}",
        modifier = Modifier
            .padding(8.dp)
            .background(Color.LightGray)
            .fillMaxWidth()
            .padding(16.dp),
        style = MaterialTheme.typography.bodyMedium,
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun getFloatingActionButtons(viewModel: ChuckNorrisViewModel) {
    FloatingActionButtons(
        firstIcon = Icons.Default.Add,
        firstContentDescription = "Add Quote",
        onFirstClick = { viewModel.insertNewQuote() },
        secondIcon = Icons.Default.Delete,
        secondContentDescription = "Delete All Quotes",
        onSecondClick = { viewModel.deleteAllQuote() }
    )

}
