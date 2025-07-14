package com.arox.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.arox.model.Message
import com.arox.model.Sender
import com.arox.R

@Composable
fun MessageBubble(message: Message) {
    val isUser = message.sender == Sender.USER
    val alignment = if (isUser) Arrangement.End else Arrangement.Start
    val backgroundColor = if (isUser) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surfaceVariant
    val textColor = if (isUser) Color.White else Color.Black
    val avatarRes = if (isUser) R.drawable.user_avatar else R.drawable.arox_avatar

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp),
        horizontalArrangement = alignment
    ) {
        if (!isUser) {
            Image(
                painter = painterResource(id = avatarRes),
                contentDescription = "Avatar",
                modifier = Modifier
                    .size(32.dp)
                    .clip(RoundedCornerShape(50)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(6.dp))
        }

        Surface(
            color = backgroundColor,
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
                .widthIn(max = 280.dp)
                .padding(2.dp)
        ) {
            Text(
                text = message.text,
                color = textColor,
                modifier = Modifier.padding(12.dp),
                style = MaterialTheme.typography.bodyMedium
            )
        }

        if (isUser) {
            Spacer(modifier = Modifier.width(6.dp))
            Image(
                painter = painterResource(id = avatarRes),
                contentDescription = "Avatar",
                modifier = Modifier
                    .size(32.dp)
                    .clip(RoundedCornerShape(50)),
                contentScale = ContentScale.Crop
            )
        }
    }
}