package com.sercan.yigit.weros_health_app.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.wear.compose.material.MaterialTheme
import androidx.wear.compose.material.Text
import com.sercan.yigit.weros_health_app.R

@Composable
fun StepCountComponent(step: Int) {

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize().padding(16.dp)
        ) {
            LottieAnimationComponent(
                animationFileName = R.raw.running,
                modifier = Modifier.size(110.dp)
            )

            if(step == 0) {
                Text(
                    text = "Lütfen bekleyin",
                    color = Color.White,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center
                )
            }else {
                Text(
                    text = "$step steps",
                    style = MaterialTheme.typography.title1,
                    fontSize = 22.sp,
                    color = Color.White
                )
            }

        }

}

