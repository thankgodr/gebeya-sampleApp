package com.richard.carsapp.domain.usecases

import com.richard.carsapp.core.Resource
import com.richard.carsapp.domain.model.CarDeTails
import com.richard.carsapp.domain.repository.CarsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCarDetailsUseCase @Inject constructor(
    private val repository: CarsRepository
) {

    operator fun invoke(carId: String): Flow<Resource<CarDeTails>> = flow {
        try {
            emit(Resource.Loading<CarDeTails>())
            val res = repository.getCardetails(carId)
            emit(Resource.Success<CarDeTails>(res))
        } catch (e: HttpException) {
            emit(Resource.Error<CarDeTails>(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException) {
            emit(Resource.Error<CarDeTails>("Couldn't reach server. Check your internet connection."))
        }
    }
}