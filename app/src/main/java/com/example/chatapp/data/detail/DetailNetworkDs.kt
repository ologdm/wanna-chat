package com.example.chatapp.data.detail

import com.example.chatapp.data.dto.MessageListDto
import com.example.chatapp.utils.RetrofitUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.HttpException
import retrofit2.Response

object DetailNetworkDs {

    private val api = RetrofitUtils.chatApi

    fun getMessageList(onSuccess: (MessageListDto) -> Unit, onError: (Throwable) -> Unit) {
        val call: Call<MessageListDto> = api.getMessageListDto()

        call.enqueue(object : Callback<MessageListDto> {
            override fun onResponse(
                call: Call<MessageListDto>,
                response: Response<MessageListDto>
            ) {
                if (response.isSuccessful) {
                    onSuccess(response.body()!!)
                } else {
                    onError(HttpException(response))
                }
            }

            override fun onFailure(call: Call<MessageListDto>, throwable: Throwable) {
                onError(throwable)
            }

        })

    }

}