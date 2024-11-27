package com.example.pmdm02_01whatsapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.pmdm02_01whatsapp.R


@Composable
fun ChatScreen(navController: NavController, contactId: String, contactName: String?, picture: Painter?) {
}


@Composable
fun ContactTopBar(
    profilePic: Painter = painterResource(id = R.drawable.ic_launcher_foreground),
    name: String? = "Desconocido"
) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 25.dp, vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(25.dp)
    ) {

        Image(
            painter = profilePic,
            contentDescription = "Foto de perfil",
            modifier = Modifier.size(50.dp)
                .clip(CircleShape)
        )

        Text(
            text = stringResource(id = R.string.app_title),
            color = Color.White,
            fontSize = 20.sp,
            textAlign = TextAlign.Left,
            modifier = Modifier.weight(1f)
        )

    }

}


@Composable
fun chat() {

}


@Composable
fun chatBubble() {

}


@Composable
fun ContactLowerBar() {

}