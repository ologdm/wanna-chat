package com.example.chatapp.data

import com.example.chatapp.data.dto.ChatListDto
import com.example.chatapp.data.dto.MessageListDto
import com.example.chatapp.utils.IoResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class ChatNetworkDS @Inject constructor(
    val chatApi: ChatApi
) {

    fun getChatsList(onResponse: (IoResponse<ChatListDto>) -> Unit) {

        val call: Call<ChatListDto> = chatApi.getChatsListDto()

        call.enqueue(object : Callback<ChatListDto> {
            override fun onResponse(
                call: Call<ChatListDto>,
                response: Response<ChatListDto>
            ) {
                if (response.isSuccessful) {
                    onResponse(IoResponse.Success(response.body()!!)) // ##
                } else {
                    HttpException(response).printStackTrace()
                    onResponse(IoResponse.OtherError(HttpException(response))) // ##
                }
            }

            override fun onFailure(
                call: Call<ChatListDto>,
                throwable: Throwable
            ) {
                if (throwable is IOException) {
                    onResponse(IoResponse.NetworkError(throwable)) // ##
                } else {
                    IoResponse.OtherError(throwable) // ##
                }

            }
        })
    }



    fun getMessageList(onResponse: (IoResponse<MessageListDto>) -> Unit) {

        val call: Call<MessageListDto> = chatApi.getMessageListDto()

        call.enqueue(object : Callback<MessageListDto> {
            override fun onResponse(
                call: Call<MessageListDto>,
                response: Response<MessageListDto>
            ) {
                if (response.isSuccessful) {
                    onResponse(IoResponse.Success(response.body()!!)) // ##
                } else {
                    onResponse(IoResponse.OtherError(HttpException(response))) // ##
                }
            }

            override fun onFailure(call: Call<MessageListDto>, throwable: Throwable) {
                onResponse(IoResponse.NetworkError(throwable)) // ##



            }

        })

    }


}