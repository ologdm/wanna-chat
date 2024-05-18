package com.example.chatapp.ui.chats

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.chatapp.data.chats.ChatsRepo
import com.example.chatapp.domain.ChatItem


class ChatsVModel() : ViewModel() {

    val itemList = MutableLiveData<List<ChatItem>>()


    fun loadUserConversations() {

        ChatsRepo.getChatsList(
            onSuccess = {
                itemList.value = it // OK


                // TODO manage ES success
                println("XXX VM SUCCESS")
            },

            onErrorIO = {
                println("XXX VM ERROR IO")
                // TODO manage ES Io

            },

            onErrorOther = {
                println("XXX VM ERROR")
                // TODO manage ES Other
            }

        )
    }




}