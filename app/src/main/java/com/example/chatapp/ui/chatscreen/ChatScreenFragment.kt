package com.example.chatapp.ui.chatscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chatapp.databinding.FragmentChatScreenBinding
import com.example.chatapp.ui.Navigator
import com.example.chatapp.ui.chatscreen.test.AdapterTest


/* TODO:
// Binding OK
// ListAdapter OK
// VH Binding
// DI - repo, api
// VM - only logic function, observable updates OK
 */


class ChatScreenFragment : Fragment() {

    // ATRIBUTES
    private var binding: FragmentChatScreenBinding? = null
    private val navigator = Navigator()
    private val viewModel by viewModels<ChatScreenVModel>()

    private val adapter = ChatScreenAdapter(
        onClick = { chatItem ->
            navigator.startDetail(requireActivity(), chatItem)
            // TODO startDetail create(chatItem)
        })
//    private val adapter = AdapterTest()


    // FRAGMENT FUNCTIONS
    //create
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        println("XXX CREATE FRAGMENT")
        binding = FragmentChatScreenBinding.inflate(inflater, container, false)
        return binding?.root
    }


    // logic OK
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        binding = FragmentMainscreenBinding.bind(view) // in place of onCreateView

        println("XXX LOGIC FRAGMENT")
        // Observe OK
        viewModel.chatItemList.observe(
            viewLifecycleOwner, Observer {
                adapter.submitList(it)
//                adapter.updateList(it)
                println("XXX FRAGM UPDATE ADAPTER")
            })

        // OK
        // with(binding) - non funziona
        binding?.run {
            // set RV - OK
            recycleView.adapter = adapter
            recycleView.layoutManager = LinearLayoutManager(requireContext())
        }


        // OK
        viewModel.loadUserConversations() // update VModelList
    }

}
