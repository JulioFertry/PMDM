package com.example.pmdm_pruebaej2.productModel

import androidx.compose.ui.graphics.painter.Painter


data class Product(
    val image: Painter,
    val name: String,
    val price: String,
    val category: String
)