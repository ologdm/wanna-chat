package com.example.chatapp.data.detail

import com.example.chatapp.data.dto.MessageDto
import com.example.chatapp.data.dto.toDomain
import com.example.chatapp.domain.MessageItem
import com.example.chatapp.utils.IoResponse
import com.example.chatapp.utils.ioMapper
import java.io.IOException

object DetailRepo {

    fun getMessagesList(onResponse: (IoResponse<List<MessageItem>>) -> Unit) {
        DetailNetworkDS.getMessageList { response ->
            val mapped = response.ioMapper { rawDto ->
                val mappedList = rawDto.record.map { dto ->
                    dto.toDomain()
                }
                val sortedList = mappedList.sortedByDescending { item ->
                    item.date
                }
                sortedList// ioMapper return
            }
            onResponse(mapped)
        }
    }


    // ELIMINARE
//    fun getMessagesList(
//        onSuccess: (List<MessageItem>) -> Unit,
//        onErrorIO: () -> Unit,
//        onErrorOther: () -> Unit
//    ) {
//        DetailNetworkDS.getMessageList(
//            onSuccess = {
//                val list: List<MessageDto> = it.record
//                val mappedList = list.map {
//                    it.toDomain()
//                }
//                val sortedList = mappedList.sortedByDescending {
//                    it.date
//                }
//                onSuccess(sortedList) // ##
//
//            },
//            onError = {
//                if (it is IOException) {
//                    it.printStackTrace()
//                    onErrorIO()  // ##
//                } else {
//                    onErrorOther()  // ##
//                }
//
//            }
//        )
//
//    }


}