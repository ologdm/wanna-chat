package com.example.wannachat.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.Date

@Parcelize
data class ChatItem(
    val id: Int,
    val userName: String,
    val avatarUrl: String,
    val lastMsgContent: String,
    val lastMsgDate: Date, //
    val unseenCount: Int
) : Parcelable
