package com.example.chatapp.ui.detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.chatapp.domain.ChatItem

class DetailFragment : Fragment() {

    // val chatItem: ChatItem


    companion object {
        fun create(chatItem: ChatItem): DetailFragment {
            val detailFragment= DetailFragment()
            // TODO Arguments
            return detailFragment
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        // TODO - getArguments
        val x = arguments


    }
}