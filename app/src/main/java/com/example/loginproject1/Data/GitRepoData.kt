package com.example.loginproject1.Data

import com.google.gson.annotations.SerializedName

data class GetGitRepoData (

    @SerializedName("name")
    val name: String,
    @SerializedName("description")
    val description: String?,
    @SerializedName("updated_at")
    val updatedAt: String?,
    @SerializedName("language")
    val language: String?

    /*val language: String?
    var title: String,
    var sub : String,
    var date : String,
    var language :String,
    var btn : Int
    */

)