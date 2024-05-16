package com.example.chatapp.ui.chatscreen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.chatapp.data.chatscreen.ChatScreenRepo
import com.example.chatapp.domain.ChatItem

// essential function
//  - load

// other
//  - send


class ChatScreenVModel() : ViewModel() {

    // observable OK
    val chatItemList = MutableLiveData<List<ChatItem>>()

//    val state = MutableLiveData<ChatSreenState>() TODO


    fun loadUserConversations() {

        ChatScreenRepo.getChatsList(
            onSuccess = {
                // update list OK
                chatItemList.value = it

//                state.value = ChatSreenState(
//                    items = it,
//                    isError = false,
//                )
                // TODO manage ES success
                println("XXX VM SUCCESS")
            },

            onErrorIO = {
                println("XXX VM ERROR IO")
                // TODO manage ES Io
//                state.value = ChatSreenState(
//                    items = emptyList(),
//                    isError = true,
//                )
            },

            onErrorOther = {
                println("XXX VM ERROR")
                // TODO manage ES Other
            }

        )
    }


// TODO internet state
//    data class ChatSreenState(
//        val items: List<ChatItem>,
//        val isError: Boolean,
//    )


}