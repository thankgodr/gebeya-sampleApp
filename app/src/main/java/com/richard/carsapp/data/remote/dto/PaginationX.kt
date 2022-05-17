package com.richard.carsapp.data.remote.dto


import com.google.gson.annotations.SerializedName

data class PaginationX(
    @SerializedName("currentPage")
    val currentPage: Int,
    @SerializedName("pageSize")
    val pageSize: Int,
    @SerializedName("total")
    val total: Int
)