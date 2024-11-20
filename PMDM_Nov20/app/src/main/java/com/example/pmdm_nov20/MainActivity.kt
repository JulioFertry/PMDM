package com.example.pmdm_nov20

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pmdm_nov20.ui.theme.PMDM_Nov20Theme


private val messages: List<Mensaje> = listOf(
    Mensaje("Perrrrro", "2 gramitos de cooooca por favoooh"),
    Mensaje("Er yoni", "2 gramitos de cooooca por favoooh"),
    Mensaje("La sasha", "2 gramitos de cooooca por favoooh"),
    Mensaje("Aamamá", "2 gramitos de cooooca por favoooh")
)


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ListaFuncion()
        }
    }
}


data class Mensaje(val name: String, val msg: String)


@Composable
fun MisTextos(mensaje: Mensaje) {
    Text(mensaje.name)
    Spacer(Modifier.size(6.dp))
    Text(mensaje.msg, fontSize = 4.sp)
}


@Preview
@Composable
fun ListaFuncion() {
    LazyColumn {
        items(messages) {
            messages2 -> MisTextos(messages2)
        }
    }
}