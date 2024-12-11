package com.example.pmdm_pruebaej2.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pmdm_pruebaej2.R


/** Logo de la app + Titulo de la app colocados de forma lineal */
@Composable
fun TextLogo() {
    Row {
        // Logo de la app
        Image(
            painter = painterResource(id = R.drawable.marketlogo),
            contentDescription = "Texto + Logo",
            modifier = Modifier.size(70.dp)
        )

        // Espaciado horizontal para separar el Logo del Titulo
        Spacer(modifier = Modifier.width(8.dp))

        // Titulo de la app
        Text(
            text = "Cádiz Market",
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 35.sp,
        color = colorResource(id = R.color.cadiz_yellow)
            )
        )
    }

}


/** Boton para navegar a la ventana del menu
 *
 * @param onClickAct Recibe el comportamiento del boton al pulsarlo, en este caso cambia de pantalla
 */
@Composable
fun NextScreenButton(onClickAct: () -> Unit) {
    Button(
        onClick = onClickAct,
        shape = RoundedCornerShape(8.dp),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 15.dp,
            pressedElevation = 5.dp
        ),
        colors = ButtonDefaults.buttonColors(
            containerColor = colorResource(id = R.color.cadiz_blue),
            contentColor = colorResource(id = R.color.cadiz_yellow)
        ),
        modifier = Modifier.padding(20.dp).width(150.dp).height(65.dp),
        enabled = true // Creo que por defecto es true pero asi me aseguro
    ) {
        Text(
            text = "Comenzar",
            style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight.SemiBold
            )
        )
    }

}