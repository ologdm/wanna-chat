package com.example.wannachat.data

import com.example.wannachat.data.dto.ChatListDto
import com.example.wannachat.data.dto.MessageListDto
import com.example.wannachat.utils.IoResponse
import com.example.wannachat.utils.handleApiCall
import retrofit2.Call
import retrofit2.Callback
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException
import java.util.concurrent.CancellationException
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class NetworkDS @Inject constructor(
    private val chatApi: ChatApi
) {

    suspend fun getChatsList(): IoResponse<ChatListDto> {
        return handleApiCall {
            chatApi.getChatsListDto()
        }
    }


    suspend fun getMessagesList(): IoResponse<MessageListDto> {
        return handleApiCall {
            chatApi.getMessageListDto()
        }
    }

}

// old
//        val call: Call<ChatListDto> = chatApi.getChatsListDto()
//
//        call.enqueue(object : Callback<ChatListDto> {
//            override fun onResponse(
//                call: Call<ChatListDto>,
//                response: Response<ChatListDto>
//            ) {
//                if (response.isSuccessful) {
//                    onResponse(IoResponse.Success(response.body()!!))
//                } else {
//                    val exception = HttpException(response)
//                    exception.printStackTrace()
//                    onResponse(IoResponse.OtherError)
//                }
//            }
//
//            override fun onFailure(
//                call: Call<ChatListDto>,
//                throwable: Throwable
//            ) {
//                throwable.printStackTrace()
//                onResponse(IoResponse.NetworkError)
//            }
//        })