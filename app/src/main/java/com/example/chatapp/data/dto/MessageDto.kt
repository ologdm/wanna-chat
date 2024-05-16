package com.example.chatapp.data.dto

import com.example.chatapp.domain.MessageItem
import com.google.gson.annotations.SerializedName

// support dto
data class MessageDto(
    @SerializedName("message_id") val messageId: Int,
    @SerializedName("message_type") val messageType: String,
    @SerializedName("message_content") val messageContent: String,
    @SerializedName("sent_at") val sentAt: String,
    @SerializedName("received_at") val receivedAt: String
)


fun MessageDto.toDomain() : MessageItem{
    return MessageItem(
        this.messageId,
        this.messageType,
        this.messageContent,
        this.sentAt,
        this.receivedAt
    )
}