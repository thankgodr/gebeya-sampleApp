package com.richard.carsapp.data.remote.dto


import com.google.gson.annotations.SerializedName
import com.richard.carsapp.domain.model.AllCarsResultModel
import com.richard.carsapp.domain.model.Car

data class AllCarsDto(
    @SerializedName("pagination")
    val pagination: Pagination,
    @SerializedName("result")
    val result: List<Result>
)

fun AllCarsDto.toMatchModel(): AllCarsResultModel {
    return AllCarsResultModel(
        this.result.map {
            Car(
                it.bodyTypeId, it.city, it.depositReceived, it.fuelType, it.gradeScore,
                it.hasFinancing, it.hasThreeDImage, it.hasWarranty, it.id, it.imageUrl,
                it.installment, it.licensePlate, it.loanValue, it.marketplaceOldPrice,
                it.marketplacePrice, it.marketplaceVisibleDate, it.mileage, it.mileageUnit,
                it.sellingCondition, it.sold, it.state, it.stats.stats(), it.title, it.transmission,
                it.websiteUrl, it.year
            )
        },
        this.pagination.currentPage,
        this.pagination.pageSize
    )
}