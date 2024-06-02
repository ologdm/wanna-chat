package com.example.wannachat.fakes

import com.example.wannachat.domain.ChatItem
import com.example.wannachat.domain.ChatRepo
import com.example.wannachat.domain.MessageItem
import com.example.wannachat.utils.IoResponse

class FakeChatRepo(
    private val chatResponse: IoResponse<List<ChatItem>> = IoResponse.OtherError,
    private val messagesResponse: IoResponse<List<MessageItem>> = IoResponse.OtherError,
) : ChatRepo {

    override fun getChats(onResponse: (IoResponse<List<ChatItem>>) -> Unit) {
        onResponse(chatResponse)
    }

    override fun getMessages(onResponse: (IoResponse<List<MessageItem>>) -> Unit) {
        onResponse(messagesResponse)
    }
}