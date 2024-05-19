package com.example.chatapp.ui.chats

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.chatapp.data.chats.ChatsRepo1
import com.example.chatapp.domain.ChatItem
import com.example.chatapp.utils.IoResponse
import com.example.chatapp.utils.StateContainer


class ChatsVModel1() : ViewModel() {

    val state = MutableLiveData<StateContainer<ChatItem>>()

    fun loadUserConversations() {
        state.value = StateContainer(isLoading = true)

        ChatsRepo1.getChatsList {
            when (it) {
                is IoResponse.Success -> {
                    println("ZZZ VM SUCCESS")
                    state.value = StateContainer(items = it.value)

                }

                is IoResponse.NetworkError -> {
                    println("ZZZ VM ERROR IO")
                    state.value = StateContainer(isNetworkError = true)
                }

                is IoResponse.OtherError -> {
                    println("ZZZ VM ERROR OTHER")
                    state.value = StateContainer(isOtherError = true)
                }
            }
        }

    }



}