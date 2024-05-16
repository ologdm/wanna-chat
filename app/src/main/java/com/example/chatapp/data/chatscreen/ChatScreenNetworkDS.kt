package com.example.chatapp.data.chatscreen

import com.example.chatapp.data.dto.ChatDto
import com.example.chatapp.data.dto.ChatListDto
import com.example.chatapp.utils.RetrofitUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.HttpException
import retrofit2.Response

/**
 * header: Intercepter
 * callback: onSuccess, onError
 * convert: rawDto -> list<Dto>
**/

object ChatScreenNetworkDS {

    // separate retrofit
    val chatApi = RetrofitUtils.chatApi


    // OK - using lambdas
    fun getChatsList(
        onSuccess: (List<ChatDto>) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        val call: Call<ChatListDto> = chatApi.getChatsList()

        call.enqueue(object : Callback<ChatListDto> {
            override fun onResponse(
                call: Call<ChatListDto>, // p0
                response: Response<ChatListDto> // p1
            ) {
                if (response.isSuccessful) {
                    val rawDto: ChatListDto = response.body()!!
                    val chatList: List<ChatDto> = rawDto.record
                    onSuccess(chatList)
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