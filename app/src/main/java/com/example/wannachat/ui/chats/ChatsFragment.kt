package com.example.wannachat.ui.chats

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wannachat.databinding.FragmentChatsBinding
import com.example.wannachat.ui.Navigator
import com.example.wannachat.utils.statesFlow
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class ChatsFragment : Fragment() {

    private var binding: FragmentChatsBinding? = null

    @Inject
    lateinit var navigator: Navigator

    private val adapter = ChatsAdapter(
        onClick = { chatItem ->
            navigator.startDetailFragment(chatItem)
        })


    private val viewModel by viewModels<ChatsViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentChatsBinding.inflate(inflater, container, false)
        return binding?.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


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


        //lifecycleScope, non usare, lifecycle del fragment
        // !! lo scope e del fragment view quindi vinene resettato ad ogni aggiornamento,
        // es giro schermo, (config. change)
//        viewLifecycleOwner.lifecycleScope.launch {
//            val stateConteint = viewModel.loadUserConversations2()
//            adapter.submitList(stateConteint.items)
//        }  // non usare per chiamate internet , operazioni con latenza in generale
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
        // viewLifecycleOwner.lifecycleScope.cancel()  -fa quesnto alla chiusura
    }

}


