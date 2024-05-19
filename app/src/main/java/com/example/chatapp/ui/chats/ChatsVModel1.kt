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
                    state.value = StateContainer(items = it.value)
                    println("YYY SUCCESS")
                }

                is IoResponse.NetworkError -> {
                    state.value = StateContainer(isNetworkError = true)
                    println("YYY IO")
                }

                is IoResponse.OtherError -> {
                    state.value = StateContainer(isOtherError = true)
                    println("YYY OTHER")
                }
            }
        }

    }



}