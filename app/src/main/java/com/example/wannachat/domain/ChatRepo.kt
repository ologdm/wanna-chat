package com.example.wannachat.domain

import com.example.wannachat.utils.IoResponse

interface ChatRepo {

    suspend fun getChats(): IoResponse<List<ChatItem>>
    suspend fun getMessages() : IoResponse<List<MessageItem>>

}