//package com.example.wannachat.ui.detail.vh
//
//import android.graphics.Rect
//import android.view.View
//import androidx.recyclerview.widget.RecyclerView
//import com.example.wannachat.ui.detail.DetailAdapter
//
//
//// separo blocchi di messaggi
//
//class CustomItemDecoration(
//    private val space: Int
//) : RecyclerView.ItemDecoration() {
//
//
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
//            if (position > 0 &&
//                adapter.getItemViewType(position) !=
//                adapter.getItemViewType(position - 1)
//            ) {
//                outRect.top = space
//            }
//        }
//    }
//}



