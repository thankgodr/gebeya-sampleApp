package com.richard.carsapp.data.remote.dto


import com.google.gson.annotations.SerializedName

data class FinancingSettings(
    @SerializedName("loanCalculator")
    val loanCalculator: LoanCalculator
)