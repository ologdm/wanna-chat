package com.example.wannachat.ui.chats

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wannachat.domain.ChatItem
import com.example.wannachat.domain.ChatRepo
import com.example.wannachat.utils.IoResponse
import com.example.wannachat.utils.StateContainer
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChatsViewModel @Inject constructor(
    private val repository: ChatRepo
) : ViewModel() {

    private val _state = MutableLiveData<StateContainer<ChatItem>>()
    val state: LiveData<StateContainer<ChatItem>> get() = _state


    init {
        loadUserConversations()
    }


    fun loadUserConversations() {
        viewModelScope.launch {
            _state.value = StateContainer(isLoading = true)

            when (val response = repository.getChats()) {
                is IoResponse.Success -> {
                    _state.value = StateContainer(items = response.value)
                }

                is IoResponse.NetworkError -> {
                    _state.value = StateContainer(isNetworkError = true)
                }

                is IoResponse.OtherError -> {
                    _state.value = StateContainer(isOtherError = true)
                }
            }
        }
    }


}
