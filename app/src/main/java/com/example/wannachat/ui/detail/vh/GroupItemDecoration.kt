//package com.example.wannachat.ui.detail.vh
//
//import android.graphics.Rect
//import android.view.View
//import androidx.recyclerview.widget.RecyclerView
//import com.example.wannachat.ui.detail.DetailAdapter
//
//class GroupItemDecoration(
//    private val space: Int
//) : RecyclerView.ItemDecoration() {
//    override fun getItemOffsets(
//        outRect: Rect,
//        view: View,
//        parent: RecyclerView,
//        state: RecyclerView.State
//    ) {
//        val position = parent.getChildAdapterPosition(view)
//        val adapter = parent.adapter as DetailAdapter
//
//        if (position != RecyclerView.NO_POSITION) {
//            if (position > 0) {
//                val currentItem = adapter.adapterList[position]
//                val previousItem = adapter.adapterList[position - 1]
//
//                // Aggiungi spazio solo se cambia il gruppo tra "sent" e "received"
//                if (currentItem.isMe != previousItem.isMe) {
//                    outRect.top = space
//                }
//            }
//        }
//    }
//}