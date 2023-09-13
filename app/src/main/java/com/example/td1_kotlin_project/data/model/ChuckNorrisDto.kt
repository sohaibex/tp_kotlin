package com.example.td1_kotlin_project.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class ChuckNorrisDto(
    @Expose
    @SerializedName("value")
    val quote: String,


    @Expose
    @SerializedName("icon_url")
    val iconUrl: String


)

fun ChuckNorrisDto.toRoom(): ChuckNorrisEntity {
    return ChuckNorrisEntity(
        quote = quote,
        iconUrl = iconUrl
    )
}
