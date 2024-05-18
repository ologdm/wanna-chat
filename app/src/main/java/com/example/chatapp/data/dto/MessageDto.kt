package com.example.chatapp.data.dto

import com.example.chatapp.domain.MessageItem
import com.example.chatapp.utils.formatToDate
import com.google.gson.annotations.SerializedName
import java.util.Date

// OK
data class MessageDto(
    @SerializedName("message_id") val messageId: Int,
    @SerializedName("message_type") val messageType: String,
    @SerializedName("message_content") val messageContent: String,
    @SerializedName("sent_at") val sentAt: String?,
    @SerializedName("received_at") val receivedAt: String?
)


fun MessageDto.toDomain(): MessageItem {
    val isMe = (sentAt != null)

    val date: Date? = if (sentAt != null) {
        sentAt.formatToDate()
    } else if (receivedAt != null) {
        receivedAt.formatToDate()
    } else {
        null
    }

    return MessageItem(
        id = messageId,
        type = messageType,
        content = messageContent,
        isMe = isMe, //
        date = date ?: Date() // shouldn't happen, but in case both are null -> use today
    )
}