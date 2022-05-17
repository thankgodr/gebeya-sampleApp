package com.richard.carsapp.data.remote

import com.richard.carsapp.data.remote.dto.AllCarsDto
import com.richard.carsapp.data.remote.dto.AllMakeDto
import com.richard.carsapp.data.remote.dto.CarMEdiaDto
import com.richard.carsapp.data.remote.dto.CardetailsDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CarsAPI {
    @GET("v1/inventory/car/search")
    suspend fun getAllCars(): AllCarsDto

    @GET("v1/inventory/make")
    suspend fun getALlMakes(): AllMakeDto

    @GET("v1/inventory/car/{carId}")
    suspend fun getCarDetails(@Path("carId") carId: String): CardetailsDto

    @GET("v1/inventory/car_media")
    suspend fun getCardMedia(@Query("carId") carId: String): CarMEdiaDto

}