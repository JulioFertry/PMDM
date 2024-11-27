package com.example.pmdm02_02form.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.pmdm02_02form.components.SendButton
import com.example.pmdm02_02form.components.StringBox
import com.example.pmdm02_02form.components.TextCheckBox
import com.example.pmdm02_02form.components.TitleBox
import com.example.pmdm02_02form.navigation.AppScreen
import com.example.pmdm02_02form.validations.Validation


@Composable
fun FirstScreen(navController: NavController) {
    FirstBody(navController)
}


@Composable
fun FirstBody(navController: NavController) {
    val validateObj = Validation()
    val userName = rememberSaveable { mutableStateOf("") }
    val userDni = rememberSaveable { mutableStateOf("") }
    val userAge = rememberSaveable { mutableStateOf("") }
    val termsAcceptance = rememberSaveable { mutableStateOf(false) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
    ) {

        TitleBox("Formulario")

        Spacer(modifier = Modifier.height(25.dp))

        StringBox(
            "Nombre",
            "Introduce tu nombre",
            userName.value,
            onTextChange = { userName.value = it }
        )

        Spacer(modifier = Modifier.height(10.dp))

        StringBox(
            "DNI",
            "Introduce tu DNI",
            userDni.value,
            onTextChange = { userDni.value = it }
        )

        Spacer(modifier = Modifier.height(10.dp))

        StringBox(
            "Edad",
            "Introduce tu edad",
            userAge.value,
            onTextChange = { userAge.value = it }
        )

        Spacer(modifier = Modifier.height(10.dp))

        TextCheckBox("Acepto vender mi alma a Mark Zuckerberg", termsAcceptance)

        Spacer(modifier = Modifier.height(10.dp))

        SendButton(
            onClickAct = {
                val validations = validateObj.validation(userName.value, userDni.value, userAge.value)
                var validRequest = true
                val errors = mutableListOf<String>()

                validations.forEach { validation ->
                    if (!validation.second) {
                        validRequest = false
                        errors.add(validation.first)
                    }
                }

                if (validRequest) {
                    navController.navigate(route = AppScreen.SecondScreen.route +
                            "/${userName.value}/${userDni.value}/${userAge.value.toInt()}")
                } else {
                    validations.forEach { validation ->
                        println(validation.first)
                    }
                }

            },
            isEnabled = termsAcceptance.value
        )

    }

}