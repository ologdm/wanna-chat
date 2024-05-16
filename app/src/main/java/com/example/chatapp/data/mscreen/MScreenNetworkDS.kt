package com.example.chatapp.data.mscreen

import com.example.chatapp.data.ChatApi
import com.example.chatapp.data.dto.ChatDto
import com.example.chatapp.data.dto.ChatListDto
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.HttpException
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * header: Intercepter
 * callback: onSuccess, onError
 * convert: rawDto -> list<Dto>
**/

object MScreenNetworkDS {

    // retrofit instance based on site domain - OK
    val retrofit = Retrofit.Builder()
        .baseUrl("https://api.jsonbin.io/")
        .addConverterFactory(GsonConverterFactory.create())
        .callFactory(
            OkHttpClient.Builder()
                .addInterceptor(Interceptor { chain ->
                    val newRequest = chain.request().newBuilder()
                        .addHeader(
                            "X-Access-Key",
                            "$2a$10\$ZUUP6OpOmZ8u2p/SAofEF.N32mQ72UWqs9/Fl6Zvom7./2vdo1JGq"
                        )
                        .build()
                    chain.proceed(newRequest)
                })
                .build()
        )
        .build()


    // create Api instance from java class - OK
    val chatApi = retrofit.create(ChatApi::class.java)

    // ######### spostare retrofit e api


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