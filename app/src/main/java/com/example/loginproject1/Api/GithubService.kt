package com.example.loginproject1.Api

import com.example.loginproject1.Data.GetGitRepoData
import com.example.loginproject1.Data.GetUserData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubService {
    @GET("/users/{login}")
    fun getUser(
        @Path("login") login: String
    ): Call<GetUserData>

    @GET("/users/{login}/repos")
    fun getRepos(
        @Path("login") login: String
    ): Call<List<GetGitRepoData>>
}