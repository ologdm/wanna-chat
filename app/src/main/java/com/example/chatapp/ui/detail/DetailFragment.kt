package com.example.chatapp.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.chatapp.databinding.FragmentDetailBinding
import com.example.chatapp.domain.ChatItem
import com.example.chatapp.ui.chats.ChatsVModel

class DetailFragment : Fragment() {

    private var binding: FragmentDetailBinding? = null
    val viewModel by viewModels<DetailVModel>()
    private val adapter = DetailAdapter() // TODO check

    // TODO lateinit check
    private var chatItem: ChatItem? = null


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
        chatItem
        if (bundle != null) {
            chatItem = bundle.getParcelable(ITEM_KEY)  // TODO check
        }


        // TODO check null
        binding?.run {
            recyclerView.adapter = adapter
            recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, true)

            buttonBack.setOnClickListener {
                requireActivity().onBackPressed()
            }

            Glide.with(requireContext())
                .load(chatItem?.avatarUrl)
                .into(avatarImage)

            userName.text = chatItem?.userName
        }

        // OK
        viewModel.itemList.observe(viewLifecycleOwner, Observer {
            adapter.updateList(it)
//            val list = it
//            println("XXX DETAILS LIST UPDATE")

        })


        viewModel.loadConversationMessages()
    }
}