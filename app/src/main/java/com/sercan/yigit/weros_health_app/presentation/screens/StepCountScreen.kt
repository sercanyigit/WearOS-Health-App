package com.sercan.yigit.weros_health_app.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.wear.compose.material.MaterialTheme
import androidx.wear.compose.material.Text
import com.sercan.yigit.weros_health_app.R
import com.sercan.yigit.weros_health_app.presentation.MainViewModel
import com.sercan.yigit.weros_health_app.presentation.components.LottieAnimationComponent


@Composable
fun StepCountScreen(viewModel: MainViewModel) {
    val getStep = viewModel.getStep.observeAsState()
    val step = getStep.value ?: 0

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
    ) {
        LottieAnimationComponent(
            animationFileName = R.raw.running,
            modifier = Modifier.size(120.dp)
        )

        Text(
            text = "$step steps",
            style = MaterialTheme.typography.title1,
            fontSize = 22.sp,
            color = Color.White
        )
    }
}