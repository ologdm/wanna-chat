package com.example.chatapp.ui.detail

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.chatapp.databinding.VhDetailTextReceivedBinding
import com.example.chatapp.databinding.VhDetailTextSentBinding
import com.example.chatapp.domain.MessageItem
import com.example.chatapp.utils.formatToStringDateTime

class DetailTextReceivedVH(
    private val binding: VhDetailTextReceivedBinding
) : ViewHolder(binding.root) {


    fun bindTextVH(item: MessageItem){
        binding.messageText.text = item.content
        binding.date.text= item.date.formatToStringDateTime()
    }

}

class DetailTextSentVH(
    private val binding: VhDetailTextSentBinding
) : ViewHolder(binding.root) {


    fun bindTextVH(item: MessageItem){
        binding.messageText.text = item.content
        binding.date.text= item.date.formatToStringDateTime()
    }

}