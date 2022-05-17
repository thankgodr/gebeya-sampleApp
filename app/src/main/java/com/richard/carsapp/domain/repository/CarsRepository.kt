package com.richard.carsapp.domain.repository

import com.richard.carsapp.domain.model.AllCarMakeResult
import com.richard.carsapp.domain.model.AllCarsResultModel
import com.richard.carsapp.domain.model.CarDeTails
import com.richard.carsapp.domain.model.CarMedia

interface CarsRepository {
    suspend fun getAllCars(currentPage: Int = 1): AllCarsResultModel
    suspend fun getMaKes(currentPage: Int = 1): AllCarMakeResult
    suspend fun getCarmedia(carid: String): CarMedia
    suspend fun getCardetails(carid: String): CarDeTails

}