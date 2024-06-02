package com.example.wannachat.domain

import com.example.wannachat.utils.IoResponse

interface ChatRepo {

    fun getChats(onResponse: (IoResponse<List<ChatItem>>) -> Unit)

    fun getMessages(onResponse: (IoResponse<List<MessageItem>>) -> Unit)

}