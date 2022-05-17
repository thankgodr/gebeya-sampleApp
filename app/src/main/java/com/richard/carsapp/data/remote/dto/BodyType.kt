package com.richard.carsapp.data.remote.dto


import com.google.gson.annotations.SerializedName

data class BodyType(
    @SerializedName("id")
    val id: Int,
    @SerializedName("imageUrl")
    val imageUrl: String,
    @SerializedName("name")
    val name: String
)