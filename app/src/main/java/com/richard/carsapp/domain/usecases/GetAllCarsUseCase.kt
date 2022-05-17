package com.richard.carsapp.domain.usecases

import com.richard.carsapp.core.Resource
import com.richard.carsapp.domain.model.AllCarsResultModel
import com.richard.carsapp.domain.repository.CarsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetAllCarsUseCase @Inject constructor(
    private val repository: CarsRepository
) {

    operator fun invoke(page: Int = 1): Flow<Resource<AllCarsResultModel>> = flow {
        try {
            emit(Resource.Loading<AllCarsResultModel>())
            val res = repository.getAllCars(page)
            emit(Resource.Success<AllCarsResultModel>(res))
        } catch (e: HttpException) {
            emit(
                Resource.Error<AllCarsResultModel>(
                    e.localizedMessage ?: "An unexpected error occured"
                )
            )
        } catch (e: IOException) {
            emit(Resource.Error<AllCarsResultModel>("Couldn't reach server. Check your internet connection."))
        }
    }
}