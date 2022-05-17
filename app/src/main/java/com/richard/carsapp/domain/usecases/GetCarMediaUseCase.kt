package com.richard.carsapp.domain.usecases

import com.richard.carsapp.core.Resource
import com.richard.carsapp.domain.model.CarMedia
import com.richard.carsapp.domain.repository.CarsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCarMediaUseCase @Inject constructor(
    private val repository: CarsRepository
) {

    operator fun invoke(carId: String): Flow<Resource<CarMedia>> = flow {
        try {
            emit(Resource.Loading<CarMedia>())
            val res = repository.getCarmedia(carId)
            emit(Resource.Success<CarMedia>(res))
        } catch (e: HttpException) {
            emit(Resource.Error<CarMedia>(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException) {
            emit(Resource.Error<CarMedia>("Couldn't reach server. Check your internet connection."))
        }
    }
}