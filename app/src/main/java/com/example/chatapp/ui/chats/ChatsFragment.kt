package com.example.chatapp.ui.chats

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chatapp.databinding.FragmentChatsBinding
import com.example.chatapp.ui.Navigator
import com.example.chatapp.utils.statesFlow


class ChatsFragment : Fragment() {

    private var binding: FragmentChatsBinding? = null
    private val navigator = Navigator()
    private val viewModel by viewModels<ChatsVModel>()

    private val adapter = ChatsAdapter(
        onClick = { chatItem ->
            navigator.startDetail(requireActivity(), chatItem)
        })


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        println("XXX CREATE FRAGMENT")
        binding = FragmentChatsBinding.inflate(inflater, container, false)
        return binding?.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        binding = FragmentMainscreenBinding.bind(view) // in place of onCreateView

        println("XXX LOGIC FRAGMENT")

        viewModel.state.observe(
            viewLifecycleOwner, Observer { stateContainer ->

                adapter.submitList(stateContainer.items)

                stateContainer.statesFlow(
                    binding!!.progressBar,
                    binding!!.errorScreen.errorText,
                    binding!!.errorScreen.retryButton
                )
            })


        binding?.run {
            recycleView.adapter = adapter
            recycleView.layoutManager = LinearLayoutManager(requireContext())
        }

        binding?.errorScreen?.retryButton?.setOnClickListener {
            viewModel.loadUserConversations()
        }


        viewModel.loadUserConversations()
    }


}


