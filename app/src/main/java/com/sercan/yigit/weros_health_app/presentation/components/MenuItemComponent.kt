package com.sercan.yigit.weros_health_app.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.wear.compose.material.Card
import androidx.wear.compose.material.MaterialTheme
import androidx.wear.compose.material.Text
import com.sercan.yigit.weros_health_app.data.MockData
import com.sercan.yigit.weros_health_app.data.model.MenuListModel

@Composable
fun MenuItemComponent(navController: NavController, menuItem: MenuListModel) {
    Card(
        onClick = { navController.navigate(menuItem.navigateScreen) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 15.dp, end = 15.dp)
            .border(
                width = 1.dp, color = MaterialTheme.colors.primary,
                shape = RoundedCornerShape(30.dp)
            ),
        contentColor = Color.Black,
        shape = RoundedCornerShape(30.dp)
    ) {
        Column(
            Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = menuItem.icon),
                    contentDescription = null,
                    modifier = Modifier.width(35.dp)
                )
                Text(
                    text = menuItem.title,
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    style = MaterialTheme.typography.title3
                )
            }
        }
    }
}

@Preview
@Composable
fun MenuItemComponentPreview() {
    MenuItemComponent(
        navController = NavController(LocalContext.current),
        MockData.menuList.first()
    )
}


