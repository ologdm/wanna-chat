package com.example.wannachat.ui.chats

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.wannachat.databinding.VhChatsBinding
import com.example.wannachat.domain.ChatItem


class ChatsAdapter(
    private val onClick: (chatItem: ChatItem) -> Unit
) : ListAdapter<ChatItem, ChatsVH>(ChatsAdapter) {


    companion object : DiffUtil.ItemCallback<ChatItem>() {
        override fun areItemsTheSame(oldItem: ChatItem, newItem: ChatItem): Boolean {
            return oldItem.id == newItem.id
        }
        override fun areContentsTheSame(oldItem: ChatItem, newItem: ChatItem): Boolean {
            return oldItem == newItem
        }
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ChatsVH {
        val inflater = LayoutInflater.from(parent.context)
        val binding =
            VhChatsBinding.inflate(inflater, parent, false)
        return ChatsVH(binding)
    }


    override fun onBindViewHolder(
        holder: ChatsVH,
        position: Int
    ) {
        val currentItem = getItem(position)

        holder.itemView.setOnClickListener {
            onClick.invoke(currentItem)
        }

        holder.bindChatsVH(currentItem)
    }
}