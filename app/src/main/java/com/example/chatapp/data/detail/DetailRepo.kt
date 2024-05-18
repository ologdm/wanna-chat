package com.example.chatapp.data.detail

import com.example.chatapp.data.dto.MessageDto
import com.example.chatapp.data.dto.toDomain
import com.example.chatapp.domain.MessageItem
import java.io.IOException

object DetailRepo {


    fun getMessagesList(
        onSuccess: (List<MessageItem>) -> Unit,
        onErrorIO: () -> Unit,
        onErrorOther: () -> Unit
    ) {
        DetailNetworkDs.getMessageList(
            onSuccess = {
                val list: List<MessageDto> = it.record
                val mappedList = list.map {
                    it.toDomain()
                }
                val sortedList = mappedList.sortedByDescending {
                    it.date
                }
                onSuccess(sortedList) // ##

            },
            onError = {
                if (it is IOException) {
                    it.printStackTrace()
                    onErrorIO()  // ##
                } else {
                    onErrorOther()  // ##
                }

            }
        )

    }


}