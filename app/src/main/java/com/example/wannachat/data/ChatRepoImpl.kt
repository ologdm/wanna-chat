package com.example.wannachat.data

import com.example.wannachat.data.dto.toDomain
import com.example.wannachat.domain.ChatItem
import com.example.wannachat.domain.ChatRepo
import com.example.wannachat.domain.MessageItem
import com.example.wannachat.utils.IoResponse
import com.example.wannachat.utils.ioMapper
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ChatRepoImpl @Inject constructor(
    private val chatNetworkDS: ChatNetworkDS
) : ChatRepo {


    override
    suspend fun getChats(): IoResponse<List<ChatItem>> {
        return chatNetworkDS.getChatsList()
            .ioMapper { rawDto ->
                rawDto.record
                    .map { dto -> dto.toDomain() }
                    .sortedByDescending { item -> item.lastMsgDate }
            }
    }


    override
    suspend fun getMessages(): IoResponse<List<MessageItem>> {
        // devo mappare oggetto ottenuto
        return chatNetworkDS.getMessageList()
            .ioMapper { rawDto ->
                rawDto.record
                    .map { dto -> dto.toDomain() }
                    .sortedByDescending { item -> item.date }
            }
    }


}


// old chats
//        chatNetworkDS.getChatsList { response ->
//            val mapped = response.ioMapper { rawDto ->
//                val mappedList = rawDto.record.map { dto ->
//                    dto.toDomain()
//                }
//                val sortedList = mappedList.sortedByDescending { item ->
//                    item.lastMsgDate
//                }
//                sortedList // forma finale che deve avere R
//            }
//            onResponse(mapped)
//        }