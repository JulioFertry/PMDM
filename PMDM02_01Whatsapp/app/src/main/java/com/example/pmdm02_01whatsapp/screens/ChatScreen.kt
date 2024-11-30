package com.example.pmdm02_01whatsapp.screens

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
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.pmdm02_01whatsapp.R
import com.example.pmdm02_01whatsapp.model.Contact
import com.example.pmdm02_01whatsapp.model.Message


@Composable
fun ChatScreen(navController: NavController, contact: Contact?) {
    ChatBody(navController, contact)
}


@Composable
fun ChatBody(navController: NavController, contact: Contact?) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        ContactTopBar(contact)
        Chat(contact?.messages ?: listOf())
        ContactLowerBar {newMessage ->
            contact!!.messages.add(newMessage)
            contact.lastMessage = newMessage
        }
    }
}


@Composable
fun ContactTopBar(
    contact: Contact?
) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 25.dp, vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(25.dp)
    ) {

        Image(
            painter = contact?.profilePic ?: painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "Foto de perfil",
            modifier = Modifier.size(50.dp)
                .clip(CircleShape)
        )

        Text(
            text = contact?.name ?: stringResource(id = R.string.app_title),
            color = Color.White,
            fontSize = 20.sp,
            textAlign = TextAlign.Left,
            modifier = Modifier.weight(1f)
        )

    }

}


@Composable
fun Chat(messages: List<Message>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 10.dp, vertical = 5.dp),
        reverseLayout = true
    ) {
        items(messages) { message ->
            ChatBubble(message = message)
        }
    }
}


@Composable
fun ChatBubble(message: Message) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 5.dp),
        horizontalArrangement = if (message.owner) Arrangement.End else Arrangement.Start
    ) {
        Column(
            modifier = Modifier
                .clip(
                    androidx.compose.foundation.shape.RoundedCornerShape(
                        topStart = if (message.owner) 10.dp else 0.dp,
                        topEnd = if (message.owner) 0.dp else 10.dp,
                        bottomStart = 10.dp,
                        bottomEnd = 10.dp
                    )
                )
                .background(
                    if (message.owner)
                        colorResource(id = R.color.userBubbleColor)
                    else
                        colorResource(id = R.color.otherBubbleColor)
                )
                .padding(horizontal = 15.dp, vertical = 10.dp)
        ) {
            Text(
                text = message.content,
                color = colorResource(id = R.color.black),
                fontSize = 16.sp
            )
            Text(
                text = message.hour,
                color = colorResource(id = R.color.grey),
                fontSize = 12.sp,
                modifier = Modifier.align(Alignment.End)
            )
        }
    }
}


@Composable
fun ContactLowerBar(
    onSendMessage: (Message) -> Unit
) {
    val messageText = rememberSaveable { mutableStateOf("") }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextField(
            value = messageText.value,
            onValueChange = { messageText.value = it },
            modifier = Modifier
                .weight(1f)
                .padding(end = 8.dp),
            placeholder = { Text("Escribe un mensaje...") }
        )

        Button(
            onClick = {
                if (messageText.value.isNotBlank()) {
                    onSendMessage(
                        Message(
                            content = messageText.value,
                            hour = "00:00",
                            owner = true
                        )
                    )
                    messageText.value = ""
                }
            }
        ) {
            Text("Enviar")
        }
    }
}