package com.example.chatapp.data.dto


data class ChatsListDto(
    val record: List<ChatDto>
    // metadata - don't need
)


// support dto
data class ChatDto(
    val id: Int,
    val userName: String,
    val avatarUrl: String,
    val lastMessageContent: String,
    val lastMessageDate: String,
    val unseenCount: Int
)
