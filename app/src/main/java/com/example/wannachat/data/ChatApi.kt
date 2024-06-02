package com.example.wannachat.data

import com.example.wannachat.data.dto.MessageListDto
import com.example.wannachat.data.dto.ChatListDto
import retrofit2.Call
import retrofit2.http.GET

interface ChatApi {

    @GET("v3/b/665ccecbacd3cb34a851bc67")
    fun getChatsListDto() : Call<ChatListDto>


    @GET("v3/b/665b714dacd3cb34a8513b98")
    fun getMessageListDto() :Call<MessageListDto>

}