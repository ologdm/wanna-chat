package com.example.wannachat.ui.chats

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.wannachat.databinding.VhChatsBinding
import com.example.wannachat.domain.ChatItem
import com.example.wannachat.utils.formatToStringDate



class ChatsVH(
    private val binding: VhChatsBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bindChatsVH(chatItem: ChatItem) {
        binding.run {
            userName.text = chatItem.userName
            lastMessage.text = chatItem.lastMsgContent
            Glide.with(binding.root)
                .load(chatItem.avatarUrl)
                .into(avatarImage)
            lastDate.hint = chatItem.lastMsgDate.formatToStringDate()
        }

    }


}