package com.example.chatapp.ui.chats

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.chatapp.data.chats.ChatsRepo1
import com.example.chatapp.domain.ChatItem
import com.example.chatapp.utils.IoResponse


class ChatsVModel() : ViewModel() {

    val itemList = MutableLiveData<List<ChatItem>>()


    fun loadUserConversations() {

        ChatsRepo1.getChatsList {
            when (it) {
                is IoResponse.Success -> {
                    itemList.value = it.value
                }

                is IoResponse.NetworkError -> {
                    // TODO no internet
                }

                is IoResponse.OtherError -> {
                    // TODO other error
                }
            }
        }

    }





}