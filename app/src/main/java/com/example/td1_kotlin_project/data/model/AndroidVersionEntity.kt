package com.example.td1_kotlin_project.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "android_version")
data class AndroidVersionEntity(

    @ColumnInfo(name = "name")
    val name: String,


    @ColumnInfo(name = "code")
    val code: String,
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}



fun AndroidObject.toRoomObject(): AndroidVersionEntity {
    return AndroidVersionEntity(
        name = versionName,
        code = versionNumber,
    )
}


fun List<AndroidVersionEntity>.toDomain(): List<AndroidObject> {
    return map { eachItem ->
        AndroidObject(
            versionNumber = eachItem.code,
            versionName = eachItem.name,
        )
    }
}

