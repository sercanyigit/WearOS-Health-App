package com.sercan.yigit.weros_health_app.presentation.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import com.sercan.yigit.weros_health_app.presentation.MainViewModel
import com.sercan.yigit.weros_health_app.presentation.components.StepCountComponent


@Composable
fun StepCountScreen(viewModel: MainViewModel) {
    val getStep = viewModel.getStep.observeAsState()
    StepCountComponent(step = getStep.value ?: 0)
}