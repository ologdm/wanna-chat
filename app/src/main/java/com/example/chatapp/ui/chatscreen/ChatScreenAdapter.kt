package com.example.chatapp.ui.chatscreen

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.chatapp.databinding.VhChatScreenBinding
import com.example.chatapp.domain.ChatItem

// pass companion to ListAdapter(constructor)
/* companion object - si usa perche utilizza il nome della classe
// altrimenti uso object */


class ChatScreenAdapter(
    val onClick: (chatItem: ChatItem) -> Unit // I need to pass name on conversation
) : ListAdapter<ChatItem, ChatScreenVH>(ChatScreenAdapter) {


    companion object : DiffUtil.ItemCallback<ChatItem>() {   // two members to implement
        // compare if same object (by id)
        override fun areItemsTheSame(oldItem: ChatItem, newItem: ChatItem): Boolean {
            return oldItem.id == newItem.id
        }

        // compare the content one by one (dataclass equals)
        override fun areContentsTheSame(oldItem: ChatItem, newItem: ChatItem): Boolean {
            return oldItem == newItem
        }
    }


    // ADAPTER METHODS
    // binding OK
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ChatScreenVH {
        val inflater = LayoutInflater.from(parent.context)
        val binding =
            VhChatScreenBinding.inflate(inflater, parent, false)
        return ChatScreenVH(binding)
        println("XXX ADAPTER CREATE VH")
    }


    // only logic, bind on VH OK
    override fun onBindViewHolder(
        holder: ChatScreenVH,
        position: Int
    ) {
        val currentItem = getItem(position)

//        onClick.invoke(currentItem) // pass dto


        holder.bindMScreenVH(currentItem) // bind on VH
        println("XXX ADAPTER LOGIC VH")
    }
}