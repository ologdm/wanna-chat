package com.example.chatapp.data.chatscreen

import com.example.chatapp.data.dto.toDomain
import com.example.chatapp.domain.ChatItem
import java.io.IOException

import java.text.SimpleDateFormat
import java.util.Locale

/**
 * fun getChatsList()
 * fun orderByLastMessage()
 *
 * callback: onSuccess, onErrorIO, onErrorOther
 *
 **/


object ChatScreenRepo {

    // trasforma in Domain
    // ordina
    fun getChatsList(
        onSuccess: (List<ChatItem>) -> Unit,
        onErrorIO: () -> Unit,
        onErrorOther: () -> Unit
    ) {
        ChatScreenNetworkDS.getChatsList(
            onSuccess = {
                val mappedList = it.map { it.toDomain() }
                val sortedList = mappedList.sortedByDescending { it.lastMessageDate } // Date type
                onSuccess(sortedList) // ## stato Success
            },

            onError = {
                if (it is IOException) {
                    it.printStackTrace()
                    onErrorIO() // ## stato IO
                } else {
                    onErrorOther() // ## stato Other
                }
            }
        )

    }


    /* OK non serve
//    private fun orderByLastMessage(list: List<ChatItem>): List<ChatItem> {
//        val dataFormat = SimpleDateFormat("HH:mm:ss yyyy-MM-dd", Locale.getDefault())
//
//        return list.sortedByDescending {
//            dataFormat.parse(it.lastMessageDate)
//            // dataFormat.parse ("string") - converte string in dataformat
//        }
//    }
     */


}