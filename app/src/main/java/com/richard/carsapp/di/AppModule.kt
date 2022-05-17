package com.richard.carsapp.di

import com.richard.carsapp.core.Constants
import com.richard.carsapp.data.remote.CarsAPI
import com.richard.carsapp.data.repository.CarRepositoryImpl
import com.richard.carsapp.domain.repository.CarsRepository
import com.richard.carsapp.domain.usecases.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideAPi(): CarsAPI {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CarsAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideRepository(api: CarsAPI): CarsRepository {
        return CarRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideUsescase(repo: CarsRepository): UseCase {
        return UseCase(
            getAllCars = GetAllCarsUseCase(repo),
            getAllMakes = GetAllMakesUseCase(repo),
            getCardDetails = GetCarDetailsUseCase(repo),
            getCarmedia = GetCarMediaUseCase(repo)
        )
    }

}