package com.arox.model

data class Message(
    val id: String = System.currentTimeMillis().toString(),
    val text: String,
    val timestamp: Long = System.currentTimeMillis(),
    val sender: Sender,
    val mediaUrl: String? = null // optional, for images or links
)