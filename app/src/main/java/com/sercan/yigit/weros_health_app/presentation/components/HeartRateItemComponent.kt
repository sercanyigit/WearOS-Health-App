package com.sercan.yigit.weros_health_app.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.wear.compose.material.Text
import com.sercan.yigit.weros_health_app.R


@Composable
fun AnimatedHeartRateItem(heartRate: Int) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LottieAnimationComponent(
            animationFileName = R.raw.heart,
            modifier = Modifier.size(110.dp)
        )

        if (heartRate == 0) {
            Text(
                text = "Lütfen bekleyin ölçüm yapılıyor",
                color = Color.White,
                fontSize = 14.sp,
                textAlign = TextAlign.Center
            )
        } else {
            Text(
                text = "$heartRate bpm",
                color = Color.White,
                fontSize = 26.sp
            )
        }
    }
}