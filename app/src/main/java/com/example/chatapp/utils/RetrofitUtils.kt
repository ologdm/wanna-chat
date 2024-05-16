package com.example.chatapp.utils

import com.example.chatapp.data.ChatApi
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


// Retrofit
// ChatApi

// enqueue generale

object RetrofitUtils {

    // retrofit instance based on site domain - OK
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

    // create Api instance from java class - OK
    val chatApi = retrofit.create(ChatApi::class.java)



//    fun getChatApi(): ChatApi {
//        val chatApi = retrofit.create(ChatApi::class.java)
//        return chatApi
//    }

}



