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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
                MainScreen()
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun MainScreen() {
    PMDM02_01WhatsappTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize()
        ) { innerPadding ->
            Column(modifier = Modifier.padding(innerPadding)) {
                TopBar(modifier = Modifier.fillMaxWidth())
                ChatColumn()
            }
        }
    }
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
fun ChatRow(profilePic: Painter, name: String, lastMessage: String) {
    Row(
        modifier = Modifier.fillMaxWidth()
            .background(colorResource(id = R.color.dark_green))
            .padding(horizontal = 15.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = profilePic,
            contentDescription = "Foto de perfil",
            modifier = Modifier.size(50.dp)
                .clip(CircleShape)
        )

        Column(
            modifier = Modifier.padding(start = 10.dp)
                .padding(vertical = 15.dp)
        ) {
            Text(
                text = name,
                color = colorResource(id = R.color.white),
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

}


@Composable
fun ChatColumn() {
    val chatList = listOf(
        Chat(
            painterResource(id = R.drawable.aa_2dam),
            stringResource(id = R.string.contact1_name),
            stringResource(id = R.string.contact1_message)
        ),
        Chat(
            painterResource(id = R.drawable.aa_eustaquio),
            stringResource(id = R.string.contact2_name),
            stringResource(id = R.string.contact2_message)
        ),
        Chat(
            painterResource(id = R.drawable.aa_novia2),
            stringResource(id = R.string.contact3_name),
            stringResource(id = R.string.contact3_message)
        ),
        Chat(
            painterResource(id = R.drawable.aa_doctor),
            stringResource(id = R.string.contact4_name),
            stringResource(id = R.string.contact4_message)
        ),
        Chat(
            painterResource(id = R.drawable.aa_anacleto),
            stringResource(id = R.string.contact5_name),
            stringResource(id = R.string.contact5_message)
        ),
        Chat(
            painterResource(id = R.drawable.aa_novia1),
            stringResource(id = R.string.contact6_name),
            stringResource(id = R.string.contact6_message)
        ),
        Chat(
            painterResource(id = R.drawable.aa_mono),
            stringResource(id = R.string.contact7_name),
            stringResource(id = R.string.contact7_message)
        ),
        Chat(
            painterResource(id = R.drawable.aa_mama),
            stringResource(id = R.string.contact8_name),
            stringResource(id = R.string.contact8_message)
        ),
        Chat(
            painterResource(id = R.drawable.aa_aeropuerto),
            stringResource(id = R.string.contact9_name),
            stringResource(id = R.string.contact9_message)
        ),
        Chat(
            painterResource(id = R.drawable.aa_papa),
            stringResource(id = R.string.contact10_name),
            stringResource(id = R.string.contact10_message)
        ),
        Chat(
            painterResource(id = R.drawable.aa_profesor),
            stringResource(id = R.string.contact11_name),
            stringResource(id = R.string.contact11_message)
        ),
        Chat(
            painterResource(id = R.drawable.aa_juanmecanico),
            stringResource(id = R.string.contact12_name),
            stringResource(id = R.string.contact12_message)
        )
    )

    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(chatList) { chat ->
            ChatRow(
                profilePic = chat.profilePic,
                name = chat.name,
                lastMessage = chat.lastMessage
            )
        }
    }

}