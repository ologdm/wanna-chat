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

    private var _binding: FragmentChatsBinding? = null
    private val binding get() = _binding

    @Inject
    lateinit var navigator: Navigator
    private val viewModel by viewModels<ChatsViewModel>()

    private val adapter = ChatsAdapter(
        onClick = { chatItem ->
            navigator.startDetailFragment(chatItem)
        })


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentChatsBinding.inflate(inflater, container, false)
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

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}


