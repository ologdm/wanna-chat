package com.example.chatapp.domain

import com.example.chatapp.utils.IoResponse

interface ChatRepo {

    fun getChats(onResponse: (IoResponse<List<ChatItem>>) -> Unit)

    fun getMessages(onResponse: (IoResponse<List<MessageItem>>) -> Unit)

}