package com.sercan.yigit.weros_health_app.data

import com.sercan.yigit.weros_health_app.data.model.MenuListModel
import com.sercan.yigit.weros_health_app.R
import com.sercan.yigit.weros_health_app.navigation.Screens

object MockData {
    val menuList = listOf(
        MenuListModel(R.drawable.ic_hearth_foreground, "Kalp Ritmi", Screens.HEARTH_RATE_SCREEN),
        MenuListModel(R.drawable.ic_steps_foreground, "Adımlar", Screens.STEP_COUNT_SCREEN)
    )
}