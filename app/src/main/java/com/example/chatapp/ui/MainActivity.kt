package com.example.chatapp.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.chatapp.R
import com.example.chatapp.ui.chatscreen.ChatScreenFragment


// only access to MainscreeenFragment


class MainActivity : AppCompatActivity() {


    private val navigator = Navigator()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() //
        setContentView(R.layout.activity_main)

         //adapt enableEdgeToEdge() to screen
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        navigator.startMainscreen(this, ChatScreenFragment())

    }
}