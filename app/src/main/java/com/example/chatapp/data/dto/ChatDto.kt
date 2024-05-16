package com.example.chatapp.data.dto

import com.example.chatapp.domain.ChatItem
import com.google.gson.annotations.SerializedName

// support dto
data class ChatDto(
    val id: Int,
    @SerializedName("user_name") val userName: String,
    @SerializedName("avatar_url") val avatarUrl: String,
    @SerializedName("last_message_content") val lastMessageContent: String,
    @SerializedName("last_message_date") val lastMessageDate: String,
    @SerializedName("unseen_count") val unseenCount: Int
)

fun ChatDto.toDomain(): ChatItem {
    return ChatItem(
        this.id,
        this.userName,
        this.avatarUrl,
        this.lastMessageContent,
        this.lastMessageDate,
        this.unseenCount
    )
}
