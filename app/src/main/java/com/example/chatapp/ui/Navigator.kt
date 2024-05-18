package com.example.chatapp.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import com.example.chatapp.R
import com.example.chatapp.domain.ChatItem
import com.example.chatapp.ui.detail.DetailFragment

class Navigator {


    fun startMainscreen(fragmentActivity: FragmentActivity, fragment: Fragment) {
        val fragmentManager: FragmentManager = fragmentActivity.supportFragmentManager
        fragmentManager.beginTransaction()
            .replace(R.id.frameLayout, fragment)
            .commit()
    }


    fun startDetail(fragmentActivity: FragmentActivity, chatItem: ChatItem) {
        val fragmentManager = fragmentActivity.supportFragmentManager
        fragmentManager.beginTransaction()
            .replace(R.id.frameLayout, DetailFragment.create(chatItem))
            .addToBackStack(null)
            .commit()
    }


}