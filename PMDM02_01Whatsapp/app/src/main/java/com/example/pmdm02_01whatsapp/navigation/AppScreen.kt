package com.example.pmdm02_01whatsapp.navigation

sealed class AppScreen(val path: String) {
    data object MainScreen: AppScreen("MainScreen")
    data object ChatScreen: AppScreen("ChatScreen")
}