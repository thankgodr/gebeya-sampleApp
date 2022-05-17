package com.richard.carsapp.domain.model


import com.google.gson.annotations.SerializedName

data class Ranges(
    @SerializedName("maxDownPayment")
    val maxDownPayment: Double,
    @SerializedName("maxInterestRate")
    val maxInterestRate: Double,
    @SerializedName("minDownPayment")
    val minDownPayment: Double,
    @SerializedName("minInterestRate")
    val minInterestRate: Double,
    @SerializedName("tenure")
    val tenure: Int
)