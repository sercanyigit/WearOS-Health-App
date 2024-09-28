package com.sercan.yigit.weros_health_app.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.wear.compose.material.Text
import com.sercan.yigit.weros_health_app.R


@Composable
fun AnimatedHeartRateItem(heartRate: Int, modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LottieAnimationComponent(
                animationFileName = R.raw.heart,
                modifier = Modifier.size(120.dp)
            )

            Text(
                text = "$heartRate bpm",
                color = Color.White,
                fontSize = 26.sp
            )
        }
    }
}