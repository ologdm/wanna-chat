package com.example.chatapp.utils.test

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.chatapp.data.chats.ChatsRepo
import com.example.chatapp.domain.ChatItem
import com.example.chatapp.utils.IoResponse
import com.example.chatapp.utils.StateContainer


class ChatsVModelOld() : ViewModel() {

//    val itemList = MutableLiveData<List<ChatItem>>()
    val state = MutableLiveData<StateContainer<ChatItem>>()

    fun loadUserConversations() {

        ChatsRepo.getChatsList {
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