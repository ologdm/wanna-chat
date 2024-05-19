package com.example.chatapp.ui.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.chatapp.data.ChatRepo
import com.example.chatapp.domain.ChatItem
import com.example.chatapp.domain.MessageItem
import com.example.chatapp.utils.IoResponse
import com.example.chatapp.utils.StateContainer
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val repository :ChatRepo
) : ViewModel() {

    val state = MutableLiveData<StateContainer<MessageItem>>()


    fun loadConversationMessages() {
        state.value = StateContainer(isLoading = true)

        repository.getMessages { response ->
            when (response) {
                is IoResponse.Success -> {
                    state.value = StateContainer(items = response.value)
                }

                is IoResponse.NetworkError -> {
                    state.value = StateContainer(isNetworkError = true)
                }

                is IoResponse.OtherError -> {
                    state.value = StateContainer(isOtherError = true)
                }
            }

        }
    }


}