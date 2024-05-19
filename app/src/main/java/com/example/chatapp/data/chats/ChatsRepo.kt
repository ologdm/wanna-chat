package com.example.chatapp.data.chats

import com.example.chatapp.data.dto.toDomain
import com.example.chatapp.domain.ChatItem
import com.example.chatapp.utils.IoResponse
import com.example.chatapp.utils.ioMapper


object ChatsRepo {


    fun getChatsList(onResponse: (IoResponse<List<ChatItem>>) -> Unit) {
        ChatsNetworkDS.getChatsList { response ->
            val mapped = response.ioMapper { rawDto ->
                val mappedList = rawDto.record.map { dto ->
                    dto.toDomain()
                }
                val sortedList = mappedList.sortedByDescending { item ->
                    item.lastMsgDate
                }
                sortedList// ioMapper return
            }
            onResponse(mapped)
        }
    }


//    fun getChatsList(onResponse1: (IoResponse<List<ChatItem>>) -> Unit) {
//
//        ChatsNetworkDS.getChatsList { response ->
//
//            when (response) {
//                is IoResponse.Success -> {
//                    val mapped = response.ioMapper {
//                        val mappedList = it.record.map { dto ->
//                            dto.toDomain()
//                        }
//                        val sortedList = mappedList.sortedByDescending { item ->
//                            item.lastMsgDate
//                        }
//                        sortedList
//                    }
//                    println("ZZZ REPO SUCCESS")
//                    onResponse1(mapped)
//                }
//
//                is IoResponse.NetworkError -> {
//                    println("ZZZ REPO ERROR IO")
//                    onResponse1(response)
//                }
//
//                is IoResponse.OtherError -> {
//                    println("ZZZ REPO ERROR OTHER")
//                    onResponse1(response)
//                }
//            }
//        }
//    }

}
