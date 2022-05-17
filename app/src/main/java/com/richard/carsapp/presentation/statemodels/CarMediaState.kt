package com.richard.carsapp.presentation.statemodels

import com.richard.carsapp.domain.model.CarMedia

data class CarMediaState(
    val error: Boolean = false,
    val message: String = "",
    val isLoading: Boolean = false,
    val carMedia: CarMedia? = null
)
