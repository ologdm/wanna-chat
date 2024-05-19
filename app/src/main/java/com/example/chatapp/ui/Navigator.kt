package com.example.chatapp.ui

import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.chatapp.R
import com.example.chatapp.domain.ChatItem
import com.example.chatapp.ui.chats.ChatsFragment
import com.example.chatapp.ui.detail.DetailFragment
import javax.inject.Inject


class Navigator @Inject constructor(
    private val fragmentActivity: FragmentActivity
) {

    fun startChatsFragment() {
        val fragmentManager: FragmentManager = fragmentActivity.supportFragmentManager
        fragmentManager.beginTransaction().replace(R.id.frameLayout, ChatsFragment()).commit()
    }


    fun startDetailFragment(chatItem: ChatItem) {
        val fragmentManager = fragmentActivity.supportFragmentManager
        fragmentManager.beginTransaction()
            .replace(R.id.frameLayout, DetailFragment.create(chatItem))
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            .addToBackStack(null)
            .commit()
    }


}