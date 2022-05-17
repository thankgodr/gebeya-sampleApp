package com.richard.carsapp.domain.model

data class AllCarMakeResult(
    val carMakes: List<CarMake>,
    val currentPage: Int,
    val lastPage: Int
)
