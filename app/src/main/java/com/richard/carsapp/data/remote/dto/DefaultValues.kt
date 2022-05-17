package com.richard.carsapp.data.remote.dto


import com.google.gson.annotations.SerializedName

data class DefaultValues(
    @SerializedName("downPayment")
    val downPayment: Double,
    @SerializedName("interestRate")
    val interestRate: Double,
    @SerializedName("tenure")
    val tenure: Int
)