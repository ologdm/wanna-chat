package com.example.chatapp.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.chatapp.databinding.FragmentDetailBinding
import com.example.chatapp.domain.ChatItem
import com.example.chatapp.utils.statesFlow
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class DetailFragment : Fragment() {

    companion object {
        const val ITEM_KEY = "id_key"

        fun create(chatItem: ChatItem): DetailFragment {
            val detailFragment = DetailFragment()
            val bundle = Bundle()
            bundle.putParcelable(ITEM_KEY, chatItem)
            detailFragment.arguments = bundle
            return detailFragment
        }
    }


    private var binding: FragmentDetailBinding? = null
    private val adapter = DetailAdapter()

    private var chatItem: ChatItem? = null

    private val viewModel by viewModels<DetailViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding?.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val bundle = arguments
        if (bundle != null) {
            chatItem = bundle.getParcelable(ITEM_KEY)
        }

        binding?.run {
            recyclerView.adapter = adapter
            recyclerView.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, true)

            buttonBack.setOnClickListener {
                requireActivity().onBackPressed()
            }

            Glide.with(requireContext())
                .load(chatItem?.avatarUrl)
                .into(avatarImage)

            userName.text = chatItem?.userName
        }


        viewModel.state.observe(viewLifecycleOwner, Observer { stateContainer ->

            adapter.updateList(stateContainer.items)

            stateContainer.statesFlow(
                binding!!.progressBar,
                binding!!.errorScreen.errorText,
                binding!!.errorScreen.retryButton
            )
        })

        binding?.errorScreen?.retryButton?.setOnClickListener {
            viewModel.loadConversationMessages()
        }


        viewModel.loadConversationMessages()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}