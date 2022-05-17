package com.richard.carsapp.presentation.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.richard.carsapp.presentation.screens.AllCarsScreen
import com.richard.carsapp.presentation.screens.DetailsScreen
import com.richard.carsapp.presentation.screens.MediaScreen

@Composable
fun NaviGationHos(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Routes.ALLCARS.name
    ) {
        composable(Routes.ALLCARS.name) {
            AllCarsScreen(navController)
        }
        composable(Routes.DETAILS.name) {
            DetailsScreen(navController)
        }
        composable(Routes.MEDIA.name) {
            MediaScreen(navController)
        }
    }
}