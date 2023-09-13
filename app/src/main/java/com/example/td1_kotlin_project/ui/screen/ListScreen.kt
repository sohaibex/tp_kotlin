import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.SuggestionChipDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.td1_kotlin_project.ui.data.ItemUi
import com.example.td1_kotlin_project.ui.screen.common.FloatingActionButtons
import com.example.td1_kotlin_project.ui.viewmodel.ChuckNorrisViewModel


@Composable
fun ListScreen() {
    Column {
        MainColumn()
    }
}

@Composable
fun MainColumn() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        DisplayImage(url = "https://i.ytimg.com/vi/KEkrWRHCDQU/maxresdefault.jpg")
        Spacer(modifier = Modifier.height(16.dp))
        DisplayItems()
    }
}

@Composable
fun DisplayImage(url: String) {
    val painter = rememberAsyncImagePainter(
        ImageRequest.Builder(LocalContext.current).data(url).build()
    )
    Image(
        painter = painter,
        contentDescription = null,
        modifier = Modifier
            .height(200.dp)
            .fillMaxWidth()
    )
}

@Composable
fun DisplayItems() {
    val viewModel: AndroidVersionViewModel = viewModel()
    val list = viewModel.androidVersionList.collectAsState(emptyList()).value
    Box(modifier = Modifier.fillMaxSize()) {
        ItemsListWithHeaders(list)

        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            getFloatingActionButtons(viewModel = viewModel)
        }
    }
}

@Composable
fun ItemsListWithHeaders(items: List<ItemUi>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        itemsIndexed(items) { _, currentItem ->
            when (currentItem) {
                is ItemUi.Header -> CategoryChip(currentItem.title)
                is ItemUi.Item -> RatingChip(currentItem.versionNumber)
            }
        }
    }
}

@Composable
fun CategoryChip(category: String) {
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


@Composable
fun RatingChip(rating: String) {
    Box(
        modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center
    ) {
        SuggestionChip(colors = SuggestionChipDefaults.suggestionChipColors(
            containerColor = MaterialTheme.colorScheme.onTertiaryContainer,
            labelColor = MaterialTheme.colorScheme.errorContainer
        ), label = { Text(rating) }, onClick = {})
    }
}

@Composable
fun getFloatingActionButtons(viewModel: AndroidVersionViewModel) {
    FloatingActionButtons(
        firstIcon = Icons.Default.Add,
        firstContentDescription = "Add Version",
        onFirstClick = { viewModel.insertAndroidVersion() },
        secondIcon = Icons.Default.Delete,
        secondContentDescription = "Delete a version",
        onSecondClick = { viewModel.deleteAllAndroidVersion() }
    )

}

