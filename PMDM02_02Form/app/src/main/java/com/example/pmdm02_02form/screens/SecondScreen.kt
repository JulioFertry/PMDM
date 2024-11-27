package com.example.pmdm02_02form.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.pmdm02_02form.components.Message
import com.example.pmdm02_02form.components.TitleBox


@Composable
fun SecondScreen(navController: NavController, name: String, dni: String, age: Int) {
    SecondBody(navController, name, dni, age)
}


@Composable
fun SecondBody(navController: NavController, name: String, dni: String, age: Int) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {

        TitleBox("Bienvenido $dni al centro de desintoxicación")

        Spacer(modifier = Modifier.height(15.dp))

        Message("Enhorabuena $name por entrar a nuestro centro con solo $age años, prometemos total desintoxicación en 3 meses")

    }
}