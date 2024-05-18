package com.example.chatapp.utils

import com.example.chatapp.data.ChatApi
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitUtils {

    private val retrofit = Retrofit.Builder()
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


    val chatApi = retrofit.create(ChatApi::class.java)

}



