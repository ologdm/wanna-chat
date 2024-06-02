package com.example.wannachat.ui.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wannachat.databinding.VhDetailImageReceivedBinding
import com.example.wannachat.databinding.VhDetailLocationReceivedBinding
import com.example.wannachat.databinding.VhDetailLocationSentBinding
import com.example.wannachat.databinding.VhDetailTextReceivedBinding
import com.example.wannachat.databinding.VhDetailTextSentBinding
import com.example.wannachat.domain.MessageItem


class DetailAdapter(
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val VH_TYPE_TEXT_RECEIVED = 1
        const val VH_TYPE_TEXT_SENT = 2
        const val VH_TYPE_LOCATION_RECEIVED = 3
        const val VH_TYPE_LOCATION_SENT = 4
        const val VH_TYPE_IMAGE_RECEIVED = 5

        const val TEXT = "text"
        const val LOCATION = "location"
        const val IMAGE = "image"
    }

    private var adapterList: List<MessageItem> = listOf()


    override fun getItemViewType(position: Int): Int {
        val item = adapterList[position]
        return when (item.type) {
            TEXT -> if (item.isMe) VH_TYPE_TEXT_SENT else VH_TYPE_TEXT_RECEIVED
            LOCATION -> if (item.isMe) VH_TYPE_LOCATION_SENT else VH_TYPE_LOCATION_RECEIVED
            IMAGE -> VH_TYPE_IMAGE_RECEIVED
            else -> error("invalid type")
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        when (viewType) {
            VH_TYPE_TEXT_RECEIVED -> {
                val binding =
                    VhDetailTextReceivedBinding.inflate(layoutInflater, parent, false)
                return DetailTextReceivedVH(binding)
            }

            VH_TYPE_TEXT_SENT -> {
                val binding =
                    VhDetailTextSentBinding.inflate(layoutInflater, parent, false)
                return DetailTextSentVH(binding)
            }

            VH_TYPE_LOCATION_RECEIVED -> {
                val binding =
                    VhDetailLocationReceivedBinding.inflate(layoutInflater, parent, false)
                return DetailLocationReceivedVH(binding)
            }

            VH_TYPE_LOCATION_SENT -> {
                val binding =
                    VhDetailLocationSentBinding.inflate(layoutInflater, parent, false)
                return DetailLocationSentVH(binding)
            }

            VH_TYPE_IMAGE_RECEIVED -> {
                val binding = VhDetailImageReceivedBinding.inflate(layoutInflater, parent,false)
                return DetailImageVH(binding)
            }

            else -> error("Invalid view type")
        }
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = adapterList.get(position)

        when (holder) {
            is DetailTextReceivedVH -> {
                holder.bindTextVH(item)
            }
            is DetailTextSentVH -> {
                holder.bindTextVH(item)
            }
            is DetailLocationSentVH -> {
                holder.bind(item)
            }
            is DetailLocationReceivedVH -> {
                holder.bind(item)
            }
            is DetailImageVH -> {
                holder.bind(item)
            }
        }
    }


    override fun getItemCount(): Int {
        return adapterList.size
    }


    fun updateList(list: List<MessageItem>) {
        adapterList = list
        notifyDataSetChanged()
    }


}