package com.example.pmdm02_01whatsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pmdm02_01whatsapp.ui.theme.PMDM02_01WhatsappTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            PMDM02_01WhatsappTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    innerPadding -> TopBar(modifier = Modifier.padding(innerPadding))
                }
            }
        }

    }
}


@Composable
fun MainScreen(modifier: Modifier) {
}


@Composable
fun TopBar(modifier: Modifier) {
    Column(modifier.background(colorResource(id = R.color.green_bar))) {

        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 25.dp, vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(25.dp)
        ) {
            Text(
                text = stringResource(id = R.string.app_title),
                color = Color.White,
                fontSize = 20.sp,
                textAlign = TextAlign.Left,
                modifier = Modifier.weight(1f)
                )

            Icon(
                painter = painterResource(id = R.drawable.camara),
                contentDescription = "Camara",
                tint = colorResource(id = R.color.white),
                modifier = Modifier.size(20.dp)
            )

            Icon(
                painter = painterResource(id = R.drawable.lupa),
                contentDescription = "Camara",
                tint = colorResource(id = R.color.white),
                modifier = Modifier.size(20.dp)
            )

            Icon(
                painter = painterResource(id = R.drawable.dots2),
                contentDescription = "Camara",
                tint = colorResource(id = R.color.white),
                modifier = Modifier.size(20.dp)
            )
        }

    }
}


@Composable
fun Chat(profilePic: Painter, name: String, lastMessage: String) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 25.dp, vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = profilePic,
            contentDescription = "Foto de perfil",
            modifier = Modifier.size(50.dp)
                .clip(CircleShape)
                .background(colorResource(id = R.color.dark_green))
                .weight(1f)
        )
    }

    Column(
        modifier = Modifier.padding(start = 25.dp).fillMaxWidth()
    ) {
        Text(
            text = name,
            color = colorResource(id = R.color.black),
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = lastMessage,
            color = colorResource(id = R.color.grey),
            fontSize = 10.sp,
            fontWeight = FontWeight.Light
        )
    }

}


@Composable
fun ChatList() {

}


@Preview(showBackground = true)
@Composable
fun TopBarPreview() {
    PMDM02_01WhatsappTheme {
        TopBar(
            modifier = Modifier.fillMaxWidth()
        )
    }
}
