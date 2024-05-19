package com.example.chatapp.data.chats

import com.example.chatapp.data.dto.toDomain
import com.example.chatapp.domain.ChatItem
import com.example.chatapp.utils.IoResponse
import com.example.chatapp.utils.ioMapper


object ChatsRepo1 {


    fun getChatsList(onResponse1: (IoResponse<List<ChatItem>>) -> Unit) {
        ChatsNetworkDS1.getChatsList { response ->
            val mapped = response.ioMapper {
                val mappedList = it.record.map { dto ->
                    dto.toDomain()
                }
                val sortedList = mappedList.sortedByDescending { item ->
                    item.lastMsgDate
                }
                sortedList
            }
            onResponse1(mapped)
        }
    }

}



