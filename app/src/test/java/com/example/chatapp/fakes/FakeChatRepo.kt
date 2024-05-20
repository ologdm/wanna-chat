package com.example.chatapp.fakes

import com.example.chatapp.domain.ChatItem
import com.example.chatapp.domain.ChatRepo
import com.example.chatapp.domain.MessageItem
import com.example.chatapp.utils.IoResponse

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