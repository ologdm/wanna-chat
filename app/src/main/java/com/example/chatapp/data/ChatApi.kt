package com.example.chatapp.data

import com.example.chatapp.data.dto.MessageListDto
import com.example.chatapp.data.dto.ChatListDto
import retrofit2.Call
import retrofit2.http.GET


// path da retrofit, e fisso


interface ChatApi {

    // 1. all user's chats
    @GET("v3/b/663ce915acd3cb34a8454a2d")
    fun getChatsList() : Call<ChatListDto>


    // 2. all message from a chat
    @GET("v3/b/663cfb19ad19ca34f866d954")
    fun getChatDetails() :Call<MessageListDto>


}