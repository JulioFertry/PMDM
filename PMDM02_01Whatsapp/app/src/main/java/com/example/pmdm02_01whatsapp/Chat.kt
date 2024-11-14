package com.example.pmdm02_01whatsapp

import androidx.compose.ui.graphics.painter.Painter

data class Chat(
    val profilePic: Painter,
    val name: String,
    val lastMessage: String
)
