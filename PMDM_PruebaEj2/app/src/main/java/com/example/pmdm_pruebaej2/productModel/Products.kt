package com.example.pmdm_pruebaej2.productModel

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.example.pmdm_pruebaej2.R

@Composable
fun allProductList(): List<Product> {

    val products = listOf(
        Product(
            painterResource(id = R.drawable.dog1),
            "Pipo",
            "3.80 $",
            "Perros"
        ),
        Product(
            painterResource(id = R.drawable.dog2),
            name = "Dobby",
            "5.90 $",
            "Perros"
        ),
        Product(
            painterResource(id = R.drawable.coche1),
            "Seat Panda",
            "3080 $",
            "Coches"
        ),
        Product(
            painterResource(id = R.drawable.coche2),
            "Renault Roto",
            "2050 $",
            "Coches"
        ),
        Product(
            painterResource(id = R.drawable.peluche1),
            "oso chulo",
            "19.90 $",
            "Peluches"
        ),
        Product(
            painterResource(id = R.drawable.peluche2),
            "oso no tan chulo",
            "15.50 $",
            "Peluches"
        )
    )

    return products
}