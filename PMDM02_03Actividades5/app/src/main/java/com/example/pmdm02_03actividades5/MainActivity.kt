package com.example.pmdm02_03actividades5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.dam23_24.composecatalogolayout.screens.Actividad1
import com.dam23_24.composecatalogolayout.screens.Actividad2
import com.dam23_24.composecatalogolayout.screens.Actividad3
import com.dam23_24.composecatalogolayout.screens.Actividad4
import com.dam23_24.composecatalogolayout.screens.Actividad5
import com.example.pmdm02_03actividades5.ui.theme.PMDM02_03Actividades5Theme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            PMDM02_03Actividades5Theme {
                Actividad5()
            }
        }

    }
}