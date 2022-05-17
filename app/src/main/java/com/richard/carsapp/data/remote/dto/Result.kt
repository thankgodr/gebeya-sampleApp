package com.richard.carsapp.data.remote.dto


import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("bodyTypeId")
    val bodyTypeId: String,
    @SerializedName("city")
    val city: String,
    @SerializedName("depositReceived")
    val depositReceived: Boolean,
    @SerializedName("fuelType")
    val fuelType: String,
    @SerializedName("gradeScore")
    val gradeScore: Double,
    @SerializedName("hasFinancing")
    val hasFinancing: Boolean,
    @SerializedName("hasThreeDImage")
    val hasThreeDImage: Boolean,
    @SerializedName("hasWarranty")
    val hasWarranty: Boolean,
    @SerializedName("id")
    val id: String,
    @SerializedName("imageUrl")
    val imageUrl: String,
    @SerializedName("installment")
    val installment: Int,
    @SerializedName("licensePlate")
    val licensePlate: String,
    @SerializedName("loanValue")
    val loanValue: Double,
    @SerializedName("marketplaceOldPrice")
    val marketplaceOldPrice: Int,
    @SerializedName("marketplacePrice")
    val marketplacePrice: Int,
    @SerializedName("marketplaceVisibleDate")
    val marketplaceVisibleDate: String,
    @SerializedName("mileage")
    val mileage: Int,
    @SerializedName("mileageUnit")
    val mileageUnit: String,
    @SerializedName("sellingCondition")
    val sellingCondition: String,
    @SerializedName("sold")
    val sold: Boolean,
    @SerializedName("state")
    val state: String,
    @SerializedName("stats")
    val stats: Stats,
    @SerializedName("title")
    val title: String,
    @SerializedName("transmission")
    val transmission: String,
    @SerializedName("websiteUrl")
    val websiteUrl: String,
    @SerializedName("year")
    val year: Int
)