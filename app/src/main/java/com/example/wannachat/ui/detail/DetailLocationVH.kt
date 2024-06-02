package com.example.wannachat.ui.detail

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.wannachat.databinding.VhDetailLocationReceivedBinding
import com.example.wannachat.databinding.VhDetailLocationSentBinding
import com.example.wannachat.domain.MessageItem
import com.example.wannachat.utils.formatToStringDateTime
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class DetailLocationReceivedVH(
    private val binding: VhDetailLocationReceivedBinding
) : ViewHolder(binding.root) {


    fun bind(item: MessageItem) {

        binding.map.onCreate(null)

        binding.map.getMapAsync {
            val (lat, long) = item.content.split(",")
            val position = LatLng(lat.toDouble(), long.toDouble())

            binding.map.onResume()
            it.moveCamera(CameraUpdateFactory.newLatLngZoom(position, 15f))
            it.addMarker(MarkerOptions().position(position))
        }

        binding.date.hint = item.date.formatToStringDateTime()
    }
}


class DetailLocationSentVH(
    private val binding: VhDetailLocationSentBinding
) : ViewHolder(binding.root) {

    fun bind(item: MessageItem) {

        // maps function ready to use
//        binding.map.onCreate(null)
//
//        binding.map.getMapAsync {
//            val (lat, long) = item.content.split(",")
//            val position = LatLng(lat.toDouble(), long.toDouble())
//
//            binding.map.onResume()
//            it.moveCamera(CameraUpdateFactory.newLatLngZoom(position, 15f))
//            it.addMarker(MarkerOptions().position(position))
//        }
//
//        binding.date.hint = item.date.formatToStringDateTime()
    }

}