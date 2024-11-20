package com.example.pmdm_navigation.pantallas

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController


@Composable
fun SecondScreen(navController: NavController, texto: String?) {
    SecondBody(navController, texto)
}


@Composable
fun SecondBody(navController: NavController, texto: String?) {
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Adioooo!!")

        Button(onClick = {navController.popBackStack()}) {
            Text("John Como Molo")
        }

        texto?.let {
            Text(it)
        }

    }

}