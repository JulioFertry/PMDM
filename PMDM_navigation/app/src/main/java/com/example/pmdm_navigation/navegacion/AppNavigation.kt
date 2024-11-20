package com.example.pmdm_navigation.navegacion

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.pmdm_navigation.pantallas.FirstScreen
import com.example.pmdm_navigation.pantallas.SecondScreen


@Composable
fun AppNavigation(modifier: Modifier = Modifier) {
    val navControlador = rememberNavController()
    NavHost(navController = navControlador, startDestination = AppScreen.FirstScreen.route){

        composable(AppScreen.FirstScreen.route){
            FirstScreen(navControlador)
        }

        composable(AppScreen.SecondScreen.route + "/{text}",
            arguments = listOf(navArgument(name = "text") {type = NavType.StringType})
            ) {
            SecondScreen(navControlador, it.arguments?.getString("text"))
        }

    }

}