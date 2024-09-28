package com.sercan.yigit.weros_health_app.presentation.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.wear.compose.foundation.lazy.ScalingLazyColumn
import androidx.wear.compose.foundation.lazy.itemsIndexed
import androidx.wear.compose.foundation.lazy.rememberScalingLazyListState
import androidx.wear.compose.material.PositionIndicator
import androidx.wear.compose.material.Scaffold
import com.sercan.yigit.weros_health_app.data.MockData
import com.sercan.yigit.weros_health_app.presentation.components.MenuItemComponent

@Composable
fun HomeScreen(navController: NavHostController) {
    val scalingLazyListState = rememberScalingLazyListState()

    Scaffold (positionIndicator = { PositionIndicator(scalingLazyListState = scalingLazyListState) },
        modifier = Modifier.fillMaxSize().padding(top = 30.dp)
    ){
        ScalingLazyColumn(state = scalingLazyListState) {
            itemsIndexed(MockData.menuList) { index, menuItem ->
                MenuItemComponent(navController = navController, menuItem = menuItem)
            }
        }
    }
}