package com.richard.carsapp.domain.usecases

data class UseCase(
    val getAllCars: GetAllCarsUseCase,
    val getAllMakes: GetAllMakesUseCase,
    val getCardDetails: GetCarDetailsUseCase,
    val getCarmedia: GetCarMediaUseCase
)
