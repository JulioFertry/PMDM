package com.example.pmdm_navigation.pantallas


import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.pmdm_navigation.navegacion.AppScreen


@Composable
fun FirstScreen(navController: NavController) {
    FirstBody(navController)
}


@Composable
fun FirstBody(navController: NavController) {
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Hola!!")
        Button(onClick = {navController.navigate(route = AppScreen.SecondScreen.route) }) {
            Text("Vamonos Atomos!!")
        }

    }

}