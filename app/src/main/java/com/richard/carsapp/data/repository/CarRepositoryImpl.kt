package com.richard.carsapp.data.repository

import com.richard.carsapp.data.remote.CarsAPI
import com.richard.carsapp.data.remote.dto.toMatchModel
import com.richard.carsapp.domain.model.AllCarMakeResult
import com.richard.carsapp.domain.model.AllCarsResultModel
import com.richard.carsapp.domain.model.CarDeTails
import com.richard.carsapp.domain.model.CarMedia
import com.richard.carsapp.domain.repository.CarsRepository
import javax.inject.Inject

class CarRepositoryImpl @Inject constructor(
    private val api: CarsAPI
) : CarsRepository {
    override suspend fun getAllCars(currentPage: Int): AllCarsResultModel {
        return api.getAllCars().toMatchModel()
    }

    override suspend fun getMaKes(currentPage: Int): AllCarMakeResult {
        return api.getALlMakes().toMatchModel()
    }

    override suspend fun getCarmedia(carid: String): CarMedia {
        return api.getCardMedia(carid) as CarMedia
    }

    override suspend fun getCardetails(carid: String): CarDeTails {
        return api.getCarDetails(carid) as CarDeTails
    }
}