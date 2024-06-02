package com.example.chatapp.ui.detail

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.chatapp.databinding.VhDetailImageReceivedBinding
import com.example.chatapp.domain.MessageItem

class DetailImageVH(
    val binding: VhDetailImageReceivedBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind (item : MessageItem){

        Glide.with(binding.root.context)
            .load(item.content)
            .into(binding.imageView)


//        bind.imageView
    }


}