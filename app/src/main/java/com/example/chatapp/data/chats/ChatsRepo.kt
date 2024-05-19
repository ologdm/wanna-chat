//package com.example.chatapp.data.chats
//
//import com.example.chatapp.data.dto.ChatDto
//import com.example.chatapp.data.dto.toDomain
//import com.example.chatapp.domain.ChatItem
//import java.io.IOException
//
//
//object ChatsRepo {
//
//
//    fun getChatsList(
//        onSuccess: (List<ChatItem>) -> Unit,
//        onErrorIO: () -> Unit,
//        onErrorOther: () -> Unit
//    ) {
//        ChatsNetworkDS.getChatsList(
//            onSuccess = {
//                val list: List<ChatDto> = it.record
//                val mappedList = list.map { it.toDomain() }
//                val sortedList = mappedList.sortedByDescending { it.lastMsgDate } // Date type
//                onSuccess(sortedList) // ##
//            },
//
//            onError = {
//                if (it is IOException) {
//                    it.printStackTrace()
//                    onErrorIO() // ##
//                } else {
//                    onErrorOther() // ##
//                }
//            }
//        )
//
//    }
//
//
//}