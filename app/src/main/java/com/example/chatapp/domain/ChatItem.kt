package com.example.chatapp.domain

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


/* JSON
{
    "id": 53,
    "user_name": "Silvio Berlusconi",
    "avatar_url": "https://upload.wikimedia.org/wikipedia/commons/thumb/0/01/Silvio_Berlusconi_%282010%29_cropped.jpg/400px-Silvio_Berlusconi_%282010%29_cropped.jpg",
    "last_message_content": "I bet you will like this deal. check it out asap and let me know.",
    "last_message_date": "12:05:14 2021-05-12",
    "unseen_count": 99
}
 */