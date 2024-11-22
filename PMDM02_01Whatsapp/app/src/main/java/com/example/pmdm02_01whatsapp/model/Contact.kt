package com.example.pmdm02_01whatsapp.model

import androidx.compose.ui.graphics.painter.Painter

data class Contact(
    val id: String,
    val profilePic: Painter,
    val name: String,
    val messages: MutableList<Message>,
) {
    var lastMessage = messages.lastOrNull()
}
