package com.example.chatapp.ui.detail

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.chatapp.databinding.VhDetailLocationReceivedBinding
import com.example.chatapp.databinding.VhDetailLocationSentBinding
import com.example.chatapp.domain.MessageItem
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class DetailLocationReceivedVH(
    private val binding: VhDetailLocationReceivedBinding
) : ViewHolder(binding.root) {


    fun bind(item: MessageItem) {
        binding.map.onCreate(null)

        binding.map.getMapAsync {
            val list = item.content.split(",")

            // Maps - todo da vedere
            val (lat, long) = item.content.split(",")
            val position = LatLng(lat.toDouble(), long.toDouble())

            binding.map.onResume()
            it.moveCamera(CameraUpdateFactory.newLatLngZoom(position, 15f))
            it.addMarker(MarkerOptions().position(position))
        }
    }
}


class DetailLocationSentVH(
    val binding: VhDetailLocationSentBinding
) : ViewHolder(binding.root) {


    fun bind(item: MessageItem) {

    }

}