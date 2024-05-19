package com.example.chatapp.utils

import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import com.example.chatapp.R


data class StateContainer<T>(
    val items: List<T> = emptyList(),
    val isNetworkError: Boolean = false,
    val isOtherError: Boolean = false,
    val isLoading: Boolean = false
)


fun <T> StateContainer<T>.statesFlow(
    progressBar: ProgressBar,
    errorMsg: TextView,
    retry: Button
) {
    val context = progressBar.context

    when {
        isLoading -> {
            progressBar.visibility = View.VISIBLE
            errorMsg.visibility = View.GONE
            retry.visibility = View.GONE
        }

        isNetworkError -> {
            progressBar.visibility = View.GONE
            errorMsg.visibility = View.VISIBLE
            retry.visibility = View.VISIBLE
            errorMsg.text = context.getString(R.string.please_check_your_internet_connection)
        }

        isOtherError -> {
            progressBar.visibility = View.GONE
            errorMsg.visibility = View.VISIBLE
            retry.visibility = View.GONE
            errorMsg.text = context.getString(R.string.something_went_wrong)
        }

        else -> {
            progressBar.visibility = View.GONE
            errorMsg.visibility = View.GONE
            retry.visibility = View.GONE
        }
    }
}



