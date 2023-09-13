package com.example.td1_kotlin_project.data.repository

import com.example.td1_kotlin_project.architecture.CustomApplication
import com.example.td1_kotlin_project.data.model.AndroidObject
import com.example.td1_kotlin_project.data.model.toDomain
import com.example.td1_kotlin_project.data.model.toRoomObject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


class AndroidVersionRepository {
    private val mAndroidVersionDao =
        CustomApplication.instance.mApplicationDatabase.androidVersionDao()


    fun selectAllAndroidVersion(): Flow<List<AndroidObject>> {
        return mAndroidVersionDao.selectAll().map {
            it.toDomain()
        }
    }


    fun insertAndroidVersion(androidObject: AndroidObject) {
        mAndroidVersionDao.insert(androidObject.toRoomObject())
    }


    fun deleteAllAndroidVersion() {
        mAndroidVersionDao.deleteAll()
    }

}

