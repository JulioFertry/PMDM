package com.example.pmdm_pruebaej2.navigation

sealed class AppScreen(val route: String) {
    data object WelcomeScreen: AppScreen("WelcomeScreen")
    data object MenuScreen: AppScreen("MenuScreen")
    data object InfoScreen: AppScreen("InfoScreen")
}