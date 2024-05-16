package com.example.chatapp.domain

data class MessageItem (
    val messageId: Int,
    val messageType: String,
    val messageContent: String,
    val sentAt: String,
    val receivedAt: String

    // other business attributes
)