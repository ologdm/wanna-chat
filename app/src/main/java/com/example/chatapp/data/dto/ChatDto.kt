package com.example.chatapp.data.dto

import com.example.chatapp.domain.ChatItem
import com.example.chatapp.utils.formatToDate
import com.google.gson.annotations.SerializedName
import java.util.Date


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
        id = id,
        userName = userName,
        avatarUrl = avatarUrl,
        lastMsgContent = lastMessageContent,
        lastMsgDate = lastMessageDate.formatToDate()
            ?: Date(), // shouldn't happen, but in case are null -> use today
        unseenCount = unseenCount
    )
}
