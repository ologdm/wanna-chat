package com.example.chatapp.ui.mscreen

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.chatapp.databinding.VhMainscreenBinding
import com.example.chatapp.domain.ChatItem

class MScreenVH(
    val binding: VhMainscreenBinding // binding.root == itemView
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

        }

    }


}