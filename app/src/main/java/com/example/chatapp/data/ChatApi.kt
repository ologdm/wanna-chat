package com.example.chatapp.data

import com.example.chatapp.data.dto.MessageListDto
import com.example.chatapp.data.dto.ChatListDto
import retrofit2.Call
import retrofit2.http.GET

interface ChatApi {

    @GET("v3/b/663ce915acd3cb34a8454a2d")
    fun getChatsListDto() : Call<ChatListDto>


    @GET("v3/b/664f0519acd3cb34a84c4318")
    fun getMessageListDto() :Call<MessageListDto>



}