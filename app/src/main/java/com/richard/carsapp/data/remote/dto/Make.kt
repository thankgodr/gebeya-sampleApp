package com.richard.carsapp.data.remote.dto


import com.google.gson.annotations.SerializedName

data class Make(
    @SerializedName("id")
    val id: Int,
    @SerializedName("imageUrl")
    val imageUrl: String,
    @SerializedName("name")
    val name: String
)