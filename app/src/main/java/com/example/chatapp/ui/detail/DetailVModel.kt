package com.example.chatapp.ui.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.chatapp.data.detail.DetailRepo
import com.example.chatapp.domain.MessageItem


class DetailVModel : ViewModel() {

    val itemList = MutableLiveData<List<MessageItem>>()


    fun loadConversationMessages() {
        DetailRepo.getMessagesList(
            onSuccess = {
                itemList.value = it
                println("XXX DETAIL_VM SUCCESS")
            },
            onErrorIO = {
                println("XXX DETAIL_VM_ERROR IO")
            },
            onErrorOther = {
                println("XXX DETAIL_ERROR")
            }
        )
    }


}