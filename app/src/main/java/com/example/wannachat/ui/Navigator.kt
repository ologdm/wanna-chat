package com.example.wannachat.ui

import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.wannachat.R
import com.example.wannachat.domain.ChatItem
import com.example.wannachat.ui.chats.ChatsFragment
import com.example.wannachat.ui.detail.DetailFragment
import javax.inject.Inject


class Navigator @Inject constructor(
    private val fragmentActivity: FragmentActivity
) {

    fun startChatsFragment() {
        val fragmentManager: FragmentManager = fragmentActivity.supportFragmentManager
        fragmentManager.beginTransaction()
            .replace(R.id.frameLayout, ChatsFragment())
            .commit()
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