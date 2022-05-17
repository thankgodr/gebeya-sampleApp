package com.richard.carsapp.data.remote.dto


import com.google.gson.annotations.SerializedName

data class Model(
    @SerializedName("id")
    val id: Int,
    @SerializedName("imageUrl")
    val imageUrl: String,
    @SerializedName("make")
    val make: MakeX,
    @SerializedName("modelFeatures")
    val modelFeatures: List<Any>,
    @SerializedName("name")
    val name: String,
    @SerializedName("popular")
    val popular: Boolean,
    @SerializedName("wheelType")
    val wheelType: String
)