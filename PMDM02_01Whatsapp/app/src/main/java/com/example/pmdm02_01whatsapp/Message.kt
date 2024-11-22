package com.example.pmdm02_01whatsapp

data class Message(
    val content: String,
    val read: Boolean,
    val hour: String,
    val owner: Boolean
)