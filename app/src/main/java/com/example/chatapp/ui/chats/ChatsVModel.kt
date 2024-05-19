package com.example.chatapp.ui.chats

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.chatapp.data.chats.ChatsRepo
import com.example.chatapp.domain.ChatItem
import com.example.chatapp.utils.IoResponse
import com.example.chatapp.utils.StateContainer


class ChatsVModel() : ViewModel() {

    val state = MutableLiveData<StateContainer<ChatItem>>()

    fun loadUserConversations() {
        state.value = StateContainer(isLoading = true)

        ChatsRepo.getChatsList { response ->
            when (response) {
                is IoResponse.Success -> {
                    println("ZZZ VM SUCCESS")
                    state.value = StateContainer(items = response.value)

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