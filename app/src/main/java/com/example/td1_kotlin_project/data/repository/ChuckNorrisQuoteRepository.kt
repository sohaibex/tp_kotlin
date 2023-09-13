package com.example.td1_kotlin_project.data.repository

import com.example.td1_kotlin_project.architecture.CustomApplication
import com.example.td1_kotlin_project.architecture.RetrofitBuilder
import com.example.td1_kotlin_project.data.model.ChuckNorrisObject
import com.example.td1_kotlin_project.data.model.toDomain
import com.example.td1_kotlin_project.data.model.toRoom
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ChuckNorrisQuoteRepository {


    private val chuckNorrisDao = CustomApplication.instance.mApplicationDatabase.chuckNorrisDao()


    suspend fun fetchData() {
        chuckNorrisDao.insert(RetrofitBuilder.getChuckNorrisQuote().getRandomQuote().toRoom())
    }


    fun deleteAll() {
        chuckNorrisDao.deleteAll()
    }


    fun selectAll(): Flow<List<ChuckNorrisObject>> {
        return chuckNorrisDao.selectAll().map { list ->
            list.toDomain()
        }
    }
}
