package com.richard.carsapp.presentation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.richard.carsapp.presentation.components.SingleCarMakeView
import com.richard.carsapp.presentation.components.SingleCarView
import com.richard.carsapp.presentation.viewmodels.MainViewModel

@Composable
fun AllCarsScreen(
    navController: NavController,
    viewModel: MainViewModel = hiltViewModel()
) {
    viewModel.startAllCard()
    viewModel.startAllMakes()
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            LazyRow(
                modifier = Modifier.padding(vertical = 16.dp)
            ) {
                items(viewModel.allMakes) { carMake ->
                    SingleCarMakeView(carMake = carMake)
                }
            }

            LazyColumn() {
                items(viewModel.allCars) { car ->
                    SingleCarView(car = car)
                }
            }
        }

        val state = viewModel.allcarsStates.value
        if (state.error) {
            Text(
                text = state.message,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )
        }
        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}