package com.richard.carsapp.domain.model


import com.google.gson.annotations.SerializedName

data class InspectorDetails(
    @SerializedName("inspectedMakes")
    val inspectedMakes: List<InspectedMake>,
    @SerializedName("inspectorFullName")
    val inspectorFullName: String,
    @SerializedName("profileImageUrl")
    val profileImageUrl: String,
    @SerializedName("totalInspection")
    val totalInspection: Int,
    @SerializedName("workshopName")
    val workshopName: String
)