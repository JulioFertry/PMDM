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
            AppScreen.ChatScreen.path + "/{contactId}/{contactName}/{profilePic}",
            arguments = listOf(
                navArgument("contactId") { type = NavType.StringType },
                navArgument("contactName") { type = NavType.StringType },
                navArgument("profilePicId") { type = NavType.IntType }
            )
        ) { it ->


            val contactId = it.arguments?.getString("contactId")?:"00"
            val contact = getContacts().find { it.id == contactId }
            val contactName = it.arguments?.getString("contactName")

            val profilePic = if (contact != null) {
                contact.profilePic
            } else {
                painterResource(id = R.drawable.ic_launcher_foreground)
            }

            ChatScreen(navController, contactId, contactName, profilePic)
        }
    }
}
