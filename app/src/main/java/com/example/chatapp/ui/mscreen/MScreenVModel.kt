package com.example.chatapp.ui.mscreen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.chatapp.data.mscreen.MScreenRepo
import com.example.chatapp.domain.ChatItem

// essential function
//  - load

// other
//  - send


class MScreenVModel() : ViewModel() {

    // observable OK
    val chatItemList = MutableLiveData<List<ChatItem>>()

//    val emptyState = MutableLiveData<EmptyStatesEnum>() TODO


    fun loadUserConversations() {

        MScreenRepo.getChatsList(
            onSuccess = {
                // update list OK
                chatItemList.value = it

                // TODO manage ES success
                println("XXX VM SUCCESS")
            },

            onErrorIO = {
                // TODO manage ES Io
                println("XXX VM ERROR IO")
            },

            onErrorOther = {
                // TODO manage ES Other
                println("XXX VM ERROR")
            }

        )
    }


}