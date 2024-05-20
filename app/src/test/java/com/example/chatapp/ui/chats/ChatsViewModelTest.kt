package com.example.chatapp.ui.chats

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.chatapp.domain.ChatItem
import com.example.chatapp.fakes.FakeChatRepo
import com.example.chatapp.utils.IoResponse
import com.example.chatapp.utils.StateContainer
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import java.util.Date

class ChatsViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Test
    fun testSuccess() {
        val response = listOf(ChatItem(1, "", "", "", Date(), 0))
        val repository = FakeChatRepo(chatResponse = IoResponse.Success(response))
        val viewModel = ChatsViewModel(repository)

        viewModel.loadUserConversations()

        val expected = StateContainer(items = response)
        Assert.assertEquals(
            expected,
            viewModel.state.value
        )
    }

    @Test
    fun testNetworkError() {
        val repository = FakeChatRepo(chatResponse = IoResponse.NetworkError)
        val viewModel = ChatsViewModel(repository)

        viewModel.loadUserConversations()

        val expected = StateContainer<ChatItem>(isNetworkError = true)
        Assert.assertEquals(
            expected,
            viewModel.state.value
        )
    }

    @Test
    fun testOtherError() {
        val repository = FakeChatRepo(chatResponse = IoResponse.OtherError)
        val viewModel = ChatsViewModel(repository)

        viewModel.loadUserConversations()

        val expected = StateContainer<ChatItem>(isOtherError = true)
        Assert.assertEquals(
            expected,
            viewModel.state.value
        )
    }

}