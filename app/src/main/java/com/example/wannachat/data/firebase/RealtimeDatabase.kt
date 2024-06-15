package com.example.wannachat.data.firebase

import com.google.firebase.Firebase
import com.google.firebase.database.database

class RealtimeDatabase {

    // 1. == FirebaseDatabase.getInstance()
    val myDatabase = Firebase.database

    // 2. == database.getReference("message")
    val myRef = myDatabase.getReference("message")

    fun test (){
        myRef.setValue("Hello, World!")

    }

}