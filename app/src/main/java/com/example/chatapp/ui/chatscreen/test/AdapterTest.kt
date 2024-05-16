package com.example.chatapp.ui.chatscreen.test

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.chatapp.R
import com.example.chatapp.domain.ChatItem

class AdapterTest : RecyclerView.Adapter<VHtest>() {

    private var adapterList = listOf<ChatItem>()


    // OK
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VHtest {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.vh_chat_screen, parent, false)
        return VHtest(view)
//        val binding = VhMainscreenBinding.inflate(layoutInflater, parent, false)
//        return VHtest(binding)
    }

    // OK
    override fun getItemCount(): Int {
        return adapterList.size
    }

    // OK
    override fun onBindViewHolder(holder: VHtest, position: Int) {

        var item = adapterList.get(position)

        val name: TextView = holder.itemView.findViewById(R.id.name)
        val message: TextView = holder.itemView.findViewById(R.id.message)
        name.text = item.userName
        message.text = item.lastMessageContent

//        with(holder.binding) {
//            name.text = item.userName
//            message.text = item.lastMessageContent
//        }
    }


    fun updateList(list: List<ChatItem>) {
        adapterList = list
        notifyDataSetChanged()
        println(" XXX TEST UPDATE ADAPTER")
    }


}