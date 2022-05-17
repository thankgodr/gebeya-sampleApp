package com.richard.carsapp.data.remote.dto


import com.google.gson.annotations.SerializedName

data class CarMEdiaDto(
    @SerializedName("carMediaList")
    val carMediaList: List<CarMedia>,
    @SerializedName("pagination")
    val pagination: PaginationXX
)