package com.example.chatapp.data.mainscreen

import com.example.chatapp.data.ChatApi
import com.example.chatapp.data.dto.ChatsListDto
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.HttpException
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// header: Intercepter


class MScreenNetworkDS {

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

    val call: Call<ChatsListDto> = chatApi.getChatsList()


    // OK - using lambdas
    fun getChatsList(
        onSuccess: (ChatsListDto) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        call.enqueue(object : Callback<ChatsListDto> {
            override fun onResponse(
                call: Call<ChatsListDto>, // p0
                response: Response<ChatsListDto> // p1
            ) {
                if (response.isSuccessful) {
                    onSuccess(response.body()!!)
                } else {
                    // HttpException - retrofit library
                    onError(HttpException(response))
                }
            }

            override fun onFailure(
                call: Call<ChatsListDto>,
                throwable: Throwable
            ) {
                onError(throwable)
            }

        })

    }


}