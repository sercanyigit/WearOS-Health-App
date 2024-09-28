package com.sercan.yigit.weros_health_app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.wear.compose.navigation.SwipeDismissableNavHost
import androidx.wear.compose.navigation.composable
import com.sercan.yigit.weros_health_app.presentation.MainViewModel
import com.sercan.yigit.weros_health_app.presentation.screens.HearthRateScreen
import com.sercan.yigit.weros_health_app.presentation.screens.HomeScreen
import com.sercan.yigit.weros_health_app.presentation.screens.StepCountScreen

@Composable
fun AppNavigation(navController: NavHostController, viewModel: MainViewModel) {
    SwipeDismissableNavHost(
        navController = navController,
        startDestination = Screens.HOME_SCREEN
    ) {
        composable(Screens.HOME_SCREEN) {
            HomeScreen(navController = navController)
        }
        composable(Screens.HEARTH_RATE_SCREEN) {
            HearthRateScreen(viewModel = viewModel)
        }
        composable(Screens.STEP_COUNT_SCREEN) {
            StepCountScreen(viewModel = viewModel)
        }
    }
}