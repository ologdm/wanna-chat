package com.example.chatapp.data.detail

import com.example.chatapp.data.dto.MessageListDto
import com.example.chatapp.utils.IoResponse
import com.example.chatapp.utils.RetrofitUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

object DetailNetworkDS {

    private val api = RetrofitUtils.chatApi


    fun getMessageList(onResponse: (IoResponse<MessageListDto>) -> Unit) {

        val call: Call<MessageListDto> = api.getMessageListDto()

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
                if (throwable is IOException){
                    onResponse(IoResponse.NetworkError(throwable)) // ##
                    } else{
                        IoResponse.OtherError(throwable) // ##
                }


            }

        })

    }

}