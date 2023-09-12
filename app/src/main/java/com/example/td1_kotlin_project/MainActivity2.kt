package com.example.td1_kotlin_project

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.td1_kotlin_project.ui.theme.TD1_kotlin_projectTheme

data class Item(val category: String, val ratings: List<String>)

class MainActivity2 : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TD1_kotlin_projectTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {
                                Text("Android Cloud 2023")
                            },
                        )
                    }
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp)
                    ) {
                        ImageFromUrl(url = "https://i.ytimg.com/vi/KEkrWRHCDQU/maxresdefault.jpg")
                        Spacer(modifier = Modifier.height(16.dp))
                        val items = listOf(
                            Item("Honey Comb", listOf("3.0", "3.1", "3.2")),
                            Item("Ice Cream Sandwich", listOf("4.0", "4.1")),
                            Item("Jelly Bean", listOf("5.0")),
                            Item("Kitkat", listOf("6.0", "6.1"))
                        ).groupBy { it.category }
                        ItemsListWithHeaders(items)
                    }
                }
            }
        }
    }
}

@Composable
fun ImageFromUrl(url: String) {
    val painter = rememberAsyncImagePainter(
        ImageRequest.Builder(LocalContext.current)
            .data(url)
            .build()
    )
    Image(
        painter = painter,
        contentDescription = null,
        modifier = Modifier
            .height(200.dp)
            .fillMaxWidth()
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemsListWithHeaders(items: Map<String, List<Item>>) {
    LazyColumn {
        items.forEach { (category, itemList) ->
            item {
                SuggestionChip(
                    colors = SuggestionChipDefaults.suggestionChipColors(
                        containerColor = MaterialTheme.colorScheme.errorContainer,
                        labelColor = MaterialTheme.colorScheme.onErrorContainer
                    ),
                    label = { Text(category) },
                    onClick = {},
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                )
            }

            itemList.forEach { item ->
                items(item.ratings) { rating ->
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        SuggestionChip(
                            colors = SuggestionChipDefaults.suggestionChipColors(
                                containerColor = MaterialTheme.colorScheme.onTertiaryContainer,
                                labelColor = MaterialTheme.colorScheme.errorContainer
                            ),
                            label = { Text(rating) },
                            onClick = {}
                        )
                    }
                }
            }
        }
    }


}
