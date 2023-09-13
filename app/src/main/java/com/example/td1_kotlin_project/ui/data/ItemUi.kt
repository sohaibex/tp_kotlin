package com.example.td1_kotlin_project.ui.data

import com.example.td1_kotlin_project.data.model.AndroidObject

sealed interface ItemUi {
    data class Item(
        val versionNumber: String,
    ) : ItemUi


    data class Header(
        val title: String,
    ) : ItemUi

}


fun List<AndroidObject>.toUi(): List<ItemUi.Item> {
    return map { currentAndroidObject ->
        ItemUi.Item(
            versionNumber = currentAndroidObject.versionNumber,
        )
    }
}

