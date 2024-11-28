package com.example.pmdm02_02form.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.pmdm02_02form.screens.FirstScreen
import com.example.pmdm02_02form.screens.SecondScreen


@Composable
fun AppNavigation(modifier: Modifier = Modifier) {
    val navControlador = rememberNavController()
    NavHost(navController = navControlador, startDestination = AppScreen.FirstScreen.route){

        composable(AppScreen.FirstScreen.route){
            FirstScreen(navControlador)
        }

        composable(AppScreen.SecondScreen.route + "/{name}/{dni}/{age}",
            arguments = listOf(
                navArgument("name") {type = NavType.StringType},
                navArgument("dni") {type = NavType.StringType},
                navArgument("age") {type = NavType.IntType}
            )
        ) {
            val name = it.arguments?.getString("name") ?: ""
            val dni = it.arguments?.getString("dni") ?: ""
            val age = it.arguments?.getInt("age") ?: 0
            SecondScreen(navControlador, name, dni, age)
        }

    }

}