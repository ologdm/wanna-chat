package com.example.chatapp.ui.mainscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment


// TODO:
// binding

// adapter
// - only one vh
// - adapter.submitList(items = List<Pokemon>)  - automatic function of ListAdapter

// DI - repo, api

//  istanza VM - only logic function, observable updates




class MScreenFragment : Fragment() {


    // FRAGMENT FUNCTION
    // create
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }


    // logic
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



    }



}