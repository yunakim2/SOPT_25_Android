package com.example.loginproject1.Data

import com.google.gson.annotations.SerializedName

data class GetUserData (
    @SerializedName("login")
    val login: String,
    @SerializedName("avatar_url")
    val avatarUrl: String?,
    @SerializedName("name")
    val name: String,
    @SerializedName("bio")
    val bio: String?
)