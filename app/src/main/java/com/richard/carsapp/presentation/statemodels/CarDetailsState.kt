package com.richard.carsapp.presentation.statemodels

import com.richard.carsapp.domain.model.CarDeTails

data class CarDetailsState(
    val error: Boolean = false,
    val message: String = "",
    val isLoading: Boolean = false,
    val carDeTails: CarDeTails? = null
)
