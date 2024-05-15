package com.example.chatapp.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import com.example.chatapp.R
import com.example.chatapp.ui.detail.DetailFragment

class Navigator {


    // start Mainscreen OK
    fun startMainscreen(fragmentActivity: FragmentActivity, fragment: Fragment) {
        val fragmentManager: FragmentManager = fragmentActivity.supportFragmentManager

        fragmentManager.beginTransaction()
            .replace(R.id.frameLayout, fragment)
            .commit()
    }


    // start detail OK
    fun startDetail(fragmentActivity: FragmentActivity) {
        val fragmentManager = fragmentActivity.supportFragmentManager
        fragmentManager.beginTransaction()
            .replace(R.id.frameLayout,DetailFragment())
            .addToBackStack(null)
            .commit()
    }


}