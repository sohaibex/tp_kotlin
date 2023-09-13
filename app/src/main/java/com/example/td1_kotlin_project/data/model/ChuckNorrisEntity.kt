package com.example.td1_kotlin_project.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "chuck_norris_table")
data class ChuckNorrisEntity(
    @ColumnInfo(name = "quote")
    val quote: String,


    @ColumnInfo(name = "icon")
    val iconUrl: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}
