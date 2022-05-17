package com.richard.carsapp.domain.model


import com.google.gson.annotations.SerializedName

data class LoanCalculator(
    @SerializedName("defaultValues")
    val defaultValues: DefaultValues,
    @SerializedName("loanPercentage")
    val loanPercentage: Double,
    @SerializedName("ranges")
    val ranges: Ranges
)