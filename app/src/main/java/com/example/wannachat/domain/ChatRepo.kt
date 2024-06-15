package com.example.wannachat.domain

import com.example.wannachat.utils.IoResponse

interface ChatRepo {

    suspend fun getChats(): IoResponse<List<ChatItem>>

    fun getMessages(onResponse: (IoResponse<List<MessageItem>>) -> Unit)

}