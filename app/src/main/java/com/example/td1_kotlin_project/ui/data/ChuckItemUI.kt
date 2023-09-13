package com.example.td1_kotlin_project.ui.data

import com.example.td1_kotlin_project.data.model.ChuckNorrisObject

data class ChuckItemUi(
    val quote: String,
    val iconUrl: String,
)


fun List<ChuckNorrisObject>.toUi() : List<ChuckItemUi> {
    return map { item ->
        ChuckItemUi(
            quote = item.title,
            iconUrl = item.url,
        )
    }
}

