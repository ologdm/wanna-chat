package com.example.chatapp.ui.chats

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.chatapp.data.chats.ChatsRepo1
import com.example.chatapp.domain.ChatItem
import com.example.chatapp.utils.IoResponse
import com.example.chatapp.utils.StateContainer


class ChatsVModel() : ViewModel() {

//    val itemList = MutableLiveData<List<ChatItem>>()
    val state = MutableLiveData<StateContainer<ChatItem>>()

    fun loadUserConversations() {

        ChatsRepo1.getChatsList {
            when (it) {
                is IoResponse.Success -> {
                    println("XXX SUCCESS")
                    state.value = StateContainer(items = it.value)
                }

                is IoResponse.NetworkError -> {
                    // TODO no internet
                    println("XXX ERROR IO")
                    state.value = StateContainer(isNetworkError = true)
                }

                is IoResponse.OtherError -> {
                    // TODO other error
                    println("XXX ERROR OTHER")
                    state.value = StateContainer(isOtherError = true)

                }
            }
        }

    }





}