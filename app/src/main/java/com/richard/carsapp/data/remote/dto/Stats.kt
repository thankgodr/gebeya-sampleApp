package com.richard.carsapp.data.remote.dto


import com.google.gson.annotations.SerializedName

data class Stats(
    @SerializedName("appViewCount")
    val appViewCount: Int,
    @SerializedName("appViewerCount")
    val appViewerCount: Int,
    @SerializedName("interestCount")
    val interestCount: Int,
    @SerializedName("processedLoanCount")
    val processedLoanCount: Int,
    @SerializedName("testDriveCount")
    val testDriveCount: Int,
    @SerializedName("webViewCount")
    val webViewCount: Int,
    @SerializedName("webViewerCount")
    val webViewerCount: Int
)

fun Stats.stats(): com.richard.carsapp.domain.model.Stats {
    return com.richard.carsapp.domain.model.Stats(
        this.appViewCount, this.appViewerCount, this.interestCount, this.processedLoanCount,
        this.testDriveCount, this.webViewCount, this.webViewerCount
    )
}