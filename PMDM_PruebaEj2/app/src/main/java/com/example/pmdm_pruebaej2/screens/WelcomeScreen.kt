package com.example.pmdm_pruebaej2.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.pmdm_pruebaej2.R
import com.example.pmdm_pruebaej2.components.NextScreenButton
import com.example.pmdm_pruebaej2.components.TextLogo
import com.example.pmdm_pruebaej2.navigation.AppScreen


@Composable
fun WelcomeScreen(navController: NavController) {
    WelcomeBody(navController)
}


@Composable
fun WelcomeBody(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.background_color)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextLogo()
        Spacer(modifier = Modifier.height(120.dp))
        NextScreenButton(
            onClickAct = {
                navController.navigate(route = AppScreen.MenuScreen.route + "/")
            }
        )
    }

}