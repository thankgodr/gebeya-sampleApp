package com.richard.carsapp.presentation.statemodels

data class AllCarsStates(
    val error: Boolean = false,
    val message: String = "",
    val isLoading: Boolean = false
)