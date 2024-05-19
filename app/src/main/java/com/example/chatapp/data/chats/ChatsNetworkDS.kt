package com.example.chatapp.data.chats

import com.example.chatapp.data.dto.ChatListDto
import com.example.chatapp.utils.RetrofitUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.HttpException
import retrofit2.Response


object ChatsNetworkDS {

    private val chatApi = RetrofitUtils.chatApi


    fun getChatsList(
        onSuccess: (ChatListDto) -> Unit, // TODO ChatListDto
        onError: (Throwable) -> Unit
    ) {
        val call: Call<ChatListDto> = chatApi.getChatsListDto()

        call.enqueue(object : Callback<ChatListDto> {
            override fun onResponse(
                call: Call<ChatListDto>, // p0
                response: Response<ChatListDto> // p1
            ) {
                if (response.isSuccessful) {
                    onSuccess(response.body()!!)
                } else {
                    onError(HttpException(response)) // HttpException() - retrofit library
                }
            }

            override fun onFailure(
                call: Call<ChatListDto>,
                throwable: Throwable
            ) {
                onError(throwable)
            }
        })
    }


}