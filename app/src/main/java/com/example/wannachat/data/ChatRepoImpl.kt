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
    private val networkDS: NetworkDS
) : ChatRepo {


    override
    suspend fun getChats(): IoResponse<List<ChatItem>> {
        return networkDS.getChatsList()
            .ioMapper { rawDto ->
                rawDto.record
                    .map { dto -> dto.toDomain() }
                    .sortedByDescending { item -> item.lastMsgDate }
            }
    }


    override
    suspend fun getMessages(): IoResponse<List<MessageItem>> {
        return networkDS.getMessagesList()
            .ioMapper { rawDto ->
                rawDto.record
                    .map { dto -> dto.toDomain() }
                    .sortedByDescending { item -> item.date }
            }
    }


}