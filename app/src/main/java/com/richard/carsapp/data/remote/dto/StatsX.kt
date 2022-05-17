package com.richard.carsapp.data.remote.dto


import com.google.gson.annotations.SerializedName

data class StatsX(
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