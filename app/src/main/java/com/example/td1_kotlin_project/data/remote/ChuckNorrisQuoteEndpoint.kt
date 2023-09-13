package com.example.td1_kotlin_project.data.remote

import com.example.td1_kotlin_project.data.model.ChuckNorrisDto
import retrofit2.http.GET

interface ChuckNorrisQuoteEndpoint {


    @GET("random")
    suspend fun getRandomQuote(): ChuckNorrisDto
}
