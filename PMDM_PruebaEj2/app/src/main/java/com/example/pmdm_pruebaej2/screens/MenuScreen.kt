package com.example.pmdm_pruebaej2.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.pmdm_pruebaej2.components.CategoryBar
import com.example.pmdm_pruebaej2.components.Products
import com.example.pmdm_pruebaej2.productModel.allProductList


@Composable
fun MenuScreen(navController: NavController, nothing: String?) {
    MenuBody(navController, nothing)
}


@Composable
fun MenuBody(navController: NavController, nothing: String?) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        CategoryBar()
        Spacer(modifier = Modifier.height(10.dp))
        Products(null, allProductList())
    }

}