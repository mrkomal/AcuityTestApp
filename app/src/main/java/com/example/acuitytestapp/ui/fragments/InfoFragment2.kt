package com.example.acuitytestapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.acuitytestapp.R
import kotlinx.android.synthetic.main.fragment_info1.*
import kotlinx.android.synthetic.main.fragment_info2.*

class InfoFragment2: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_info2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonStartTest2.setOnClickListener{view ->
            val action = InfoFragment2Directions.actionInfoFragment2ToLiterkowoFragment(2)
            Navigation.findNavController(requireView()).navigate(action)
        }
    }
}