package com.example.wannachat.ui.chats

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

    val state = MutableLiveData<StateContainer<ChatItem>>()

    init {
        loadUserConversations()
    }

//    suspend fun loadUserConversations2(): StateContainer<ChatItem> {
//        state.value = StateContainer(isLoading = true)
//
//        val response = repository.getChats()
//        return when (response) {
//            is IoResponse.Success -> {
//                StateContainer(items = response.value)
//            }
//
//            is IoResponse.NetworkError -> {
//                StateContainer(isNetworkError = true)
//            }
//
//            is IoResponse.OtherError -> {
//                StateContainer(isOtherError = true)
//            }
//        }
//    }

    fun loadUserConversations() {
        viewModelScope.launch {
            state.value = StateContainer(isLoading = true)

            val response = repository.getChats()
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


//        state.value = StateContainer(isLoading = true)
//
//        repository.getChats { response ->
//            when (response) {
//                is IoResponse.Success -> {
//                    state.value = StateContainer(items = response.value)
//                }
//                is IoResponse.NetworkError -> {
//                    state.value = StateContainer(isNetworkError = true)
//                }
//                is IoResponse.OtherError -> {
//                    state.value = StateContainer(isOtherError = true)
//                }
//            }
//        }

    }


}