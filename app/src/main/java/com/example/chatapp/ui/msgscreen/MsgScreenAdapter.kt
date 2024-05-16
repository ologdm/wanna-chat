package com.example.chatapp.ui.msgscreen

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.chatapp.domain.MessageItem


class MsgScreenAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    companion object {
        const val VIEW_TYPE_SENT = 1
        const val VIEW_TYPE_RECEIVED = 2
    }

    private var adapterList: List<MessageItem> = listOf()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}