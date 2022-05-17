package com.richard.carsapp.domain.model

data class AllCarsResultModel(
    val cars: List<Car>,
    val currentPage: Int,
    val lastPage: Int
)