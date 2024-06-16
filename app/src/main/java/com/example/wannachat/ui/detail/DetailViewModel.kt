package com.example.wannachat.ui.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wannachat.domain.ChatRepo
import com.example.wannachat.domain.MessageItem
import com.example.wannachat.utils.IoResponse
import com.example.wannachat.utils.StateContainer
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.lang.Thread.State
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val repository: ChatRepo
) : ViewModel() {

    val state = MutableLiveData<StateContainer<MessageItem>>()


    init {
        loadConversationMessages()
    }


    fun loadConversationMessages() {
        viewModelScope.launch {
            state.value = StateContainer(isLoading = true)

            when (val response = repository.getMessages()) {
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



//state.value = StateContainer(isLoading = true)
//
//        repository.getMessages { response ->
//            when (response) {
//                is IoResponse.Success -> {
//                    state.value = StateContainer(items = response.value)
//                }
//
//                is IoResponse.NetworkError -> {
//                    state.value = StateContainer(isNetworkError = true)
//                }
//
//                is IoResponse.OtherError -> {
//                    state.value = StateContainer(isOtherError = true)
//                }
//            }
//
//        }
