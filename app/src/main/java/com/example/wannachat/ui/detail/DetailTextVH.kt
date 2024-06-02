package com.example.wannachat.ui.detail

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.wannachat.databinding.VhDetailTextReceivedBinding
import com.example.wannachat.databinding.VhDetailTextSentBinding
import com.example.wannachat.domain.MessageItem
import com.example.wannachat.utils.formatToStringDateTime

class DetailTextReceivedVH(
    private val binding: VhDetailTextReceivedBinding
) : ViewHolder(binding.root) {


    fun bindTextVH(item: MessageItem){
        binding.messageText.text = item.content
        binding.date.hint= item.date.formatToStringDateTime()
    }

}

class DetailTextSentVH(
    private val binding: VhDetailTextSentBinding
) : ViewHolder(binding.root) {


    fun bindTextVH(item: MessageItem){
        binding.messageText.text = item.content
        binding.date.hint= item.date.formatToStringDateTime()
    }

}