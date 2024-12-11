package com.example.pmdm_pruebaej2.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pmdm_pruebaej2.R
import com.example.pmdm_pruebaej2.productModel.Product


/** Esqueleto de un boton de categoria que se usa para ordenar la lista de productos
 *
 * @param text Texto que tendrá el boton, concretamente el nombre de la categoria
 * @param onClickAct Comportamiento para ordenar la lista de productos
 */
@Composable
fun CategoryButton(text: String, onClickAct: () -> Unit) {
    Button(
        onClick = onClickAct,
        shape = RoundedCornerShape(16.dp),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 15.dp,
            pressedElevation = 5.dp
        ),
        colors = ButtonDefaults.buttonColors(
            containerColor = colorResource(id = R.color.cadiz_blue),
            contentColor = colorResource(id = R.color.cadiz_yellow)
        ),
        modifier = Modifier.width(40.dp).height(35.dp),
        enabled = true
    ) {
        Text(
            text = text,
            style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight.SemiBold
            )
        )
    }

}


/** Barra de categorias donde se muestran todos los botones de categoria */
@Composable
fun CategoryBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
    ) {
        CategoryButton("Coches") { }
        Spacer(modifier = Modifier.width(8.dp))
        CategoryButton("Peluches") { }
        Spacer(modifier = Modifier.width(8.dp))
        CategoryButton("Perros") { }
    }

}


/** Elemento producto que tiene una imagen, nombre y precio
 *
 * @param product Objeto de tipo producto
 */
@Composable
fun ProductBubble(product: Product) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Image(
            painter = product.image,
            contentDescription = "foto producto",
            modifier = Modifier.size(35.dp)
        )

        Spacer(modifier = Modifier.width(8.dp))

        Text(
            text = product.name,
            style = TextStyle(
                fontWeight = FontWeight.Normal,
                fontSize = 15.sp,
                color = colorResource(id = R.color.black)
            )
        )

        Spacer(modifier = Modifier.width(8.dp))

        Text(
            text = product.price,
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp,
                color = colorResource(id = R.color.black)
            )
        )
    }

}


/** Lista de categorias dinamica, se ordena segun la categoria que presione el usuario
 *
 * @param category Categoria por la que se ordena
 * @param products Lista de los productos
 */
@Composable
fun Products(category: String?, products: List<Product>) {
    LazyColumn {
        items(products) { product ->
            ProductBubble(product)
        }
    }


}