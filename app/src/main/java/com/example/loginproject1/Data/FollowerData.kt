package com.example.loginproject1.Data

import com.google.gson.annotations.SerializedName

data class FollowerData (
var page : Int,
@SerializedName("per_page")
var perPage :Int,
var total : Int,
@SerializedName("total_pages")
var totalPages:Int,
var data : List<GetFollowerPageResponseData>
)

data class  GetFollowerPageResponseData(
    var id : Int ,
    var email : String,
    @SerializedName("first_name") // 서버에서 명칭한 이름
    var firstName : String, // 바꾸고자 하는 이름
    @SerializedName("last_name") // 서버에서 명칭한 이름
    var lastName:String,
    var avatar : String
)
