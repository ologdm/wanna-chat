package com.example.chatapp.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.chatapp.domain.ChatItem
import com.example.chatapp.domain.MessageItem
import com.example.chatapp.fakes.FakeChatRepo
import com.example.chatapp.utils.IoResponse
import com.example.chatapp.utils.StateContainer
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import java.util.Date


class DetailViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Test
    fun testSuccess() {
        val response = listOf(MessageItem(1, "", "", false, Date()))
        val repository = FakeChatRepo(messagesResponse = IoResponse.Success(response))
        val viewModel = DetailViewModel(repository)

        viewModel.loadConversationMessages()

        val expected = StateContainer(items = response)
        Assert.assertEquals(
            expected,
            viewModel.state.value
        )
    }

    @Test
    fun testNetworkError() {
        val repository = FakeChatRepo(messagesResponse = IoResponse.NetworkError)
        val viewModel = DetailViewModel(repository)

        viewModel.loadConversationMessages()

        val expected = StateContainer<ChatItem>(isNetworkError = true)
        Assert.assertEquals(
            expected,
            viewModel.state.value
        )
    }

    @Test
    fun testOtherError() {
        val repository = FakeChatRepo(messagesResponse = IoResponse.OtherError)
        val viewModel = DetailViewModel(repository)

        viewModel.loadConversationMessages()

        val expected = StateContainer<ChatItem>(isOtherError = true)
        Assert.assertEquals(
            expected,
            viewModel.state.value
        )
    }

}