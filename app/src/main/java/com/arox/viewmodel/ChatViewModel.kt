package com.arox.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arox.model.Message
import com.arox.model.Sender
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ChatViewModel : ViewModel() {

    private val _messages = MutableStateFlow<List<Message>>(emptyList())
    val messages: StateFlow<List<Message>> = _messages

    fun sendMessage(text: String) {
        val userMessage = Message(
            text = text,
            sender = Sender.USER
        )

        _messages.value += userMessage

        // Simulate Arox's reply for now (we’ll replace with OpenAI later)
        viewModelScope.launch {
            val aroxReply = Message(
                text = generateReply(text),
                sender = Sender.AROX
            )
            _messages.value += aroxReply
        }
    }

    // TEMP: Fake AI logic
    private fun generateReply(userText: String): String {
        return when {
            userText.contains("hello", ignoreCase = true) -> "Hello, I’m Arox! How can I help you today? 😊"
            userText.contains("how are you", ignoreCase = true) -> "I’m running at 100% performance — thanks for asking!"
            else -> "Interesting... tell me more!"
        }
    }
}