package com.example.chatapp.data.dto

data class ChatDetailsDto(
    val record: List<MessageDto>
    // metadata - don't need
)


// support dto
data class MessageDto(
    val messageId: Int,
    val messageType: String,
    val messageContent: String,
    val sentAt: String,
    val receivedAt: String
)

// trasformare in domain solo lista message