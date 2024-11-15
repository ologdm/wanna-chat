package com.example.wannachat.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wannachat.domain.ChatRepo
import com.example.wannachat.domain.MessageItem
import com.example.wannachat.utils.IoResponse
import com.example.wannachat.utils.StateContainer
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class DetailViewModel @Inject constructor(
    private val repository: ChatRepo
) : ViewModel() {

    private val _state = MutableLiveData<StateContainer<MessageItem>>()
    val state: LiveData<StateContainer<MessageItem>> get()= _state


    init {
        loadConversationMessages()
    }


    fun loadConversationMessages() {
        viewModelScope.launch {
            _state.value = StateContainer(isLoading = true)

            when (val response = repository.getMessages()) {
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
