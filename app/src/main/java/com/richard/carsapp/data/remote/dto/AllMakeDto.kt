package com.richard.carsapp.data.remote.dto


import com.google.gson.annotations.SerializedName
import com.richard.carsapp.domain.model.AllCarMakeResult
import com.richard.carsapp.domain.model.CarMake

data class AllMakeDto(
    @SerializedName("makeList")
    val makeList: List<Make>,
    @SerializedName("pagination")
    val pagination: PaginationX
)

fun AllMakeDto.toMatchModel(): AllCarMakeResult {
    return AllCarMakeResult(
        this.makeList.map {
            CarMake(
                it.id,
                it.imageUrl ?: "",
                it.name
            )
        },
        pagination.currentPage,
        pagination.pageSize
    )
}