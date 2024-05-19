package com.example.chatapp.data.chats

import com.example.chatapp.data.dto.ChatListDto
import com.example.chatapp.utils.IoResponse
import com.example.chatapp.utils.RetrofitUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException


object ChatsNetworkDS {


    private val chatApi = RetrofitUtils.chatApi


    fun getChatsList(onResponse: (IoResponse<ChatListDto>) -> Unit) {

        val call: Call<ChatListDto> = chatApi.getChatsListDto()

        call.enqueue(object : Callback<ChatListDto> {
            override fun onResponse(
                call: Call<ChatListDto>,
                response: Response<ChatListDto>
            ) {
                if (response.isSuccessful) {
                    onResponse(IoResponse.Success(response.body()!!)) // ##
                    println("ZZZ RETROFIT SUCCESS")
                } else {
                    HttpException(response).printStackTrace()
                    onResponse(IoResponse.OtherError(HttpException(response))) // ##
                    println("ZZZ RETROFIT OTHER")
                }
            }

            override fun onFailure(
                call: Call<ChatListDto>,
                throwable: Throwable
            ) {
                if (throwable is IOException){
                    onResponse(IoResponse.NetworkError(throwable)) // ##
                } else{
                    IoResponse.OtherError(throwable) // ##
                }

                println("ZZZ RETROFIT IO")
            }
        })
    }


}