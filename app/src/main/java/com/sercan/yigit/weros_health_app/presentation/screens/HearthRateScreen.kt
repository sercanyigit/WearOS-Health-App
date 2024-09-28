package com.sercan.yigit.weros_health_app.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sercan.yigit.weros_health_app.presentation.MainViewModel
import com.sercan.yigit.weros_health_app.presentation.components.AnimatedHeartRateItem

@Composable
fun HearthRateScreen(viewModel: MainViewModel) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth().padding(16.dp),
    ) {
        val getHearRate = viewModel.getHeartRate.observeAsState()
        AnimatedHeartRateItem(heartRate = getHearRate.value ?: 0)
    }
}