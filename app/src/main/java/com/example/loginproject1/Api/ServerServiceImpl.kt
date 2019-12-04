package com.example.loginproject1.Api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServerServiceImpl {
    private const val BASE_URL = "https://reqres.in/"

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service : ServerService = retrofit.create(ServerService::class.java)
}