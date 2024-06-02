package com.example.wannachat.data

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RetrofitModule {


//    @Provides
//    @Singleton
//    fun getApi(): ChatApi {
//        val retrofit = Retrofit.Builder()
//            .baseUrl("https://api.jsonbin.io/")
//            .addConverterFactory(GsonConverterFactory.create())
//            .callFactory(
//                OkHttpClient.Builder()
//                    .addInterceptor(Interceptor { chain ->
//                        val newRequest = chain.request().newBuilder()
//                            .addHeader(
//                                "X-Access-Key",
//                                "$2a$10\$ZUUP6OpOmZ8u2p/SAofEF.N32mQ72UWqs9/Fl6Zvom7./2vdo1JGq"
//                            )
//                            .build()
//                        chain.proceed(newRequest)
//                    })
//                    .build()
//            )
//            .build()
//
//        return retrofit.create(ChatApi::class.java)
//    }


    //test
    @Provides
    @Singleton
    fun getApi(): ChatApi {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.jsonbin.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .callFactory(
                OkHttpClient.Builder()
                    .addInterceptor(Interceptor { chain ->
                        val newRequest = chain.request().newBuilder()
                            .addHeader(
                                "X-ACCESS-KEY",
                                "\$2a\$10\$4FM9zC5A3ylJY/Mf62wE9OqQFDAjm1Ss2VHQ2r9Hsr2SnNL4nfvMe"
                            )
                            .build()
                        chain.proceed(newRequest)
                    })
                    .build()
            )
            .build()

        return retrofit.create(ChatApi::class.java)
    }


}



