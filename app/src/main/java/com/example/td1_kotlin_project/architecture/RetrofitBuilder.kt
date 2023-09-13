package com.example.td1_kotlin_project.architecture

import com.example.td1_kotlin_project.data.remote.ChuckNorrisQuoteEndpoint
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {


    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://api.chucknorris.io/jokes/")
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
        .build()


    fun getChuckNorrisQuote(): ChuckNorrisQuoteEndpoint =
        retrofit.create(ChuckNorrisQuoteEndpoint::class.java)
}
