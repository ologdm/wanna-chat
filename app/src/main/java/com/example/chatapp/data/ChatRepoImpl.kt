package com.example.chatapp.data

import com.example.chatapp.data.dto.toDomain
import com.example.chatapp.domain.ChatItem
import com.example.chatapp.domain.ChatRepo
import com.example.chatapp.domain.MessageItem
import com.example.chatapp.utils.IoResponse
import com.example.chatapp.utils.ioMapper
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ChatRepoImpl @Inject constructor(
    private val chatNetworkDS: ChatNetworkDS
) : ChatRepo {


    override fun getChats(onResponse: (IoResponse<List<ChatItem>>) -> Unit) {
        chatNetworkDS.getChatsList { response ->
            val mapped = response.ioMapper { rawDto ->
                val mappedList = rawDto.record.map { dto ->
                    dto.toDomain()
                }
                val sortedList = mappedList.sortedByDescending { item ->
                    item.lastMsgDate
                }
                sortedList
            }
            onResponse(mapped)
        }
    }


    override fun getMessages(onResponse: (IoResponse<List<MessageItem>>) -> Unit) {
        chatNetworkDS.getMessageList { response ->
            val mapped = response.ioMapper { rawDto ->
                val mappedList = rawDto.record.map { dto ->
                    dto.toDomain()
                }
                val sortedList = mappedList.sortedByDescending { item ->
                    item.date
                }
                sortedList
            }
            onResponse(mapped)
        }
    }


}
