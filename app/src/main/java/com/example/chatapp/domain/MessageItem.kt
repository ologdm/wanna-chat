package com.example.chatapp.domain

import java.util.Date

data class MessageItem (
    val id: Int,
    val type: String,
    val content: String,
    val isMe: Boolean,
    val date : Date
)