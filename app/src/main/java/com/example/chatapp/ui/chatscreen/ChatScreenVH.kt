package com.example.chatapp.ui.chatscreen

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.chatapp.databinding.VhChatScreenBinding
import com.example.chatapp.domain.ChatItem


class ChatScreenVH(
    val binding: VhChatScreenBinding // binding.root == itemView
) : RecyclerView.ViewHolder(binding.root) {

    //
    fun bindMScreenVH(chatItem: ChatItem) {

        // foto, name, message, time OK
        binding.run {
            name.text = chatItem.userName
            message.text = chatItem.lastMessageContent
            Glide.with(binding.root)
                .load(chatItem.avatarUrl)
                .into(image)

            // TODO time
        }

    }


}