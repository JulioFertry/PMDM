package com.example.pmdm02_01whatsapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.pmdm02_01whatsapp.R
import com.example.pmdm02_01whatsapp.data.getContacts
import com.example.pmdm02_01whatsapp.screens.MainScreen
import com.example.pmdm02_01whatsapp.screens.ChatScreen


@Composable
fun AppNavigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreen.MainScreen.path) {

        composable(AppScreen.MainScreen.path) {
            MainScreen(navController)
        }

        composable(
            AppScreen.ChatScreen.path + "/{contactId}",
            arguments = listOf(
                navArgument("contactId") { type = NavType.StringType },
            )
        ) { it ->


            val contactId = it.arguments?.getString("contactId")?:"00"
            val contact = getContacts().find { it.id == contactId }

            ChatScreen(navController, contact)
        }
    }
}
