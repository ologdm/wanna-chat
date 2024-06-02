package com.example.wannachat.ui.detail.vh

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.wannachat.databinding.VhDetailImageReceivedBinding
import com.example.wannachat.databinding.VhDetailImageSentBinding
import com.example.wannachat.domain.MessageItem
import com.example.wannachat.utils.formatToStringDateTime

class DetailImageReceivedVH(
    val binding: VhDetailImageReceivedBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: MessageItem) {

        Glide.with(binding.root.context)
            .load(item.content)
            .into(binding.image)

        binding.date.hint = item.date.formatToStringDateTime()
    }


}


// Vh ready to use
class DetailImageSentVH(
    val binding: VhDetailImageSentBinding
) : RecyclerView.ViewHolder(binding.root) {


    fun bind(item: MessageItem) {
        Glide.with(binding.root.context)
            .load(item.content)
            .into(binding.image)

        binding.date.hint = item.date.formatToStringDateTime()
    }


}