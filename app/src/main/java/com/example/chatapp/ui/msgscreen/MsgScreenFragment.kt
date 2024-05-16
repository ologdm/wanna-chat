package com.example.chatapp.ui.msgscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chatapp.databinding.FragmentMsgScreenBinding
import com.example.chatapp.domain.ChatItem
import com.example.chatapp.ui.chatscreen.ChatScreenVModel

class MsgScreenFragment : Fragment() {

    // TODO val chatItem: ChatItem

    private var binding: FragmentMsgScreenBinding? = null
    private val adapter = MsgScreenAdapter()
    val viewModel by viewModels<ChatScreenVModel>()


    companion object {
        fun create(chatItem: ChatItem): MsgScreenFragment {
            val detailFragment = MsgScreenFragment()
            //val Bundle.
            // TODO Arguments
            return detailFragment
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMsgScreenBinding.inflate(inflater, container, false)
        return binding?.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        // TODO - getArguments
        val x = arguments

        binding?.run {
            recyclerView.adapter = adapter
            recyclerView.layoutManager = LinearLayoutManager(requireContext())
        }


    }
}