package com.richard.carsapp.domain.model


import com.google.gson.annotations.SerializedName

data class FinancingSettings(
    @SerializedName("loanCalculator")
    val loanCalculator: LoanCalculator
)