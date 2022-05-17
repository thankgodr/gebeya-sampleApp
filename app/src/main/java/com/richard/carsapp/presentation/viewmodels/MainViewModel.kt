package com.richard.carsapp.presentation.viewmodels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.richard.carsapp.core.Resource
import com.richard.carsapp.domain.model.Car
import com.richard.carsapp.domain.model.CarMake
import com.richard.carsapp.domain.usecases.UseCase
import com.richard.carsapp.presentation.statemodels.AllCarsStates
import com.richard.carsapp.presentation.statemodels.CarDetailsState
import com.richard.carsapp.presentation.statemodels.CarMediaState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val useCase: UseCase
) : ViewModel() {

    ///ALL Cars
    private val _allCars = mutableStateListOf<Car>()
    val allCars: List<Car> = _allCars
    private val _allcarsStates = mutableStateOf(AllCarsStates())
    val allcarsStates: State<AllCarsStates> = _allcarsStates


    //All Car Make
    private val _allCarMake = mutableStateListOf<CarMake>()
    val allMakes: List<CarMake> = _allCarMake

    //Cardetails
    private val _carDetails = mutableStateOf(CarDetailsState())
    val carDetails: State<CarDetailsState> = _carDetails


    //CarMedia
    private val _carMediaData = mutableStateOf(CarMediaState())
    val carMediaData: State<CarMediaState> = _carMediaData


    fun startAllCard() {
        getAllCars()
    }

    fun startAllMakes() {
        getAllMakes()
    }

    fun getDetails(cardId: String) {
        getDetails(cardId)
    }

    fun getMedia(cardId: String) {
        getCarMedia(cardId)
    }


    private fun getAllCars(currentPage: Int = 1) {
        useCase.getAllCars(currentPage).onEach { resource ->
            when (resource) {
                is Resource.Loading -> {
                    _allcarsStates.value = AllCarsStates(isLoading = true)
                }
                is Resource.Success -> {
                    _allcarsStates.value = AllCarsStates(isLoading = false)
                    resource.data?.let { _allCars.addAll(it.cars) }

                }
                is Resource.Error -> {
                    _allcarsStates.value = AllCarsStates(
                        error = true,
                        message = resource.message ?: "unknown error"
                    )
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun getAllMakes(currentPage: Int = 1) {
        useCase.getAllMakes(currentPage).onEach { resource ->
            when (resource) {
                is Resource.Loading -> {
                    _allcarsStates.value = AllCarsStates(isLoading = true)
                }
                is Resource.Success -> {
                    _allcarsStates.value = AllCarsStates(isLoading = false)
                    resource.data?.let { _allCarMake.addAll(it.carMakes) }
                }
                is Resource.Error -> {
                    _allcarsStates.value = AllCarsStates(
                        error = true,
                        message = resource.message ?: "unknown error"
                    )
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun getCardDetails(cardId: String) {
        useCase.getCardDetails(cardId).onEach { resource ->
            when (resource) {
                is Resource.Loading -> {
                    _carDetails.value = CarDetailsState(
                        isLoading = true
                    )
                }
                is Resource.Success -> {
                    _carDetails.value = CarDetailsState(
                        carDeTails = resource.data
                    )
                }
                is Resource.Error -> {
                    _carDetails.value = CarDetailsState(
                        error = true,
                        message = resource.message ?: "Unknown Error"
                    )
                }
            }
        }
    }

    private fun getCarMedia(cardId: String) {
        useCase.getCarmedia(cardId).onEach { resource ->
            when (resource) {
                is Resource.Loading -> {
                    _carMediaData.value = CarMediaState(
                        isLoading = true
                    )
                }
                is Resource.Success -> {
                    _carMediaData.value = CarMediaState(
                        carMedia = resource.data
                    )
                }
                is Resource.Error -> {
                    _carMediaData.value = CarMediaState(
                        error = false,
                        message = resource.message ?: "unknown error"
                    )
                }
            }
        }
    }


}