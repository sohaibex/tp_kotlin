package com.example.td1_kotlin_project.architecture

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.td1_kotlin_project.data.dao.AndroidVersionDao
import com.example.td1_kotlin_project.data.dao.ChuckNorrisDao
import com.example.td1_kotlin_project.data.model.AndroidVersionEntity
import com.example.td1_kotlin_project.data.model.ChuckNorrisEntity

@Database(
    entities = [
        AndroidVersionEntity::class,
        ChuckNorrisEntity::class
    ],
    version = 2,
    exportSchema = false
)
abstract class CustomRoomDatabase : RoomDatabase() {
    abstract fun androidVersionDao(): AndroidVersionDao
    abstract fun chuckNorrisDao(): ChuckNorrisDao

}