package com.example.td1_kotlin_project.data.model

data class ChuckNorrisObject(
    val title: String,
    val url: String,
)


fun List<ChuckNorrisEntity>.toDomain(): List<ChuckNorrisObject> {
    return map { eachEntity ->
        ChuckNorrisObject(
            title = eachEntity.quote,
            url = eachEntity.iconUrl,
        )
    }
}
