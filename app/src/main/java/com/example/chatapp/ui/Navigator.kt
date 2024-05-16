package com.example.chatapp.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import com.example.chatapp.R
import com.example.chatapp.domain.ChatItem
import com.example.chatapp.ui.msgscreen.MsgScreenFragment

class Navigator {


    // start Mainscreen OK
    fun startMainscreen(fragmentActivity: FragmentActivity, fragment: Fragment) {
        val fragmentManager: FragmentManager = fragmentActivity.supportFragmentManager
        fragmentManager.beginTransaction()
            .replace(R.id.frameLayout, fragment)
            .commit()
    }


    // start detail OK
    fun startDetail(fragmentActivity: FragmentActivity, chatItem: ChatItem) {
        val fragmentManager = fragmentActivity.supportFragmentManager
        fragmentManager.beginTransaction()
            .replace(R.id.frameLayout, MsgScreenFragment.create(chatItem)) // TODO add create
            .addToBackStack(null)
            .commit()
    }


}