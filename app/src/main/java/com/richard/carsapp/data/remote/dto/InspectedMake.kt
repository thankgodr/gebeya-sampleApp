package com.richard.carsapp.data.remote.dto


import com.google.gson.annotations.SerializedName

data class InspectedMake(
    @SerializedName("count")
    val count: Int,
    @SerializedName("imageUrl")
    val imageUrl: String,
    @SerializedName("name")
    val name: String
)