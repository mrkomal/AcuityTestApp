package com.example.acuitytestapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.acuitytestapp.R
import kotlinx.android.synthetic.main.fragment_info1.*
import kotlinx.android.synthetic.main.fragment_mode_choice.*

class InfoFragment1 : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_info1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonStartTest.setOnClickListener{view ->
            view.findNavController().navigate(R.id.action_infoFragment1_to_literkowoFragment)}
    }

}