package com.example.chatapp.ui.mscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chatapp.R
import com.example.chatapp.databinding.FragmentMainscreenBinding
import com.example.chatapp.ui.Navigator


/* TODO:
// binding

// adapter
// - only one vh
// - adapter.submitList(items = List<Pokemon>)  - automatic function of ListAdapter

// DI - repo, api

//  istanza VM - only logic function, observable updates
 */


class MScreenFragment : Fragment() {

    // ATRIBUTES
    private var binding: FragmentMainscreenBinding? = null
    private val navigator = Navigator()
    private val viewModel by viewModels<MScreenVModel>()

    private val adapter = MScreenAdapter(
        onClick = { chatItem ->
            navigator.startDetail(requireActivity(), chatItem)
            // TODO startDetail create(chatItem)
        })


    // FRAGMENT FUNCTIONS
    //create
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        println("XXX CREATE FRAGMENT")
        return FragmentMainscreenBinding.inflate(inflater,container,false).root
    }



    // logic OK
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        binding = FragmentMainscreenBinding.bind(view) // in place of onCreateView

        println("XXX LOGIC FRAGMENT")
        // Observe OK
        viewModel.chatItemList.observe(
            viewLifecycleOwner, Observer {
                adapter.submitList(it) // OK update list
                println("XXX SUBMIT ADAPTER")
            })

        // OK
        binding?.run {
            // set RV - OK
            recycleView.adapter = adapter
            recycleView.layoutManager = LinearLayoutManager(requireContext())

        }

        // OK
        viewModel.loadUserConversations() // update VModelList
    }

}
