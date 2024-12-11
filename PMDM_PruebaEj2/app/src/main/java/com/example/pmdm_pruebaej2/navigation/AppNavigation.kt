package com.example.pmdm_pruebaej2.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.pmdm_pruebaej2.screens.MenuScreen
import com.example.pmdm_pruebaej2.screens.WelcomeScreen


@Composable
fun AppNavigation(modifier: Modifier = Modifier) {
    val navControlador = rememberNavController()
    NavHost(navController = navControlador, startDestination = AppScreen.WelcomeScreen.route){

        composable(AppScreen.WelcomeScreen.route){
            WelcomeScreen(navControlador)
        }

        composable(AppScreen.MenuScreen.route + "/{text}",
            arguments = listOf(navArgument("text") {type = NavType.StringType})
        ) {
            MenuScreen(navControlador, it.arguments?.getString("text"))
        }

    }

}