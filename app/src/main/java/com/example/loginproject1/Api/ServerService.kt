package com.example.loginproject1.Api

import com.example.loginproject1.Data.FollowerData
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ServerService {
    @GET("api/users")
    fun getUsersList(
        @Query("page") page : Int //Query가 여러개 나오면 여러개 써주면 됨
    ) : Call<FollowerData>

}